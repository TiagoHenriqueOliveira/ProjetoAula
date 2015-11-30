package forms.WashCar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.text.MaskFormatter;

import conexao.ConexaoUtil;
import daoFactory.WashCar.DaoFactory;
import exception.WashCar.RegistroExistente;
import exception.WashCar.RegistroNotExistente;
import model.WashCar.Carro;
import model.WashCar.Cliente;
import model.WashCar.Entidade;
import model.WashCar.OrdemServico;
import preencherDados.WashCar.PreencherDados;
import relatorio.RelatorioUtil;
import validacaoCampos.WashCar.ValidaCampoAlfaNumerico;
import validacaoCampos.WashCar.ValidaCampoNumeroInteiro;

public class OrdemServicoForm extends JFrame implements PreencherDados {

	private static final long serialVersionUID = 1L;
	private JPanel jpnOrdemServico;
	private JPanel jpnPesquisaOrdemServico;
	private JLabel jlbConsultaOrdensServico;
	private JLabel jlbPesquisaCodigoOSV;
	private JLabel jlbPesquisaPlaca;
	private JLabel jlbPesquisaNomeClienteOSV;
	private JLabel jlbDataAgendamento;
	private JLabel jlbDataAlteracao;
	private JLabel jlbCodigoOSV;
	private JLabel jlbStatusOSV;
	private JLabel jlbTelefoneCelular;
	private JLabel jlbTelefoneComercial;
	private JLabel jlbTelefoneResidencial;
	private JLabel jlbCodigoCliente;
	private JLabel jlbCNPJCliente;
	private JLabel jlbCPFCliente;
	private JLabel jlbNomeCliente;
	private JLabel jlbPlacaCarro;
	private JLabel jlbNomeCarro;
	private JLabel jlbCodigoCarro;
	private JTextField jtfPesquisaCodigoOSV;
	private JTextField jtfPesquisaNomeClienteOSV;
	private JTextField jtfCodigoCliente;
	private JTextField jtfTelefoneComercial;
	private JTextField jtfTelefoneResidencial;
	private JTextField jtfTelefoneCelular;
	private JTextField jtfCodigoOSV;
	private JTextField jtfNomeCliente;
	private JTextField jtfCodigoCarro;
	private JTextField jtfNomeCarro;
	private JFormattedTextField jftfPesquisaPlaca;
	private JFormattedTextField jftfDataAgendamento;
	private JFormattedTextField jftfDataAlteracao;
	private JFormattedTextField jftfCPFCliente;
	private JFormattedTextField jftfCNPJCliente;
	private JFormattedTextField jftfPlacaCarro;
	private JComboBox<String> jcbxStatusOSV;
	private JButton jbtNovo;
	private JButton jbtSalvar;
	private JButton jbtEditar;
	private JButton jbtCancelar;
	private JButton jbtFechar;
	private JButton jbtInserirServicos;
	private JButton jbtRelatorioPadrao;
	private static OrdemServicoForm ordemServicoForm;
	private OrdemServico ordemServico;
	private ListaOrdemServicoForm listaOrdemServico = new ListaOrdemServicoForm(null, null, null, null);
	private ListaCarroForm listaCarro = new ListaCarroForm(null, null, null, null);
	
