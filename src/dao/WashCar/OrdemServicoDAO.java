package dao.WashCar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import exception.WashCar.RegistroExistente;
import model.WashCar.OrdemServico;

public interface OrdemServicoDAO extends GenericDAO<OrdemServico> {
	
	public Integer obterUltimoID(PreparedStatement pstmt, ResultSet rs) throws RegistroExistente;
	
	public OrdemServico pesquisaPorPlaca(String placa);
	
}