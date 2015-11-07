package dao.WashCar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoUtil;
import exception.WashCar.RegistroExistente;
import model.WashCar.PessoaJuridica;

public class PessoaJuridicaDAOJDBC implements PessoaJuridicaDAO{
	
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String query;
	
	public PessoaJuridicaDAOJDBC() {
		connection = ConexaoUtil.openConnection();
	}

	@Override
	public void inserir(PessoaJuridica pessoa) throws RegistroExistente {
		query = "insert into tb_pessoaJuridica "
				+ "values(razaoSocialCliente, nomeFantasiaCliente, cnpjCliente, inscricaoEstadualCliente, inscricaoMunicipalCliente, idCliente)";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, pessoa.getRazaoSocial());
			pstmt.setString(2, pessoa.getNomeFantasia());
			pstmt.setString(3, pessoa.getCnpj());
			pstmt.setString(4, pessoa.getInscricaoEstadual());
			pstmt.setString(5, pessoa.getInscricaoMunicipal());
			pstmt.setInt(6, pessoa.getIdCliente());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RegistroExistente(e.getMessage());
		}
	}

	@Override
	public void alterar(PessoaJuridica pessoa) throws RegistroExistente {
		query = "update tb_pessoaJuridica "
				+ "set tb_pessoaJuridica.razaoSocialCliente = ?, tb_pessoaJuridica.nomeFantasiaCliente = ?, "
				+ "tb_pessoaJuridica.cnpjCliente = ?, tb_pessoaJuridica.inscricaoEstadualCliente = ? "
				+ "tb_pessoaJuridica.inscricaoMunicipalCliente = ? "
				+ "where tb_pessoaJuridica.idCliente = ?";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, pessoa.getRazaoSocial());
			pstmt.setString(2, pessoa.getNomeFantasia());
			pstmt.setString(3, pessoa.getCnpj());
			pstmt.setString(4, pessoa.getInscricaoEstadual());
			pstmt.setString(5, pessoa.getInscricaoMunicipal());
			pstmt.setInt(6, pessoa.getIdCliente());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RegistroExistente(e.getMessage());
		}		
	}

	@Override
	public PessoaJuridica buscarDocumento(String documento) {
		PessoaJuridica pessoa = null;
		query = "select * from tb_pessoaJuridica "
				+ "inner join tb_Cliente "
				+ "on tb_pessoaJuridica.idCliente = tb_Cliente.idCliente "
				+ "where tb_pessoaJuridica.cnpjCliente = ? "
				+ "order by tb_pessoaJuridica.nomeFantasia";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, documento);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pessoa = new PessoaJuridica();
				pessoa.setRazaoSocial(rs.getString("razaoSocialCliente"));
				pessoa.setNomeFantasia(rs.getString("nomeFantasiaCliente"));
				pessoa.setCnpj(rs.getString("cnpjCliente"));
				pessoa.setInscricaoEstadual(rs.getString("inscricaoEstadualCliente"));
				pessoa.setInscricaoMunicipal(rs.getString("inscricaoMunicipalCliente"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pessoa;
	}

	@Override
	public List<PessoaJuridica> buscarNome(String nome) {
		List<PessoaJuridica> pessoas = new ArrayList<>();
		query = "select * from tb_pessoaJuridica "
				+ "inner join tb_Cliente "
				+ "on tb_pessoaJuridica.idCliente = tb_Cliente.idCliente "
				+ "where tb_pessoaJuridica.nomeFantasiaCliente like ? "
				+ "order by tb_pessoaJuridica.nomeFantasia";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, "%" + nome + "%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PessoaJuridica pessoa = new PessoaJuridica();
				pessoa.setRazaoSocial(rs.getString("razaoSocialCliente"));
				pessoa.setNomeFantasia(rs.getString("nomeFantasiaCliente"));
				pessoa.setCnpj(rs.getString("cnpjCliente"));
				pessoa.setInscricaoEstadual(rs.getString("inscricaoEstadualCliente"));
				pessoa.setInscricaoMunicipal(rs.getString("inscricaoMunicipalCliente"));
				pessoas.add(pessoa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pessoas;
	}
}