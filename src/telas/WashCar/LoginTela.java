package telas.WashCar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginTela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnLogin;
	private JTextField jtfLoginUsuario;
	private JPasswordField jpfSenhaUsuario;
	private JLabel jlbLogo;
	private JLabel lblLoginDoUsurio;
	private JLabel jlbSenhaUsuario;
	private JButton jbtLogin;
	private JButton jbtSair;	
	
	public void componentesTelaLogin() {
		jlbLogo = new JLabel("");
		jlbLogo.setIcon(new ImageIcon(LoginTela.class.getResource("/Imagens/washCar.jpeg")));
		jlbLogo.setBounds(10, 11, 262, 206);
		jpnLogin.add(jlbLogo);
		
		lblLoginDoUsurio = new JLabel("Login do Usu\u00E1rio");
		lblLoginDoUsurio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoginDoUsurio.setBounds(10, 228, 187, 14);
		jpnLogin.add(lblLoginDoUsurio);
		
		jtfLoginUsuario = new JTextField();
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
		
		componentesTelaLogin();
		
		jbtLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrincipalTela principal = new PrincipalTela();
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
}