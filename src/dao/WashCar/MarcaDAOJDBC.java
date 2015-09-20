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
	
	private Connection con;
	private String sql;
	
	public MarcaDAOJDBC() {
		con = ConexaoUtil.getCon();
	}

	@SuppressWarnings("static-access")
	@Override
	public void inserir(Marca marca) {
		sql = "insert into marca(nome, dataAlteracao, foraUso)"
				+ "values(?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, marca.getNome());
			pstmt.setDate(2, Date.valueOf(marca.getDataAltercacao().now()));
			pstmt.setBoolean(3, marca.isForaUso());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Marca marca) {
		sql = "update marca m"
				+ "set m.nome = ?, m.foraUso = ?"
				+ "where m.idMarca = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, marca.getNome());
			pstmt.setBoolean(2, marca.isForaUso());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(Marca marca) {
		// TODO Auto-generated method stub
	}

	@Override
	public Marca buscarId(Integer id) {
		Marca marca = null;
		sql = "select * from marca m"
				+ "where m.idMarca = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
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
	public Marca buscarDescricao(String nome) {
		Marca marca = null;
		sql = "select * from marca m"
				+ "where m.nome like ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nome);
			ResultSet rs = pstmt.executeQuery();
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
	public Marca buscarDocumento(String codDocumento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Marca> todos() {
		List<Marca> marcas = new ArrayList<>();
		sql = "select * from marca";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Marca marca = new Marca();
				marca.setIdMarca(Integer.valueOf(rs.getInt("idMarca")));
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
}