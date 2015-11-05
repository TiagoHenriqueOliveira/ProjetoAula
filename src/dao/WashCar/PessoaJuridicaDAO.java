package dao.WashCar;

import java.util.List;

import exception.WashCar.RegistroExistente;
import model.WashCar.PessoaJuridica;

public interface PessoaJuridicaDAO {

	void inserir(PessoaJuridica pessoa) throws RegistroExistente;
	
	void alterar(PessoaJuridica pessoa) throws RegistroExistente;
	
	public PessoaJuridica buscarDocumento(String documento);
	
	List<PessoaJuridica> buscarNome(String nome);
	
}