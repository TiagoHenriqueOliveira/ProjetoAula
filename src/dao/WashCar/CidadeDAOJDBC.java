package dao.WashCar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import conexao.ConexaoUtil;
import exception.WashCar.RegistroNotExistente;
import model.WashCar.Cidade;
import model.WashCar.Pais;
import model.WashCar.UnidadeFederativa;

public class CidadeDAOJDBC implements CidadeDAO{
	
	private Connection connection;
	private String sql;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public CidadeDAOJDBC() {
		connection = ConexaoUtil.openConnection();
	}

	@Override
	public List<Cidade> buscarNomeCidade(String descricao) {
		List<Cidade> cidades = new ArrayList<>();
		Cidade cidade = null;
		sql = "select * from tb_cidade "
				+ "inner join tb_UF "
				+ "on tb_cidade.idUF = tb_UF.idUF "
				+ "inner join tb_pais "
				+ "on tb_UF.idPais = tb_pais.idPais "
				+ "where tb_cidade.nomeCidade like ? "
				+ "order by tb_cidade.nomeCidade";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, "%" + descricao + "%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cidade = new Cidade();
				cidade.setIdCidade(rs.getInt("idCidade"));
				cidade.setNome(rs.getString("nomeCidade"));
				cidade.setUnidadeFederativa(new UnidadeFederativa(rs.getInt("idUF"), rs.getString("nomeUF"), 
																		new Pais(rs.getInt("idPais"), rs.getString("nomePais"))));
				cidades.add(cidade);
			}
			if(cidade == null) {
				throw new RegistroNotExistente("N�o foi poss�vel encontrar nenhum registro "
						+ "para o conte�do de busca informado.\n"
						+ "Por gentileza, efetue uma nova pesquisa.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cidades;
	}

	@Override
	public List<Cidade> todos() {
		List<Cidade> cidades = new ArrayList<>();
		Cidade cidade = null;
		sql = "select * from tb_cidade "
				+ "inner join tb_UF "
				+ "on tb_cidade.idUF = tb_UF.idUF "
				+ "inner join tb_pais "
				+ "on tb_UF.idPais = tb_pais.idPais "
				+ "order by tb_cidade.nomeCidade";
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cidade = new Cidade();
				cidade.setIdCidade(rs.getInt("idCidade"));
				cidade.setNome(rs.getString("nomeCidade"));
				cidade.setUnidadeFederativa(new UnidadeFederativa(rs.getInt("idUF"), rs.getString("nomeUF"), 
				new Pais(rs.getInt("idPais"), rs.getString("nomePais"))));
				cidades.add(cidade);
			}
			if(cidade == null) {
				throw new RegistroNotExistente("N�o foi poss�vel encontrar nenhum registro "
						+ "para o conte�do de busca informado.\n"
						+ "Por gentileza, efetue uma nova pesquisa.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cidades;
	}

}