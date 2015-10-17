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
import dao.WashCar.MarcaDAO;

public class MarcaDAOJDBC implements MarcaDAO{
	
	private Connection connection;
	private String sql;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public MarcaDAOJDBC() {
		connection = ConexaoUtil.openConnection();
	}

	@SuppressWarnings("static-access")
	@Override
	public void inserir(Marca marca) throws Exception{
		sql = "insert into marca(nome, dataAlteracao, foraUso)"
				+ "values(?,?,?)";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, marca.getNome());
			pstmt.setDate(2, Date.valueOf(marca.getDataAltercacao().now()));
			pstmt.setBoolean(3, marca.isForaUso());
			pstmt.executeUpdate();
			marca.setIdMarca(obterUltimoID(pstmt, rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public void alterar(Marca marca) {
		sql = "update marca m "
				+ "set m.nome = ?, m.foraUso = ?, m.dataAlteracao = ? "
				+ "where m.idMarca = ?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, marca.getNome());
			pstmt.setBoolean(2, marca.isForaUso());
			pstmt.setDate(3, Date.valueOf(marca.getDataAltercacao().now().toString()));
			pstmt.setInt(4, marca.getIdMarca());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(Marca marca) throws Exception{
		// TODO Auto-generated method stub
	}

	@Override
	public Marca buscarId(Integer id) {
		Marca marca = null;
		sql = "select * from marca m "
				+ "where m.idMarca = ?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				marca = new Marca();
				marca.setIdMarca(Integer.valueOf(rs.getInt("idMarca")));
				marca.setNome(rs.getString("nome"));
				marca.setDataAltercacao(rs.getDate("dataAlteracao").toLocalDate());
				marca.setForaUso(Boolean.valueOf(rs.getBoolean("foraUso")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return marca;
	}

	@Override
	public List<Marca> buscarDescricao(String nome) {
		List<Marca> marcas = new ArrayList<>();
		sql = "select * from marca m "
				+ "where m.nome like ?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, "%" + nome + "%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Marca marca = new Marca();
				marca.setIdMarca(Integer.valueOf(rs.getInt("idMarca")));
				marca.setNome(rs.getString("nome"));
				marca.setDataAltercacao(rs.getDate("dataAlteracao").toLocalDate());
				marca.setForaUso(Boolean.valueOf(rs.getBoolean("foraUso")));
				marcas.add(marca);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return marcas;
	}

	@Override
	public List<Marca> todos() {
		List<Marca> marcas = new ArrayList<>();
		sql = "select * from marca";
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Marca marca = new Marca();
				marca.setIdMarca(rs.getInt("idMarca"));
				marca.setNome(rs.getString("nome"));
				marca.setForaUso(Boolean.valueOf(rs.getBoolean("foraUso")));
				marca.setDataAltercacao(rs.getDate("dataAlteracao").toLocalDate());
				marcas.add(marca);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return marcas;
	}

	@Override
	public Integer obterUltimoID(PreparedStatement pstmt, ResultSet rs) throws Exception {
		try {
			rs = pstmt.executeQuery("select last_insert_id()");
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}