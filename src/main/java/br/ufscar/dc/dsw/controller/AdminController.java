package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

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

@WebServlet(urlPatterns = "/admin/*")
public class AdminController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UsuarioDAO usuarioDAO;
	private LojaDAO lojaDAO;

	@Override
	public void init() {
		usuarioDAO = new UsuarioDAO();
		lojaDAO = new LojaDAO();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo();

		if (action == null) {
			action = "";
		}

		try {
			switch (action) {
			case "/cadastro":
				apresentaFormCadastro(request, response);
				break;
			case "/insercao":
				insere(request, response);
				break;
			case "/edicao":
				apresentaFormEdicao(request, response);
				break;
			case "/atualiza":
				atualiza(request, response);
				break;
			case "/deletar":
				deletar(request, response);
				break;
			default:
				home(request, response);
				break;
			}
		}

		catch (Exception e) {
			Erro erros = new Erro();
			erros.add(e.getMessage());
			request.setAttribute("mensagens", erros);
			RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
			rd.forward(request, response);
		}
	}

	private Boolean isAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
			if (usuario != null) {
				return usuario.getPapel().equals("ADM");
			} else {
				return false;
			}
		} catch (Exception e) {
			Erro erros = new Erro();
			erros.add("Acesso não autorizado!");
			request.setAttribute("mensagens", erros);
			RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
			rd.forward(request, response);
		}

		return false;
	}

	private void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (isAdmin(request, response)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/user.jsp");
			dispatcher.forward(request, response);
		} else {
			acessoNegado(request, response);
		}

	}

	private void acessoNegado(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Erro erros = new Erro();
		erros.add("Acesso não autorizado!");
		request.setAttribute("mensagens", erros);
		RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
		rd.forward(request, response);
	}

	private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (isAdmin(request, response)) {
			String tipo = request.getParameter("tipo").toString();
			if (tipo.equals("usuario")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/formulario.jsp");
				dispatcher.forward(request, response);
			} else if (tipo.equals("loja")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/formularioloja.jsp");
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect(tipo);
			}
		} else {
			acessoNegado(request, response);
		}

	}

	private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		String tipo = request.getParameter("tipo");
		if (tipo.equals("usuario")) {
			Usuario usuario = usuarioDAO.getbyID(id);
			request.setAttribute("usuario", usuario);
		} else if (tipo.equals("loja")) {
			Loja loja = lojaDAO.getbyID(id);
			request.setAttribute("loja", loja);
		}
		this.apresentaFormCadastro(request, response);
	}

	private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String tipo = request.getParameter("tipo");

		String nome = request.getParameter("nome");

		if (tipo.equals("usuario")) {
			String email = request.getParameter("email");
			String cpf = request.getParameter("cpf");
			String sexo = request.getParameter("sexo");
			Date nascimento = null;
			if (request.getParameter("nascimento") != null) {
				nascimento = Date.valueOf(request.getParameter("nascimento"));
			}
			String telefone = request.getParameter("telefone");
			String senha = request.getParameter("senha");
			String papel = request.getParameter("papel");

			Usuario usuario = new Usuario(nome, email, cpf, sexo, nascimento, telefone, senha, papel);
			usuarioDAO.insert(usuario);
		} else if (tipo.equals("loja")) {
			String email = request.getParameter("email");
			String cnpj = request.getParameter("cnpj");
			String senha = request.getParameter("senha");
			String descricao = request.getParameter("descricao");

			Loja loja = new Loja(cnpj, nome, email, senha, descricao);
			lojaDAO.insert(loja);
		}
		response.sendRedirect("lista");
	}

	private void atualiza(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String tipo = request.getParameter("tipo");
		if (tipo.equals("usuario")) {
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String cpf = request.getParameter("cpf");
			String sexo = request.getParameter("sexo");
			Date nascimento = null;
			if (request.getParameter("nascimento") != null) {
				nascimento = Date.valueOf(request.getParameter("nascimento"));
			}
			String telefone = request.getParameter("telefone");
			String senha = request.getParameter("senha");
			String papel = request.getParameter("papel");
			Long id = Long.parseLong(request.getParameter("id"));

			Usuario usuario = new Usuario(id, nome, email, cpf, sexo, nascimento, telefone, senha, papel);
			usuarioDAO.update(usuario);
		} else if (tipo.equals("loja")) {
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String cnpj = request.getParameter("cnpj");
			String senha = request.getParameter("senha");
			String descricao = request.getParameter("descricao");
			Long id = Long.parseLong(request.getParameter("id"));

			Loja loja = new Loja(id, cnpj, nome, email, senha, descricao);
			lojaDAO.update(loja);
		}
		response.sendRedirect("lista");
	}

	private void deletar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String tipo = request.getParameter("tipo");
		Long id = Long.parseLong(request.getParameter("id"));

		if (tipo.equals("usuario")) {
			Usuario usuario = new Usuario(id);
			usuarioDAO.delete(usuario);
		} else if (tipo.equals("loja")) {
			Loja loja = new Loja(id);
			lojaDAO.delete(loja);
		}
		response.sendRedirect("lista");
	}
}