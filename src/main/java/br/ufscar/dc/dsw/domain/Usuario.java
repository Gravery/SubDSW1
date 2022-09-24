package br.ufscar.dc.dsw.domain;

import java.sql.Date;

public class Usuario {

	private Long id;
	private String nome;
	private String email;
	private final String cpf;
	private String sexo;
	private Date nascimento;
	private String telefone;
	private String senha;
	private String papel;

	public Usuario(Long id) {
		this.id = id;
		this.cpf = "";
	}

	public Usuario(Long id, String cpf) {
		this.cpf = cpf;
		this.id = id;
	}

	public Usuario(String nome, String email, String cpf, String sexo, Date nascimento, String telefone, String senha, String papel) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.sexo = sexo;
		this.nascimento = nascimento;
		this.telefone = telefone;
		this.senha = senha;
		this.papel = papel;
	}
	
	public Usuario(Long id, String nome, String email, String cpf, String sexo, Date nascimento, String telefone, String senha, String papel) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.sexo = sexo;
		this.nascimento = nascimento;
		this.telefone = telefone;
		this.senha = senha;
		this.papel = papel;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSenha() {
		return senha;
	}

	public void setSenha(String password) {
		this.senha = password;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}


	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "id:" + id.toString() + " telefone:" + telefone.toString();
	}
}
