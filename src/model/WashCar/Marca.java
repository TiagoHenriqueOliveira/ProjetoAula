package model.WashCar;

import java.time.LocalDate;

public class Marca {
	
	private Integer idMarca;
	private String nome;
	private LocalDate dataAltercacao;
	private LocalDate dataInclusao;
	
	//construtor com atributos
	public Marca(Integer idMarca, String nome, LocalDate dataAltercacao, LocalDate dataInclusao) {
		super();
		this.idMarca = idMarca;
		this.nome = nome;
		this.dataAltercacao = dataAltercacao;
		this.dataInclusao = dataInclusao;
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

	public LocalDate getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(LocalDate dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
}