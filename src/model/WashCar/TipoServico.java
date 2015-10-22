package model.WashCar;

import java.time.LocalDate;

public class TipoServico implements Entidade {
	
	private Integer idTipoServico;
	private String nome;
	private Double valor;
	private LocalDate dataAltercacao;
	private LocalDate dataInclusao;
	
	//construtor com atributos
	public TipoServico(Integer idTipoServico, String nome, Double valor, LocalDate dataAltercacao, LocalDate dataInclusao) {
		super();
		this.idTipoServico = idTipoServico;
		this.nome = nome;
		this.valor = valor;
		this.dataAltercacao = dataAltercacao;
		this.dataInclusao = dataInclusao;
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

	public LocalDate getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(LocalDate dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
}