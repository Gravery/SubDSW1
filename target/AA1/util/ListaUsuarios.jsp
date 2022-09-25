<%@ page import="java.io.IOException" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="java.io.File" %>
<%@ page import="br.ufscar.dc.dsw.dao.UsuarioDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="br.ufscar.dc.dsw.domain.Usuario" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String contextPath = request.getContextPath().replace("/", "");
%>
<head>
    <script src="${pageContext.request.contextPath.concat('/js/formEdit.js')}"></script>
    <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
</head>
<body>
    <h2>Usuarios</h2>
    <br/>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Usuario</th>
            <th>Email</th>
            <th>CPF</th>
            <th>Sexo</th>
            <th>Nascimento</th>
            <th>Telefone</th>
            <th>Papel</th>
            <th>Ações</th>
        </tr>
        </thead>
        <c:forEach var="usuario" items="${UsuarioDAO().getAll()}">
            <tr>
                <td>${usuario.id}</td>
                <td>${usuario.nome}</td>
                <td>${usuario.email}</td>
                <td>${usuario.cpf}</td>
                <td>${usuario.sexo}</td>
                <td>${usuario.nascimento}</td>
                <td>${usuario.telefone}</td>
                <td>${usuario.papel}</td>
                <td>
                    <button class="btn btn-primary" onclick='requestUsuarioEdit("<%= contextPath %>", ${usuario.id})'>
                        Editar
                    </button>
                    <button class="btn btn-danger" onclick='requestUsuarioDelete("<%= contextPath %>", ${usuario.id})'>
                        Deletar
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>