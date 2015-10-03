package dao.WashCar;

import model.WashCar.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario>{
	
	public Usuario login(String login, String senha);
	
}