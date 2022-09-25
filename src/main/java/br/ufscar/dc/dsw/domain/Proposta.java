package br.ufscar.dc.dsw.domain;

import java.sql.Date;

public class Proposta {
    private Long id;
    private Long idUsuario;
    private Long idLoja;
    private Long idCarro;
    private Date dataProposta;
    private Float valor;
    private String pagamento;
    private int statusProposta;

    public Proposta(Long id) {
        this.id = id;
    }

    public Proposta(Long idUsuario, Long idLoja, Long idCarro, Date dataproposta, Float valor, String pagamento, int statusProposta) {
        this.idUsuario = idUsuario;
        this.idLoja = idLoja;
        this.idCarro = idCarro;
        this.dataProposta = dataproposta;
        this.valor = valor;    
        this.pagamento = pagamento;
        this.statusProposta = statusProposta;
    }

    public Proposta(Long id, Long idUsuario, Long idLoja, Long idCarro, Date dataproposta, Float valor, String pagamento, int statusProposta) {
        this(idUsuario, idLoja, idCarro, dataproposta, valor, pagamento, statusProposta);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(Long idLoja) {
        this.idLoja = idLoja;
    }

    public Long getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Long idCarro) {
        this.idCarro = idCarro;
    }

    public Date getDataProposta() {
        return dataProposta;
    }

    public void setDataProposta(Date dataProposta) {
        this.dataProposta = dataProposta;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public int getStatusProposta() {
        return statusProposta;
    }

    public void setStatusProposta(int statusProposta) {
        this.statusProposta = statusProposta;
    }

}
