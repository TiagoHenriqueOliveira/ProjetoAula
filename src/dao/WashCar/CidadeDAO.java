package dao.WashCar;

import java.util.List;

import model.WashCar.Cidade;

public interface CidadeDAO {
	
	public List<Cidade> buscarNomeCidade(String descricao);
	
	public List<Cidade> todos();
	
}