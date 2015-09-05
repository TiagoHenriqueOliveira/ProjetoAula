package model.WashCar;

import java.time.LocalDate;

public class OrdemServico {
	
	private Integer idOrdemServico;
	private LocalDate dataAgendamento;
	private Double valorTotal;
	private Cliente cliente;
	private Carro carro;
	private LocalDate dataAltercacao;
	private LocalDate dataInclusao;
	
	//construtor com atributos
	public OrdemServico(Integer idOrdemServico, LocalDate dataAgendamento,
			Double valorTotal, Cliente cliente, Carro carro, LocalDate dataAltercacao, LocalDate dataInclusao) {
		super();
		this.idOrdemServico = idOrdemServico;
		this.dataAgendamento = dataAgendamento;
		this.valorTotal = valorTotal;
		this.cliente = cliente;
		this.carro = carro;
		this.dataAltercacao = dataAltercacao;
		this.dataInclusao = dataInclusao;
	}

	//gets e sets das variaveis
	public Integer getIdOrdemServico() {
		return idOrdemServico;
	}

	public void setIdOrdemServico(Integer idOrdemServico) {
		this.idOrdemServico = idOrdemServico;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
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