package forms.WashCar;

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

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JCheckBox;

import validacaoCampos.WashCar.ValidaCampoAlfaNumerico;
import validacaoCampos.WashCar.ValidaCampoNumeroInteiro;
import validacaoCampos.WashCar.ValidaCampoValor;

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
	private JTextField jtfPesquisaCodigoOrdemServico;
	private JTextField jtfPesquisaNomeClienteOrdemServico;
	private JTextField jtfPesquisaPlacaCarroOrdemServico;
	private JTextField jtfCodigoCliente;
	private JTextField jtfDataAlteracao;
	private JTextField jtfNomeCliente;
	private JTextField jtfCpf;
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
	private JLabel jlbValorTotal;
	private JLabel jlbTelefoneCelular;
	private JLabel jlbTelefoneResidencial;
	private JLabel jlbTelefoneComercial;
	private JLabel jlbPlaca;
	private JLabel jlbNomeCarro;
	private JLabel jlbCnpj;
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
	private JCheckBox jckbxOrdemServicoCancelada;
	private JButton jbtFechar;
	private JButton jbtSalvar;
	private JButton jbtEditar;
	private JButton jbtNovo;
	private JButton jbtCancelar;
	private JButton jbtCancelarItemServico;
	private JButton jbtSalvarItemServico;
	private JButton jbtEditarItemServico;
	private JButton jbtNovoItemServico;
	private JTabbedPane jtbOrdemServico;
	private JTable jttGridItensServico;
	private DefaultTableModel dtmGridItensServico;
	private Vector<String> dados;
	private JScrollPane jspGridItensServico;
	private JMenuBar jmbOrdemServico;
	private JMenu jmnRelatorio;
	private JFormattedTextField jtfDataAgendamento;

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
		jtbOrdemServico.setBounds(10, 11, 673, 373);//605 - 575
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
		jtfPesquisaNomeClienteOrdemServico.setDocument(new ValidaCampoAlfaNumerico());
		jtfPesquisaNomeClienteOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaNomeClienteOrdemServico.setColumns(10);
		jtfPesquisaNomeClienteOrdemServico.setBounds(120, 52, 275, 20);
		jpnPesquisaOrdemServico.add(jtfPesquisaNomeClienteOrdemServico);

		try {
			jtfPesquisaPlacaCarroOrdemServico = new JFormattedTextField(new MaskFormatter("UUU-####"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfPesquisaPlacaCarroOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaPlacaCarroOrdemServico.setColumns(10);
		jtfPesquisaPlacaCarroOrdemServico.setBounds(405, 52, 75, 20);
		jpnPesquisaOrdemServico.add(jtfPesquisaPlacaCarroOrdemServico);
		
		jlbPesquisaPlacaCarroOrdemServico = new JLabel("Placa do Carro");
		jlbPesquisaPlacaCarroOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaPlacaCarroOrdemServico.setBounds(405, 36, 100, 14);
		jpnPesquisaOrdemServico.add(jlbPesquisaPlacaCarroOrdemServico);
		
		jlbConsultaOrdemServico = new JLabel("Consulta de Ordens de Servi\u00E7o");
		jlbConsultaOrdemServico.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbConsultaOrdemServico.setBounds(10, 11, 405, 14);
		jpnPesquisaOrdemServico.add(jlbConsultaOrdemServico);
		
		jlbCodigoCliente = new JLabel("C\u00F3d. Cliente");
		jlbCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoCliente.setBounds(10, 152, 141, 14);
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
		jlbDataAlteracao.setBounds(546, 105, 114, 14);
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
		jtfDataAlteracao.setBounds(546, 121, 75, 20);
		jpnDadosOrdemServico.add(jtfDataAlteracao);
		
		jlbNomeCliente = new JLabel("Nome do Cliente");
		jlbNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeCliente.setBounds(10, 199, 265, 14);
		jpnDadosOrdemServico.add(jlbNomeCliente);
		
		jtfNomeCliente = new JTextField();
		jtfNomeCliente.setDocument(new ValidaCampoAlfaNumerico());
		jtfNomeCliente.setEnabled(false);
		jtfNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeCliente.setColumns(10);
		jtfNomeCliente.setBounds(10, 215, 381, 20);
		jpnDadosOrdemServico.add(jtfNomeCliente);
		
		jlbCpf = new JLabel("CPF");
		jlbCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCpf.setBounds(401, 199, 100, 14);
		jpnDadosOrdemServico.add(jlbCpf);
		
		try {
			jtfCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfCpf.setEnabled(false);
		jtfCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCpf.setColumns(10);
		jtfCpf.setBounds(401, 215, 100, 20);
		jpnDadosOrdemServico.add(jtfCpf);
		
		jlbCnpj = new JLabel("CNPJ");
		jlbCnpj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCnpj.setBounds(511, 199, 120, 14);
		jpnDadosOrdemServico.add(jlbCnpj);
		
		try {
			jtfCnpj = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfCnpj.setEnabled(false);
		jtfCnpj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCnpj.setColumns(10);
		jtfCnpj.setBounds(511, 215, 125, 20);
		jpnDadosOrdemServico.add(jtfCnpj);
		
		jlbNomeCarro = new JLabel("Nome do Carro");
		jlbNomeCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeCarro.setBounds(108, 246, 270, 14);
		jpnDadosOrdemServico.add(jlbNomeCarro);
		
		jtfNomeCarro = new JTextField();
		jtfNomeCarro.setDocument(new ValidaCampoAlfaNumerico());
		jtfNomeCarro.setEnabled(false);
		jtfNomeCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeCarro.setColumns(10);
		jtfNomeCarro.setBounds(108, 260, 283, 20);
		jpnDadosOrdemServico.add(jtfNomeCarro);
		
		try {
			jtfPlaca = new JFormattedTextField(new MaskFormatter("UUU-####"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfPlaca.setEnabled(false);
		jtfPlaca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPlaca.setColumns(10);
		jtfPlaca.setBounds(401, 260, 75, 20);
		jpnDadosOrdemServico.add(jtfPlaca);
		
		jlbPlaca = new JLabel("Placa do Carro");
		jlbPlaca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPlaca.setBounds(401, 246, 130, 14);
		jpnDadosOrdemServico.add(jlbPlaca);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 302, 120, 25);
		jpnDadosOrdemServico.add(jbtNovo);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setEnabled(false);
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setBounds(140, 302, 120, 25);
		jpnDadosOrdemServico.add(jbtEditar);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setEnabled(false);
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(270, 302, 120, 25);
		jpnDadosOrdemServico.add(jbtSalvar);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setBounds(530, 302, 120, 25);
		jpnDadosOrdemServico.add(jbtFechar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setEnabled(false);
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setBounds(400, 302, 120, 25);
		jpnDadosOrdemServico.add(jbtCancelar);
		
		jckbxOrdemServicoCancelada = new JCheckBox("Cancelada");
		jckbxOrdemServicoCancelada.setEnabled(false);
		jckbxOrdemServicoCancelada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jckbxOrdemServicoCancelada.setBounds(401, 120, 130, 23);
		jpnDadosOrdemServico.add(jckbxOrdemServicoCancelada);
		
		jlbTelefoneComercial = new JLabel("Telefone Comercial");
		jlbTelefoneComercial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneComercial.setBounds(140, 152, 130, 14);
		jpnDadosOrdemServico.add(jlbTelefoneComercial);
		
		jtfTelefoneComercial = new JTextField();
		jtfTelefoneComercial.setEnabled(false);
		jtfTelefoneComercial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneComercial.setColumns(10);
		jtfTelefoneComercial.setBounds(140, 168, 130, 20);
		jpnDadosOrdemServico.add(jtfTelefoneComercial);
		
		jlbTelefoneResidencial = new JLabel("Telefone Residencial");
		jlbTelefoneResidencial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneResidencial.setBounds(280, 152, 130, 14);
		jpnDadosOrdemServico.add(jlbTelefoneResidencial);
		
		jtfTelefoneResidencial = new JTextField();
		jtfTelefoneResidencial.setEnabled(false);
		jtfTelefoneResidencial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneResidencial.setColumns(10);
		jtfTelefoneResidencial.setBounds(280, 167, 130, 20);
		jpnDadosOrdemServico.add(jtfTelefoneResidencial);
		
		jlbTelefoneCelular = new JLabel("Telefone Celular");
		jlbTelefoneCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneCelular.setBounds(420, 152, 130, 14);
		jpnDadosOrdemServico.add(jlbTelefoneCelular);
		
		jtfTelefoneCelular = new JTextField();
		jtfTelefoneCelular.setEnabled(false);
		jtfTelefoneCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneCelular.setColumns(10);
		jtfTelefoneCelular.setBounds(420, 168, 130, 20);
		jpnDadosOrdemServico.add(jtfTelefoneCelular);
		
		jtfValorTotal = new JTextField();
		jtfValorTotal.setDocument(new ValidaCampoValor());
		jtfValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfValorTotal.setEditable(false);
		jtfValorTotal.setColumns(10);
		jtfValorTotal.setBackground(Color.YELLOW);
		jtfValorTotal.setBounds(140, 121, 130, 20);
		jpnDadosOrdemServico.add(jtfValorTotal);
		
		jlbValorTotal = new JLabel("Valor Total");
		jlbValorTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbValorTotal.setBounds(140, 107, 130, 14);
		jpnDadosOrdemServico.add(jlbValorTotal);
		
		jlbDataServico = new JLabel("Data Agendamento");
		jlbDataServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataServico.setBounds(280, 106, 150, 14);
		jpnDadosOrdemServico.add(jlbDataServico);
		
		jtfCodigoOSV = new JTextField();
		jtfCodigoOSV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoOSV.setEditable(false);
		jtfCodigoOSV.setColumns(10);
		jtfCodigoOSV.setBackground(Color.YELLOW);
		jtfCodigoOSV.setBounds(10, 121, 50, 20);
		jpnDadosOrdemServico.add(jtfCodigoOSV);
		
		jlbCodigoOSV = new JLabel("C\u00F3d. OSV");
		jlbCodigoOSV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoOSV.setBounds(10, 105, 90, 14);
		jpnDadosOrdemServico.add(jlbCodigoOSV);
		
		jlbCodigoCarro = new JLabel("C\u00F3d. Carro");
		jlbCodigoCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoCarro.setBounds(10, 246, 102, 14);
		jpnDadosOrdemServico.add(jlbCodigoCarro);
		
		jtfCodigoCarro = new JTextField();
		jtfCodigoCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoCarro.setEditable(false);
		jtfCodigoCarro.setColumns(10);
		jtfCodigoCarro.setBackground(Color.YELLOW);
		jtfCodigoCarro.setBounds(10, 260, 50, 20);
		jpnDadosOrdemServico.add(jtfCodigoCarro);
		
		try {
			jtfDataAgendamento = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfDataAgendamento.setHorizontalAlignment(SwingConstants.RIGHT);
		jtfDataAgendamento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfDataAgendamento.setEnabled(false);
		jtfDataAgendamento.setBounds(280, 121, 75, 20);
		jpnDadosOrdemServico.add(jtfDataAgendamento);
		
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
		jspGridItensServico.setBounds(10, 10, 640, 190);
		
		jlbDescricaoServico = new JLabel("Descri\u00E7\u00E3o do Servi\u00E7o");
		jlbDescricaoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDescricaoServico.setBounds(170, 211, 324, 14);
		jpnCadastroServico.add(jlbDescricaoServico);
		
		jtfDescricaoTipoServico = new JTextField();
		jtfDescricaoTipoServico.setDocument(new ValidaCampoAlfaNumerico());
		jtfDescricaoTipoServico.setEnabled(false);
		jtfDescricaoTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfDescricaoTipoServico.setColumns(10);
		jtfDescricaoTipoServico.setBounds(170, 226, 324, 20);
		jpnCadastroServico.add(jtfDescricaoTipoServico);
		
		jtfCodigoTipoServico = new JTextField();
		jtfCodigoTipoServico.setDocument(new ValidaCampoNumeroInteiro());
		jtfCodigoTipoServico.setEnabled(false);
		jtfCodigoTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoTipoServico.setColumns(10);
		jtfCodigoTipoServico.setBounds(10, 226, 50, 20);
		jpnCadastroServico.add(jtfCodigoTipoServico);
		
		jlbCodigoTipoServico = new JLabel("C\u00F3d. Tipo de Servi\u00E7o");
		jlbCodigoTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoTipoServico.setBounds(10, 211, 160, 14);
		jpnCadastroServico.add(jlbCodigoTipoServico);
		
		jtfQuantidade = new JTextField();
		jtfQuantidade.setDocument(new ValidaCampoNumeroInteiro());
		jtfQuantidade.setEnabled(false);
		jtfQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfQuantidade.setColumns(10);
		jtfQuantidade.setBounds(10, 271, 50, 20);
		jpnCadastroServico.add(jtfQuantidade);
		
		jlbQuantidade = new JLabel("Quantidade");
		jlbQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbQuantidade.setBounds(10, 257, 120, 14);
		jpnCadastroServico.add(jlbQuantidade);
		
		jtfValorUnitario = new JTextField();
		jtfValorUnitario.setDocument(new ValidaCampoValor());
		jtfValorUnitario.setEnabled(false);
		jtfValorUnitario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfValorUnitario.setColumns(10);
		jtfValorUnitario.setBounds(130, 271, 135, 20);
		jpnCadastroServico.add(jtfValorUnitario);
		
		jlbValorUnitario = new JLabel("Valor Unit\u00E1rio");
		jlbValorUnitario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbValorUnitario.setBounds(130, 257, 135, 14);
		jpnCadastroServico.add(jlbValorUnitario);
		
		jtfValorTotalItemServico = new JTextField();
		jtfValorTotalItemServico.setDocument(new ValidaCampoValor());
		jtfValorTotalItemServico.setEnabled(false);
		jtfValorTotalItemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfValorTotalItemServico.setColumns(10);
		jtfValorTotalItemServico.setBounds(275, 271, 135, 20);
		jpnCadastroServico.add(jtfValorTotalItemServico);
		
		jlbValorTotalItemServico = new JLabel("Valor Total");
		jlbValorTotalItemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbValorTotalItemServico.setBounds(275, 257, 135, 14);
		jpnCadastroServico.add(jlbValorTotalItemServico);
		
		jbtNovoItemServico = new JButton("Novo");
		jbtNovoItemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovoItemServico.setBounds(10, 302, 120, 25);
		jpnCadastroServico.add(jbtNovoItemServico);
		
		jbtEditarItemServico = new JButton("Editar");
		jbtEditarItemServico.setEnabled(false);
		jbtEditarItemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditarItemServico.setBounds(140, 302, 120, 25);
		jpnCadastroServico.add(jbtEditarItemServico);
		
		jbtSalvarItemServico = new JButton("Salvar");
		jbtSalvarItemServico.setEnabled(false);
		jbtSalvarItemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvarItemServico.setBounds(270, 302, 120, 25);
		jpnCadastroServico.add(jbtSalvarItemServico);
		
		jbtCancelarItemServico = new JButton("Cancelar");
		jbtCancelarItemServico.setEnabled(false);
		jbtCancelarItemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelarItemServico.setBounds(400, 302, 120, 25);
		jpnCadastroServico.add(jbtCancelarItemServico);
	}
	
	public void acionarBotaoNovoCadastroOsv() {
		jckbxOrdemServicoCancelada.setEnabled(true);
		jtfNomeCliente.setEnabled(true);
		jtfNomeCarro.setEnabled(true);
		jtfDataAgendamento.setEnabled(true);
		jbtNovo.setEnabled(false);
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
		jckbxOrdemServicoCancelada.setEnabled(false);
		jtfNomeCliente.setEnabled(false);
		jtfNomeCarro.setEnabled(false);
		jtfDataAgendamento.setEnabled(false);
		jtfNomeCliente.setText("");
		jtfCpf.setText("");
		jtfCnpj.setText("");
		jtfTelefoneCelular.setText("");
		jtfTelefoneComercial.setText("");
		jtfTelefoneResidencial.setText("");
		jtfNomeCarro.setText("");
		jtfPlaca.setText("");
		jbtNovo.setEnabled(true);
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
		jtfCodigoTipoServico.setText("");
		jtfDescricaoTipoServico.setText("");
		jtfQuantidade.setText("");
		jtfValorUnitario.setText("");
		jtfValorTotalItemServico.setText("");
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
		setBounds(100, 100, 699, 445); //700 - 575
		jpnOrdemServico = new JPanel();
		jpnOrdemServico.setLayout(null);
		setLocationRelativeTo(null);
		
		componentesTelaOrdemServico();
		acoesDosBotoes();
	}
}