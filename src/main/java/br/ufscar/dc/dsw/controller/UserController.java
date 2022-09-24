package br.ufscar.dc.dsw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.LojaDAO;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.domain.Loja;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(name = "User", urlPatterns = { "/user.jsp", "/logout.jsp" })
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Erro erros = new Erro();
		if (request.getParameter("bOK") != null) {
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			if (email == null || email.isEmpty()) {
				erros.add("É necessário inserir um email para logar");
			}
			if (senha == null || senha.isEmpty()) {
				erros.add("É necessário inserir uma senha para logar");
			}
			if (!erros.isExisteErros()) {
				UsuarioDAO dao = new UsuarioDAO();
				Usuario usuario = dao.getbyEmail(email);
				LojaDAO daoAgencia = new LojaDAO();
				Loja agencia = daoAgencia.getbyEmail(email);
				if (usuario != null) {
					if (usuario.getSenha().equals(senha)) {
						request.getSession().setAttribute("usuarioLogado", usuario);
						if (usuario.getPapel().equals("ADM")) {
							response.sendRedirect("admin/");
						} else {
							response.sendRedirect("usuario/");
						}
						return;
					} else {
						erros.add("Senha ou email inválidos");
					}
				} else if(agencia != null) {
					if (agencia.getSenha().equals(senha)) {
						request.getSession().setAttribute("usuarioLogado", agencia);
						response.sendRedirect("loja/");
						return;
					} else {
						erros.add("Senha ou email inválidos");
					}
				} else {
					erros.add("Usuário não encontrado");
				}
			}
		}
		request.getSession().invalidate();

		request.setAttribute("mensagens", erros);

		String URL = "/login.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(URL);
		rd.forward(request, response);
	}
}