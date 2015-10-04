package forms.WashCar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import validacaoCampos.WashCar.ValidaCampoString;
import model.WashCar.Usuario;
import conexao.ConexaoUtil;
import dao.WashCar.UsuarioDAOJDBC;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Toolkit;

public class LoginForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnLogin;
	private JTextField jtfLoginUsuario;
	private JPasswordField jpfSenhaUsuario;
	private JLabel jlbLogo;
	private JLabel jlbLoginUsuario;
	private JLabel jlbSenhaUsuario;
	private JButton jbtLogin;
	private JButton jbtSair;
	private Usuario usuario;
	private static PrincipalForm principal;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		LoginForm login = new LoginForm();
		login.show();
	}
	
	public void componentesTelaLogin() {
		jlbLogo = new JLabel("");
		jlbLogo.setIcon(new ImageIcon(LoginForm.class.getResource("/Imagens/washCar.jpeg")));
		jlbLogo.setBounds(10, 11, 262, 206);
		jpnLogin.add(jlbLogo);
		
		jlbLoginUsuario = new JLabel("Login do Usuário");
		jlbLoginUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbLoginUsuario.setBounds(10, 228, 187, 14);
		jpnLogin.add(jlbLoginUsuario);
		
		jtfLoginUsuario = new JTextField();
		jtfLoginUsuario.setDocument(new ValidaCampoString());
		jtfLoginUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfLoginUsuario.setBounds(10, 253, 187, 20);
		jpnLogin.add(jtfLoginUsuario);
		jtfLoginUsuario.setColumns(10);
		
		jlbSenhaUsuario = new JLabel("Senha do Usu\u00E1rio");
		jlbSenhaUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbSenhaUsuario.setBounds(10, 284, 187, 14);
		jpnLogin.add(jlbSenhaUsuario);
		
		jpfSenhaUsuario = new JPasswordField();
		jpfSenhaUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jpfSenhaUsuario.setBounds(10, 309, 187, 20);
		jpnLogin.add(jpfSenhaUsuario);
		
		jbtLogin = new JButton("Entrar no Sistema");
		jbtLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtLogin.setBounds(10, 340, 150, 23);
		jpnLogin.add(jbtLogin);
		
		jbtSair = new JButton("Sair do Sistema");
		jbtSair.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSair.setBounds(10, 374, 150, 23);
		jpnLogin.add(jbtSair);
	}

	@SuppressWarnings({ "deprecation" })
	public void acesso(Usuario usuario) {
		UsuarioDAOJDBC usuarioDAOJDBC = new UsuarioDAOJDBC();
		usuario = usuarioDAOJDBC.login(jtfLoginUsuario.getText(), jpfSenhaUsuario.getText());
		if(usuario != null && !usuario.isForaUso()) {
			principal = new PrincipalForm();
			principal.show();
			dispose();
		} else {
			JOptionPane.showMessageDialog(null, "Usuario ou senha estão incorretos!!!\n"
			+ "Se o problema persistir, entre em contato com o Administrador!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfLoginUsuario.setText("");
			jpfSenhaUsuario.setText("");
			jtfLoginUsuario.requestFocus();
		}
	}	
	/*
	 * Usuario: ADMIN
	 * Senha: 452758
	 */
	public LoginForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginForm.class.getResource("/Imagens/washCar.jpeg")));
		setTitle("Login | WashCar");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 245, 438);
		setLocationRelativeTo(null);
		jpnLogin = new JPanel();
		jpnLogin.setBorder(new EmptyBorder(0, 0, 0, 0));
		jpnLogin.setLayout(null);
		setContentPane(jpnLogin);
		
		componentesTelaLogin();
		
		jbtLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//acesso(usuario);
				principal = new PrincipalForm();
				principal.show();
				dispose();
			}
		});
		
		jbtSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});		
	}
}