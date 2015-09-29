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
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JCheckBox;

import daoFactory.WashCar.DaoFactory;
import model.WashCar.Marca;
import validacaoCampos.WashCar.ValidaCampoNumeroInteiro;
import validacaoCampos.WashCar.ValidaCampoString;

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
	private JButton jbtPesquisar;
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
	private Marca marca;
	private static MarcaForm marcaForm;
	

	//teste
	public void componentesTelaMarca() {
		jpnPesquisaMarcas = new JPanel();
		jpnPesquisaMarcas.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnPesquisaMarcas.setBounds(10, 11, 414, 82);
		jpnMarca.add(jpnPesquisaMarcas);
		jpnPesquisaMarcas.setLayout(null);
		
		jtfPesquisaCodigoMarca = new JTextField();
		jtfPesquisaCodigoMarca.setDocument(new ValidaCampoNumeroInteiro());
		jtfPesquisaCodigoMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaCodigoMarca.setBounds(10, 52, 66, 20);
		jpnPesquisaMarcas.add(jtfPesquisaCodigoMarca);
		jtfPesquisaCodigoMarca.setColumns(10);
		
		jtfPesquisaNomeMarca = new JTextField();
		jtfPesquisaNomeMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaNomeMarca.setBounds(86, 52, 275, 20);
		jpnPesquisaMarcas.add(jtfPesquisaNomeMarca);
		jtfPesquisaNomeMarca.setColumns(10);
		
		jlbCodigo = new JLabel("C\u00F3digo");
		jlbCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigo.setBounds(10, 36, 46, 14);
		jpnPesquisaMarcas.add(jlbCodigo);
		
		lblNomeDaMarca = new JLabel("Nome da Marca");
		lblNomeDaMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeDaMarca.setBounds(86, 36, 90, 14);
		jpnPesquisaMarcas.add(lblNomeDaMarca);
		
		jbtPesquisar = new JButton("");
		jbtPesquisar.setBounds(367, 41, 40, 32);
		jpnPesquisaMarcas.add(jbtPesquisar);
		jbtPesquisar.setIcon(new ImageIcon(MarcaForm.class.getResource("/Imagens/lupaPesquisa.jpeg")));
		
		jlbConsultaMarcas = new JLabel("Consulta Marcas de Carros");
		jlbConsultaMarcas.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbConsultaMarcas.setBounds(10, 11, 200, 14);
		jpnPesquisaMarcas.add(jlbConsultaMarcas);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 216, 75, 23);
		jpnMarca.add(jbtNovo);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setEnabled(false);
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(93, 216, 75, 23);
		jpnMarca.add(jbtSalvar);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setEnabled(false);
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setBounds(178, 216, 75, 23);
		jpnMarca.add(jbtEditar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setEnabled(false);
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setBounds(261, 216, 80, 23);
		jpnMarca.add(jbtCancelar);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setToolTipText("");
		jbtFechar.setBounds(350, 216, 75, 23);
		jpnMarca.add(jbtFechar);
		
		jtfCodigoMarca = new JTextField();
		jtfCodigoMarca.setBackground(Color.YELLOW);
		jtfCodigoMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoMarca.setEditable(false);
		jtfCodigoMarca.setBounds(10, 121, 86, 20);
		jpnMarca.add(jtfCodigoMarca);
		jtfCodigoMarca.setColumns(10);
		
		jtfNomeMarca = new JTextField();
		jtfNomeMarca.setDocument(new ValidaCampoString());
		jtfNomeMarca.setEnabled(false);
		jtfNomeMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeMarca.setBounds(10, 179, 330, 20);
		jpnMarca.add(jtfNomeMarca);
		jtfNomeMarca.setColumns(10);
		
		jlbCodigoMarca = new JLabel("C\u00F3digo");
		jlbCodigoMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoMarca.setBounds(10, 104, 46, 14);
		jpnMarca.add(jlbCodigoMarca);
		
		lblNomeDaMarca_1 = new JLabel("Nome da Marca");
		lblNomeDaMarca_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeDaMarca_1.setBounds(10, 162, 100, 14);
		jpnMarca.add(lblNomeDaMarca_1);
		
		try {
			jtfDataAlteracao = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfDataAlteracao.setBackground(Color.YELLOW);
		jtfDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfDataAlteracao.setEditable(false);
		jtfDataAlteracao.setBounds(324, 121, 100, 20);
		jpnMarca.add(jtfDataAlteracao);
		jtfDataAlteracao.setColumns(10);
		
		jlbDataAlteracao = new JLabel("Data Altera\u00E7\u00E3o");
		jlbDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataAlteracao.setBounds(324, 105, 100, 14);
		jpnMarca.add(jlbDataAlteracao);
		
		jcbxForaUso = new JCheckBox("Fora de Uso");
		jcbxForaUso.setEnabled(false);
		jcbxForaUso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jcbxForaUso.setBounds(156, 120, 97, 23);
		jpnMarca.add(jcbxForaUso);
	}
	
	public void novoCadastro() {
		jbtNovo.setEnabled(false);
		jtfNomeMarca.setEnabled(true);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
	}
	
	@SuppressWarnings("static-access")
	public void salvarCadastro() {
		this.marca = new Marca();
		if(jtfNomeMarca.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigat�rio informar o nome da marca!!!",
					"Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeMarca.requestFocus();
		} else {
			this.marca.setNome(jtfNomeMarca.getText());
			this.marca.setDataAltercacao(Date.valueOf(marca.getDataAltercacao().now()).toLocalDate());
			this.marca.setForaUso(Boolean.valueOf(jcbxForaUso.isSelected()));
		}
	}
	
	public void editarCadastro() {
		
	}
	
	public void cancelarCadastro() {
		jbtNovo.setEnabled(true);
		jtfNomeMarca.setEnabled(false);
		jtfNomeMarca.setText("");
		jbtSalvar.setEnabled(false);
		jbtCancelar.setEnabled(false);
	}
	
	public void acionarBotaoPesquisar() {
		jbtPesquisar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtPesquisar) {
					ListaMarcaForm listaMarcaForm = new ListaMarcaForm(marcaForm);
					listaMarcaForm.show();
				}
			}
		});
	}
	
	public void acionarBotaoNovo() {
		jbtNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtNovo) {
					novoCadastro();
				}
			}
		});
	}
	
	public void acionarBotaoSalvar() {
		jbtSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarCadastro();
				DaoFactory.getFactory().marcaDao().inserir(marca);
				JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!!!",
						"Confirma��o", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
	
	public void acionarBotaoEdtiar() {
		jbtEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	public void acionarBotaoCancelar() {
		jbtCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtCancelar) {
					cancelarCadastro();
				}
			}
		});
	}
	
	public void acionarBotaoFechar() {
		jbtFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtFechar) {
					dispose();
				}
			}
		});
	}

	public MarcaForm() {
		marcaForm = this;
		setIconImage(Toolkit.getDefaultToolkit().getImage(MarcaForm.class.getResource("/Imagens/washCar.jpeg")));
		setTitle("Cadastrar Marcas de Carros | WashCar");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 442, 279);
		jpnMarca = new JPanel();
		setLocationRelativeTo(null);
		setContentPane(jpnMarca);
		jpnMarca.setLayout(null);
		
		componentesTelaMarca();
		acionarBotaoPesquisar();
		acionarBotaoNovo();
		acionarBotaoSalvar();
		acionarBotaoEdtiar();
		acionarBotaoCancelar();
		acionarBotaoFechar();
	}
}