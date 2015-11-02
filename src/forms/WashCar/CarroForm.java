package forms.WashCar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.text.MaskFormatter;

import daoFactory.WashCar.DaoFactory;
import model.WashCar.Carro;
import model.WashCar.Entidade;
import model.WashCar.Modelo;
import preencherDados.WashCar.PreencherDados;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

import validacaoCampos.WashCar.ValidaCampoAlfaNumerico;
import validacaoCampos.WashCar.ValidaCampoNumeroInteiro;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class CarroForm extends JFrame implements PreencherDados{

	private static final long serialVersionUID = 1L;
	private JPanel jpnCarro;
	private JPanel jpnPesquisaCarro;
	private JTextField jtfPesquisaCodigoCarro;
	private JTextField jtfPesquisaNomeCarro;
	private JTextField jtfPesquisaPlacaCarro;
	private JTextField jtfCodigoCarro;
	private JTextField jtfDataAlteracao;
	private JTextField jtfNomeCarro;
	private JTextField jtfPlacaCarro;
	private JTextField jtfNomeModelo;
	private JTextField jtfCodigoModelo;
	private JLabel jlbPesquisaCodigoCarro;
	private JLabel jlbPesquisaNomeCarro;
	private JLabel jlbPesquisaPlacaCarro;
	private JLabel jlbCodigoCarro;
	private JLabel jlbDataAlteracao;
	private JLabel jlbNomeCarro;
	private JLabel jlbPlacaCarro;
	private JLabel jlbConsultaCarro;
	private JLabel jlbNomeModelo;
	private JLabel jlbCodigoModelo;
	private JCheckBox jckbxForaUso;
	private JButton jbtNovo;
	private JButton jbtEditar;
	private JButton jbtSalvar;
	private JButton jbtFechar;
	private JButton jbtCancelar;
	private JMenuBar jmbCadastroCarro;
	private JMenu jmnRelatorio;
	private Carro carro;
	private static CarroForm carroForm;

	public void componentesCarroForm() {
		jpnPesquisaCarro = new JPanel();
		jpnPesquisaCarro.setLayout(null);
		jpnPesquisaCarro.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnPesquisaCarro.setBounds(10, 11, 640, 85);
		jpnCarro.add(jpnPesquisaCarro);
		
		jlbPesquisaCodigoCarro = new JLabel("C\u00F3digo");
		jlbPesquisaCodigoCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaCodigoCarro.setBounds(10, 38, 74, 14);
		jpnPesquisaCarro.add(jlbPesquisaCodigoCarro);
		
		jtfPesquisaCodigoCarro = new JTextField();
		jtfPesquisaCodigoCarro.setDocument(new ValidaCampoNumeroInteiro());
		jtfPesquisaCodigoCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaCodigoCarro.setColumns(10);
		jtfPesquisaCodigoCarro.setBounds(10, 54, 50, 20);
		jpnPesquisaCarro.add(jtfPesquisaCodigoCarro);
		
		jlbPesquisaNomeCarro = new JLabel("Nome do Cliente / Nome Fantasia");
		jlbPesquisaNomeCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaNomeCarro.setBounds(86, 38, 275, 14);
		jpnPesquisaCarro.add(jlbPesquisaNomeCarro);
		
		jtfPesquisaNomeCarro = new JTextField();
		jtfPesquisaNomeCarro.setDocument(new ValidaCampoAlfaNumerico());
		jtfPesquisaNomeCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaNomeCarro.setColumns(10);
		jtfPesquisaNomeCarro.setBounds(86, 54, 275, 20);
		jpnPesquisaCarro.add(jtfPesquisaNomeCarro);
		
		try {
			jtfPesquisaPlacaCarro = new JFormattedTextField(new MaskFormatter("UUU-####"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfPesquisaPlacaCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaPlacaCarro.setColumns(10);
		jtfPesquisaPlacaCarro.setBounds(371, 54, 75, 20);
		jpnPesquisaCarro.add(jtfPesquisaPlacaCarro);
		
		jlbPesquisaPlacaCarro = new JLabel("Placa do Carro");
		jlbPesquisaPlacaCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaPlacaCarro.setBounds(371, 38, 165, 14);
		jpnPesquisaCarro.add(jlbPesquisaPlacaCarro);
		
		jlbConsultaCarro = new JLabel("Consulta Cadastro de Carros");
		jlbConsultaCarro.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbConsultaCarro.setBounds(10, 13, 351, 14);
		jpnPesquisaCarro.add(jlbConsultaCarro);
		
		jlbCodigoCarro = new JLabel("C\u00F3d. do Carro");
		jlbCodigoCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoCarro.setBounds(10, 107, 120, 14);
		jpnCarro.add(jlbCodigoCarro);
		
		jtfCodigoCarro = new JTextField();
		jtfCodigoCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoCarro.setEditable(false);
		jtfCodigoCarro.setColumns(10);
		jtfCodigoCarro.setBackground(Color.YELLOW);
		jtfCodigoCarro.setBounds(10, 123, 50, 20);
		jpnCarro.add(jtfCodigoCarro);
		
		jlbDataAlteracao = new JLabel("Data Alteracao");
		jlbDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataAlteracao.setBounds(550, 107, 120, 14);
		jpnCarro.add(jlbDataAlteracao);
		
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
		jtfDataAlteracao.setBounds(550, 123, 75, 20);
		jpnCarro.add(jtfDataAlteracao);
		
		jlbNomeCarro = new JLabel("Nome do Carro");
		jlbNomeCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeCarro.setBounds(130, 107, 298, 14);
		jpnCarro.add(jlbNomeCarro);
		
		jtfNomeCarro = new JTextField();
		jtfNomeCarro.setDocument(new ValidaCampoAlfaNumerico());
		jtfNomeCarro.setEnabled(false);
		jtfNomeCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeCarro.setColumns(10);
		jtfNomeCarro.setBounds(130, 123, 300, 20);
		jpnCarro.add(jtfNomeCarro);
		
		try {
			jtfPlacaCarro = new JFormattedTextField(new MaskFormatter("UUU-####"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfPlacaCarro.setEnabled(false);
		jtfPlacaCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPlacaCarro.setColumns(10);
		jtfPlacaCarro.setBounds(440, 123, 75, 20);
		jpnCarro.add(jtfPlacaCarro);
		
		jlbPlacaCarro = new JLabel("Placa do Carro");
		jlbPlacaCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPlacaCarro.setBounds(440, 107, 110, 14);
		jpnCarro.add(jlbPlacaCarro);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 201, 120, 25);
		jpnCarro.add(jbtNovo);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setEnabled(false);
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setBounds(140, 201, 120, 25);
		jpnCarro.add(jbtEditar);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setEnabled(false);
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(270, 201, 120, 25);
		jpnCarro.add(jbtSalvar);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setBounds(530, 201, 120, 25);
		jpnCarro.add(jbtFechar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setEnabled(false);
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setBounds(400, 201, 120, 25);
		jpnCarro.add(jbtCancelar);
		
		jmbCadastroCarro = new JMenuBar();
		jmbCadastroCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		setJMenuBar(jmbCadastroCarro);
		
		jmnRelatorio = new JMenu("Relat\u00F3rios");
		jmnRelatorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jmbCadastroCarro.add(jmnRelatorio);
		setContentPane(jpnCarro);
		
		jtfNomeModelo = new JTextField();
		jtfNomeModelo.setDocument(new ValidaCampoAlfaNumerico());
		jtfNomeModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeModelo.setEnabled(false);
		jtfNomeModelo.setColumns(10);
		jtfNomeModelo.setBounds(130, 170, 300, 20);
		jpnCarro.add(jtfNomeModelo);
		
		jlbNomeModelo = new JLabel("Nome do Modelo");
		jlbNomeModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeModelo.setBounds(130, 154, 298, 14);
		jpnCarro.add(jlbNomeModelo);
		
		jlbCodigoModelo = new JLabel("C\u00F3d. do Modelo");
		jlbCodigoModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoModelo.setBounds(10, 154, 120, 14);
		jpnCarro.add(jlbCodigoModelo);
		
		jtfCodigoModelo = new JTextField();
		jtfCodigoModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoModelo.setEditable(false);
		jtfCodigoModelo.setColumns(10);
		jtfCodigoModelo.setBackground(Color.YELLOW);
		jtfCodigoModelo.setBounds(10, 170, 50, 20);
		jpnCarro.add(jtfCodigoModelo);
		
		jckbxForaUso = new JCheckBox("Fora de Uso");
		jckbxForaUso.setEnabled(false);
		jckbxForaUso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jckbxForaUso.setBounds(530, 169, 120, 23);
		jpnCarro.add(jckbxForaUso);
	}

	public void acionarBotaoNovo() {
		jtfNomeCarro.requestFocus();
		jtfNomeCarro.setEnabled(true);
		jtfPlacaCarro.setEnabled(true);
		jtfNomeModelo.setEnabled(true);
		jckbxForaUso.setSelected(false);
		jckbxForaUso.setEnabled(false);
		jtfCodigoCarro.setText("");
		jtfNomeCarro.setText("");
		jtfPlacaCarro.setText("");
		jtfCodigoModelo.setText("");
		jtfNomeModelo.setText("");
		jtfDataAlteracao.setText("");
		jbtNovo.setEnabled(false);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
		jbtEditar.setEnabled(false);
	}
	
	@SuppressWarnings("static-access")
	public void salvarCadastroCarro() throws Exception {
		this.carro = new Carro();
		if(jtfNomeCarro.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o nome do carro!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeCarro.requestFocus();
		} else if(jtfPlacaCarro.getText().equals("   -    ")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar a placa do carro!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfPlacaCarro.requestFocus();
		} else if(jtfNomeModelo.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o modelo do carro!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeModelo.requestFocus();
		} else {
			this.carro.setNome(jtfNomeCarro.getText());
			this.carro.setPlaca(jtfPlacaCarro.getText());
			this.carro.setModelo(new Modelo(Integer.valueOf(jtfCodigoModelo.getText()), null));
			this.carro.setForaUso(Boolean.valueOf(jckbxForaUso.isSelected()));
			this.carro.setDataAltercacao(Date.valueOf(carro.getDataAltercacao().now()).toLocalDate());
			DaoFactory.getFactory().carroDao().inserir(carro);
			jtfCodigoCarro.setText(String.valueOf(this.carro.getIdCarro()));
			jtfDataAlteracao.setText(this.carro.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
			JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!!!", "Confirmação",
					JOptionPane.INFORMATION_MESSAGE);
			jtfNomeCarro.setEnabled(false);
			jtfPlacaCarro.setEnabled(false);
			jtfNomeModelo.setEnabled(false);
			jbtSalvar.setEnabled(false);
			jbtEditar.setEnabled(true);
			jbtNovo.setEnabled(true);
			jbtCancelar.setEnabled(false);
		}
	}
	
	@SuppressWarnings("static-access")
	public void salvarEdicaoCarro() throws Exception {
		this.carro = new Carro();
		if (jtfNomeCarro.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o nome do carro!!!", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);
			jtfNomeCarro.requestFocus();
		} else if (jtfPlacaCarro.getText().equals("   -    ")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar a placa do carro!!!", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);
			jtfPlacaCarro.requestFocus();
		} else if (jtfNomeModelo.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o modelo do carro!!!", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);
			jtfNomeModelo.requestFocus();
		} else {
			this.carro.setNome(jtfNomeCarro.getText());
			this.carro.setPlaca(jtfPlacaCarro.getText());
			this.carro.setModelo(new Modelo(Integer.valueOf(jtfCodigoModelo.getText()), null));
			this.carro.setForaUso(Boolean.valueOf(jckbxForaUso.isSelected()));
			this.carro.setDataAltercacao(Date.valueOf(carro.getDataAltercacao().now()).toLocalDate());
			this.carro.setIdCarro(Integer.valueOf(jtfCodigoCarro.getText()));
			DaoFactory.getFactory().carroDao().alterar(carro);
			jtfCodigoCarro.setText(String.valueOf(this.carro.getIdCarro()));
			jtfDataAlteracao.setText(this.carro.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
			JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!!!", "Confirmação",
					JOptionPane.INFORMATION_MESSAGE);
			jtfNomeCarro.setEnabled(false);
			jtfPlacaCarro.setEnabled(false);
			jtfNomeModelo.setEnabled(false);
			jckbxForaUso.setEnabled(false);
			jbtSalvar.setEnabled(false);
			jbtEditar.setEnabled(true);
			jbtNovo.setEnabled(true);
			jbtCancelar.setEnabled(false);
		}
	}
	
	public void acionarBotaoEditar() {
		jtfNomeCarro.requestFocus();
		jtfNomeCarro.setEnabled(true);
		jtfPlacaCarro.setEnabled(true);
		jtfNomeModelo.setEnabled(true);
		jckbxForaUso.setEnabled(true);
		jbtNovo.setEnabled(false);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
	}
	
	public void acionarBotaoCancelar() {
		jtfPesquisaCodigoCarro.requestFocus();
		jtfNomeCarro.setEnabled(false);
		jtfPlacaCarro.setEnabled(false);
		jtfNomeModelo.setEnabled(false);
		jckbxForaUso.setSelected(false);
		jckbxForaUso.setEnabled(false);
		jtfCodigoCarro.setText("");
		jtfNomeCarro.setText("");
		jtfPlacaCarro.setText("");
		jtfCodigoModelo.setText("");
		jtfNomeModelo.setText("");
		jtfDataAlteracao.setText("");
		jbtNovo.setEnabled(true);
		jbtSalvar.setEnabled(false);
		jbtCancelar.setEnabled(false);
		jbtEditar.setEnabled(false);
	}
	
	public void preencherCamposCarro(Carro carro) {
		jtfCodigoCarro.setText(String.valueOf(carro.getIdCarro()));
		jtfNomeCarro.setText(carro.getNome());
		jtfPlacaCarro.setText(carro.getPlaca());
		jtfCodigoModelo.setText(String.valueOf(carro.getModelo().getIdModelo()));
		jtfNomeModelo.setText(carro.getModelo().getNome());
		jtfDataAlteracao.setText(carro.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
		if(carro.isForaUso()) {
			jckbxForaUso.setSelected(true);
		} else {
			jckbxForaUso.setSelected(false);
		}
		jtfPesquisaCodigoCarro.requestFocus();
	}
	
	public void preencherCamposModelo(Modelo modelo) {
		if(modelo.isForaUso()) {
			JOptionPane.showMessageDialog(null, "O modelo selecionada está fora de uso,\n"
			+ "por gentileza entre em contato com o responsável!\n"
			+ "Após a confirmação o cadastro será cancelado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			this.acionarBotaoCancelar();
		} else {
			jtfCodigoModelo.setText(String.valueOf(modelo.getIdModelo()));
			jtfNomeModelo.setText(modelo.getNome());
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
							salvarEdicaoCarro();
						} catch (Exception salvarEdicao) {
							salvarEdicao.printStackTrace();
						}
					} else {
						try {
							salvarCadastroCarro();
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
	}

	public void pesquisaPorCodigo() {
		jtfPesquisaCodigoCarro.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					Integer codigo = null;
					if(!jtfPesquisaCodigoCarro.getText().equals("")) {
						codigo = Integer.valueOf(jtfPesquisaCodigoCarro.getText());
					}
					ListaCarroForm listaCarro = new ListaCarroForm(carroForm, null, codigo, null);
					listaCarro.setVisible(true);
					jtfNomeCarro.setEnabled(false);
					jtfNomeModelo.setEnabled(false);
					jckbxForaUso.setEnabled(false);
					jckbxForaUso.setSelected(false);
					jtfCodigoCarro.setText("");
					jtfNomeCarro.setText("");
					jtfPlacaCarro.setText("");
					jtfCodigoModelo.setText("");
					jtfNomeModelo.setText("");
					jtfDataAlteracao.setText("");
					jtfPesquisaCodigoCarro.setText("");
					jtfPesquisaNomeCarro.setText("");
					jtfPesquisaPlacaCarro.setText("");
					jbtEditar.setEnabled(true);
					jbtSalvar.setEnabled(false);
					jbtCancelar.setEnabled(true);
				}
			}
		});
	}
		
	public void pesquisaPorNome() {
		jtfPesquisaNomeCarro.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					ListaCarroForm listaCarro = new ListaCarroForm(carroForm, jtfPesquisaNomeCarro.getText(), null, null);
					listaCarro.setVisible(true);
					jtfNomeCarro.setEnabled(false);
					jtfNomeModelo.setEnabled(false);
					jckbxForaUso.setEnabled(false);
					jckbxForaUso.setSelected(false);
					jtfCodigoCarro.setText("");
					jtfNomeCarro.setText("");
					jtfPlacaCarro.setText("");
					jtfCodigoModelo.setText("");
					jtfNomeModelo.setText("");
					jtfDataAlteracao.setText("");
					jtfPesquisaCodigoCarro.setText("");
					jtfPesquisaNomeCarro.setText("");
					jtfPesquisaPlacaCarro.setText("");
					jbtEditar.setEnabled(true);
					jbtSalvar.setEnabled(false);
					jbtCancelar.setEnabled(true);
				}
			}
		});
	}
		
	public void pesquisaPorPlaca() {
		jtfPesquisaPlacaCarro.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					ListaCarroForm listaCarro = new ListaCarroForm(carroForm, null, null, jtfPesquisaPlacaCarro.getText());
					listaCarro.setVisible(true);
					jtfNomeCarro.setEnabled(false);
					jtfNomeModelo.setEnabled(false);
					jckbxForaUso.setEnabled(false);
					jckbxForaUso.setSelected(false);
					jtfCodigoCarro.setText("");
					jtfNomeCarro.setText("");
					jtfPlacaCarro.setText("");
					jtfCodigoModelo.setText("");
					jtfNomeModelo.setText("");
					jtfDataAlteracao.setText("");
					jtfPesquisaCodigoCarro.setText("");
					jtfPesquisaNomeCarro.setText("");
					jtfPesquisaPlacaCarro.setText("");
					jbtEditar.setEnabled(true);
					jbtSalvar.setEnabled(false);
					jbtCancelar.setEnabled(true);
				}
			}
		});
	}
	
	public void pesquisaNomeModelo() {
		jtfNomeModelo.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					ListaModeloForm listaModelo = new ListaModeloForm(carroForm, jtfNomeModelo.getText(), null);
					listaModelo.setVisible(true);
				}
			}
		});
	}
		
	public CarroForm() {
		carroForm = this;
		setIconImage(Toolkit.getDefaultToolkit().getImage(CarroForm.class.getResource("/Imagens/washCar.jpeg")));
		setTitle("Cadastro de Carros do Cliente | WashCar");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 665, 285);
		jpnCarro = new JPanel();
		jpnCarro.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		componentesCarroForm();
		acoesDosBotoes();
		pesquisaPorCodigo();
		pesquisaPorNome();
		pesquisaPorPlaca();
		pesquisaNomeModelo();
	}

	@Override
	public void preencherCampos(Entidade entidade) {
		if(!jtfNomeModelo.isEnabled()) {
			this.preencherCamposCarro((Carro)entidade);
		} else {
			this.preencherCamposModelo((Modelo)entidade);
		}
	}
}