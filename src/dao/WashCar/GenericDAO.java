package dao.WashCar;

import java.util.List;

import exception.WashCar.RegistroExistente;
import exception.WashCar.RegistroNotExistente;

public interface GenericDAO<T> {

	void inserir(T entidade) throws RegistroExistente;
	
	void alterar(T entidade) throws RegistroExistente;
	
	void excluir(T entidade) throws RegistroExistente;
	
	T buscarId(Integer id);
	
	List<T> buscarDescricao(String nome);
	
	List<T> todos();
	
}