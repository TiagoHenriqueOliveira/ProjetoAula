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
		sql = "insert into modelo(nome, dataAlteracao, marca, foraUso) "
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
		sql = "update modelo m "
				+ "set m.nome = ?, dataAlteracao = ?, marca = ?, foraUso = ? "
				+ "where m.idModelo = ?";
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
		sql = "select * from modelo m "
				+ "where m.idModelo = ?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				modelo = new Modelo();
				modelo.setIdModelo(Integer.valueOf(rs.getInt("idModelo")));
				modelo.setNome(rs.getString("nome"));
				modelo.setMarca(new Marca(rs.getInt("marca ")));
				modelo.setDataAltercacao(rs.getDate("dataAlteracao").toLocalDate());
				modelo.setForaUso(rs.getBoolean("foraUso"));
			}
		} catch (SQLException buscaId) {
			buscaId.printStackTrace();
		}
		return modelo;
	}

	@Override
	public Modelo buscarDescricao(String nome) {
		Modelo modelo = null;
		sql = "select * from modelo m "
				+ "where m.nome like ?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, nome);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				modelo = new Modelo();
				modelo.setIdModelo(Integer.valueOf(rs.getInt("idModelo")));
				modelo.setNome(rs.getString("nome"));
				modelo.setMarca(new Marca(rs.getInt("marca ")));
				modelo.setDataAltercacao(rs.getDate("dataAlteracao").toLocalDate());
				modelo.setForaUso(rs.getBoolean("foraUso"));
			}
		} catch (SQLException buscaNome) {
			buscaNome.printStackTrace();
		}
		return modelo;
	}

	@Override
	public List<Modelo> todos() {
		List<Modelo> modelos = new ArrayList<>();
		sql = "select * from modelo";
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Modelo modelo = new Modelo();
				modelo.setIdModelo(Integer.valueOf(rs.getInt("idModelo")));
				modelo.setNome(rs.getString("nome"));
				modelo.setMarca(new Marca(rs.getInt("marca ")));
				modelo.setDataAltercacao(rs.getDate("dataAlteracao").toLocalDate());
				modelo.setForaUso(rs.getBoolean("foraUso"));
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