package dao.WashCar;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoUtil;
import model.WashCar.Empresa;

public class EmpresaDAOJDBC implements EmpresaDAO{

	private Connection con;
	private String sql;
	
	public EmpresaDAOJDBC() {
		con = ConexaoUtil.openConnection();
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void inserir(Empresa empresa) {
		sql = "insert into empresa("
				+ "razaoSocial, nomeFantasia, cnpj, inscricaoEstadual,"
				+ "endereco, bairro, numero, telefoneComercial, telefoneCelular,"
				+ "fax, regimeTributario, dataAlteracao, cidade, inscricaoMunicipal)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empresa.getRazaoSocial());
			pstmt.setString(2, empresa.getNomeFantasia());
			pstmt.setString(3, empresa.getCnpj());
			pstmt.setString(4, empresa.getInscricaoEstadual());
			pstmt.setString(5, empresa.getEndereco());
			pstmt.setString(6, empresa.getBairro());
			pstmt.setInt(7, empresa.getNumero());
			pstmt.setString(8, empresa.getTelefoneComercial());
			pstmt.setString(9, empresa.getTelefoneCelular());
			pstmt.setString(10, empresa.getFax());
			pstmt.setString(11, empresa.getRegimeTributario());
			pstmt.setDate(12, Date.valueOf(empresa.getDataAltercacao().now()));
			pstmt.setInt(13, empresa.getCidade().getIdCidade());
			pstmt.setString(14, empresa.getInscricaoMunicipal());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public void alterar(Empresa empresa) {
		sql = "update empresa"
				+ "set razaoSocial = ?, nomeFantasia = ?, cnpj = ?, inscricaoEstadual = ?,"
				+ "endereco = ?, bairro = ?, numero = ?, telefoneComercial = ?, telefoneCelular = ?,"
				+ "fax = ?, regimeTributario = ?, dataAlteracao = ?, inscricaoMunicipal = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empresa.getRazaoSocial());
			pstmt.setString(2, empresa.getNomeFantasia());
			pstmt.setString(3, empresa.getCnpj());
			pstmt.setString(4, empresa.getInscricaoEstadual());
			pstmt.setString(5, empresa.getEndereco());
			pstmt.setString(6, empresa.getBairro());
			pstmt.setInt(7, empresa.getNumero());
			pstmt.setString(8, empresa.getTelefoneComercial());
			pstmt.setString(9, empresa.getTelefoneCelular());
			pstmt.setString(10, empresa.getFax());
			pstmt.setString(11, empresa.getRegimeTributario());
			pstmt.setDate(12, Date.valueOf(empresa.getDataAltercacao().now()));
			pstmt.setString(13, empresa.getInscricaoMunicipal());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(Empresa emprea) {
		// TODO Auto-generated method stub
	}

	@Override
	public Empresa buscarId(Integer id) {
		Empresa empresa = null;
		sql = "select * from empresa e"
				+ "where e.idEmpresa = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				empresa = new Empresa();
				empresa.setIdEmpresa(rs.getInt("idEmpresa"));
				empresa.setRazaoSocial(rs.getString("razaoSocial"));
				empresa.setNomeFantasia(rs.getString("nomeFantasia"));
				empresa.setCnpj(rs.getString("cnpj"));
				empresa.setInscricaoEstadual(rs.getString("inscricaoEstadual"));
				empresa.setEndereco(rs.getString("endereco"));
				empresa.setBairro(rs.getString("bairro"));
				empresa.setNumero(rs.getInt("numero"));
				empresa.setTelefoneComercial(rs.getString("telefoneComercial"));
				empresa.setTelefoneCelular(rs.getString("telefoneCelular"));
				empresa.setFax(rs.getString("fax"));
				empresa.setRegimeTributario(rs.getString("regimeTributario"));
				empresa.setInscricaoMunicipal(rs.getString("inscricaoMunicipal"));
				empresa.setDataAltercacao(rs.getDate("dataAlteracao").toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empresa;
	}

	@Override
	public Empresa buscarDescricao(String descricao) {
		Empresa empresa = null;
		sql = "select * from empresa e"
				+ "where e.razaoSocial like ?"
				+ "or e.nomeFantasia like ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, descricao);
			pstmt.setString(2, descricao);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				empresa = new Empresa();
				empresa.setIdEmpresa(rs.getInt("idEmpresa"));
				empresa.setRazaoSocial(rs.getString("razaoSocial"));
				empresa.setNomeFantasia(rs.getString("nomeFantasia"));
				empresa.setCnpj(rs.getString("cnpj"));
				empresa.setInscricaoEstadual(rs.getString("inscricaoEstadual"));
				empresa.setEndereco(rs.getString("endereco"));
				empresa.setBairro(rs.getString("bairro"));
				empresa.setNumero(rs.getInt("numero"));
				empresa.setTelefoneComercial(rs.getString("telefoneComercial"));
				empresa.setTelefoneCelular(rs.getString("telefoneCelular"));
				empresa.setFax(rs.getString("fax"));
				empresa.setRegimeTributario(rs.getString("regimeTributario"));
				empresa.setInscricaoMunicipal(rs.getString("inscricaoMunicipal"));
				empresa.setDataAltercacao(rs.getDate("dataAlteracao").toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empresa;
	}

	@Override
	public void buscarDocumento(String codDocumento) {
		Empresa empresa = null;
		sql = "select * from empresa e"
				+ "where e.cnpj = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, codDocumento);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				empresa = new Empresa();
				empresa.setIdEmpresa(rs.getInt("idEmpresa"));
				empresa.setRazaoSocial(rs.getString("razaoSocial"));
				empresa.setNomeFantasia(rs.getString("nomeFantasia"));
				empresa.setCnpj(rs.getString("cnpj"));
				empresa.setInscricaoEstadual(rs.getString("inscricaoEstadual"));
				empresa.setEndereco(rs.getString("endereco"));
				empresa.setBairro(rs.getString("bairro"));
				empresa.setNumero(rs.getInt("numero"));
				empresa.setTelefoneComercial(rs.getString("telefoneComercial"));
				empresa.setTelefoneCelular(rs.getString("telefoneCelular"));
				empresa.setFax(rs.getString("fax"));
				empresa.setRegimeTributario(rs.getString("regimeTributario"));
				empresa.setInscricaoMunicipal(rs.getString("inscricaoMunicipal"));
				empresa.setDataAltercacao(rs.getDate("dataAlteracao").toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}

	@Override
	public List<Empresa> todos() {
		List<Empresa> empresas = new ArrayList<Empresa>();
		sql = "select * from empresa";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Empresa empresa = new Empresa();
				empresa.setIdEmpresa(rs.getInt("idEmpresa"));
				empresa.setRazaoSocial(rs.getString("razaoSocial"));
				empresa.setNomeFantasia(rs.getString("nomeFantasia"));
				empresa.setCnpj(rs.getString("cnpj"));
				empresa.setInscricaoEstadual(rs.getString("inscricaoEstadual"));
				empresas.add(empresa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empresas;
	}	
}