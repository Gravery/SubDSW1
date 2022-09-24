<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Página das Lojas</title>
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
	<div class="container">
		<br>
		<h1>Olá, ${sessionScope.usuarioLogado.nome}</h1>
		<br>
		<a class="btn btn-primary btn-lg btn-block"
		href="${pageContext.request.contextPath}/agencia/cadastro">Criar Novo Veículo</a>
		<br><br>
		<jsp:include
			page="${renderRequest.getContextPath()}//util/ListaCarrosLoja.jsp" />
		<br>
	</div>
</body>
</html>