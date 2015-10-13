package forms.WashCar;

import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

import validacaoCampos.WashCar.ValidaCampoNumeroInteiro;
import validacaoCampos.WashCar.ValidaCampoString;
import validacaoCampos.WashCar.ValidaCampoValor;

import com.toedter.calendar.JDateChooser;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class OrdemServicoForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnOrdemServico;
	private JPanel jpnPesquisaOrdemServico;
	private JPanel jpnDadosOrdemServico;
	private JPanel jpnCadastroServico;
	private JPanel jpnObservacaoServico;
	private JTextField jtfPesquisaCodigoOrdemServico;
	private JTextField jtfPesquisaNomeClienteOrdemServico;
	private JTextField jtfPesquisaPlacaCarroOrdemServico;
	private JTextField jtfCodigoCliente;
	private JTextField jtfDataAlteracao;
	private JTextField jtfNomeCliente;
	private JTextField jtfCpf;
	private JTextField jtfNomeFantasia;
	private JTextField jtfCnpj;
	private JTextField jtfNomeCarro;
	private JTextField jtfPlaca;
	private JTextField jtfTelefoneComercial;
	private JTextField jtfTelefoneResidencial;
	private JTextField jtfTelefoneCelular;
	private JTextField jtfValorTotal;
	private JTextField jtfDescricaoTipoServico;
	private JTextField jtfCodigoTipoServico;
	private JTextField jtfQuantidade;
	private JTextField jtfValorUnitario;
	private JTextField jtfValorTotalItemServico;
	private JTextField jtfCodigoOSV;
	private JTextField jtfCodigoCarro;
	private JTextArea jtaObservacaoServico;
	private JLabel jlbValorTotal;
	private JLabel jlbTelefoneCelular;
	private JLabel jlbTelefoneResidencial;
	private JLabel jlbTelefoneComercial;
	private JLabel jlbFormaPagamento;
	private JLabel jlbPlaca;
	private JLabel jlbNomeCarro;
	private JLabel jlbCnpj;
	private JLabel jlbNomeFantasia;
	private JLabel jlbCpf;
	private JLabel jlbNomeCliente;
	private JLabel jlbDataAlteracao;
	private JLabel jlbCodigoCliente;
	private JLabel jlbPesquisaPlacaCarroOrdemServico;
	private JLabel jlbDescricaoServico;
	private JLabel jlbConsultaOrdemServico;
	private JLabel jlbPesquisaNomeClienteOrdemServico;
	private JLabel jlbPesquisaCodigoOrdemServico;
	private JLabel jlbValorUnitario;
	private JLabel jlbQuantidade;
	private JLabel jlbCodigoTipoServico;
	private JLabel jlbValorTotalItemServico;
	private JLabel jlbDataServico;
	private JLabel jlbCodigoCarro;
	private JLabel jlbCodigoOSV;
	private JCheckBox jckbOrdemServicoCancelada;
	private ButtonGroup jbgFormaPagamento;
	private JButton jbtFechar;
	private JButton jbtSalvar;
	private JButton jbtEditar;
	private JButton jbtNovo;
	private JButton jbtCancelar;
	private JButton jbtPesquisaOrdemServico;
	private JButton jbtCancelarItemServico;
	private JButton jbtSalvarItemServico;
	private JButton jbtEditarItemServico;
	private JButton jbtNovoItemServico;
	private JTabbedPane jtbOrdemServico;
	private JRadioButton jrbPagamentoVista;
	private JRadioButton jrbPagamentoPrazo;
	private JTable jttGridItensServico;
	private DefaultTableModel dtmGridItensServico;
	private Vector<String> dados;
	private JScrollPane jspGridItensServico;
	private JScrollPane jspObservacaoServico;
	private JDateChooser jctDataAgendamento;
	private JMenuBar jmbOrdemServico;
	private JMenu jmnRelatorio;

	public void componentesTelaOrdemServico() {
		jmbOrdemServico = new JMenuBar();
		jmbOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		setJMenuBar(jmbOrdemServico);
		
		jmnRelatorio = new JMenu("Relat\u00F3rios");
		jmnRelatorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jmbOrdemServico.add(jmnRelatorio);
		setContentPane(jpnOrdemServico);
		
		jtbOrdemServico = new JTabbedPane(JTabbedPane.TOP);
		jtbOrdemServico.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jtbOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtbOrdemServico.setToolTipText("");
		jtbOrdemServico.setBounds(10, 11, 675, 505);
		jpnOrdemServico.add(jtbOrdemServico);
		
		dados = new Vector<String>();
		dados.add("Código");
		dados.add("Descrição");
		dados.add("Quantidade");
		dados.add("Valor Unitário");
		dados.add("Valor Total");
		dtmGridItensServico = new DefaultTableModel();
		dtmGridItensServico.setColumnIdentifiers(dados);
		
		jpnDadosOrdemServico = new JPanel();
		jtbOrdemServico.addTab("Cadastro da Ordem de Servi\u00E7o", null, jpnDadosOrdemServico, null);
		jpnDadosOrdemServico.setLayout(null);
		
		jpnPesquisaOrdemServico = new JPanel();
		jpnPesquisaOrdemServico.setLayout(null);
		jpnPesquisaOrdemServico.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnPesquisaOrdemServico.setBounds(10, 11, 640, 83);
		jpnDadosOrdemServico.add(jpnPesquisaOrdemServico);
		
		jlbPesquisaCodigoOrdemServico = new JLabel("Código OSV");
		jlbPesquisaCodigoOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaCodigoOrdemServico.setBounds(10, 36, 100, 14);
		jpnPesquisaOrdemServico.add(jlbPesquisaCodigoOrdemServico);
		
		jtfPesquisaCodigoOrdemServico = new JTextField();
		jtfPesquisaCodigoOrdemServico.setDocument(new ValidaCampoNumeroInteiro());
		jtfPesquisaCodigoOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaCodigoOrdemServico.setColumns(10);
		jtfPesquisaCodigoOrdemServico.setBounds(10, 52, 50, 20);
		jpnPesquisaOrdemServico.add(jtfPesquisaCodigoOrdemServico);
		
		jlbPesquisaNomeClienteOrdemServico = new JLabel("Nome do Cliente");
		jlbPesquisaNomeClienteOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaNomeClienteOrdemServico.setBounds(120, 36, 275, 14);
		jpnPesquisaOrdemServico.add(jlbPesquisaNomeClienteOrdemServico);
		
		jtfPesquisaNomeClienteOrdemServico = new JTextField();
		jtfPesquisaNomeClienteOrdemServico.setDocument(new ValidaCampoString());
		jtfPesquisaNomeClienteOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaNomeClienteOrdemServico.setColumns(10);
		jtfPesquisaNomeClienteOrdemServico.setBounds(120, 52, 275, 20);
		jpnPesquisaOrdemServico.add(jtfPesquisaNomeClienteOrdemServico);
		
		jbtPesquisaOrdemServico = new JButton("");
		jbtPesquisaOrdemServico.setIcon(new ImageIcon(OrdemServicoForm.class.getResource("/Imagens/lupaPesquisa.jpeg")));
		jbtPesquisaOrdemServico.setBounds(580, 40, 40, 32);
		jpnPesquisaOrdemServico.add(jbtPesquisaOrdemServico);
		
		try {
			jtfPesquisaPlacaCarroOrdemServico = new JFormattedTextField(new MaskFormatter("UUU-####"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfPesquisaPlacaCarroOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaPlacaCarroOrdemServico.setColumns(10);
		jtfPesquisaPlacaCarroOrdemServico.setBounds(405, 52, 165, 20);
		jpnPesquisaOrdemServico.add(jtfPesquisaPlacaCarroOrdemServico);
		
		jlbPesquisaPlacaCarroOrdemServico = new JLabel("Placa do Carro");
		jlbPesquisaPlacaCarroOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaPlacaCarroOrdemServico.setBounds(405, 36, 100, 14);
		jpnPesquisaOrdemServico.add(jlbPesquisaPlacaCarroOrdemServico);
		
		jlbConsultaOrdemServico = new JLabel("Consulta de Ordens de Servi\u00E7o");
		jlbConsultaOrdemServico.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbConsultaOrdemServico.setBounds(10, 11, 405, 14);
		jpnPesquisaOrdemServico.add(jlbConsultaOrdemServico);
		
		jlbCodigoCliente = new JLabel("C\u00F3digo do Cliente");
		jlbCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoCliente.setBounds(10, 152, 165, 14);
		jpnDadosOrdemServico.add(jlbCodigoCliente);
		
		jtfCodigoCliente = new JTextField();
		jtfCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoCliente.setEditable(false);
		jtfCodigoCliente.setColumns(10);
		jtfCodigoCliente.setBackground(Color.YELLOW);
		jtfCodigoCliente.setBounds(10, 168, 50, 20);
		jpnDadosOrdemServico.add(jtfCodigoCliente);
		
		jlbDataAlteracao = new JLabel("Data Alteracao");
		jlbDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataAlteracao.setBounds(550, 387, 100, 14);
		jpnDadosOrdemServico.add(jlbDataAlteracao);
		
		try {
			jtfDataAlteracao = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfDataAlteracao.setHorizontalAlignment(SwingConstants.RIGHT);
		jtfDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfDataAlteracao.setEditable(false);
		jtfDataAlteracao.setColumns(10);
		jtfDataAlteracao.setBackground(Color.YELLOW);
		jtfDataAlteracao.setBounds(550, 403, 100, 20);
		jpnDadosOrdemServico.add(jtfDataAlteracao);
		
		jlbNomeCliente = new JLabel("Nome do Cliente");
		jlbNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeCliente.setBounds(10, 199, 265, 14);
		jpnDadosOrdemServico.add(jlbNomeCliente);
		
		jtfNomeCliente = new JTextField();
		jtfNomeCliente.setDocument(new ValidaCampoString());
		jtfNomeCliente.setEnabled(false);
		jtfNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeCliente.setColumns(10);
		jtfNomeCliente.setBounds(10, 215, 381, 20);
		jpnDadosOrdemServico.add(jtfNomeCliente);
		
		jlbCpf = new JLabel("CPF");
		jlbCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCpf.setBounds(401, 199, 165, 14);
		jpnDadosOrdemServico.add(jlbCpf);
		
		try {
			jtfCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfCpf.setEnabled(false);
		jtfCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCpf.setColumns(10);
		jtfCpf.setBounds(401, 215, 179, 20);
		jpnDadosOrdemServico.add(jtfCpf);
		
		jlbNomeFantasia = new JLabel("Nome Fantasia");
		jlbNomeFantasia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeFantasia.setBounds(10, 246, 265, 14);
		jpnDadosOrdemServico.add(jlbNomeFantasia);
		
		jtfNomeFantasia = new JTextField();
		jtfNomeFantasia.setDocument(new ValidaCampoString());
		jtfNomeFantasia.setEnabled(false);
		jtfNomeFantasia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeFantasia.setColumns(10);
		jtfNomeFantasia.setBounds(10, 262, 381, 20);
		jpnDadosOrdemServico.add(jtfNomeFantasia);
		
		jlbCnpj = new JLabel("CNPJ");
		jlbCnpj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCnpj.setBounds(401, 246, 165, 14);
		jpnDadosOrdemServico.add(jlbCnpj);
		
		try {
			jtfCnpj = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfCnpj.setEnabled(false);
		jtfCnpj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCnpj.setColumns(10);
		jtfCnpj.setBounds(401, 262, 179, 20);
		jpnDadosOrdemServico.add(jtfCnpj);
		
		jlbNomeCarro = new JLabel("Nome do Carro");
		jlbNomeCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeCarro.setBounds(150, 293, 265, 14);
		jpnDadosOrdemServico.add(jlbNomeCarro);
		
		jtfNomeCarro = new JTextField();
		jtfNomeCarro.setEnabled(false);
		jtfNomeCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeCarro.setColumns(10);
		jtfNomeCarro.setBounds(150, 309, 270, 20);
		jpnDadosOrdemServico.add(jtfNomeCarro);
		
		try {
			jtfPlaca = new JFormattedTextField(new MaskFormatter("UUU-####"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfPlaca.setEnabled(false);
		jtfPlaca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPlaca.setColumns(10);
		jtfPlaca.setBounds(430, 309, 150, 20);
		jpnDadosOrdemServico.add(jtfPlaca);
		
		jlbPlaca = new JLabel("Placa do Carro");
		jlbPlaca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPlaca.setBounds(430, 293, 150, 14);
		jpnDadosOrdemServico.add(jlbPlaca);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 434, 120, 25);
		jpnDadosOrdemServico.add(jbtNovo);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setEnabled(false);
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setBounds(140, 434, 120, 25);
		jpnDadosOrdemServico.add(jbtEditar);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setEnabled(false);
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(270, 434, 120, 25);
		jpnDadosOrdemServico.add(jbtSalvar);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setBounds(530, 434, 120, 25);
		jpnDadosOrdemServico.add(jbtFechar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setEnabled(false);
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setBounds(400, 434, 120, 25);
		jpnDadosOrdemServico.add(jbtCancelar);
		
		jckbOrdemServicoCancelada = new JCheckBox("Cancelada");
		jckbOrdemServicoCancelada.setEnabled(false);
		jckbOrdemServicoCancelada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jckbOrdemServicoCancelada.setBounds(450, 160, 130, 23);
		jpnDadosOrdemServico.add(jckbOrdemServicoCancelada);
		
		jlbFormaPagamento = new JLabel("Forma de Pagamento");
		jlbFormaPagamento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbFormaPagamento.setBounds(354, 103, 130, 14);
		jpnDadosOrdemServico.add(jlbFormaPagamento);
		
		jlbTelefoneComercial = new JLabel("Telefone Comercial");
		jlbTelefoneComercial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneComercial.setBounds(10, 340, 130, 14);
		jpnDadosOrdemServico.add(jlbTelefoneComercial);
		
		jtfTelefoneComercial = new JTextField();
		jtfTelefoneComercial.setEnabled(false);
		jtfTelefoneComercial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneComercial.setColumns(10);
		jtfTelefoneComercial.setBounds(10, 356, 130, 20);
		jpnDadosOrdemServico.add(jtfTelefoneComercial);
		
		jlbTelefoneResidencial = new JLabel("Telefone Residencial");
		jlbTelefoneResidencial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneResidencial.setBounds(150, 340, 130, 14);
		jpnDadosOrdemServico.add(jlbTelefoneResidencial);
		
		jtfTelefoneResidencial = new JTextField();
		jtfTelefoneResidencial.setEnabled(false);
		jtfTelefoneResidencial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneResidencial.setColumns(10);
		jtfTelefoneResidencial.setBounds(150, 355, 130, 20);
		jpnDadosOrdemServico.add(jtfTelefoneResidencial);
		
		jlbTelefoneCelular = new JLabel("Telefone Celular");
		jlbTelefoneCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneCelular.setBounds(290, 340, 130, 14);
		jpnDadosOrdemServico.add(jlbTelefoneCelular);
		
		jtfTelefoneCelular = new JTextField();
		jtfTelefoneCelular.setEnabled(false);
		jtfTelefoneCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneCelular.setColumns(10);
		jtfTelefoneCelular.setBounds(290, 356, 130, 20);
		jpnDadosOrdemServico.add(jtfTelefoneCelular);
		
		jtfValorTotal = new JTextField();
		jtfValorTotal.setDocument(new ValidaCampoValor());
		jtfValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfValorTotal.setEditable(false);
		jtfValorTotal.setColumns(10);
		jtfValorTotal.setBackground(Color.YELLOW);
		jtfValorTotal.setBounds(10, 403, 130, 20);
		jpnDadosOrdemServico.add(jtfValorTotal);
		
		jlbValorTotal = new JLabel("Valor Total");
		jlbValorTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbValorTotal.setBounds(10, 387, 130, 14);
		jpnDadosOrdemServico.add(jlbValorTotal);
		
		jrbPagamentoVista = new JRadioButton("\u00C0 Vista");
		jrbPagamentoVista.setEnabled(false);
		jrbPagamentoVista.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jrbPagamentoVista.setBounds(354, 118, 109, 23);
		jpnDadosOrdemServico.add(jrbPagamentoVista);
		
		jrbPagamentoPrazo = new JRadioButton("\u00C0 Prazo");
		jrbPagamentoPrazo.setEnabled(false);
		jrbPagamentoPrazo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jrbPagamentoPrazo.setBounds(471, 118, 109, 23);
		jpnDadosOrdemServico.add(jrbPagamentoPrazo);
		
		jbgFormaPagamento = new ButtonGroup();
		jbgFormaPagamento.add(jrbPagamentoPrazo);
		jbgFormaPagamento.add(jrbPagamentoVista);
		
		jlbDataServico = new JLabel("Data Agendamento do Servi\u00E7o");
		jlbDataServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataServico.setBounds(160, 386, 260, 14);
		jpnDadosOrdemServico.add(jlbDataServico);
		
		jctDataAgendamento = new JDateChooser();
		jctDataAgendamento.setEnabled(false);
		jctDataAgendamento.setBounds(160, 400, 130, 20);
		jpnDadosOrdemServico.add(jctDataAgendamento);
		
		jtfCodigoOSV = new JTextField();
		jtfCodigoOSV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoOSV.setEditable(false);
		jtfCodigoOSV.setColumns(10);
		jtfCodigoOSV.setBackground(Color.YELLOW);
		jtfCodigoOSV.setBounds(10, 121, 50, 20);
		jpnDadosOrdemServico.add(jtfCodigoOSV);
		
		jlbCodigoOSV = new JLabel("Código da Ordem de Serviço");
		jlbCodigoOSV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoOSV.setBounds(10, 105, 265, 14);
		jpnDadosOrdemServico.add(jlbCodigoOSV);
		
		jlbCodigoCarro = new JLabel("C\u00F3digo do Carro");
		jlbCodigoCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoCarro.setBounds(10, 293, 165, 14);
		jpnDadosOrdemServico.add(jlbCodigoCarro);
		
		jtfCodigoCarro = new JTextField();
		jtfCodigoCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoCarro.setEditable(false);
		jtfCodigoCarro.setColumns(10);
		jtfCodigoCarro.setBackground(Color.YELLOW);
		jtfCodigoCarro.setBounds(10, 309, 50, 20);
		jpnDadosOrdemServico.add(jtfCodigoCarro);
		
		jpnCadastroServico = new JPanel();
		jtbOrdemServico.addTab("Cadastro de Serviços", null, jpnCadastroServico, null);
		jpnCadastroServico.setLayout(null);
		jttGridItensServico = new JTable();
		jttGridItensServico.setModel(dtmGridItensServico);
		jttGridItensServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jttGridItensServico.getColumnModel().getColumn(0).setResizable(false);
		jttGridItensServico.getColumnModel().getColumn(0).setPreferredWidth(20);
		jttGridItensServico.getColumnModel().getColumn(1).setResizable(false);
		jttGridItensServico.getColumnModel().getColumn(1).setPreferredWidth(210);
		jttGridItensServico.getColumnModel().getColumn(2).setResizable(false);
		jttGridItensServico.getColumnModel().getColumn(2).setPreferredWidth(50);
		jttGridItensServico.getColumnModel().getColumn(3).setResizable(false);
		jttGridItensServico.getColumnModel().getColumn(3).setPreferredWidth(50);
		jttGridItensServico.getColumnModel().getColumn(4).setResizable(false);
		jttGridItensServico.getColumnModel().getColumn(4).setPreferredWidth(50);
		jspGridItensServico = new JScrollPane(jttGridItensServico);
		jpnCadastroServico.add(jspGridItensServico);
		jspGridItensServico.setBounds(10, 10, 640, 200);
		
		jlbDescricaoServico = new JLabel("Descri\u00E7\u00E3o do Servi\u00E7o");
		jlbDescricaoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDescricaoServico.setBounds(10, 269, 324, 14);
		jpnCadastroServico.add(jlbDescricaoServico);
		
		jtfDescricaoTipoServico = new JTextField();
		jtfDescricaoTipoServico.setEnabled(false);
		jtfDescricaoTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfDescricaoTipoServico.setColumns(10);
		jtfDescricaoTipoServico.setBounds(10, 286, 324, 20);
		jpnCadastroServico.add(jtfDescricaoTipoServico);
		
		jtfCodigoTipoServico = new JTextField();
		jtfCodigoTipoServico.setDocument(new ValidaCampoNumeroInteiro());
		jtfCodigoTipoServico.setEnabled(false);
		jtfCodigoTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoTipoServico.setColumns(10);
		jtfCodigoTipoServico.setBounds(10, 238, 50, 20);
		jpnCadastroServico.add(jtfCodigoTipoServico);
		
		jlbCodigoTipoServico = new JLabel("C\u00F3digo Tipo de Servi\u00E7o");
		jlbCodigoTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoTipoServico.setBounds(10, 221, 251, 14);
		jpnCadastroServico.add(jlbCodigoTipoServico);
		
		jtfQuantidade = new JTextField();
		jtfQuantidade.setDocument(new ValidaCampoNumeroInteiro());
		jtfQuantidade.setEnabled(false);
		jtfQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfQuantidade.setColumns(10);
		jtfQuantidade.setBounds(10, 338, 50, 20);
		jpnCadastroServico.add(jtfQuantidade);
		
		jlbQuantidade = new JLabel("Quantidade");
		jlbQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbQuantidade.setBounds(10, 321, 120, 14);
		jpnCadastroServico.add(jlbQuantidade);
		
		jtfValorUnitario = new JTextField();
		jtfValorUnitario.setDocument(new ValidaCampoValor());
		jtfValorUnitario.setEnabled(false);
		jtfValorUnitario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfValorUnitario.setColumns(10);
		jtfValorUnitario.setBounds(155, 338, 135, 20);
		jpnCadastroServico.add(jtfValorUnitario);
		
		jlbValorUnitario = new JLabel("Valor Unit\u00E1rio");
		jlbValorUnitario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbValorUnitario.setBounds(155, 321, 135, 14);
		jpnCadastroServico.add(jlbValorUnitario);
		
		jtfValorTotalItemServico = new JTextField();
		jtfValorTotalItemServico.setDocument(new ValidaCampoValor());
		jtfValorTotalItemServico.setEnabled(false);
		jtfValorTotalItemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfValorTotalItemServico.setColumns(10);
		jtfValorTotalItemServico.setBounds(344, 338, 135, 20);
		jpnCadastroServico.add(jtfValorTotalItemServico);
		
		jlbValorTotalItemServico = new JLabel("Valor Total");
		jlbValorTotalItemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbValorTotalItemServico.setBounds(344, 321, 135, 14);
		jpnCadastroServico.add(jlbValorTotalItemServico);
		
		jbtNovoItemServico = new JButton("Novo");
		jbtNovoItemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovoItemServico.setBounds(10, 434, 120, 25);
		jpnCadastroServico.add(jbtNovoItemServico);
		
		jbtEditarItemServico = new JButton("Editar");
		jbtEditarItemServico.setEnabled(false);
		jbtEditarItemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditarItemServico.setBounds(140, 434, 120, 25);
		jpnCadastroServico.add(jbtEditarItemServico);
		
		jbtSalvarItemServico = new JButton("Salvar");
		jbtSalvarItemServico.setEnabled(false);
		jbtSalvarItemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvarItemServico.setBounds(270, 434, 120, 25);
		jpnCadastroServico.add(jbtSalvarItemServico);
		
		jbtCancelarItemServico = new JButton("Cancelar");
		jbtCancelarItemServico.setEnabled(false);
		jbtCancelarItemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelarItemServico.setBounds(400, 434, 120, 25);
		jpnCadastroServico.add(jbtCancelarItemServico);
		
		jspObservacaoServico = new JScrollPane();
		jspObservacaoServico.setBounds(10, 369, 640, 54);
		jpnCadastroServico.add(jspObservacaoServico);
		
		jpnObservacaoServico = new JPanel();
		jspObservacaoServico.setViewportView(jpnObservacaoServico);
		jpnObservacaoServico.setLayout(null);
		
		jtaObservacaoServico = new JTextArea();
		jtaObservacaoServico.setBounds(0, 0, 638, 52);
		jpnObservacaoServico.add(jtaObservacaoServico);
		jtaObservacaoServico.setEnabled(false);
	}
	
	public void acionarBotaoNovoCadastroOsv() {
		jbtNovo.setEnabled(false);
		jckbOrdemServicoCancelada.setEnabled(true);
		jrbPagamentoPrazo.setEnabled(true);
		jrbPagamentoVista.setEnabled(true);
		jtfNomeCliente.setEnabled(true);
		jtfNomeFantasia.setEnabled(true);
		jtfTelefoneCelular.setEnabled(true);
		jtfTelefoneComercial.setEnabled(true);
		jtfTelefoneResidencial.setEnabled(true);
		jtfNomeCarro.setEnabled(true);
		jtfPlaca.setEnabled(true);
		jctDataAgendamento.setEnabled(true);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
	}
	
	public void acionarBotaoNovoCadastroItemOsv() {
		jbtNovoItemServico.setEnabled(false);
		jtfCodigoTipoServico.setEnabled(true);
		jtfDescricaoTipoServico.setEnabled(true);
		jtfQuantidade.setEnabled(true);
		jtfValorUnitario.setEnabled(true);
		jtfValorTotalItemServico.setEnabled(true);
		jtaObservacaoServico.setEnabled(true);
		jbtSalvarItemServico.setEnabled(true);
		jbtCancelarItemServico.setEnabled(true);
	}
	
	public void salvarCadastroOsv() {
		
	}
	
	public void salvarEdicaoCadastroOsv() {
		
	}
	
	public void acionarBotaoEditar() {
		
	}
	
	public void acionarBotaoCancelarCadastroOsv() {
		jbtNovo.setEnabled(true);
		jrbPagamentoPrazo.setEnabled(false);
		jrbPagamentoVista.setEnabled(false);
		jckbOrdemServicoCancelada.setEnabled(false);
		jtfNomeCliente.setEnabled(false);
		jtfNomeFantasia.setEnabled(false);
		jtfTelefoneCelular.setEnabled(false);
		jtfTelefoneComercial.setEnabled(false);
		jtfTelefoneResidencial.setEnabled(false);
		jtfNomeCarro.setEnabled(false);
		jtfPlaca.setEnabled(false);
		jctDataAgendamento.setEnabled(false);
		jtfNomeCliente.setText("");
		jtfCpf.setText("");
		jtfNomeFantasia.setText("");
		jtfCnpj.setText("");
		jtfTelefoneCelular.setText("");
		jtfTelefoneComercial.setText("");
		jtfTelefoneResidencial.setText("");
		jtfNomeCarro.setText("");
		jtfPlaca.setText("");
		jbtSalvar.setEnabled(false);
		jbtCancelar.setEnabled(false);
	}
	
	public void acionarBotaoCancelarCadastroItemOsv() {
		jbtNovoItemServico.setEnabled(true);
		jtfCodigoTipoServico.setEnabled(false);
		jtfDescricaoTipoServico.setEnabled(false);
		jtfQuantidade.setEnabled(false);
		jtfValorUnitario.setEnabled(false);
		jtfValorTotalItemServico.setEnabled(false);
		jtaObservacaoServico.setEnabled(false);
		jtfCodigoTipoServico.setText("");
		jtfDescricaoTipoServico.setText("");
		jtfQuantidade.setText("");
		jtfValorUnitario.setText("");
		jtfValorTotalItemServico.setText("");
		jtaObservacaoServico.setText("");
		jbtSalvarItemServico.setEnabled(false);
		jbtCancelarItemServico.setEnabled(false);
	}
	
	public void acoesDosBotoes() {
		jbtNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent acvt) {
				if(acvt.getSource() == jbtNovo) {
					acionarBotaoNovoCadastroOsv();
				}
			}
		});
		
		jbtNovoItemServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent acvt) {
				if(acvt.getSource() == jbtNovoItemServico) {
					acionarBotaoNovoCadastroItemOsv();
				}
			}
		});
		
		jbtSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent acvt) {
				if(acvt.getSource() == jbtSalvar) {
					
				}
			}
		});
		
		jbtSalvarItemServico.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent acvt) {
				if(acvt.getSource() == jbtSalvarItemServico) {
					
				}
			}
		});
		
		jbtEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent acvt) {
				if(acvt.getSource() == jbtEditar) {
					
				}
			}
		});
		
		jbtEditarItemServico.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent acvt) {
				if(acvt.getSource() == jbtEditarItemServico) {
					
				}
			}
		});
		
		jbtCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent acvt) {
				if(acvt.getSource() == jbtCancelar) {
					acionarBotaoCancelarCadastroOsv();
				}
			}
		});
		
		jbtCancelarItemServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent acvt) {
				if(acvt.getSource() == jbtCancelarItemServico) {
					acionarBotaoCancelarCadastroItemOsv();;
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
	
	public OrdemServicoForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(OrdemServicoForm.class.getResource("/Imagens/washCar.jpeg")));
		setTitle("Ordem de Serviço | WashCar");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 702, 577);
		jpnOrdemServico = new JPanel();
		jpnOrdemServico.setLayout(null);
		setLocationRelativeTo(null);
		
		componentesTelaOrdemServico();
		acoesDosBotoes();
	}
}