package forms.WashCar;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.text.MaskFormatter;

import model.WashCar.Modelo;

import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

import validacaoCampos.WashCar.ValidaCampoString;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ModeloForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnModelo;
	private JTextField jtfPesquisaCodigoModelo;
	private JTextField jtfPesquisaNomeModelo;
	private JTextField jtfCodigoModelo;
	private JTextField jtfNomeModelo;
	private JTextField jtfDataAlteracao;
	private JPanel jpnPesquisaModelo;
	private JLabel jlbPesquisaCodigoModelo;
	private JLabel jlbPesquisaNomeModelo;
	private JButton jbtPesquisaModelo;
	private JButton jbtNovo;
	private JButton jbtSalvar;
	private JButton jbtEditar;
	private JButton jbtCancelar;
	private JButton jbtFechar;
	private JLabel jlbCodigoModelo;
	private JLabel jlbNomeModelo;
	private JLabel jlbDataAlteracao;
	private JCheckBox jckbForaUso;
	private JLabel jlbConsultaModelos;
	private JTextField jtfCodigoMarca;
	private JTextField jtfNomeMarca;
	private JMenuItem jmiRelatorioGeralTodos;
	private JMenu jmnRelatorio;
	private JMenuBar jmbModelo;
	private JLabel jlbNomeMarca;
	private JLabel jlbCodigoMarca;
	private static ModeloForm modeloForm;

	public void componentesTelaModelo() {
		jpnPesquisaModelo = new JPanel();
		jpnPesquisaModelo.setLayout(null);
		jpnPesquisaModelo.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnPesquisaModelo.setBounds(10, 11, 640, 86);
		jpnModelo.add(jpnPesquisaModelo);
		
		jtfPesquisaCodigoModelo = new JTextField();
		jtfPesquisaCodigoModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaCodigoModelo.setColumns(10);
		jtfPesquisaCodigoModelo.setBounds(10, 54, 50, 20);
		jpnPesquisaModelo.add(jtfPesquisaCodigoModelo);
		
		jtfPesquisaNomeModelo = new JTextField();
		jtfPesquisaNomeModelo.setDocument(new ValidaCampoString());
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
		
		jbtPesquisaModelo = new JButton("");
		jbtPesquisaModelo.setIcon(new ImageIcon(ModeloForm.class.getResource("/Imagens/lupaPesquisa.jpeg")));
		jbtPesquisaModelo.setBounds(371, 42, 40, 32);
		jpnPesquisaModelo.add(jbtPesquisaModelo);
		
		jlbConsultaModelos = new JLabel("Consulta Modelos de Carros");
		jlbConsultaModelos.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbConsultaModelos.setBounds(10, 11, 351, 14);
		jpnPesquisaModelo.add(jlbConsultaModelos);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 300, 120, 25);
		jpnModelo.add(jbtNovo);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setEnabled(false);
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(140, 300, 120, 25);
		jpnModelo.add(jbtSalvar);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setEnabled(false);
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setBounds(270, 300, 120, 25);
		jpnModelo.add(jbtEditar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setEnabled(false);
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setBounds(400, 300, 120, 25);
		jpnModelo.add(jbtCancelar);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setToolTipText("");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setBounds(530, 300, 120, 25);
		jpnModelo.add(jbtFechar);
		
		jtfCodigoModelo = new JTextField();
		jtfCodigoModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoModelo.setEditable(false);
		jtfCodigoModelo.setColumns(10);
		jtfCodigoModelo.setBackground(Color.YELLOW);
		jtfCodigoModelo.setBounds(10, 125, 50, 20);
		jpnModelo.add(jtfCodigoModelo);
		
		jtfNomeModelo = new JTextField();
		jtfNomeModelo.setEnabled(false);
		jtfNomeModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeModelo.setColumns(10);
		jtfNomeModelo.setBounds(10, 173, 300, 20);
		jpnModelo.add(jtfNomeModelo);
		
		jlbCodigoModelo = new JLabel("C\u00F3digo do Modelo");
		jlbCodigoModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoModelo.setBounds(10, 108, 158, 14);
		jpnModelo.add(jlbCodigoModelo);
		
		jlbNomeModelo = new JLabel("Nome do Modelo");
		jlbNomeModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeModelo.setBounds(10, 156, 158, 14);
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
		jtfDataAlteracao.setBounds(550, 269, 100, 20);
		jpnModelo.add(jtfDataAlteracao);
		
		jlbDataAlteracao = new JLabel("Data Altera\u00E7\u00E3o");
		jlbDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataAlteracao.setBounds(550, 253, 100, 14);
		jpnModelo.add(jlbDataAlteracao);
		
		jckbForaUso = new JCheckBox("Fora de Uso");
		jckbForaUso.setEnabled(false);
		jckbForaUso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jckbForaUso.setBounds(530, 124, 120, 23);
		jpnModelo.add(jckbForaUso);
		
		jlbCodigoMarca = new JLabel("C\u00F3digo da Marca");
		jlbCodigoMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoMarca.setBounds(10, 204, 158, 14);
		jpnModelo.add(jlbCodigoMarca);
		
		jtfCodigoMarca = new JTextField();
		jtfCodigoMarca.setEditable(false);
		jtfCodigoMarca.setBackground(Color.YELLOW);
		jtfCodigoMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoMarca.setBounds(10, 221, 50, 20);
		jpnModelo.add(jtfCodigoMarca);
		jtfCodigoMarca.setColumns(10);
		
		jlbNomeMarca = new JLabel("Nome da Marca");
		jlbNomeMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeMarca.setBounds(10, 252, 158, 14);
		jpnModelo.add(jlbNomeMarca);
		
		jtfNomeMarca = new JTextField();
		jtfNomeMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeMarca.setEnabled(false);
		jtfNomeMarca.setColumns(10);
		jtfNomeMarca.setBounds(10, 269, 300, 20);
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
		jbtNovo.setEnabled(false);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
		jbtEditar.setEnabled(false);
		jtfNomeModelo.setEnabled(true);
		jtfNomeMarca.setEnabled(true);
	}
	
	public void salvarCadastroModelo() {
		
	}
	
	public void salvarEdicaoModelo() {
		
	}
	
	public void acionarBotaoEditar() {
		jbtNovo.setEnabled(false);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
		jtfNomeModelo.setEnabled(true);
		jtfNomeMarca.setEnabled(true);
		jckbForaUso.setEnabled(true);
	}
	
	public void acionarBotaoCancelar() {
		jbtNovo.setEnabled(true);
		jbtSalvar.setEnabled(false);
		jbtCancelar.setEnabled(false);
		jbtEditar.setEnabled(false);
		jtfNomeModelo.setEnabled(false);
		jtfNomeMarca.setEnabled(false);
		jtfCodigoModelo.setText("");
		jtfNomeModelo.setText("");
		jtfCodigoMarca.setText("");
		jtfNomeMarca.setText("");
		jtfDataAlteracao.setText("");
		jckbForaUso.setSelected(false);
		jckbForaUso.setEnabled(false);
	}
	
	@SuppressWarnings("deprecation")
	public void acionarBotaoPesquisar() {
		ListaModeloForm listaModeloForm = new ListaModeloForm(modeloForm);
		listaModeloForm.show();
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
	}
	
	public void preencherCampos(Modelo modelo) {
		
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
						} catch (Exception salvarEdicao) {
							salvarEdicao.printStackTrace();
						}
					} else {
						try {
							salvarCadastroModelo();
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
		
		jbtPesquisaModelo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent acvt) {
				if(acvt.getSource() == jbtPesquisaModelo) {
					acionarBotaoPesquisar();
				}				
			}
		});
	}

	public ModeloForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModeloForm.class.getResource("/Imagens/washCar.jpeg")));
		setResizable(false);
		setTitle("Cadastrar Modelos de Carros | WashCar");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 666, 385);
		jpnModelo = new JPanel();
		jpnModelo.setLayout(null);
		setLocationRelativeTo(null);
				
		componentesTelaModelo();
		acoesDosBotoes();
	}
}