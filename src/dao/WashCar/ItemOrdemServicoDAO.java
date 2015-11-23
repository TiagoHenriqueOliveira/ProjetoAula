package dao.WashCar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import model.WashCar.ItemOrdemServico;

public interface ItemOrdemServicoDAO extends GenericDAO<ItemOrdemServico> {
	
	public List<ItemOrdemServico> mostrarItens(Integer idOrdemServico);
	
	public Integer obterUltimoID(PreparedStatement pstmt, ResultSet rs) throws Exception;
	
}