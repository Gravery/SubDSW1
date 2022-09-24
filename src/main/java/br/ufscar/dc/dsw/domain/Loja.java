package br.ufscar.dc.dsw.domain;

public class Loja {
	private Long id;
    private String CNPJ;
    private String nome;
    private String email;
    private String senha;	
    private String descricao;
    
    public Loja(Long id) {
        this.id = id;
    }

    public Loja(String CNPJ, String nome, String email, String senha, String descricao) {
        this.CNPJ = CNPJ;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.descricao = descricao;
    }

    public Loja(Long id, String CNPJ, String nome, String email, String senha, String descricao) {
        this(CNPJ, nome, email, senha, descricao);
        this.id = id;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


	public String getSenha() {
	    return senha;
	}

	public void setSenha(String senha) {
	    this.senha = senha;
	}

	public String getDescricao() {
	    return descricao;
	}

	public void setDescricao(String descricao) {
	    this.descricao = descricao;
	}

}

