package daoFactory.WashCar;

import dao.WashCar.UsuarioDAO;

public interface AbstractDaoFactory {

	/**
	 * Retorna uma implementação valida de ProdutoDAO
	 * @return ProdutoDAO
	 */
	UsuarioDAO usuarioDao();
}
