package dao.WashCar;

import exception.WashCar.RegistroExistente;
import model.WashCar.PessoaFisica;

public interface PessoaFisicaDAO {
	
	public PessoaFisica inserir(PessoaFisica pessoa) throws RegistroExistente;
	
	public PessoaFisica alterar(PessoaFisica pessoa) throws RegistroExistente;
	
	public PessoaFisica buscarNome(String nome) throws RegistroExistente;
	
	public PessoaFisica buscarDocumento(String documento) throws RegistroExistente;
	
}