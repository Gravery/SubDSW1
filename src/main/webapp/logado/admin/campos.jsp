<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
</head>
<body>
	<div class="container w-50 p-3">
		<c:choose>
			<c:when test="${usuario != null}">
				<h2>Edição</h2>
			</c:when>
			<c:otherwise>
				<h2>Cadastro</h2>
			</c:otherwise>
		</c:choose>
		<c:if test="${usuario != null}">
			<input type="hidden" name="id" value="${usuario.id}" />
		</c:if>
		<div class="form-group">
			 <label for="nome">Nome</label> <input class="form-control"
				type="text" id="nome" name="nome" maxlength="256" required
				value="${usuario.nome}" />
		</div>
		<br>
		<div class="form-group">
			<label for="email">Email</label> <input class="form-control"
				type="email" id="email" name="email" required maxlength="128"
				value="${usuario.email}" />
		</div>
		<br>
		<div class="form-group">
			<label for="cpf">CPF (sem pontos ou traços)</label>
			<c:choose>
				<c:when test="${usuario == null}">
					<input class="form-control" type="tel" id="cpf" name="cpf"
						maxlength="11" minlength="11" required value="${usuario.cpf}" />
				</c:when>
				<c:otherwise>
					<input type="text" class="form-control" id="cpf" name="cpf"
						size="11" required value="${usuario.cpf}" readonly="true"
						class='disabled' />
				</c:otherwise>
			</c:choose>
		</div>
		<br>
		<div class="form-group">
			<label for="sexo">Sexo</label> <select class="form-control" id="sexo"
				name="sexo">
				<option value="F">Feminino</option>
				<option value="M">Masculino</option>
				<option value="O">Outro</option>
			</select>
		</div>
		<br>
		<div class="form-group">
			<label for="nascimento">Data de Nascimento</label> <input
				class="form-control" type="date" id="nascimento" name="nascimento"
				required min="1500" value="${usuario.nascimento}" />
		</div>
		<br>
		<div class="form-group">
			<label for="telefone">Telefone</label> <input class="form-control"
				type="tel" id="telefone" name="telefone" minlength="8" required
				value="${usuario.telefone}" maxlength="11" />
		</div>
		<br>
		<div class="form-group">
			<label for="senha">Senha</label> <input class="form-control"
				type="password" id="senha" name="senha" required maxlength="64"
				value="${usuario.senha}" />
		</div>
		<br>
		<div class="form-group">
			<label for="papel">Papel</label> <select class="form-control"
				id="papel" name="papel">
				<option value="USR">Cliente</option>
				<option value="ADM">Administrador</option>
			</select>
		</div>
		<br> <input class="btn btn-primary" type="submit"
			value="Salvar Dados" />
	</div>
</body>