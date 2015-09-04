package model.WashCar;

public class Cidade {
	
	private Integer idCidade;
	private String nome;
	private UnidadeFederativa unidadeFederativa;
	
	public Cidade(Integer idCidade, String nome,
			UnidadeFederativa unidadeFederativa) {
		super();
		this.idCidade = idCidade;
		this.nome = nome;
		this.unidadeFederativa = unidadeFederativa;
	}
	
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