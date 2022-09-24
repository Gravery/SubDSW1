<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Autenticação do Usuário</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-light bg-light px-4 justify-content-between">
		<a class="navbar-brand">Compra e Venda de Veículos</a> 
		<a class="btn btn-outline-primary" href="${pageContext.request.contextPath}">Home</a>
	</nav>
	<br><br>
	<div class="d-flex justify-content-center pt-4">
			<div class="d-inline-flex p-4">
				<img src="images/rotes.png" width="200" height="200">
			</div>
			<div class="col-4">
				<h2>Autenticação do Usuário</h2>
				<form method="post" action="user.jsp">
					<div class="form-group">
						<label for="basic-url">Email</label>
						<div class="input-group mb-3">
							<input class="form-control" type="text" maxlength="128" name="email"
								value="${param.email}" required/>
						</div>
						<label for="basic-url">Senha</label>
						<div class="input-group mb-3">
							<input class="form-control" type="password" name="senha" maxlength="64" required/>
						</div>
						<input type="submit" class="btn btn-primary" name="bOK"
							value="Entrar" />
					</div>
					<br>
				</form>
				<c:if test="${mensagens.existeErros}">
					<c:forEach var="erro" items="${mensagens.erros}">
						<div class="alert alert-danger" role="alert">${erro}</div>
					</c:forEach>
				</c:if>
			</div>
		</div>
</body>
</html>