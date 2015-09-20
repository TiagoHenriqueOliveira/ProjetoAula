package forms.WashCar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import validacaoCampos.WashCar.ValidaCampoData;
import validacaoCampos.WashCar.ValidaCampoNumeroInteiro;
import validacaoCampos.WashCar.ValidaCampoString;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

public class CarroForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnCarro;
	private JTextField jtfPesquisaCodigoCarro;
	private JTextField jtfPesquisaNomeCarro;
	private JTextField jtfPesquisaPlacaCarro;
	private JTextField jtfCodigo;
	private JTextField jtfDataAlteracao;
	private JTextField jtfNomeCliente;
	private JTextField jtfCpfCliente;
	private JTextField jtfRazaoSocialCliente;
	private JTextField jtfCnpjCliente;
	private JTextField jtfNomeCarro;
	private JTextField jtfModeloCarro;
	private JTextField jtfPlacaCarro;
	private JPanel jpnPesquisaCarro;
	private JLabel jlbPesquisaCodigoCarro;
	private JLabel jlbPesquisaNomeCarro;
	private JButton jbtPesquisa;
	private JLabel jlbPesquisaPlacaCarro;
	private JLabel jlbCodigo;
	private JLabel jlbDataAlteracao;
	private JLabel jlbNomeCliente;
	private JLabel jlbCpfCliente;
	private JLabel jlbRazaoSocialCliente;
	private JLabel jlbCnpjCliente;
	private JLabel jlbNomeCarro;
	private JLabel jlbModeloCarro;
	private JLabel jlbPlacaCarro;
	private JButton jbtNovo;
	private JButton jbtEditar;
	private JButton jbtSalvar;
	private JButton jbtFechar;
	private JButton jbtCancelar;
	private JLabel jlbConsultaCarro;

	public void componentesTelaCarro() {
		jpnPesquisaCarro = new JPanel();
		jpnPesquisaCarro.setLayout(null);
		jpnPesquisaCarro.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnPesquisaCarro.setBounds(10, 11, 615, 85);
		jpnCarro.add(jpnPesquisaCarro);
		
		jlbPesquisaCodigoCarro = new JLabel("C\u00F3digo");
		jlbPesquisaCodigoCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaCodigoCarro.setBounds(10, 38, 46, 14);
		jpnPesquisaCarro.add(jlbPesquisaCodigoCarro);
		
		jtfPesquisaCodigoCarro = new JTextField();
		jtfPesquisaCodigoCarro.setDocument(new ValidaCampoNumeroInteiro());
		jtfPesquisaCodigoCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaCodigoCarro.setColumns(10);
		jtfPesquisaCodigoCarro.setBounds(10, 54, 66, 20);
		jpnPesquisaCarro.add(jtfPesquisaCodigoCarro);
		
		jlbPesquisaNomeCarro = new JLabel("Nome do Cliente / Nome Fantasia");
		jlbPesquisaNomeCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaNomeCarro.setBounds(86, 38, 217, 14);
		jpnPesquisaCarro.add(jlbPesquisaNomeCarro);
		
		jtfPesquisaNomeCarro = new JTextField();
		jtfPesquisaNomeCarro.setDocument(new ValidaCampoString());
		jtfPesquisaNomeCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaNomeCarro.setColumns(10);
		jtfPesquisaNomeCarro.setBounds(86, 54, 275, 20);
		jpnPesquisaCarro.add(jtfPesquisaNomeCarro);
		
		jbtPesquisa = new JButton("");
		jbtPesquisa.setIcon(new ImageIcon(CarroForm.class.getResource("/Imagens/lupaPesquisa.jpeg")));
		jbtPesquisa.setBounds(565, 42, 40, 32);
		jpnPesquisaCarro.add(jbtPesquisa);
		
		jtfPesquisaPlacaCarro = new JTextField();
		jtfPesquisaPlacaCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaPlacaCarro.setColumns(10);
		jtfPesquisaPlacaCarro.setBounds(371, 54, 165, 20);
		jpnPesquisaCarro.add(jtfPesquisaPlacaCarro);
		
		jlbPesquisaPlacaCarro = new JLabel("Placa do Carro");
		jlbPesquisaPlacaCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaPlacaCarro.setBounds(371, 38, 100, 14);
		jpnPesquisaCarro.add(jlbPesquisaPlacaCarro);
		
		jlbConsultaCarro = new JLabel("Consulta Cadastro de Carros");
		jlbConsultaCarro.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbConsultaCarro.setBounds(10, 13, 200, 14);
		jpnPesquisaCarro.add(jlbConsultaCarro);
		
		jlbCodigo = new JLabel("C\u00F3digo");
		jlbCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigo.setBounds(10, 107, 46, 14);
		jpnCarro.add(jlbCodigo);
		
		jtfCodigo = new JTextField();
		jtfCodigo.setDocument(new ValidaCampoNumeroInteiro());
		jtfCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigo.setEditable(false);
		jtfCodigo.setColumns(10);
		jtfCodigo.setBackground(Color.YELLOW);
		jtfCodigo.setBounds(10, 123, 66, 20);
		jpnCarro.add(jtfCodigo);
		
		jlbDataAlteracao = new JLabel("Data Alteracao");
		jlbDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataAlteracao.setBounds(525, 107, 100, 14);
		jpnCarro.add(jlbDataAlteracao);
		
		try {
			jtfDataAlteracao = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfDataAlteracao.setDocument(new ValidaCampoData());
		jtfDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfDataAlteracao.setEditable(false);
		jtfDataAlteracao.setColumns(10);
		jtfDataAlteracao.setBackground(Color.YELLOW);
		jtfDataAlteracao.setBounds(525, 123, 100, 20);
		jpnCarro.add(jtfDataAlteracao);
		
		jlbNomeCliente = new JLabel("Nome do Cliente");
		jlbNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeCliente.setBounds(10, 154, 150, 14);
		jpnCarro.add(jlbNomeCliente);
		
		jtfNomeCliente = new JTextField();
		jtfNomeCliente.setEnabled(false);
		jtfNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeCliente.setColumns(10);
		jtfNomeCliente.setBounds(10, 170, 381, 20);
		jpnCarro.add(jtfNomeCliente);
		
		jlbCpfCliente = new JLabel("CPF");
		jlbCpfCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCpfCliente.setBounds(460, 154, 100, 14);
		jpnCarro.add(jlbCpfCliente);
		
		try {
			jtfCpfCliente = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfCpfCliente.setEnabled(false);
		jtfCpfCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCpfCliente.setColumns(10);
		jtfCpfCliente.setBounds(460, 170, 165, 20);
		jpnCarro.add(jtfCpfCliente);
		
		jlbRazaoSocialCliente = new JLabel("Nome Fantasia");
		jlbRazaoSocialCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbRazaoSocialCliente.setBounds(10, 201, 150, 14);
		jpnCarro.add(jlbRazaoSocialCliente);
		
		jtfRazaoSocialCliente = new JTextField();
		jtfRazaoSocialCliente.setDocument(new ValidaCampoString());
		jtfRazaoSocialCliente.setEnabled(false);
		jtfRazaoSocialCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfRazaoSocialCliente.setColumns(10);
		jtfRazaoSocialCliente.setBounds(10, 217, 381, 20);
		jpnCarro.add(jtfRazaoSocialCliente);
		
		jlbCnpjCliente = new JLabel("CNPJ");
		jlbCnpjCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCnpjCliente.setBounds(460, 201, 100, 14);
		jpnCarro.add(jlbCnpjCliente);
		
		try {
			jtfCnpjCliente = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfCnpjCliente.setEnabled(false);
		jtfCnpjCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCnpjCliente.setColumns(10);
		jtfCnpjCliente.setBounds(460, 217, 165, 20);
		jpnCarro.add(jtfCnpjCliente);
		
		jlbNomeCarro = new JLabel("Nome do Carro");
		jlbNomeCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeCarro.setBounds(10, 248, 150, 14);
		jpnCarro.add(jlbNomeCarro);
		
		jtfNomeCarro = new JTextField();
		jtfNomeCarro.setEnabled(false);
		jtfNomeCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeCarro.setColumns(10);
		jtfNomeCarro.setBounds(10, 264, 265, 20);
		jpnCarro.add(jtfNomeCarro);
		
		jlbModeloCarro = new JLabel("Modelo do Carro");
		jlbModeloCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbModeloCarro.setBounds(285, 248, 150, 14);
		jpnCarro.add(jlbModeloCarro);
		
		jtfModeloCarro = new JTextField();
		jtfModeloCarro.setEnabled(false);
		jtfModeloCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfModeloCarro.setColumns(10);
		jtfModeloCarro.setBounds(285, 264, 165, 20);
		jpnCarro.add(jtfModeloCarro);
		
		jtfPlacaCarro = new JTextField();
		jtfPlacaCarro.setEnabled(false);
		jtfPlacaCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPlacaCarro.setColumns(10);
		jtfPlacaCarro.setBounds(460, 264, 165, 20);
		jpnCarro.add(jtfPlacaCarro);
		
		jlbPlacaCarro = new JLabel("Placa do Carro");
		jlbPlacaCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPlacaCarro.setBounds(460, 248, 100, 14);
		jpnCarro.add(jlbPlacaCarro);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 295, 110, 23);
		jpnCarro.add(jbtNovo);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setEnabled(false);
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setBounds(138, 295, 110, 23);
		jpnCarro.add(jbtEditar);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setEnabled(false);
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(265, 295, 110, 23);
		jpnCarro.add(jbtSalvar);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setBounds(515, 295, 110, 23);
		jpnCarro.add(jbtFechar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setEnabled(false);
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setBounds(390, 295, 110, 23);
		jpnCarro.add(jbtCancelar);
	}

	public void novoCadastro() {
		jbtNovo.setEnabled(false);
		jtfNomeCliente.setEnabled(true);
		jtfRazaoSocialCliente.setEnabled(true);
		jtfNomeCarro.setEnabled(true);
		jtfModeloCarro.setEnabled(true);
		jtfPlacaCarro.setEnabled(true);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
	}
	
	public void salvarCadastro() {
		
	}
	
	public void editarCadastro() {
		
	}
	
	public void cancelarCadastro() {
		jbtNovo.setEnabled(true);
		jtfNomeCliente.setEnabled(false);
		jtfRazaoSocialCliente.setEnabled(false);
		jtfNomeCarro.setEnabled(false);
		jtfModeloCarro.setEnabled(false);
		jtfPlacaCarro.setEnabled(false);
		jtfNomeCliente.setText("");
		jtfCpfCliente.setText("");
		jtfRazaoSocialCliente.setText("");
		jtfCnpjCliente.setText("");
		jtfNomeCarro.setText("");
		jtfModeloCarro.setText("");
		jtfPlacaCarro.setText("");
		jbtSalvar.setEnabled(false);
		jbtCancelar.setEnabled(false);
	}
	
	public CarroForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CarroForm.class.getResource("/Imagens/washCar.jpeg")));
		setTitle("Cadastro de Carros do Cliente | WashCar");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 642, 356);
		jpnCarro = new JPanel();
		jpnCarro.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(jpnCarro);
				
		componentesTelaCarro();
		
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