package forms.WashCar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.border.BevelBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.MaskFormatter;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import validacaoCampos.WashCar.ValidaCampoNumeroInteiro;
import validacaoCampos.WashCar.ValidaCampoString;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.SwingConstants;

public class CarroForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnCarro;
	private JPanel jpnPesquisaCarro;
	private JTextField jtfPesquisaCodigoCarro;
	private JTextField jtfPesquisaNomeCarro;
	private JTextField jtfPesquisaPlacaCarro;
	private JTextField jtfCodigoCarro;
	private JTextField jtfDataAlteracao;
	private JTextField jtfNomeCliente;
	private JTextField jtfCpfCliente;
	private JTextField jtfNomeFantasiaCliente;
	private JTextField jtfCnpjCliente;
	private JTextField jtfNomeCarro;
	private JTextField jtfPlacaCarro;
	private JTextField jtfCodigoCliente;
	private JLabel jlbPesquisaCodigoCarro;
	private JLabel jlbPesquisaNomeCarro;
	private JLabel jlbPesquisaPlacaCarro;
	private JLabel jlbCodigoCarro;
	private JLabel jlbDataAlteracao;
	private JLabel jlbNomeCliente;
	private JLabel jlbCpfCliente;
	private JLabel jlbNomeFantasiaCliente;
	private JLabel jlbCnpjCliente;
	private JLabel jlbNomeCarro;
	private JLabel jlbPlacaCarro;
	private JLabel jlbConsultaCarro;
	private JLabel jlbCodigoCliente;
	private JButton jbtNovo;
	private JButton jbtEditar;
	private JButton jbtSalvar;
	private JButton jbtFechar;
	private JButton jbtCancelar;
	private JButton jbtPesquisa;
	private JMenuBar jmbCadastroCarro;
	private JMenu jmnRelatorio;

	public void componentesCarroForm() {
		jpnPesquisaCarro = new JPanel();
		jpnPesquisaCarro.setLayout(null);
		jpnPesquisaCarro.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnPesquisaCarro.setBounds(10, 11, 640, 85);
		jpnCarro.add(jpnPesquisaCarro);
		
		jlbPesquisaCodigoCarro = new JLabel("C\u00F3digo");
		jlbPesquisaCodigoCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaCodigoCarro.setBounds(10, 38, 66, 14);
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
		jtfPesquisaNomeCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaNomeCarro.setColumns(10);
		jtfPesquisaNomeCarro.setBounds(86, 54, 275, 20);
		jpnPesquisaCarro.add(jtfPesquisaNomeCarro);
		
		jbtPesquisa = new JButton("");
		jbtPesquisa.setIcon(new ImageIcon(CarroForm.class.getResource("/Imagens/lupaPesquisa.jpeg")));
		jbtPesquisa.setBounds(565, 42, 40, 32);
		jpnPesquisaCarro.add(jbtPesquisa);
		
		try {
			jtfPesquisaPlacaCarro = new JFormattedTextField(new MaskFormatter("UUU-####"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfPesquisaPlacaCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaPlacaCarro.setColumns(10);
		jtfPesquisaPlacaCarro.setBounds(371, 54, 165, 20);
		jpnPesquisaCarro.add(jtfPesquisaPlacaCarro);
		
		jlbPesquisaPlacaCarro = new JLabel("Placa do Carro");
		jlbPesquisaPlacaCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaPlacaCarro.setBounds(371, 38, 165, 14);
		jpnPesquisaCarro.add(jlbPesquisaPlacaCarro);
		
		jlbConsultaCarro = new JLabel("Consulta Cadastro de Carros");
		jlbConsultaCarro.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbConsultaCarro.setBounds(10, 13, 351, 14);
		jpnPesquisaCarro.add(jlbConsultaCarro);
		
		jlbCodigoCarro = new JLabel("C\u00F3digo do Carro");
		jlbCodigoCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoCarro.setBounds(10, 107, 127, 14);
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
		jlbDataAlteracao.setBounds(550, 107, 100, 14);
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
		jtfDataAlteracao.setBounds(550, 123, 100, 20);
		jpnCarro.add(jtfDataAlteracao);
		
		jlbNomeCliente = new JLabel("Nome do Cliente");
		jlbNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeCliente.setBounds(10, 248, 265, 14);
		jpnCarro.add(jlbNomeCliente);
		
		jtfNomeCliente = new JTextField();
		jtfNomeCliente.setDocument(new ValidaCampoString());
		jtfNomeCliente.setEnabled(false);
		jtfNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeCliente.setColumns(10);
		jtfNomeCliente.setBounds(10, 264, 300, 20);
		jpnCarro.add(jtfNomeCliente);
		
		jlbCpfCliente = new JLabel("CPF");
		jlbCpfCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCpfCliente.setBounds(320, 248, 100, 14);
		jpnCarro.add(jlbCpfCliente);
		
		try {
			jtfCpfCliente = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfCpfCliente.setEnabled(false);
		jtfCpfCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCpfCliente.setColumns(10);
		jtfCpfCliente.setBounds(320, 264, 165, 20);
		jpnCarro.add(jtfCpfCliente);
		
		jlbNomeFantasiaCliente = new JLabel("Nome Fantasia");
		jlbNomeFantasiaCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeFantasiaCliente.setBounds(10, 295, 265, 14);
		jpnCarro.add(jlbNomeFantasiaCliente);
		
		jtfNomeFantasiaCliente = new JTextField();
		jtfNomeFantasiaCliente.setDocument(new ValidaCampoString());
		jtfNomeFantasiaCliente.setEnabled(false);
		jtfNomeFantasiaCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeFantasiaCliente.setColumns(10);
		jtfNomeFantasiaCliente.setBounds(10, 311, 300, 20);
		jpnCarro.add(jtfNomeFantasiaCliente);
		
		jlbCnpjCliente = new JLabel("CNPJ");
		jlbCnpjCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCnpjCliente.setBounds(320, 295, 100, 14);
		jpnCarro.add(jlbCnpjCliente);
		
		try {
			jtfCnpjCliente = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfCnpjCliente.setEnabled(false);
		jtfCnpjCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCnpjCliente.setColumns(10);
		jtfCnpjCliente.setBounds(320, 311, 165, 20);
		jpnCarro.add(jtfCnpjCliente);
		
		jlbNomeCarro = new JLabel("Nome do Carro");
		jlbNomeCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeCarro.setBounds(10, 154, 265, 14);
		jpnCarro.add(jlbNomeCarro);
		
		jtfNomeCarro = new JTextField();
		jtfNomeCarro.setEnabled(false);
		jtfNomeCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeCarro.setColumns(10);
		jtfNomeCarro.setBounds(10, 170, 300, 20);
		jpnCarro.add(jtfNomeCarro);
		
		try {
			jtfPlacaCarro = new JFormattedTextField(new MaskFormatter("UUU-####"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfPlacaCarro.setEnabled(false);
		jtfPlacaCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPlacaCarro.setColumns(10);
		jtfPlacaCarro.setBounds(320, 170, 165, 20);
		jpnCarro.add(jtfPlacaCarro);
		
		jlbPlacaCarro = new JLabel("Placa do Carro");
		jlbPlacaCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPlacaCarro.setBounds(320, 154, 165, 14);
		jpnCarro.add(jlbPlacaCarro);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 342, 120, 25);
		jpnCarro.add(jbtNovo);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setEnabled(false);
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setBounds(140, 342, 120, 25);
		jpnCarro.add(jbtEditar);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setEnabled(false);
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(270, 342, 120, 25);
		jpnCarro.add(jbtSalvar);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setBounds(530, 342, 120, 25);
		jpnCarro.add(jbtFechar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setEnabled(false);
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setBounds(400, 342, 120, 25);
		jpnCarro.add(jbtCancelar);
		
		jmbCadastroCarro = new JMenuBar();
		jmbCadastroCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		setJMenuBar(jmbCadastroCarro);
		
		jmnRelatorio = new JMenu("Relat\u00F3rios");
		jmnRelatorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jmbCadastroCarro.add(jmnRelatorio);
		setContentPane(jpnCarro);
		
		jtfCodigoCliente = new JTextField();
		jtfCodigoCliente.setDocument(new ValidaCampoNumeroInteiro());
		jtfCodigoCliente.setEnabled(false);
		jtfCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoCliente.setColumns(10);
		jtfCodigoCliente.setBounds(10, 217, 50, 20);
		jpnCarro.add(jtfCodigoCliente);
		
		jlbCodigoCliente = new JLabel("C\u00F3digo do Cliente");
		jlbCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoCliente.setBounds(10, 201, 135, 14);
		jpnCarro.add(jlbCodigoCliente);
	}

	public void acionarBotaoNovo() {
		jbtNovo.setEnabled(false);
		jtfNomeCliente.setEnabled(true);
		jtfNomeFantasiaCliente.setEnabled(true);
		jtfNomeCarro.setEnabled(true);
		jtfPlacaCarro.setEnabled(true);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
	}
	
	public void salvarCadastroCarro() {
		
	}
	
	public void salvarEdicaoCarro() {
		
	}
	
	public void acionarBotaoEditar() {
		
	}
	
	public void acionarBotaoCancelar() {
		jbtNovo.setEnabled(true);
		jtfNomeCliente.setEnabled(false);
		jtfNomeFantasiaCliente.setEnabled(false);
		jtfNomeCarro.setEnabled(false);
		jtfPlacaCarro.setEnabled(false);
		jtfNomeCliente.setText("");
		jtfCpfCliente.setText("");
		jtfNomeFantasiaCliente.setText("");
		jtfCnpjCliente.setText("");
		jtfNomeCarro.setText("");
		jtfPlacaCarro.setText("");
		jbtSalvar.setEnabled(false);
		jbtCancelar.setEnabled(false);
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
	
	public CarroForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CarroForm.class.getResource("/Imagens/washCar.jpeg")));
		setTitle("Cadastro de Carros do Cliente | WashCar");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 667, 430);
		jpnCarro = new JPanel();
		jpnCarro.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		componentesCarroForm();
		acoesDosBotoes();
		
	}
}