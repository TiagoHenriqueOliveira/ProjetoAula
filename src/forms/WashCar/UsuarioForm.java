package forms.WashCar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.MaskFormatter;

import daoFactory.WashCar.DaoFactory;
import exception.WashCar.RegistroExistente;
import exception.WashCar.RegistroNotExistente;
import model.WashCar.Empresa;
import model.WashCar.Entidade;
import model.WashCar.Usuario;
import preencherDados.WashCar.PreencherDados;
import validacaoCampos.WashCar.ValidaCampoNumeroInteiro;
import validacaoCampos.WashCar.ValidaCampoString;

public class UsuarioForm extends JFrame implements PreencherDados{

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
	private JLabel jlbNome;
	private JLabel jlbLogin;
	private JLabel jlbSenha;
	private JLabel jlbCodigo;
	private JLabel jlbDataAlteracao;
	private JCheckBox jckbForaUso;
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
	private ListaUsuarioForm listaUsuario = new ListaUsuarioForm(null, null, null);;

	public void componentesUsuarioForm() {
		jpnPesquisaUsuario = new JPanel();
		jpnPesquisaUsuario.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnPesquisaUsuario.setBounds(10, 11, 640, 81);
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
		jtfPesquisaCodigoUsuario.setBounds(10, 49, 50, 20);
		jpnPesquisaUsuario.add(jtfPesquisaCodigoUsuario);
		
		jlbPesquisaNomeUsuario = new JLabel("Nome do Usu\u00E1rio");
		jlbPesquisaNomeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaNomeUsuario.setBounds(86, 33, 275, 14);
		jpnPesquisaUsuario.add(jlbPesquisaNomeUsuario);
		
		jtfPesquisaNomeUsuario = new JTextField();
		jtfPesquisaNomeUsuario.setDocument(new ValidaCampoString());
		jtfPesquisaNomeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaNomeUsuario.setColumns(10);
		jtfPesquisaNomeUsuario.setBounds(86, 49, 275, 20);
		jpnPesquisaUsuario.add(jtfPesquisaNomeUsuario);
		
		jlbConsultaUsuario = new JLabel("Consulta de Usu\u00E1rios");
		jlbConsultaUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbConsultaUsuario.setBounds(10, 8, 351, 14);
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
		jlbDataAlteracao.setBounds(552, 236, 98, 14);
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
		jtfDataAlteracao.setBounds(552, 252, 98, 20);
		jpnUsuario.add(jtfDataAlteracao);
		
		jckbForaUso = new JCheckBox("Usu\u00E1rio Fora de Uso");
		jckbForaUso.setEnabled(false);
		jckbForaUso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jckbForaUso.setBounds(468, 118, 182, 23);
		jpnUsuario.add(jckbForaUso);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setToolTipText("");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setBounds(530, 283, 120, 25);
		jpnUsuario.add(jbtFechar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setEnabled(false);
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setBounds(400, 283, 120, 25);
		jpnUsuario.add(jbtCancelar);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setEnabled(false);
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setBounds(270, 283, 120, 25);
		jpnUsuario.add(jbtEditar);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setEnabled(false);
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(140, 283, 120, 25);
		jpnUsuario.add(jbtSalvar);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 283, 120, 25);
		jpnUsuario.add(jbtNovo);
		
		jtfCodigo = new JTextField();
		jtfCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigo.setEditable(false);
		jtfCodigo.setColumns(10);
		jtfCodigo.setBackground(Color.YELLOW);
		jtfCodigo.setBounds(10, 119, 50, 20);
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
		jtfNome.setEnabled(true);
		jtfLogin.setEnabled(true);
		jpfSenha.setEnabled(true);
		jckbForaUso.setSelected(false);
		jckbForaUso.setEnabled(false);
		jbtNovo.setEnabled(false);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
		jbtEditar.setEnabled(false);
	}

