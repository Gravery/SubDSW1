<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.ufscar.dc.dsw.dao.LojaDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="br.ufscar.dc.dsw.domain.Loja" %>

<head>
	<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
</head>
<body>
<div class="container d-flex flex-column w-50 p-2">
	<c:choose>
		<c:when test="${carro != null}">
			<h2>Edição</h2>
		</c:when>
		<c:otherwise>
			<h2>Cadastro</h2>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${carro != null}">
			<input type="hidden" name="id" value="${carro.id}" />
			<input type="hidden" name="idLoja" value="${carro.idLoja}">
			<input type="hidden" name="cnpj" value="${carro.CNPJ}">
		</c:when>
		<c:otherwise>
			<input type="hidden" name="idLoja" value="${sessionScope.usuarioLogado.id}">
			<input type="hidden" name="cnpj" value="${LojaDAO().getbyID(sessionScope.usuarioLogado.id).CNPJ}">
		</c:otherwise>
	</c:choose>
<%--	private String modelo;--%>
<%--	private int ano;--%>
<%--	private BigDecimal valor;--%>
<%--	private String descricao;--%>

	<label class="p-2 mt-2" for="placa">Placa</label>
	<input class="p-1" type="text" id="placa" name="placa" maxlength="256" value="${carro.placa}" required>

	<label class="p-2 mt-2" for="modelo">Modelo</label>
	<input class="p-1" type="text" id="modelo" name="modelo" maxlength="256" value="${carro.modelo}" required>

	<label class="p-2 mt-2" for="chassi">Chassi</label>
	<input class="p-1" type="text" id="chassi" name="chassi" maxlength="256" value="${carro.chassi}" required>

	<label class="p-2 mt-2" for="ano">Ano</label>
	<input class="p-1" type="number" id="ano" name="ano" value="${carro.ano}" required>

	<label class="p-2 mt-2" for="quilometragem">Quilometragem</label>
	<input class="p-1" type="number" id="quilometragem" min="0" max="1000000000" name="quilometragem" value="${carro.quilometragem}" required>

	<label class="p-2 mt-2" for="valor">Valor</label>
	<input class="p-1" type="number" id="valor" min="0" max="1000000000" name="valor" value="${carro.valor}" required>

	<label class="p-2 mt-2" for="descricao">Descrição (máximo de 256 caracteres)</label>
	<textarea class="p-1" id="descricao" name="descricao" maxlength="256" placeholder="Coloque uma descrição para o carro.">${carro.descricao}</textarea>

	<input class="mt-4 btn btn-primary" type="submit" value="Salvar Dados" />
</div>
</body>