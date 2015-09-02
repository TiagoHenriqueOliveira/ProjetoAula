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

public class TipoServicoTela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnTipoServico;
	private JTextField jtfPesquisaCodigoTipoServico;
	private JTextField jtfPesquisaNomeTipoServico;
	private JTextField jtfCodigo;
	private JTextField jtfNomeTipoServico;
	private JTextField jtfDataAlteracao;
	private JTextField jtfValor;
	private JPanel jpnPesquisaTipoServico;
	private JLabel jlbPesquisaCodigoTipoServico;
	private JLabel jlbPesquisaNomeTipoServico;
	private JButton jbtPesquisarTipoServico;
	private JButton jbtNovo;
	private JButton jbtSalvar;
	private JButton jbtEditar;
	private JButton jbtCancelar;
	private JButton jbtFechar;
	private JLabel jlbCodigo;
	private JLabel jlbNomeTipoServico;
	private JLabel jlbDataAlteracao;
	private JLabel jlbValor;
	private JCheckBox jckbForaUso;

	public void componenteTelaTipoServico() {
		jpnPesquisaTipoServico = new JPanel();
		jpnPesquisaTipoServico.setLayout(null);
		jpnPesquisaTipoServico.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnPesquisaTipoServico.setBounds(10, 11, 414, 55);
		jpnTipoServico.add(jpnPesquisaTipoServico);
		
		jtfPesquisaCodigoTipoServico = new JTextField();
		jtfPesquisaCodigoTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaCodigoTipoServico.setColumns(10);
		jtfPesquisaCodigoTipoServico.setBounds(10, 24, 66, 20);
		jpnPesquisaTipoServico.add(jtfPesquisaCodigoTipoServico);
		
		jtfPesquisaNomeTipoServico = new JTextField();
		jtfPesquisaNomeTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaNomeTipoServico.setColumns(10);
		jtfPesquisaNomeTipoServico.setBounds(86, 24, 275, 20);
		jpnPesquisaTipoServico.add(jtfPesquisaNomeTipoServico);
		
		jlbPesquisaCodigoTipoServico = new JLabel("C\u00F3digo");
		jlbPesquisaCodigoTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaCodigoTipoServico.setBounds(10, 8, 46, 14);
		jpnPesquisaTipoServico.add(jlbPesquisaCodigoTipoServico);
		
		jlbPesquisaNomeTipoServico = new JLabel("Nome do Tipo de Servi\u00E7o");
		jlbPesquisaNomeTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaNomeTipoServico.setBounds(86, 8, 150, 14);
		jpnPesquisaTipoServico.add(jlbPesquisaNomeTipoServico);
		
		jbtPesquisarTipoServico = new JButton("");
		jbtPesquisarTipoServico.setIcon(new ImageIcon(TipoServicoTela.class.getResource("/Imagens/lupaPesquisa.jpeg")));
		jbtPesquisarTipoServico.setBounds(367, 13, 40, 32);
		jpnPesquisaTipoServico.add(jbtPesquisarTipoServico);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 189, 75, 23);
		jpnTipoServico.add(jbtNovo);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(93, 189, 75, 23);
		jpnTipoServico.add(jbtSalvar);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setBounds(178, 189, 75, 23);
		jpnTipoServico.add(jbtEditar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setBounds(261, 189, 80, 23);
		jpnTipoServico.add(jbtCancelar);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setToolTipText("");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setBounds(350, 189, 75, 23);
		jpnTipoServico.add(jbtFechar);
		
		jtfCodigo = new JTextField();
		jtfCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigo.setEditable(false);
		jtfCodigo.setColumns(10);
		jtfCodigo.setBackground(Color.YELLOW);
		jtfCodigo.setBounds(10, 94, 86, 20);
		jpnTipoServico.add(jtfCodigo);
		
		jtfNomeTipoServico = new JTextField();
		jtfNomeTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeTipoServico.setColumns(10);
		jtfNomeTipoServico.setBounds(10, 152, 243, 20);
		jpnTipoServico.add(jtfNomeTipoServico);
		
		jlbCodigo = new JLabel("C\u00F3digo");
		jlbCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigo.setBounds(10, 77, 46, 14);
		jpnTipoServico.add(jlbCodigo);
		
		jlbNomeTipoServico = new JLabel("Nome do Tipo de Servi\u00E7o");
		jlbNomeTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeTipoServico.setBounds(10, 135, 150, 14);
		jpnTipoServico.add(jlbNomeTipoServico);
		
		jtfDataAlteracao = new JTextField();
		jtfDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfDataAlteracao.setEditable(false);
		jtfDataAlteracao.setColumns(10);
		jtfDataAlteracao.setBackground(Color.YELLOW);
		jtfDataAlteracao.setBounds(338, 93, 86, 20);
		jpnTipoServico.add(jtfDataAlteracao);
		
		jlbDataAlteracao = new JLabel("Data Altera\u00E7\u00E3o");
		jlbDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataAlteracao.setBounds(338, 77, 86, 14);
		jpnTipoServico.add(jlbDataAlteracao);
		
		jtfValor = new JTextField();
		jtfValor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfValor.setColumns(10);
		jtfValor.setBackground(Color.WHITE);
		jtfValor.setBounds(274, 152, 150, 20);
		jpnTipoServico.add(jtfValor);
		
		jlbValor = new JLabel("Valor do Tipo de Servi\u00E7o");
		jlbValor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbValor.setBounds(274, 135, 150, 14);
		jpnTipoServico.add(jlbValor);
		
		jckbForaUso = new JCheckBox("Fora de Uso");
		jckbForaUso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jckbForaUso.setBounds(170, 92, 97, 23);
		jpnTipoServico.add(jckbForaUso);
	}

	public TipoServicoTela() {
		setTitle("Cadastrar Tipos de Serviço | WashCar");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 440, 250);
		jpnTipoServico = new JPanel();
		jpnTipoServico.setLayout(null);
		setLocationRelativeTo(null);
		setContentPane(jpnTipoServico);
		
		componenteTelaTipoServico();

	}
}