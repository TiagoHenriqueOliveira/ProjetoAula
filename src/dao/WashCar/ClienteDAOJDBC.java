package dao.WashCar;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoUtil;
import exception.WashCar.RegistroExistente;
import exception.WashCar.RegistroNotExistente;
import model.WashCar.Cidade;
import model.WashCar.Cliente;
import model.WashCar.Pais;
import model.WashCar.PessoaFisica;
import model.WashCar.PessoaJuridica;
import model.WashCar.UnidadeFederativa;

public class ClienteDAOJDBC implements ClienteDAO{
	
	private Connection connection;
	private String query;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ClienteDAOJDBC() {
		connection = ConexaoUtil.openConnection();
	}

	@SuppressWarnings("static-access")
	@Override
	public void inserir(Cliente cliente) throws RegistroExistente {
		query = "insert into tb_cliente(tipoPessoa, enderecoCliente, bairroCliente, numeroCliente, telefoneComercialCliente, telefoneResidencialCliente, "
				+ "telefoneCelularCliente, emailCliente, clienteForaUso, dataAlteracaoCliente, idCidade, idEmpresa) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, cliente.getTipoPessoa());
			pstmt.setString(2, cliente.getEndereco());
			pstmt.setString(3, cliente.getBairro());
			pstmt.setInt(4, cliente.getNumero());
			pstmt.setString(5, cliente.getTelefoneComercial());
			pstmt.setString(6, cliente.getTelefoneResidencial());
			pstmt.setString(7, cliente.getTelefoneCelular());
			pstmt.setString(8, cliente.getEmail());
			pstmt.setBoolean(9, cliente.isForaUso());
			pstmt.setDate(10, Date.valueOf(cliente.getDataAltercacao().now().toString()));
			pstmt.setInt(11, cliente.getCidade().getIdCidade());
			pstmt.setInt(12, cliente.getEmpresa().getIdEmpresa());
			pstmt.executeUpdate();
			cliente.setIdCliente(obterUltimoID(pstmt, rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public void alterar(Cliente cliente) throws RegistroExistente {
		query = "update tb_cliente "
				+ "set tb_cliente.tipoPessoa = ? , tb_cliente.enderecoCliente = ?, tb_cliente.bairroCliente = ?, "
				+ "tb_cliente.numeroCliente = ?, tb_cliente.telefoneComercialCliente = ?, tb_cliente.telefoneResidencialCliente = ?, "
				+ "tb_cliente.telefoneCelularCliente = ?, tb_cliente.emailCliente = ?, tb_cliente.clienteForaUso = ?, "
				+ "tb_cliente.dataAlteracaoCliente = ?, tb_cliente.idCidade = ? "
				+ "where tb_cliente.idCliente = ?";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, cliente.getTipoPessoa());
			pstmt.setString(2, cliente.getEndereco());
			pstmt.setString(3, cliente.getBairro());
			pstmt.setInt(4, cliente.getNumero());
			pstmt.setString(5, cliente.getTelefoneComercial());
			pstmt.setString(6, cliente.getTelefoneResidencial());
			pstmt.setString(7, cliente.getTelefoneCelular());
			pstmt.setString(8, cliente.getEmail());
			pstmt.setBoolean(9, cliente.isForaUso());
			pstmt.setDate(10, Date.valueOf(cliente.getDataAltercacao().now().toString()));
			pstmt.setInt(11, cliente.getCidade().getIdCidade());
			pstmt.setInt(12, cliente.getIdCliente());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(Cliente cliente) throws RegistroExistente {
		// TODO Auto-generated method stub
	}

	@Override
	public Cliente buscarId(Integer id) {
		Cliente cliente = null;
		query = "select * from tb_cliente "
				+ "left join tb_pessoaFisica "
				+ "on tb_cliente.idCliente = tb_pessoaFisica.idCliente "
				+ "left join tb_pessoaJuridica "
				+ "on tb_cliente.idCliente = tb_pessoaJuridica.idCliente "
				+ "inner join tb_cidade "
				+ "on tb_cliente.idCidade = tb_cidade.idCidade "
				+ "inner join tb_uf "
				+ "on tb_cidade.idUF = tb_uf.idUF "
				+ "inner join tb_pais "
				+ "on tb_uf.idPais = tb_pais.idPais "
				+ "where tb_cliente.idCliente = ?";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cliente = new Cliente();
				cliente.setIdCliente(rs.getInt("idCliente"));
				cliente.setTipoPessoa(rs.getInt("tipoPessoa"));
				cliente.setEndereco(rs.getString("enderecoCliente"));
				cliente.setBairro(rs.getString("bairroCliente"));
				cliente.setNumero(rs.getInt("numeroCliente"));
				cliente.setTelefoneCelular(rs.getString("telefoneCelularCliente"));
				cliente.setTelefoneComercial(rs.getString("telefoneComercialCliente"));
				cliente.setTelefoneResidencial(rs.getString("telefoneResidencialCliente"));
				cliente.setEmail(rs.getString("emailCliente"));
				cliente.setForaUso(rs.getBoolean("clienteForaUso"));
				cliente.setDataAltercacao(rs.getDate("dataAlteracaoCliente").toLocalDate());
				cliente.setPessoaFisica(new PessoaFisica(rs.getString("nomeCliente"), rs.getString("cpfCliente"), rs.getString("rgCliente")));
				cliente.setPessoaJuridica(new PessoaJuridica(rs.getString("razaoSocialCliente"), rs.getString("nomeFantasiaCliente"),
				rs.getString("cnpjCliente"), rs.getString("inscricaoEstadualCliente"), rs.getString("inscricaoMunicipalCliente")));
				Cidade cidade = new Cidade(rs.getInt("idCidade"), rs.getString("nomeCidade"));
				cidade.setUnidadeFederativa(new UnidadeFederativa(rs.getInt("idUF"), rs.getString("nomeUF"),
				new Pais(rs.getInt("idPais"), rs.getString("nomePais"))));
				cliente.setCidade(cidade);
			}
			if(cliente == null) {
				throw new RegistroNotExistente("Não foi possível encontrar nenhum registro "
						+ "para o conteúdo de busca informado.\n"
						+ "Por gentileza, efetue uma nova pesquisa.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}

	@Override
	public List<Cliente> buscarDescricao(String nome) {
		List<Cliente> clientes = new ArrayList<>();
		Cliente cliente = null;
		query = "select * from tb_cliente "
				+ "left join tb_pessoaFisica "
				+ "on tb_cliente.idCliente = tb_pessoaFisica.idCliente "
				+ "left join tb_pessoaJuridica "
				+ "on tb_cliente.idCliente = tb_pessoaJuridica.idCliente "
				+ "inner join tb_cidade "
				+ "on tb_cliente.idCidade = tb_cidade.idCidade "
				+ "inner join tb_uf "
				+ "on tb_cidade.idUF = tb_uf.idUF "
				+ "inner join tb_pais "
				+ "on tb_uf.idPais = tb_pais.idPais "
				+ "where tb_pessoaFisica.nomeCliente like ? "
				+ "or tb_pessoaJuridica.nomeFantasiaCliente like ?"
				+ "order by tb_pessoaFisica.nomeCliente ";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, "%" + nome + "%");
			pstmt.setString(2, "%" + nome + "%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cliente = new Cliente();
				cliente.setIdCliente(rs.getInt("idCliente"));
				cliente.setTipoPessoa(rs.getInt("tipoPessoa"));
				cliente.setEndereco(rs.getString("enderecoCliente"));
				cliente.setBairro(rs.getString("bairroCliente"));
				cliente.setNumero(rs.getInt("numeroCliente"));
				cliente.setTelefoneCelular(rs.getString("telefoneCelularCliente"));
				cliente.setTelefoneComercial(rs.getString("telefoneComercialCliente"));
				cliente.setTelefoneResidencial(rs.getString("telefoneResidencialCliente"));
				cliente.setEmail(rs.getString("emailCliente"));
				cliente.setForaUso(rs.getBoolean("clienteForaUso"));
				cliente.setDataAltercacao(rs.getDate("dataAlteracaoCliente").toLocalDate());
				cliente.setPessoaFisica(new PessoaFisica(rs.getString("nomeCliente"), rs.getString("cpfCliente"), rs.getString("rgCliente")));
				cliente.setPessoaJuridica(new PessoaJuridica(rs.getString("razaoSocialCliente"), rs.getString("nomeFantasiaCliente"),
				rs.getString("cnpjCliente"), rs.getString("inscricaoEstadualCliente"), rs.getString("inscricaoMunicipalCliente")));
				Cidade cidade = new Cidade(rs.getInt("idCidade"), rs.getString("nomeCidade"));
				cidade.setUnidadeFederativa(new UnidadeFederativa(rs.getInt("idUF"), rs.getString("nomeUF"),
				new Pais(rs.getInt("idPais"), rs.getString("nomePais"))));
				cliente.setCidade(cidade);
				clientes.add(cliente);
			}
			if(cliente == null) {
				throw new RegistroNotExistente("Não foi possível encontrar nenhum registro "
						+ "para o conteúdo de busca informado.\n"
						+ "Por gentileza, efetue uma nova pesquisa.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}

	@Override
	public List<Cliente> todos() {
		List<Cliente> clientes = new ArrayList<>();
		Cliente cliente = null;
		query = "select * from tb_cliente "
				+ "left join tb_pessoaFisica "
				+ "on tb_cliente.idCliente = tb_pessoaFisica.idCliente "
				+ "left join tb_pessoaJuridica "
				+ "on tb_cliente.idCliente = tb_pessoaJuridica.idCliente "
				+ "inner join tb_cidade "
				+ "on tb_cliente.idCidade = tb_cidade.idCidade "
				+ "inner join tb_UF "
				+ "on tb_cidade.idUF = tb_uf.idUF "
				+ "inner join tb_pais "
				+ "on tb_UF.idPais = tb_pais.idPais "
				+ "order by tb_pessoaFisica.nomeCliente ";
		try {
			pstmt = connection.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cliente = new Cliente();
				cliente.setIdCliente(rs.getInt("idCliente"));
				cliente.setTipoPessoa(rs.getInt("tipoPessoa"));
				cliente.setEndereco(rs.getString("enderecoCliente"));
				cliente.setBairro(rs.getString("bairroCliente"));
				cliente.setNumero(rs.getInt("numeroCliente"));
				cliente.setTelefoneCelular(rs.getString("telefoneCelularCliente"));
				cliente.setTelefoneComercial(rs.getString("telefoneComercialCliente"));
				cliente.setTelefoneResidencial(rs.getString("telefoneResidencialCliente"));
				cliente.setEmail(rs.getString("emailCliente"));
				cliente.setForaUso(rs.getBoolean("clienteForaUso"));
				cliente.setDataAltercacao(rs.getDate("dataAlteracaoCliente").toLocalDate());
				cliente.setPessoaFisica(new PessoaFisica(rs.getString("nomeCliente"), rs.getString("cpfCliente"), rs.getString("rgCliente")));
				cliente.setPessoaJuridica(new PessoaJuridica(rs.getString("razaoSocialCliente"), rs.getString("nomeFantasiaCliente"),
				rs.getString("cnpjCliente"), rs.getString("inscricaoEstadualCliente"), rs.getString("inscricaoMunicipalCliente")));
				Cidade cidade = new Cidade(rs.getInt("idCidade"), rs.getString("nomeCidade"));
				cidade.setUnidadeFederativa(new UnidadeFederativa(rs.getInt("idUF"), rs.getString("nomeUF"),
				new Pais(rs.getInt("idPais"), rs.getString("nomePais"))));
				cliente.setCidade(cidade);
				clientes.add(cliente);
			}
			if(cliente == null) {
				throw new RegistroNotExistente("Não foi possível encontrar nenhum registro "
						+ "para o conteúdo de busca informado.\n"
						+ "Por gentileza, efetue uma nova pesquisa.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}

	@Override
	public Cliente pesquisaCNPJ(String cnpj) {
		Cliente cliente = null;
		query = "select * from tb_cliente "
				+ "left join tb_pessoaFisica "
				+ "on tb_cliente.idCliente = tb_pessoaFisica.idCliente "
				+ "left join tb_pessoaJuridica "
				+ "on tb_cliente.idCliente = tb_pessoaJuridica.idCliente "
				+ "inner join tb_cidade "
				+ "on tb_cliente.idCidade = tb_cidade.idCidade "
				+ "inner join tb_uf "
				+ "on tb_cidade.idUF = tb_uf.idUF "
				+ "inner join tb_pais "
				+ "on tb_uf.idPais = tb_pais.idPais "
				+ "where tb_pessoaJuridica.cnpjCliente = ?";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, cnpj);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cliente = new Cliente();
				cliente.setIdCliente(rs.getInt("idCliente"));
				cliente.setTipoPessoa(rs.getInt("tipoPessoa"));
				cliente.setEndereco(rs.getString("enderecoCliente"));
				cliente.setBairro(rs.getString("bairroCliente"));
				cliente.setNumero(rs.getInt("numeroCliente"));
				cliente.setTelefoneCelular(rs.getString("telefoneCelularCliente"));
				cliente.setTelefoneComercial(rs.getString("telefoneComercialCliente"));
				cliente.setTelefoneResidencial(rs.getString("telefoneResidencialCliente"));
				cliente.setEmail(rs.getString("emailCliente"));
				cliente.setForaUso(rs.getBoolean("clienteForaUso"));
				cliente.setDataAltercacao(rs.getDate("dataAlteracaoCliente").toLocalDate());
				cliente.setPessoaFisica(new PessoaFisica(rs.getString("nomeCliente"), rs.getString("cpfCliente"), rs.getString("rgCliente")));
				cliente.setPessoaJuridica(new PessoaJuridica(rs.getString("razaoSocialCliente"), rs.getString("nomeFantasiaCliente"),
				rs.getString("cnpjCliente"), rs.getString("inscricaoEstadualCliente"), rs.getString("inscricaoMunicipalCliente")));
				Cidade cidade = new Cidade(rs.getInt("idCidade"), rs.getString("nomeCidade"));
				cidade.setUnidadeFederativa(new UnidadeFederativa(rs.getInt("idUF"), rs.getString("nomeUF"),
				new Pais(rs.getInt("idPais"), rs.getString("nomePais"))));
				cliente.setCidade(cidade);
			}
			if(cliente == null) {
				throw new RegistroNotExistente("Não foi possível encontrar nenhum registro "
						+ "para o conteúdo de busca informado.\n"
						+ "Por gentileza, efetue uma nova pesquisa.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}

	@Override
	public Cliente pesquisaCPF(String cpf) {
		Cliente cliente = null;
		query = "select * from tb_cliente "
				+ "left join tb_pessoaFisica "
				+ "on tb_cliente.idCliente = tb_pessoaFisica.idCliente "
				+ "left join tb_pessoaJuridica "
				+ "on tb_cliente.idCliente = tb_pessoaJuridica.idCliente "
				+ "inner join tb_cidade "
				+ "on tb_cliente.idCidade = tb_cidade.idCidade "
				+ "inner join tb_uf "
				+ "on tb_cidade.idUF = tb_uf.idUF "
				+ "inner join tb_pais "
				+ "on tb_uf.idPais = tb_pais.idPais "
				+ "where tb_pessoaFisica.cpfCliente = ?";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, cpf);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cliente = new Cliente();
				cliente.setIdCliente(rs.getInt("idCliente"));
				cliente.setTipoPessoa(rs.getInt("tipoPessoa"));
				cliente.setEndereco(rs.getString("enderecoCliente"));
				cliente.setBairro(rs.getString("bairroCliente"));
				cliente.setNumero(rs.getInt("numeroCliente"));
				cliente.setTelefoneCelular(rs.getString("telefoneCelularCliente"));
				cliente.setTelefoneComercial(rs.getString("telefoneComercialCliente"));
				cliente.setTelefoneResidencial(rs.getString("telefoneResidencialCliente"));
				cliente.setEmail(rs.getString("emailCliente"));
				cliente.setForaUso(rs.getBoolean("clienteForaUso"));
				cliente.setDataAltercacao(rs.getDate("dataAlteracaoCliente").toLocalDate());
				cliente.setPessoaFisica(new PessoaFisica(rs.getString("nomeCliente"), rs.getString("cpfCliente"), rs.getString("rgCliente")));
				cliente.setPessoaJuridica(new PessoaJuridica(rs.getString("razaoSocialCliente"), rs.getString("nomeFantasiaCliente"),
				rs.getString("cnpjCliente"), rs.getString("inscricaoEstadualCliente"), rs.getString("inscricaoMunicipalCliente")));
				Cidade cidade = new Cidade(rs.getInt("idCidade"), rs.getString("nomeCidade"));
				cidade.setUnidadeFederativa(new UnidadeFederativa(rs.getInt("idUF"), rs.getString("nomeUF"),
				new Pais(rs.getInt("idPais"), rs.getString("nomePais"))));
				cliente.setCidade(cidade);
			}
			if(cliente == null) {
				throw new RegistroNotExistente("Não foi possível encontrar nenhum registro "
						+ "para o conteúdo de busca informado.\n"
						+ "Por gentileza, efetue uma nova pesquisa.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}

	@Override
	public Integer obterUltimoID(PreparedStatement pstmt, ResultSet rs) throws RegistroExistente {
		try {
			rs = pstmt.executeQuery("select last_insert_id()");
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}