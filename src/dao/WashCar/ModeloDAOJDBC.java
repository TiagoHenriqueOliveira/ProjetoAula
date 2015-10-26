package dao.WashCar;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoUtil;
import model.WashCar.Marca;
import model.WashCar.Modelo;

public class ModeloDAOJDBC implements ModeloDAO{
	
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql;
	
	public ModeloDAOJDBC() {
		connection = ConexaoUtil.openConnection();
	}

	@SuppressWarnings("static-access")
	@Override
	public void inserir(Modelo modelo) throws Exception {
		sql = "insert into tb_modelo(nomeModelo, dataAlteracaoModelo, idMarca, modeloForaUso) "
				+ "values(?, ?, ?, ?)";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, modelo.getNome());
			pstmt.setDate(2, Date.valueOf(modelo.getDataAltercacao().now()));
			pstmt.setInt(3, modelo.getMarca().getIdMarca());
			pstmt.setBoolean(4, modelo.isForaUso());
			pstmt.executeUpdate();
			modelo.setIdModelo(obterUltimoID(pstmt, rs));
		} catch (SQLException insert) {
			insert.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public void alterar(Modelo modelo) throws Exception {
		sql = "update tb_modelo "
				+ "set tb_modelo.nomeModelo = ?, tb_modelo.dataAlteracaoModelo = ?, tb_modelo.idMarca = ?, tb_modelo.modeloForaUso = ? "
				+ "where tb_modelo.idModelo = ?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, modelo.getNome());
			pstmt.setDate(2, Date.valueOf(modelo.getDataAltercacao().now()));
			pstmt.setInt(3, modelo.getMarca().getIdMarca());
			pstmt.setBoolean(4, modelo.isForaUso());
			pstmt.setInt(5, modelo.getIdModelo());
			pstmt.executeUpdate();			
		} catch (SQLException update) {
			update.printStackTrace();
		}
	}

	@Override
	public void excluir(Modelo modelo) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public Modelo buscarId(Integer id) {
		Modelo modelo = null;
		sql = "select * from tb_modelo "
				+ "inner join tb_marca "
				+ "on tb_modelo.idMarca = tb_marca.idMarca "
				+ "where tb_modelo.idModelo = ?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				modelo = new Modelo();
				modelo.setIdModelo(Integer.valueOf(rs.getInt("idModelo")));
				modelo.setNome(rs.getString("nomeModelo"));
				modelo.setMarca(new Marca(rs.getInt("idMarca"), rs.getString("nomeMarca")));
				modelo.setDataAltercacao(rs.getDate("dataAlteracaoModelo").toLocalDate());
				modelo.setForaUso(rs.getBoolean("ModeloforaUso"));
			}
		} catch (SQLException buscaId) {
			buscaId.printStackTrace();
		}
		return modelo;
	}

	@Override
	public List<Modelo> buscarDescricao(String nome) {
		List<Modelo>	 modelos = new ArrayList<>();
		sql = "select * from tb_modelo "
				+ "inner join tb_marca "
				+ "on tb_modelo.idMarca = tb_marca.idMarca "
				+ "where tb_modelo.nomeModelo like ?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, "%" + nome + "%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Modelo modelo = new Modelo();
				modelo.setIdModelo(Integer.valueOf(rs.getInt("idModelo")));
				modelo.setNome(rs.getString("nomeModelo"));
				modelo.setMarca(new Marca(rs.getInt("idMarca"), rs.getString("nomeMarca")));
				modelo.setDataAltercacao(rs.getDate("dataAlteracaoModelo").toLocalDate());
				modelo.setForaUso(rs.getBoolean("ModeloforaUso"));
				modelos.add(modelo);
			}
		} catch (SQLException buscaNome) {
			buscaNome.printStackTrace();
		}
		return modelos;
	}

	@Override
	public List<Modelo> todos() {
		List<Modelo> modelos = new ArrayList<>();
		sql = "select * from tb_modelo "
				+ "inner join tb_marca "
				+ "on tb_modelo.idMarca = tb_marca.idMarca";
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Modelo modelo = new Modelo();
				modelo.setIdModelo(Integer.valueOf(rs.getInt("idModelo")));
				modelo.setNome(rs.getString("nomeModelo"));
				modelo.setMarca(new Marca(rs.getInt("idMarca"), rs.getString("nomeMarca")));
				modelo.setDataAltercacao(rs.getDate("dataAlteracaoModelo").toLocalDate());
				modelo.setForaUso(rs.getBoolean("ModeloforaUso"));
				modelos.add(modelo);
			}
		} catch (SQLException buscaModelo) {
			buscaModelo.printStackTrace();
		}
		return modelos;
	}

	@Override
	public Integer obterUltimoID(PreparedStatement pstmt, ResultSet rs) throws Exception {
		try {
			rs = pstmt.executeQuery("select last_insert_id()");
			while(rs.next())	{
				return rs.getInt(1);
			}
		} catch (SQLException ultimoID) {
			ultimoID.printStackTrace();
		}
		return null;
	}
}