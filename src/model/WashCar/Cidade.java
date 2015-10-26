package model.WashCar;

public class Cidade implements Entidade{
	
	private Integer idCidade;
	private String nome;
	private UnidadeFederativa unidadeFederativa;
	
	//construtor com atributos
	public Cidade(Integer idCidade, String nome) {
		this.idCidade = idCidade;
		this.nome = nome;
	}
	
	public Cidade() {
		
	}
	
	//gets e sets das variaveis
	public Integer getIdCidade() {
		return idCidade;
	}
	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public UnidadeFederativa getUnidadeFederativa() {
		return unidadeFederativa;
	}
	public void setUnidadeFederativa(UnidadeFederativa unidadeFederativa) {
		this.unidadeFederativa = unidadeFederativa;
	}	
}