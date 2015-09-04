package model.WashCar;

public class Marca {
	
	private Integer idMarca;
	private String nome;
	
	//construtor com atributos
	public Marca(Integer idMarca, String nome) {
		super();
		this.idMarca = idMarca;
		this.nome = nome;
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
}