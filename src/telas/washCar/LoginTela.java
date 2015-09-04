package telas.washCar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LoginTela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnLogin;
	private JTextField jtfLoginUsuario;
	private JPasswordField jpfSenhaUsuario;

	public static void main(String[] args) {
		LoginTela login = new LoginTela();
		login.setVisible(true);
	}

	public LoginTela() {
		setTitle("Login | WashCar");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 245, 438);
		jpnLogin = new JPanel();
		jpnLogin.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(jpnLogin);
		setLocationRelativeTo(null);
		jpnLogin.setLayout(null);
		
		JLabel jlbLogo = new JLabel("");
		jlbLogo.setIcon(new ImageIcon(LoginTela.class.getResource("/Imagens/washCar.jpeg")));
		jlbLogo.setBounds(10, 11, 262, 206);
		jpnLogin.add(jlbLogo);
		
		JLabel lblLoginDoUsurio = new JLabel("Login do Usu\u00E1rio");
		lblLoginDoUsurio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoginDoUsurio.setBounds(10, 228, 187, 14);
		jpnLogin.add(lblLoginDoUsurio);
		
		jtfLoginUsuario = new JTextField();
		jtfLoginUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfLoginUsuario.setBounds(10, 253, 187, 20);
		jpnLogin.add(jtfLoginUsuario);
		jtfLoginUsuario.setColumns(10);
		
		JLabel jlbSenhaUsuario = new JLabel("Senha do Usu\u00E1rio");
		jlbSenhaUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbSenhaUsuario.setBounds(10, 284, 187, 14);
		jpnLogin.add(jlbSenhaUsuario);
		
		jpfSenhaUsuario = new JPasswordField();
		jpfSenhaUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jpfSenhaUsuario.setBounds(10, 309, 187, 20);
		jpnLogin.add(jpfSenhaUsuario);
		
		JButton jbtLogin = new JButton("Entrar no Sistema");
		jbtLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtLogin.setBounds(10, 340, 150, 23);
		jpnLogin.add(jbtLogin);
		
		JButton jbtSair = new JButton("Sair do Sistema");
		jbtSair.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSair.setBounds(10, 374, 150, 23);
		jpnLogin.add(jbtSair);
	}
}