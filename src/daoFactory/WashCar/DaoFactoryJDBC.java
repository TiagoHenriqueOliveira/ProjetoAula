package daoFactory.WashCar;

import dao.WashCar.EmpresaDAO;
import dao.WashCar.EmpresaDAOJDBC;
import dao.WashCar.MarcaDAO;
import dao.WashCar.UsuarioDAO;
import dao.WashCar.UsuarioDAOJDBC;
import dao.WashCar.MarcaDAOJDBC;

public class DaoFactoryJDBC implements AbstractDaoFactory{

	@Override
	public UsuarioDAO usuarioDao() {
		return new UsuarioDAOJDBC();
	}

	@Override
	public EmpresaDAO empresaDao() {
		return new EmpresaDAOJDBC();
	}
	
	public MarcaDAO marcaDao() {
		return new MarcaDAOJDBC();
	}
}