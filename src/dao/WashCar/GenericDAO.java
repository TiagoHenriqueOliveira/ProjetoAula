package dao.WashCar;

import java.util.List;

public interface GenericDAO<T> {

	void inserir(T entidade) throws Exception;
	
	void alterar(T entidade) throws Exception;
	
	void excluir(T entidade) throws Exception;
	
	T buscarId(Integer id);
	
	List<T> buscarDescricao(String nome);
	
	List<T> todos();
	
}