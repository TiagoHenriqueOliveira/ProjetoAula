package dao.WashCar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.WashCar.Marca;

public interface MarcaDAO extends GenericDAO<Marca>{
	
	public Integer obterUltimoID(PreparedStatement pstmt, ResultSet rs) throws Exception;
	
}