package dao.WashCar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.WashCar.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario>{
	
	public Usuario login(String login, String senha);
	
	public Integer obterUltimoID(PreparedStatement pstmt, ResultSet rs) throws Exception;
	
}