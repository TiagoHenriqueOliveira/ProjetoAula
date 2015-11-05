package dao.WashCar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.WashCar.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente> {
	
	public Cliente pesquisaCNPJ(String cnpj);
	
	public Cliente pesquisaCPF(String cpf);
	
	public Integer obterUltimoID(PreparedStatement pstmt, ResultSet rs) throws Exception;
	
}