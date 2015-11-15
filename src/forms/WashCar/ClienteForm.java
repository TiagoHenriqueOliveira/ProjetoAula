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
import exception.WashCar.RegistroExistente;
import exception.WashCar.RegistroNotExistente;
import model.WashCar.Cidade;
import model.WashCar.Cliente;
import model.WashCar.Empresa;
import model.WashCar.Entidade;
import model.WashCar.PessoaFisica;
import model.WashCar.PessoaJuridica;
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
import java.sql.Date;
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
	private JLabel jlbConsultaCliente;
	private JLabel jlbPesquisaCPFCliente;
	private JLabel jlbCodigoCidade;
	private JLabel jlbCodigoUF;
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
	private PessoaFisica pessoaFisica;
	private PessoaJuridica pessoaJuridica;
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
		jpnPesquisaCliente.setBounds(10, 11, 725, 81);
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
		jtfPesquisaNomeCliente.setDocument(new ValidaCampoAlfaNumerico());
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
		jtfPesquisaCnpjCliente.setBounds(371, 50, 125, 20);
		jpnPesquisaCliente.add(jtfPesquisaCnpjCliente);
		
		jlbPesquisaCNPJCliente = new JLabel("CNPJ do Cliente");
		jlbPesquisaCNPJCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaCNPJCliente.setBounds(371, 34, 125, 14);
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
		jtfPesquisaCPFCliente.setBounds(506, 50, 100, 20);
		jpnPesquisaCliente.add(jtfPesquisaCPFCliente);
		
		jlbPesquisaCPFCliente = new JLabel("CPF");
		jlbPesquisaCPFCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaCPFCliente.setBounds(506, 34, 100, 14);
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
		jlbEndereco.setBounds(10, 336, 300, 14);
		jpnCliente.add(jlbEndereco);
		
		jtfEndereco = new JTextField();
		jtfEndereco.setDocument(new ValidaCampoString());
		jtfEndereco.setEnabled(false);
		jtfEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfEndereco.setColumns(10);
		jtfEndereco.setBounds(10, 352, 300, 20);
		jpnCliente.add(jtfEndereco);
		
		jlbBairro = new JLabel("Bairro");
		jlbBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbBairro.setBounds(396, 336, 174, 14);
		jpnCliente.add(jlbBairro);
		
		jtfBairro = new JTextField();
		jtfBairro.setDocument(new ValidaCampoString());
		jtfBairro.setEnabled(false);
		jtfBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfBairro.setColumns(10);
		jtfBairro.setBounds(396, 352, 174, 20);
		jpnCliente.add(jtfBairro);
		
		jlbNumero = new JLabel("N\u00FAmero");
		jlbNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNumero.setBounds(320, 336, 66, 14);
		jpnCliente.add(jlbNumero);
		
		jtfNumero = new JTextField();
		jtfNumero.setDocument(new ValidaCampoNumeroInteiro());
		jtfNumero.setEnabled(false);
		jtfNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNumero.setColumns(10);
		jtfNumero.setBounds(320, 352, 66, 20);
		jpnCliente.add(jtfNumero);
		
		jlbTelefoneComercial = new JLabel("Telefone Comercial");
		jlbTelefoneComercial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneComercial.setBounds(595, 246, 130, 14);
		jpnCliente.add(jlbTelefoneComercial);
		
		jtfTelefoneComercial = new JTextField();
		jtfTelefoneComercial.setDocument(new ValidaCampoTelefone());
		jtfTelefoneComercial.setEnabled(false);
		jtfTelefoneComercial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneComercial.setColumns(10);
		jtfTelefoneComercial.setBounds(595, 260, 130, 20);
		jpnCliente.add(jtfTelefoneComercial);
		
		jlbTelefoneCelular = new JLabel("Telefone Celular");
		jlbTelefoneCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneCelular.setBounds(595, 199, 130, 14);
		jpnCliente.add(jlbTelefoneCelular);
		
		jtfTelefoneCelular = new JTextField();
		jtfTelefoneCelular.setDocument(new ValidaCampoTelefone());
		jtfTelefoneCelular.setEnabled(false);
		jtfTelefoneCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneCelular.setColumns(10);
		jtfTelefoneCelular.setBounds(595, 213, 130, 20);
		jpnCliente.add(jtfTelefoneCelular);
		
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
		jlbDataAlteracao.setBounds(611, 105, 114, 14);
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
		jtfDataAlteracao.setBounds(611, 121, 75, 20);
		jpnCliente.add(jtfDataAlteracao);
		
		jlbCidade = new JLabel("Nome da Cidade");
		jlbCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCidade.setBounds(10, 385, 140, 14);
		jpnCliente.add(jlbCidade);
		
		jtfNomeCidade = new JTextField();
		jtfNomeCidade.setDocument(new ValidaCampoAlfaNumerico());
		jtfNomeCidade.setEnabled(false);
		jtfNomeCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeCidade.setColumns(10);
		jtfNomeCidade.setBounds(10, 400, 226, 20);
		jpnCliente.add(jtfNomeCidade);
		
		jlbPais = new JLabel("Nome do Pa\u00EDs");
		jlbPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPais.setBounds(615, 385, 110, 14);
		jpnCliente.add(jlbPais);
		
		jtfNomePais = new JTextField();
		jtfNomePais.setDocument(new ValidaCampoAlfaNumerico());
		jtfNomePais.setEnabled(false);
		jtfNomePais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomePais.setColumns(10);
		jtfNomePais.setBounds(615, 400, 110, 20);
		jpnCliente.add(jtfNomePais);
		
		jlbTipoPessoa = new JLabel("Tipo de Pessoa");
		jlbTipoPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTipoPessoa.setBounds(243, 105, 130, 14);
		jpnCliente.add(jlbTipoPessoa);
		
		jlbUnidadeFederativa = new JLabel("Nome do Estado");
		jlbUnidadeFederativa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbUnidadeFederativa.setBounds(345, 385, 130, 14);
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
		jtfTelefoneResidencial.setBounds(595, 166, 130, 20);
		jpnCliente.add(jtfTelefoneResidencial);
		
		jlbTelefoneResidencial = new JLabel("Telefone Residencial");
		jlbTelefoneResidencial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneResidencial.setBounds(595, 152, 130, 14);
		jpnCliente.add(jlbTelefoneResidencial);
		
		jlbEmail = new JLabel("E-mail");
		jlbEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbEmail.setBounds(10, 291, 140, 14);
		jpnCliente.add(jlbEmail);
		
		jtfEmail = new JTextField();
		jtfEmail.setEnabled(false);
		jtfEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfEmail.setColumns(10);
		jtfEmail.setBounds(10, 305, 300, 20);
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
		
		jckbxForaUso = new JCheckBox("Fora de Uso");
		jckbxForaUso.setEnabled(false);
		jckbxForaUso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jckbxForaUso.setBounds(473, 118, 130, 23);
		jpnCliente.add(jckbxForaUso);
		
		jtfNomeUF = new JTextField();
		jtfNomeUF.setDocument(new ValidaCampoAlfaNumerico());
		jtfNomeUF.setEnabled(false);
		jtfNomeUF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeUF.setColumns(10);
		jtfNomeUF.setBounds(345, 400, 130, 20);
		jpnCliente.add(jtfNomeUF);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 431, 120, 25);
		jpnCliente.add(jbtNovo);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setBounds(530, 431, 120, 25);
		jpnCliente.add(jbtFechar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setEnabled(false);
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setBounds(400, 431, 120, 25);
		jpnCliente.add(jbtCancelar);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setEnabled(false);
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(140, 431, 120, 25);
		jpnCliente.add(jbtSalvar);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setEnabled(false);
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setBounds(270, 431, 120, 25);
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
		jlbCodigoCidade.setBounds(246, 385, 100, 14);
		jpnCliente.add(jlbCodigoCidade);
		
		jtfCodigoCidade = new JTextField();
		jtfCodigoCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoCidade.setEditable(false);
		jtfCodigoCidade.setColumns(10);
		jtfCodigoCidade.setBackground(Color.YELLOW);
		jtfCodigoCidade.setBounds(246, 400, 50, 20);
		jpnCliente.add(jtfCodigoCidade);
		
		jlbCodigoUF = new JLabel("C\u00F3d. Estado");
		jlbCodigoUF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoUF.setBounds(485, 385, 110, 14);
		jpnCliente.add(jlbCodigoUF);
		
		jtfCodigoUF = new JTextField();
		jtfCodigoUF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoUF.setEditable(false);
		jtfCodigoUF.setColumns(10);
		jtfCodigoUF.setBackground(Color.YELLOW);
		jtfCodigoUF.setBounds(485, 400, 50, 20);
		jpnCliente.add(jtfCodigoUF);
	}
	
	public void acionarBotaoNovo() {
		this.selecionarTipoPessoa();
		jtfNomeCliente.requestFocus();
		jtfNomeCliente.setEnabled(true);
		jtfCPF.setEnabled(true);
		jtfRG.setEnabled(true);
		jcbxTipoPessoa.setEnabled(true);
		jcbxTipoPessoa.setSelectedIndex(0);
		jckbxForaUso.setSelected(false);
		jtfEmail.setEnabled(true);
		jtfTelefoneCelular.setEnabled(true);
		jtfTelefoneComercial.setEnabled(true);
		jtfTelefoneResidencial.setEnabled(true);
		jtfEndereco.setEnabled(true);
		jtfNumero.setEnabled(true);
		jtfBairro.setEnabled(true);
		jtfNomeCidade.setEnabled(true);
		jtfCodigoCliente.setText("");
		jtfNomeCliente.setText("");
		jtfCPF.setText("");
		jtfRG.setText("");
		jtfEmail.setText("");
		jtfTelefoneCelular.setText("");
		jtfTelefoneComercial.setText("");
		jtfTelefoneResidencial.setText("");
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
	
	@SuppressWarnings("static-access")
	public void salvarCadastroCliente() throws RegistroExistente {
		if (jcbxTipoPessoa.getSelectedIndex() == 0) {
			if (jtfNomeCliente.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar nome do cliente!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfNomeCliente.requestFocus();
			} else if (jtfCPF.getText().equals("   .   .   -  ")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar o CPF do cliente!!!", "Aviso",	JOptionPane.INFORMATION_MESSAGE);
				jtfCPF.requestFocus();
			} else if (jtfEmail.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar o email!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfEmail.requestFocus();
			} else if (jtfEndereco.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar o endereço!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfEndereco.requestFocus();
			} else if (jtfNumero.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Obrigatório informar o número!!!\n (Residência/Estabelecimento Comercial)", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfNumero.requestFocus();
			} else if (jtfBairro.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar o bairro!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfBairro.requestFocus();
			} else if (jtfNomeCidade.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar uma cidade!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfNomeCidade.requestFocus();
			} else {
				//Tipo de pessoa igual a 1 é Física 2 Jurídica
				this.cliente = new Cliente();
				this.cliente.setTipoPessoa(1);
				this.cliente.setEmail(jtfEmail.getText());
				this.cliente.setTelefoneCelular(jtfTelefoneCelular.getText());
				this.cliente.setTelefoneComercial(jtfTelefoneComercial.getText());
				this.cliente.setTelefoneResidencial(jtfTelefoneResidencial.getText());
				this.cliente.setEndereco(jtfEndereco.getText());
				this.cliente.setNumero(Integer.valueOf(jtfNumero.getText()));
				this.cliente.setBairro(jtfBairro.getText());
				this.cliente.setForaUso(Boolean.valueOf(jckbxForaUso.isSelected()));
				this.cliente.setDataAltercacao(Date.valueOf(cliente.getDataAltercacao().now()).toLocalDate());
				this.cliente.setCidade(new Cidade(Integer.valueOf(jtfCodigoCidade.getText()), null));
				this.cliente.setEmpresa(new Empresa(1));
				DaoFactory.getFactory().clienteDao().inserir(cliente);
				jtfCodigoCliente.setText(String.valueOf(this.cliente.getIdCliente()));
				this.pessoaFisica = new PessoaFisica();
				this.pessoaFisica.setNome(jtfNomeCliente.getText());
				this.pessoaFisica.setCpf(jtfCPF.getText());
				this.pessoaFisica.setRg(jtfRG.getText());
				this.pessoaFisica.setIdCliente(Integer.valueOf(jtfCodigoCliente.getText()));
				DaoFactory.getFactory().pessoaFisicaDao().inserir(pessoaFisica);
				jtfDataAlteracao.setText(this.cliente.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
				JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!!!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
				jcbxTipoPessoa.setEnabled(false);
				jckbxIsento.setEnabled(false);
				jtfNomeCliente.setEnabled(false);
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
				jtfEndereco.setEnabled(false);
				jtfNumero.setEnabled(false);
				jtfBairro.setEnabled(false);
				jtfNomeCidade.setEnabled(false);
				jbtSalvar.setEnabled(false);
				jbtEditar.setEnabled(true);
				jbtNovo.setEnabled(true);
				jbtCancelar.setEnabled(false);
			}
		} else if (jcbxTipoPessoa.getSelectedIndex() == 1) {
			if (jtfRazaoSocial.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar a Razão Social!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfRazaoSocial.requestFocus();
			} else if (jtfCNPJ.getText().equals("  .   .   /    -  ")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar o CNPJ!!!", "Aviso",	JOptionPane.INFORMATION_MESSAGE);
				jtfCNPJ.requestFocus();
			} else if (jtfNomeFantasia.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar nome Fantasia!!!", "Aviso",	JOptionPane.INFORMATION_MESSAGE);
				jtfNomeFantasia.requestFocus();
			} else if ((jtfInscricaoEstadual.getText().equals("")) && (!jckbxIsento.isSelected())) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar a inscrição estadual!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfInscricaoEstadual.requestFocus();
			} else if (jtfEmail.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar o email!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfEmail.requestFocus();
			} else if (jtfEndereco.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar o endereço!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfEndereco.requestFocus();
			} else if (jtfNumero.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Obrigatório informar o número!!!\n (Residência/Estabelecimento Comercial)", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfNumero.requestFocus();
			} else if (jtfBairro.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar o bairro!!!", "Aviso",	JOptionPane.INFORMATION_MESSAGE);
				jtfBairro.requestFocus();
			} else if (jtfNomeCidade.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar uma cidade!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfNomeCidade.requestFocus();
			} else {
			//Tipo de pessoa igual a 1 é Física 2 Jurídica
			this.cliente = new Cliente();
			this.cliente.setTipoPessoa(2);
			this.cliente.setEmail(jtfEmail.getText());
			this.cliente.setTelefoneCelular(jtfTelefoneCelular.getText());
			this.cliente.setTelefoneComercial(jtfTelefoneComercial.getText());
			this.cliente.setTelefoneResidencial(jtfTelefoneResidencial.getText());
			this.cliente.setEndereco(jtfEndereco.getText());
			this.cliente.setNumero(Integer.valueOf(jtfNumero.getText()));
			this.cliente.setBairro(jtfBairro.getText());
			this.cliente.setForaUso(Boolean.valueOf(jckbxForaUso.isSelected()));
			this.cliente.setDataAltercacao(Date.valueOf(cliente.getDataAltercacao().now()).toLocalDate());
			this.cliente.setCidade(new Cidade(Integer.valueOf(jtfCodigoCidade.getText()), null));
			this.cliente.setEmpresa(new Empresa(1));
			DaoFactory.getFactory().clienteDao().inserir(cliente);
			jtfCodigoCliente.setText(String.valueOf(this.cliente.getIdCliente()));
			this.pessoaJuridica = new PessoaJuridica();
			this.pessoaJuridica.setRazaoSocial(jtfRazaoSocial.getText());
			this.pessoaJuridica.setNomeFantasia(jtfNomeFantasia.getText());
			this.pessoaJuridica.setCnpj(jtfCNPJ.getText());
			if(jckbxIsento.isSelected()) {
				jtfInscricaoEstadual.setText("ISENTO");
			}
			this.pessoaJuridica.setInscricaoEstadual(jtfInscricaoEstadual.getText());
			this.pessoaJuridica.setInscricaoMunicipal(jtfInscricaoMunicipal.getText());
			this.pessoaJuridica.setIdCliente(Integer.valueOf(jtfCodigoCliente.getText()));
			DaoFactory.getFactory().pessoaJuridicaDao().inserir(pessoaJuridica);
			jtfDataAlteracao.setText(this.cliente.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
			JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!!!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			jcbxTipoPessoa.setEnabled(false);
			jckbxIsento.setEnabled(false);
			jtfNomeCliente.setEnabled(false);
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
	}
	
	@SuppressWarnings("static-access")
	public void salvarEdicaoCliente() throws RegistroExistente {
		if (jcbxTipoPessoa.getSelectedIndex() == 0) {
			if (jtfNomeCliente.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar nome do cliente!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfNomeCliente.requestFocus();
			} else if (jtfCPF.getText().equals("   .   .   -  ")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar o CPF do cliente!!!", "Aviso",	JOptionPane.INFORMATION_MESSAGE);
				jtfCPF.requestFocus();
			} else if (jtfEmail.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar o email!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfEmail.requestFocus();
			} else if (jtfEndereco.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar o endereço!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfEndereco.requestFocus();
			} else if (jtfNumero.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Obrigatório informar o número!!!\n (Residência/Estabelecimento Comercial)", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfNumero.requestFocus();
			} else if (jtfBairro.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar o bairro!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfBairro.requestFocus();
			} else if (jtfNomeCidade.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar uma cidade!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfNomeCidade.requestFocus();
			} else {
				//Tipo de pessoa igual a 1 é Física 2 Jurídica
				this.cliente = new Cliente();
				this.cliente.setTipoPessoa(1);
				this.cliente.setEmail(jtfEmail.getText());
				this.cliente.setTelefoneCelular(jtfTelefoneCelular.getText());
				this.cliente.setTelefoneComercial(jtfTelefoneComercial.getText());
				this.cliente.setTelefoneResidencial(jtfTelefoneResidencial.getText());
				this.cliente.setEndereco(jtfEndereco.getText());
				this.cliente.setNumero(Integer.valueOf(jtfNumero.getText()));
				this.cliente.setBairro(jtfBairro.getText());
				this.cliente.setForaUso(Boolean.valueOf(jckbxForaUso.isSelected()));
				this.cliente.setDataAltercacao(Date.valueOf(cliente.getDataAltercacao().now()).toLocalDate());
				this.cliente.setCidade(new Cidade(Integer.valueOf(jtfCodigoCidade.getText()), null));
				this.cliente.setIdCliente(Integer.valueOf(jtfCodigoCliente.getText()));
				DaoFactory.getFactory().clienteDao().alterar(cliente);
				this.pessoaFisica = new PessoaFisica();
				this.pessoaFisica.setNome(jtfNomeCliente.getText());
				this.pessoaFisica.setCpf(jtfCPF.getText());
				this.pessoaFisica.setRg(jtfRG.getText());
				this.pessoaFisica.setIdCliente(Integer.valueOf(jtfCodigoCliente.getText()));
				DaoFactory.getFactory().pessoaFisicaDao().alterar(pessoaFisica);
				jtfDataAlteracao.setText(this.cliente.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
				JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!!!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
				jcbxTipoPessoa.setEnabled(false);
				jckbxIsento.setEnabled(false);
				jtfNomeCliente.setEnabled(false);
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
				jtfEndereco.setEnabled(false);
				jtfNumero.setEnabled(false);
				jtfBairro.setEnabled(false);
				jtfNomeCidade.setEnabled(false);
				jbtSalvar.setEnabled(false);
				jbtEditar.setEnabled(true);
				jbtNovo.setEnabled(true);
				jbtCancelar.setEnabled(false);
			}
		} else if (jcbxTipoPessoa.getSelectedIndex() == 1) {
			if (jtfRazaoSocial.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar a Razão Social!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfRazaoSocial.requestFocus();
			} else if (jtfCNPJ.getText().equals("  .   .   /    -  ")) {
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
				JOptionPane.showMessageDialog(null,"Obrigatório informar o número!!!\n (Residência/Estabelecimento Comercial)", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfNumero.requestFocus();
			} else if (jtfBairro.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar o bairro!!!", "Aviso",	JOptionPane.INFORMATION_MESSAGE);
				jtfBairro.requestFocus();
			} else if (jtfNomeCidade.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Obrigatório informar uma cidade!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				jtfNomeCidade.requestFocus();
			} else {
			//Tipo de pessoa igual a 1 é Física 2 Jurídica
			this.cliente = new Cliente();
			this.cliente.setTipoPessoa(2);
			this.cliente.setEmail(jtfEmail.getText());
			this.cliente.setTelefoneCelular(jtfTelefoneCelular.getText());
			this.cliente.setTelefoneComercial(jtfTelefoneComercial.getText());
			this.cliente.setTelefoneResidencial(jtfTelefoneResidencial.getText());
			this.cliente.setEndereco(jtfEndereco.getText());
			this.cliente.setNumero(Integer.valueOf(jtfNumero.getText()));
			this.cliente.setBairro(jtfBairro.getText());
			this.cliente.setForaUso(Boolean.valueOf(jckbxForaUso.isSelected()));
			this.cliente.setDataAltercacao(Date.valueOf(cliente.getDataAltercacao().now()).toLocalDate());
			this.cliente.setCidade(new Cidade(Integer.valueOf(jtfCodigoCidade.getText()), null));
			this.cliente.setIdCliente(Integer.valueOf(jtfCodigoCliente.getText()));
			DaoFactory.getFactory().clienteDao().alterar(cliente);
			this.pessoaJuridica = new PessoaJuridica();
			this.pessoaJuridica.setRazaoSocial(jtfRazaoSocial.getText());
			this.pessoaJuridica.setNomeFantasia(jtfNomeFantasia.getText());
			this.pessoaJuridica.setCnpj(jtfCNPJ.getText());
			this.pessoaJuridica.setInscricaoEstadual(jtfInscricaoEstadual.getText());
			this.pessoaJuridica.setInscricaoMunicipal(jtfInscricaoMunicipal.getText());
			this.pessoaJuridica.setIdCliente(Integer.valueOf(jtfCodigoCliente.getText()));
			DaoFactory.getFactory().pessoaJuridicaDao().alterar(pessoaJuridica);
			jtfDataAlteracao.setText(this.cliente.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
			JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!!!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			jcbxTipoPessoa.setEnabled(false);
			jckbxIsento.setEnabled(false);
			jtfNomeCliente.setEnabled(false);
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
	}
	
	public void acionarBotaoEditar() {
		if(jcbxTipoPessoa.getSelectedIndex() == 0) {
			this.selecionarTipoPessoa();
			jtfNomeCliente.requestFocus();
			jcbxTipoPessoa.setEnabled(true);
			jckbxForaUso.setEnabled(true);
			jtfNomeCliente.setEnabled(true);
			jtfCPF.setEnabled(true);
			jtfRG.setEnabled(true);
			jckbxIsento.setEnabled(false);
			jckbxIsento.setSelected(false);
			jtfRazaoSocial.setEnabled(false);
			jtfNomeFantasia.setEnabled(false);
			jtfCNPJ.setEnabled(false);
			jtfInscricaoEstadual.setEnabled(false);
			jtfInscricaoMunicipal.setEnabled(false);
			jtfEmail.setEnabled(true);
			jtfTelefoneCelular.setEnabled(true);
			jtfTelefoneComercial.setEnabled(true);
			jtfTelefoneResidencial.setEnabled(true);
			jtfEndereco.setEnabled(true);
			jtfNumero.setEnabled(true);
			jtfBairro.setEnabled(true);
			jtfNomeCidade.setEnabled(true);
			jtfNomeCidade.setEnabled(true);
			jbtNovo.setEnabled(false);
			jbtSalvar.setEnabled(true);
			jbtCancelar.setEnabled(true);
		} else {
			this.selecionarTipoPessoa();
			jtfRazaoSocial.requestFocus();
			jtfNomeCliente.setEnabled(false);
			jtfCPF.setEnabled(false);
			jtfRG.setEnabled(false);
			jckbxIsento.setEnabled(true);
			jckbxForaUso.setEnabled(true);
			jtfRazaoSocial.setEnabled(true);
			jtfNomeFantasia.setEnabled(true);
			jtfCNPJ.setEnabled(true);
			jtfInscricaoEstadual.setEnabled(true);
			jtfInscricaoMunicipal.setEnabled(true);
			jcbxTipoPessoa.setEnabled(true);
			jtfEmail.setEnabled(true);
			jtfTelefoneCelular.setEnabled(true);
			jtfTelefoneComercial.setEnabled(true);
			jtfTelefoneResidencial.setEnabled(true);
			jtfEndereco.setEnabled(true);
			jtfNumero.setEnabled(true);
			jtfBairro.setEnabled(true);
			jtfNomeCidade.setEnabled(true);
			jtfNomeCidade.setEnabled(true);
			jbtNovo.setEnabled(false);
			jbtSalvar.setEnabled(true);
			jbtCancelar.setEnabled(true);
		}
	}
	
	public void acionarBotaoCancelar() {
		jtfPesquisaCodigoCliente.requestFocus();
		jcbxTipoPessoa.setEnabled(false);
		jcbxTipoPessoa.setSelectedIndex(0);
		jckbxForaUso.setSelected(false);
		jckbxIsento.setEnabled(false);
		jckbxIsento.setSelected(false);
		jtfNomeCliente.setEnabled(false);
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
		jtfEndereco.setEnabled(false);
		jtfNumero.setEnabled(false);
		jtfBairro.setEnabled(false);
		jtfNomeCidade.setEnabled(false);
		jtfCodigoCliente.setText("");
		jtfNomeCliente.setText("");
		jtfCPF.setText("");
		jtfRG.setText("");
		jtfRazaoSocial.setText("");
		jtfNomeFantasia.setText("");
		jtfCNPJ.setText("");
		jtfInscricaoEstadual.setText("");
		jtfInscricaoMunicipal.setText("");
		jtfEmail.setText("");
		jtfTelefoneCelular.setText("");
		jtfTelefoneComercial.setText("");
		jtfTelefoneResidencial.setText("");
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
		if(cliente.getTipoPessoa() == 1) {
			jcbxTipoPessoa.setSelectedIndex(0);
		} else {
			jcbxTipoPessoa.setSelectedIndex(1);
		}
		jtfEndereco.setText(cliente.getEndereco());
		jtfBairro.setText(cliente.getBairro());
		jtfNumero.setText(String.valueOf(cliente.getNumero()));
		jtfTelefoneCelular.setText(cliente.getTelefoneCelular());
		jtfTelefoneComercial.setText(cliente.getTelefoneComercial());
		jtfTelefoneResidencial.setText(cliente.getTelefoneResidencial());
		jtfEmail.setText(cliente.getEmail());
		if(cliente.isForaUso()) {
			jckbxForaUso.setSelected(true);
		} else {
			jckbxForaUso.setSelected(false);
		}
		jtfDataAlteracao.setText(cliente.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
		jtfCodigoCidade.setText(String.valueOf(cliente.getCidade().getIdCidade()));
		jtfNomeCidade.setText(cliente.getCidade().getNome());
		jtfCodigoUF.setText(String.valueOf(cliente.getCidade().getUnidadeFederativa().getIdUnidadeFederativa()));
		jtfNomeUF.setText(cliente.getCidade().getUnidadeFederativa().getNome());
		jtfNomePais.setText(cliente.getCidade().getUnidadeFederativa().getPais().getNome());
		jtfNomeCliente.setText(cliente.getPessoaFisica().getNome());
		jtfCPF.setText(cliente.getPessoaFisica().getCpf());
		jtfRG.setText(cliente.getPessoaFisica().getRg());
		jtfRazaoSocial.setText(cliente.getPessoaJuridica().getRazaoSocial());
		jtfNomeFantasia.setText(cliente.getPessoaJuridica().getNomeFantasia());
		jtfCNPJ.setText(cliente.getPessoaJuridica().getCnpj());
		jtfInscricaoEstadual.setText(cliente.getPessoaJuridica().getInscricaoEstadual());
		jtfInscricaoMunicipal.setText(cliente.getPessoaJuridica().getInscricaoMunicipal());
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
						jtfCPF.setEnabled(false);
						jtfRG.setEnabled(false);
						jtfCodigoCliente.setText("");
						jtfNomeCliente.setText("");
						jtfCPF.setText("");
						jtfRG.setText("");
						jckbxIsento.setEnabled(true);
						jckbxIsento.setSelected(false);
						jtfRazaoSocial.setEnabled(true);
						jtfNomeFantasia.setEnabled(true);
						jtfCNPJ.setEnabled(true);
						jtfInscricaoEstadual.setEnabled(true);
						jtfInscricaoMunicipal.setEnabled(true);
					} else {
						jtfNomeCliente.setEnabled(true);
						jtfCPF.setEnabled(true);
						jtfRG.setEnabled(true);
						jckbxIsento.setEnabled(false);
						jckbxIsento.setSelected(false);
						jtfRazaoSocial.setEnabled(false);
						jtfNomeFantasia.setEnabled(false);
						jtfCNPJ.setEnabled(false);
						jtfInscricaoEstadual.setEnabled(false);
						jtfInscricaoMunicipal.setEnabled(false);
						jtfRazaoSocial.setText("");
						jtfNomeFantasia.setText("");
						jtfCNPJ.setText("");
						jtfInscricaoEstadual.setText("");
						jtfInscricaoMunicipal.setText("");
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
						try {
							salvarEdicaoCliente();
						} catch (RegistroExistente salvarEdicao) {
							JOptionPane.showMessageDialog(clienteForm, salvarEdicao.documentoJaExiste(), "Atenção", JOptionPane.WARNING_MESSAGE);
						}
					} else {
						try {
							salvarCadastroCliente();
						} catch (RegistroExistente salvarCadastro) {
							JOptionPane.showMessageDialog(clienteForm, salvarCadastro.documentoJaExiste(), "Atenção", JOptionPane.WARNING_MESSAGE);
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
		jtfPesquisaCodigoCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						Integer codigo = null;
						if(!jtfPesquisaCodigoCliente.getText().equals("")) {
							codigo = Integer.valueOf(jtfPesquisaCodigoCliente.getText());
						}
						ListaClienteForm listaCliente = new ListaClienteForm(clienteForm, codigo, null, null, null);
						listaCliente.setVisible(true);
						jcbxTipoPessoa.setEnabled(false);
						jcbxTipoPessoa.setSelectedIndex(0);
						jckbxForaUso.setSelected(false);
						jckbxIsento.setEnabled(false);
						jckbxIsento.setSelected(false);
						jtfNomeCliente.setEnabled(false);
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
						jtfEndereco.setEnabled(false);
						jtfNumero.setEnabled(false);
						jtfBairro.setEnabled(false);
						jtfNomeCidade.setEnabled(false);
						jtfCodigoCliente.setText("");
						jtfNomeCliente.setText("");
						jtfCPF.setText("");
						jtfRG.setText("");
						jtfRazaoSocial.setText("");
						jtfNomeFantasia.setText("");
						jtfCNPJ.setText("");
						jtfInscricaoEstadual.setText("");
						jtfInscricaoMunicipal.setText("");
						jtfEmail.setText("");
						jtfTelefoneCelular.setText("");
						jtfTelefoneComercial.setText("");
						jtfTelefoneResidencial.setText("");
						jtfEndereco.setText("");
						jtfNumero.setText("");
						jtfBairro.setText("");
						jtfCodigoUF.setText("");
						jtfNomeUF.setText("");
						jtfNomeCidade.setText("");
						jtfCodigoCidade.setText("");
						jtfNomePais.setText("");
						jtfDataAlteracao.setText("");
						jtfPesquisaCodigoCliente.setText("");
						jtfPesquisaNomeCliente.setText("");
						jtfPesquisaCnpjCliente.setText("");
						jtfPesquisaCPFCliente.setText("");
						jbtEditar.setEnabled(true);
						jbtSalvar.setEnabled(false);
						jbtCancelar.setEnabled(true);
					} catch (RegistroNotExistente e) {
						JOptionPane.showMessageDialog(clienteForm, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
						jtfPesquisaCodigoCliente.setText("");
					}
				}
			}
		});
	}
	
	public void pesquisaPorNome() {
		jtfPesquisaNomeCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						ListaClienteForm listaCliente = new ListaClienteForm(clienteForm, null, jtfPesquisaNomeCliente.getText(), null, null);
						listaCliente.setVisible(true);
						jcbxTipoPessoa.setEnabled(false);
						jcbxTipoPessoa.setSelectedIndex(0);
						jckbxForaUso.setSelected(false);
						jckbxIsento.setEnabled(false);
						jckbxIsento.setSelected(false);
						jtfNomeCliente.setEnabled(false);
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
						jtfEndereco.setEnabled(false);
						jtfNumero.setEnabled(false);
						jtfBairro.setEnabled(false);
						jtfNomeCidade.setEnabled(false);
						jtfCodigoCliente.setText("");
						jtfNomeCliente.setText("");
						jtfCPF.setText("");
						jtfRG.setText("");
						jtfRazaoSocial.setText("");
						jtfNomeFantasia.setText("");
						jtfCNPJ.setText("");
						jtfInscricaoEstadual.setText("");
						jtfInscricaoMunicipal.setText("");
						jtfEmail.setText("");
						jtfTelefoneCelular.setText("");
						jtfTelefoneComercial.setText("");
						jtfTelefoneResidencial.setText("");
						jtfEndereco.setText("");
						jtfNumero.setText("");
						jtfBairro.setText("");
						jtfCodigoUF.setText("");
						jtfNomeUF.setText("");
						jtfNomeCidade.setText("");
						jtfCodigoCidade.setText("");
						jtfNomePais.setText("");
						jtfDataAlteracao.setText("");
						jtfPesquisaCodigoCliente.setText("");
						jtfPesquisaNomeCliente.setText("");
						jtfPesquisaCnpjCliente.setText("");
						jtfPesquisaCPFCliente.setText("");
						jbtEditar.setEnabled(true);
						jbtSalvar.setEnabled(false);
						jbtCancelar.setEnabled(true);
					} catch (RegistroNotExistente e) {
						JOptionPane.showMessageDialog(clienteForm, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
						jtfPesquisaNomeCliente.setText("");
					}
				}
			}
		});
	}
	
	public void pesquisaPorCNPJ() {
		jtfPesquisaCnpjCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						ListaClienteForm listaCliente = new ListaClienteForm(clienteForm, null, null, jtfPesquisaCnpjCliente.getText(), null);
						listaCliente.setVisible(true);
						jcbxTipoPessoa.setEnabled(false);
						jcbxTipoPessoa.setSelectedIndex(0);
						jckbxForaUso.setSelected(false);
						jckbxIsento.setEnabled(false);
						jckbxIsento.setSelected(false);
						jtfNomeCliente.setEnabled(false);
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
						jtfEndereco.setEnabled(false);
						jtfNumero.setEnabled(false);
						jtfBairro.setEnabled(false);
						jtfNomeCidade.setEnabled(false);
						jtfCodigoCliente.setText("");
						jtfNomeCliente.setText("");
						jtfCPF.setText("");
						jtfRG.setText("");
						jtfRazaoSocial.setText("");
						jtfNomeFantasia.setText("");
						jtfCNPJ.setText("");
						jtfInscricaoEstadual.setText("");
						jtfInscricaoMunicipal.setText("");
						jtfEmail.setText("");
						jtfTelefoneCelular.setText("");
						jtfTelefoneComercial.setText("");
						jtfTelefoneResidencial.setText("");
						jtfEndereco.setText("");
						jtfNumero.setText("");
						jtfBairro.setText("");
						jtfCodigoUF.setText("");
						jtfNomeUF.setText("");
						jtfNomeCidade.setText("");
						jtfCodigoCidade.setText("");
						jtfNomePais.setText("");
						jtfDataAlteracao.setText("");
						jtfPesquisaCodigoCliente.setText("");
						jtfPesquisaNomeCliente.setText("");
						jtfPesquisaCnpjCliente.setText("");
						jtfPesquisaCPFCliente.setText("");
						jbtEditar.setEnabled(true);
						jbtSalvar.setEnabled(false);
						jbtCancelar.setEnabled(true);
					} catch (RegistroNotExistente e) {
						JOptionPane.showMessageDialog(clienteForm, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
						jtfPesquisaCnpjCliente.setText("");
					}
				}
			}
		});
	}
	
	public void pesquisaPorCPF() {
		jtfPesquisaCPFCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						ListaClienteForm listaCliente = new ListaClienteForm(clienteForm, null, null, null, jtfPesquisaCPFCliente.getText());
						listaCliente.setVisible(true);
						jcbxTipoPessoa.setEnabled(false);
						jcbxTipoPessoa.setSelectedIndex(0);
						jckbxForaUso.setSelected(false);
						jckbxIsento.setEnabled(false);
						jckbxIsento.setSelected(false);
						jtfNomeCliente.setEnabled(false);
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
						jtfEndereco.setEnabled(false);
						jtfNumero.setEnabled(false);
						jtfBairro.setEnabled(false);
						jtfNomeCidade.setEnabled(false);
						jtfCodigoCliente.setText("");
						jtfNomeCliente.setText("");
						jtfCPF.setText("");
						jtfRG.setText("");
						jtfRazaoSocial.setText("");
						jtfNomeFantasia.setText("");
						jtfCNPJ.setText("");
						jtfInscricaoEstadual.setText("");
						jtfInscricaoMunicipal.setText("");
						jtfEmail.setText("");
						jtfTelefoneCelular.setText("");
						jtfTelefoneComercial.setText("");
						jtfTelefoneResidencial.setText("");
						jtfEndereco.setText("");
						jtfNumero.setText("");
						jtfBairro.setText("");
						jtfCodigoUF.setText("");
						jtfNomeUF.setText("");
						jtfNomeCidade.setText("");
						jtfCodigoCidade.setText("");
						jtfNomePais.setText("");
						jtfDataAlteracao.setText("");
						jtfPesquisaCodigoCliente.setText("");
						jtfPesquisaNomeCliente.setText("");
						jtfPesquisaCnpjCliente.setText("");
						jtfPesquisaCPFCliente.setText("");
						jbtEditar.setEnabled(true);
						jbtSalvar.setEnabled(false);
						jbtCancelar.setEnabled(true);
					} catch (RegistroNotExistente e) {
						JOptionPane.showMessageDialog(clienteForm, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
						jtfPesquisaCPFCliente.setText("");
					}
				}
			}
		});
	}
	
	public void pesquisaCidade() {
		jtfNomeCidade.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						ListaCidadeUFPaisForm listaCidadeUFPaisForm = new ListaCidadeUFPaisForm(clienteForm, jtfNomeCidade.getText());
						listaCidadeUFPaisForm.setVisible(true);
						jtfCodigoCidade.setText("");
						jtfNomeCidade.setText("");
						jtfCodigoUF.setText("");
						jtfNomeUF.setText("");
						jtfNomePais.setText("");
					} catch (RegistroNotExistente e) {
						JOptionPane.showMessageDialog(clienteForm, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
						jtfNomeCidade.setText("");
					}
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
		setBounds(100, 100, 753, 519);
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
		if(entidade instanceof Cidade) {
			this.preencherCamposCidadeUFPais((Cidade)entidade);
		} else if(entidade instanceof Cliente) {
			this.preencherCamposCliente((Cliente)entidade);
		}
	}
}