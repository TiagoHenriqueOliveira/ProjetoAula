package dao.WashCar;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoUtil;
import model.WashCar.Usuario;

public class UsuarioDAOJDBC implements UsuarioDAO{
	
	private Connection con;
	
	public UsuarioDAOJDBC() {
		con = ConexaoUtil.getCon();
	}

	@SuppressWarnings("static-access")
	@Override
	public void inserir(Usuario usuario) {
		String sql = "inser into usuario(nomeUsuario, loginUsuario, senhaUsuario"
							+"dataInclusao, dataAlteracao, EMPRESA, foraUso)"
							+ "values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getLogin());
			pstmt.setString(3, usuario.getSenha());
			pstmt.setString(4, usuario.getSenha());
			pstmt.setDate(5, Date.valueOf(usuario.getDataInclusao().now()));
			pstmt.setDate(6, Date.valueOf(usuario.getDataAltercacao().now()));
			pstmt.setInt(7, Integer.valueOf(usuario.getEmpresa().getIdEmpresa()));
			pstmt.setBoolean(8, usuario.isForaUso());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public void alterar(Usuario usuario) {
		String sql = "update usuario"
							+ "set nomeUsuario = ?, loginUsuario = ?, senhaUsuario = ?"
							+ "dataAlteracao = ?, foraUso = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getLogin());
			pstmt.setString(3, usuario.getSenha());
			pstmt.setDate(4, Date.valueOf(usuario.getDataAltercacao().now()));
			pstmt.setBoolean(5, usuario.isForaUso());
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
		String sql = "select * from usuario u"
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	@Override
	public Usuario buscarDescricao(String nome) {
		Usuario usuario = null;
		String sql = "select * from usuario u"
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
		String sql = "select * from usuario";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("idCadastroUsuario"));
				usuario.setNome(rs.getString("nomeUsuario"));
				usuario.setLogin(rs.getString("loginUsuario"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
}