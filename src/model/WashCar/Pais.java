package model.WashCar;

public class Pais {
	
	private Integer idPais;
	private String nome;
	
	//construtor com atributos
	public Pais(Integer idPais) {
		this.idPais = idPais;
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