<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Cadasto de Lojas</title>
</head>

<body>
	<div align="center">
	<br><br>
		<h1>Gerenciamento de Lojas</h1>
		<h2>
			<a href="lista">Lista de Lojas</a>
		</h2>
	</div>
	<br>
	<div align="center">
		<c:choose>
			<c:when test="${loja != null}">
				<form action="atualiza?tipo=loja&id=${loja.id}" method="post">
					<%@include file="camposLoja.jsp"%>
				</form>
			</c:when>
			<c:otherwise>
				<form action="insercao?tipo=loja" method="post">
					<%@include file="camposLoja.jsp"%>
				</form>
			</c:otherwise>
		</c:choose>
	</div>
	<c:if test="${!empty requestScope.mensagens}">
		<ul class="erro">
			<c:forEach items="${requestScope.mensagens}" var="mensagem">
				<li>${mensagem}</li>
			</c:forEach>
		</ul>
	</c:if>
</body>

</html>