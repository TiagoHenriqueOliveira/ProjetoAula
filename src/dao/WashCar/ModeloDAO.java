package dao.WashCar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.WashCar.Modelo;

public interface ModeloDAO extends GenericDAO<Modelo>{

	public Integer obterUltimoID(PreparedStatement pstmt, ResultSet rs) throws Exception;
	
}