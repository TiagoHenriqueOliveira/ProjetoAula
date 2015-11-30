package forms.WashCar;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.text.MaskFormatter;

import daoFactory.WashCar.DaoFactory;
import exception.WashCar.RegistroExistente;
import exception.WashCar.RegistroNotExistente;
import model.WashCar.Entidade;
import model.WashCar.Marca;
import model.WashCar.Modelo;
import preencherDados.WashCar.PreencherDados;

import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.time.format.DateTimeFormatter;

import javax.swing.JCheckBox;

import validacaoCampos.WashCar.ValidaCampoAlfaNumerico;
import validacaoCampos.WashCar.ValidaCampoNumeroInteiro;
import validacaoCampos.WashCar.ValidaCampoString;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class ModeloForm extends JFrame implements PreencherDados{

	private static final long serialVersionUID = 1L;
	private JPanel jpnModelo;
	private JPanel jpnPesquisaModelo;
	private JTextField jtfPesquisaCodigoModelo;
	private JTextField jtfPesquisaNomeModelo;
	private JTextField jtfCodigoModelo;
	private JTextField jtfNomeModelo;
	private JTextField jtfDataAlteracao;
	private JTextField jtfCodigoMarca;
	private JTextField jtfNomeMarca;
	private JLabel jlbPesquisaCodigoModelo;
	private JLabel jlbPesquisaNomeModelo;
	private JLabel jlbConsultaModelos;
	private JLabel jlbCodigoModelo;
	private JLabel jlbNomeModelo;
	private JLabel jlbDataAlteracao;
	private JLabel jlbNomeMarca;
	private JLabel jlbCodigoMarca;
	private JCheckBox jckbForaUso;
	private JButton jbtNovo;
	private JButton jbtSalvar;
	private JButton jbtEditar;
	private JButton jbtCancelar;
	private JButton jbtFechar;
	private JMenuItem jmiRelatorioGeralTodos;
	private JMenu jmnRelatorio;
	private JMenuBar jmbModelo;
	private Modelo modelo;
	private static ModeloForm modeloForm;
	private ListaModeloForm listaModeloForm = new ListaModeloForm(null, null, null);
	private ListaMarcaForm listaMarcaForm = new ListaMarcaForm(null, null, null);

	public void componentesTelaModelo() {
		jpnPesquisaModelo = new JPanel();
		jpnPesquisaModelo.setLayout(null);
		jpnPesquisaModelo.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnPesquisaModelo.setBounds(10, 11, 640, 86);
		jpnModelo.add(jpnPesquisaModelo);
		
		jtfPesquisaCodigoModelo = new JTextField();
		jtfPesquisaCodigoModelo.setDocument(new ValidaCampoNumeroInteiro());
		jtfPesquisaCodigoModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaCodigoModelo.setColumns(10);
		jtfPesquisaCodigoModelo.setBounds(10, 54, 50, 20);
		jpnPesquisaModelo.add(jtfPesquisaCodigoModelo);
		
		jtfPesquisaNomeModelo = new JTextField();
		jtfPesquisaNomeModelo.setDocument(new ValidaCampoAlfaNumerico());
		jtfPesquisaNomeModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaNomeModelo.setColumns(10);
		jtfPesquisaNomeModelo.setBounds(86, 54, 275, 20);
		jpnPesquisaModelo.add(jtfPesquisaNomeModelo);
		
		jlbPesquisaCodigoModelo = new JLabel("C\u00F3digo");
		jlbPesquisaCodigoModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaCodigoModelo.setBounds(10, 38, 66, 14);
		jpnPesquisaModelo.add(jlbPesquisaCodigoModelo);
		
		jlbPesquisaNomeModelo = new JLabel("Nome do Modelo");
		jlbPesquisaNomeModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaNomeModelo.setBounds(86, 38, 275, 14);
		jpnPesquisaModelo.add(jlbPesquisaNomeModelo);
		
		jlbConsultaModelos = new JLabel("Consulta Modelos de Carros");
		jlbConsultaModelos.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbConsultaModelos.setBounds(10, 11, 351, 14);
		jpnPesquisaModelo.add(jlbConsultaModelos);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 200, 120, 25);
		jpnModelo.add(jbtNovo);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setEnabled(false);
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(140, 200, 120, 25);
		jpnModelo.add(jbtSalvar);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setEnabled(false);
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setBounds(270, 200, 120, 25);
		jpnModelo.add(jbtEditar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setEnabled(false);
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setBounds(400, 200, 120, 25);
		jpnModelo.add(jbtCancelar);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setToolTipText("");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setBounds(530, 200, 120, 25);
		jpnModelo.add(jbtFechar);
		
		jtfCodigoModelo = new JTextField();
		jtfCodigoModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoModelo.setEditable(false);
		jtfCodigoModelo.setColumns(10);
		jtfCodigoModelo.setBackground(Color.YELLOW);
		jtfCodigoModelo.setBounds(10, 123, 50, 20);
		jpnModelo.add(jtfCodigoModelo);
		
		jtfNomeModelo = new JTextField();
		jtfNomeModelo.setDocument(new ValidaCampoAlfaNumerico());
		jtfNomeModelo.setEnabled(false);
		jtfNomeModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeModelo.setColumns(10);
		jtfNomeModelo.setBounds(110, 123, 300, 20);
		jpnModelo.add(jtfNomeModelo);
		
		jlbCodigoModelo = new JLabel("C\u00F3d. Modelo");
		jlbCodigoModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoModelo.setBounds(10, 108, 100, 14);
		jpnModelo.add(jlbCodigoModelo);
		
		jlbNomeModelo = new JLabel("Nome do Modelo");
		jlbNomeModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeModelo.setBounds(110, 108, 158, 14);
		jpnModelo.add(jlbNomeModelo);
		
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
		jtfDataAlteracao.setBounds(530, 169, 75, 20);
		jpnModelo.add(jtfDataAlteracao);
		
		jlbDataAlteracao = new JLabel("Data Altera\u00E7\u00E3o");
		jlbDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataAlteracao.setBounds(530, 153, 120, 14);
		jpnModelo.add(jlbDataAlteracao);
		
		jckbForaUso = new JCheckBox("Fora de Uso");
		jckbForaUso.setEnabled(false);
		jckbForaUso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jckbForaUso.setBounds(509, 120, 141, 23);
		jpnModelo.add(jckbForaUso);
		
		jlbCodigoMarca = new JLabel("C\u00F3d. Marca");
		jlbCodigoMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoMarca.setBounds(10, 154, 100, 14);
		jpnModelo.add(jlbCodigoMarca);
		
		jtfCodigoMarca = new JTextField();
		jtfCodigoMarca.setEditable(false);
		jtfCodigoMarca.setBackground(Color.YELLOW);
		jtfCodigoMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoMarca.setBounds(10, 169, 50, 20);
		jpnModelo.add(jtfCodigoMarca);
		jtfCodigoMarca.setColumns(10);
		
		jlbNomeMarca = new JLabel("Nome da Marca");
		jlbNomeMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeMarca.setBounds(110, 154, 158, 14);
		jpnModelo.add(jlbNomeMarca);
		
		jtfNomeMarca = new JTextField();
		jtfNomeMarca.setDocument(new ValidaCampoString());
		jtfNomeMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeMarca.setEnabled(false);
		jtfNomeMarca.setColumns(10);
		jtfNomeMarca.setBounds(110, 169, 300, 20);
		jpnModelo.add(jtfNomeMarca);
		
		jmbModelo = new JMenuBar();
		jmbModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		setJMenuBar(jmbModelo);
		
		jmnRelatorio = new JMenu("Relat\u00F3rios");
		jmnRelatorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jmbModelo.add(jmnRelatorio);
		
		jmiRelatorioGeralTodos = new JMenuItem("Relat\u00F3rio Geral - Todos Modelos");
		jmiRelatorioGeralTodos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jmnRelatorio.add(jmiRelatorioGeralTodos);
		setContentPane(jpnModelo);
	}
	
	public void acionarBotaoNovo() {
		jtfNomeModelo.requestFocus();
		jtfCodigoModelo.setText("");
		jtfNomeModelo.setText("");
		jtfCodigoMarca.setText("");
		jtfNomeMarca.setText("");
		jtfDataAlteracao.setText("");
		jckbForaUso.setSelected(false);
		jckbForaUso.setEnabled(false);
		jbtNovo.setEnabled(false);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
		jbtEditar.setEnabled(false);
		jtfNomeModelo.setEnabled(true);
		jtfNomeMarca.setEnabled(true);
	}
	
	@SuppressWarnings("static-access")
	public void salvarCadastroModelo() throws RegistroExistente {
		this.modelo = new Modelo();
		if(jtfNomeModelo.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o nome do modelo!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeModelo.requestFocus();
		} else if(jtfCodigoMarca.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o nome da marca válido!\n"
					+ "Por gentileza, efetue uma nova consulta.\nA consulta é feita acionando o" + " Enter!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeMarca.requestFocus();
		} else {
			this.modelo.setNome(jtfNomeModelo.getText());
			this.modelo.setMarca(new Marca(Integer.valueOf(jtfCodigoMarca.getText()), null));
			this.modelo.setDataAltercacao(Date.valueOf(modelo.getDataAltercacao().now()).toLocalDate());
			this.modelo.setForaUso(Boolean.valueOf(jckbForaUso.isSelected()));
			DaoFactory.getFactory().modeloDao().inserir(modelo);
			jtfCodigoModelo.setText(String.valueOf(this.modelo.getIdModelo()));
			jtfDataAlteracao.setText(this.modelo.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
			JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!!!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeModelo.setEnabled(false);
			jtfNomeMarca.setEnabled(false);
			jbtSalvar.setEnabled(false);
			jbtEditar.setEnabled(true);
			jbtNovo.setEnabled(true);
			jbtCancelar.setEnabled(false);
		}
	}
	
	@SuppressWarnings("static-access")
	public void salvarEdicaoModelo() throws RegistroExistente {
		this.modelo = new Modelo();
		if(jtfNomeModelo.equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o nome do modelo!!!",
					"Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeModelo.requestFocus();
		} else if(jtfCodigoMarca.equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o nome da marca!!!",
					"Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeMarca.requestFocus();
		} else {
			this.modelo.setNome(jtfNomeModelo.getText());
			this.modelo.setMarca(new Marca(Integer.valueOf(jtfCodigoMarca.getText()), null));
			this.modelo.setDataAltercacao(Date.valueOf(modelo.getDataAltercacao().now()).toLocalDate());
			this.modelo.setForaUso(Boolean.valueOf(jckbForaUso.isSelected()));
			this.modelo.setIdModelo(Integer.valueOf(jtfCodigoModelo.getText()));
			DaoFactory.getFactory().modeloDao().alterar(modelo);
			jtfDataAlteracao.setText(this.modelo.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
			JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!!!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeModelo.setEnabled(false);
			jtfNomeMarca.setEnabled(false);
			jckbForaUso.setEnabled(false);
			jbtSalvar.setEnabled(false);
			jbtEditar.setEnabled(true);
			jbtNovo.setEnabled(true);
			jbtCancelar.setEnabled(false);
		}
	}
	
	public void acionarBotaoEditar() {
		jtfNomeModelo.requestFocus();
		jbtNovo.setEnabled(false);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
		jtfNomeModelo.setEnabled(true);
		jtfNomeMarca.setEnabled(true);
		jckbForaUso.setEnabled(true);
	}
	
	public void acionarBotaoCancelar() {
		jtfPesquisaCodigoModelo.requestFocus();
		jtfNomeModelo.setEnabled(false);
		jtfNomeMarca.setEnabled(false);
		jtfCodigoModelo.setText("");
		jtfNomeModelo.setText("");
		jtfCodigoMarca.setText("");
		jtfNomeMarca.setText("");
		jtfDataAlteracao.setText("");
		jckbForaUso.setSelected(false);
		jckbForaUso.setEnabled(false);
		jbtNovo.setEnabled(true);
		jbtCancelar.setEnabled(false);
		jbtSalvar.setEnabled(false);
		jbtEditar.setEnabled(false);
	}
	
	public void preencherCamposModelo(Modelo modelo) {
		jtfCodigoModelo.setText(String.valueOf(modelo.getIdModelo()));
		jtfNomeModelo.setText(modelo.getNome());
		jtfCodigoMarca.setText(String.valueOf(modelo.getMarca().getIdMarca()));
		jtfNomeMarca.setText(modelo.getMarca().getNome());
		jtfDataAlteracao.setText(modelo.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
		if(modelo.isForaUso()) {
			jckbForaUso.setSelected(true);
		} else {
			jckbForaUso.setSelected(false);
		}
		jtfPesquisaCodigoModelo.requestFocus();
	}
	
	public void preencherCamposMarca(Marca marca) {
		if(marca.isForaUso()) {
			JOptionPane.showMessageDialog(null, "A Marca selecionada está fora de uso,\n"
			+ "por gentileza entre em contato com o responsável!\n"
			+ "Após a confirmação o cadastro será cancelado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			this.acionarBotaoCancelar();
		} else {
			jtfCodigoMarca.setText(String.valueOf(marca.getIdMarca()));
			jtfNomeMarca.setText(marca.getNome());
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
							salvarEdicaoModelo();
						} catch (RegistroExistente salvarEdicao) {
							JOptionPane.showMessageDialog(modeloForm, salvarEdicao.modeloJaExiste(), "Atenção", JOptionPane.WARNING_MESSAGE);
							jtfNomeModelo.setText("");
							jtfNomeModelo.requestFocus();
						}
					} else {
						try {
							salvarCadastroModelo();
						} catch (RegistroExistente salvarCadastro) {
							JOptionPane.showMessageDialog(modeloForm, salvarCadastro.modeloJaExiste(), "Atenção", JOptionPane.WARNING_MESSAGE);
							jtfNomeModelo.setText("");
							jtfNomeModelo.requestFocus();
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
					if(jtfCodigoMarca.getText() == null || jtfCodigoMarca.getText().equals("")) {
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
	
	public void pesquisarPorCodigo() {
		jtfPesquisaCodigoModelo.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						if(listaModeloForm.isVisible()) {
							listaModeloForm.requestFocus();
							listaModeloForm.setLocationRelativeTo(modeloForm);
						} else {
							Integer codigo = null;
							if(!jtfPesquisaCodigoModelo.getText().equals("")) {
								codigo = Integer.valueOf(jtfPesquisaCodigoModelo.getText());
							}
							listaModeloForm = new ListaModeloForm(modeloForm, null, codigo);
							listaModeloForm.setVisible(true);
							jbtEditar.setEnabled(true);
							jbtNovo.setEnabled(true);
							jbtCancelar.setEnabled(true);
							jbtSalvar.setEnabled(false);
							jtfCodigoModelo.setText("");
							jtfNomeModelo.setText("");
							jtfCodigoMarca.setText("");
							jtfNomeMarca.setText("");
							jtfDataAlteracao.setText("");
							jckbForaUso.setSelected(false);
							jckbForaUso.setEnabled(false);
							jtfPesquisaCodigoModelo.setText("");
							jtfPesquisaNomeModelo.setText("");
							jbtEditar.setEnabled(true);
							jbtSalvar.setEnabled(false);
							jbtCancelar.setEnabled(true);
						}
					} catch (RegistroNotExistente e) {
						JOptionPane.showMessageDialog(modeloForm, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
						jtfPesquisaCodigoModelo.setText("");
					}
				}
			}
		});
	}
	
	public void pesquisarPorNome() {
		jtfPesquisaNomeModelo.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						if(listaModeloForm.isVisible()) {
							listaModeloForm.requestFocus();
							listaModeloForm.setLocationRelativeTo(modeloForm);
						} else {
							listaModeloForm = new ListaModeloForm(modeloForm, jtfPesquisaNomeModelo.getText(), null);
							listaModeloForm.setVisible(true);
							jbtEditar.setEnabled(true);
							jbtNovo.setEnabled(true);
							jbtCancelar.setEnabled(true);
							jbtSalvar.setEnabled(false);
							jtfCodigoModelo.setText("");
							jtfNomeModelo.setText("");
							jtfCodigoMarca.setText("");
							jtfNomeMarca.setText("");
							jtfDataAlteracao.setText("");
							jckbForaUso.setSelected(false);
							jckbForaUso.setEnabled(false);
							jtfPesquisaCodigoModelo.setText("");
							jtfPesquisaNomeModelo.setText("");
							jbtEditar.setEnabled(true);
							jbtSalvar.setEnabled(false);
							jbtCancelar.setEnabled(true);
						}
					} catch (RegistroNotExistente e) {
						JOptionPane.showMessageDialog(modeloForm, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
						jtfPesquisaNomeModelo.setText("");
					}
				}
			}
		});
	}
	
	public void pesquisarNomeMarca() {
		jtfNomeMarca.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						if(listaMarcaForm.isVisible()) {
							listaMarcaForm.requestFocus();
							listaMarcaForm.setLocationRelativeTo(modeloForm);
						} else {
							listaMarcaForm = new ListaMarcaForm(modeloForm, jtfNomeMarca.getText(), null);
							listaMarcaForm.setVisible(true);
							jtfCodigoMarca.setText("");
							jtfNomeMarca.setText("");
						}
					} catch (RegistroNotExistente e) {
						JOptionPane.showMessageDialog(modeloForm, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
						jtfNomeMarca.setText("");
					}
				}
			}
		});
	}
	
	public ModeloForm() {
		modeloForm = this;
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModeloForm.class.getResource("/Imagens/washCar.jpeg")));
		setResizable(false);
		setTitle("Cadastrar Modelos de Carros | WashCar");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 666, 285);
		jpnModelo = new JPanel();
		jpnModelo.setLayout(null);
		setLocationRelativeTo(null);
		
		componentesTelaModelo();
		acoesDosBotoes();
		pesquisarPorCodigo();
		pesquisarPorNome();
		pesquisarNomeMarca();
	}

	@Override
	public void preencherCampos(Entidade entidade) {
		if(entidade instanceof Modelo) {
			this.preencherCamposModelo((Modelo)entidade);
		} else if(entidade instanceof Marca) {
			this.preencherCamposMarca((Marca)entidade);
		}
	}
}