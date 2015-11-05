package forms.WashCar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;

import validacaoCampos.WashCar.ValidaCampoAlfaNumerico;
import validacaoCampos.WashCar.ValidaCampoDocumentoFisico;
import validacaoCampos.WashCar.ValidaCampoNumeroInteiro;
import validacaoCampos.WashCar.ValidaCampoDocumentoJuridico;
import validacaoCampos.WashCar.ValidaCampoString;
import validacaoCampos.WashCar.ValidaCampoTelefone;

import daoFactory.WashCar.DaoFactory;
import model.WashCar.Cidade;
import model.WashCar.Cliente;
import model.WashCar.Empresa;
import model.WashCar.Entidade;
import preencherDados.WashCar.PreencherDados;

import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.format.DateTimeFormatter;
import java.awt.event.ItemEvent;

public class ClienteForm extends JFrame implements PreencherDados {

	private static final long serialVersionUID = 1L;
	private JPanel jpnCliente;
	private JPanel jpnPesquisaCliente;
	private JTextField jtfPesquisaCodigoCliente;
	private JTextField jtfPesquisaNomeCliente;
	private JTextField jtfPesquisaCnpjCliente;
	private JTextField jtfCodigoCliente;
	private JTextField jtfRazaoSocial;
	private JTextField jtfNomeFantasia;
	private JTextField jtfCNPJ;
	private JTextField jtfEndereco;
	private JTextField jtfBairro;
	private JTextField jtfNumero;
	private JTextField jtfTelefoneComercial;
	private JTextField jtfTelefoneCelular;
	private JTextField jtfFax;
	private JTextField jtfInscricaoEstadual;
	private JTextField jtfDataAlteracao;
	private JTextField jtfNomeCidade;
	private JTextField jtfNomePais;
	private JTextField jtfInscricaoMunicipal;
	private JTextField jtfTelefoneResidencial;
	private JTextField jtfEmail;
	private JTextField jtfNomeCliente;
	private JTextField jtfCPF;
	private JTextField jtfRG;
	private JTextField jtfNomeUF;
	private JTextField jtfCodigoCidade;
	private JTextField jtfCodigoUF;
	private JTextField jtfPesquisaCPFCliente;
	private JTextField jtfDataNascimento;
	private JTextField jtfCodigoCarro;
	private JTextField jtfNomeCarro;
	private JFormattedTextField jtfPlacaCarro;
	private JLabel jlbPesquisaCodigoCliente;
	private JLabel jlbPesquisaNomeCliente;
	private JLabel jlbPesquisaCNPJCliente;
	private JLabel jlbCodigoCliente;
	private JLabel jlbRazaoSocial;
	private JLabel jlbNomeFantasia;
	private JLabel jlbCNPJ;
	private JLabel jlbEndereco;
	private JLabel jlbBairro;
	private JLabel jlbNumero;
	private JLabel jlbTelefoneComercial;
	private JLabel jlbTelefoneCelular;
	private JLabel jlbFax;
	private JLabel jlbInscricaoEstadual;
	private JLabel jlbDataAlteracao;
	private JLabel jlbCidade;
	private JLabel jlbPais;
	private JLabel jlbTipoPessoa;
	private JLabel jlbUnidadeFederativa;
	private JLabel jlbInscricaoMunicipal;
	private JLabel jlbTelefoneResidencial;
	private JLabel jlbEmail;
	private JLabel jlbNome;
	private JLabel jlbCPF;
	private JLabel jlbRG;
	private JLabel jlbDataNascimento;
	private JLabel jlbConsultaCliente;
	private JLabel jlbPesquisaCPFCliente;
	private JLabel jlbCodigoCidade;
	private JLabel jlbCodigoUF;
	private JLabel jlbPlacaCarro;
	private JLabel jlbCodigoCarro;
	private JLabel jlbNomeCarro;
	private JCheckBox jckbxForaUso;
	private JCheckBox jckbxIsento;
	private JComboBox<String> jcbxTipoPessoa;
	private JButton jbtNovo;
	private JButton jbtFechar;
	private JButton jbtCancelar;
	private JButton jbtSalvar;
	private JButton jbtEditar;
	private JMenuBar jmbCadastroCliente;
	private JMenuItem jmnRelatorio;
	private Cliente cliente;
	private static ClienteForm clienteForm;

