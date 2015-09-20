package model.WashCar;

import java.time.LocalDate;

public class Usuario {
	
	private Integer idUsuario;
	private String nome;
	private String login;
	private String senha;
	private Empresa empresa;
	private Boolean foraUso;
	private LocalDate dataAltercacao;
	
	public Usuario() {
		
	}

	//gets e sets das variaveis
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public LocalDate getDataAltercacao() {
		return dataAltercacao;
	}

	public void setDataAltercacao(LocalDate dataAltercacao) {
		this.dataAltercacao = dataAltercacao;
	}

	public Boolean isForaUso() {
		return foraUso;
	}

	public void setForaUso(Boolean foraUso) {
		this.foraUso = foraUso;
	}
}