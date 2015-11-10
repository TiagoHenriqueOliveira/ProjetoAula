package dao.WashCar;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import conexao.ConexaoUtil;
import dao.WashCar.TipoServicoDAO;
import exception.WashCar.RegistroExistente;
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
		sql = "insert into tipo_servico(nome, valor, dataAlteracao) "
				+ "values(?, ?, ?)";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, tipoServico.getNome());
			pstmt.setDouble(2, Double.valueOf(tipoServico.getValor()));
			pstmt.setDate(3, Date.valueOf(tipoServico.getDataAltercacao().now()));
			//pstmt.setBoolean(4, tipoServico.isForaUso());
			pstmt.executeUpdate();
			tipoServico.setIdTipoServico(obterUltimoID(pstmt, rs));
		} catch (Exception insert) {
			insert.printStackTrace();
		}

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

	@Override
	public void alterar(TipoServico tipoServico) throws RegistroExistente {
		sql = "update tipo_servico "
				+"set tipo_servico.nome = ?, tipo_servico.valor = ?, tipo_servico.dataAlteracao = ?, tipo_servico.foraUso = ? "
				+"where tipo_servico.idTipoServico = ?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, tipoServico.getNome());
			pstmt.setDouble(2, Double.valueOf(tipoServico.getValor()));
			pstmt.setDate(3, Date.valueOf(tipoServico.getDataAltercacao().now()));
			pstmt.setBoolean(4, tipoServico.isForaUso());
			pstmt.executeUpdate();
			tipoServico.setIdTipoServico(obterUltimoID(pstmt, rs));
		} catch (Exception insert) {
			insert.printStackTrace();
		}

	}

	@Override
	public void excluir(TipoServico entidade) throws RegistroExistente {
		// TODO Auto-generated method stub

	}

	@Override
	public TipoServico buscarId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoServico> buscarDescricao(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoServico> todos() {
		// TODO Auto-generated method stub
		return null;
	}

}