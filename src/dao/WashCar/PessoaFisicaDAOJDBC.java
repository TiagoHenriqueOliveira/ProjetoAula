package dao.WashCar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoUtil;
import exception.WashCar.RegistroExistente;
import model.WashCar.PessoaFisica;

public class PessoaFisicaDAOJDBC implements PessoaFisicaDAO{
	
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String query;
	
	public PessoaFisicaDAOJDBC() {
		connection = ConexaoUtil.openConnection();
	}

	@Override
	public void inserir(PessoaFisica pessoa) throws RegistroExistente {
		query = "insert into tb_pessoaFisica values(nomeCliente, cpfCliente, rgCliente, idCliente)";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, pessoa.getNome());
			pstmt.setString(2, pessoa.getCpf());
			pstmt.setString(3, pessoa.getRg());
			pstmt.setInt(4, pessoa.getIdCliente());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RegistroExistente(e.getMessage());
		}
	}

	@Override
	public void alterar(PessoaFisica pessoa) throws RegistroExistente {
		query = "update tb_pessoaFisica "
				+ "set tb_pessoaFisica.nomeCliente = ?, tb_pessoaFisica.cpfCliente = ?, "
				+ "tb_pessoaFisica.rgCliente = ? "
				+ "where tb_pessoaFisica.idCliente = ?";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, pessoa.getNome());
			pstmt.setString(2, pessoa.getCpf());
			pstmt.setString(3, pessoa.getRg());
			pstmt.setInt(4, pessoa.getIdCliente());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RegistroExistente(e.getMessage());
		}
	}

	@Override
	public List<PessoaFisica> buscarNome(String nome) {
		List<PessoaFisica> pessoas = new ArrayList<>();
		query = "select * from tb_pessoaFisica "
				+ "inner join tb_cliente "
				+ "on tb_pessoaFisica.IdCliente = tb_cliente.idCliente "
				+ "where tb_pessoaFisica like ? "
				+ "order by tb_pessoaFisica.nomeCliente";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, "%" + nome + "%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PessoaFisica pessoa = new PessoaFisica();
				pessoa.setNome(rs.getString("nomeCliente"));
				pessoa.setCpf(rs.getString("cpfCliente"));
				pessoa.setRg(rs.getString("rgCliente"));
				pessoas.add(pessoa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pessoas;
	}

	@Override
	public PessoaFisica buscarDocumento(String documento) {
		PessoaFisica pessoa = null;
		query = "select * from tb_pessoaFisica "
				+ "inner join tb_cliente "
				+ "on tb_pessoaFisica.IdCliente = tb_cliente.idCliente "
				+ "order by tb_pessoaFisica.nomeCliente";
		try {
			pstmt = connection.prepareStatement(documento);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pessoa = new PessoaFisica();
				pessoa.setNome(rs.getString("nomeCliente"));
				pessoa.setCpf(rs.getString("cpfCliente"));
				pessoa.setRg(rs.getString("rgCliente"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pessoa;
	}
}