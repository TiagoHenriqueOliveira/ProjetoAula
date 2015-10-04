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
	private JTextField jtfCodigo;
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
	private JTextField jtfCodigoModelo;
	private JTextField jtfNomeMarca;
	private JMenuItem jmiRelatorioGeralTodos;
	private JMenu jmnRelatorio;
	private JMenuBar jmbModelo;
	private JLabel jlbNomeMarca;
	private JLabel jlbCodigoMarca;

	public void componentesTelaModelo() {
		jpnPesquisaModelo = new JPanel();
		jpnPesquisaModelo.setLayout(null);
		jpnPesquisaModelo.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnPesquisaModelo.setBounds(10, 11, 540, 86);
		jpnModelo.add(jpnPesquisaModelo);
		
		jtfPesquisaCodigoModelo = new JTextField();
		jtfPesquisaCodigoModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaCodigoModelo.setColumns(10);
		jtfPesquisaCodigoModelo.setBounds(10, 54, 66, 20);
		jpnPesquisaModelo.add(jtfPesquisaCodigoModelo);
		
		jtfPesquisaNomeModelo = new JTextField();
		jtfPesquisaNomeModelo.setDocument(new ValidaCampoString());
		jtfPesquisaNomeModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaNomeModelo.setColumns(10);
		jtfPesquisaNomeModelo.setBounds(86, 54, 275, 20);
		jpnPesquisaModelo.add(jtfPesquisaNomeModelo);
		
		jlbPesquisaCodigoModelo = new JLabel("C\u00F3digo");
		jlbPesquisaCodigoModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaCodigoModelo.setBounds(10, 38, 46, 14);
		jpnPesquisaModelo.add(jlbPesquisaCodigoModelo);
		
		jlbPesquisaNomeModelo = new JLabel("Nome do Modelo");
		jlbPesquisaNomeModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaNomeModelo.setBounds(86, 38, 100, 14);
		jpnPesquisaModelo.add(jlbPesquisaNomeModelo);
		
		jbtPesquisaModelo = new JButton("");
		jbtPesquisaModelo.setIcon(new ImageIcon(ModeloForm.class.getResource("/Imagens/lupaPesquisa.jpeg")));
		jbtPesquisaModelo.setBounds(367, 43, 40, 32);
		jpnPesquisaModelo.add(jbtPesquisaModelo);
		
		jlbConsultaModelos = new JLabel("Consulta Modelos de Carros");
		jlbConsultaModelos.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbConsultaModelos.setBounds(10, 11, 200, 14);
		jpnPesquisaModelo.add(jlbConsultaModelos);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 300, 100, 23);
		jpnModelo.add(jbtNovo);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setEnabled(false);
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(120, 300, 100, 23);
		jpnModelo.add(jbtSalvar);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setEnabled(false);
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setBounds(230, 300, 100, 23);
		jpnModelo.add(jbtEditar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setEnabled(false);
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setBounds(340, 300, 100, 23);
		jpnModelo.add(jbtCancelar);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setToolTipText("");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setBounds(450, 300, 100, 23);
		jpnModelo.add(jbtFechar);
		
		jtfCodigo = new JTextField();
		jtfCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigo.setEditable(false);
		jtfCodigo.setColumns(10);
		jtfCodigo.setBackground(Color.YELLOW);
		jtfCodigo.setBounds(10, 125, 86, 20);
		jpnModelo.add(jtfCodigo);
		
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
		jtfDataAlteracao.setBounds(450, 269, 100, 20);
		jpnModelo.add(jtfDataAlteracao);
		
		jlbDataAlteracao = new JLabel("Data Altera\u00E7\u00E3o");
		jlbDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataAlteracao.setBounds(450, 253, 100, 14);
		jpnModelo.add(jlbDataAlteracao);
		
		jckbForaUso = new JCheckBox("Fora de Uso");
		jckbForaUso.setEnabled(false);
		jckbForaUso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jckbForaUso.setBounds(436, 124, 115, 23);
		jpnModelo.add(jckbForaUso);
		
		jlbCodigoMarca = new JLabel("C\u00F3digo da Marca");
		jlbCodigoMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoMarca.setBounds(10, 204, 158, 14);
		jpnModelo.add(jlbCodigoMarca);
		
		jtfCodigoModelo = new JTextField();
		jtfCodigoModelo.setEditable(false);
		jtfCodigoModelo.setBackground(Color.YELLOW);
		jtfCodigoModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoModelo.setBounds(10, 221, 86, 20);
		jpnModelo.add(jtfCodigoModelo);
		jtfCodigoModelo.setColumns(10);
		
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
		jtfNomeModelo.setEnabled(true);
		jtfNomeMarca.setEnabled(true);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
		jbtEditar.setEnabled(false);
	}
	
	public void salvarCadastroModelo() {
		
	}
	
	public void salvarEdicaoModelo() {
		
	}
	
	public void acionarBotaoEditar() {
		
	}
	
	public void acionarBotaoCancelar() {
		jbtNovo.setEnabled(true);
		jtfNomeModelo.setEnabled(false);
		jtfNomeMarca.setEnabled(false);
		jtfNomeModelo.setText("");
		jtfNomeMarca.setText("");
		jbtSalvar.setEnabled(false);
		jbtCancelar.setEnabled(false);
		jbtEditar.setEnabled(false);
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
			}
		});
		
		jbtEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent acvt) {
				
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

	public ModeloForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModeloForm.class.getResource("/Imagens/washCar.jpeg")));
		setResizable(false);
		setTitle("Cadastrar Modelos de Carros | WashCar");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 566, 385);
		jpnModelo = new JPanel();
		jpnModelo.setLayout(null);
		setLocationRelativeTo(null);
				
		componentesTelaModelo();
		acoesDosBotoes();
	}
}