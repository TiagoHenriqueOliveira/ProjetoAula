package model.WashCar;

public class Pais implements Entidade {
	
	private Integer idPais;
	private String nome;
	
	//construtor com atributos
	public Pais(Integer idPais, String nome) {
		this.idPais = idPais;
		this.nome = nome;
	}
	
	public Pais() {
		
	}
		
	//gets e sets das variaveis
	public Integer getIdPais() {
		return idPais;
	}
	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
}