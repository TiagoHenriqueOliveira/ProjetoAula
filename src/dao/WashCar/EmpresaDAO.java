package dao.WashCar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.WashCar.Empresa;

public interface EmpresaDAO extends GenericDAO<Empresa>{
	
	public Empresa buscarDocumento(String codDocumento);
	
	public Integer obterUltimoID(PreparedStatement pstmt, ResultSet rs) throws Exception;

}