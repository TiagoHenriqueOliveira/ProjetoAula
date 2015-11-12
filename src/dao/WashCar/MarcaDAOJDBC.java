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
import exception.WashCar.RegistroExistente;
import exception.WashCar.RegistroNotExistente;

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
	public void inserir(Marca marca) throws RegistroExistente{
		sql = "insert into tb_marca(nomeMarca, dataAlteracaoMarca, marcaForaUso)"
				+ "values(?,?,?)";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, marca.getNome());
			pstmt.setDate(2, Date.valueOf(marca.getDataAltercacao().now()));
			pstmt.setBoolean(3, marca.isForaUso());
			pstmt.executeUpdate();
			marca.setIdMarca(obterUltimoID(pstmt, rs));
		} catch (SQLException e) {
			throw new RegistroExistente(e.getMessage());
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public void alterar(Marca marca) throws RegistroExistente{
		sql = "update tb_marca "
				+ "set tb_marca.nomeMarca = ?, tb_marca.marcaForaUso = ?, tb_marca.dataAlteracaoMarca = ? "
				+ "where tb_marca.idMarca = ?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, marca.getNome());
			pstmt.setBoolean(2, marca.isForaUso());
			pstmt.setDate(3, Date.valueOf(marca.getDataAltercacao().now().toString()));
			pstmt.setInt(4, marca.getIdMarca());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RegistroExistente(e.getMessage());
		}
	}

	@Override
	public void excluir(Marca marca) throws RegistroExistente{
		// TODO Auto-generated method stub
	}

	@Override
	public Marca buscarId(Integer id) throws RegistroNotExistente {
		Marca marca = null;
		sql = "select * from tb_marca "
				+ "where tb_marca.idMarca = ?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				marca = new Marca();
				marca.setIdMarca(Integer.valueOf(rs.getInt("idMarca")));
				marca.setNome(rs.getString("nomeMarca"));
				marca.setDataAltercacao(rs.getDate("dataAlteracaoMarca").toLocalDate());
				marca.setForaUso(Boolean.valueOf(rs.getBoolean("marcaForaUso")));
			}
			if(marca == null) {
				throw new RegistroNotExistente("Não foi possível encontrar nenhum registro "
						+ "para o conteúdo de busca informado.\n"
						+ "Por gentileza, efetue uma nova pesquisa.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return marca;
	}

	@Override
	public List<Marca> buscarDescricao(String nome) {
		List<Marca> marcas = new ArrayList<>();
		Marca marca = null;
		sql = "select * from tb_marca "
				+ "where tb_marca.nomeMarca like ?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, "%" + nome + "%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				marca = new Marca();
				marca.setIdMarca(Integer.valueOf(rs.getInt("idMarca")));
				marca.setNome(rs.getString("nomeMarca"));
				marca.setDataAltercacao(rs.getDate("dataAlteracaoMarca").toLocalDate());
				marca.setForaUso(Boolean.valueOf(rs.getBoolean("marcaForaUso")));
				marcas.add(marca);
			}
			if(marca == null) {
				throw new RegistroNotExistente("Não foi possível encontrar nenhum registro "
						+ "para o conteúdo de busca informado.\n"
						+ "Por gentileza, efetue uma nova pesquisa.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return marcas;
	}

	@Override
	public List<Marca> todos() {
		List<Marca> marcas = new ArrayList<>();
		Marca marca = null;
		sql = "select * from tb_marca";
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				marca = new Marca();
				marca.setIdMarca(rs.getInt("idMarca"));
				marca.setNome(rs.getString("nomeMarca"));
				marca.setForaUso(Boolean.valueOf(rs.getBoolean("marcaForaUso")));
				marca.setDataAltercacao(rs.getDate("dataAlteracaoMarca").toLocalDate());
				marcas.add(marca);
			}
			if(marca == null) {
				throw new RegistroNotExistente("Não foi possível encontrar nenhum registro "
						+ "para o conteúdo de busca informado.\n"
						+ "Por gentileza, efetue uma nova pesquisa.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return marcas;
	}

	@Override
	public Integer obterUltimoID(PreparedStatement pstmt, ResultSet rs) throws RegistroExistente {
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