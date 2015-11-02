package dao.WashCar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.WashCar.Carro;

public interface CarroDAO extends GenericDAO<Carro>{
	
	public Carro pesquisaPorPlaca(String placa);
	
	public Integer obterUltimoID(PreparedStatement pstmt, ResultSet rs) throws Exception;
	
}