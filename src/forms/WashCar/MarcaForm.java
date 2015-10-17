package forms.WashCar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.time.format.DateTimeFormatter;

import javax.swing.JCheckBox;

import daoFactory.WashCar.DaoFactory;
import model.WashCar.Marca;
import validacaoCampos.WashCar.ValidaCampoNumeroInteiro;
import validacaoCampos.WashCar.ValidaCampoString;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class MarcaForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnMarca;
	private JTextField jtfPesquisaCodigoMarca;
	private JTextField jtfPesquisaNomeMarca;
	private JTextField jtfCodigoMarca;
	private JTextField jtfNomeMarca;
	private JTextField jtfDataAlteracao;
	private JPanel jpnPesquisaMarcas;
	private JLabel jlbCodigo;
	private JLabel lblNomeDaMarca;
	private JButton jbtNovo;
	private JButton jbtSalvar;
	private JButton jbtEditar;
	private JButton jbtCancelar;
	private JButton jbtFechar;
	private JLabel jlbCodigoMarca;
	private JLabel lblNomeDaMarca_1;
	private JLabel jlbDataAlteracao;
	private JLabel jlbConsultaMarcas;
	private JCheckBox jcbxForaUso;
	private JMenuItem jmiRelatorioGeral;
	private JMenu jmnRelatorio;
	private JMenuBar jmbMarcas;
	private Marca marca;
	private static MarcaForm marcaForm;
	private String nomeMarca;
	private String codigoMarca;
	
	public void componentesTelaMarca() {
		jpnPesquisaMarcas = new JPanel();
		jpnPesquisaMarcas.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnPesquisaMarcas.setBounds(10, 11, 640, 82);
		jpnMarca.add(jpnPesquisaMarcas);
		jpnPesquisaMarcas.setLayout(null);
		
		jtfPesquisaCodigoMarca = new JTextField();
		jtfPesquisaCodigoMarca.setDocument(new ValidaCampoNumeroInteiro());
		jtfPesquisaCodigoMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaCodigoMarca.setBounds(10, 52, 50, 20);
		jpnPesquisaMarcas.add(jtfPesquisaCodigoMarca);
		jtfPesquisaCodigoMarca.setColumns(10);
		
		jtfPesquisaNomeMarca = new JTextField();
		jtfPesquisaNomeMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaNomeMarca.setBounds(86, 52, 275, 20);
		jpnPesquisaMarcas.add(jtfPesquisaNomeMarca);
		jtfPesquisaNomeMarca.setColumns(10);
		
		jlbCodigo = new JLabel("C\u00F3digo");
		jlbCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigo.setBounds(10, 36, 66, 14);
		jpnPesquisaMarcas.add(jlbCodigo);
		
		lblNomeDaMarca = new JLabel("Nome da Marca");
		lblNomeDaMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeDaMarca.setBounds(86, 36, 275, 14);
		jpnPesquisaMarcas.add(lblNomeDaMarca);
		
		jlbConsultaMarcas = new JLabel("Consulta Marcas de Carros");
		jlbConsultaMarcas.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbConsultaMarcas.setBounds(10, 11, 351, 14);
		jpnPesquisaMarcas.add(jlbConsultaMarcas);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 200, 120, 25);
		jpnMarca.add(jbtNovo);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setEnabled(false);
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(140, 200, 120, 25);
		jpnMarca.add(jbtSalvar);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setEnabled(false);
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setBounds(270, 200, 120, 25);
		jpnMarca.add(jbtEditar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setEnabled(false);
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setBounds(400, 200, 120, 25);
		jpnMarca.add(jbtCancelar);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setToolTipText("");
		jbtFechar.setBounds(530, 200, 120, 25);
		jpnMarca.add(jbtFechar);
		
		jtfCodigoMarca = new JTextField();
		jtfCodigoMarca.setBackground(Color.YELLOW);
		jtfCodigoMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoMarca.setEditable(false);
		jtfCodigoMarca.setBounds(10, 121, 50, 20);
		jpnMarca.add(jtfCodigoMarca);
		jtfCodigoMarca.setColumns(10);
		
		jtfNomeMarca = new JTextField();
		jtfNomeMarca.setDocument(new ValidaCampoString());
		jtfNomeMarca.setEnabled(false);
		jtfNomeMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeMarca.setBounds(10, 169, 330, 20);
		jpnMarca.add(jtfNomeMarca);
		jtfNomeMarca.setColumns(10);
		
		jlbCodigoMarca = new JLabel("C\u00F3digo");
		jlbCodigoMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoMarca.setBounds(10, 104, 80, 14);
		jpnMarca.add(jlbCodigoMarca);
		
		lblNomeDaMarca_1 = new JLabel("Nome da Marca");
		lblNomeDaMarca_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeDaMarca_1.setBounds(10, 152, 330, 14);
		jpnMarca.add(lblNomeDaMarca_1);
		
		try {
			jtfDataAlteracao = new JFormattedTextField(new MaskFormatter("##/##/####"));
			jtfDataAlteracao.setHorizontalAlignment(SwingConstants.RIGHT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfDataAlteracao.setBackground(Color.YELLOW);
		jtfDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfDataAlteracao.setEditable(false);
		jtfDataAlteracao.setBounds(550, 169, 100, 20);
		jpnMarca.add(jtfDataAlteracao);
		jtfDataAlteracao.setColumns(10);
		
		jlbDataAlteracao = new JLabel("Data Altera\u00E7\u00E3o");
		jlbDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataAlteracao.setBounds(550, 153, 100, 14);
		jpnMarca.add(jlbDataAlteracao);
		
		jcbxForaUso = new JCheckBox("Fora de Uso");
		jcbxForaUso.setEnabled(false);
		jcbxForaUso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jcbxForaUso.setBounds(530, 120, 120, 23);
		jpnMarca.add(jcbxForaUso);
		
		jmbMarcas = new JMenuBar();
		jmbMarcas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		setJMenuBar(jmbMarcas);
		
		jmnRelatorio = new JMenu("Relat\u00F3rios");
		jmnRelatorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jmbMarcas.add(jmnRelatorio);
		
		jmiRelatorioGeral = new JMenuItem("Relat\u00F3rio Geral - Todas as Marcas");
		jmiRelatorioGeral.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jmnRelatorio.add(jmiRelatorioGeral);
		setContentPane(jpnMarca);
		jpnMarca.setLayout(null);
	}
	
	public void acionarBotaoNovo() {
		jtfNomeMarca.requestFocus();
		jbtNovo.setEnabled(false);
		jtfNomeMarca.setEnabled(true);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
	}
	
	@SuppressWarnings("static-access")
	public void salvarCadastroMarca() throws Exception {
		this.marca = new Marca();
		if(jtfNomeMarca.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o nome da marca!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeMarca.requestFocus();
		} else {
			this.marca.setNome(jtfNomeMarca.getText());
			this.marca.setDataAltercacao(Date.valueOf(marca.getDataAltercacao().now()).toLocalDate());
			this.marca.setForaUso(Boolean.valueOf(jcbxForaUso.isSelected()));
			DaoFactory.getFactory().marcaDao().inserir(marca);
			jtfCodigoMarca.setText(String.valueOf(this.marca.getIdMarca()));
			jtfDataAlteracao.setText(this.marca.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
			jtfNomeMarca.setEnabled(false);
			JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!!!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	@SuppressWarnings("static-access")
	public void salvarEdicaoMarca() throws Exception{
		this.marca = new Marca();
		if(jtfNomeMarca.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o nome da marca!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeMarca.requestFocus();
		} else {
			this.marca.setNome(jtfNomeMarca.getText());
			this.marca.setDataAltercacao(Date.valueOf(marca.getDataAltercacao().now()).toLocalDate());
			this.marca.setForaUso(Boolean.valueOf(jcbxForaUso.isSelected()));
			this.marca.setIdMarca(Integer.valueOf(jtfCodigoMarca.getText()));
			DaoFactory.getFactory().marcaDao().alterar(marca);
			jtfDataAlteracao.setText(this.marca.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
			jtfNomeMarca.setEnabled(false);
			JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!!!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void acionarBotaoEditar() {
		jtfNomeMarca.setEnabled(true);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
		jbtNovo.setEnabled(false);
		jcbxForaUso.setEnabled(true);
	}
	
	public void acionarBotaoCancelar() {
		jtfPesquisaCodigoMarca.requestFocus();
		jbtNovo.setEnabled(true);
		jtfNomeMarca.setEnabled(false);
		jtfCodigoMarca.setText(null);
		jtfDataAlteracao.setText(null);
		jtfNomeMarca.setText(null);
		jtfPesquisaCodigoMarca.setText(null);
		jtfPesquisaNomeMarca.setText(null);
		jbtSalvar.setEnabled(false);
		jbtCancelar.setEnabled(false);
		jbtEditar.setEnabled(false);
	}
	
	public void preencherCampos(Marca marca) {
		jtfCodigoMarca.setText(String.valueOf(marca.getIdMarca()));
		jtfNomeMarca.setText(marca.getNome());
		jtfDataAlteracao.setText(marca.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
		if(marca.isForaUso()) {
			jcbxForaUso.setSelected(true);
		} else {
			jcbxForaUso.setSelected(false);
		}
		jtfPesquisaCodigoMarca.setText(null);
		jtfPesquisaNomeMarca.setText(null);
		jtfPesquisaCodigoMarca.requestFocus();
	}
	
	public void pesquisaPorCodigo() {
		jtfPesquisaCodigoMarca.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					setCodigoMarca(jtfPesquisaCodigoMarca.getText());
					ListaMarcaForm listaMarca = new ListaMarcaForm(marcaForm);
					listaMarca.setVisible(true);
					jtfNomeMarca.setEnabled(false);
					jtfNomeMarca.setText(null);
					jtfCodigoMarca.setText(null);
					jtfDataAlteracao.setText(null);
					jcbxForaUso.setSelected(false);
					jcbxForaUso.setEnabled(false);
					jbtEditar.setEnabled(true);
					jbtNovo.setEnabled(true);
					jbtCancelar.setEnabled(true);
					jbtSalvar.setEnabled(false);
				}
			}
		});
	}
	
	public void pesquisaPorNome() {
		jtfPesquisaNomeMarca.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					setNomeMarca(jtfPesquisaNomeMarca.getText());
					ListaMarcaForm listaMarca = new ListaMarcaForm(marcaForm);
					listaMarca.setVisible(true);
					jtfNomeMarca.setEnabled(false);
					jtfNomeMarca.setText(null);
					jtfCodigoMarca.setText(null);
					jtfDataAlteracao.setText(null);
					jcbxForaUso.setSelected(false);
					jcbxForaUso.setEnabled(false);
					jbtEditar.setEnabled(true);
					jbtNovo.setEnabled(true);
					jbtCancelar.setEnabled(true);
					jbtSalvar.setEnabled(false);
				}
			}
		});
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
							salvarEdicaoMarca();
						} catch (Exception salvarEdicao) {
							salvarEdicao.printStackTrace();
						}
					} else {
						try {
							salvarCadastroMarca();
						} catch (Exception salvarCadastro) {
							salvarCadastro.printStackTrace();
						}
					}
				}
			}
		});
		
		jbtEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent acvt) {
				acionarBotaoEditar();
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
	
	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	public String getCodigoMarca() {
		return codigoMarca;
	}

	public void setCodigoMarca(String codigoMarca) {
		this.codigoMarca = codigoMarca;
	}

	public MarcaForm() {
		marcaForm = this;
		setIconImage(Toolkit.getDefaultToolkit().getImage(MarcaForm.class.getResource("/Imagens/washCar.jpeg")));
		setTitle("Cadastrar Marcas de Carros | WashCar");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 666, 285);
		setLocationRelativeTo(null);
		jpnMarca = new JPanel();		
		
		componentesTelaMarca();
		acoesDosBotoes();
		pesquisaPorCodigo();
		pesquisaPorNome();
	}
}