package model.WashCar;

public class TipoServico {
	
	private Integer idTipoServico;
	private String nome;
	private Double valor;
	
	//construtor com atributos
	public TipoServico(Integer idTipoServico, String nome, Double valor) {
		super();
		this.idTipoServico = idTipoServico;
		this.nome = nome;
		this.valor = valor;
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
}