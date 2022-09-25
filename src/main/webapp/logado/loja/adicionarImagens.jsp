<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Cadastro de Carros</title>
</head>

<body>
	<div align="center">
	<br><br>
		<h1>Adicionar Imagens</h1>
		<h2>
			<a href="lista">Lista de Carros</a>
		</h2>
	</div>

    <form action="addImg" method="post" enctype="multipart/form-data">
        Enviar imagens desejadas:
        <br/>
        <input type="file" name="fileName">
        <br>
        <input type="submit" value="Enviar">
    </form>

	<c:if test="${!empty requestScope.mensagens}">
		<ul class="erro">
			<c:forEach items="${requestScope.mensagens}" var="mensagem">
				<li>${mensagem}</li>
			</c:forEach>
		</ul>
	</c:if>
</body>

</html>