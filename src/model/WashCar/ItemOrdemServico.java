package model.WashCar;

import java.time.LocalDate;

public class ItemOrdemServico implements Entidade {
	
	private Integer idItemServico;
	private Double valorTotalItem;
	private OrdemServico ordemServico;
	private TipoServico tipoServico;
	private LocalDate dataAltercacao;
	
	//construtor com atributos
	public ItemOrdemServico(Integer idItemServico) {
		this.idItemServico = idItemServico;
	}
	
	public ItemOrdemServico() {

	}

	//gets e sets das variaveis
	public Integer getIdItemServico() {
		return idItemServico;
	}

	public void setIdItemServico(Integer idItemServico) {
		this.idItemServico = idItemServico;
	}

	public Double getValorUnitario() {
		return valorTotalItem;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorTotalItem = valorUnitario;
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
}