	@SuppressWarnings({ "deprecation", "static-access" })
	public void salvarCadastroUsuario() throws RegistroExistente {
		this.usuario = new Usuario();
		if (jtfNome.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o nome do usuário!!!", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);
			jtfNome.requestFocus();
		} else if (jtfLogin.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o login do usuário!!!", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);
			jtfLogin.requestFocus();
		} else if (jpfSenha.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar a senha do usuário!!!", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);
			jpfSenha.requestFocus();
		} else {
			this.usuario.setNome(jtfNome.getText());
			this.usuario.setLogin(jtfLogin.getText());
			this.usuario.setSenha(jpfSenha.getText());
			this.usuario.setDataAltercacao(Date.valueOf(usuario.getDataAltercacao().now()).toLocalDate());
			this.usuario.setForaUso(Boolean.valueOf(jckbForaUso.isSelected()));
			this.usuario.setEmpresa(new Empresa(1));
			DaoFactory.getFactory().usuarioDao().inserir(usuario);
			jtfCodigo.setText(String.valueOf(this.usuario.getIdUsuario()));
			jtfDataAlteracao.setText(this.usuario.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
			JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!!!", "Confirmação",
					JOptionPane.INFORMATION_MESSAGE);
			jtfNome.setEnabled(false);
			jtfLogin.setEnabled(false);
			jpfSenha.setEnabled(false);
			jbtSalvar.setEnabled(false);
			jbtEditar.setEnabled(true);
			jbtNovo.setEnabled(true);
			jbtCancelar.setEnabled(false);
		}
	}
	
	@SuppressWarnings({ "deprecation", "static-access" })
	public void salvarEdicaoUsuario() throws RegistroExistente {
		this.usuario = new Usuario();
		if (jtfNome.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o nome do usuário!!!", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);
			jtfNome.requestFocus();
		} else if (jtfLogin.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o login do usuário!!!", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);
			jtfLogin.requestFocus();
		} else if (jpfSenha.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar a senha do usuário!!!", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);
			jpfSenha.requestFocus();
		} else {
			this.usuario.setNome(jtfNome.getText());
			this.usuario.setLogin(jtfLogin.getText());
			this.usuario.setSenha(jpfSenha.getText());
			this.usuario.setDataAltercacao(Date.valueOf(usuario.getDataAltercacao().now()).toLocalDate());
			this.usuario.setForaUso(Boolean.valueOf(jckbForaUso.isSelected()));
			this.usuario.setIdUsuario(Integer.valueOf(jtfCodigo.getText()));
			DaoFactory.getFactory().usuarioDao().alterar(usuario);
			jtfDataAlteracao.setText(this.usuario.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
			JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!!!", "Confirmação",
					JOptionPane.INFORMATION_MESSAGE);
			jtfNome.setEnabled(false);
			jtfLogin.setEnabled(false);
			jpfSenha.setEnabled(false);
			jckbForaUso.setEnabled(false);
			jbtSalvar.setEnabled(false);
			jbtEditar.setEnabled(true);
			jbtNovo.setEnabled(true);
			jbtCancelar.setEnabled(false);
		}
	}
	
	public void acionarBotaoEditar() {
		jtfNome.setEnabled(true);
		jtfLogin.setEnabled(true);
		jpfSenha.setEnabled(true);
		jckbForaUso.setEnabled(true);
		jbtNovo.setEnabled(false);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
	}
	
	public void acionarBotaoCancelar() {
		jtfPesquisaCodigoUsuario.requestFocus();
		jtfNome.setEnabled(false);
		jtfLogin.setEnabled(false);
		jpfSenha.setEnabled(false);
		jckbForaUso.setEnabled(false);
		jckbForaUso.setSelected(false);
		jtfCodigo.setText("");
		jtfNome.setText("");
		jtfLogin.setText("");
		jpfSenha.setText("");
		jtfDataAlteracao.setText("");
		jbtNovo.setEnabled(true);
		jbtCancelar.setEnabled(false);
		jbtSalvar.setEnabled(false);
		jbtEditar.setEnabled(false);
	}
	
