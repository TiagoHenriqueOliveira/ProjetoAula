package model.WashCar;

import java.time.LocalDate;

public class Usuario {
	
	private Integer idUsuario;
	private String nome;
	private String login;
	private String senha;
	private Empresa empresa;
	private boolean foraUso = false;
	private LocalDate dataAltercacao;
	private LocalDate dataInclusao;
	
	//construtor com atributos
	public Usuario(Integer idUsuario, String nome, String login, String senha,
			Empresa empresa, LocalDate dataAltercacao, LocalDate dataInclusao, boolean foraUso) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.empresa = empresa;
		this.dataAltercacao = dataAltercacao;
		this.dataInclusao = dataInclusao;
		this.foraUso = foraUso;
	}
	
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

	public LocalDate getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(LocalDate dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public boolean isForaUso() {
		return foraUso;
	}

	public void setForaUso(boolean foraUso) {
		this.foraUso = foraUso;
	}
}