package br.ufscar.dc.dsw.domain;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Carro {
	private Long id;
    private Long idLoja;
    private String CNPJ;
    private String placa;
    private String modelo;
    private String chassi;
    private Integer ano;
    private Float quilometragem;	
    private BigDecimal valor;
    private String descricao;

    public Carro(Long id) {
        this.id = id;
    }

    public Carro(Long idLoja, String CNPJ, String placa, String modelo, String chassi, Integer ano, Float quilometragem, BigDecimal valor) {
        this.idLoja = idLoja;
        this.CNPJ = CNPJ;
        this.placa = placa;
        this.modelo = modelo;
        this.chassi = chassi;
        this.ano = ano;
        this.quilometragem = quilometragem;
        this.valor = valor;
    }

    public Carro(Long id, Long idLoja, String CNPJ, String placa, String modelo, String chassi, Integer ano, Float quilometragem, BigDecimal valor, String descricao) {
        this(idLoja, CNPJ, placa, modelo, chassi, ano, quilometragem, valor);
        this.id = id;
        this.descricao = descricao;
    }

    public Carro(Long idLoja, String CNPJ, String placa, String modelo, String chassi, Integer ano, Float quilometragem, BigDecimal valor, String descricao) {
        this(idLoja, CNPJ, placa, modelo, chassi, ano, quilometragem, valor);
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

	public String getDescricao() {
	    return descricao;
	}

	public void setDescricao(String descricao) {
	    this.descricao = descricao;
	}

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public String getChassi() {
        return chassi;
    }
    
    public void setChassi(String chassi) {
        this.chassi = chassi;
    }
    
    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Float getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Float quilometragem) {
        this.quilometragem = quilometragem;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<String> getFotosImages(String path, String context){
        //List<String> aux = new ArrayList<String>();

        path = path + File.separator + this.id.toString();
        List<String> imageList = new ArrayList<String>();
        File dir = new File(path);
        File[] files = dir.listFiles();
        if (files != null) {
            for (final File imageFile : files) {
                imageList.add(context + File.separator + "images" + File.separator + this.id.toString() + File.separator + imageFile.getName());
            }
        }
        return imageList;
    }

    public Long getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(Long idLoja) {
        this.idLoja = idLoja;
    }
}

