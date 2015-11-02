package dao.WashCar;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoUtil;
import model.WashCar.Carro;
import model.WashCar.Modelo;

public class CarroDAOJDBC implements CarroDAO{
	
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql;

	public CarroDAOJDBC() {
		connection = ConexaoUtil.openConnection();
	}

	@SuppressWarnings("static-access")
	@Override
	public void inserir(Carro carro) throws Exception {
		sql = "insert into tb_carro(nomeCarro, placaCarro, carroForaUso, dataAlteracaoCarro, idModelo) "
				+ "values(?, ?, ?, ?, ?)";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, carro.getNome());
			pstmt.setString(2, carro.getPlaca());
			pstmt.setBoolean(3, carro.isForaUso());
			pstmt.setDate(4, Date.valueOf(carro.getDataAltercacao().now()));
			pstmt.setInt(5, carro.getModelo().getIdModelo());
			pstmt.executeUpdate();
			carro.setIdCarro(obterUltimoID(pstmt, rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public void alterar(Carro carro) throws Exception {
		sql = "update tb_carro "
				+ "set tb_carro.nomeCarro = ?, tb_carro.placaCarro = ?, tb_carro.carroForaUso = ?, tb_carro.dataAlteracaoCarro = ?, tb_carro.idModelo = ? "
				+ "where tb_carro.idCarro = ?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, carro.getNome());
			pstmt.setString(2, carro.getPlaca());
			pstmt.setBoolean(3, carro.isForaUso());
			pstmt.setDate(4, Date.valueOf(carro.getDataAltercacao().now()));
			pstmt.setInt(5, carro.getModelo().getIdModelo());
			pstmt.setInt(6, carro.getIdCarro());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(Carro carro) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public Carro buscarId(Integer id) {
		Carro carro = null;
		sql = "select * from tb_carro "
				+ "inner join tb_modelo "
				+ "on tb_carro.idModelo = tb_modelo.idModelo "
				+ "where tb_carro.idCarro = ?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				carro = new Carro();
				carro.setIdCarro(Integer.valueOf(rs.getInt("idCarro")));
				carro.setNome(rs.getString("nomeCarro"));
				carro.setPlaca(rs.getString("placaCarro"));
				carro.setForaUso(rs.getBoolean("carroForaUso"));
				carro.setDataAltercacao(rs.getDate("dataAlteracaoCarro").toLocalDate());
				carro.setModelo(new Modelo(rs.getInt("idModelo"), rs.getString("nomeModelo")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carro;
	}

	@Override
	public List<Carro> buscarDescricao(String nome) {
		List<Carro> carros = new ArrayList<>();
		sql = "select * from tb_carro "
				+ "inner join tb_modelo "
				+ "on tb_carro.idModelo = tb_modelo.idModelo "
				+ "where tb_carro.nomeCarro like ?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, "%" + nome + "%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Carro carro = new Carro();
				carro.setIdCarro(Integer.valueOf(rs.getInt("idCarro")));
				carro.setNome(rs.getString("nomeCarro"));
				carro.setPlaca(rs.getString("placaCarro"));
				carro.setForaUso(rs.getBoolean("carroForaUso"));
				carro.setDataAltercacao(rs.getDate("dataAlteracaoCarro").toLocalDate());
				carro.setModelo(new Modelo(rs.getInt("idModelo"), rs.getString("nomeModelo")));
				carros.add(carro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carros;
	}

	@Override
	public List<Carro> todos() {
		List<Carro> carros = new ArrayList<>();
		sql = "select * from tb_carro "
				+ "inner join tb_modelo "
				+ "on tb_carro.idModelo = tb_modelo.idModelo";
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Carro carro = new Carro();
				carro.setIdCarro(Integer.valueOf(rs.getInt("idCarro")));
				carro.setNome(rs.getString("nomeCarro"));
				carro.setPlaca(rs.getString("placaCarro"));
				carro.setForaUso(rs.getBoolean("carroForaUso"));
				carro.setDataAltercacao(rs.getDate("dataAlteracaoCarro").toLocalDate());
				carro.setModelo(new Modelo(rs.getInt("idModelo"), rs.getString("nomeModelo")));
				carros.add(carro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carros;
	}

	@Override
	public Carro pesquisaPorPlaca(String placa) {
		Carro carro = null;
		sql = "select * from tb_carro "
				+ "inner join tb_modelo " + "on tb_carro.idModelo = tb_modelo.idModelo "
				+ "where tb_carro.placaCarro = ?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, placa);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				carro = new Carro();
				carro.setIdCarro(Integer.valueOf(rs.getInt("idCarro")));
				carro.setNome(rs.getString("nomeCarro"));
				carro.setPlaca(rs.getString("placaCarro"));
				carro.setForaUso(rs.getBoolean("carroForaUso"));
				carro.setDataAltercacao(rs.getDate("dataAlteracaoCarro").toLocalDate());
				carro.setModelo(new Modelo(rs.getInt("idModelo"), rs.getString("nomeModelo")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carro;
	}

	@Override
	public Integer obterUltimoID(PreparedStatement pstmt, ResultSet rs) throws Exception {
		try {
			rs = pstmt.executeQuery("select last_insert_id()");
			while(rs.next())	{
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}