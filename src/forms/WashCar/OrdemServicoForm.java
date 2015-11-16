package forms.WashCar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import daoFactory.WashCar.DaoFactory;
import exception.WashCar.RegistroExistente;
import exception.WashCar.RegistroNotExistente;
import model.WashCar.Carro;
import model.WashCar.Cliente;
import model.WashCar.Entidade;
import model.WashCar.OrdemServico;
import preencherDados.WashCar.PreencherDados;
import validacaoCampos.WashCar.ValidaCampoAlfaNumerico;
import validacaoCampos.WashCar.ValidaCampoNumeroInteiro;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class OrdemServicoForm extends JFrame implements PreencherDados {

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
	private JTextField jtfValorTotalItemServico;
	private JTextField jtfCodigoOSV;
	private JTextField jtfCodigoCarro;
	private JFormattedTextField jtfDataAgendamento;
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
	private JButton jbtFecharItemServico;
	private JTabbedPane jtbOrdemServico;
	private JTable jttGridItensServico;
	private DefaultTableModel dtmGridItensServico;
	private Vector<String> dados;
	private JScrollPane jspGridItensServico;
	private JMenuBar jmbOrdemServico;
	private JMenu jmnRelatorio;
	private OrdemServico ordemServico;
	private static OrdemServicoForm ordemServicoForm;

	@SuppressWarnings("static-access")
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
		jbtEditar.setBounds(271, 302, 120, 25);
		jpnDadosOrdemServico.add(jbtEditar);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setEnabled(false);
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(140, 302, 120, 25);
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
		jtfValorTotal.setEnabled(false);
		jtfValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfValorTotal.setColumns(10);
		jtfValorTotal.setBackground(Color.YELLOW);
		jtfValorTotal.setBounds(140, 121, 75, 20);
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
		jttGridItensServico.getColumnModel().getColumn(0).setPreferredWidth(70);
		jttGridItensServico.getColumnModel().getColumn(1).setResizable(false);
		jttGridItensServico.getColumnModel().getColumn(1).setPreferredWidth(467);
		jttGridItensServico.getColumnModel().getColumn(2).setResizable(false);
		jttGridItensServico.getColumnModel().getColumn(2).setPreferredWidth(100);
		jspGridItensServico = new JScrollPane(jttGridItensServico);
		jttGridItensServico.setAutoResizeMode(jttGridItensServico.AUTO_RESIZE_OFF);
		jpnCadastroServico.add(jspGridItensServico);
		jspGridItensServico.setBounds(10, 10, 640, 235);
		
		jlbDescricaoServico = new JLabel("Descri\u00E7\u00E3o do Servi\u00E7o");
		jlbDescricaoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDescricaoServico.setBounds(170, 256, 324, 14);
		jpnCadastroServico.add(jlbDescricaoServico);
		
		jtfDescricaoTipoServico = new JTextField();
		jtfDescricaoTipoServico.setDocument(new ValidaCampoAlfaNumerico());
		jtfDescricaoTipoServico.setEnabled(false);
		jtfDescricaoTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfDescricaoTipoServico.setColumns(10);
		jtfDescricaoTipoServico.setBounds(170, 271, 324, 20);
		jpnCadastroServico.add(jtfDescricaoTipoServico);
		
		jtfCodigoTipoServico = new JTextField();
		jtfCodigoTipoServico.setHorizontalAlignment(SwingConstants.CENTER);
		jtfCodigoTipoServico.setDocument(new ValidaCampoNumeroInteiro());
		jtfCodigoTipoServico.setEnabled(false);
		jtfCodigoTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoTipoServico.setColumns(10);
		jtfCodigoTipoServico.setBounds(10, 271, 50, 20);
		jpnCadastroServico.add(jtfCodigoTipoServico);
		
		jlbCodigoTipoServico = new JLabel("C\u00F3d. Tipo de Servi\u00E7o");
		jlbCodigoTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoTipoServico.setBounds(10, 256, 160, 14);
		jpnCadastroServico.add(jlbCodigoTipoServico);
		
		jtfValorTotalItemServico = new JTextField();
		jtfValorTotalItemServico.setHorizontalAlignment(SwingConstants.RIGHT);
		jtfValorTotalItemServico.setEnabled(false);
		jtfValorTotalItemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfValorTotalItemServico.setColumns(10);
		jtfValorTotalItemServico.setBounds(515, 271, 80, 20);
		jpnCadastroServico.add(jtfValorTotalItemServico);
		
		jlbValorTotalItemServico = new JLabel("Valor Total");
		jlbValorTotalItemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbValorTotalItemServico.setBounds(515, 257, 135, 14);
		jpnCadastroServico.add(jlbValorTotalItemServico);
		
		jbtNovoItemServico = new JButton("Novo");
		jbtNovoItemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovoItemServico.setBounds(10, 302, 120, 25);
		jpnCadastroServico.add(jbtNovoItemServico);
		
		jbtEditarItemServico = new JButton("Editar");
		jbtEditarItemServico.setEnabled(false);
		jbtEditarItemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditarItemServico.setBounds(270, 302, 120, 25);
		jpnCadastroServico.add(jbtEditarItemServico);
		
		jbtSalvarItemServico = new JButton("Salvar");
		jbtSalvarItemServico.setEnabled(false);
		jbtSalvarItemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvarItemServico.setBounds(140, 302, 120, 25);
		jpnCadastroServico.add(jbtSalvarItemServico);
		
		jbtCancelarItemServico = new JButton("Cancelar");
		jbtCancelarItemServico.setEnabled(false);
		jbtCancelarItemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelarItemServico.setBounds(400, 302, 120, 25);
		jpnCadastroServico.add(jbtCancelarItemServico);
		
		jbtFecharItemServico = new JButton("Fechar");
		jbtFecharItemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFecharItemServico.setBounds(530, 302, 120, 25);
		jpnCadastroServico.add(jbtFecharItemServico);
		
		jtfPesquisaCodigoOrdemServico.requestFocus();
	}
	
	public void acionarBotaoNovoCadastroOsv() {
		jckbxOrdemServicoCancelada.setEnabled(false);
		jckbxOrdemServicoCancelada.setSelected(false);
		jtfDataAgendamento.setEnabled(true);
		jtfNomeCliente.setEnabled(true);
		jtfNomeCarro.setEnabled(true);
		jtfPlaca.setEnabled(true);
		jtfCodigoOSV.setText("");
		jtfValorTotal.setText("");
		jtfDataAgendamento.setText("");
		jtfDataAlteracao.setText("");
		jtfCodigoCliente.setText("");
		jtfTelefoneComercial.setText("");
		jtfTelefoneResidencial.setText("");
		jtfTelefoneCelular.setText("");
		jtfNomeCliente.setText("");
		jtfCpf.setText("");
		jtfCnpj.setText("");
		jtfCodigoCarro.setText("");
		jtfNomeCarro.setText("");
		jtfPlaca.setText("");
		jbtNovo.setEnabled(false);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
		jbtEditar.setEnabled(false);
	}
	
	public void acionarBotaoNovoCadastroItemOsv() {
		jtfCodigoTipoServico.setEnabled(true);
		jtfDescricaoTipoServico.setEnabled(true);
		jbtNovoItemServico.setEnabled(false);
		jbtSalvarItemServico.setEnabled(true);
		jbtCancelarItemServico.setEnabled(true);
	}
	
	@SuppressWarnings("static-access")
	public void salvarCadastroOsv() throws RegistroExistente {
		if(jtfDataAgendamento.getText().equals("  /  /  ")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar uma data de agendamento do serviço!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfDataAgendamento.requestFocus();
		} else if(jtfCodigoCliente.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar nome do cliente!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeCliente.requestFocus();
		} else {
			this.ordemServico = new OrdemServico();
			this.ordemServico.setValorTotal(Double.valueOf(jtfValorTotal.getText().replace(",", ".")));
			this.ordemServico.setOrdemServicoCancelada(jckbxOrdemServicoCancelada.isSelected());
			this.ordemServico.setDataAgendamento(Date.valueOf(jtfDataAgendamento.getText()).toLocalDate());
			this.ordemServico.setDataAlteracao(Date.valueOf(ordemServico.getDataAlteracao().now()).toLocalDate());
			this.ordemServico.setCliente(new Cliente(Integer.valueOf(jtfCodigoCliente.getText()), null));
			DaoFactory.getFactory().ordemServicoDao().inserir(ordemServico);
			jtfCodigoOSV.setText(String.valueOf(this.ordemServico.getIdOrdemServico()));
			jtfDataAlteracao.setText(this.ordemServico.getDataAlteracao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
			jtfDataAgendamento.setEnabled(false);
			jtfNomeCliente.setEnabled(false);
			jbtSalvar.setEnabled(false);
			jbtEditar.setEnabled(true);
			jbtNovo.setEnabled(true);
			jbtCancelar.setEnabled(false);
		}
	}
	
	@SuppressWarnings("static-access")
	public void salvarEdicaoCadastroOsv() throws RegistroExistente {
		if(jtfDataAgendamento.getText().equals("  /  /  ")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar uma data de agendamento do serviço!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfDataAgendamento.requestFocus();
		} else if(jtfCodigoCliente.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar nome do cliente!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeCliente.requestFocus();
		} else {
			this.ordemServico = new OrdemServico();
			this.ordemServico.setValorTotal(Double.valueOf(jtfValorTotal.getText().replace(",", ".")));
			this.ordemServico.setOrdemServicoCancelada(jckbxOrdemServicoCancelada.isSelected());
			this.ordemServico.setDataAgendamento(Date.valueOf(jtfDataAgendamento.getText()).toLocalDate());
			this.ordemServico.setDataAlteracao(Date.valueOf(ordemServico.getDataAlteracao().now()).toLocalDate());
			this.ordemServico.setCliente(new Cliente(Integer.valueOf(jtfCodigoCliente.getText()), null));
			DaoFactory.getFactory().ordemServicoDao().inserir(ordemServico);
			jtfDataAlteracao.setText(this.ordemServico.getDataAlteracao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
			jtfDataAgendamento.setEnabled(false);
			jtfNomeCliente.setEnabled(false);
			jbtSalvar.setEnabled(false);
			jbtEditar.setEnabled(true);
			jbtNovo.setEnabled(true);
			jbtCancelar.setEnabled(false);
		}
	}
	
	public void salvarCadastroItemOSV() {
		
	}
	
	public void salvarEdicaoItemOSV() {
		
	}
	
	public void acionarBotaoEditar() {
		jckbxOrdemServicoCancelada.setEnabled(true);
		jtfDataAgendamento.setEnabled(true);
		jtfNomeCliente.setEnabled(true);
		jtfNomeCarro.setEnabled(true);
		jtfPlaca.setEnabled(true);
		jbtNovo.setEnabled(false);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
	}
	
	public void acionarBotaoEditarItemOSV() {
		
	}
	
	public void acionarBotaoCancelarCadastroOsv() {
		jckbxOrdemServicoCancelada.setEnabled(false);
		jckbxOrdemServicoCancelada.setSelected(false);
		jtfDataAgendamento.setEnabled(false);
		jtfNomeCliente.setEnabled(false);
		jtfNomeCarro.setEnabled(false);
		jtfPlaca.setEnabled(false);
		jtfCodigoOSV.setText("");
		jtfValorTotal.setText("");
		jtfDataAgendamento.setText("");
		jtfDataAlteracao.setText("");
		jtfCodigoCliente.setText("");
		jtfTelefoneComercial.setText("");
		jtfTelefoneResidencial.setText("");
		jtfTelefoneCelular.setText("");
		jtfNomeCliente.setText("");
		jtfCpf.setText("");
		jtfCnpj.setText("");
		jtfCodigoCarro.setText("");
		jtfNomeCarro.setText("");
		jtfPlaca.setText("");
		jbtNovo.setEnabled(true);
		jbtCancelar.setEnabled(false);
		jbtSalvar.setEnabled(false);
		jbtEditar.setEnabled(false);
	}
	
	public void acionarBotaoCancelarCadastroItemOsv() {
		jbtNovoItemServico.setEnabled(true);
		jtfCodigoTipoServico.setEnabled(false);
		jtfDescricaoTipoServico.setEnabled(false);
		jtfCodigoTipoServico.setText("");
		jtfDescricaoTipoServico.setText("");
		jtfValorTotalItemServico.setText("");
		jbtSalvarItemServico.setEnabled(false);
		jbtCancelarItemServico.setEnabled(false);
	}
	
	public void peencherCamposOrdemServico(OrdemServico ordemServico) {
		jtfCodigoOSV.setText(String.valueOf(ordemServico.getIdOrdemServico()));
		jtfValorTotal.setText(String.valueOf(new DecimalFormat("R$ #,##0.00").format(ordemServico.getValorTotal())));
		jtfDataAgendamento.setText(ordemServico.getDataAgendamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
		jtfDataAlteracao.setText(ordemServico.getDataAlteracao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
		if(ordemServico.isOrdemServicoCancelada()) {
			jckbxOrdemServicoCancelada.setSelected(true);
		} else {
			jckbxOrdemServicoCancelada.setSelected(false);
		}
		if(ordemServico.getCliente().getTipoPessoa() == 1) {
			jtfCodigoCliente.setText(String.valueOf(ordemServico.getCliente().getIdCliente()));
			jtfNomeCliente.setText(ordemServico.getCliente().getPessoaFisica().getNome());
			jtfCpf.setText(ordemServico.getCliente().getPessoaFisica().getCpf());
		} else {
			jtfCodigoCliente.setText(String.valueOf(ordemServico.getCliente().getIdCliente()));
			jtfNomeCliente.setText(ordemServico.getCliente().getPessoaJuridica().getNomeFantasia());
			jtfCnpj.setText(ordemServico.getCliente().getPessoaJuridica().getCnpj());
		}
		jtfCodigoCarro.setText(String.valueOf(ordemServico.getCarro().getIdCarro()));
		jtfNomeCarro.setText(ordemServico.getCarro().getNome());
		jtfPlaca.setText(ordemServico.getCarro().getPlaca());
	}
	
	public void preencherCamposCliente(Cliente cliente) {
		if(cliente.getTipoPessoa() == 1) {
			if(cliente.isForaUso()) {
				JOptionPane.showMessageDialog(null, "O cliente selecionado está fora de uso.\n"
				+ "Por gentileza, entre em contato com o responsável!\n"
				+ "Após a confirmação o cadastro será cancelado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				this.acionarBotaoCancelarCadastroItemOsv();
			} else {
				jtfCodigoCliente.setText(String.valueOf(cliente.getIdCliente()));
				jtfNomeCliente.setText(cliente.getPessoaFisica().getNome());
				jtfCpf.setText(cliente.getPessoaFisica().getCpf());
			}
		} else {
			if(cliente.isForaUso()) {
				JOptionPane.showMessageDialog(null, "O cliente selecionado está fora de uso.\n"
				+ "Por gentileza, entre em contato com o responsável!\n"
				+ "Após a confirmação o cadastro será cancelado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				this.acionarBotaoCancelarCadastroItemOsv();
			} else {
				jtfCodigoCliente.setText(String.valueOf(cliente.getIdCliente()));
				jtfNomeCliente.setText(cliente.getPessoaJuridica().getNomeFantasia());
				jtfCnpj.setText(cliente.getPessoaJuridica().getCnpj());
			}
		}
	}
	
	public void preencherCamposCarro(Carro carro) {
		if(carro.isForaUso()) {
			JOptionPane.showMessageDialog(null, "O carro selecionado está fora de uso.\n"
			+ "Por gentileza, entre em contato com o responsável!\n"
			+ "Após a confirmação o cadastro será cancelado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			this.acionarBotaoCancelarCadastroItemOsv();
		} else {
			jtfCodigoCarro.setText(String.valueOf(carro.getIdCarro()));
			jtfNomeCarro.setText(carro.getNome());
			jtfPlaca.setText(carro.getPlaca());
		}
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
		
		jbtFecharItemServico.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent acvt) {
				if(acvt.getSource() == jbtFecharItemServico) {
					if(jtfCodigoOSV.getText() == null || jtfCodigoOSV.getText().equals("")) {
						Integer valor = JOptionPane.showConfirmDialog(null, "Você NÃO concluiu o cadastro da Ordem de serviço.\n"
								+ "Deseja realmente fechar sem concluir o cadastro?\n"
								+ "SIM - Cadastro da Ordem de Serviço será cancelado!\n"
								+ "NÃO - Por gentileza, conclua o cadastro da Ordem de Serviço!", "Atenção", JOptionPane.YES_NO_OPTION);
						if(valor == 0) {
							dispose();
						}
					}
				}
			}
		});
	}
	
	public void pesquisaPorCodigo() {
		jtfPesquisaCodigoOrdemServico.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						Integer codigo = null;
						if(!jtfPesquisaCodigoOrdemServico.getText().equals("")) {
							codigo = Integer.valueOf(jtfPesquisaCodigoOrdemServico.getText());
						}
						ListaOrdemServicoForm listaOrdemServico = new ListaOrdemServicoForm(ordemServicoForm, null, codigo, null);
						listaOrdemServico.setVisible(true);
						jckbxOrdemServicoCancelada.setEnabled(false);
						jckbxOrdemServicoCancelada.setSelected(false);
						jtfDataAgendamento.setEnabled(false);
						jtfNomeCliente.setEnabled(false);
						jtfCodigoOSV.setText("");
						jtfValorTotal.setText("");
						jtfDataAgendamento.setText("");
						jtfDataAlteracao.setText("");
						jtfCodigoCliente.setText("");
						jtfTelefoneComercial.setText("");
						jtfTelefoneResidencial.setText("");
						jtfTelefoneCelular.setText("");
						jtfNomeCliente.setText("");
						jtfCpf.setText("");
						jtfCnpj.setText("");
						jtfCodigoCarro.setText("");
						jtfNomeCarro.setText("");
						jtfPlaca.setText("");
						jtfPesquisaPlacaCarroOrdemServico.setText("");
						jtfPesquisaNomeClienteOrdemServico.setText("");
						jtfPesquisaCodigoOrdemServico.setText("");
						jbtEditar.setEnabled(true);
						jbtSalvar.setEnabled(false);
						jbtCancelar.setEnabled(true);
					} catch (RegistroNotExistente e) {
						JOptionPane.showMessageDialog(ordemServicoForm, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
						jtfPesquisaCodigoOrdemServico.setText("");
					}
				}
			}
		});
	}
	
	public void pesquisaPorNome() {
		jtfPesquisaNomeClienteOrdemServico.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						ListaOrdemServicoForm listaOrdemServico = new ListaOrdemServicoForm(ordemServicoForm, jtfPesquisaNomeClienteOrdemServico.getText(), null, null);
						listaOrdemServico.setVisible(true);
						jckbxOrdemServicoCancelada.setEnabled(false);
						jckbxOrdemServicoCancelada.setSelected(false);
						jtfDataAgendamento.setEnabled(false);
						jtfNomeCliente.setEnabled(false);
						jtfCodigoOSV.setText("");
						jtfValorTotal.setText("");
						jtfDataAgendamento.setText("");
						jtfDataAlteracao.setText("");
						jtfCodigoCliente.setText("");
						jtfTelefoneComercial.setText("");
						jtfTelefoneResidencial.setText("");
						jtfTelefoneCelular.setText("");
						jtfNomeCliente.setText("");
						jtfCpf.setText("");
						jtfCnpj.setText("");
						jtfCodigoCarro.setText("");
						jtfNomeCarro.setText("");
						jtfPlaca.setText("");
						jtfPesquisaPlacaCarroOrdemServico.setText("");
						jtfPesquisaNomeClienteOrdemServico.setText("");
						jtfPesquisaCodigoOrdemServico.setText("");
						jbtEditar.setEnabled(true);
						jbtSalvar.setEnabled(false);
						jbtCancelar.setEnabled(true);
					} catch (RegistroNotExistente e) {
						JOptionPane.showMessageDialog(ordemServicoForm, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
						jtfPesquisaNomeClienteOrdemServico.setText("");
					}
				}
			}
		});
	}
	
	public void pesquisaPorPlaca() {
		jtfPesquisaPlacaCarroOrdemServico.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						ListaOrdemServicoForm listaOrdemServico = new ListaOrdemServicoForm(ordemServicoForm, null, null, jtfPesquisaPlacaCarroOrdemServico.getText());
						listaOrdemServico.setVisible(true);
						jckbxOrdemServicoCancelada.setEnabled(false);
						jckbxOrdemServicoCancelada.setSelected(false);
						jtfDataAgendamento.setEnabled(false);
						jtfNomeCliente.setEnabled(false);
						jtfCodigoOSV.setText("");
						jtfValorTotal.setText("");
						jtfDataAgendamento.setText("");
						jtfDataAlteracao.setText("");
						jtfCodigoCliente.setText("");
						jtfTelefoneComercial.setText("");
						jtfTelefoneResidencial.setText("");
						jtfTelefoneCelular.setText("");
						jtfNomeCliente.setText("");
						jtfCpf.setText("");
						jtfCnpj.setText("");
						jtfCodigoCarro.setText("");
						jtfNomeCarro.setText("");
						jtfPlaca.setText("");
						jtfPesquisaPlacaCarroOrdemServico.setText("");
						jtfPesquisaNomeClienteOrdemServico.setText("");
						jtfPesquisaCodigoOrdemServico.setText("");
						jbtEditar.setEnabled(true);
						jbtSalvar.setEnabled(false);
						jbtCancelar.setEnabled(true);
					} catch (RegistroNotExistente e) {
						JOptionPane.showMessageDialog(ordemServicoForm, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
						jtfPesquisaPlacaCarroOrdemServico.setText("");
					}
				}
			}
		});
	}
	
	public void pesquisaNomeCliente() {
		jtfNomeCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						ListaClienteForm listaCliente = new ListaClienteForm(ordemServicoForm, null, jtfNomeCliente.getText(), null, null);
						listaCliente.setVisible(true);
						jtfCodigoCliente.setText("");
						jtfTelefoneComercial.setText("");
						jtfTelefoneResidencial.setText("");
						jtfTelefoneCelular.setText("");
						jtfNomeCliente.setText("");
						jtfCpf.setText("");
						jtfCnpj.setText("");
					} catch (RegistroNotExistente e) {
						JOptionPane.showMessageDialog(ordemServicoForm, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
						jtfNomeCliente.setText("");
					}
				}
			}
		});
	}

	public void pesquisaNomeCarro() {
		jtfNomeCarro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						ListaCarroForm listaCarro = new ListaCarroForm(ordemServicoForm, jtfNomeCarro.getText(), null, null);
						listaCarro.setVisible(true);
						jtfCodigoCarro.setText("");
						jtfNomeCarro.setText("");
						jtfPlaca.setText("");
					} catch (RegistroNotExistente e) {
						JOptionPane.showMessageDialog(ordemServicoForm, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
						jtfNomeCarro.setText("");
					}
				}
			}
		});
	}
	
	public void pesquisaPlacaCarro() {
		jtfPlaca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						ListaCarroForm listaCarro = new ListaCarroForm(ordemServicoForm, null, null, jtfPlaca.getText());
						listaCarro.setVisible(true);
						jtfCodigoCarro.setText("");
						jtfNomeCarro.setText("");
						jtfPlaca.setText("");
					} catch (RegistroNotExistente e) {
						JOptionPane.showMessageDialog(ordemServicoForm, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
						jtfPlaca.setText("");
					}
				}
			}
		});
	}
	
	public OrdemServicoForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(OrdemServicoForm.class.getResource("/Imagens/washCar.jpeg")));
		setTitle("Ordem de Serviço | WashCar");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 699, 445);
		jpnOrdemServico = new JPanel();
		jpnOrdemServico.setLayout(null);
		setLocationRelativeTo(null);
		
		componentesTelaOrdemServico();
		acoesDosBotoes();
		pesquisaPorCodigo();
		pesquisaPorNome();
		pesquisaPorPlaca();
		pesquisaNomeCarro();
		pesquisaPlacaCarro();
		pesquisaNomeCliente();
	}

	@Override
	public void preencherCampos(Entidade entidade) {
		if(entidade instanceof OrdemServico) {
			this.peencherCamposOrdemServico((OrdemServico)entidade);
		} else if(entidade instanceof Cliente) {
			this.preencherCamposCliente((Cliente)entidade);
		} else if(entidade instanceof Carro) {
			this.preencherCamposCarro((Carro)entidade);
		}
	}
}