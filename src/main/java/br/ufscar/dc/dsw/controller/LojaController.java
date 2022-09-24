package br.ufscar.dc.dsw.controller;

import java.io.*;
import java.util.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.io.output.*;

import br.ufscar.dc.dsw.controller.ImageController;
import br.ufscar.dc.dsw.dao.LojaDAO;
import br.ufscar.dc.dsw.dao.CarroDAO;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.domain.Loja;
import br.ufscar.dc.dsw.domain.Carro;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(urlPatterns = "/loja/*")
public class LojaController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CarroDAO pacoteDAO;
	private Carro lastPacote;

	@Override
	public void init() {
		pacoteDAO = new CarroDAO();
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
			case "/addImagem":
				adicionarImagem(request, response);
				break;
			case "/cadastro":
				apresentaFormCadastro(request, response);
				break;
			case "/insercao":
				insercao(request, response);
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
		} catch (Exception e) {
			Erro erros = new Erro();
			erros.add(e.getMessage());
			request.setAttribute("mensagens", erros);
			RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
			rd.forward(request, response);
		}
	}

	private void adicionarImagem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ImageController imageController = new ImageController();

		String contentType = request.getContentType();		
		if ((contentType.indexOf("multipart/form-data") >= 0)) {
			try {
				List fileItems = imageController.GetServletFileItem().parseRequest(request);
				//Loja auxA = (Loja) request.getSession().getAttribute("usuarioLogado");
				ServletContext context = request.getServletContext();
				String location = context.getRealPath("images") + File.separator + lastPacote.getId();

				imageController.SaveFileList(location, fileItems);
			} catch(Exception ex) {
				System.out.println(ex);
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher("/logado/loja/user.jsp");
		rd.forward(request, response);
	}
	
	private void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Erro erros = new Erro();

		try {
			Loja loja = (Loja) request.getSession().getAttribute("usuarioLogado");
			if (loja == null) {
				response.sendRedirect(request.getContextPath());
			} else if (loja.getCNPJ() != null && loja.getCNPJ() != null) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/loja/user.jsp");
				dispatcher.forward(request, response);
			} else {
				erros.add("Acesso não autorizado!");
				request.setAttribute("mensagens", erros);
				RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			erros.add(e.getMessage());
			request.setAttribute("mensagens", erros);
			RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
			rd.forward(request, response);
		}
	}
	
	private void deletar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		Long id = Long.parseLong(request.getParameter("id"));
		pacoteDAO.delete(id);
		response.sendRedirect("lista");
	}
	
	private void atualiza(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Long idloja = Long.valueOf(request.getParameter("idLoja"));
		String cnpjloja = request.getParameter("cnpj");
		String placa = request.getParameter("placa");
		String modelo = request.getParameter("modelo");
		String chassi = request.getParameter("chassi");
		Integer ano = Integer.valueOf(request.getParameter("ano"));
		Float quilometragem = Float.valueOf(request.getParameter("quilometragem"));
		BigDecimal valor = BigDecimal.valueOf(Double.valueOf(request.getParameter("valor")));
		String descricao = request.getParameter("descricao");

		Carro pacote = new Carro(
				id, idloja, cnpjloja, placa,
				modelo, chassi, ano,
				quilometragem, valor, descricao
		);
		lastPacote = pacote;
		pacoteDAO.update(pacote);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/loja/adicionarImagens.jsp");
		dispatcher.forward(request, response);
	}

	private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Carro pacote = pacoteDAO.getbyID(id);
		request.setAttribute("pacote", pacote);
			
		this.apresentaFormCadastro(request, response);
	}
	
	private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/loja/formulario.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insercao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Long idloja = Long.valueOf(request.getParameter("idloja"));
		String cnpjloja = request.getParameter("cnpj");
		String placa = request.getParameter("placa");
		String modelo = request.getParameter("modelo");
		String chassi = request.getParameter("chassi");
		Integer ano = Integer.valueOf(request.getParameter("ano"));
		Float quilometragem = Float.valueOf(request.getParameter("quilometragem"));
		BigDecimal valor = BigDecimal.valueOf(Double.valueOf(request.getParameter("valor")));
		String descricao = request.getParameter("descricao");

		Carro pacote = new Carro(
				idloja, cnpjloja, placa,
				modelo, chassi, ano,
				quilometragem, valor, descricao
		);
		pacoteDAO.insert(pacote);
		response.sendRedirect("lista");
	}

}