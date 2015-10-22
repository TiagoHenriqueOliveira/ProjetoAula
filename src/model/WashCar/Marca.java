package model.WashCar;

import java.time.LocalDate;

import daoFactory.WashCar.DaoFactory;

public class Marca implements Entidade{
	
	private Integer idMarca;
	private String nome;
	private LocalDate dataAltercacao;
	private Boolean foraUso;
	
	//construtor com atributos
	public Marca(Integer idMarca) {
		this.idMarca = idMarca;
	}
	
	public Marca() {
		
	}

	//gets e sets das variaveis
	public Integer getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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