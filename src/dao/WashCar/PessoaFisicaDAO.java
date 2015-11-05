package dao.WashCar;

import java.util.List;

import exception.WashCar.RegistroExistente;
import model.WashCar.PessoaFisica;

public interface PessoaFisicaDAO {
	
	void inserir(PessoaFisica pessoa) throws RegistroExistente;
	
	void alterar(PessoaFisica pessoa) throws RegistroExistente;
	
	List<PessoaFisica> buscarNome(String nome);
	
	public PessoaFisica buscarDocumento(String documento);
	
}