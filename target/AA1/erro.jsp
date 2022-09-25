<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Erro :(</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
</head>
<body>
<div class="container">
<br><br>
	<h1>A operação não pôde ser concluída</h1>
	<c:if test="${mensagens.existeErros}">
	<br>
			<c:forEach var="erro" items="${mensagens.erros}">
				<div class="alert alert-danger">
					<h4 class="alert-heading">${erro}</h4>
				</div>
			</c:forEach>
			<a href="${pageContext.request.contextPath}" class="card-link">Ir para Home</a>
	</c:if>
	</div>
</body>
</html>