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
	
	private Connection connection;
	private String sql;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UsuarioDAOJDBC() {
		connection = ConexaoUtil.openConnection();
	}

	@SuppressWarnings({ "static-access"})
	@Override
	public void inserir(Usuario usuario) throws Exception {
		sql = "insert into tb_usuario(nomeUsuario, loginUsuario, senhaUsuario, dataAlteracaoUsuario, idEmpresa, usuarioForaUso)"
				+ "values(?,?,?,?,?,?)";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getLogin());
			pstmt.setString(3, usuario.getSenha());
			pstmt.setDate(4, Date.valueOf(usuario.getDataAltercacao().now()));
			pstmt.setInt(5,  usuario.getEmpresa().getIdEmpresa());
			pstmt.setBoolean(6, usuario.isForaUso());
			pstmt.executeUpdate();
			usuario.setIdUsuario(obterUltimoID(pstmt, rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public void alterar(Usuario usuario) throws Exception{
		sql = "update tb_usuario "
				+"set tb_usuario.nomeUsuario = ?, tb_usuario.loginUsuario = ?, tb_usuario.senhaUsuario = ?, tb_usuario.dataAlteracaoUsuario = ?, tb_usuario.usuarioForaUso = ? "
				+"where tb_usuario.idUsuario = ?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getLogin());
			pstmt.setString(3, usuario.getSenha());
			pstmt.setDate(4, Date.valueOf(usuario.getDataAltercacao().now()));
			pstmt.setBoolean(5, usuario.isForaUso());
			pstmt.setInt(6, usuario.getIdUsuario());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(Usuario usuario) throws Exception{
		// TODO Auto-generated method stub
	}

	@Override
	public Usuario buscarId(Integer id) {
		Usuario usuario = null;
		sql = "select * from tb_usuario "
				+ "where tb_usuario.idUsuario = ?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("idUsuario"));
				usuario.setNome(rs.getString("nomeUsuario"));
				usuario.setLogin(rs.getString("loginUsuario"));
				usuario.setSenha(rs.getString("senhaUsuario"));
				usuario.setDataAltercacao(rs.getDate("dataAlteracaoUsuario").toLocalDate());
				usuario.setForaUso(Boolean.valueOf(rs.getBoolean("usuarioForaUso")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	@Override
	public List<Usuario> buscarDescricao(String nome) {
		List<Usuario> usuarios = new ArrayList<>();
		sql = "select * from tb_usuario "
				+ "where tb_usuario.nomeUsuario like ?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, "%" + nome + "%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("idUsuario"));
				usuario.setNome(rs.getString("nomeUsuario"));
				usuario.setLogin(rs.getString("loginUsuario"));
				usuario.setSenha(rs.getString("senhaUsuario"));
				usuario.setDataAltercacao(rs.getDate("dataAlteracaoUsuario").toLocalDate());
				usuario.setForaUso(Boolean.valueOf(rs.getBoolean("usuarioForaUso")));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	@Override
	public List<Usuario> todos() {
		List<Usuario> usuarios = new ArrayList<>();
		sql = "select * from tb_usuario";
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("idUsuario"));
				usuario.setNome(rs.getString("nomeUsuario"));
				usuario.setLogin(rs.getString("loginUsuario"));
				usuario.setSenha(rs.getString("senhaUsuario"));
				usuario.setDataAltercacao(rs.getDate("dataAlteracaoUsuario").toLocalDate());
				usuario.setForaUso(Boolean.valueOf(rs.getBoolean("usuarioForaUso")));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	@Override
	public Usuario login(String login, String senha) {
		Usuario usuario = null;
		sql = "select * from tb_usuario "
				+ "where tb_usuario.loginUsuario = ? "
				+ "and tb_usuario.senhaUsuario = ?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, login);
			pstmt.setString(2, senha);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				usuario = new Usuario();
				usuario.setLogin(rs.getString("loginUsuario"));
				usuario.setSenha(rs.getString("senhaUsuario"));
				usuario.setForaUso(Boolean.valueOf(rs.getBoolean("usuarioForaUso")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	@Override
	public Integer obterUltimoID(PreparedStatement pstmt, ResultSet rs) throws Exception {
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