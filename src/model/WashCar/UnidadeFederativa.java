package model.WashCar;

public class UnidadeFederativa implements Entidade{
	
	private Integer idUnidadeFederativa;
	private String nome;
	private Pais pais;
	
	//construtor com atributos
	public UnidadeFederativa(Integer idUnidadeFederativa, String nome) {
		this.idUnidadeFederativa = idUnidadeFederativa;
		this.nome = nome;
	}
	
	public UnidadeFederativa() {
		
	}
	
	//gets e sets das variaveis
	public Integer getIdUnidadeFederativa() {
		return idUnidadeFederativa;
	}
	public void setIdUnidadeFederativa(Integer idUnidadeFederativa) {
		this.idUnidadeFederativa = idUnidadeFederativa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}	
}