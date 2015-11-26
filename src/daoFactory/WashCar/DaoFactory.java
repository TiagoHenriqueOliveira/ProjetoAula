package daoFactory.WashCar;

import dao.WashCar.CarroDAO;
import dao.WashCar.ClienteDAO;
import dao.WashCar.EmpresaDAO;
import dao.WashCar.ItemOrdemServicoDAO;
import dao.WashCar.MarcaDAO;
import dao.WashCar.TipoServicoDAO;
import dao.WashCar.ModeloDAO;
import dao.WashCar.OrdemServicoDAO;
import dao.WashCar.PessoaFisicaDAO;
import dao.WashCar.PessoaJuridicaDAO;
import dao.WashCar.UsuarioDAO;

public class DaoFactory {
	
	private static DaoFactory factory;
	
	private static AbstractDaoFactory daoFactory;
	
	public static DaoFactory getFactory() {
		if(factory == null) {
			factory = new DaoFactory();
		}
		daoFactory = new DaoFactoryJDBC();
		return factory;
	}

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
	
	public PessoaFisicaDAO pessoaFisicaDao() {
		return daoFactory.pessoaFisicaDao();
	}
	
	public PessoaJuridicaDAO pessoaJuridicaDao() {
		return daoFactory.pessoaJuridicaDao();
	}
	
	public TipoServicoDAO tipoServicoDao(){
		return daoFactory.tipoServicoDao();
	}
	
	public OrdemServicoDAO ordemServicoDao() {
		return daoFactory.ordemServicoDao();
	}
	
	public ItemOrdemServicoDAO itemOrdemServicoDao() {
		return daoFactory.itemOrdemServicoDao();
	}
}