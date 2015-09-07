package telas.WashCar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

import java.awt.Color;

import javax.swing.JCheckBox;

import validacaoCampos.WashCar.ValidaCampoNumeroInteiro;
import validacaoCampos.WashCar.ValidaCampoString;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UsuarioTela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnUsuario;
	private JTextField jtfPesquisaCodigoUsuario;
	private JTextField jtfPesquisaNomeUsuario;
	private JTextField jtfNome;
	private JTextField jtfLogin;
	private JPasswordField jpfSenha;
	private JTextField jtfDataAlteracao;
	private JPanel jpnPesquisaUsuario;
	private JLabel jlbPesquisaCodigoUsuario;
	private JLabel jlbPesquisaNomeUsuario;
	private JButton jbtPesquisaUsuario;
	private JLabel jlbNome;
	private JLabel jlbLogin;
	private JLabel jlbSenha;
	private JLabel jlbDataAlteracao;
	private JCheckBox jcbxUsuarioForaUso;
	private JButton jbtFechar;
	private JButton jbtCancelar;
	private JButton jbtEditar;
	private JButton jbtSalvar;
	private JButton jbtNovo;
	private JLabel jlbConsultaUsuario;

	public void componentesTelaUsuario() {
		jpnPesquisaUsuario = new JPanel();
		jpnPesquisaUsuario.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnPesquisaUsuario.setBounds(10, 11, 424, 81);
		jpnUsuario.add(jpnPesquisaUsuario);
		jpnPesquisaUsuario.setLayout(null);
		
		jlbPesquisaCodigoUsuario = new JLabel("C\u00F3digo");
		jlbPesquisaCodigoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaCodigoUsuario.setBounds(10, 33, 46, 14);
		jpnPesquisaUsuario.add(jlbPesquisaCodigoUsuario);
		
		jtfPesquisaCodigoUsuario = new JTextField();
		jtfPesquisaCodigoUsuario.setDocument(new ValidaCampoNumeroInteiro());
		jtfPesquisaCodigoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaCodigoUsuario.setColumns(10);
		jtfPesquisaCodigoUsuario.setBounds(10, 49, 66, 20);
		jpnPesquisaUsuario.add(jtfPesquisaCodigoUsuario);
		
		jlbPesquisaNomeUsuario = new JLabel("Nome do Usu\u00E1rio");
		jlbPesquisaNomeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaNomeUsuario.setBounds(86, 33, 100, 14);
		jpnPesquisaUsuario.add(jlbPesquisaNomeUsuario);
		
		jtfPesquisaNomeUsuario = new JTextField();
		jtfPesquisaNomeUsuario.setDocument(new ValidaCampoString());
		jtfPesquisaNomeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaNomeUsuario.setColumns(10);
		jtfPesquisaNomeUsuario.setBounds(86, 49, 275, 20);
		jpnPesquisaUsuario.add(jtfPesquisaNomeUsuario);
		
		jbtPesquisaUsuario = new JButton("");
		jbtPesquisaUsuario.setIcon(new ImageIcon(UsuarioTela.class.getResource("/Imagens/lupaPesquisa.jpeg")));
		jbtPesquisaUsuario.setBounds(367, 38, 40, 32);
		jpnPesquisaUsuario.add(jbtPesquisaUsuario);
		
		jlbConsultaUsuario = new JLabel("Consulta de Usu\u00E1rios");
		jlbConsultaUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbConsultaUsuario.setBounds(10, 8, 143, 14);
		jpnPesquisaUsuario.add(jlbConsultaUsuario);
		
		jtfNome = new JTextField();
		jtfNome.setDocument(new ValidaCampoString());
		jtfNome.setEnabled(false);
		jtfNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNome.setColumns(10);
		jtfNome.setBounds(10, 119, 275, 20);
		jpnUsuario.add(jtfNome);
		
		jlbNome = new JLabel("Nome do Usu\u00E1rio");
		jlbNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNome.setBounds(10, 103, 100, 14);
		jpnUsuario.add(jlbNome);
		
		jtfLogin = new JTextField();
		jtfLogin.setDocument(new ValidaCampoString());
		jtfLogin.setEnabled(false);
		jtfLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfLogin.setColumns(10);
		jtfLogin.setBounds(10, 166, 275, 20);
		jpnUsuario.add(jtfLogin);
		
		jlbLogin = new JLabel("Login do Usu\u00E1rio");
		jlbLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbLogin.setBounds(10, 150, 100, 14);
		jpnUsuario.add(jlbLogin);
		
		jlbSenha = new JLabel("Senha do Usu\u00E1rio");
		jlbSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbSenha.setBounds(10, 197, 100, 14);
		jpnUsuario.add(jlbSenha);
		
		jpfSenha = new JPasswordField();
		jpfSenha.setEnabled(false);
		jpfSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jpfSenha.setBounds(10, 212, 182, 20);
		jpnUsuario.add(jpfSenha);
		
		jlbDataAlteracao = new JLabel("Data Altera\u00E7\u00E3o");
		jlbDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataAlteracao.setBounds(336, 266, 98, 14);
		jpnUsuario.add(jlbDataAlteracao);
		
		try {
			jtfDataAlteracao = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfDataAlteracao.setEditable(false);
		jtfDataAlteracao.setColumns(10);
		jtfDataAlteracao.setBackground(Color.YELLOW);
		jtfDataAlteracao.setBounds(336, 282, 98, 20);
		jpnUsuario.add(jtfDataAlteracao);
		
		jcbxUsuarioForaUso = new JCheckBox("Usu\u00E1rio Fora de Uso");
		jcbxUsuarioForaUso.setEnabled(false);
		jcbxUsuarioForaUso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jcbxUsuarioForaUso.setBounds(10, 279, 140, 23);
		jpnUsuario.add(jcbxUsuarioForaUso);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setToolTipText("");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setBounds(359, 314, 75, 23);
		jpnUsuario.add(jbtFechar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setEnabled(false);
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setBounds(269, 314, 81, 23);
		jpnUsuario.add(jbtCancelar);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setEnabled(false);
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setBounds(183, 314, 75, 23);
		jpnUsuario.add(jbtEditar);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setEnabled(false);
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(97, 314, 75, 23);
		jpnUsuario.add(jbtSalvar);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 314, 75, 23);
		jpnUsuario.add(jbtNovo);
	}
	
	public void novoCadastro() {
		jbtNovo.setEnabled(false);
		jtfNome.setEnabled(true);
		jtfLogin.setEnabled(true);
		jpfSenha.setEnabled(true);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
	}
	
	public void salvarCadastro() {
		
	}
	
	public void editarCadastro() {
		
	}
	
	public void cancelarCadastro() {
		jbtNovo.setEnabled(true);
		jtfNome.setEnabled(false);
		jtfLogin.setEnabled(false);
		jpfSenha.setEnabled(false);
		jtfNome.setText("");
		jtfLogin.setText("");
		jpfSenha.setText("");
		jbtSalvar.setEnabled(false);
		jbtCancelar.setEnabled(false);
	}

	public UsuarioTela() {
		setTitle("Cadastro de Usuários | WashCar");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 376);
		jpnUsuario = new JPanel();
		jpnUsuario.setLayout(null);
		setLocationRelativeTo(null);
		setContentPane(jpnUsuario);
		
		componentesTelaUsuario();
		
		jbtNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtNovo) {
					novoCadastro();
				}
			}
		});
		
		jbtSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		jbtEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		jbtCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtCancelar) {
					cancelarCadastro();
				}
			}
		});
		
		jbtFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtFechar) {
					dispose();
				}
			}
		});
		
	}
}