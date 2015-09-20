package daoFactory.WashCar;

import dao.WashCar.EmpresaDAO;
import dao.WashCar.MarcaDAO;
import dao.WashCar.UsuarioDAO;

public interface AbstractDaoFactory {

	/**
	 * Retorna uma implementação valida de
	 * @return 
	 */
	UsuarioDAO usuarioDao();
	EmpresaDAO empresaDao();
	MarcaDAO marcaDao();
}
