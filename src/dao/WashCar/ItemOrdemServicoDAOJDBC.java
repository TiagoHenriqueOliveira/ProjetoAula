package dao.WashCar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoUtil;
import exception.WashCar.RegistroExistente;
import model.WashCar.ItemOrdemServico;
import model.WashCar.OrdemServico;
import model.WashCar.TipoServico;

public class ItemOrdemServicoDAOJDBC implements ItemOrdemServicoDAO{
	
	private String query;
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ItemOrdemServicoDAOJDBC() {
		connection = ConexaoUtil.openConnection();
	}

	@Override
	public void inserir(ItemOrdemServico ordemServico) throws RegistroExistente {
		query = "insert into tb_itemOrdemServico(idOrdemServico, idTipoServico, valorItemOrdemServico) "
				+ "values(?,?,?)";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, ordemServico.getOrdemServico().getIdOrdemServico());
			pstmt.setInt(2, ordemServico.getTipoServico().getIdTipoServico());
			pstmt.setDouble(3, ordemServico.getValorUnitario());
			pstmt.executeUpdate();
			ordemServico.setIdItemServico(obterUltimoID(pstmt, rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(ItemOrdemServico ordemServico) throws RegistroExistente {
		// TODO Auto-generated method stub
		//Não será utilizado  no momento
	}

	@Override
	public void excluir(ItemOrdemServico ordemServico) throws RegistroExistente {
		query = "delete from tb_itemOrdemServico "
				+ "where tb_itemOrdemServico.idTipoServico = ? "
				+ "and tb_itemOrdemServico.idOrdemServico = ?";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, ordemServico.getTipoServico().getIdTipoServico());
			pstmt.setInt(2, ordemServico.getOrdemServico().getIdOrdemServico());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ItemOrdemServico buscarId(Integer id) {
		// TODO Auto-generated method stub
		//Não será utilizado no momento
		return null;
	}

	@Override
	public List<ItemOrdemServico> buscarDescricao(String nome) {
		// TODO Auto-generated method stub
		//Não será utilizado no momento
		return null;
	}

	@Override
	public List<ItemOrdemServico> todos() {
		List<ItemOrdemServico> itensOrdemServicos = new ArrayList<>();
		query = "select * from tb_itemOrdemServico "
				+ "inner join tb_ordemServico "
				+ "on tb_itemOrdemServico.idOrdemServico = tb_ordemServico.idOrdemServico "
				+ "inner join tb_tipoServico "
				+ "on tb_itemOrdemServico.idTipoServico = tb_tipoServico.idTipoServico ";
		try {
			pstmt = connection.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ItemOrdemServico itemOrdemServico = new ItemOrdemServico();
				itemOrdemServico.setIdItemServico(rs.getInt("idOrdemServico"));
				itemOrdemServico.setOrdemServico(new OrdemServico(rs.getInt("idOrdemServico")));
				itemOrdemServico.setTipoServico(new TipoServico(rs.getInt("idTipoServico"), rs.getString("nomeTipoServico")));
				itemOrdemServico.setValorUnitario(rs.getDouble("valorItemOrdemServico"));
				itensOrdemServicos.add(itemOrdemServico);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itensOrdemServicos;
	}

	@Override
	public List<ItemOrdemServico> mostrarItens(Integer idOrdemServico) {
		List<ItemOrdemServico> itensOrdemServicos = new ArrayList<>();
		query = "select * from tb_itemOrdemServico "
				+ "inner join tb_ordemServico "
				+ "on tb_itemOrdemServico.idOrdemServico = tb_ordemServico.idOrdemServico "
				+ "inner join tb_tipoServico "
				+ "on tb_itemOrdemServico.idTipoServico = tb_tipoServico.idTipoServico "
				+ "where tb_ordemServico.idOrdemServico = ?";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, idOrdemServico);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ItemOrdemServico itemOrdemServico = new ItemOrdemServico();
				itemOrdemServico.setIdItemServico(rs.getInt("idOrdemServico"));
				itemOrdemServico.setOrdemServico(new OrdemServico(rs.getInt("idOrdemServico")));
				itemOrdemServico.setTipoServico(new TipoServico(rs.getInt("idTipoServico"), rs.getString("nomeTipoServico")));
				itemOrdemServico.setValorUnitario(rs.getDouble("valorItemOrdemServico"));
				itensOrdemServicos.add(itemOrdemServico);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itensOrdemServicos;
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