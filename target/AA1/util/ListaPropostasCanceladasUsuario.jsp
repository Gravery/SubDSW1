<%@ page import="java.io.IOException" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="java.io.File" %>
<%@ page import="br.ufscar.dc.dsw.dao.PropostaDAO" %>
<%@ page import="br.ufscar.dc.dsw.domain.Proposta" %>
<%@ page import="br.ufscar.dc.dsw.dao.CarroDAO" %>
<%@ page import="br.ufscar.dc.dsw.dao.LojaDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="br.ufscar.dc.dsw.domain.Carro" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String contextPath = request.getContextPath().replace("/", "");
%>

<head>
    <script src="${pageContext.request.contextPath.concat('/js/formEdit.js')}"></script>
</head>
<body>
    <c:choose>
        <c:when test="${PropostaDAO().getAllCancelledbyIDUsuario(sessionScope.usuarioLogado.id).size() == '0'}">
            <h2>Você não cancelou nenhuma proposta.</h2>
        </c:when>    
        <c:otherwise>
    <h2>Propostas Canceladas e Não Aceitas</h2>
    <br/>
    <table class="table">
        <thead>
        <tr>
            <th>Carro</th>
            <th>Descrição</th>
            <th>Modelo</th>
            <th>Placa</th>
            <th>Chassi</th>
            <th>Agência</th>
            <th>Ano</th>
            <th>Quilometragem</th>
            <th>Pagamento</th>
            <th>Valor</th>
            <th>Fotos</th>
        </tr>
        </thead>
        <c:forEach var="proposta" items="${PropostaDAO().getAllCancelledbyIDUsuario(sessionScope.usuarioLogado.id)}">
            <tr>
                <td>${CarroDAO().getbyID(proposta.idCarro).id}</td>
                <td>${CarroDAO().getbyID(proposta.idCarro).descricao}</td>
                <td>${CarroDAO().getbyID(proposta.idCarro).modelo}</td>
                <td>${CarroDAO().getbyID(proposta.idCarro).placa}</td>
                <td>${CarroDAO().getbyID(proposta.idCarro).chassi}</td>
                <td>${LojaDAO().getByCNPJ(CarroDAO().getbyID(proposta.idCarro).CNPJ).nome}</td>
                <td>${CarroDAO().getbyID(proposta.idCarro).ano}</td>
                <td>${CarroDAO().getbyID(proposta.idCarro).quilometragem}</td>
                <td>${proposta.pagamento}</td>
                <td>${proposta.valor}</td>
                <td>
                        <c:forEach var="image"
                                items='${CarroDAO().getbyID(proposta.idCarro)
                                         .getFotosImages(pageContext.servletContext.getRealPath("images"),
                                                         pageContext.request.contextPath)}'
                        >
                            <img src="${image}" width="64px">
                        </c:forEach>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
    </c:otherwise>
    </c:choose>
</body>