package daoFactory.WashCar;

import dao.WashCar.CarroDAO;
import dao.WashCar.ClienteDAO;
import dao.WashCar.EmpresaDAO;
import dao.WashCar.MarcaDAO;
import dao.WashCar.ModeloDAO;
import dao.WashCar.OrdemServicoDAO;
import dao.WashCar.PessoaFisicaDAO;
import dao.WashCar.PessoaJuridicaDAO;
import dao.WashCar.UsuarioDAO;
import dao.WashCar.TipoServicoDAO;

public interface AbstractDaoFactory {

	/**
	 * Retorna uma implementação valida de
	 * @return 
	 */
	UsuarioDAO usuarioDao();
	EmpresaDAO empresaDao();
	MarcaDAO marcaDao();
	ModeloDAO modeloDao();
	ClienteDAO clienteDao();
	CarroDAO carroDao();
	PessoaFisicaDAO pessoaFisicaDao();
	PessoaJuridicaDAO pessoaJuridicaDao();
	TipoServicoDAO tipoServicoDao();
	OrdemServicoDAO ordemServicoDao();
}
