package model.WashCar;

public class Carro {
	
	private Integer idCarro;
	private String nome;
	private String placa;
	private Cliente cliente;
	private Modelo modelo;
	
	//construtor com atributos
	public Carro(Integer idCarro, String nome, String placa, Cliente cliente,
			Modelo modelo) {
		super();
		this.idCarro = idCarro;
		this.nome = nome;
		this.placa = placa;
		this.cliente = cliente;
		this.modelo = modelo;
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
}