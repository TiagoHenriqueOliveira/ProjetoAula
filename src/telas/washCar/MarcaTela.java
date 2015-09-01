package telas.washCar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

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
	private JButton jbtExcluir;
	private JButton jbtFechar;
	private JLabel jlbCodigoMarca;
	private JLabel lblNomeDaMarca_1;
	private JLabel jlbDataAlteracao;

	public static void main(String[] args) {
		MarcaTela frame = new MarcaTela();
		frame.setVisible(true);
	}
	
	public void componentesTelaMarca() {
		jpnPesquisaMarcas = new JPanel();
		jpnPesquisaMarcas.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnPesquisaMarcas.setBounds(10, 11, 414, 55);
		jpnMarca.add(jpnPesquisaMarcas);
		jpnPesquisaMarcas.setLayout(null);
		
		jtfPesquisaCodigoMarca = new JTextField();
		jtfPesquisaCodigoMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaCodigoMarca.setBounds(10, 24, 66, 20);
		jpnPesquisaMarcas.add(jtfPesquisaCodigoMarca);
		jtfPesquisaCodigoMarca.setColumns(10);
		
		jtfPesquisaNomeMarca = new JTextField();
		jtfPesquisaNomeMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaNomeMarca.setBounds(86, 24, 275, 20);
		jpnPesquisaMarcas.add(jtfPesquisaNomeMarca);
		jtfPesquisaNomeMarca.setColumns(10);
		
		jlbCodigo = new JLabel("C\u00F3digo");
		jlbCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigo.setBounds(10, 8, 46, 14);
		jpnPesquisaMarcas.add(jlbCodigo);
		
		lblNomeDaMarca = new JLabel("Nome da Marca");
		lblNomeDaMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeDaMarca.setBounds(86, 8, 90, 14);
		jpnPesquisaMarcas.add(lblNomeDaMarca);
		
		jbtPesquisar = new JButton("");
		jbtPesquisar.setBounds(367, 13, 40, 32);
		jpnPesquisaMarcas.add(jbtPesquisar);
		jbtPesquisar.setIcon(new ImageIcon(MarcaTela.class.getResource("/Imagens/lupaPesquisa.jpeg")));
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 189, 75, 23);
		jpnMarca.add(jbtNovo);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(95, 189, 75, 23);
		jpnMarca.add(jbtSalvar);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setBounds(180, 189, 75, 23);
		jpnMarca.add(jbtEditar);
		
		jbtExcluir = new JButton("Excluir");
		jbtExcluir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtExcluir.setBounds(265, 189, 75, 23);
		jpnMarca.add(jbtExcluir);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setToolTipText("");
		jbtFechar.setBounds(350, 189, 75, 23);
		jpnMarca.add(jbtFechar);
		
		jtfCodigoMarca = new JTextField();
		jtfCodigoMarca.setBackground(Color.YELLOW);
		jtfCodigoMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoMarca.setEditable(false);
		jtfCodigoMarca.setBounds(10, 94, 86, 20);
		jpnMarca.add(jtfCodigoMarca);
		jtfCodigoMarca.setColumns(10);
		
		jtfNomeMarca = new JTextField();
		jtfNomeMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeMarca.setBounds(10, 152, 330, 20);
		jpnMarca.add(jtfNomeMarca);
		jtfNomeMarca.setColumns(10);
		
		jlbCodigoMarca = new JLabel("C\u00F3digo");
		jlbCodigoMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoMarca.setBounds(10, 77, 46, 14);
		jpnMarca.add(jlbCodigoMarca);
		
		lblNomeDaMarca_1 = new JLabel("Nome da Marca");
		lblNomeDaMarca_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeDaMarca_1.setBounds(10, 135, 100, 14);
		jpnMarca.add(lblNomeDaMarca_1);
		
		jtfDataAlteracao = new JTextField();
		jtfDataAlteracao.setBackground(Color.YELLOW);
		jtfDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfDataAlteracao.setEditable(false);
		jtfDataAlteracao.setBounds(254, 94, 86, 20);
		jpnMarca.add(jtfDataAlteracao);
		jtfDataAlteracao.setColumns(10);
		
		jlbDataAlteracao = new JLabel("Data Altera\u00E7\u00E3o");
		jlbDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataAlteracao.setBounds(254, 78, 100, 14);
		jpnMarca.add(jlbDataAlteracao);
	}

	public MarcaTela() {
		setTitle("Cadastrar Marcas de Carros");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 245);
		jpnMarca = new JPanel();
		setLocationRelativeTo(null);
		setContentPane(jpnMarca);
		jpnMarca.setLayout(null);
		
		componentesTelaMarca();

	}
}