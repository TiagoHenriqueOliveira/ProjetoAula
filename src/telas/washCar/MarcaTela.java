package telas.washCar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

public class MarcaTela extends JFrame {

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
	private JCheckBox jckbForaUso;

	public void componentesTelaMarca() {
		jpnPesquisaMarcas = new JPanel();
		jpnPesquisaMarcas.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnPesquisaMarcas.setBounds(10, 11, 414, 82);
		jpnMarca.add(jpnPesquisaMarcas);
		jpnPesquisaMarcas.setLayout(null);
		
		jtfPesquisaCodigoMarca = new JTextField();
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
		jbtPesquisar.setIcon(new ImageIcon(MarcaTela.class.getResource("/Imagens/lupaPesquisa.jpeg")));
		
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
		
		jckbForaUso = new JCheckBox("Fora de Uso");
		jckbForaUso.setEnabled(false);
		jckbForaUso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jckbForaUso.setBounds(156, 120, 97, 23);
		jpnMarca.add(jckbForaUso);
	}
	
	public void novoCadastro() {
		jbtNovo.setEnabled(false);
		jtfNomeMarca.setEnabled(true);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
	}
	
	public void salvarCadastro() {
		
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

	public MarcaTela() {
		setTitle("Cadastrar Marcas de Carros | WashCar");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 442, 279);
		jpnMarca = new JPanel();
		setLocationRelativeTo(null);
		setContentPane(jpnMarca);
		jpnMarca.setLayout(null);
		
		componentesTelaMarca();
		
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