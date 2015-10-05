package forms.WashCar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.MaskFormatter;

import model.WashCar.Empresa;
import model.WashCar.Usuario;
import validacaoCampos.WashCar.ValidaCampoNumeroInteiro;
import validacaoCampos.WashCar.ValidaCampoString;
import daoFactory.WashCar.DaoFactory;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class UsuarioForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnUsuario;
	private JTextField jtfPesquisaCodigoUsuario;
	private JTextField jtfPesquisaNomeUsuario;
	private JTextField jtfNome;
	private JTextField jtfLogin;
	private JTextField jtfCodigo;
	private JPasswordField jpfSenha;
	private JTextField jtfDataAlteracao;
	private JPanel jpnPesquisaUsuario;
	private JLabel jlbPesquisaCodigoUsuario;
	private JLabel jlbPesquisaNomeUsuario;
	private JButton jbtPesquisaUsuario;
	private JLabel jlbNome;
	private JLabel jlbLogin;
	private JLabel jlbSenha;
	private JLabel jlbCodigo;
	private JLabel jlbDataAlteracao;
	private JCheckBox jcbxUsuarioForaUso;
	private JButton jbtFechar;
	private JButton jbtCancelar;
	private JButton jbtEditar;
	private JButton jbtSalvar;
	private JButton jbtNovo;
	private JLabel jlbConsultaUsuario;
	private JMenuBar jmbUsuario;
	private JMenu jmnRelatorio;
	private JMenuItem jmiUsuarioCadastradoTodos;
	private Usuario usuario;
	private static UsuarioForm usuarioForm;
	private static String nomeUsuario;
	private static String codigoUsuario;

	public void componentesFormUsuario() {
		jpnPesquisaUsuario = new JPanel();
		jpnPesquisaUsuario.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnPesquisaUsuario.setBounds(10, 11, 540, 81);
		jpnUsuario.add(jpnPesquisaUsuario);
		jpnPesquisaUsuario.setLayout(null);
		
		jlbPesquisaCodigoUsuario = new JLabel("C\u00F3digo");
		jlbPesquisaCodigoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaCodigoUsuario.setBounds(10, 33, 66, 14);
		jpnPesquisaUsuario.add(jlbPesquisaCodigoUsuario);
		
		jtfPesquisaCodigoUsuario = new JTextField();
		jtfPesquisaCodigoUsuario.setDocument(new ValidaCampoNumeroInteiro());
		jtfPesquisaCodigoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaCodigoUsuario.setColumns(10);
		jtfPesquisaCodigoUsuario.setBounds(10, 49, 66, 20);
		jpnPesquisaUsuario.add(jtfPesquisaCodigoUsuario);
		
		jlbPesquisaNomeUsuario = new JLabel("Nome do Usu\u00E1rio");
		jlbPesquisaNomeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaNomeUsuario.setBounds(86, 33, 196, 14);
		jpnPesquisaUsuario.add(jlbPesquisaNomeUsuario);
		
		jtfPesquisaNomeUsuario = new JTextField();
		jtfPesquisaNomeUsuario.setDocument(new ValidaCampoString());
		jtfPesquisaNomeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaNomeUsuario.setColumns(10);
		jtfPesquisaNomeUsuario.setBounds(86, 49, 275, 20);
		jpnPesquisaUsuario.add(jtfPesquisaNomeUsuario);
		
		jbtPesquisaUsuario = new JButton("");
		jbtPesquisaUsuario.setIcon(new ImageIcon(UsuarioForm.class.getResource("/Imagens/lupaPesquisa.jpeg")));
		jbtPesquisaUsuario.setBounds(367, 38, 40, 32);
		jpnPesquisaUsuario.add(jbtPesquisaUsuario);
		
		jlbConsultaUsuario = new JLabel("Consulta de Usu\u00E1rios");
		jlbConsultaUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbConsultaUsuario.setBounds(10, 8, 196, 14);
		jpnPesquisaUsuario.add(jlbConsultaUsuario);
		
		jtfNome = new JTextField();
		jtfNome.setDocument(new ValidaCampoString());
		jtfNome.setEnabled(false);
		jtfNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNome.setColumns(10);
		jtfNome.setBounds(10, 159, 275, 20);
		jpnUsuario.add(jtfNome);
		
		jlbNome = new JLabel("Nome do Usu\u00E1rio");
		jlbNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNome.setBounds(10, 143, 182, 14);
		jpnUsuario.add(jlbNome);
		
		jtfLogin = new JTextField();
		jtfLogin.setDocument(new ValidaCampoString());
		jtfLogin.setEnabled(false);
		jtfLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfLogin.setColumns(10);
		jtfLogin.setBounds(10, 206, 275, 20);
		jpnUsuario.add(jtfLogin);
		
		jlbLogin = new JLabel("Login do Usu\u00E1rio");
		jlbLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbLogin.setBounds(10, 190, 182, 14);
		jpnUsuario.add(jlbLogin);
		
		jlbSenha = new JLabel("Senha do Usu\u00E1rio");
		jlbSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbSenha.setBounds(10, 237, 182, 14);
		jpnUsuario.add(jlbSenha);
		
		jpfSenha = new JPasswordField();
		jpfSenha.setEnabled(false);
		jpfSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jpfSenha.setBounds(10, 252, 182, 20);
		jpnUsuario.add(jpfSenha);
		
		jlbDataAlteracao = new JLabel("Data Altera\u00E7\u00E3o");
		jlbDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataAlteracao.setBounds(452, 266, 98, 14);
		jpnUsuario.add(jlbDataAlteracao);
		
		try {
			jtfDataAlteracao = new JFormattedTextField(new MaskFormatter("##/##/####"));
			jtfDataAlteracao.setHorizontalAlignment(SwingConstants.RIGHT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfDataAlteracao.setEditable(false);
		jtfDataAlteracao.setColumns(10);
		jtfDataAlteracao.setBackground(Color.YELLOW);
		jtfDataAlteracao.setBounds(452, 282, 98, 20);
		jpnUsuario.add(jtfDataAlteracao);
		
		jcbxUsuarioForaUso = new JCheckBox("Usu\u00E1rio Fora de Uso");
		jcbxUsuarioForaUso.setEnabled(false);
		jcbxUsuarioForaUso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jcbxUsuarioForaUso.setBounds(10, 279, 182, 23);
		jpnUsuario.add(jcbxUsuarioForaUso);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setToolTipText("");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setBounds(450, 314, 100, 23);
		jpnUsuario.add(jbtFechar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setEnabled(false);
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setBounds(340, 314, 100, 23);
		jpnUsuario.add(jbtCancelar);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setEnabled(false);
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setBounds(230, 314, 100, 23);
		jpnUsuario.add(jbtEditar);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setEnabled(false);
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(120, 314, 100, 23);
		jpnUsuario.add(jbtSalvar);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 314, 100, 23);
		jpnUsuario.add(jbtNovo);
		
		jtfCodigo = new JTextField();
		jtfCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigo.setEditable(false);
		jtfCodigo.setColumns(10);
		jtfCodigo.setBackground(Color.YELLOW);
		jtfCodigo.setBounds(10, 119, 66, 20);
		jpnUsuario.add(jtfCodigo);
		
		jlbCodigo = new JLabel("C\u00F3digo");
		jlbCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigo.setBounds(10, 103, 66, 14);
		jpnUsuario.add(jlbCodigo);
		
		jmbUsuario = new JMenuBar();
		jmbUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		setJMenuBar(jmbUsuario);
		
		jmnRelatorio = new JMenu("Relat\u00F3rios");
		jmnRelatorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jmbUsuario.add(jmnRelatorio);
		
		jmiUsuarioCadastradoTodos = new JMenuItem("Usu\u00E1rios Cadastrados - Todos");
		jmiUsuarioCadastradoTodos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jmnRelatorio.add(jmiUsuarioCadastradoTodos);
	}
	
	public void acionarBotaoNovo() {
		jtfNome.requestFocus();
		jtfCodigo.setText("");
		jtfNome.setText("");
		jtfLogin.setText("");
		jpfSenha.setText("");
		jtfDataAlteracao.setText("");
		jbtNovo.setEnabled(false);
		jtfNome.setEnabled(true);
		jtfLogin.setEnabled(true);
		jpfSenha.setEnabled(true);
		jcbxUsuarioForaUso.setSelected(false);
		jcbxUsuarioForaUso.setEnabled(false);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
		jbtEditar.setEnabled(false);
	}
	
	@SuppressWarnings({ "deprecation", "static-access" })
	public void salvarCadastroUsuario() throws Exception{
		this.usuario = new Usuario();
		if(jtfNome.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigat�rio informar o nome do usu�rio!!!",
					"Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNome.requestFocus();
		} else if(jtfLogin.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigat�rio informar o login do usu�rio!!!",
					"Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfLogin.requestFocus();
		} else if(jpfSenha.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigat�rio informar a senha do usu�rio!!!",
					"Aviso", JOptionPane.INFORMATION_MESSAGE);
			jpfSenha.requestFocus();
		} else {
		this.usuario.setNome(jtfNome.getText());
		this.usuario.setLogin(jtfLogin.getText());
		this.usuario.setSenha(jpfSenha.getText());
		this.usuario.setDataAltercacao(Date.valueOf(usuario.getDataAltercacao().now()).toLocalDate());
		this.usuario.setForaUso(Boolean.valueOf(jcbxUsuarioForaUso.isSelected()));
		this.usuario.setEmpresa(new Empresa(1));
		DaoFactory.getFactory().usuarioDao().inserir(usuario);
		jtfCodigo.setText(String.valueOf(this.usuario.getIdUsuario()));
		jtfDataAlteracao.setText(this.usuario.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
		JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!!!", "Confirma��o", JOptionPane.INFORMATION_MESSAGE);
		jtfNome.setEnabled(false);
		jtfLogin.setEnabled(false);
		jpfSenha.setEnabled(false);
		jbtSalvar.setEnabled(false);
		jbtEditar.setEnabled(true);
		jbtNovo.setEnabled(true);
		}
	}
	
	@SuppressWarnings({ "deprecation", "static-access" })
	public void salvarEdicaoUsuario() throws Exception {
		this.usuario = new Usuario();
		if(jtfNome.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigat�rio informar o nome do usu�rio!!!",
					"Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNome.requestFocus();
		} else if(jtfLogin.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigat�rio informar o login do usu�rio!!!",
					"Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfLogin.requestFocus();
		} else if(jpfSenha.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigat�rio informar a senha do usu�rio!!!",
					"Aviso", JOptionPane.INFORMATION_MESSAGE);
			jpfSenha.requestFocus();
		} else {
		this.usuario.setNome(jtfNome.getText());
		this.usuario.setLogin(jtfLogin.getText());
		this.usuario.setSenha(jpfSenha.getText());
		this.usuario.setDataAltercacao(Date.valueOf(usuario.getDataAltercacao().now()).toLocalDate());
		this.usuario.setForaUso(Boolean.valueOf(jcbxUsuarioForaUso.isSelected()));
		this.usuario.setIdUsuario(Integer.valueOf(jtfCodigo.getText()));
		DaoFactory.getFactory().usuarioDao().alterar(usuario);
		jtfDataAlteracao.setText(this.usuario.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
		JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!!!", "Confirma��o", JOptionPane.INFORMATION_MESSAGE);
		jtfNome.setEnabled(false);
		jtfLogin.setEnabled(false);
		jpfSenha.setEnabled(false);
		jcbxUsuarioForaUso.setEnabled(false);
		jbtSalvar.setEnabled(false);
		jbtEditar.setEnabled(true);
		jbtNovo.setEnabled(true);
		}
	}
	
	public void acionarBotaoEditar() {
		jbtNovo.setEnabled(false);
		jtfNome.setEnabled(true);
		jtfLogin.setEnabled(true);
		jpfSenha.setEnabled(true);
		jcbxUsuarioForaUso.setEnabled(true);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
	}
	
	@SuppressWarnings("deprecation")
	public void acionarBotaoPesquisa() {
		ListaUsuarioForm listaUsuario = new ListaUsuarioForm(usuarioForm);
		listaUsuario.show();
		jtfNome.setEnabled(false);
		jtfLogin.setEnabled(false);
		jpfSenha.setEnabled(false);
		jcbxUsuarioForaUso.setEnabled(false);
		jcbxUsuarioForaUso.setSelected(false);
		jtfCodigo.setText("");
		jtfNome.setText("");
		jtfLogin.setText("");
		jpfSenha.setText("");
		jbtEditar.setEnabled(true);
		jbtSalvar.setEnabled(false);
		jbtCancelar.setEnabled(true);
	}
	
	public void acionarBotaoCancelar() {
		jbtNovo.setEnabled(true);
		jtfNome.setEnabled(false);
		jtfLogin.setEnabled(false);
		jpfSenha.setEnabled(false);
		jcbxUsuarioForaUso.setEnabled(false);
		jcbxUsuarioForaUso.setSelected(false);
		jtfCodigo.setText("");
		jtfNome.setText("");
		jtfLogin.setText("");
		jpfSenha.setText("");
		jbtCancelar.setEnabled(false);
		jbtSalvar.setEnabled(false);
		jbtEditar.setEnabled(false);
	}
	
	public void preencherCampos(Usuario usuario) {
		jtfCodigo.setText(String.valueOf(usuario.getIdUsuario()));
		jtfNome.setText(usuario.getNome());
		jtfLogin.setText(usuario.getLogin());
		jpfSenha.setText(usuario.getSenha());
		jtfDataAlteracao.setText(usuario.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
		if(usuario.isForaUso()) {
			jcbxUsuarioForaUso.setSelected(true);
		} else {
			jcbxUsuarioForaUso.setSelected(false);
		}
	}
	
	public void acoesDosBotoes() {
		jbtNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent acvt) {
				if(acvt.getSource() == jbtNovo) {
					acionarBotaoNovo();
				}
			}
		});
		
		jbtSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent acvt) {
				if(acvt.getSource() == jbtSalvar) {
					if(jbtSalvar.isEnabled() && jbtEditar.isEnabled()) {
						try {
							salvarEdicaoUsuario();
						} catch (Exception salvarEdicao) {
							salvarEdicao.printStackTrace();
						}
					} else {
						try {
							salvarCadastroUsuario();
						} catch (Exception salvarCadastro) {
							salvarCadastro.printStackTrace();
						}
					}
				}
			}
		});
		
		jbtEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent acvt) {
				if(acvt.getSource() == jbtEditar) {
					acionarBotaoEditar();
				}
			}
		});
		
		jbtCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent acvt) {
				if(acvt.getSource() == jbtCancelar) {
					acionarBotaoCancelar();
				}
			}
		});
		
		jbtFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent acvt) {
				if(acvt.getSource() == jbtFechar) {
					dispose();
				}
			}
		});
		
		jbtPesquisaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent acvt) {
				if(acvt.getSource() == jbtPesquisaUsuario) {
					acionarBotaoPesquisa();
				}
			}
		});
	}
	
	public void pesquisarConteudoTextField() {
		jtfPesquisaNomeUsuario.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					nomeUsuario = jtfPesquisaNomeUsuario.getText();
					ListaUsuarioForm listaUsuario = new ListaUsuarioForm(usuarioForm);
					listaUsuario.show();
					acionarBotaoPesquisa();
				}
			}
		});
		
		jtfPesquisaCodigoUsuario.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					codigoUsuario = jtfPesquisaCodigoUsuario.getText();
					ListaUsuarioForm listaUsuario = new ListaUsuarioForm(usuarioForm);
					listaUsuario.show();
					acionarBotaoPesquisa();
				}
			}
		});
	}
		
	public UsuarioForm() {
		usuarioForm = this;
		setIconImage(Toolkit.getDefaultToolkit().getImage(UsuarioForm.class.getResource("/Imagens/washCar.jpeg")));
		setTitle("Cadastro de Usu�rios | WashCar");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 565, 395);
		jpnUsuario = new JPanel();
		jpnUsuario.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(jpnUsuario);
		
		componentesFormUsuario();
		acoesDosBotoes();
		pesquisarConteudoTextField();
	}
}