package model.WashCar;

import java.time.LocalDate;

public class ItemOrdemServico {
	
	private Integer idItemServico;
	private Double valorUnitario;
	private Integer quantidade;
	private String Observacoes;
	private OrdemServico ordemServico;
	private TipoServico tipoServico;
	private LocalDate dataAltercacao;
	private LocalDate dataInclusao;
	
	//construtor com atributos
	public ItemOrdemServico(Integer idItemServico, Double valorUnitario,
			Integer quantidade, String observacoes, OrdemServico ordemServico,
			TipoServico tipoServico, LocalDate dataAltercacao, LocalDate dataInclusao) {
		super();
		this.idItemServico = idItemServico;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
		this.Observacoes = observacoes;
		this.ordemServico = ordemServico;
		this.tipoServico = tipoServico;
		this.dataAltercacao = dataAltercacao;
		this.dataInclusao = dataInclusao;
	}

	//gets e sets das variaveis
	public Integer getIdItemServico() {
		return idItemServico;
	}

	public void setIdItemServico(Integer idItemServico) {
		this.idItemServico = idItemServico;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getObservacoes() {
		return Observacoes;
	}

	public void setObservacoes(String observacoes) {
		Observacoes = observacoes;
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
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