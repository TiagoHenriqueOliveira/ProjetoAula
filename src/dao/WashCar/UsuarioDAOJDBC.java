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
import model.WashCar.Usuario;

public class UsuarioDAOJDBC implements UsuarioDAO{
	
	private Connection con;
	private String sql;
	
	public UsuarioDAOJDBC() {
		con = ConexaoUtil.getCon();
	}

	@SuppressWarnings("static-access")
	@Override
	public void inserir(Usuario usuario) {
		sql = "insert into usuario(nomeUsuario, loginUsuario, senhaUsuario, "
							+"dataAlteracao, empresa, foraUso)"
							+ "values(?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getLogin());
			pstmt.setString(3, usuario.getSenha());
			pstmt.setDate(4, Date.valueOf(usuario.getDataAltercacao().now()));
			pstmt.setInt(5,  usuario.getEmpresa().getIdEmpresa());
			pstmt.setBoolean(6, usuario.isForaUso());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public void alterar(Usuario usuario) {
		sql = "update usuario u"
				+ "set u.nomeUsuario = ?, u.loginUsuario = ?, u.senhaUsuario = ?"
				+ "u.dataAlteracao = ?, u.foraUso = ?"
				+ "where u.idCadastroUsuario =  ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getLogin());
			pstmt.setString(3, usuario.getSenha());
			pstmt.setDate(4, Date.valueOf(usuario.getDataAltercacao().now()));
			pstmt.setBoolean(5, usuario.isForaUso());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(Usuario usuario) {
	}

	@Override
	public Usuario buscarId(Integer id) {
		Usuario usuario = null;
		sql = "select * from usuario u"
							+ "where u.idCadastroUsuario = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("idCadastroUsuario"));
				usuario.setNome(rs.getString("nomeUsuario"));
				usuario.setLogin(rs.getString("loginUsuario"));
				usuario.setSenha(rs.getString("senhaUsuario"));
				usuario.setDataAltercacao(rs.getDate("dataAlteracao").toLocalDate());
				usuario.setForaUso(Boolean.valueOf(rs.getBoolean("foraUso")));
				usuario.setEmpresa(new Empresa(rs.getInt("empresa")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	@Override
	public Usuario buscarDescricao(String nome) {
		Usuario usuario = null;
		sql = "select * from usuario u"
							+ "where u.nomeUsuario like ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nome);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("idCadastroUsuario"));
				usuario.setNome(rs.getString("nomeUsuario"));
				usuario.setLogin(rs.getString("loginUsuario"));
				usuario.setSenha(rs.getString("senhaUsuario"));
				usuario.setDataAltercacao(rs.getDate("dataAlteracao").toLocalDate());
				usuario.setForaUso(Boolean.valueOf(rs.getBoolean("foraUso")));
				usuario.setEmpresa(new Empresa(rs.getInt("empresa")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	@Override
	public Usuario buscarDocumento(String codDocumento) {
		return null;
	}

	@Override
	public List<Usuario> todos() {
		List<Usuario> usuarios = new ArrayList<>();
		sql = "select * from usuario";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("idCadastroUsuario"));
				usuario.setNome(rs.getString("nomeUsuario"));
				usuario.setLogin(rs.getString("loginUsuario"));
				usuario.setSenha(rs.getString("senhaUsuario"));
				usuario.setDataAltercacao(rs.getDate("dataAlteracao").toLocalDate());
				usuario.setForaUso(Boolean.valueOf(rs.getBoolean("foraUso")));
				usuario.setEmpresa(new Empresa(rs.getInt("empresa")));
				usuarios.add(usuario);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
}