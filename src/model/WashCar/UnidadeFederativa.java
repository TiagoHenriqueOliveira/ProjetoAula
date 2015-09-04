package model.WashCar;

public class UnidadeFederativa {
	
	private Integer idUnidadeFederativa;
	private String nome;
	private Pais pais;
	
	public UnidadeFederativa(Integer idUnidadeFederativa, String nome, Pais pais) {
		super();
		this.idUnidadeFederativa = idUnidadeFederativa;
		this.nome = nome;
		this.pais = pais;
	}
	
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