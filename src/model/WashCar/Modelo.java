package model.WashCar;

public class Modelo {
	
	private Integer idModelo;
	private String nome;
	private Marca marca;
	
	//construtor com atributos
	public Modelo(Integer idModelo, String nome, Marca marca) {
		super();
		this.idModelo = idModelo;
		this.nome = nome;
		this.marca = marca;
	}
	
	//gets e sets das variaveis
	public Integer getIdModelo() {
		return idModelo;
	}
	public void setIdModelo(Integer idModelo) {
		this.idModelo = idModelo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
}