package forms.WashCar;

import exception.WashCar.RegistroExistente;
import model.WashCar.PessoaJuridica;

public interface PessoaJuridicaDAO {

	public PessoaJuridica inserir() throws RegistroExistente;
	
	public PessoaJuridica alterar() throws RegistroExistente;
	
}