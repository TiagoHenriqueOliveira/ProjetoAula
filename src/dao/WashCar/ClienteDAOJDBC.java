package dao.WashCar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import conexao.ConexaoUtil;
import exception.WashCar.RegistroExistente;
import model.WashCar.Cliente;

public class ClienteDAOJDBC implements ClienteDAO{
	
	private Connection connection;
	private String sql;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ClienteDAOJDBC() {
		connection = ConexaoUtil.openConnection();
	}

	@Override
	public void inserir(Cliente cliente) throws RegistroExistente {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Cliente cliente) throws RegistroExistente {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Cliente cliente) throws RegistroExistente {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente buscarId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> buscarDescricao(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> todos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente pesquisaCNPJ(String cnpj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente pesquisaCPF(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer obterUltimoID(PreparedStatement pstmt, ResultSet rs) throws RegistroExistente {
		try {
			rs = pstmt.executeQuery("select las_insert_id()");
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}