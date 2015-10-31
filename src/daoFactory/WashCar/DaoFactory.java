package daoFactory.WashCar;

import dao.WashCar.CarroDAO;
import dao.WashCar.ClienteDAO;
import dao.WashCar.EmpresaDAO;
import dao.WashCar.MarcaDAO;
import dao.WashCar.ModeloDAO;
import dao.WashCar.UsuarioDAO;

/**
 * Fabrica de DAO, inicializa a fabrica correta para 
 * o tipo de sistema e disponibiza os métodos de acesso a construção do DAO 
 * @author forchesatto
 *
 */
public class DaoFactory {
	
	private static DaoFactory factory;
	
	private static AbstractDaoFactory daoFactory;
	
	/**
	 * Constroi a fabrica correta de DAO.
	 * @return
	 */
	public static DaoFactory getFactory() {
		if(factory == null) {
			factory = new DaoFactory();
		}
		daoFactory = new DaoFactoryJDBC();
		return factory;
	}

	/**
	 * Disponibiliza o DAO com base na fabrica construida dinamicamente.
	 * @return
	 */
	public UsuarioDAO usuarioDao() {
		return daoFactory.usuarioDao();
	}
	
	public EmpresaDAO empresaDao() {
		return daoFactory.empresaDao();
	}
	
	public MarcaDAO marcaDao() {
		return daoFactory.marcaDao();
	}
	
	public ModeloDAO modeloDao() {
		return daoFactory.modeloDao();
	}
	
	public ClienteDAO clienteDao() {
		return daoFactory.clienteDao();
	}
	
	public CarroDAO carroDao() {
		return daoFactory.carroDao();
	}
}