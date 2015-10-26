package dao.WashCar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import conexao.ConexaoUtil;
import model.WashCar.Cidade;
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
		sql = "select * from tb_cidade "
				+ "inner join tb_UF "
				+ "on tb_cidade.idUF = tb_UF.idUF "
				+ "inner join tb_pais "
				+ "on tb_UF.idPais = tb_pais.idPais "
				+ "where tb_cidade.nomeCidade like ?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, "%" + descricao + "%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Cidade cidade = new Cidade();
				cidade.setIdCidade(rs.getInt("idCidade"));
				cidade.setNome(rs.getString("nomeCidade"));
				cidade.setUnidadeFederativa(new UnidadeFederativa(rs.getInt("idUF"), rs.getString("nomeUF")));
				cidades.add(cidade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cidades;
	}

	@Override
	public List<Cidade> todos() {
		List<Cidade> cidades = new ArrayList<>();
		sql = "select * from tb_cidade "
				+ "inner join tb_UF "
				+ "on tb_cidade.idUF = tb_UF.idUF "
				+ "inner join tb_pais "
				+ "on tb_UF.idPais = tb_pais.idPais";
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Cidade cidade = new Cidade();
				cidade.setIdCidade(rs.getInt("idCidade"));
				cidade.setNome(rs.getString("nomeCidade"));
				cidade.setUnidadeFederativa(new UnidadeFederativa(rs.getInt("idUF"), rs.getString("nomeUF")));
				cidades.add(cidade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cidades;
	}

}