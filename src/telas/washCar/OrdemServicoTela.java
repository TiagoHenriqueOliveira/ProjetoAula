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
	private Vector<String> colunasGridItensServico;
	private JScrollPane jspGridItensServico;

	public void componentesTelaOrdemServico() {
		
		jtbOrdemServico = new JTabbedPane(JTabbedPane.TOP);
		jtbOrdemServico.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jtbOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtbOrdemServico.setToolTipText("");
		jtbOrdemServico.setBounds(10, 11, 647, 423);
		jpnOrdemServico.add(jtbOrdemServico);
		
		jpnDadosOrdemServico = new JPanel();
		jtbOrdemServico.addTab("Cadastro da Ordem de Servi\u00E7o", null, jpnDadosOrdemServico, null);
		jpnDadosOrdemServico.setLayout(null);
		
		jpnPesquisaOrdemServico = new JPanel();
		jpnPesquisaOrdemServico.setLayout(null);
		jpnPesquisaOrdemServico.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnPesquisaOrdemServico.setBounds(10, 11, 615, 55);
		jpnDadosOrdemServico.add(jpnPesquisaOrdemServico);
		
		jlbPesquisaCodigoOrdemServico = new JLabel("C\u00F3digo");
		jlbPesquisaCodigoOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaCodigoOrdemServico.setBounds(10, 11, 46, 14);
		jpnPesquisaOrdemServico.add(jlbPesquisaCodigoOrdemServico);
		
		jtfPesquisaCodigoOrdemServico = new JTextField();
		jtfPesquisaCodigoOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaCodigoOrdemServico.setColumns(10);
		jtfPesquisaCodigoOrdemServico.setBounds(10, 27, 66, 20);
		jpnPesquisaOrdemServico.add(jtfPesquisaCodigoOrdemServico);
		
		jlbPesquisaNomeClienteOrdemServico = new JLabel("Nome do Cliente");
		jlbPesquisaNomeClienteOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaNomeClienteOrdemServico.setBounds(86, 11, 100, 14);
		jpnPesquisaOrdemServico.add(jlbPesquisaNomeClienteOrdemServico);
		
		jtfPesquisaNomeClienteOrdemServico = new JTextField();
		jtfPesquisaNomeClienteOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaNomeClienteOrdemServico.setColumns(10);
		jtfPesquisaNomeClienteOrdemServico.setBounds(86, 27, 275, 20);
		jpnPesquisaOrdemServico.add(jtfPesquisaNomeClienteOrdemServico);
		
		jbtPesquisaOrdemServico = new JButton("");
		jbtPesquisaOrdemServico.setIcon(new ImageIcon(OrdemServicoTela.class.getResource("/Imagens/lupaPesquisa.jpeg")));
		jbtPesquisaOrdemServico.setBounds(565, 15, 40, 32);
		jpnPesquisaOrdemServico.add(jbtPesquisaOrdemServico);
		
		jtfPesquisaPlacaCarroOrdemServico = new JTextField();
		jtfPesquisaPlacaCarroOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaPlacaCarroOrdemServico.setColumns(10);
		jtfPesquisaPlacaCarroOrdemServico.setBounds(371, 27, 165, 20);
		jpnPesquisaOrdemServico.add(jtfPesquisaPlacaCarroOrdemServico);
		
		jlbPesquisaPlacaCarroOrdemServico = new JLabel("Placa do Carro");
		jlbPesquisaPlacaCarroOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaPlacaCarroOrdemServico.setBounds(371, 11, 100, 14);
		jpnPesquisaOrdemServico.add(jlbPesquisaPlacaCarroOrdemServico);
		
		jlbCodigo = new JLabel("C\u00F3digo");
		jlbCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigo.setBounds(10, 77, 46, 14);
		jpnDadosOrdemServico.add(jlbCodigo);
		
		jtfCodigo = new JTextField();
		jtfCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigo.setEditable(false);
		jtfCodigo.setColumns(10);
		jtfCodigo.setBackground(Color.YELLOW);
		jtfCodigo.setBounds(10, 93, 66, 20);
		jpnDadosOrdemServico.add(jtfCodigo);
		
		jlbDataAlteracao = new JLabel("Data Alteracao");
		jlbDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataAlteracao.setBounds(495, 77, 130, 14);
		jpnDadosOrdemServico.add(jlbDataAlteracao);
		
		jtfDataAlteracao = new JTextField();
		jtfDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfDataAlteracao.setEditable(false);
		jtfDataAlteracao.setColumns(10);
		jtfDataAlteracao.setBackground(Color.YELLOW);
		jtfDataAlteracao.setBounds(495, 93, 130, 20);
		jpnDadosOrdemServico.add(jtfDataAlteracao);
		
		jlbNomeCliente = new JLabel("Nome do Cliente");
		jlbNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeCliente.setBounds(10, 124, 150, 14);
		jpnDadosOrdemServico.add(jlbNomeCliente);
		
		jtfNomeCliente = new JTextField();
		jtfNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeCliente.setColumns(10);
		jtfNomeCliente.setBounds(10, 140, 381, 20);
		jpnDadosOrdemServico.add(jtfNomeCliente);
		
		jlbCpf = new JLabel("CPF");
		jlbCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCpf.setBounds(460, 124, 100, 14);
		jpnDadosOrdemServico.add(jlbCpf);
		
		jtfCpf = new JTextField();
		jtfCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCpf.setColumns(10);
		jtfCpf.setBounds(460, 140, 165, 20);
		jpnDadosOrdemServico.add(jtfCpf);
		
		jlbRazaoSocial = new JLabel("Raz\u00E3o Social");
		jlbRazaoSocial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbRazaoSocial.setBounds(10, 171, 150, 14);
		jpnDadosOrdemServico.add(jlbRazaoSocial);
		
		jtfRazaoSocial = new JTextField();
		jtfRazaoSocial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfRazaoSocial.setColumns(10);
		jtfRazaoSocial.setBounds(10, 187, 381, 20);
		jpnDadosOrdemServico.add(jtfRazaoSocial);
		
		jlbCnpj = new JLabel("CNPJ");
		jlbCnpj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCnpj.setBounds(460, 171, 100, 14);
		jpnDadosOrdemServico.add(jlbCnpj);
		
		jtfCnpj = new JTextField();
		jtfCnpj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCnpj.setColumns(10);
		jtfCnpj.setBounds(460, 187, 165, 20);
		jpnDadosOrdemServico.add(jtfCnpj);
		
		jlbNomeCarro = new JLabel("Nome do Carro");
		jlbNomeCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeCarro.setBounds(10, 218, 150, 14);
		jpnDadosOrdemServico.add(jlbNomeCarro);
		
		jtfNomeCarro = new JTextField();
		jtfNomeCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeCarro.setColumns(10);
		jtfNomeCarro.setBounds(10, 234, 265, 20);
		jpnDadosOrdemServico.add(jtfNomeCarro);
		
		jlbModelo = new JLabel("Modelo do Carro");
		jlbModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbModelo.setBounds(10, 265, 150, 14);
		jpnDadosOrdemServico.add(jlbModelo);
		
		jtfModelo = new JTextField();
		jtfModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfModelo.setColumns(10);
		jtfModelo.setBounds(10, 281, 165, 20);
		jpnDadosOrdemServico.add(jtfModelo);
		
		jtfPlaca = new JTextField();
		jtfPlaca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPlaca.setColumns(10);
		jtfPlaca.setBounds(185, 281, 165, 20);
		jpnDadosOrdemServico.add(jtfPlaca);
		
		jlbPlaca = new JLabel("Placa do Carro");
		jlbPlaca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPlaca.setBounds(185, 265, 100, 14);
		jpnDadosOrdemServico.add(jlbPlaca);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 354, 110, 23);
		jpnDadosOrdemServico.add(jbtNovo);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setBounds(138, 354, 110, 23);
		jpnDadosOrdemServico.add(jbtEditar);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(265, 354, 110, 23);
		jpnDadosOrdemServico.add(jbtSalvar);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setBounds(515, 354, 110, 23);
		jpnDadosOrdemServico.add(jbtFechar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setBounds(390, 354, 110, 23);
		jpnDadosOrdemServico.add(jbtCancelar);
		
		jckbOrdemServicoCancelada = new JCheckBox("Cancelada");
		jckbOrdemServicoCancelada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jckbOrdemServicoCancelada.setBounds(346, 92, 97, 23);
		jpnDadosOrdemServico.add(jckbOrdemServicoCancelada);
		
		jlbFormaPagamento = new JLabel("Forma de Pagamento");
		jlbFormaPagamento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbFormaPagamento.setBounds(124, 77, 130, 14);
		jpnDadosOrdemServico.add(jlbFormaPagamento);
		
		jlbTelefoneComercial = new JLabel("Telefone Comercial");
		jlbTelefoneComercial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneComercial.setBounds(495, 218, 130, 14);
		jpnDadosOrdemServico.add(jlbTelefoneComercial);
		
		jtfTelefoneComercial = new JTextField();
		jtfTelefoneComercial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneComercial.setColumns(10);
		jtfTelefoneComercial.setBounds(495, 234, 130, 20);
		jpnDadosOrdemServico.add(jtfTelefoneComercial);
		
		jlbTelefoneResidencial = new JLabel("Telefone Residencial");
		jlbTelefoneResidencial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneResidencial.setBounds(495, 263, 130, 14);
		jpnDadosOrdemServico.add(jlbTelefoneResidencial);
		
		jtfTelefoneResidencial = new JTextField();
		jtfTelefoneResidencial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneResidencial.setColumns(10);
		jtfTelefoneResidencial.setBounds(495, 278, 130, 20);
		jpnDadosOrdemServico.add(jtfTelefoneResidencial);
		
		jlbTelefoneCelular = new JLabel("Telefone Celular");
		jlbTelefoneCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneCelular.setBounds(495, 307, 130, 14);
		jpnDadosOrdemServico.add(jlbTelefoneCelular);
		
		jtfTelefoneCelular = new JTextField();
		jtfTelefoneCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneCelular.setColumns(10);
		jtfTelefoneCelular.setBounds(495, 323, 130, 20);
		jpnDadosOrdemServico.add(jtfTelefoneCelular);
		
		jtfValorTotal = new JTextField();
		jtfValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfValorTotal.setEditable(false);
		jtfValorTotal.setColumns(10);
		jtfValorTotal.setBackground(Color.YELLOW);
		jtfValorTotal.setBounds(10, 323, 130, 20);
		jpnDadosOrdemServico.add(jtfValorTotal);
		
		jlbValorTotal = new JLabel("Valor Total");
		jlbValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbValorTotal.setBounds(10, 307, 130, 14);
		jpnDadosOrdemServico.add(jlbValorTotal);
		
		jrbPagamentoVista = new JRadioButton("\u00C0 Vista");
		jrbPagamentoVista.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jrbPagamentoVista.setBounds(124, 92, 109, 23);
		jpnDadosOrdemServico.add(jrbPagamentoVista);
		
		jrbPagamentoPrazo = new JRadioButton("\u00C0 Prazo");
		jrbPagamentoPrazo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jrbPagamentoPrazo.setBounds(241, 92, 109, 23);
		jpnDadosOrdemServico.add(jrbPagamentoPrazo);
		
		jbgFormaPagamento = new ButtonGroup();
		jbgFormaPagamento.add(jrbPagamentoPrazo);
		jbgFormaPagamento.add(jrbPagamentoVista);
		
		jpnCadastroServico = new JPanel();
		jtbOrdemServico.addTab("Cadastro de Servi\u00E7os", null, jpnCadastroServico, null);
		jpnCadastroServico.setLayout(null);
		
		dtmGridItensServico = new DefaultTableModel();
		colunasGridItensServico = new Vector<String>();
		colunasGridItensServico.add("Código");
		colunasGridItensServico.add("Descrição");
		colunasGridItensServico.add("Valor Unitário");
		dtmGridItensServico.setColumnIdentifiers(colunasGridItensServico);
				
		jttGridItensServico = new JTable();
		jttGridItensServico.setBounds(10, 10, 200, 200);
		jttGridItensServico.setModel(dtmGridItensServico);
		getContentPane().add(jttGridItensServico);
	}
	
	public static void main(String[] args) {
		OrdemServicoTela teste = new OrdemServicoTela();
		teste.setVisible(true);
	}

	public OrdemServicoTela() {
		setTitle("Ordem de Servi\u00E7o | WashCar");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 673, 466);
		jpnOrdemServico = new JPanel();
		jpnOrdemServico.setLayout(null);
		setLocationRelativeTo(null);
		setContentPane(jpnOrdemServico);
				
		componentesTelaOrdemServico();
		
	}
}