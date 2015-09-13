package daoFactory.WashCar;

import dao.WashCar.UsuarioDAO;
import dao.WashCar.UsuarioDAOJDBC;

public class DaoFactoryJDBC implements AbstractDaoFactory{

	@Override
	public UsuarioDAO usuarioDao() {
		return new UsuarioDAOJDBC();
	}
}