	public void componentesTelaCliente() {
		jmbCadastroCliente = new JMenuBar();
		jmbCadastroCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		setJMenuBar(jmbCadastroCliente);
		
		jmnRelatorio = new JMenu("Relat\u00F3rios");
		jmnRelatorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jmbCadastroCliente.add(jmnRelatorio);
		setContentPane(jpnCliente);
		
		jpnPesquisaCliente = new JPanel();
		jpnPesquisaCliente.setLayout(null);
		jpnPesquisaCliente.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnPesquisaCliente.setBounds(10, 11, 790, 81);
		jpnCliente.add(jpnPesquisaCliente);
		
		jlbPesquisaCodigoCliente = new JLabel("C\u00F3digo");
		jlbPesquisaCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaCodigoCliente.setBounds(10, 34, 75, 14);
		jpnPesquisaCliente.add(jlbPesquisaCodigoCliente);
		
		jtfPesquisaCodigoCliente = new JTextField();
		jtfPesquisaCodigoCliente.setDocument(new ValidaCampoNumeroInteiro());
		jtfPesquisaCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaCodigoCliente.setColumns(10);
		jtfPesquisaCodigoCliente.setBounds(10, 50, 50, 20);
		jpnPesquisaCliente.add(jtfPesquisaCodigoCliente);
		
		jlbPesquisaNomeCliente = new JLabel("Nome do Cliente");
		jlbPesquisaNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaNomeCliente.setBounds(86, 34, 275, 14);
		jpnPesquisaCliente.add(jlbPesquisaNomeCliente);
		
		jtfPesquisaNomeCliente = new JTextField();
		jtfPesquisaNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaNomeCliente.setColumns(10);
		jtfPesquisaNomeCliente.setBounds(86, 50, 275, 20);
		jpnPesquisaCliente.add(jtfPesquisaNomeCliente);
		
		try {
			jtfPesquisaCnpjCliente = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfPesquisaCnpjCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaCnpjCliente.setColumns(10);
		jtfPesquisaCnpjCliente.setBounds(371, 50, 165, 20);
		jpnPesquisaCliente.add(jtfPesquisaCnpjCliente);
		
		jlbPesquisaCNPJCliente = new JLabel("CNPJ do Cliente");
		jlbPesquisaCNPJCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaCNPJCliente.setBounds(371, 34, 165, 14);
		jpnPesquisaCliente.add(jlbPesquisaCNPJCliente);
		
		jlbConsultaCliente = new JLabel("Consulta Cadastro do Cliente");
		jlbConsultaCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbConsultaCliente.setBounds(10, 9, 351, 14);
		jpnPesquisaCliente.add(jlbConsultaCliente);
		
		try {
			jtfPesquisaCPFCliente = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfPesquisaCPFCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaCPFCliente.setColumns(10);
		jtfPesquisaCPFCliente.setBounds(546, 50, 165, 20);
		jpnPesquisaCliente.add(jtfPesquisaCPFCliente);
		
		jlbPesquisaCPFCliente = new JLabel("CPF");
		jlbPesquisaCPFCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaCPFCliente.setBounds(546, 34, 165, 14);
		jpnPesquisaCliente.add(jlbPesquisaCPFCliente);
		
		jlbCodigoCliente = new JLabel("C\u00F3d. Cliente");
		jlbCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoCliente.setBounds(10, 103, 100, 14);
		jpnCliente.add(jlbCodigoCliente);
		
		jtfCodigoCliente = new JTextField();
		jtfCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoCliente.setEditable(false);
		jtfCodigoCliente.setColumns(10);
		jtfCodigoCliente.setBackground(Color.YELLOW);
		jtfCodigoCliente.setBounds(10, 119, 50, 20);
		jpnCliente.add(jtfCodigoCliente);
		
		jlbRazaoSocial = new JLabel("Raz\u00E3o Social");
		jlbRazaoSocial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbRazaoSocial.setBounds(10, 199, 300, 14);
		jpnCliente.add(jlbRazaoSocial);
		
		jtfRazaoSocial = new JTextField();
		jtfRazaoSocial.setDocument(new ValidaCampoString());
		jtfRazaoSocial.setEnabled(false);
		jtfRazaoSocial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfRazaoSocial.setColumns(10);
		jtfRazaoSocial.setBounds(10, 213, 300, 20);
		jpnCliente.add(jtfRazaoSocial);
		
		jlbNomeFantasia = new JLabel("Nome Fantasia");
		jlbNomeFantasia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeFantasia.setBounds(10, 246, 300, 14);
		jpnCliente.add(jlbNomeFantasia);
		
		jtfNomeFantasia = new JTextField();
		jtfNomeFantasia.setDocument(new ValidaCampoString());
		jtfNomeFantasia.setEnabled(false);
		jtfNomeFantasia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeFantasia.setColumns(10);
		jtfNomeFantasia.setBounds(10, 260, 300, 20);
		jpnCliente.add(jtfNomeFantasia);
		
		jlbCNPJ = new JLabel("CNPJ");
		jlbCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCNPJ.setBounds(320, 199, 125, 14);
		jpnCliente.add(jlbCNPJ);
		
		try {
			jtfCNPJ = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfCNPJ.setEnabled(false);
		jtfCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCNPJ.setColumns(10);
		jtfCNPJ.setBounds(320, 213, 125, 20);
		jpnCliente.add(jtfCNPJ);
		
		jlbEndereco = new JLabel("Endere\u00E7o");
		jlbEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbEndereco.setBounds(10, 383, 300, 14);
		jpnCliente.add(jlbEndereco);
		
		jtfEndereco = new JTextField();
		jtfEndereco.setDocument(new ValidaCampoString());
		jtfEndereco.setEnabled(false);
		jtfEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfEndereco.setColumns(10);
		jtfEndereco.setBounds(10, 399, 300, 20);
		jpnCliente.add(jtfEndereco);
		
		jlbBairro = new JLabel("Bairro");
		jlbBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbBairro.setBounds(396, 383, 174, 14);
		jpnCliente.add(jlbBairro);
		
		jtfBairro = new JTextField();
		jtfBairro.setDocument(new ValidaCampoString());
		jtfBairro.setEnabled(false);
		jtfBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfBairro.setColumns(10);
		jtfBairro.setBounds(396, 399, 174, 20);
		jpnCliente.add(jtfBairro);
		
		jlbNumero = new JLabel("N\u00FAmero");
		jlbNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNumero.setBounds(320, 383, 66, 14);
		jpnCliente.add(jlbNumero);
		
		jtfNumero = new JTextField();
		jtfNumero.setDocument(new ValidaCampoNumeroInteiro());
		jtfNumero.setEnabled(false);
		jtfNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNumero.setColumns(10);
		jtfNumero.setBounds(320, 399, 66, 20);
		jpnCliente.add(jtfNumero);
		
		jlbTelefoneComercial = new JLabel("Telefone Comercial");
		jlbTelefoneComercial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneComercial.setBounds(670, 293, 130, 14);
		jpnCliente.add(jlbTelefoneComercial);
		
		jtfTelefoneComercial = new JTextField();
		jtfTelefoneComercial.setDocument(new ValidaCampoTelefone());
		jtfTelefoneComercial.setEnabled(false);
		jtfTelefoneComercial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneComercial.setColumns(10);
		jtfTelefoneComercial.setBounds(670, 307, 130, 20);
		jpnCliente.add(jtfTelefoneComercial);
		
		jlbTelefoneCelular = new JLabel("Telefone Celular");
		jlbTelefoneCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneCelular.setBounds(670, 199, 130, 14);
		jpnCliente.add(jlbTelefoneCelular);
		
		jtfTelefoneCelular = new JTextField();
		jtfTelefoneCelular.setDocument(new ValidaCampoTelefone());
		jtfTelefoneCelular.setEnabled(false);
		jtfTelefoneCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneCelular.setColumns(10);
		jtfTelefoneCelular.setBounds(670, 213, 130, 20);
		jpnCliente.add(jtfTelefoneCelular);
		
		jlbFax = new JLabel("Fax");
		jlbFax.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbFax.setBounds(670, 246, 130, 14);
		jpnCliente.add(jlbFax);
		
		jtfFax = new JTextField();
		jtfFax.setDocument(new ValidaCampoTelefone());
		jtfFax.setEnabled(false);
		jtfFax.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfFax.setColumns(10);
		jtfFax.setBounds(670, 260, 130, 20);
		jpnCliente.add(jtfFax);
		
		jlbInscricaoEstadual = new JLabel("Inscri\u00E7\u00E3o Estadual");
		jlbInscricaoEstadual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbInscricaoEstadual.setBounds(320, 246, 130, 14);
		jpnCliente.add(jlbInscricaoEstadual);
		
		jtfInscricaoEstadual = new JTextField();
		jtfInscricaoEstadual.setEnabled(false);
		jtfInscricaoEstadual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfInscricaoEstadual.setColumns(10);
		jtfInscricaoEstadual.setBounds(320, 260, 125, 20);
		jpnCliente.add(jtfInscricaoEstadual);
		
		jlbDataAlteracao = new JLabel("Data Alteracao");
		jlbDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataAlteracao.setBounds(686, 105, 114, 14);
		jpnCliente.add(jlbDataAlteracao);
		
		try {
			jtfDataAlteracao = new JFormattedTextField(new MaskFormatter("##/##/####"));
			jtfDataAlteracao.setHorizontalAlignment(SwingConstants.RIGHT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfDataAlteracao.setEditable(false);
		jtfDataAlteracao.setColumns(10);
		jtfDataAlteracao.setBackground(Color.YELLOW);
		jtfDataAlteracao.setBounds(686, 121, 75, 20);
		jpnCliente.add(jtfDataAlteracao);
		
		jlbCidade = new JLabel("Nome da Cidade");
		jlbCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCidade.setBounds(10, 432, 140, 14);
		jpnCliente.add(jlbCidade);
		
		jtfNomeCidade = new JTextField();
		jtfNomeCidade.setDocument(new ValidaCampoAlfaNumerico());
		jtfNomeCidade.setEnabled(false);
		jtfNomeCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeCidade.setColumns(10);
		jtfNomeCidade.setBounds(10, 447, 140, 20);
		jpnCliente.add(jtfNomeCidade);
		
		jlbPais = new JLabel("Nome do Pa\u00EDs");
		jlbPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPais.setBounds(540, 432, 110, 14);
		jpnCliente.add(jlbPais);
		
		jtfNomePais = new JTextField();
		jtfNomePais.setDocument(new ValidaCampoAlfaNumerico());
		jtfNomePais.setEnabled(false);
		jtfNomePais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomePais.setColumns(10);
		jtfNomePais.setBounds(540, 447, 110, 20);
		jpnCliente.add(jtfNomePais);
		
		jlbTipoPessoa = new JLabel("Tipo de Pessoa");
		jlbTipoPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTipoPessoa.setBounds(243, 105, 130, 14);
		jpnCliente.add(jlbTipoPessoa);
		
		jlbUnidadeFederativa = new JLabel("Nome do Estado");
		jlbUnidadeFederativa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbUnidadeFederativa.setBounds(270, 432, 130, 14);
		jpnCliente.add(jlbUnidadeFederativa);
		
		jlbInscricaoMunicipal = new JLabel("Inscri\u00E7\u00E3o Municipal");
		jlbInscricaoMunicipal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbInscricaoMunicipal.setBounds(455, 199, 130, 14);
		jpnCliente.add(jlbInscricaoMunicipal);
		
		jtfInscricaoMunicipal = new JTextField();
		jtfInscricaoMunicipal.setDocument(new ValidaCampoDocumentoJuridico());
		jtfInscricaoMunicipal.setEnabled(false);
		jtfInscricaoMunicipal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfInscricaoMunicipal.setColumns(10);
		jtfInscricaoMunicipal.setBounds(455, 213, 125, 20);
		getContentPane().add(jtfInscricaoMunicipal);
		
		jtfTelefoneResidencial = new JTextField();
		jtfTelefoneResidencial.setDocument(new ValidaCampoTelefone());
		jtfTelefoneResidencial.setEnabled(false);
		jtfTelefoneResidencial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneResidencial.setColumns(10);
		jtfTelefoneResidencial.setBounds(670, 166, 130, 20);
		jpnCliente.add(jtfTelefoneResidencial);
		
		jlbTelefoneResidencial = new JLabel("Telefone Residencial");
		jlbTelefoneResidencial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneResidencial.setBounds(670, 152, 130, 14);
		jpnCliente.add(jlbTelefoneResidencial);
		
		jlbEmail = new JLabel("E-mail");
		jlbEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbEmail.setBounds(10, 338, 140, 14);
		jpnCliente.add(jlbEmail);
		
		jtfEmail = new JTextField();
		jtfEmail.setEnabled(false);
		jtfEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfEmail.setColumns(10);
		jtfEmail.setBounds(10, 352, 300, 20);
		jpnCliente.add(jtfEmail);
		
		jlbNome = new JLabel("Nome do Cliente");
		jlbNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNome.setBounds(10, 152, 300, 14);
		jpnCliente.add(jlbNome);
		
		jtfNomeCliente = new JTextField();
		jtfNomeCliente.setDocument(new ValidaCampoString());
		jtfNomeCliente.setEnabled(false);
		jtfNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeCliente.setColumns(10);
		jtfNomeCliente.setBounds(10, 166, 300, 20);
		jpnCliente.add(jtfNomeCliente);
		
		jlbCPF = new JLabel("CPF");
		jlbCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCPF.setBounds(320, 152, 100, 14);
		jpnCliente.add(jlbCPF);
		
		try {
			jtfCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfCPF.setEnabled(false);
		jtfCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCPF.setColumns(10);
		jtfCPF.setBounds(320, 166, 100, 20);
		jpnCliente.add(jtfCPF);
		
		jlbRG = new JLabel("R.G.");
		jlbRG.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbRG.setBounds(430, 152, 100, 14);
		jpnCliente.add(jlbRG);
		
		jtfRG = new JTextField();
		jtfRG.setDocument(new ValidaCampoDocumentoFisico());
		jtfRG.setEnabled(false);
		jtfRG.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfRG.setColumns(10);
		jtfRG.setBounds(430, 166, 100, 20);
		jpnCliente.add(jtfRG);
		
		jlbDataNascimento = new JLabel("Data de Nascimento");
		jlbDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataNascimento.setBounds(540, 152, 150, 14);
		jpnCliente.add(jlbDataNascimento);
		
		jckbxForaUso = new JCheckBox("Fora de Uso");
		jckbxForaUso.setEnabled(false);
		jckbxForaUso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jckbxForaUso.setBounds(495, 118, 130, 23);
		jpnCliente.add(jckbxForaUso);
		
		jtfNomeUF = new JTextField();
		jtfNomeUF.setDocument(new ValidaCampoAlfaNumerico());
		jtfNomeUF.setEnabled(false);
		jtfNomeUF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeUF.setColumns(10);
		jtfNomeUF.setBounds(270, 447, 130, 20);
		jpnCliente.add(jtfNomeUF);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 478, 120, 25);
		jpnCliente.add(jbtNovo);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setBounds(530, 478, 120, 25);
		jpnCliente.add(jbtFechar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setEnabled(false);
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setBounds(400, 478, 120, 25);
		jpnCliente.add(jbtCancelar);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setEnabled(false);
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(270, 478, 120, 25);
		jpnCliente.add(jbtSalvar);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setEnabled(false);
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setBounds(140, 478, 120, 25);
		jpnCliente.add(jbtEditar);
		
		jckbxIsento = new JCheckBox("ISENTO");
		jckbxIsento.setEnabled(false);
		jckbxIsento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jckbxIsento.setBounds(451, 259, 134, 23);
		jpnCliente.add(jckbxIsento);
		
		jcbxTipoPessoa = new JComboBox<String>();
		jcbxTipoPessoa.setEnabled(false);
		jcbxTipoPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jcbxTipoPessoa.setBounds(243, 120, 130, 20);
		jcbxTipoPessoa.addItem("Pessoa Física");
		jcbxTipoPessoa.addItem("Pessoa Jurídica");
		jpnCliente.add(jcbxTipoPessoa);
		
		jlbCodigoCidade = new JLabel("C\u00F3d. Cidade");
		jlbCodigoCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoCidade.setBounds(160, 432, 110, 14);
		jpnCliente.add(jlbCodigoCidade);
		
		jtfCodigoCidade = new JTextField();
		jtfCodigoCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoCidade.setEditable(false);
		jtfCodigoCidade.setColumns(10);
		jtfCodigoCidade.setBackground(Color.YELLOW);
		jtfCodigoCidade.setBounds(160, 447, 50, 20);
		jpnCliente.add(jtfCodigoCidade);
		
		jlbCodigoUF = new JLabel("C\u00F3d. Estado");
		jlbCodigoUF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoUF.setBounds(410, 432, 110, 14);
		jpnCliente.add(jlbCodigoUF);
		
		jtfCodigoUF = new JTextField();
		jtfCodigoUF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoUF.setEditable(false);
		jtfCodigoUF.setColumns(10);
		jtfCodigoUF.setBackground(Color.YELLOW);
		jtfCodigoUF.setBounds(410, 447, 50, 20);
		jpnCliente.add(jtfCodigoUF);
		
		try {
			jtfDataNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
			jtfDataNascimento.setHorizontalAlignment(SwingConstants.TRAILING);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfDataNascimento.setEnabled(false);
		jtfDataNascimento.setColumns(10);
		jtfDataNascimento.setBounds(542, 166, 75, 20);
		jpnCliente.add(jtfDataNascimento);
		
		jtfCodigoCarro = new JTextField();
		jtfCodigoCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoCarro.setEditable(false);
		jtfCodigoCarro.setColumns(10);
		jtfCodigoCarro.setBackground(Color.YELLOW);
		jtfCodigoCarro.setBounds(10, 307, 50, 20);
		jpnCliente.add(jtfCodigoCarro);
		
		jlbCodigoCarro = new JLabel("C\u00F3d. Carro");
		jlbCodigoCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoCarro.setBounds(10, 291, 95, 14);
		jpnCliente.add(jlbCodigoCarro);

		jlbNomeCarro = new JLabel("Nome do Carro");
		jlbNomeCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeCarro.setBounds(105, 293, 300, 14);
		jpnCliente.add(jlbNomeCarro);
		
		jtfNomeCarro = new JTextField();
		jtfNomeCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeCarro.setEnabled(false);
		jtfNomeCarro.setColumns(10);
		jtfNomeCarro.setBounds(105, 307, 300, 20);
		jpnCliente.add(jtfNomeCarro);
		
		jlbPlacaCarro = new JLabel("Placa do Carro");
		jlbPlacaCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPlacaCarro.setBounds(415, 293, 110, 14);
		jpnCliente.add(jlbPlacaCarro);
		
		try {
			jtfPlacaCarro = new JFormattedTextField(new MaskFormatter("UUU-####"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfPlacaCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPlacaCarro.setEnabled(false);
		jtfPlacaCarro.setColumns(10);
		jtfPlacaCarro.setBounds(415, 307, 75, 20);
		jpnCliente.add(jtfPlacaCarro);
	}
	
	public void acionarBotaoNovo() {
		this.selecionarTipoPessoa();
		jtfNomeCliente.setEnabled(true);
		jtfDataNascimento.setEnabled(true);
		jtfCPF.setEnabled(true);
		jtfRG.setEnabled(true);
		jcbxTipoPessoa.setEnabled(true);
		jcbxTipoPessoa.setSelectedIndex(0);
		jckbxForaUso.setSelected(false);
		jtfNomeCarro.setEnabled(true);
		jtfEmail.setEnabled(true);
		jtfTelefoneCelular.setEnabled(true);
		jtfTelefoneComercial.setEnabled(true);
		jtfTelefoneResidencial.setEnabled(true);
		jtfFax.setEnabled(true);
		jtfEndereco.setEnabled(true);
		jtfNumero.setEnabled(true);
		jtfBairro.setEnabled(true);
		jtfNomeCidade.setEnabled(true);
		jtfNomeCliente.setText("");
		jtfCPF.setText("");
		jtfRG.setText("");
		jtfEmail.setText("");
		jtfNomeCarro.setText("");
		jtfCodigoCarro.setText("");
		jtfPlacaCarro.setText("");
		jtfTelefoneCelular.setText("");
		jtfTelefoneComercial.setText("");
		jtfTelefoneResidencial.setText("");
		jtfFax.setText("");
		jtfEndereco.setText("");
		jtfNumero.setText("");
		jtfBairro.setText("");
		jtfCodigoUF.setText("");
		jtfNomeUF.setText("");
		jtfNomeCidade.setText("");
		jtfCodigoCidade.setText("");
		jtfNomePais.setText("");
		jbtNovo.setEnabled(false);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
		jbtEditar.setEnabled(false);
	}
	
	public void salvarCadastroCliente() throws Exception {
		this.cliente = new Cliente();
		if (jcbxTipoPessoa.getSelectedIndex() == 0) {
			if (jtfNomeCliente.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar nome do cliente!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfNomeCliente.requestFocus();
			} else if (jtfCPF.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar o CPF do cliente!!!", "Aviso",	JOptionPane.INFORMATION_MESSAGE);
				jtfCPF.requestFocus();
			} else if (jtfDataNascimento.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar a data de nascimento!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfDataNascimento.requestFocus();
			} else if (jtfEmail.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar o email!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfEmail.requestFocus();
			} else if (jtfEndereco.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar o endereço!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfEndereco.requestFocus();
			} else if (jtfNumero.getText().equals("")) {
				JOptionPane.showMessageDialog(null,
						"Obrigatório informar o número!!!\n" + "(Residência/Estabelecimento Comercial)", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfNumero.requestFocus();
			} else if (jtfBairro.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar o bairro!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfBairro.requestFocus();
			} else if (jtfNomeCidade.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar uma cidade!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfNomeCidade.requestFocus();
			}
		} else if (jcbxTipoPessoa.getSelectedIndex() == 1) {
			if (jtfRazaoSocial.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar a Razão Social!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfRazaoSocial.requestFocus();
			} else if (jtfCNPJ.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar o CNPJ!!!", "Aviso",	JOptionPane.INFORMATION_MESSAGE);
				jtfCNPJ.requestFocus();
			} else if (jtfNomeFantasia.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar nome Fantasia!!!", "Aviso",	JOptionPane.INFORMATION_MESSAGE);
				jtfNomeFantasia.requestFocus();
			} else if (jtfInscricaoEstadual.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar a inscrição estadual!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfInscricaoEstadual.requestFocus();
				if (jckbxIsento.isSelected()) {
					jtfInscricaoEstadual.setText("ISENTO");
				}
			} else if (jtfEmail.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar o email!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfEmail.requestFocus();
			} else if (jtfEndereco.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar o endereço!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfEndereco.requestFocus();
			} else if (jtfNumero.getText().equals("")) {
				JOptionPane.showMessageDialog(null,
						"Obrigatório informar o número!!!\n" + "(Residência/Estabelecimento Comercial)", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfNumero.requestFocus();
			} else if (jtfBairro.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar o bairro!!!", "Aviso",	JOptionPane.INFORMATION_MESSAGE);
				jtfBairro.requestFocus();
			} else if (jtfNomeCidade.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar uma cidade!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfNomeCidade.requestFocus();
			}
		} else {
			//Tipo de pessoa igual a 1 é Física 2 Jurídica
			if(jcbxTipoPessoa.getSelectedIndex() == 0) {
				this.cliente.setTipoPessoa(1);
			} else {
				this.cliente.setTipoPessoa(2);
			}
//			this.cliente.setNome(jtfNomeCliente.getText());
//			this.cliente.setCpf(jtfCPF.getText());
//			this.cliente.setRg(jtfRG.getText());
//			this.cliente.setDataNascimento(Date.valueOf(jtfDataNascimento.getText()).toLocalDate());
//			this.cliente.setRazaoSocial(jtfRazaoSocial.getText());
//			this.cliente.setCnpj(jtfCNPJ.getText());
//			this.cliente.setInscricaoMunicipal(jtfInscricaoMunicipal.getText());
//			this.cliente.setNomeFantasia(jtfNomeFantasia.getText());
//			this.cliente.setInscricaoEstadual(jtfInscricaoEstadual.getText());
			this.cliente.setEmail(jtfEmail.getText());
			this.cliente.setTelefoneCelular(jtfTelefoneCelular.getText());
			this.cliente.setTelefoneComercial(jtfTelefoneComercial.getText());
			this.cliente.setTelefoneResidencial(jtfTelefoneResidencial.getText());
			this.cliente.setFax(jtfFax.getText());
			this.cliente.setEndereco(jtfEndereco.getText());
			this.cliente.setNumero(Integer.valueOf(jtfNumero.getText()));
			this.cliente.setBairro(jtfBairro.getText());
			this.cliente.setCidade(new Cidade(Integer.valueOf(jtfCodigoCidade.getText()), null));
			this.cliente.setEmpresa(new Empresa(1));
			DaoFactory.getFactory().clienteDao().inserir(cliente);
			jtfCodigoCliente.setText(String.valueOf(this.cliente.getIdCliente()));
			jtfDataAlteracao.setText(this.cliente.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
			JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!!!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			jcbxTipoPessoa.setEnabled(false);
			jckbxIsento.setEnabled(false);
			jtfNomeCliente.setEnabled(false);
			jtfDataNascimento.setEnabled(false);
			jtfCPF.setEnabled(false);
			jtfRG.setEnabled(false);
			jtfRazaoSocial.setEnabled(false);
			jtfNomeFantasia.setEnabled(false);
			jtfCNPJ.setEnabled(false);
			jtfInscricaoEstadual.setEnabled(false);
			jtfInscricaoMunicipal.setEnabled(false);
			jtfEmail.setEnabled(false);
			jtfTelefoneCelular.setEnabled(false);
			jtfTelefoneComercial.setEnabled(false);
			jtfTelefoneResidencial.setEnabled(false);
			jtfFax.setEnabled(false);
			jtfEndereco.setEnabled(false);
			jtfNumero.setEnabled(false);
			jtfBairro.setEnabled(false);
			jtfNomeCidade.setEnabled(false);
			jbtSalvar.setEnabled(false);
			jbtEditar.setEnabled(true);
			jbtNovo.setEnabled(true);
			jbtCancelar.setEnabled(false);
		}
	}
	
	public void salvarEdicaoCliente() {
		jckbxForaUso.setEnabled(true);
		jbtSalvar.setEnabled(false);
		jbtEditar.setEnabled(true);
		jbtNovo.setEnabled(true);
		jbtCancelar.setEnabled(false);
	}
	
	public void acionarBotaoEditar() {
		this.selecionarTipoPessoa();
		jcbxTipoPessoa.setEnabled(true);
		jtfEmail.setEnabled(true);
		jtfTelefoneCelular.setEnabled(true);
		jtfTelefoneComercial.setEnabled(true);
		jtfTelefoneResidencial.setEnabled(true);
		jtfFax.setEnabled(true);
		jtfEndereco.setEnabled(true);
		jtfNumero.setEnabled(true);
		jtfBairro.setEnabled(true);
		jtfNomeCidade.setEnabled(true);
		jtfNomeCidade.setEnabled(true);
		jbtNovo.setEnabled(false);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
	}
	
	public void acionarBotaoCancelar() {
		jcbxTipoPessoa.setEnabled(false);
		jcbxTipoPessoa.setSelectedIndex(0);
		jckbxForaUso.setSelected(false);
		jckbxIsento.setEnabled(false);
		jckbxIsento.setSelected(false);
		jtfNomeCliente.setEnabled(false);
		jtfDataNascimento.setEnabled(false);
		jtfCPF.setEnabled(false);
		jtfRG.setEnabled(false);
		jtfRazaoSocial.setEnabled(false);
		jtfNomeFantasia.setEnabled(false);
		jtfCNPJ.setEnabled(false);
		jtfInscricaoEstadual.setEnabled(false);
		jtfInscricaoMunicipal.setEnabled(false);
		jtfNomeCarro.setEnabled(false);
		jtfEmail.setEnabled(false);
		jtfTelefoneCelular.setEnabled(false);
		jtfTelefoneComercial.setEnabled(false);
		jtfTelefoneResidencial.setEnabled(false);
		jtfFax.setEnabled(false);
		jtfEndereco.setEnabled(false);
		jtfNumero.setEnabled(false);
		jtfBairro.setEnabled(false);
		jtfNomeCidade.setEnabled(false);
		jtfCodigoCliente.setText("");
		jtfNomeCliente.setText("");
		jtfCPF.setText("");
		jtfRG.setText("");
		jtfDataNascimento.setText("");
		jtfRazaoSocial.setText("");
		jtfNomeFantasia.setText("");
		jtfCNPJ.setText("");
		jtfInscricaoEstadual.setText("");
		jtfInscricaoMunicipal.setText("");
		jtfEmail.setText("");
		jtfNomeCarro.setText("");
		jtfCodigoCarro.setText("");
		jtfPlacaCarro.setText("");
		jtfTelefoneCelular.setText("");
		jtfTelefoneComercial.setText("");
		jtfTelefoneResidencial.setText("");
		jtfFax.setText("");
		jtfEndereco.setText("");
		jtfNumero.setText("");
		jtfBairro.setText("");
		jtfCodigoUF.setText("");
		jtfNomeUF.setText("");
		jtfNomeCidade.setText("");
		jtfCodigoCidade.setText("");
		jtfNomePais.setText("");
		jtfDataAlteracao.setText("");
		jbtNovo.setEnabled(true);
		jbtCancelar.setEnabled(false);
		jbtSalvar.setEnabled(false);
		jbtEditar.setEnabled(false);
	}
	
	public void preencherCamposCliente(Cliente cliente) {
		jtfCodigoCliente.setText(String.valueOf(cliente.getIdCliente()));
//		jtfNomeCliente.setText(cliente.getNome());
//		jtfCPF.setText(cliente.getCpf());
//		jtfRG.setText(cliente.getRg());
//		jtfDataNascimento.setText(cliente.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
//		jtfRazaoSocial.setText(cliente.getRazaoSocial());
//		jtfNomeFantasia.setText(cliente.getNomeFantasia());
//		jtfCNPJ.setText(cliente.getCnpj());
//		jtfInscricaoEstadual.setText(cliente.getInscricaoEstadual());
//		jtfInscricaoMunicipal.setText(cliente.getInscricaoMunicipal());
		jtfEmail.setText(cliente.getEmail());
		jtfTelefoneCelular.setText(cliente.getTelefoneCelular());
		jtfTelefoneComercial.setText(cliente.getTelefoneComercial());
		jtfTelefoneResidencial.setText(cliente.getTelefoneResidencial());
		jtfFax.setText(cliente.getFax());
		jtfEndereco.setText(cliente.getEndereco());
		jtfNumero.setText(String.valueOf(cliente.getNumero()));
		jtfBairro.setText(cliente.getBairro());
		jtfCodigoUF.setText(String.valueOf(cliente.getCidade().getUnidadeFederativa().getIdUnidadeFederativa()));
		jtfNomeUF.setText(cliente.getCidade().getUnidadeFederativa().getNome());
		jtfNomeCidade.setText(cliente.getCidade().getNome());
		jtfCodigoCidade.setText(String.valueOf(cliente.getCidade().getIdCidade()));
		jtfNomePais.setText(cliente.getCidade().getUnidadeFederativa().getPais().getNome());
		jtfDataAlteracao.setText(cliente.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
		if(cliente.getTipoPessoa() == 1) {
			jcbxTipoPessoa.setSelectedIndex(0);
		} else {
			jcbxTipoPessoa.setSelectedIndex(1);
		}
		jtfPesquisaCodigoCliente.setText("");
		jtfPesquisaNomeCliente.setText("");
		jtfPesquisaCnpjCliente.setText("");
		jtfPesquisaCPFCliente.setText("");
		jtfPesquisaCodigoCliente.requestFocus();
	}
	
	public void preencherCamposCidadeUFPais(Cidade cidade) {
		jtfCodigoCidade.setText(String.valueOf(cidade.getIdCidade()));
		jtfNomeCidade.setText(cidade.getNome());
		jtfCodigoUF.setText(String.valueOf(cidade.getUnidadeFederativa().getIdUnidadeFederativa()));
		jtfNomeUF.setText(cidade.getUnidadeFederativa().getNome());
		jtfNomePais.setText(cidade.getUnidadeFederativa().getPais().getNome());
	}
	
	public void selecionarTipoPessoa() {
		jcbxTipoPessoa.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if((evt.getSource() == jcbxTipoPessoa) && (evt.getStateChange() == ItemEvent.SELECTED)) {
					if(jcbxTipoPessoa.getSelectedIndex() == 1) {
						jtfNomeCliente.setEnabled(false);
						jtfDataNascimento.setEnabled(false);
						jtfCPF.setEnabled(false);
						jtfRG.setEnabled(false);
						jckbxIsento.setEnabled(true);
						jckbxIsento.setSelected(false);
						jtfRazaoSocial.setEnabled(true);
						jtfNomeFantasia.setEnabled(true);
						jtfCNPJ.setEnabled(true);
						jtfInscricaoEstadual.setEnabled(true);
						jtfInscricaoMunicipal.setEnabled(true);
					} else {
						jtfNomeCliente.setEnabled(true);
						jtfDataNascimento.setEnabled(true);
						jtfCPF.setEnabled(true);
						jtfRG.setEnabled(true);
						jckbxIsento.setEnabled(false);
						jckbxIsento.setSelected(false);
						jtfRazaoSocial.setEnabled(false);
						jtfNomeFantasia.setEnabled(false);
						jtfCNPJ.setEnabled(false);
						jtfInscricaoEstadual.setEnabled(false);
						jtfInscricaoMunicipal.setEnabled(false);
					}
				}
			}
		});
	}
	
	public void acoesDosBotoes() {
		jbtNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent acvt) {
				if(acvt.getSource() == jbtNovo) {
					acionarBotaoNovo();
				}
			}
		});
		
		jbtSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent acvt) {
				if (acvt.getSource() == jbtSalvar) {
					if (jbtSalvar.isEnabled() && jbtEditar.isEnabled()) {
						salvarEdicaoCliente();
					} else {
						try {
							salvarCadastroCliente();
						} catch (Exception salvarCliente) {
							salvarCliente.printStackTrace();
						}
					}
				}
			}
		});
		
		jbtEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent acvt) {
				if(acvt.getSource() == jbtEditar) {
					acionarBotaoEditar();
				}
			}
		});
		
		jbtCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent acvt) {
				if(acvt.getSource() == jbtCancelar) {
					acionarBotaoCancelar();
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
	
	public void pesquisaPorCodigo() {
		jtfPesquisaNomeCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
				
					jtfDataAlteracao.setText("");
					jbtEditar.setEnabled(true);
					jbtSalvar.setEnabled(false);
					jbtCancelar.setEnabled(true);
				}
			}
		});
	}
	
