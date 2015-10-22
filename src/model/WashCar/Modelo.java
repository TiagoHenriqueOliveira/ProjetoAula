package model.WashCar;

import java.time.LocalDate;

public class Modelo implements Entidade{
	
	private Integer idModelo;
	private String nome;
	private Marca marca;
	private Boolean foraUso;
	private LocalDate dataAltercacao;
	
	//construtor com atributos
	public Modelo(Integer idModelo) {
		this.idModelo = idModelo;
	}
	
	public Modelo() {
		
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

	public Boolean isForaUso() {
		return foraUso;
	}

	public void setForaUso(Boolean foraUso) {
		this.foraUso = foraUso;
	}
}