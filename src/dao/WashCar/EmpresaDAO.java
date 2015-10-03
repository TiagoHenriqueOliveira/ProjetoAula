package dao.WashCar;

import model.WashCar.Empresa;

public interface EmpresaDAO extends GenericDAO<Empresa>{
	
	void buscarDocumento(String codDocumento);

}