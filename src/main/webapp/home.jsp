<%@ page import="java.io.IOException" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="java.io.File" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="br.ufscar.dc.dsw.dao.PacoteDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compra e Venda de Veículos</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
    <nav class="navbar navbar-light bg-light px-4 justify-content-between">
		<a class="navbar-brand" href="${pageContext.request.contextPath}"> Compra e Venda de Veículos
			</a><a class="btn btn-outline-primary"
			href="login.jsp">Logar</a>
	</nav>
    <%
        String contextPath = request.getContextPath().replace("/", "");
    %>
    <br><br>
    <div class="container justify-content-center p-2">
    <h1>Compra e Venda de Veículos</h1>
    <br>
    <h2>Compre Seu Veículo Desejado</h2>
    <br>
    <jsp:include page="${renderRequest.getContextPath()}/util/ListaCarros.jsp" /> 
    <c:if test="${mensagens.existeErros}">
        <div id="erro">
            <ul>
                <c:forEach var="erro" items="${mensagens.erros}">
                    <li> ${erro} </li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
    </div>
    </body>
</html>