	public void componentesOrdemServicoForm() {
		jpnOrdemServico = new JPanel();
		jpnOrdemServico.setLayout(null);
		setContentPane(jpnOrdemServico);
		
		jpnPesquisaOrdemServico = new JPanel();
		jpnPesquisaOrdemServico.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnPesquisaOrdemServico.setBounds(10, 11, 812, 85);
		jpnOrdemServico.add(jpnPesquisaOrdemServico);
		jpnPesquisaOrdemServico.setLayout(null);
		
		jlbConsultaOrdensServico = new JLabel("Consulta de Ordens de Serviço");
		jlbConsultaOrdensServico.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbConsultaOrdensServico.setBounds(10, 11, 350, 15);
		jpnPesquisaOrdemServico.add(jlbConsultaOrdensServico);
		
		jlbPesquisaCodigoOSV = new JLabel("Cód. OSV");
		jlbPesquisaCodigoOSV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaCodigoOSV.setBounds(10, 37, 70, 14);
		jpnPesquisaOrdemServico.add(jlbPesquisaCodigoOSV);
		
		jtfPesquisaCodigoOSV = new JTextField();
		jtfPesquisaCodigoOSV.setDocument(new ValidaCampoNumeroInteiro());
		jtfPesquisaCodigoOSV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaCodigoOSV.setBounds(10, 52, 50, 20);
		jpnPesquisaOrdemServico.add(jtfPesquisaCodigoOSV);
		jtfPesquisaCodigoOSV.setColumns(10);
		
		jtfPesquisaNomeClienteOSV = new JTextField();
		jtfPesquisaNomeClienteOSV.setDocument(new ValidaCampoAlfaNumerico());
		jtfPesquisaNomeClienteOSV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaNomeClienteOSV.setColumns(10);
		jtfPesquisaNomeClienteOSV.setBounds(90, 52, 275, 20);
		jpnPesquisaOrdemServico.add(jtfPesquisaNomeClienteOSV);
		
		jlbPesquisaNomeClienteOSV = new JLabel("Nome do Cliente");
		jlbPesquisaNomeClienteOSV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaNomeClienteOSV.setBounds(90, 37, 275, 14);
		jpnPesquisaOrdemServico.add(jlbPesquisaNomeClienteOSV);
		
		jlbPesquisaPlaca = new JLabel("Placa do Carro");
		jlbPesquisaPlaca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaPlaca.setBounds(375, 37, 150, 14);
		jpnPesquisaOrdemServico.add(jlbPesquisaPlaca);
		
		try {
			jftfPesquisaPlaca = new JFormattedTextField(new MaskFormatter("UUU-####"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jftfPesquisaPlaca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jftfPesquisaPlaca.setBounds(375, 52, 75, 20);
		jpnPesquisaOrdemServico.add(jftfPesquisaPlaca);
		
		jlbCodigoOSV = new JLabel("C\u00F3d. OSV");
		jlbCodigoOSV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoOSV.setBounds(10, 107, 70, 14);
		jpnOrdemServico.add(jlbCodigoOSV);
		
		jtfCodigoOSV = new JTextField();
		jtfCodigoOSV.setEditable(false);
		jtfCodigoOSV.setBackground(Color.YELLOW);
		jtfCodigoOSV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoOSV.setColumns(10);
		jtfCodigoOSV.setBounds(10, 122, 50, 20);
		jpnOrdemServico.add(jtfCodigoOSV);
		
		jlbDataAgendamento = new JLabel("Data Agendamento");
		jlbDataAgendamento.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbDataAgendamento.setBounds(240, 107, 160, 14);
		jpnOrdemServico.add(jlbDataAgendamento);
		
		try {
			jftfDataAgendamento = new JFormattedTextField(new MaskFormatter("##/##/####"));
			jftfDataAgendamento.setEditable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jftfDataAgendamento.setHorizontalAlignment(SwingConstants.RIGHT);
		jftfDataAgendamento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jftfDataAgendamento.setBounds(240, 122, 75, 20);
		jpnOrdemServico.add(jftfDataAgendamento);
		
		jcbxStatusOSV = new JComboBox<String>();
		jcbxStatusOSV.setEnabled(false);
		jcbxStatusOSV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jcbxStatusOSV.setBounds(400, 122, 120, 20);
		jcbxStatusOSV.addItem("Em Aberto");
		jcbxStatusOSV.addItem("Confirmada");
		jcbxStatusOSV.addItem("Cancelada");
		jpnOrdemServico.add(jcbxStatusOSV);
		
		jlbStatusOSV = new JLabel("Status da OSV");
		jlbStatusOSV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbStatusOSV.setBounds(400, 107, 150, 14);
		jpnOrdemServico.add(jlbStatusOSV);
		
		try {
			jftfDataAlteracao = new JFormattedTextField(new MaskFormatter("##/##/####"));
			jftfDataAlteracao.setEditable(false);
			jftfDataAlteracao.setBackground(Color.YELLOW);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jftfDataAlteracao.setHorizontalAlignment(SwingConstants.RIGHT);
		jftfDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jftfDataAlteracao.setBounds(706, 296, 75, 20);
		jpnOrdemServico.add(jftfDataAlteracao);
		
		jlbDataAlteracao = new JLabel("Data Altera\u00E7\u00E3o");
		jlbDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataAlteracao.setBounds(706, 281, 150, 14);
		jpnOrdemServico.add(jlbDataAlteracao);
		
		jlbCodigoCliente = new JLabel("C\u00F3d. Cliente");
		jlbCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoCliente.setBounds(10, 153, 100, 14);
		jpnOrdemServico.add(jlbCodigoCliente);
		
		jtfCodigoCliente = new JTextField();
		jtfCodigoCliente.setEditable(false);
		jtfCodigoCliente.setBackground(Color.YELLOW);
		jtfCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoCliente.setColumns(10);
		jtfCodigoCliente.setBounds(10, 168, 50, 20);
		jpnOrdemServico.add(jtfCodigoCliente);
		
		jlbTelefoneComercial = new JLabel("Telefone Comercial");
		jlbTelefoneComercial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneComercial.setBounds(110, 153, 130, 14);
		jpnOrdemServico.add(jlbTelefoneComercial);
		
		jtfTelefoneComercial = new JTextField();
		jtfTelefoneComercial.setEditable(false);
		jtfTelefoneComercial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneComercial.setColumns(10);
		jtfTelefoneComercial.setBounds(110, 168, 130, 20);
		jpnOrdemServico.add(jtfTelefoneComercial);

		jlbTelefoneResidencial = new JLabel("Telefone Residencial");
		jlbTelefoneResidencial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneResidencial.setBounds(250, 153, 130, 14);
		jpnOrdemServico.add(jlbTelefoneResidencial);
		
		jtfTelefoneResidencial = new JTextField();
		jtfTelefoneResidencial.setEditable(false);
		jtfTelefoneResidencial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneResidencial.setColumns(10);
		jtfTelefoneResidencial.setBounds(250, 168, 130, 20);
		jpnOrdemServico.add(jtfTelefoneResidencial);
		
		jlbTelefoneCelular = new JLabel("Telefone Celular");
		jlbTelefoneCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneCelular.setBounds(390, 153, 130, 14);
		jpnOrdemServico.add(jlbTelefoneCelular);
		
		jtfTelefoneCelular = new JTextField();
		jtfTelefoneCelular.setEditable(false);
		jtfTelefoneCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneCelular.setColumns(10);
		jtfTelefoneCelular.setBounds(390, 168, 130, 20);
		jpnOrdemServico.add(jtfTelefoneCelular);
		
		jlbNomeCliente = new JLabel("Nome do Cliente");
		jlbNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeCliente.setBounds(10, 199, 200, 14);
		jpnOrdemServico.add(jlbNomeCliente);
		
		jtfNomeCliente = new JTextField();
		jtfNomeCliente.setEditable(false);
		jtfNomeCliente.setDocument(new ValidaCampoAlfaNumerico());
		jtfNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeCliente.setColumns(10);
		jtfNomeCliente.setBounds(10, 214, 300, 20);
		jpnOrdemServico.add(jtfNomeCliente);
		
		jlbCPFCliente = new JLabel("CPF");
		jlbCPFCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCPFCliente.setBounds(320, 199, 75, 14);
		jpnOrdemServico.add(jlbCPFCliente);
		
		try {
			jftfCPFCliente = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			jftfCPFCliente.setEditable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jftfCPFCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jftfCPFCliente.setBounds(320, 214, 100, 20);
		jpnOrdemServico.add(jftfCPFCliente);
		
		jlbCNPJCliente = new JLabel("CNPJ");
		jlbCNPJCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCNPJCliente.setBounds(430, 199, 75, 14);
		jpnOrdemServico.add(jlbCNPJCliente);
		
		try {
			jftfCNPJCliente = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
			jftfCNPJCliente.setEditable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jftfCNPJCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jftfCNPJCliente.setBounds(430, 214, 125, 20);
		jpnOrdemServico.add(jftfCNPJCliente);
		
		jlbCodigoCarro = new JLabel("C\u00F3d. Carro");
		jlbCodigoCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoCarro.setBounds(10, 245, 70, 14);
		jpnOrdemServico.add(jlbCodigoCarro);
		
		jtfCodigoCarro = new JTextField();
		jtfCodigoCarro.setEditable(false);
		jtfCodigoCarro.setBackground(Color.YELLOW);
		jtfCodigoCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoCarro.setColumns(10);
		jtfCodigoCarro.setBounds(10, 260, 50, 20);
		jpnOrdemServico.add(jtfCodigoCarro);
		
		jlbNomeCarro = new JLabel("Nome do Carro");
		jlbNomeCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeCarro.setBounds(90, 245, 170, 14);
		jpnOrdemServico.add(jlbNomeCarro);
		
		jtfNomeCarro = new JTextField();
		jtfNomeCarro.setEditable(false);
		jtfNomeCarro.setDocument(new ValidaCampoAlfaNumerico());
		jtfNomeCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeCarro.setColumns(10);
		jtfNomeCarro.setBounds(90, 260, 310, 20);
		jpnOrdemServico.add(jtfNomeCarro);
		
		jlbPlacaCarro = new JLabel("Placa do Carro");
		jlbPlacaCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPlacaCarro.setBounds(410, 245, 140, 14);
		jpnOrdemServico.add(jlbPlacaCarro);
		
		try {
			jftfPlacaCarro = new JFormattedTextField(new MaskFormatter("UUU-####"));
			jftfPlacaCarro.setEditable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jftfPlacaCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jftfPlacaCarro.setBounds(410, 260, 75, 20);
		jpnOrdemServico.add(jftfPlacaCarro);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setBounds(530, 291, 120, 25);
		jpnOrdemServico.add(jbtFechar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setEnabled(false);
		jbtCancelar.setBounds(400, 291, 120, 25);
		jpnOrdemServico.add(jbtCancelar);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setEnabled(false);
		jbtEditar.setBounds(271, 291, 120, 25);
		jpnOrdemServico.add(jbtEditar);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setEnabled(false);
		jbtSalvar.setBounds(140, 291, 120, 25);
		jpnOrdemServico.add(jbtSalvar);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 291, 120, 25);
		jpnOrdemServico.add(jbtNovo);
		
		jbtInserirServicos = new JButton("INSERIR SERVIÇOS");
		jbtInserirServicos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtInserirServicos.setBounds(652, 199, 170, 35);
		jpnOrdemServico.add(jbtInserirServicos);
		
		jbtRelatorioPadrao = new JButton("RELATÓRIO PADRÃO");
		jbtRelatorioPadrao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtRelatorioPadrao.setBounds(652, 153, 170, 35);
		jpnOrdemServico.add(jbtRelatorioPadrao);
	}
	
	public void acionarBotaoNovo() {
		this.selecionarStatusOSV();
		jftfDataAgendamento.requestFocus();
		jcbxStatusOSV.setSelectedIndex(0);
		jcbxStatusOSV.setEnabled(true);
		jftfDataAgendamento.setEditable(true);
		jtfNomeCarro.setEditable(true);
		jftfPlacaCarro.setEditable(true);
		jtfCodigoOSV.setText("");
		jftfDataAgendamento.setText("");
		jftfDataAlteracao.setText("");
		jtfCodigoCliente.setText("");
		jtfTelefoneComercial.setText("");
		jtfTelefoneResidencial.setText("");
		jtfTelefoneCelular.setText("");
		jtfNomeCliente.setText("");
		jftfCPFCliente.setText("");
		jftfCNPJCliente.setText("");
		jtfCodigoCarro.setText("");
		jtfNomeCarro.setText("");
		jftfPlacaCarro.setText("");
		jbtNovo.setEnabled(false);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
		jbtEditar.setEnabled(false);
	}
	
	@SuppressWarnings("static-access")
	public void salvarCadastro() throws RegistroExistente {
		if(jftfDataAgendamento.getText().equals("  /  /    ")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar uma data de agendamento do serviço!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jftfDataAgendamento.requestFocus();
		} else if(jtfCodigoCarro.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar um carro e cliente!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeCarro.requestFocus();
		} else {
			this.ordemServico = new OrdemServico();
			if(jcbxStatusOSV.getSelectedIndex() == 0) {
				this.ordemServico.setStatusOSV(1); //Status Em Aberto
			} else if(jcbxStatusOSV.getSelectedIndex() == 1) {
				this.ordemServico.setStatusOSV(2);//Status Confirmado
			} else {
				this.ordemServico.setStatusOSV(3); //Status Cancelado
			}
			String dia = jftfDataAgendamento.getText().substring(0, 2);
			String mes = jftfDataAgendamento.getText().substring(3, 5);
			String ano = jftfDataAgendamento.getText().substring(6);
			String dataAgendamento = ano + "-" + mes + "-" + dia;
 			this.ordemServico.setDataAgendamento(Date.valueOf(dataAgendamento).toLocalDate());
			this.ordemServico.setDataAlteracao(Date.valueOf(ordemServico.getDataAlteracao().now()).toLocalDate());
			this.ordemServico.setCliente(new Cliente(Integer.valueOf(jtfCodigoCliente.getText()), null, null, null, null));
			this.ordemServico.setCarro(new Carro(Integer.valueOf(jtfCodigoCarro.getText()), null, null));
			DaoFactory.getFactory().ordemServicoDao().inserir(ordemServico);
			jtfCodigoOSV.setText(String.valueOf(this.ordemServico.getIdOrdemServico()));
			jftfDataAlteracao.setText(this.ordemServico.getDataAlteracao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
			JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!!!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			jcbxStatusOSV.setEnabled(false);
			jftfDataAgendamento.setEditable(false);
			jtfNomeCliente.setEditable(false);
			jtfNomeCarro.setEditable(false);
			jftfPlacaCarro.setEditable(false);
			jbtSalvar.setEnabled(false);
			jbtEditar.setEnabled(true);
			jbtNovo.setEnabled(true);
			jbtCancelar.setEnabled(false);
		}
	}
	
	@SuppressWarnings("static-access")
	public void salvarEdicaoCadastro() throws RegistroExistente {
		if(jftfDataAgendamento.getText().equals("  /  /    ")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar uma data de agendamento do serviço!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jftfDataAgendamento.requestFocus();
		} else if(jtfCodigoCliente.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar nome do cliente!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeCliente.requestFocus();
		} else if(jtfCodigoCarro.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar nome do cliente e placa do carro!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeCarro.requestFocus();
		} else {
			this.ordemServico = new OrdemServico();
			if(jcbxStatusOSV.getSelectedIndex() == 0) {
				this.ordemServico.setStatusOSV(1); //Status Em Aberto
			} else if(jcbxStatusOSV.getSelectedIndex() == 1) {
				this.ordemServico.setStatusOSV(2);//Status Confirmado
			} else {
				this.ordemServico.setStatusOSV(3); //Status Cancelado
			}
			String dia = jftfDataAgendamento.getText().substring(0, 2);
			String mes = jftfDataAgendamento.getText().substring(3, 5);
			String ano = jftfDataAgendamento.getText().substring(6);
			String dataAgendamento = ano + "-" + mes + "-" + dia;
 			this.ordemServico.setDataAgendamento(Date.valueOf(dataAgendamento).toLocalDate());
			this.ordemServico.setDataAlteracao(Date.valueOf(ordemServico.getDataAlteracao().now()).toLocalDate());
			this.ordemServico.setCliente(new Cliente(Integer.valueOf(jtfCodigoCliente.getText()), null, null, null, null));
			this.ordemServico.setCarro(new Carro(Integer.valueOf(jtfCodigoCarro.getText()), null, null));
			this.ordemServico.setIdOrdemServico(Integer.valueOf(jtfCodigoOSV.getText()));
			DaoFactory.getFactory().ordemServicoDao().alterar(ordemServico);
			jftfDataAlteracao.setText(this.ordemServico.getDataAlteracao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
			JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!!!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			jcbxStatusOSV.setEnabled(false);
			jftfDataAgendamento.setEditable(false);
			jtfNomeCliente.setEditable(false);
			jtfNomeCarro.setEditable(false);
			jftfPlacaCarro.setEditable(false);
			jbtSalvar.setEnabled(false);
			jbtEditar.setEnabled(true);
			jbtNovo.setEnabled(true);
			jbtCancelar.setEnabled(false);
		}
	}
	
	public void acionarBotaoEditar() {
		this.selecionarStatusOSV();
		if(jcbxStatusOSV.getSelectedIndex() == 0) {
			jcbxStatusOSV.setEnabled(true);
			jftfDataAgendamento.requestFocus();
			jftfDataAgendamento.setEditable(true);
			jtfNomeCarro.setEditable(true);
			jftfPlacaCarro.setEditable(true);
			jbtNovo.setEnabled(false);
			jbtSalvar.setEnabled(true);
			jbtCancelar.setEnabled(true);
		} else if(jcbxStatusOSV.getSelectedIndex() ==1) {
			JOptionPane.showMessageDialog(ordemServicoForm, "A ordem de serviço está como CONFIRMADA.\n"
			+ "Não poderá ser mais alterada, somente poderá consultar as informações pelo relatório.\n"
			+ "Caso deseje alterar, favor mudar o status para EM ABERTO.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jcbxStatusOSV.setEnabled(true);
			jftfDataAgendamento.requestFocus();
			jftfDataAgendamento.setEditable(false);
			jtfNomeCarro.setEditable(false);
			jftfPlacaCarro.setEditable(false);
			jbtNovo.setEnabled(false);
			jbtSalvar.setEnabled(true);
			jbtCancelar.setEnabled(true);
		} else if(jcbxStatusOSV.getSelectedIndex() == 2) {
			JOptionPane.showMessageDialog(ordemServicoForm, "A ordem de serviço está como CANCELADA.\n"
			+ "Não poderá ser mais alterada, somente poderá consultar as informações pelo relatório.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jcbxStatusOSV.setEnabled(false);
			jftfDataAgendamento.requestFocus();
			jftfDataAgendamento.setEditable(false);
			jtfNomeCarro.setEditable(false);
			jftfPlacaCarro.setEditable(false);
			jbtNovo.setEnabled(true);
			jbtSalvar.setEnabled(false);
			jbtCancelar.setEnabled(false);
			jbtEditar.setEnabled(false);
		}
	}
	
	public void acionarBotaoCancelar() {
		jtfPesquisaCodigoOSV.requestFocus();
		jcbxStatusOSV.setSelectedIndex(0);
		jcbxStatusOSV.setEditable(false);
		jftfDataAgendamento.setEditable(false);
		jtfNomeCarro.setEditable(false);
		jftfPlacaCarro.setEditable(false);
		jtfCodigoOSV.setText("");
		jftfDataAgendamento.setText("");
		jftfDataAlteracao.setText("");
		jtfCodigoCliente.setText("");
		jtfTelefoneComercial.setText("");
		jtfTelefoneResidencial.setText("");
		jtfTelefoneCelular.setText("");
		jtfNomeCliente.setText("");
		jftfCPFCliente.setText("");
		jftfCNPJCliente.setText("");
		jtfCodigoCarro.setText("");
		jtfNomeCarro.setText("");
		jftfPlacaCarro.setText("");
		jbtNovo.setEnabled(true);
		jbtCancelar.setEnabled(false);
		jbtSalvar.setEnabled(false);
		jbtEditar.setEnabled(false);
	}
	
	public void acaoDosBotoes() {
		jbtNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtNovo) {
					acionarBotaoNovo();
				}
			}
		});
		
		jbtSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtSalvar) {
					if (jbtSalvar.isEnabled() && jbtEditar.isEnabled()) {
						try {
							salvarEdicaoCadastro();
						} catch (RegistroExistente edicao) {
							edicao.printStackTrace();
						} 
					} else {
						try {
							salvarCadastro();
						} catch (RegistroExistente salvar) {
							salvar.printStackTrace();
						}
					}
				}
			}
		});
		
		jbtEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtEditar) {
					acionarBotaoEditar();
				}
			}
		});
		
		jbtCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtCancelar) {
					acionarBotaoCancelar();
				}
			}
		});
		
		jbtFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtFechar) {
					if(jtfCodigoOSV.getText() == null || jtfCodigoOSV.getText().equals("")) {
						Integer valor = JOptionPane.showConfirmDialog(null, "Você NÃO concluiu o cadastro.\n"
								+ "Deseja realmente fechar sem concluir o cadastro?\n"
								+ "SIM - Cadastro da Ordem de Serviço será cancelado!\n"
								+ "NÃO - Por gentileza, conclua o cadastro da Ordem de Serviço!", "Atenção", JOptionPane.YES_NO_OPTION);
						if(valor == 0) {
							dispose();
						}
					} else {
						dispose();
					}
				}
			}
		});
		
		jbtRelatorioPadrao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtRelatorioPadrao) {
					if(jtfCodigoOSV.getText() == null || jtfCodigoOSV.getText().equals("")) {
						JOptionPane.showMessageDialog(ordemServicoForm, "Não é possível gerar o relatório, pois não há nenhuma\n"
						+ "ordem de serviço selecionada.\nPor gentileza, selecione uma ordem de serviço.", "Aviso", JOptionPane.WARNING_MESSAGE);
						jtfPesquisaCodigoOSV.requestFocus();
					} else {
						Map<String, Object> parametros = new HashMap<String, Object>();
						parametros.put("idOrdemServico", Integer.valueOf(jtfCodigoOSV.getText()));
						new RelatorioUtil().viewReport("src/relatorio/OrdemServicoPadrao.jasper", ConexaoUtil.openConnection(), parametros);
					}
				}
			}
		});
		
		jbtInserirServicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtInserirServicos) {
					if(jtfCodigoOSV == null || jtfCodigoOSV.getText().equals("")) {
						JOptionPane.showMessageDialog(ordemServicoForm, "O cadastro da Ordem de Serviço não foi concluído!\n"
						+ "Por gentileza, conclua o cadastro antes de inserir os Serviços.", "Atenção", JOptionPane.WARNING_MESSAGE);
						jftfDataAgendamento.requestFocus();
					} else if(jcbxStatusOSV.getSelectedIndex() == 2) {
						JOptionPane.showMessageDialog(ordemServicoForm, "A ordem de serviço está cancelada.\n"
						+ "Não poderá ser mais alterada, somente poderá consultar as informações pelo relatório.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
						jtfPesquisaCodigoOSV.requestFocus();
					} else if(jcbxStatusOSV.getSelectedIndex() == 1) {
						JOptionPane.showMessageDialog(ordemServicoForm, "A ordem de serviço está como CONFIRMADA.\n"
						+ "Não poderá ser mais alterada, somente poderá consultar as informações pelo relatório.\n"
						+ "Caso deseje alterar, favor mudar o status para EM ABERTO.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
						jcbxStatusOSV.requestFocus();
					} else {
						ItemOrdemServicoForm itemOrdemServico = new ItemOrdemServicoForm(ordemServicoForm, Integer.valueOf(jtfCodigoOSV.getText()));
						itemOrdemServico.setVisible(true);
					}
				}
			}
		});
	}
	
	public void selecionarStatusOSV() {
		jcbxStatusOSV.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if((e.getSource() == jcbxStatusOSV) && (e.getStateChange() == ItemEvent.SELECTED)) {
					if(jcbxStatusOSV.getSelectedIndex() == 0) {
						jftfDataAgendamento.setEditable(true);
						jtfNomeCarro.setEditable(true);
						jftfPlacaCarro.setEditable(true);
						jbtInserirServicos.setEnabled(true);
					} else if(jcbxStatusOSV.getSelectedIndex() == 1) {
						jftfDataAgendamento.setEditable(false);
						jtfNomeCarro.setEditable(false);
						jftfPlacaCarro.setEditable(false);
					} else if(jcbxStatusOSV.getSelectedIndex() == 2) {
						jftfDataAgendamento.setEditable(false);
						jtfNomeCarro.setEditable(false);
						jftfPlacaCarro.setEditable(false);
						jbtInserirServicos.setEnabled(false);
					}
				}
			}
		});
	}
	
	public void peencherCamposOrdemServico(OrdemServico ordemServico) {
		jtfCodigoOSV.setText(String.valueOf(ordemServico.getIdOrdemServico()));
		jftfDataAgendamento.setText(ordemServico.getDataAgendamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
		jftfDataAlteracao.setText(ordemServico.getDataAlteracao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
		if(ordemServico.getStatusOSV() == 1) {
			jcbxStatusOSV.setSelectedIndex(0);
		} else if(ordemServico.getStatusOSV() == 2) {
			jcbxStatusOSV.setSelectedIndex(1);
		} else if(ordemServico.getStatusOSV() == 3) {
			jcbxStatusOSV.setSelectedIndex(2);
		}
		if(ordemServico.getCliente().getTipoPessoa() == 1) {
			jtfCodigoCliente.setText(String.valueOf(ordemServico.getCliente().getIdCliente()));
			jtfNomeCliente.setText(ordemServico.getCliente().getPessoaFisica().getNome());
			jftfCPFCliente.setText(ordemServico.getCliente().getPessoaFisica().getCpf());
		} else {
			jtfCodigoCliente.setText(String.valueOf(ordemServico.getCliente().getIdCliente()));
			jtfNomeCliente.setText(ordemServico.getCliente().getPessoaJuridica().getNomeFantasia());
			jftfCNPJCliente.setText(ordemServico.getCliente().getPessoaJuridica().getCnpj());
		}
		jtfCodigoCarro.setText(String.valueOf(ordemServico.getCarro().getIdCarro()));
		jtfNomeCarro.setText(ordemServico.getCarro().getNome());
		jftfPlacaCarro.setText(ordemServico.getCarro().getPlaca());
	}
	
	public void preencherCamposCarro(Carro carro) {
		if(carro.getCliente().getTipoPessoa() == 1) {
			if(carro.isForaUso()) {
				JOptionPane.showMessageDialog(null, "O carro selecionado está fora de uso.\n"
				+ "Por gentileza, entre em contato com o responsável!\n"
				+ "Após a confirmação o cadastro será cancelado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				this.acionarBotaoCancelar();
			} else {
				jtfCodigoCarro.setText(String.valueOf(carro.getIdCarro()));
				jtfNomeCarro.setText(carro.getNome());
				jftfPlacaCarro.setText(carro.getPlaca());
				jtfCodigoCliente.setText(String.valueOf(carro.getCliente().getIdCliente()));
				jtfNomeCliente.setText(carro.getCliente().getPessoaFisica().getNome());
				jftfCPFCliente.setText(carro.getCliente().getPessoaFisica().getCpf());
				jtfTelefoneCelular.setText(carro.getCliente().getTelefoneCelular());
				jtfTelefoneComercial.setText(carro.getCliente().getTelefoneComercial());
				jtfTelefoneResidencial.setText(carro.getCliente().getTelefoneResidencial());
			}
		} else {
			if(carro.isForaUso()) {
				JOptionPane.showMessageDialog(null, "O carro selecionado está fora de uso.\n"
				+ "Por gentileza, entre em contato com o responsável!\n"
				+ "Após a confirmação o cadastro será cancelado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				this.acionarBotaoCancelar();
			} else {
				jtfCodigoCarro.setText(String.valueOf(carro.getIdCarro()));
				jtfNomeCarro.setText(carro.getNome());
				jftfPlacaCarro.setText(carro.getPlaca());
				jtfCodigoCliente.setText(String.valueOf(carro.getCliente().getIdCliente()));
				jtfNomeCliente.setText(carro.getCliente().getPessoaJuridica().getNomeFantasia());
				jftfCNPJCliente.setText(carro.getCliente().getPessoaJuridica().getCnpj());
				jtfTelefoneCelular.setText(carro.getCliente().getTelefoneCelular());
				jtfTelefoneComercial.setText(carro.getCliente().getTelefoneComercial());
				jtfTelefoneResidencial.setText(carro.getCliente().getTelefoneResidencial());
			}
		}
	}
	
	public void pesquisaPorCodigo() {
		jtfPesquisaCodigoOSV.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						if(listaOrdemServico.isVisible()) {
							listaOrdemServico.requestFocus();
							listaOrdemServico.setLocationRelativeTo(ordemServicoForm);
						} else {
							Integer codigo = null;
							if(!jtfPesquisaCodigoOSV.getText().equals("")) {
								codigo = Integer.valueOf(jtfPesquisaCodigoOSV.getText());
							}
							listaOrdemServico = new ListaOrdemServicoForm(ordemServicoForm, null, codigo, null);
							listaOrdemServico.setVisible(true);
							jcbxStatusOSV.setEditable(false);
							jftfDataAgendamento.setEditable(false);
							jtfNomeCarro.setEditable(false);
							jftfPlacaCarro.setEditable(false);
							jtfCodigoOSV.setText("");
							jftfDataAgendamento.setText("");
							jftfDataAlteracao.setText("");
							jtfCodigoCliente.setText("");
							jtfTelefoneComercial.setText("");
							jtfTelefoneResidencial.setText("");
							jtfTelefoneCelular.setText("");
							jtfNomeCliente.setText("");
							jftfCPFCliente.setText("");
							jftfCNPJCliente.setText("");
							jtfCodigoCarro.setText("");
							jtfNomeCarro.setText("");
							jftfPlacaCarro.setText("");
							jftfPesquisaPlaca.setText("");
							jtfPesquisaNomeClienteOSV.setText("");
							jtfPesquisaCodigoOSV.setText("");
							jbtEditar.setEnabled(true);
							jbtSalvar.setEnabled(false);
							jbtCancelar.setEnabled(true);
						}
					} catch (RegistroNotExistente e) {
						JOptionPane.showMessageDialog(ordemServicoForm, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
						jtfPesquisaCodigoOSV.setText("");
					}
				}
			}
		});
	}
	
	public void pesquisaPorNome() {
		jtfPesquisaNomeClienteOSV.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						if(listaOrdemServico.isVisible()) {
							listaOrdemServico.requestFocus();
							listaOrdemServico.setLocationRelativeTo(ordemServicoForm);
						} else {
							listaOrdemServico = new ListaOrdemServicoForm(ordemServicoForm, jtfPesquisaNomeClienteOSV.getText(), null, null);
							listaOrdemServico.setVisible(true);
							jcbxStatusOSV.setEditable(false);
							jftfDataAgendamento.setEditable(false);
							jtfNomeCarro.setEditable(false);
							jftfPlacaCarro.setEditable(false);
							jtfCodigoOSV.setText("");
							jftfDataAgendamento.setText("");
							jftfDataAlteracao.setText("");
							jtfCodigoCliente.setText("");
							jtfTelefoneComercial.setText("");
							jtfTelefoneResidencial.setText("");
							jtfTelefoneCelular.setText("");
							jtfNomeCliente.setText("");
							jftfCPFCliente.setText("");
							jftfCNPJCliente.setText("");
							jtfCodigoCarro.setText("");
							jtfNomeCarro.setText("");
							jftfPlacaCarro.setText("");
							jftfPesquisaPlaca.setText("");
							jtfPesquisaNomeClienteOSV.setText("");
							jtfPesquisaCodigoOSV.setText("");
							jbtEditar.setEnabled(true);
							jbtSalvar.setEnabled(false);
							jbtCancelar.setEnabled(true);
						}
					} catch (RegistroNotExistente e) {
						JOptionPane.showMessageDialog(ordemServicoForm, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
						jtfPesquisaNomeClienteOSV.setText("");
					}
				}
			}
		});
	}
	
	public void pesquisaPorPlaca() {
		jftfPesquisaPlaca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						if(listaOrdemServico.isVisible()) {
							listaOrdemServico.requestFocus();
							listaOrdemServico.setLocationRelativeTo(ordemServicoForm);
						} else {
							listaOrdemServico = new ListaOrdemServicoForm(ordemServicoForm, null, null, jftfPesquisaPlaca.getText());
							listaOrdemServico.setVisible(true);
							jcbxStatusOSV.setEditable(false);
							jftfDataAgendamento.setEditable(false);
							jtfNomeCarro.setEditable(false);
							jftfPlacaCarro.setEditable(false);
							jtfCodigoOSV.setText("");
							jftfDataAgendamento.setText("");
							jftfDataAlteracao.setText("");
							jtfCodigoCliente.setText("");
							jtfTelefoneComercial.setText("");
							jtfTelefoneResidencial.setText("");
							jtfTelefoneCelular.setText("");
							jtfNomeCliente.setText("");
							jftfCPFCliente.setText("");
							jftfCNPJCliente.setText("");
							jtfCodigoCarro.setText("");
							jtfNomeCarro.setText("");
							jftfPlacaCarro.setText("");
							jftfPesquisaPlaca.setText("");
							jtfPesquisaNomeClienteOSV.setText("");
							jtfPesquisaCodigoOSV.setText("");
							jbtEditar.setEnabled(true);
							jbtSalvar.setEnabled(false);
							jbtCancelar.setEnabled(true);
						}
					} catch (RegistroNotExistente e) {
						JOptionPane.showMessageDialog(ordemServicoForm, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
						jftfPesquisaPlaca.setText("");
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
						if(listaCarro.isVisible()) {
							listaCarro.requestFocus();
							listaCarro.setLocationRelativeTo(ordemServicoForm);
						} else {
							listaCarro = new ListaCarroForm(ordemServicoForm, jtfNomeCarro.getText(), null, null);
							listaCarro.setVisible(true);
							jtfCodigoCarro.setText("");
							jtfNomeCarro.setText("");
							jftfPlacaCarro.setText("");
						}
					} catch (RegistroNotExistente e) {
						JOptionPane.showMessageDialog(ordemServicoForm, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
						jtfNomeCarro.setText("");
					}
				}
			}
		});
	}
	
	public void pesquisaPlacaCarro() {
		jftfPlacaCarro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						if(listaCarro.isVisible()) {
							listaCarro.requestFocus();
							listaCarro.setLocationRelativeTo(ordemServicoForm);
						} else {
							listaCarro = new ListaCarroForm(ordemServicoForm, null, null, jftfPlacaCarro.getText());
							listaCarro.setVisible(true);
							jtfCodigoCarro.setText("");
							jtfNomeCarro.setText("");
							jftfPlacaCarro.setText("");
						}
					} catch (RegistroNotExistente e) {
						JOptionPane.showMessageDialog(ordemServicoForm, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
						jftfPlacaCarro.setText("");
					}
				}
			}
		});
	}

	public OrdemServicoForm() {
		ordemServicoForm = this;
		setIconImage(Toolkit.getDefaultToolkit().getImage(OrdemServicoForm.class.getResource("/Imagens/washCar.jpeg")));
		setTitle("Cadastro de Ordem de Serviço");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 841, 355);
		setLocationRelativeTo(null);
		setResizable(false);
		
		componentesOrdemServicoForm();
		acaoDosBotoes();
		pesquisaPorCodigo();
		pesquisaPorNome();
		pesquisaPorPlaca();
		pesquisaNomeCarro();
		pesquisaPlacaCarro();
	}

	@Override
	public void preencherCampos(Entidade entidade) {
		if(entidade instanceof OrdemServico) {
			this.peencherCamposOrdemServico((OrdemServico)entidade);
		} else if(entidade instanceof Carro) {
			this.preencherCamposCarro((Carro)entidade);
		}
	}
}