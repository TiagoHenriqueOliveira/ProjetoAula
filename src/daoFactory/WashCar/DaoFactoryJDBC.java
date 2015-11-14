package daoFactory.WashCar;

import dao.WashCar.CarroDAO;
import dao.WashCar.CarroDAOJDBC;
import dao.WashCar.ClienteDAO;
import dao.WashCar.ClienteDAOJDBC;
import dao.WashCar.EmpresaDAO;
import dao.WashCar.EmpresaDAOJDBC;
import dao.WashCar.MarcaDAO;
import dao.WashCar.UsuarioDAO;
import dao.WashCar.UsuarioDAOJDBC;
import dao.WashCar.MarcaDAOJDBC;
import dao.WashCar.ModeloDAO;
import dao.WashCar.ModeloDAOJDBC;
import dao.WashCar.OrdemServicoDAO;
import dao.WashCar.OrdemServicoDAOJDBC;
import dao.WashCar.PessoaFisicaDAO;
import dao.WashCar.PessoaFisicaDAOJDBC;
import dao.WashCar.PessoaJuridicaDAO;
import dao.WashCar.PessoaJuridicaDAOJDBC;
import dao.WashCar.TipoServicoDAO;
import dao.WashCar.TipoServicoDAOJDBC;

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

	@Override
	public ModeloDAO modeloDao() {
		return new ModeloDAOJDBC();
	}

	@Override
	public ClienteDAO clienteDao() {
		return new ClienteDAOJDBC();
	}

	@Override
	public CarroDAO carroDao() {
		return new CarroDAOJDBC();
	}

	@Override
	public PessoaFisicaDAO pessoaFisicaDao() {
		return new PessoaFisicaDAOJDBC();
	}

	@Override
	public PessoaJuridicaDAO pessoaJuridicaDao() {
		return new PessoaJuridicaDAOJDBC();
	}
	
	@Override
	public TipoServicoDAO tipoServicoDao() {
		return new TipoServicoDAOJDBC();
	}

	@Override
	public OrdemServicoDAO ordemServicoDao() {
		return new OrdemServicoDAOJDBC();
	}
}