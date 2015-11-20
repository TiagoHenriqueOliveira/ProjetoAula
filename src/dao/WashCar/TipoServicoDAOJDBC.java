package dao.WashCar;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoUtil;
import dao.WashCar.TipoServicoDAO;
import exception.WashCar.RegistroExistente;
import exception.WashCar.RegistroNotExistente;
import model.WashCar.TipoServico;

public class TipoServicoDAOJDBC implements TipoServicoDAO {

	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql;
	
	public TipoServicoDAOJDBC(){
		connection = ConexaoUtil.openConnection();
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void inserir(TipoServico tipoServico) throws RegistroExistente {
		sql = "insert into tb_tipoServico(nomeTipoServico, valorTipoServico, tipoServicoForaUso, dataAlteracaoTipoServico) "
				+ "values(?, ?, ?, ?)";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, tipoServico.getNome());
			pstmt.setDouble(2, Double.valueOf(tipoServico.getValor()));
			pstmt.setBoolean(3, tipoServico.isForaUso());
			pstmt.setDate(4, Date.valueOf(tipoServico.getDataAltercacao().now()));
			pstmt.executeUpdate();
			tipoServico.setIdTipoServico(obterUltimoID(pstmt, rs));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void alterar(TipoServico tipoServico) throws RegistroExistente {
		sql = "update tb_tipoServico "
				+"set tb_tipoServico.nomeTipoServico = ?, tb_tipoServico.valorTipoServico = ?, "
				+ "tb_tipoServico.tipoServicoForaUso = ?, tb_tipoServico.dataAlteracaoTipoServico = ? "
				+"where tb_tipoServico.idTipoServico = ?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, tipoServico.getNome());
			pstmt.setDouble(2, Double.valueOf(tipoServico.getValor()));
			pstmt.setBoolean(3, tipoServico.isForaUso());
			pstmt.setDate(4, Date.valueOf(tipoServico.getDataAltercacao().now()));
			pstmt.setInt(5, tipoServico.getIdTipoServico());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(TipoServico entidade) throws RegistroExistente {
		// TODO Auto-generated method stub
		//Não será usado no momento
	}

	@Override
	public TipoServico buscarId(Integer id) {
		TipoServico tipoServico = null;
		sql = "select * from tb_tipoServico "
				+ "where tb_tipoServico.idTipoServico = ?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				tipoServico = new TipoServico();
				tipoServico.setIdTipoServico(rs.getInt("idTipoServico"));
				tipoServico.setNome(rs.getString("nomeTipoServico"));
				tipoServico.setValor(rs.getDouble("valorTipoServico"));
				tipoServico.setForaUso(rs.getBoolean("tipoServicoForaUso"));
				tipoServico.setDataAltercacao(rs.getDate("dataAlteracaoTipoServico").toLocalDate());
			}
			if(tipoServico == null) {
				throw new RegistroNotExistente("Não foi possível encontrar nenhum registro "
						+ "para o conteúdo de busca informado.\n"
						+ "Por gentileza, efetue uma nova pesquisa.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tipoServico;
	}

	@Override
	public List<TipoServico> buscarDescricao(String nome) {
		TipoServico tipoServico = null;
		List<TipoServico> servicos = new ArrayList<>();
		sql = "select * from tb_tipoServico "
				+ "where tb_tipoServico.nomeTipoServico like ?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, "%" + nome + "%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				tipoServico = new TipoServico();
				tipoServico.setIdTipoServico(rs.getInt("idTipoServico"));
				tipoServico.setNome(rs.getString("nomeTipoServico"));
				tipoServico.setValor(rs.getDouble("valorTipoServico"));
				tipoServico.setForaUso(rs.getBoolean("tipoServicoForaUso"));
				tipoServico.setDataAltercacao(rs.getDate("dataAlteracaoTipoServico").toLocalDate());
				servicos.add(tipoServico);
			}
			if(tipoServico == null) {
				throw new RegistroNotExistente("Não foi possível encontrar nenhum registro "
						+ "para o conteúdo de busca informado.\n"
						+ "Por gentileza, efetue uma nova pesquisa.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return servicos;
	}

	@Override
	public List<TipoServico> todos() {
		TipoServico tipoServico = null;
		List<TipoServico> servicos = new ArrayList<>();
		sql = "select * from tb_tipoServico ";
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				tipoServico = new TipoServico();
				tipoServico.setIdTipoServico(rs.getInt("idTipoServico"));
				tipoServico.setNome(rs.getString("nomeTipoServico"));
				tipoServico.setValor(rs.getDouble("valorTipoServico"));
				tipoServico.setForaUso(rs.getBoolean("tipoServicoForaUso"));
				tipoServico.setDataAltercacao(rs.getDate("dataAlteracaoTipoServico").toLocalDate());
				servicos.add(tipoServico);
			}
			if(tipoServico == null) {
				throw new RegistroNotExistente("Não foi possível encontrar nenhum registro "
						+ "para o conteúdo de busca informado.\n"
						+ "Por gentileza, efetue uma nova pesquisa.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return servicos;
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