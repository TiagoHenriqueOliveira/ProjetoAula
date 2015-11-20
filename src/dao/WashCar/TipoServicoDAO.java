package dao.WashCar;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import model.WashCar.TipoServico;

public interface TipoServicoDAO extends GenericDAO<TipoServico> {

	public Integer obterUltimoID(PreparedStatement pstmt, ResultSet rs) throws Exception;
	
}