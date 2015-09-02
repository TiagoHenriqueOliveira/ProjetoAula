package telas.washCar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JCheckBox;

public class UsuarioTela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnUsuario;
	private JTextField jtfPesquisaCodigoUsuario;
	private JTextField jtfPesquisaNomeUsuario;
	private JTextField jtfNome;
	private JTextField jtfLogin;
	private JPasswordField jpfSenha;
	private JPasswordField jpfConfirmarSenha;
	private JTextField jtfDataAlteracao;
	private JPanel jpnPesquisaUsuario;
	private JLabel jlbPesquisaCodigoUsuario;
	private JLabel jlbPesquisaNomeUsuario;
	private JButton jbtPesquisaUsuario;
	private JLabel jlbNome;
	private JLabel jlbLogin;
	private JLabel jtfSenha;
	private JLabel jlbConfirmarSenha;
	private JLabel jlbDataAlteracao;
	private JCheckBox jcbxUsuarioForaUso;
	private JButton jbtFechar;
	private JButton jbtCancelar;
	private JButton jbtEditar;
	private JButton jbtSalvar;
	private JButton jbtNovo;

	public void componentesTelaUsuario() {
		jpnPesquisaUsuario = new JPanel();
		jpnPesquisaUsuario.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnPesquisaUsuario.setBounds(10, 11, 424, 55);
		jpnUsuario.add(jpnPesquisaUsuario);
		jpnPesquisaUsuario.setLayout(null);
		
		jlbPesquisaCodigoUsuario = new JLabel("C\u00F3digo");
		jlbPesquisaCodigoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaCodigoUsuario.setBounds(10, 11, 46, 14);
		jpnPesquisaUsuario.add(jlbPesquisaCodigoUsuario);
		
		jtfPesquisaCodigoUsuario = new JTextField();
		jtfPesquisaCodigoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaCodigoUsuario.setColumns(10);
		jtfPesquisaCodigoUsuario.setBounds(10, 27, 66, 20);
		jpnPesquisaUsuario.add(jtfPesquisaCodigoUsuario);
		
		jlbPesquisaNomeUsuario = new JLabel("Nome do Usu\u00E1rio");
		jlbPesquisaNomeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaNomeUsuario.setBounds(86, 11, 100, 14);
		jpnPesquisaUsuario.add(jlbPesquisaNomeUsuario);
		
		jtfPesquisaNomeUsuario = new JTextField();
		jtfPesquisaNomeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaNomeUsuario.setColumns(10);
		jtfPesquisaNomeUsuario.setBounds(86, 27, 275, 20);
		jpnPesquisaUsuario.add(jtfPesquisaNomeUsuario);
		
		jbtPesquisaUsuario = new JButton("");
		jbtPesquisaUsuario.setIcon(new ImageIcon(UsuarioTela.class.getResource("/Imagens/lupaPesquisa.jpeg")));
		jbtPesquisaUsuario.setBounds(367, 16, 40, 32);
		jpnPesquisaUsuario.add(jbtPesquisaUsuario);
		
		jtfNome = new JTextField();
		jtfNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNome.setColumns(10);
		jtfNome.setBounds(10, 93, 275, 20);
		jpnUsuario.add(jtfNome);
		
		jlbNome = new JLabel("Nome do Usu\u00E1rio");
		jlbNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNome.setBounds(10, 77, 100, 14);
		jpnUsuario.add(jlbNome);
		
		jtfLogin = new JTextField();
		jtfLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfLogin.setColumns(10);
		jtfLogin.setBounds(10, 140, 275, 20);
		jpnUsuario.add(jtfLogin);
		
		jlbLogin = new JLabel("Login do Usu\u00E1rio");
		jlbLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbLogin.setBounds(10, 124, 100, 14);
		jpnUsuario.add(jlbLogin);
		
		jtfSenha = new JLabel("Senha do Usu\u00E1rio");
		jtfSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfSenha.setBounds(10, 171, 100, 14);
		jpnUsuario.add(jtfSenha);
		
		jpfSenha = new JPasswordField();
		jpfSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jpfSenha.setBounds(10, 186, 182, 20);
		jpnUsuario.add(jpfSenha);
		
		jlbConfirmarSenha = new JLabel("Confirmar Senha do Usu\u00E1rio");
		jlbConfirmarSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbConfirmarSenha.setBounds(10, 217, 170, 14);
		jpnUsuario.add(jlbConfirmarSenha);
		
		jpfConfirmarSenha = new JPasswordField();
		jpfConfirmarSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jpfConfirmarSenha.setBounds(10, 232, 182, 20);
		jpnUsuario.add(jpfConfirmarSenha);
		
		jlbDataAlteracao = new JLabel("Data Altera\u00E7\u00E3o");
		jlbDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataAlteracao.setBounds(336, 246, 98, 14);
		jpnUsuario.add(jlbDataAlteracao);
		
		jtfDataAlteracao = new JTextField();
		jtfDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfDataAlteracao.setEditable(false);
		jtfDataAlteracao.setColumns(10);
		jtfDataAlteracao.setBackground(Color.YELLOW);
		jtfDataAlteracao.setBounds(336, 262, 98, 20);
		jpnUsuario.add(jtfDataAlteracao);
		
		jcbxUsuarioForaUso = new JCheckBox("Usu\u00E1rio Fora de Uso");
		jcbxUsuarioForaUso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jcbxUsuarioForaUso.setBounds(10, 259, 140, 23);
		jpnUsuario.add(jcbxUsuarioForaUso);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setToolTipText("");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setBounds(359, 288, 75, 23);
		jpnUsuario.add(jbtFechar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setBounds(270, 288, 78, 23);
		jpnUsuario.add(jbtCancelar);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setBounds(183, 288, 75, 23);
		jpnUsuario.add(jbtEditar);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(97, 288, 75, 23);
		jpnUsuario.add(jbtSalvar);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 288, 75, 23);
		jpnUsuario.add(jbtNovo);
	}

	public UsuarioTela() {
		setTitle("Cadastro de Usuários | WashCar");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		jpnUsuario = new JPanel();
		jpnUsuario.setLayout(null);
		setLocationRelativeTo(null);
		setContentPane(jpnUsuario);
		
		componentesTelaUsuario();
		
	}
}