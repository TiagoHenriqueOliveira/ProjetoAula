package telas.washCar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
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

	public void componentesTelaModelo() {
		jpnPesquisaModelo = new JPanel();
		jpnPesquisaModelo.setLayout(null);
		jpnPesquisaModelo.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnPesquisaModelo.setBounds(10, 11, 414, 55);
		jpnModelo.add(jpnPesquisaModelo);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(10, 24, 66, 20);
		jpnPesquisaModelo.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(86, 24, 275, 20);
		jpnPesquisaModelo.add(textField_1);
		
		jlbPesquisaCodigoModelo = new JLabel("C\u00F3digo");
		jlbPesquisaCodigoModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaCodigoModelo.setBounds(10, 8, 46, 14);
		jpnPesquisaModelo.add(jlbPesquisaCodigoModelo);
		
		jlbPesquisaNomeModelo = new JLabel("Nome do Modelo");
		jlbPesquisaNomeModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaNomeModelo.setBounds(86, 8, 100, 14);
		jpnPesquisaModelo.add(jlbPesquisaNomeModelo);
		
		jbtPesquisaModelo = new JButton("");
		jbtPesquisaModelo.setIcon(new ImageIcon(ModeloTela.class.getResource("/Imagens/lupaPesquisa.jpeg")));
		jbtPesquisaModelo.setBounds(367, 13, 40, 32);
		jpnPesquisaModelo.add(jbtPesquisaModelo);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 189, 75, 23);
		jpnModelo.add(jbtNovo);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(93, 189, 75, 23);
		jpnModelo.add(jbtSalvar);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setBounds(178, 189, 75, 23);
		jpnModelo.add(jbtEditar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setBounds(261, 189, 80, 23);
		jpnModelo.add(jbtCancelar);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setToolTipText("");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setBounds(350, 189, 75, 23);
		jpnModelo.add(jbtFechar);
		
		jtfCodigo = new JTextField();
		jtfCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigo.setEditable(false);
		jtfCodigo.setColumns(10);
		jtfCodigo.setBackground(Color.YELLOW);
		jtfCodigo.setBounds(10, 94, 86, 20);
		jpnModelo.add(jtfCodigo);
		
		jtfNomeModelo = new JTextField();
		jtfNomeModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeModelo.setColumns(10);
		jtfNomeModelo.setBounds(10, 152, 330, 20);
		jpnModelo.add(jtfNomeModelo);
		
		jlbCodigo = new JLabel("C\u00F3digo");
		jlbCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigo.setBounds(10, 77, 46, 14);
		jpnModelo.add(jlbCodigo);
		
		jlbNomeModelo = new JLabel("Nome do Modelo");
		jlbNomeModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeModelo.setBounds(10, 135, 100, 14);
		jpnModelo.add(jlbNomeModelo);
		
		jtfDataAlteracao = new JTextField();
		jtfDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfDataAlteracao.setEditable(false);
		jtfDataAlteracao.setColumns(10);
		jtfDataAlteracao.setBackground(Color.YELLOW);
		jtfDataAlteracao.setBounds(254, 94, 86, 20);
		jpnModelo.add(jtfDataAlteracao);
		
		jlbDataAlteracao = new JLabel("Data Altera\u00E7\u00E3o");
		jlbDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataAlteracao.setBounds(254, 78, 100, 14);
		jpnModelo.add(jlbDataAlteracao);
		
		jckbForaUso = new JCheckBox("Fora de Uso");
		jckbForaUso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jckbForaUso.setBounds(128, 92, 97, 23);
		jpnModelo.add(jckbForaUso);
	}

	public ModeloTela() {
		setResizable(false);
		setTitle("Cadastrar Modelos de Carros | WashCar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 438, 251);
		jpnModelo = new JPanel();
		jpnModelo.setLayout(null);
		setLocationRelativeTo(null);
		setContentPane(jpnModelo);
		
		componentesTelaModelo();
		
	}
}