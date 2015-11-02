package model.WashCar;

import java.time.LocalDate;

public class Carro implements Entidade{
	
	private Integer idCarro;
	private String nome;
	private String placa;
	private Modelo modelo;
	private Boolean foraUso;
	private LocalDate dataAltercacao;
	
	//construtor com atributos
	public Carro(Integer idCarro, String nome, String placa) {
		this.idCarro = idCarro;
		this.nome = nome;
		this.placa = placa;
	}
	
	public Carro() {
		
	}
	
	//gets e sets das variaveis
	public Integer getIdCarro() {
		return idCarro;
	}
	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
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