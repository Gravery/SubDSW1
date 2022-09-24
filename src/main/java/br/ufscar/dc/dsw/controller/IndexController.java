package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.CarroDAO;
import br.ufscar.dc.dsw.domain.Carro;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Index", urlPatterns = { "/index.jsp" })
public class IndexController extends HttpServlet{
	
private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CarroDAO carroDao = new CarroDAO();
		List<Carro> carros = carroDao.getAll();
		request.setAttribute("carros", carros);

		String URL = "/home.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(URL);
		rd.forward(request, response);
	}

}
