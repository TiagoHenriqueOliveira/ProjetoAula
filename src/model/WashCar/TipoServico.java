package model.WashCar;

import java.time.LocalDate;

public class TipoServico implements Entidade {
	
	private Integer idTipoServico;
	private String nome;
	private Double valor;
	private LocalDate dataAltercacao;
	private Boolean foraUso;
	
	//construtor com atributos
	public TipoServico(Integer idTipoServico) {
		this.idTipoServico = idTipoServico;
	}
	
	public TipoServico(){
		
	}

	//gets e sets das variaveis
	public Integer getIdTipoServico() {
		return idTipoServico;
	}

	public void setIdTipoServico(Integer idTipoServico) {
		this.idTipoServico = idTipoServico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
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