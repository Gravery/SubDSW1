<%@ page import="br.ufscar.dc.dsw.dao.PacoteDAO" %>
<%@ page import="br.ufscar.dc.dsw.dao.AgenciaDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="br.ufscar.dc.dsw.domain.Pacote" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página dos Usuários</title>
        <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-light bg-light px-4 justify-content-between">
            <a class="navbar-brand" href="#"> Compra e Venda de Veículos</a><a class="btn btn-outline-primary"
                href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
        </nav>
        <br>
        <div class="container-fluid">
            <h1>Olá, ${sessionScope.usuarioLogado.nome}</h1>
            <br/>
            <br/>
                <jsp:include page="${renderRequest.getContextPath()}//util/ListaCarrosUsuario.jsp" />
                <br><br>
                <jsp:include page="${renderRequest.getContextPath()}//util/ListaPropostasCanceladosUsuario.jsp" />
                <br><br>
                <jsp:include page="${renderRequest.getContextPath()}//util/ListaCarros.jsp" /> 
            <br/>
        </div>
    </body>
</html>