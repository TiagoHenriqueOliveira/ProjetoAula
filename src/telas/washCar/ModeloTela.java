package telas.washCar;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class ModeloTela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnModelo;
	private JTextField textField;
	private JTextField textField_1;
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
	private JLabel jlbCodigo;
	private JLabel jlbNomeModelo;
	private JLabel jlbDataAlteracao;
	private JCheckBox jckbForaUso;
	private JLabel jlbConsultaModelos;

	public void componentesTelaModelo() {
		jpnPesquisaModelo = new JPanel();
		jpnPesquisaModelo.setLayout(null);
		jpnPesquisaModelo.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnPesquisaModelo.setBounds(10, 11, 414, 86);
		jpnModelo.add(jpnPesquisaModelo);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(10, 54, 66, 20);
		jpnPesquisaModelo.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(86, 54, 275, 20);
		jpnPesquisaModelo.add(textField_1);
		
		jlbPesquisaCodigoModelo = new JLabel("C\u00F3digo");
		jlbPesquisaCodigoModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaCodigoModelo.setBounds(10, 38, 46, 14);
		jpnPesquisaModelo.add(jlbPesquisaCodigoModelo);
		
		jlbPesquisaNomeModelo = new JLabel("Nome do Modelo");
		jlbPesquisaNomeModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaNomeModelo.setBounds(86, 38, 100, 14);
		jpnPesquisaModelo.add(jlbPesquisaNomeModelo);
		
		jbtPesquisaModelo = new JButton("");
		jbtPesquisaModelo.setIcon(new ImageIcon(ModeloTela.class.getResource("/Imagens/lupaPesquisa.jpeg")));
		jbtPesquisaModelo.setBounds(367, 43, 40, 32);
		jpnPesquisaModelo.add(jbtPesquisaModelo);
		
		jlbConsultaModelos = new JLabel("Consulta Modelos de Carros");
		jlbConsultaModelos.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbConsultaModelos.setBounds(10, 11, 200, 14);
		jpnPesquisaModelo.add(jlbConsultaModelos);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(9, 220, 75, 23);
		jpnModelo.add(jbtNovo);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setEnabled(false);
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(92, 220, 75, 23);
		jpnModelo.add(jbtSalvar);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setEnabled(false);
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setBounds(177, 220, 75, 23);
		jpnModelo.add(jbtEditar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setEnabled(false);
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setBounds(260, 220, 80, 23);
		jpnModelo.add(jbtCancelar);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setToolTipText("");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setBounds(349, 220, 75, 23);
		jpnModelo.add(jbtFechar);
		
		jtfCodigo = new JTextField();
		jtfCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigo.setEditable(false);
		jtfCodigo.setColumns(10);
		jtfCodigo.setBackground(Color.YELLOW);
		jtfCodigo.setBounds(9, 125, 86, 20);
		jpnModelo.add(jtfCodigo);
		
		jtfNomeModelo = new JTextField();
		jtfNomeModelo.setEnabled(false);
		jtfNomeModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeModelo.setColumns(10);
		jtfNomeModelo.setBounds(9, 183, 330, 20);
		jpnModelo.add(jtfNomeModelo);
		
		jlbCodigo = new JLabel("C\u00F3digo");
		jlbCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigo.setBounds(9, 108, 46, 14);
		jpnModelo.add(jlbCodigo);
		
		jlbNomeModelo = new JLabel("Nome do Modelo");
		jlbNomeModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeModelo.setBounds(9, 166, 100, 14);
		jpnModelo.add(jlbNomeModelo);
		
		try {
			jtfDataAlteracao = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfDataAlteracao.setEditable(false);
		jtfDataAlteracao.setColumns(10);
		jtfDataAlteracao.setBackground(Color.YELLOW);
		jtfDataAlteracao.setBounds(314, 125, 108, 20);
		jpnModelo.add(jtfDataAlteracao);
		
		jlbDataAlteracao = new JLabel("Data Altera\u00E7\u00E3o");
		jlbDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataAlteracao.setBounds(314, 109, 108, 14);
		jpnModelo.add(jlbDataAlteracao);
		
		jckbForaUso = new JCheckBox("Fora de Uso");
		jckbForaUso.setEnabled(false);
		jckbForaUso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jckbForaUso.setBounds(155, 124, 97, 23);
		jpnModelo.add(jckbForaUso);
	}
	
	public void novoCadastro() {
		jbtNovo.setEnabled(false);
		jtfNomeModelo.setEnabled(true);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
	}
	
	public void salvarCadastro() {
		
	}
	
	public void editarCadastro() {
		
	}
	
	public void cancelarCadastro() {
		jbtNovo.setEnabled(true);
		jtfNomeModelo.setEnabled(false);
		jtfNomeModelo.setText("");
		jbtSalvar.setEnabled(false);
		jbtCancelar.setEnabled(false);
	}

	public ModeloTela() {
		setResizable(false);
		setTitle("Cadastrar Modelos de Carros | WashCar");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 438, 282);
		jpnModelo = new JPanel();
		jpnModelo.setLayout(null);
		setLocationRelativeTo(null);
		setContentPane(jpnModelo);
		
		componentesTelaModelo();
		
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