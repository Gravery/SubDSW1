package br.ufscar.dc.dsw.domain;

import java.sql.Date;

public class Proposta {
    private Long id;
    private Long idUsuario;
    private Long idCarro;
    private Date dataProposta;
    private Float valor;
    private int statusProposta;

    public Proposta(Long id) {
        this.id = id;
    }

    public Proposta(Long idUsuario, Long idCarro, Date dataproposta, Float valor, int statusProposta) {
        this.idUsuario = idUsuario;
        this.idCarro = idCarro;
        this.dataProposta = dataproposta;
        this.valor = valor;    
        this.statusProposta = statusProposta;
    }

    public Proposta(Long id, Long idUsuario, Long idCarro, Date dataproposta, Float valor, int statusProposta) {
        this(idUsuario, idCarro, dataproposta, valor, statusProposta);
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

    public int getStatusProposta() {
        return statusProposta;
    }

    public void setStatusProposta(int statusProposta) {
        this.statusProposta = statusProposta;
    }

}
