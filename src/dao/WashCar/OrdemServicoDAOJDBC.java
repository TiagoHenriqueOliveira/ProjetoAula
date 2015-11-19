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
import model.WashCar.Carro;
import model.WashCar.Cliente;
import model.WashCar.OrdemServico;
import model.WashCar.PessoaFisica;
import model.WashCar.PessoaJuridica;

public class OrdemServicoDAOJDBC implements OrdemServicoDAO {
	
	private Connection connection;
	private String query;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public OrdemServicoDAOJDBC() {
		connection = ConexaoUtil.openConnection();
	}

	@SuppressWarnings("static-access")
	@Override
	public void inserir(OrdemServico ordemServico) throws RegistroExistente {
		query = "insert into tb_ordemServico(statusOrdemServico, dataAgendamentoOrdemServico, dataAlteracaoOrdemServico, idCliente, idCarro) "
				+ "values(?,?,?,?,?)";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, ordemServico.getStatusOSV());
			pstmt.setDate(2, Date.valueOf(ordemServico.getDataAgendamento().toString()));
			pstmt.setDate(3, Date.valueOf(ordemServico.getDataAlteracao().now().toString()));
			pstmt.setInt(4, ordemServico.getCliente().getIdCliente());
			pstmt.setInt(5, ordemServico.getCarro().getIdCarro());
			pstmt.executeUpdate();
			ordemServico.setIdOrdemServico(obterUltimoID(pstmt, rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public void alterar(OrdemServico ordemServico) throws RegistroExistente {
		query = "update tb_ordemServico "
				+ "set  tb_ordemServico.statusOrdemServico = ?, tb_ordemServico.idCliente = ?, tb_ordemServico.idCarro = ? "
				+ " tb_ordemServico.dataAgendamentoOrdemServico = ?,  tb_ordemServico.dataAlteracaoOrdemServico = ?"
				+ "where  tb_ordemServico.idOrdemServico = ?";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, ordemServico.getStatusOSV());
			pstmt.setDate(2, Date.valueOf(ordemServico.getDataAgendamento().toString()));
			pstmt.setDate(3, Date.valueOf(ordemServico.getDataAlteracao().now().toString()));
			pstmt.setInt(4, ordemServico.getCliente().getIdCliente());
			pstmt.setInt(5, ordemServico.getCarro().getIdCarro());
			pstmt.setInt(6, ordemServico.getIdOrdemServico());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(OrdemServico ordemServico) throws RegistroExistente {
		// TODO Auto-generated method stub
	}

	@Override
	public OrdemServico buscarId(Integer id) {
		OrdemServico ordemServico = null;
		query = "select * from tb_ordemServico "
				+ "inner join tb_cliente "
				+ "on tb_ordemServico.idCliente = tb_cliente.idCliente "
				+ "left join tb_pessoaFisica "
				+ "on tb_cliente.idCliente = tb_pessoaFisica.idCliente "
				+ "left join tb_pessoaJuridica "
				+ "on tb_cliente.idCliente = tb_pessoaJuridica.idCliente "
				+ "inner join tb_carro "
				+	"on tb_ordemservico.idCliente = tb_carro.idCliente "
				+  "and tb_ordemservico.idCarro = tb_carro.idCarro "
				+ "where tb_ordemServico.idOrdemServico = ? "
				+ "order by tb_ordemServico.idOrdemServico desc";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ordemServico = new OrdemServico();
				ordemServico.setIdOrdemServico(rs.getInt("idOrdemServico"));
				ordemServico.setValorTotal(rs.getDouble("valorTotalOrdemServico"));
				ordemServico.setDataAgendamento(rs.getDate("dataAgendamentoOrdemServico").toLocalDate());
				ordemServico.setDataAlteracao(rs.getDate("dataAlteracaoOrdemServico").toLocalDate());
				ordemServico.setStatusOSV(rs.getInt("statusOrdemServico"));
				Cliente cliente = new Cliente(rs.getInt("idCliente"), rs.getInt("tipoPessoa"), 
				rs.getString("telefoneComercialCliente"), rs.getString("telefoneResidencialCliente"), rs.getString("telefoneCelularCliente"));
				cliente.setPessoaFisica(new PessoaFisica(rs.getString("nomeCliente"), rs.getString("cpfCliente"), null));
				cliente.setPessoaJuridica(new PessoaJuridica(null, rs.getString("nomeFantasiaCliente"), rs.getString("cnpjCliente"), null, null));
				ordemServico.setCarro(new Carro(rs.getInt("idCarro"), rs.getString("nomeCarro"), rs.getString("placaCarro")));
				ordemServico.setCliente(cliente);
			}
			if(ordemServico == null) {
				throw new RegistroNotExistente("Não foi possível encontrar nenhum registro "
						+ "para o conteúdo informado.\n"
						+ "Por gentileza, efetue uma nova pesquisa.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ordemServico;
	}

	@Override
	public List<OrdemServico> buscarDescricao(String nome) {
		List<OrdemServico> ordensServicos = new ArrayList<>();
		OrdemServico ordemServico = null;
		query = "select * from tb_ordemServico "
				+ "inner join tb_cliente "
				+ "on tb_ordemServico.idCliente = tb_cliente.idCliente "
				+ "left join tb_pessoaFisica "
				+ "on tb_cliente.idCliente = tb_pessoaFisica.idCliente "
				+ "left join tb_pessoaJuridica "
				+ "on tb_cliente.idCliente = tb_pessoaJuridica.idCliente "
				+ "inner join tb_carro "
				+	"on tb_ordemservico.idCliente = tb_carro.idCliente "
				+  "and tb_ordemservico.idCarro = tb_carro.idCarro "
				+ "where tb_pessoaFisica.nomeCliente like ? "
				+ "or tb_pessoaJuridica.nomeFantasiaCliente like ?"
				+ "order by tb_ordemServico.idOrdemServico desc";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, "%" + nome + "%");
			pstmt.setString(2, "%" + nome + "%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ordemServico = new OrdemServico();
				ordemServico.setIdOrdemServico(rs.getInt("idOrdemServico"));
				ordemServico.setValorTotal(rs.getDouble("valorTotalOrdemServico"));
				ordemServico.setDataAgendamento(rs.getDate("dataAgendamentoOrdemServico").toLocalDate());
				ordemServico.setDataAlteracao(rs.getDate("dataAlteracaoOrdemServico").toLocalDate());
				ordemServico.setStatusOSV(rs.getInt("statusOrdemServico"));
				Cliente cliente = new Cliente(rs.getInt("idCliente"), rs.getInt("tipoPessoa"), 
				rs.getString("telefoneComercialCliente"), rs.getString("telefoneResidencialCliente"), rs.getString("telefoneCelularCliente"));
				cliente.setPessoaFisica(new PessoaFisica(rs.getString("nomeCliente"), rs.getString("cpfCliente"), null));
				cliente.setPessoaJuridica(new PessoaJuridica(null, rs.getString("nomeFantasiaCliente"), rs.getString("cnpjCliente"), null, null));
				ordemServico.setCarro(new Carro(rs.getInt("idCarro"), rs.getString("nomeCarro"), rs.getString("placaCarro")));
				ordemServico.setCliente(cliente);
				ordensServicos.add(ordemServico);
			}
			if(ordemServico == null) {
				throw new RegistroNotExistente("Não foi possível encontrar nenhum registro "
						+ "para o conteúdo informado.\n"
						+ "Por gentileza, efetue uma nova pesquisa.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ordensServicos;
	}

	@Override
	public List<OrdemServico> todos() {
		List<OrdemServico> ordensServicos = new ArrayList<>();
		OrdemServico ordemServico = null;
		query = "select * from tb_ordemServico "
				+ "inner join tb_cliente "
				+ "on tb_ordemServico.idCliente = tb_cliente.idCliente "
				+ "left join tb_pessoaFisica "
				+ "on tb_cliente.idCliente = tb_pessoaFisica.idCliente "
				+ "left join tb_pessoaJuridica "
				+ "on tb_cliente.idCliente = tb_pessoaJuridica.idCliente "
				+ "inner join tb_carro "
				+	"on tb_ordemservico.idCliente = tb_carro.idCliente "
				+  "and tb_ordemservico.idCarro = tb_carro.idCarro "
				+ "order by tb_ordemServico.idOrdemServico desc";
		try {
			pstmt = connection.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ordemServico = new OrdemServico();
				ordemServico.setIdOrdemServico(rs.getInt("idOrdemServico"));
				ordemServico.setValorTotal(rs.getDouble("valorTotalOrdemServico"));
				ordemServico.setDataAgendamento(rs.getDate("dataAgendamentoOrdemServico").toLocalDate());
				ordemServico.setDataAlteracao(rs.getDate("dataAlteracaoOrdemServico").toLocalDate());
				ordemServico.setStatusOSV(rs.getInt("statusOrdemServico"));
				Cliente cliente = new Cliente(rs.getInt("idCliente"), rs.getInt("tipoPessoa"), 
				rs.getString("telefoneComercialCliente"), rs.getString("telefoneResidencialCliente"), rs.getString("telefoneCelularCliente"));
				cliente.setPessoaFisica(new PessoaFisica(rs.getString("nomeCliente"), rs.getString("cpfCliente"), null));
				cliente.setPessoaJuridica(new PessoaJuridica(null, rs.getString("nomeFantasiaCliente"), rs.getString("cnpjCliente"), null, null));
				ordemServico.setCarro(new Carro(rs.getInt("idCarro"), rs.getString("nomeCarro"), rs.getString("placaCarro")));
				ordemServico.setCliente(cliente);
				ordensServicos.add(ordemServico);
			}
			if(ordemServico == null) {
				throw new RegistroNotExistente("Não foi possível encontrar nenhum registro "
						+ "para o conteúdo informado.\n"
						+ "Por gentileza, efetue uma nova pesquisa.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ordensServicos;
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

	@Override
	public OrdemServico pesquisaPorPlaca(String placa) {
		OrdemServico ordemServico = null;
		query = "select * from tb_ordemServico "
				+ "inner join tb_cliente "
				+ "on tb_ordemServico.idCliente = tb_cliente.idCliente "
				+ "left join tb_pessoaFisica "
				+ "on tb_cliente.idCliente = tb_pessoaFisica.idCliente "
				+ "left join tb_pessoaJuridica "
				+ "on tb_cliente.idCliente = tb_pessoaJuridica.idCliente "
				+ "inner join tb_carro "
				+	"on tb_ordemservico.idCliente = tb_carro.idCliente "
				+  "and tb_ordemservico.idCarro = tb_carro.idCarro "
				+ "where tb_carro.placaCarro = ? "
				+ "order by tb_ordemServico.idOrdemServico desc";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, placa);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ordemServico = new OrdemServico();
				ordemServico.setIdOrdemServico(rs.getInt("idOrdemServico"));
				ordemServico.setValorTotal(rs.getDouble("valorTotalOrdemServico"));
				ordemServico.setDataAgendamento(rs.getDate("dataAgendamentoOrdemServico").toLocalDate());
				ordemServico.setDataAlteracao(rs.getDate("dataAlteracaoOrdemServico").toLocalDate());
				ordemServico.setStatusOSV(rs.getInt("statusOrdemServico"));
				Cliente cliente = new Cliente(rs.getInt("idCliente"), rs.getInt("tipoPessoa"), 
				rs.getString("telefoneComercialCliente"), rs.getString("telefoneResidencialCliente"), rs.getString("telefoneCelularCliente"));
				cliente.setPessoaFisica(new PessoaFisica(rs.getString("nomeCliente"), rs.getString("cpfCliente"), null));
				cliente.setPessoaJuridica(new PessoaJuridica(null, rs.getString("nomeFantasiaCliente"), rs.getString("cnpjCliente"), null, null));
				ordemServico.setCarro(new Carro(rs.getInt("idCarro"), rs.getString("nomeCarro"), rs.getString("placaCarro")));
				ordemServico.setCliente(cliente);
			}
			if(ordemServico == null) {
				throw new RegistroNotExistente("Não foi possível encontrar nenhum registro "
						+ "para o conteúdo informado.\n"
						+ "Por gentileza, efetue uma nova pesquisa.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ordemServico;
	}
}