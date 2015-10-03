package dao.WashCar;

import java.util.List;

public interface GenericDAO<T> {

	void inserir(T entidade);
	
	void alterar(T entidade);
	
	void excluir(T entidade);
	
	T buscarId(Integer id);
	
	T buscarDescricao(String descricao);
	
	List<T> todos();
	
}