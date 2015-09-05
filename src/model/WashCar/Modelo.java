package model.WashCar;

import java.time.LocalDate;

public class Modelo {
	
	private Integer idModelo;
	private String nome;
	private Marca marca;
	private LocalDate dataAltercacao;
	private LocalDate dataInclusao;
	
	//construtor com atributos
	public Modelo(Integer idModelo, String nome, Marca marca, LocalDate dataAltercacao, LocalDate dataInclusao) {
		super();
		this.idModelo = idModelo;
		this.nome = nome;
		this.marca = marca;
		this.dataAltercacao = dataAltercacao;
		this.dataInclusao = dataInclusao;
	}
	
	//gets e sets das variaveis
	public Integer getIdModelo() {
		return idModelo;
	}
	public void setIdModelo(Integer idModelo) {
		this.idModelo = idModelo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
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
}