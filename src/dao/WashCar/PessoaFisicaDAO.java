package dao.WashCar;

import exception.WashCar.RegistroExistente;
import model.WashCar.PessoaFisica;

public interface PessoaFisicaDAO {
	
	public PessoaFisica inserir() throws RegistroExistente;
	
	public PessoaFisica alterar() throws RegistroExistente;
	
}