	public void preencherCamposUsuario(Usuario usuario) {
		jtfCodigo.setText(String.valueOf(usuario.getIdUsuario()));
		jtfNome.setText(usuario.getNome());
		jtfLogin.setText(usuario.getLogin());
		jpfSenha.setText(usuario.getSenha());
		jtfDataAlteracao.setText(usuario.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
		if(usuario.isForaUso()) {
			jckbForaUso.setSelected(true);
		} else {
			jckbForaUso.setSelected(false);
		}
		jtfPesquisaCodigoUsuario.requestFocus();
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
						} catch (RegistroExistente salvarEdicao) {
							JOptionPane.showMessageDialog(usuarioForm, salvarEdicao.usuarioJaExiste(), "Atenção", JOptionPane.WARNING_MESSAGE);
							jtfLogin.setText("");
							jtfLogin.requestFocus();
						}
					} else {
						try {
							salvarCadastroUsuario();
						} catch (RegistroExistente salvarCadastro) {
							JOptionPane.showMessageDialog(usuarioForm, salvarCadastro.usuarioJaExiste(), "Atenção", JOptionPane.WARNING_MESSAGE);
							jtfLogin.setText("");
							jtfLogin.requestFocus();
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
					if(jtfCodigo.getText() == null || jtfCodigo.getText().equals("")) {
						Integer valor = JOptionPane.showConfirmDialog(null, "Você NÃO concluiu o cadastro.\n"
								+ "Deseja realmente fechar sem concluir o cadastro?\n"
								+ "SIM - Cadastro da Ordem de Serviço será cancelado!\n"
								+ "NÃO - Por gentileza, conclua o cadastro da Ordem de Serviço!", "Atenção", JOptionPane.YES_NO_OPTION);
						if(valor == 0) {
							dispose();
						}
					}
				} else {
					dispose();
				}
			}
		});
	}
	
	public void pesquisarPorCodigo() throws RegistroNotExistente {
		jtfPesquisaCodigoUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					try{
						if(listaUsuario.isVisible()) {
							listaUsuario.requestFocus();
							listaUsuario.setLocationRelativeTo(usuarioForm);
						} else {
							Integer codigo = null;
							if(!jtfPesquisaCodigoUsuario.getText().equals("")) {
								codigo = Integer.valueOf(jtfPesquisaCodigoUsuario.getText());
							}
							listaUsuario = new ListaUsuarioForm(usuarioForm, null, codigo);
							listaUsuario.setVisible(true);
							jtfNome.setEnabled(false);
							jtfLogin.setEnabled(false);
							jpfSenha.setEnabled(false);
							jckbForaUso.setEnabled(false);
							jckbForaUso.setSelected(false);
							jtfCodigo.setText("");
							jtfNome.setText("");
							jtfLogin.setText("");
							jpfSenha.setText("");
							jtfDataAlteracao.setText("");
							jbtEditar.setEnabled(true);
							jbtSalvar.setEnabled(false);
							jbtCancelar.setEnabled(true);
							jtfPesquisaCodigoUsuario.setText("");
							jtfPesquisaNomeUsuario.setText("");
							jbtEditar.setEnabled(true);
							jbtSalvar.setEnabled(false);
							jbtCancelar.setEnabled(true);
						}
					} catch (RegistroNotExistente e) {
						JOptionPane.showMessageDialog(usuarioForm, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
						jtfPesquisaCodigoUsuario.setText("");
					}
				}
			}
		});
	}
	
	public void pesquisarPorNome() throws RegistroNotExistente {
		jtfPesquisaNomeUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						if(listaUsuario.isVisible()) {
							listaUsuario.requestFocus();
							listaUsuario.setLocationRelativeTo(usuarioForm);
						} else {
							listaUsuario = new ListaUsuarioForm(usuarioForm, jtfPesquisaNomeUsuario.getText(), null);
							listaUsuario.setVisible(true);
							jtfNome.setEnabled(false);
							jtfLogin.setEnabled(false);
							jpfSenha.setEnabled(false);
							jckbForaUso.setEnabled(false);
							jckbForaUso.setSelected(false);
							jtfCodigo.setText("");
							jtfNome.setText("");
							jtfLogin.setText("");
							jpfSenha.setText("");
							jtfDataAlteracao.setText("");
							jbtEditar.setEnabled(true);
							jbtSalvar.setEnabled(false);
							jbtCancelar.setEnabled(true);
							jtfPesquisaCodigoUsuario.setText("");
							jtfPesquisaNomeUsuario.setText("");
							jbtEditar.setEnabled(true);
							jbtSalvar.setEnabled(false);
							jbtCancelar.setEnabled(true);
						}						
					} catch (RegistroNotExistente e) {
						JOptionPane.showMessageDialog(usuarioForm, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
						jtfPesquisaNomeUsuario.setText("");
					}
				}
			}
		});
	}
	
	public UsuarioForm() {
		usuarioForm = this;
		setIconImage(Toolkit.getDefaultToolkit().getImage(UsuarioForm.class.getResource("/Imagens/washCar.jpeg")));
		setTitle("Cadastro de Usuários | WashCar");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 670, 372);
		jpnUsuario = new JPanel();
		jpnUsuario.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(jpnUsuario);
		
		componentesUsuarioForm();
		acoesDosBotoes();
		pesquisarPorNome();
		pesquisarPorCodigo();
	}

	@Override
	public void preencherCampos(Entidade entidade) {
		this.preencherCamposUsuario((Usuario)entidade);
	}	
}