	public void pesquisaPorNome() {
		jtfPesquisaNomeCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
				
					jtfDataAlteracao.setText("");
					jbtEditar.setEnabled(true);
					jbtSalvar.setEnabled(false);
					jbtCancelar.setEnabled(true);
				}
			}
		});
	}
	
	public void pesquisaPorCNPJ() {
		jtfPesquisaNomeCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
				
					jtfDataAlteracao.setText("");
					jbtEditar.setEnabled(true);
					jbtSalvar.setEnabled(false);
					jbtCancelar.setEnabled(true);
				}
			}
		});
	}
	
	public void pesquisaPorCPF() {
		jtfPesquisaNomeCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
				
					jtfDataAlteracao.setText("");
					jbtEditar.setEnabled(true);
					jbtSalvar.setEnabled(false);
					jbtCancelar.setEnabled(true);
				}
			}
		});
	}
	
	public void pesquisaCidade() {
		jtfNomeCidade.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					ListaCidadeUFPaisForm listaCidadeUFPaisForm = new ListaCidadeUFPaisForm(clienteForm, jtfNomeCidade.getText());
					listaCidadeUFPaisForm.setVisible(true);
					jtfCodigoCidade.setText("");
					jtfNomeCidade.setText("");
					jtfCodigoUF.setText("");
					jtfNomeUF.setText("");
					jtfNomePais.setText("");
				}
			}
		});
	}

	public ClienteForm() {
		clienteForm = this;
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClienteForm.class.getResource("/Imagens/washCar.jpeg")));
		setResizable(false);
		setTitle("Cadastro de Clientes");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 817, 563);
		jpnCliente = new JPanel();
		jpnCliente.setLayout(null);
		setLocationRelativeTo(null);
		
		componentesTelaCliente();
		acoesDosBotoes();
		pesquisaPorCodigo();
		pesquisaPorNome();
		pesquisaPorCNPJ();
		pesquisaPorCPF();
		pesquisaCidade();
	}

	@Override
	public void preencherCampos(Entidade entidade) {
		if(jtfNomeCidade.isEnabled() && !jtfNomeUF.isEnabled() && !jtfNomePais.isEnabled()) {
			this.preencherCamposCidadeUFPais((Cidade)entidade);
		} else {
			this.preencherCamposCliente((Cliente)entidade);
		}
	}
}