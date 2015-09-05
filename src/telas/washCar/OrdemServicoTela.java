package telas.washCar;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

import com.toedter.calendar.JDateChooser;

public class OrdemServicoTela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnOrdemServico;
	private JTextField jtfPesquisaCodigoOrdemServico;
	private JTextField jtfPesquisaNomeClienteOrdemServico;
	private JTextField jtfPesquisaPlacaCarroOrdemServico;
	private JTextField jtfCodigo;
	private JTextField jtfDataAlteracao;
	private JTextField jtfNomeCliente;
	private JTextField jtfCpf;
	private JTextField jtfRazaoSocial;
	private JTextField jtfCnpj;
	private JTextField jtfNomeCarro;
	private JTextField jtfModelo;
	private JTextField jtfPlaca;
	private JTextField jtfTelefoneComercial;
	private JTextField jtfTelefoneResidencial;
	private JTextField jtfTelefoneCelular;
	private JTextField jtfValorTotal;
	private JLabel jlbValorTotal;
	private JLabel jlbTelefoneCelular;
	private JLabel jlbTelefoneResidencial;
	private JLabel jlbTelefoneComercial;
	private JLabel jlbFormaPagamento;
	private JCheckBox jckbOrdemServicoCancelada;
	private ButtonGroup jbgFormaPagamento;
	private JButton jbtFechar;
	private JButton jbtSalvar;
	private JButton jbtEditar;
	private JButton jbtNovo;
	private JButton jbtCancelar;
	private JLabel jlbPlaca;
	private JLabel jlbModelo;
	private JLabel jlbNomeCarro;
	private JLabel jlbCnpj;
	private JLabel jlbRazaoSocial;
	private JLabel jlbCpf;
	private JLabel jlbNomeCliente;
	private JLabel jlbDataAlteracao;
	private JLabel jlbCodigo;
	private JLabel jlbPesquisaPlacaCarroOrdemServico;
	private JLabel jlbDescricao;
	private JLabel jlbConsultaOrdemServico;
	private JButton jbtPesquisaOrdemServico;
	private JLabel jlbPesquisaNomeClienteOrdemServico;
	private JLabel jlbPesquisaCodigoOrdemServico;
	private JPanel jpnPesquisaOrdemServico;
	private JPanel jpnDadosOrdemServico;
	private JTabbedPane jtbOrdemServico;
	private JRadioButton jrbPagamentoVista;
	private JRadioButton jrbPagamentoPrazo;
	private JPanel jpnCadastroServico;
	private JTable jttGridItensServico;
	private DefaultTableModel dtmGridItensServico;
	private Vector<String> colunas;
	private JScrollPane jspGridItensServico;
	private JTextField jtfDescricao;
	private JTextField jtfCodigoTipoServico;
	private JTextField jtfQuantidade;
	private JTextField jtfValorUnitario;
	private JTextField jtfValorTotalItemServico;
	private JTextArea jtaObservacaoServico;
	private JScrollPane jspObservacaoServico;
	private JPanel jpnObservacaoServico;
	private JButton jbtCancelarItemServico;
	private JButton jbtSalvarItemServico;
	private JButton jbtEditarItemServico;
	private JButton jbtNovoItemServico;
	private JLabel jlbValorTotalItemServico;
	private JLabel jlbDataServico;
	private JDateChooser jdtcDataAgendamento;

	public void componentesTelaOrdemServico() {
		jtbOrdemServico = new JTabbedPane(JTabbedPane.TOP);
		jtbOrdemServico.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jtbOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtbOrdemServico.setToolTipText("");
		jtbOrdemServico.setBounds(10, 11, 647, 451);
		jpnOrdemServico.add(jtbOrdemServico);
		
		jpnDadosOrdemServico = new JPanel();
		jtbOrdemServico.addTab("Cadastro da Ordem de Servi\u00E7o", null, jpnDadosOrdemServico, null);
		jpnDadosOrdemServico.setLayout(null);
		
		jpnPesquisaOrdemServico = new JPanel();
		jpnPesquisaOrdemServico.setLayout(null);
		jpnPesquisaOrdemServico.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnPesquisaOrdemServico.setBounds(10, 11, 615, 83);
		jpnDadosOrdemServico.add(jpnPesquisaOrdemServico);
		
		jlbPesquisaCodigoOrdemServico = new JLabel("Código OSV");
		jlbPesquisaCodigoOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaCodigoOrdemServico.setBounds(10, 36, 70, 14);
		jpnPesquisaOrdemServico.add(jlbPesquisaCodigoOrdemServico);
		
		jtfPesquisaCodigoOrdemServico = new JTextField();
		jtfPesquisaCodigoOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaCodigoOrdemServico.setColumns(10);
		jtfPesquisaCodigoOrdemServico.setBounds(10, 52, 66, 20);
		jpnPesquisaOrdemServico.add(jtfPesquisaCodigoOrdemServico);
		
		jlbPesquisaNomeClienteOrdemServico = new JLabel("Nome do Cliente");
		jlbPesquisaNomeClienteOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaNomeClienteOrdemServico.setBounds(86, 36, 100, 14);
		jpnPesquisaOrdemServico.add(jlbPesquisaNomeClienteOrdemServico);
		
		jtfPesquisaNomeClienteOrdemServico = new JTextField();
		jtfPesquisaNomeClienteOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaNomeClienteOrdemServico.setColumns(10);
		jtfPesquisaNomeClienteOrdemServico.setBounds(86, 52, 275, 20);
		jpnPesquisaOrdemServico.add(jtfPesquisaNomeClienteOrdemServico);
		
		jbtPesquisaOrdemServico = new JButton("");
		jbtPesquisaOrdemServico.setIcon(new ImageIcon(OrdemServicoTela.class.getResource("/Imagens/lupaPesquisa.jpeg")));
		jbtPesquisaOrdemServico.setBounds(565, 40, 40, 32);
		jpnPesquisaOrdemServico.add(jbtPesquisaOrdemServico);
		
		jtfPesquisaPlacaCarroOrdemServico = new JTextField();
		jtfPesquisaPlacaCarroOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaPlacaCarroOrdemServico.setColumns(10);
		jtfPesquisaPlacaCarroOrdemServico.setBounds(371, 52, 165, 20);
		jpnPesquisaOrdemServico.add(jtfPesquisaPlacaCarroOrdemServico);
		
		jlbPesquisaPlacaCarroOrdemServico = new JLabel("Placa do Carro");
		jlbPesquisaPlacaCarroOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaPlacaCarroOrdemServico.setBounds(371, 36, 100, 14);
		jpnPesquisaOrdemServico.add(jlbPesquisaPlacaCarroOrdemServico);
		
		jlbConsultaOrdemServico = new JLabel("Consulta de Ordens de Servi\u00E7o");
		jlbConsultaOrdemServico.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbConsultaOrdemServico.setBounds(10, 11, 200, 14);
		jpnPesquisaOrdemServico.add(jlbConsultaOrdemServico);
		
		jlbCodigo = new JLabel("C\u00F3digo");
		jlbCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigo.setBounds(10, 105, 46, 14);
		jpnDadosOrdemServico.add(jlbCodigo);
		
		jtfCodigo = new JTextField();
		jtfCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigo.setEditable(false);
		jtfCodigo.setColumns(10);
		jtfCodigo.setBackground(Color.YELLOW);
		jtfCodigo.setBounds(10, 121, 66, 20);
		jpnDadosOrdemServico.add(jtfCodigo);
		
		jlbDataAlteracao = new JLabel("Data Alteracao");
		jlbDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataAlteracao.setBounds(495, 105, 130, 14);
		jpnDadosOrdemServico.add(jlbDataAlteracao);
		
		jtfDataAlteracao = new JTextField();
		jtfDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfDataAlteracao.setEditable(false);
		jtfDataAlteracao.setColumns(10);
		jtfDataAlteracao.setBackground(Color.YELLOW);
		jtfDataAlteracao.setBounds(495, 121, 130, 20);
		jpnDadosOrdemServico.add(jtfDataAlteracao);
		
		jlbNomeCliente = new JLabel("Nome do Cliente");
		jlbNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeCliente.setBounds(10, 152, 150, 14);
		jpnDadosOrdemServico.add(jlbNomeCliente);
		
		jtfNomeCliente = new JTextField();
		jtfNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeCliente.setColumns(10);
		jtfNomeCliente.setBounds(10, 168, 381, 20);
		jpnDadosOrdemServico.add(jtfNomeCliente);
		
		jlbCpf = new JLabel("CPF");
		jlbCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCpf.setBounds(460, 152, 100, 14);
		jpnDadosOrdemServico.add(jlbCpf);
		
		jtfCpf = new JTextField();
		jtfCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCpf.setColumns(10);
		jtfCpf.setBounds(460, 168, 165, 20);
		jpnDadosOrdemServico.add(jtfCpf);
		
		jlbRazaoSocial = new JLabel("Raz\u00E3o Social");
		jlbRazaoSocial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbRazaoSocial.setBounds(10, 199, 150, 14);
		jpnDadosOrdemServico.add(jlbRazaoSocial);
		
		jtfRazaoSocial = new JTextField();
		jtfRazaoSocial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfRazaoSocial.setColumns(10);
		jtfRazaoSocial.setBounds(10, 215, 381, 20);
		jpnDadosOrdemServico.add(jtfRazaoSocial);
		
		jlbCnpj = new JLabel("CNPJ");
		jlbCnpj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCnpj.setBounds(460, 199, 100, 14);
		jpnDadosOrdemServico.add(jlbCnpj);
		
		jtfCnpj = new JTextField();
		jtfCnpj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCnpj.setColumns(10);
		jtfCnpj.setBounds(460, 215, 165, 20);
		jpnDadosOrdemServico.add(jtfCnpj);
		
		jlbNomeCarro = new JLabel("Nome do Carro");
		jlbNomeCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeCarro.setBounds(10, 246, 150, 14);
		jpnDadosOrdemServico.add(jlbNomeCarro);
		
		jtfNomeCarro = new JTextField();
		jtfNomeCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeCarro.setColumns(10);
		jtfNomeCarro.setBounds(10, 262, 265, 20);
		jpnDadosOrdemServico.add(jtfNomeCarro);
		
		jlbModelo = new JLabel("Modelo do Carro");
		jlbModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbModelo.setBounds(10, 293, 150, 14);
		jpnDadosOrdemServico.add(jlbModelo);
		
		jtfModelo = new JTextField();
		jtfModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfModelo.setColumns(10);
		jtfModelo.setBounds(10, 309, 165, 20);
		jpnDadosOrdemServico.add(jtfModelo);
		
		jtfPlaca = new JTextField();
		jtfPlaca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPlaca.setColumns(10);
		jtfPlaca.setBounds(185, 309, 165, 20);
		jpnDadosOrdemServico.add(jtfPlaca);
		
		jlbPlaca = new JLabel("Placa do Carro");
		jlbPlaca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPlaca.setBounds(185, 293, 100, 14);
		jpnDadosOrdemServico.add(jlbPlaca);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 385, 110, 23);
		jpnDadosOrdemServico.add(jbtNovo);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setBounds(138, 385, 110, 23);
		jpnDadosOrdemServico.add(jbtEditar);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(265, 385, 110, 23);
		jpnDadosOrdemServico.add(jbtSalvar);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setBounds(515, 385, 110, 23);
		jpnDadosOrdemServico.add(jbtFechar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setBounds(390, 385, 110, 23);
		jpnDadosOrdemServico.add(jbtCancelar);
		
		jckbOrdemServicoCancelada = new JCheckBox("Cancelada");
		jckbOrdemServicoCancelada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jckbOrdemServicoCancelada.setBounds(346, 120, 97, 23);
		jpnDadosOrdemServico.add(jckbOrdemServicoCancelada);
		
		jlbFormaPagamento = new JLabel("Forma de Pagamento");
		jlbFormaPagamento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbFormaPagamento.setBounds(124, 105, 130, 14);
		jpnDadosOrdemServico.add(jlbFormaPagamento);
		
		jlbTelefoneComercial = new JLabel("Telefone Comercial");
		jlbTelefoneComercial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneComercial.setBounds(495, 246, 130, 14);
		jpnDadosOrdemServico.add(jlbTelefoneComercial);
		
		jtfTelefoneComercial = new JTextField();
		jtfTelefoneComercial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneComercial.setColumns(10);
		jtfTelefoneComercial.setBounds(495, 262, 130, 20);
		jpnDadosOrdemServico.add(jtfTelefoneComercial);
		
		jlbTelefoneResidencial = new JLabel("Telefone Residencial");
		jlbTelefoneResidencial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneResidencial.setBounds(495, 291, 130, 14);
		jpnDadosOrdemServico.add(jlbTelefoneResidencial);
		
		jtfTelefoneResidencial = new JTextField();
		jtfTelefoneResidencial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneResidencial.setColumns(10);
		jtfTelefoneResidencial.setBounds(495, 306, 130, 20);
		jpnDadosOrdemServico.add(jtfTelefoneResidencial);
		
		jlbTelefoneCelular = new JLabel("Telefone Celular");
		jlbTelefoneCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneCelular.setBounds(495, 335, 130, 14);
		jpnDadosOrdemServico.add(jlbTelefoneCelular);
		
		jtfTelefoneCelular = new JTextField();
		jtfTelefoneCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneCelular.setColumns(10);
		jtfTelefoneCelular.setBounds(495, 351, 130, 20);
		jpnDadosOrdemServico.add(jtfTelefoneCelular);
		
		jtfValorTotal = new JTextField();
		jtfValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfValorTotal.setEditable(false);
		jtfValorTotal.setColumns(10);
		jtfValorTotal.setBackground(Color.YELLOW);
		jtfValorTotal.setBounds(10, 351, 130, 20);
		jpnDadosOrdemServico.add(jtfValorTotal);
		
		jlbValorTotal = new JLabel("Valor Total");
		jlbValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbValorTotal.setBounds(10, 335, 130, 14);
		jpnDadosOrdemServico.add(jlbValorTotal);
		
		jrbPagamentoVista = new JRadioButton("\u00C0 Vista");
		jrbPagamentoVista.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jrbPagamentoVista.setBounds(124, 120, 109, 23);
		jpnDadosOrdemServico.add(jrbPagamentoVista);
		
		jrbPagamentoPrazo = new JRadioButton("\u00C0 Prazo");
		jrbPagamentoPrazo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jrbPagamentoPrazo.setBounds(241, 120, 109, 23);
		jpnDadosOrdemServico.add(jrbPagamentoPrazo);
		
		jbgFormaPagamento = new ButtonGroup();
		jbgFormaPagamento.add(jrbPagamentoPrazo);
		jbgFormaPagamento.add(jrbPagamentoVista);
		
		jlbDataServico = new JLabel("Data do Serviço");
		jlbDataServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataServico.setBounds(261, 340, 130, 14);
		jpnDadosOrdemServico.add(jlbDataServico);
		
		jdtcDataAgendamento = new JDateChooser();
		jdtcDataAgendamento.setBounds(261, 354, 130, 20);
		jpnDadosOrdemServico.add(jdtcDataAgendamento);
		
		jpnCadastroServico = new JPanel();
		jtbOrdemServico.addTab("Cadastro de Servi\u00E7os", null, jpnCadastroServico, null);
		jpnCadastroServico.setLayout(null);
		
		colunas = new Vector<String>();
		colunas.add("Código");
		colunas.add("Descrição");
		colunas.add("Quantidade");
		colunas.add("Valor Unitário");
		colunas.add("Valor Total");
		dtmGridItensServico = new DefaultTableModel();
		dtmGridItensServico.setColumnIdentifiers(colunas);
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
		jspGridItensServico.setBounds(10, 10, 616, 200);
		
		jlbDescricao = new JLabel("Descrição");
		jlbDescricao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDescricao.setBounds(155, 221, 135, 14);
		jpnCadastroServico.add(jlbDescricao);
		
		jtfDescricao = new JTextField();
		jtfDescricao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfDescricao.setColumns(10);
		jtfDescricao.setBounds(155, 238, 324, 20);
		jpnCadastroServico.add(jtfDescricao);
		
		jtfCodigoTipoServico = new JTextField();
		jtfCodigoTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoTipoServico.setColumns(10);
		jtfCodigoTipoServico.setBounds(10, 238, 135, 20);
		jpnCadastroServico.add(jtfCodigoTipoServico);
		
		JLabel jlbCodigoTipoServico = new JLabel("C\u00F3digo Tipo de Servi\u00E7o");
		jlbCodigoTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoTipoServico.setBounds(10, 221, 135, 14);
		jpnCadastroServico.add(jlbCodigoTipoServico);
		
		jtfQuantidade = new JTextField();
		jtfQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfQuantidade.setColumns(10);
		jtfQuantidade.setBounds(10, 286, 70, 20);
		jpnCadastroServico.add(jtfQuantidade);
		
		JLabel jlbQuantidade = new JLabel("Quantidade");
		jlbQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbQuantidade.setBounds(10, 269, 70, 14);
		jpnCadastroServico.add(jlbQuantidade);
		
		jtfValorUnitario = new JTextField();
		jtfValorUnitario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfValorUnitario.setColumns(10);
		jtfValorUnitario.setBounds(155, 286, 135, 20);
		jpnCadastroServico.add(jtfValorUnitario);
		
		JLabel jlbValorUnitario = new JLabel("Valor Unit\u00E1rio");
		jlbValorUnitario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbValorUnitario.setBounds(155, 269, 106, 14);
		jpnCadastroServico.add(jlbValorUnitario);
		
		jtfValorTotalItemServico = new JTextField();
		jtfValorTotalItemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfValorTotalItemServico.setColumns(10);
		jtfValorTotalItemServico.setBounds(344, 286, 135, 20);
		jpnCadastroServico.add(jtfValorTotalItemServico);
		
		jlbValorTotalItemServico = new JLabel("Valor Total");
		jlbValorTotalItemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbValorTotalItemServico.setBounds(344, 269, 106, 14);
		jpnCadastroServico.add(jlbValorTotalItemServico);
		
		jbtNovoItemServico = new JButton("Novo");
		jbtNovoItemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovoItemServico.setBounds(10, 382, 110, 23);
		jpnCadastroServico.add(jbtNovoItemServico);
		
		jbtEditarItemServico = new JButton("Editar");
		jbtEditarItemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditarItemServico.setBounds(138, 382, 110, 23);
		jpnCadastroServico.add(jbtEditarItemServico);
		
		jbtSalvarItemServico = new JButton("Salvar");
		jbtSalvarItemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvarItemServico.setBounds(265, 382, 110, 23);
		jpnCadastroServico.add(jbtSalvarItemServico);
		
		jbtCancelarItemServico = new JButton("Cancelar");
		jbtCancelarItemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelarItemServico.setBounds(390, 382, 110, 23);
		jpnCadastroServico.add(jbtCancelarItemServico);
		
		jpnObservacaoServico = new JPanel();
		jpnObservacaoServico.setBounds(10, 317, 616, 54);
		jpnCadastroServico.add(jpnObservacaoServico);
		jpnObservacaoServico.setLayout(null);
		
		jspObservacaoServico = new JScrollPane();
		jspObservacaoServico.setBounds(0, 0, 616, 54);
		jpnObservacaoServico.add(jspObservacaoServico);
		
		jtaObservacaoServico = new JTextArea();
		jspObservacaoServico.setViewportView(jtaObservacaoServico);
	}
	
	public OrdemServicoTela() {
		setTitle("Ordem de Servi\u00E7o | WashCar");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 673, 501);
		jpnOrdemServico = new JPanel();
		jpnOrdemServico.setLayout(null);
		setLocationRelativeTo(null);
		setContentPane(jpnOrdemServico);
				
		componentesTelaOrdemServico();
		
	}
}