package forms.WashCar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.AWTKeyStroke;
import java.awt.Font;
import java.awt.KeyboardFocusManager;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import validacaoCampos.WashCar.ValidaCampoString;
import model.WashCar.Usuario;
import dao.WashCar.UsuarioDAOJDBC;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.awt.event.ActionEvent;
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		LoginForm login = new LoginForm();
		login.setVisible(true);
		HashSet conj = new HashSet(login.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS)); 
		conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0)); 
		login.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);
	}
	
	public void componentesTelaLogin() {
		jlbLogo = new JLabel("");
		jlbLogo.setIcon(new ImageIcon(LoginForm.class.getResource("/Imagens/washCar.jpeg")));
		jlbLogo.setBounds(10, 11, 262, 206);
		jpnLogin.add(jlbLogo);
		
		jlbLoginUsuario = new JLabel("Login do Usuário");
		jlbLoginUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbLoginUsuario.setBounds(282, 11, 187, 14);
		jpnLogin.add(jlbLoginUsuario);
		
		jtfLoginUsuario = new JTextField();
		jtfLoginUsuario.setDocument(new ValidaCampoString());
		jtfLoginUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfLoginUsuario.setBounds(282, 36, 187, 20);
		jpnLogin.add(jtfLoginUsuario);
		jtfLoginUsuario.setColumns(10);
		
		jlbSenhaUsuario = new JLabel("Senha do Usu\u00E1rio");
		jlbSenhaUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbSenhaUsuario.setBounds(282, 67, 187, 14);
		jpnLogin.add(jlbSenhaUsuario);
		
		jpfSenhaUsuario = new JPasswordField();
		jpfSenhaUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jpfSenhaUsuario.setBounds(282, 92, 187, 20);
		jpnLogin.add(jpfSenhaUsuario);
		
		jbtLogin = new JButton("Entrar no Sistema");
		jbtLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtLogin.setBounds(282, 123, 187, 25);
		jpnLogin.add(jbtLogin);
		
		jbtSair = new JButton("Sair do Sistema");
		jbtSair.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSair.setBounds(282, 157, 187, 25);
		jpnLogin.add(jbtSair);
	}
	
	@SuppressWarnings({ "deprecation" })
	public void acesso(Usuario usuario) {
		UsuarioDAOJDBC usuarioDAOJDBC = new UsuarioDAOJDBC();
		usuario = usuarioDAOJDBC.login(jtfLoginUsuario.getText(), jpfSenhaUsuario.getText());
		if(usuario != null && !usuario.isForaUso()) {
			principal = new PrincipalForm();
			principal.setVisible(true);;
			dispose();
		} else {
			JOptionPane.showMessageDialog(null, "Usuario ou senha estão incorretos!!!\n"
			+ "Se o problema persistir, entre em contato com o Administrador!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfLoginUsuario.setText("");
			jpfSenhaUsuario.setText("");
			jtfLoginUsuario.requestFocus();
		}
	}
	
	public void acoesDosBotoes() {
		jbtLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//acesso(usuario);
				principal = new PrincipalForm();
				principal.setVisible(true);
				dispose();
			}
		});
		
		jbtSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});	
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
		setBounds(100, 100, 492, 268);
		setLocationRelativeTo(null);
		jpnLogin = new JPanel();
		jpnLogin.setBorder(new EmptyBorder(0, 0, 0, 0));
		jpnLogin.setLayout(null);
		setContentPane(jpnLogin);
		
		componentesTelaLogin();
		acoesDosBotoes();
	}
}