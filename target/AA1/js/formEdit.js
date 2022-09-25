function requestUsuarioEdit(context, usuario) {
    window.location.assign("/" + context + "/admin/edicao?tipo=usuario&id=" + usuario);
}

function requestUsuarioDelete(context, usuario) {
    window.location.assign("/" + context + "/admin/deletar?tipo=usuario&id=" + usuario);
}

function requestLojaEdit(context, loja) {
    window.location.assign("/" + context + "/admin/edicao?tipo=loja&id=" + loja);
}

function requestLojaDelete(context, loja) {
    window.location.assign("/" + context + "/admin/deletar?tipo=loja&id=" + loja);
}

function requestRemoveCarroUsuario(context, idCarro) {
    window.location.assign("/" + context + "/usuario/deletar?id=" + idCarro);
}

function requestCarroDelete(context, idCarro) {
    window.location.assign("/" + context + "/loja/deletar?id=" + idCarro);
}

function requestCarroEdit(context, idCarro) {
    window.location.assign("/" + context + "/loja/edicao?id=" + idCarro);
}

function requestLojaAccept(context, idCarro) {
    window.location.assign("/" + context + "/loja/aceitar?id=" + idCarro);
}

function requestLojaRefuse(context, idCarro) {
    window.location.assign("/" + context + "/loja/recusar?id=" + idCarro);
}