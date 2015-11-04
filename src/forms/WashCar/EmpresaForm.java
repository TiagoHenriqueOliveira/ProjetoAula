package forms.WashCar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.text.MaskFormatter;

import daoFactory.WashCar.DaoFactory;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.time.format.DateTimeFormatter;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

import model.WashCar.Cidade;
import model.WashCar.Empresa;
import model.WashCar.Entidade;
import preencherDados.WashCar.PreencherDados;
import validacaoCampos.WashCar.ValidaCampoAlfaNumerico;
import validacaoCampos.WashCar.ValidaCampoDocumentoJuridico;
import validacaoCampos.WashCar.ValidaCampoNumeroInteiro;
import validacaoCampos.WashCar.ValidaCampoString;
import validacaoCampos.WashCar.ValidaCampoTelefone;

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class EmpresaForm extends JFrame implements PreencherDados{

	private static final long serialVersionUID = 1L;
	private JPanel jnpEmpresa;
	private JTextField jtfPesquisaCodigoEmpresa;
	private JTextField jtfPesquisaNomeEmpresa;
	private JTextField jtfCodigo;
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
	private JTextField jtfPesquisaCNPJEmpresa;
	private JTextField jtfInscricaoMunicipal;
	private JTextField jtfNomeUF;
	private JTextField jtfEmail;
	private JTextField jtfCodigoUF;
	private JTextField jtfCodigoCidade;
	private JPanel jpnPesquisaEmpresa;
	private JLabel jlbPesquisaCodigoEmpresa;
	private JLabel jlbPesquisaNomeEmpresa;
	private JLabel jlbPesquisaCNPJEmpresa;
	private JLabel jlbCodigo;
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
	private JLabel jlbRegimeTributario;
	private JLabel jlbUnidadeFederativa;
	private JLabel jlbInscricaoMunicipal;
	private JLabel jlbConsultaEmpresa;
	private JLabel jlbEmailEmpresa;
	private JLabel jlbCodigoCidade;
	private JLabel jlbCodigoUF;
	private JButton jbtNovo;
	private JButton jbtEditar;
	private JButton jbtSalvar;
	private JButton jbtCancelar;
	private JButton jbtFechar;
	private JComboBox<String> jcbxRegimeTributario;
	private JCheckBox jckbxForaUso;
	private JCheckBox jckbxIsento;
	private static EmpresaForm empresaForm;
	private Empresa empresa;
	private Integer regimeTributario = null;

	public void componentesTelaEmpresa() {
		jpnPesquisaEmpresa = new JPanel();
		jpnPesquisaEmpresa.setLayout(null);
		jpnPesquisaEmpresa.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnPesquisaEmpresa.setBounds(10, 11, 615, 85);
		jnpEmpresa.add(jpnPesquisaEmpresa);
		
		jlbPesquisaCodigoEmpresa = new JLabel("C\u00F3digo");
		jlbPesquisaCodigoEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaCodigoEmpresa.setBounds(10, 38, 66, 14);
		jpnPesquisaEmpresa.add(jlbPesquisaCodigoEmpresa);
		
		jtfPesquisaCodigoEmpresa = new JTextField();
		jtfPesquisaCodigoEmpresa.setDocument(new ValidaCampoNumeroInteiro());
		jtfPesquisaCodigoEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaCodigoEmpresa.setColumns(10);
		jtfPesquisaCodigoEmpresa.setBounds(10, 54, 50, 20);
		jpnPesquisaEmpresa.add(jtfPesquisaCodigoEmpresa);
		
		jlbPesquisaNomeEmpresa = new JLabel("Nome da Empresa");
		jlbPesquisaNomeEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaNomeEmpresa.setBounds(86, 38, 275, 14);
		jpnPesquisaEmpresa.add(jlbPesquisaNomeEmpresa);
		
		jtfPesquisaNomeEmpresa = new JTextField();
		jtfPesquisaNomeEmpresa.setDocument(new ValidaCampoString());
		jtfPesquisaNomeEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaNomeEmpresa.setColumns(10);
		jtfPesquisaNomeEmpresa.setBounds(86, 54, 275, 20);
		jpnPesquisaEmpresa.add(jtfPesquisaNomeEmpresa);
		
		try {
			jtfPesquisaCNPJEmpresa = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfPesquisaCNPJEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaCNPJEmpresa.setColumns(10);
		jtfPesquisaCNPJEmpresa.setBounds(371, 54, 165, 20);
		jpnPesquisaEmpresa.add(jtfPesquisaCNPJEmpresa);
		
		jlbPesquisaCNPJEmpresa = new JLabel("CNPJ da Empresa");
		jlbPesquisaCNPJEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaCNPJEmpresa.setBounds(371, 38, 165, 14);
		jpnPesquisaEmpresa.add(jlbPesquisaCNPJEmpresa);
		
		jlbConsultaEmpresa = new JLabel("Consulta Cadastro da Empresa");
		jlbConsultaEmpresa.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbConsultaEmpresa.setBounds(10, 13, 200, 14);
		jpnPesquisaEmpresa.add(jlbConsultaEmpresa);
		
		jlbCodigo = new JLabel("C\u00F3digo");
		jlbCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigo.setBounds(10, 109, 66, 14);
		jnpEmpresa.add(jlbCodigo);
		
		jtfCodigo = new JTextField();
		jtfCodigo.setEditable(false);
		jtfCodigo.setBackground(Color.YELLOW);
		jtfCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigo.setColumns(10);
		jtfCodigo.setBounds(10, 123, 50, 20);
		jnpEmpresa.add(jtfCodigo);
		
		jlbRazaoSocial = new JLabel("Raz\u00E3o Social da Empresa");
		jlbRazaoSocial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbRazaoSocial.setBounds(10, 154, 300, 14);
		jnpEmpresa.add(jlbRazaoSocial);
		
		jtfRazaoSocial = new JTextField();
		jtfRazaoSocial.setDocument(new ValidaCampoString());
		jtfRazaoSocial.setEnabled(false);
		jtfRazaoSocial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfRazaoSocial.setColumns(10);
		jtfRazaoSocial.setBounds(10, 168, 300, 20);
		jnpEmpresa.add(jtfRazaoSocial);
		
		jlbNomeFantasia = new JLabel("Nome Fantasia da Empresa");
		jlbNomeFantasia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeFantasia.setBounds(320, 154, 300, 14);
		jnpEmpresa.add(jlbNomeFantasia);
		
		jtfNomeFantasia = new JTextField();
		jtfNomeFantasia.setDocument(new ValidaCampoString());
		jtfNomeFantasia.setEnabled(false);
		jtfNomeFantasia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeFantasia.setColumns(10);
		jtfNomeFantasia.setBounds(320, 168, 300, 20);
		jnpEmpresa.add(jtfNomeFantasia);
		
		jlbCNPJ = new JLabel("CNPJ");
		jlbCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCNPJ.setBounds(10, 199, 125, 14);
		jnpEmpresa.add(jlbCNPJ);
		
		try {
			jtfCNPJ= new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfCNPJ.setEnabled(false);
		jtfCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCNPJ.setColumns(10);
		jtfCNPJ.setBounds(10, 213, 125, 20);
		jnpEmpresa.add(jtfCNPJ);
		
		jlbEndereco = new JLabel("Endere\u00E7o");
		jlbEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbEndereco.setBounds(10, 250, 177, 14);
		jnpEmpresa.add(jlbEndereco);
		
		jtfEndereco = new JTextField();
		jtfEndereco.setDocument(new ValidaCampoString());
		jtfEndereco.setEnabled(false);
		jtfEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfEndereco.setColumns(10);
		jtfEndereco.setBounds(10, 264, 250, 20);
		jnpEmpresa.add(jtfEndereco);
		
		jlbBairro = new JLabel("Bairro");
		jlbBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbBairro.setBounds(346, 250, 139, 14);
		jnpEmpresa.add(jlbBairro);
		
		jtfBairro = new JTextField();
		jtfBairro.setDocument(new ValidaCampoString());
		jtfBairro.setEnabled(false);
		jtfBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfBairro.setColumns(10);
		jtfBairro.setBounds(346, 264, 139, 20);
		jnpEmpresa.add(jtfBairro);
		
		jlbNumero = new JLabel("N\u00FAmero");
		jlbNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNumero.setBounds(270, 250, 66, 14);
		jnpEmpresa.add(jlbNumero);
		
		jtfNumero = new JTextField();
		jtfNumero.setDocument(new ValidaCampoNumeroInteiro());
		jtfNumero.setEnabled(false);
		jtfNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNumero.setColumns(10);
		jtfNumero.setBounds(270, 264, 66, 20);
		jnpEmpresa.add(jtfNumero);
		
		jlbTelefoneComercial = new JLabel("Telefone Comercial");
		jlbTelefoneComercial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneComercial.setBounds(495, 199, 130, 14);
		jnpEmpresa.add(jlbTelefoneComercial);
		
		jtfTelefoneComercial = new JTextField();
		jtfTelefoneComercial.setDocument(new ValidaCampoTelefone());
		jtfTelefoneComercial.setEnabled(false);
		jtfTelefoneComercial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneComercial.setColumns(10);
		jtfTelefoneComercial.setBounds(495, 213, 130, 20);
		jnpEmpresa.add(jtfTelefoneComercial);
		
		jlbTelefoneCelular = new JLabel("Telefone Celular");
		jlbTelefoneCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneCelular.setBounds(495, 250, 130, 14);
		jnpEmpresa.add(jlbTelefoneCelular);
		
		jtfTelefoneCelular = new JTextField();
		jtfTelefoneCelular.setDocument(new ValidaCampoTelefone());
		jtfTelefoneCelular.setEnabled(false);
		jtfTelefoneCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneCelular.setColumns(10);
		jtfTelefoneCelular.setBounds(495, 264, 130, 20);
		jnpEmpresa.add(jtfTelefoneCelular);
		
		jlbFax = new JLabel("Fax");
		jlbFax.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbFax.setBounds(495, 300, 130, 14);
		jnpEmpresa.add(jlbFax);
		
		jtfFax = new JTextField();
		jtfFax.setDocument(new ValidaCampoTelefone());
		jtfFax.setEnabled(false);
		jtfFax.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfFax.setColumns(10);
		jtfFax.setBounds(495, 314, 130, 20);
		jnpEmpresa.add(jtfFax);
		
		jlbInscricaoEstadual = new JLabel("Inscri\u00E7\u00E3o Estadual");
		jlbInscricaoEstadual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbInscricaoEstadual.setBounds(145, 199, 130, 14);
		jnpEmpresa.add(jlbInscricaoEstadual);
		
		jtfInscricaoEstadual = new JTextField();
		jtfInscricaoEstadual.setDocument(new ValidaCampoDocumentoJuridico());
		jtfInscricaoEstadual.setEnabled(false);
		jtfInscricaoEstadual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfInscricaoEstadual.setColumns(10);
		jtfInscricaoEstadual.setBounds(145, 213, 100, 20);
		jnpEmpresa.add(jtfInscricaoEstadual);
		
		jlbDataAlteracao = new JLabel("Data Alteracao");
		jlbDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataAlteracao.setBounds(525, 109, 100, 14);
		jnpEmpresa.add(jlbDataAlteracao);
		
		try {
			jtfDataAlteracao = new JFormattedTextField(new MaskFormatter("##/##/####"));
			jtfDataAlteracao.setHorizontalAlignment(SwingConstants.RIGHT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfDataAlteracao.setBackground(Color.YELLOW);
		jtfDataAlteracao.setEditable(false);
		jtfDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfDataAlteracao.setColumns(10);
		jtfDataAlteracao.setBounds(525, 123, 75, 20);
		jnpEmpresa.add(jtfDataAlteracao);
		
		jlbCidade = new JLabel("Cidade");
		jlbCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCidade.setBounds(10, 345, 139, 14);
		jnpEmpresa.add(jlbCidade);
		
		jtfNomeCidade = new JTextField();
		jtfNomeCidade.setDocument(new ValidaCampoAlfaNumerico());
		jtfNomeCidade.setEnabled(false);
		jtfNomeCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeCidade.setColumns(10);
		jtfNomeCidade.setBounds(10, 360, 140, 20);
		jnpEmpresa.add(jtfNomeCidade);
		
		jlbPais = new JLabel("Pa\u00EDs");
		jlbPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPais.setBounds(515, 345, 110, 14);
		jnpEmpresa.add(jlbPais);
		
		jtfNomePais = new JTextField();
		jtfNomePais.setDocument(new ValidaCampoAlfaNumerico());
		jtfNomePais.setEnabled(false);
		jtfNomePais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomePais.setColumns(10);
		jtfNomePais.setBounds(515, 360, 110, 20);
		jnpEmpresa.add(jtfNomePais);
		
		jlbRegimeTributario = new JLabel("Regime Tribut\u00E1rio");
		jlbRegimeTributario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbRegimeTributario.setBounds(150, 109, 130, 15);
		jnpEmpresa.add(jlbRegimeTributario);
		
		jlbUnidadeFederativa = new JLabel("Estado");
		jlbUnidadeFederativa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbUnidadeFederativa.setBounds(265, 345, 100, 14);
		jnpEmpresa.add(jlbUnidadeFederativa);
		
		jlbInscricaoMunicipal = new JLabel("Inscri\u00E7\u00E3o Municipal");
		jlbInscricaoMunicipal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbInscricaoMunicipal.setBounds(357, 199, 130, 14);
		jnpEmpresa.add(jlbInscricaoMunicipal);
		
		jtfInscricaoMunicipal = new JTextField();
		jtfInscricaoMunicipal.setDocument(new ValidaCampoDocumentoJuridico());
		jtfInscricaoMunicipal.setEnabled(false);
		jtfInscricaoMunicipal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfInscricaoMunicipal.setColumns(10);
		jtfInscricaoMunicipal.setBounds(357, 213, 100, 20);
		jnpEmpresa.add(jtfInscricaoMunicipal);
		
		jtfNomeUF = new JTextField();
		jtfNomeUF.setDocument(new ValidaCampoAlfaNumerico());
		jtfNomeUF.setEnabled(false);
		jtfNomeUF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeUF.setColumns(10);
		jtfNomeUF.setBounds(265, 360, 130, 20);
		jnpEmpresa.add(jtfNomeUF);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 392, 110, 23);
		jnpEmpresa.add(jbtNovo);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setEnabled(false);
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setBounds(138, 392, 110, 23);
		jnpEmpresa.add(jbtEditar);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setEnabled(false);
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(265, 392, 110, 23);
		jnpEmpresa.add(jbtSalvar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setEnabled(false);
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setBounds(390, 392, 110, 23);
		jnpEmpresa.add(jbtCancelar);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setBounds(515, 392, 110, 23);
		jnpEmpresa.add(jbtFechar);
		
		jtfEmail = new JTextField();
		jtfEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfEmail.setEnabled(false);
		jtfEmail.setColumns(10);
		jtfEmail.setBounds(10, 311, 326, 20);
		jnpEmpresa.add(jtfEmail);
		
		jlbEmailEmpresa = new JLabel("Email");
		jlbEmailEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbEmailEmpresa.setBounds(10, 297, 150, 14);
		jnpEmpresa.add(jlbEmailEmpresa);
		
		jtfCodigoUF = new JTextField();
		jtfCodigoUF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoUF.setEditable(false);
		jtfCodigoUF.setColumns(10);
		jtfCodigoUF.setBackground(Color.YELLOW);
		jtfCodigoUF.setBounds(405, 360, 50, 20);
		jnpEmpresa.add(jtfCodigoUF);
		
		jlbCodigoUF = new JLabel("C\u00F3d. Estado");
		jlbCodigoUF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoUF.setBounds(405, 345, 100, 14);
		jnpEmpresa.add(jlbCodigoUF);
		
		jtfCodigoCidade = new JTextField();
		jtfCodigoCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoCidade.setEditable(false);
		jtfCodigoCidade.setColumns(10);
		jtfCodigoCidade.setBackground(Color.YELLOW);
		jtfCodigoCidade.setBounds(159, 360, 50, 20);
		jnpEmpresa.add(jtfCodigoCidade);
		
		jlbCodigoCidade = new JLabel("C\u00F3d. Cidade");
		jlbCodigoCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoCidade.setBounds(159, 345, 100, 14);
		jnpEmpresa.add(jlbCodigoCidade);
		
		jcbxRegimeTributario = new JComboBox<String>();
		jcbxRegimeTributario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jcbxRegimeTributario.setEnabled(false);
		jcbxRegimeTributario.setBounds(150, 123, 130, 20);
		jcbxRegimeTributario.addItem("Simples Nacional");
		jcbxRegimeTributario.addItem("Lucro Presumido");
		jcbxRegimeTributario.addItem("Lucro Real");
		jnpEmpresa.add(jcbxRegimeTributario);
		
		jckbxForaUso = new JCheckBox("Fora de Uso");
		jckbxForaUso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jckbxForaUso.setEnabled(false);
		jckbxForaUso.setBounds(350, 122, 130, 23);
		jnpEmpresa.add(jckbxForaUso);
		
		jckbxIsento = new JCheckBox("ISENTO");
		jckbxIsento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jckbxIsento.setEnabled(false);
		jckbxIsento.setBounds(251, 212, 100, 23);
		jnpEmpresa.add(jckbxIsento);
	}
	
	public void acionarBotaoNovo() {
		jtfRazaoSocial.requestFocus();
		this.selecionarRegimeTributario();
		jcbxRegimeTributario.setEnabled(true);
		jcbxRegimeTributario.setSelectedIndex(0);
		jckbxForaUso.setSelected(false);
		jckbxIsento.setEnabled(true);
		jckbxIsento.setSelected(false);
		jtfNomeFantasia.setEnabled(true);
		jtfRazaoSocial.setEnabled(true);
		jtfCNPJ.setEnabled(true);
		jtfInscricaoEstadual.setEnabled(true);
		jtfInscricaoMunicipal.setEnabled(true);
		jtfTelefoneCelular.setEnabled(true);
		jtfTelefoneComercial.setEnabled(true);
		jtfFax.setEnabled(true);
		jtfEmail.setEnabled(true);
		jtfEndereco.setEnabled(true);
		jtfNumero.setEnabled(true);
		jtfBairro.setEnabled(true);
		jtfNomeCidade.setEnabled(true);
		jtfCodigo.setText("");
		jtfDataAlteracao.setText("");
		jtfNomeFantasia.setText("");
		jtfRazaoSocial.setText("");
		jtfCNPJ.setText("");
		jtfInscricaoEstadual.setText("");
		jtfInscricaoMunicipal.setText("");
		jtfTelefoneCelular.setText("");
		jtfTelefoneComercial.setText("");
		jtfFax.setText("");
		jtfEmail.setText("");
		jtfEndereco.setText("");
		jtfNumero.setText("");
		jtfBairro.setText("");
		jtfCodigoCidade.setText("");
		jtfNomeCidade.setText("");
		jtfCodigoUF.setText("");
		jtfNomeUF.setText("");
		jtfNomePais.setText("");
		jbtNovo.setEnabled(false);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
		jbtEditar.setEnabled(false);
	}
	
	@SuppressWarnings("static-access")
	public void salvarCadastroEmpresa() throws Exception{
		this.empresa = new Empresa();
		if(jtfRazaoSocial.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar a razão social!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfRazaoSocial.requestFocus();
		} else if(jtfNomeFantasia.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o nome fantasia!!!", 	"Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeFantasia.requestFocus();
		} else if(jtfCNPJ.getText().equals("  .   .   /    -  ")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o Cnpj!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfCNPJ.requestFocus();
		} else if(jtfEndereco.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o endereço!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfEndereco.requestFocus();
		} else if(jtfBairro.getText().equals(""))	 {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o bairro!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfBairro.requestFocus();
		} else if(jtfNumero.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o número do estabelecimento!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNumero.requestFocus();
		} else if(jtfEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o email da empresa!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfEmail.requestFocus();
		} else if(jtfNomeCidade.getText().equals("") || jtfCodigoCidade.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar uma cidade!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeCidade.requestFocus();
		} else {
			this.empresa.setRegimeTributario(regimeTributario);
			this.empresa.setRazaoSocial(jtfRazaoSocial.getText());
			this.empresa.setNomeFantasia(jtfNomeFantasia.getText());
			this.empresa.setCnpj(jtfCNPJ.getText());
			if(jckbxIsento.isSelected()) {
				jtfInscricaoEstadual.setText("ISENTO");
				this.empresa.setInscricaoEstadual("ISENTO");
			} else {
				this.empresa.setInscricaoEstadual(jtfInscricaoEstadual.getText());
			}
			this.empresa.setInscricaoMunicipal(jtfInscricaoMunicipal.getText());
			this.empresa.setTelefoneCelular(jtfTelefoneCelular.getText());
			this.empresa.setTelefoneComercial(jtfTelefoneComercial.getText());
			this.empresa.setFax(jtfFax.getText());
			this.empresa.setEmail(jtfEmail.getText());
			this.empresa.setEndereco(jtfEndereco.getText());
			this.empresa.setNumero(Integer.valueOf(jtfNumero.getText()));
			this.empresa.setBairro(jtfBairro.getText());
			this.empresa.setCidade(new Cidade(Integer.valueOf(jtfCodigoCidade.getText()), null));
			this.empresa.setForaUso(Boolean.valueOf(jckbxForaUso.isSelected()));
			this.empresa.setDataAltercacao(Date.valueOf(empresa.getDataAltercacao().now()).toLocalDate());
			DaoFactory.getFactory().empresaDao().inserir(empresa);
			jtfCodigo.setText(String.valueOf(this.empresa.getIdEmpresa()));
			jtfDataAlteracao.setText(this.empresa.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
			JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!!!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			jcbxRegimeTributario.setEnabled(false);
			jckbxIsento.setEnabled(false);
			jtfNomeFantasia.setEnabled(false);
			jtfRazaoSocial.setEnabled(false);
			jtfCNPJ.setEnabled(false);
			jtfInscricaoEstadual.setEnabled(false);
			jtfInscricaoMunicipal.setEnabled(false);
			jtfTelefoneCelular.setEnabled(false);
			jtfTelefoneComercial.setEnabled(false);
			jtfFax.setEnabled(false);
			jtfEmail.setEnabled(false);
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
	
	@SuppressWarnings("static-access")
	public void salvarEdicaoEmpresa() throws Exception{
		this.empresa = new Empresa();
		if(jtfRazaoSocial.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar a razão social!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfRazaoSocial.requestFocus();
		} else if(jtfNomeFantasia.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o nome fantasia!!!", 	"Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeFantasia.requestFocus();
		} else if(jtfCNPJ.getText().equals("  .   .   /    -  ")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o Cnpj!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfCNPJ.requestFocus();
		} else if(jtfEndereco.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o endereço!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfEndereco.requestFocus();
		} else if(jtfBairro.getText().equals(""))	 {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o bairro!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfBairro.requestFocus();
		} else if(jtfNumero.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o número do estabelecimento!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNumero.requestFocus();
		} else if(jtfEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o email da empresa!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfEmail.requestFocus();
		} else if(jtfNomeCidade.getText().equals("") || jtfCodigoCidade.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar uma cidade!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeCidade.requestFocus();
		} else {
			this.empresa.setRegimeTributario(regimeTributario);
			this.empresa.setRazaoSocial(jtfRazaoSocial.getText());
			this.empresa.setNomeFantasia(jtfNomeFantasia.getText());
			this.empresa.setCnpj(jtfCNPJ.getText());
			if(jckbxIsento.isSelected()) {
				jtfInscricaoEstadual.setText("ISENTO");
				this.empresa.setInscricaoEstadual("ISENTO");
			} else {
				this.empresa.setInscricaoEstadual(jtfInscricaoEstadual.getText());
			}
			this.empresa.setInscricaoMunicipal(jtfInscricaoMunicipal.getText());
			this.empresa.setTelefoneCelular(jtfTelefoneCelular.getText());
			this.empresa.setTelefoneComercial(jtfTelefoneComercial.getText());
			this.empresa.setFax(jtfFax.getText());
			this.empresa.setEmail(jtfEmail.getText());
			this.empresa.setEndereco(jtfEndereco.getText());
			this.empresa.setNumero(Integer.valueOf(jtfNumero.getText()));
			this.empresa.setBairro(jtfBairro.getText());
			this.empresa.setCidade(new Cidade(Integer.valueOf(jtfCodigoCidade.getText()), null));
			this.empresa.setForaUso(Boolean.valueOf(jckbxForaUso.isSelected()));
			this.empresa.setDataAltercacao(Date.valueOf(empresa.getDataAltercacao().now()).toLocalDate());
			this.empresa.setIdEmpresa(Integer.valueOf(jtfCodigo.getText()));
			DaoFactory.getFactory().empresaDao().alterar(empresa);
			jtfDataAlteracao.setText(this.empresa.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
			JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!!!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			jcbxRegimeTributario.setEnabled(false);
			jckbxIsento.setEnabled(false);
			jtfNomeFantasia.setEnabled(false);
			jtfNomeFantasia.setEnabled(false);
			jtfRazaoSocial.setEnabled(false);
			jtfCNPJ.setEnabled(false);
			jtfInscricaoEstadual.setEnabled(false);
			jtfInscricaoMunicipal.setEnabled(false);
			jtfTelefoneCelular.setEnabled(false);
			jtfTelefoneComercial.setEnabled(false);
			jtfFax.setEnabled(false);
			jtfEmail.setEnabled(false);
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
	
	public void acionarBotaoEditar() {
		jtfRazaoSocial.requestFocus();
		this.selecionarRegimeTributario();
		jcbxRegimeTributario.setEnabled(true);
		jckbxForaUso.setEnabled(true);
		jckbxIsento.setEnabled(true);
		jtfNomeFantasia.setEnabled(true);
		jtfRazaoSocial.setEnabled(true);
		jtfCNPJ.setEnabled(true);
		jtfInscricaoEstadual.setEnabled(true);
		jtfInscricaoMunicipal.setEnabled(true);
		jtfTelefoneCelular.setEnabled(true);
		jtfTelefoneComercial.setEnabled(true);
		jtfFax.setEnabled(true);
		jtfEmail.setEnabled(true);
		jtfEndereco.setEnabled(true);
		jtfNumero.setEnabled(true);
		jtfBairro.setEnabled(true);
		jtfNomeCidade.setEnabled(true);
		jbtNovo.setEnabled(false);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
	}
	
	public void acionarBotaoCancelar() {
		jtfPesquisaCodigoEmpresa.requestFocus();
		jcbxRegimeTributario.setEnabled(false);
		jcbxRegimeTributario.setSelectedIndex(0);
		jckbxForaUso.setEnabled(false);
		jckbxForaUso.setSelected(false);
		jckbxIsento.setEnabled(false);
		jckbxIsento.setSelected(false);
		jtfNomeFantasia.setEnabled(false);
		jtfRazaoSocial.setEnabled(false);
		jtfCNPJ.setEnabled(false);
		jtfInscricaoEstadual.setEnabled(false);
		jtfInscricaoMunicipal.setEnabled(false);
		jtfTelefoneCelular.setEnabled(false);
		jtfTelefoneComercial.setEnabled(false);
		jtfFax.setEnabled(false);
		jtfEmail.setEnabled(false);
		jtfEndereco.setEnabled(false);
		jtfNumero.setEnabled(false);
		jtfBairro.setEnabled(false);
		jtfNomeCidade.setEnabled(false);
		jtfCodigo.setText("");
		jtfDataAlteracao.setText("");
		jtfNomeFantasia.setText("");
		jtfRazaoSocial.setText("");
		jtfCNPJ.setText("");
		jtfInscricaoEstadual.setText("");
		jtfInscricaoMunicipal.setText("");
		jtfTelefoneCelular.setText("");
		jtfTelefoneComercial.setText("");
		jtfFax.setText("");
		jtfEmail.setText("");
		jtfEndereco.setText("");
		jtfNumero.setText("");
		jtfBairro.setText("");
		jtfCodigoCidade.setText("");
		jtfNomeCidade.setText("");
		jtfCodigoUF.setText("");
		jtfNomeUF.setText("");
		jtfNomePais.setText("");
		jbtNovo.setEnabled(true);
		jbtCancelar.setEnabled(false);
		jbtSalvar.setEnabled(false);
		jbtEditar.setEnabled(false);
	}
	
	public void preencherCamposEmpresa(Empresa empresa) {
		jtfCodigo.setText(String.valueOf(empresa.getIdEmpresa()));
		jtfRazaoSocial.setText(empresa.getRazaoSocial());
		jtfNomeFantasia.setText(empresa.getNomeFantasia());
		jtfCNPJ.setText(empresa.getCnpj());
		if(empresa.getInscricaoEstadual().equals("ISENTO")) {
			jtfInscricaoEstadual.setText("ISENTO");
			jckbxIsento.setSelected(true);
		} else {
			jtfInscricaoEstadual.setText(empresa.getInscricaoEstadual());
		}
		jtfInscricaoMunicipal.setText(empresa.getInscricaoMunicipal());
		jtfTelefoneCelular.setText(empresa.getTelefoneCelular());
		jtfTelefoneComercial.setText(empresa.getTelefoneComercial());
		jtfFax.setText(empresa.getFax());
		jtfEmail.setText(empresa.getEmail());
		jtfEndereco.setText(empresa.getEndereco());
		jtfNumero.setText(String.valueOf(empresa.getNumero()));
		jtfBairro.setText(empresa.getBairro());
		jtfCodigoCidade.setText(String.valueOf(empresa.getCidade().getIdCidade()));
		jtfNomeCidade.setText(empresa.getCidade().getNome());
		jtfCodigoUF.setText(String.valueOf(empresa.getCidade().getUnidadeFederativa().getIdUnidadeFederativa()));
		jtfNomeUF.setText(empresa.getCidade().getUnidadeFederativa().getNome());
		jtfNomePais.setText(empresa.getCidade().getUnidadeFederativa().getPais().getNome());
		jtfDataAlteracao.setText(empresa.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
		if(empresa.getRegimeTributario() == 1) {
			jcbxRegimeTributario.setSelectedIndex(0);
			regimeTributario = 1;
		} else if(empresa.getRegimeTributario() == 2) {
			jcbxRegimeTributario.setSelectedIndex(1);
			regimeTributario = 2;
		} else {
			jcbxRegimeTributario.setSelectedIndex(2);
			regimeTributario = 3;
		}
		jtfPesquisaCodigoEmpresa.requestFocus();
	}
	
	public void preencherCamposCidadeUFPais(Cidade cidade) {
		jtfCodigoCidade.setText(String.valueOf(cidade.getIdCidade()));
		jtfNomeCidade.setText(cidade.getNome());
		jtfCodigoUF.setText(String.valueOf(cidade.getUnidadeFederativa().getIdUnidadeFederativa()));
		jtfNomeUF.setText(cidade.getUnidadeFederativa().getNome());
		jtfNomePais.setText(cidade.getUnidadeFederativa().getPais().getNome());
	}
	
	public void selecionarRegimeTributario() {
		// Regimes Tributários ---- 1 - Simples Nacional
		//2 Lucro Presumido ----- 3 Lucro Real
		jcbxRegimeTributario.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent evt) {
				if((evt.getSource() == jcbxRegimeTributario) && (evt.getStateChange() == ItemEvent.SELECTED)) {
					if(jcbxRegimeTributario.getSelectedIndex() == 0) {
						regimeTributario = 1;
					} else if(jcbxRegimeTributario.getSelectedIndex() == 1) {
						regimeTributario = 2;
					} else {
						regimeTributario = 3;
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
				if(acvt.getSource() == jbtSalvar) {
					if(jbtSalvar.isEnabled() && jbtEditar.isEnabled()) {
						try {
							salvarEdicaoEmpresa();
						} catch (Exception salvarEdicao) {
							salvarEdicao.printStackTrace();
						}
					} else {
						try {
							salvarCadastroEmpresa();
						} catch (Exception salvarEmpresa) {
							salvarEmpresa.printStackTrace();
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
		jtfPesquisaCodigoEmpresa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					Integer codigo = null;
					if(!jtfPesquisaCodigoEmpresa.getText().equals("")) {
						codigo = Integer.valueOf(jtfPesquisaCodigoEmpresa.getText());
					}
					ListaEmpresaForm listaEmpresaForm = new ListaEmpresaForm(empresaForm, null, codigo, null);
					listaEmpresaForm.setVisible(true);
					jbtNovo.setEnabled(true);
					jbtEditar.setEnabled(true);
					jbtCancelar.setEnabled(true);
					jbtSalvar.setEnabled(false);
					jtfCodigo.setText("");
					jtfDataAlteracao.setText("");
					jtfNomeFantasia.setText("");
					jtfRazaoSocial.setText("");
					jtfCNPJ.setText("");
					jtfInscricaoEstadual.setText("");
					jtfInscricaoMunicipal.setText("");
					jtfTelefoneCelular.setText("");
					jtfTelefoneComercial.setText("");
					jtfFax.setText("");
					jtfEmail.setText("");
					jtfEndereco.setText("");
					jtfNumero.setText("");
					jtfBairro.setText("");
					jtfCodigoCidade.setText("");
					jtfNomeCidade.setText("");
					jtfCodigoUF.setText("");
					jtfNomeUF.setText("");
					jtfNomePais.setText("");
					jtfPesquisaCodigoEmpresa.setText("");
					jtfPesquisaNomeEmpresa.setText("");
					jtfPesquisaCNPJEmpresa.setText("");
				}
			}
		});
	}
	
	public void pesquisaPorNome() {
		jtfPesquisaNomeEmpresa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					ListaEmpresaForm listaEmpresaForm = new ListaEmpresaForm(empresaForm, jtfPesquisaNomeEmpresa.getText(), null, null);
					listaEmpresaForm.setVisible(true);
					jbtNovo.setEnabled(true);
					jbtEditar.setEnabled(true);
					jbtCancelar.setEnabled(true);
					jbtSalvar.setEnabled(false);
					jtfCodigo.setText("");
					jtfDataAlteracao.setText("");
					jtfNomeFantasia.setText("");
					jtfRazaoSocial.setText("");
					jtfCNPJ.setText("");
					jtfInscricaoEstadual.setText("");
					jtfInscricaoMunicipal.setText("");
					jtfTelefoneCelular.setText("");
					jtfTelefoneComercial.setText("");
					jtfFax.setText("");
					jtfEmail.setText("");
					jtfEndereco.setText("");
					jtfNumero.setText("");
					jtfBairro.setText("");
					jtfCodigoCidade.setText("");
					jtfNomeCidade.setText("");
					jtfCodigoUF.setText("");
					jtfNomeUF.setText("");
					jtfNomePais.setText("");
					jtfPesquisaCodigoEmpresa.setText("");
					jtfPesquisaNomeEmpresa.setText("");
					jtfPesquisaCNPJEmpresa.setText("");
				}
			}
		});
	}
	
	public void pesquisaPorDocumento() {
		jtfPesquisaCNPJEmpresa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					ListaEmpresaForm listaEmpresaForm = new ListaEmpresaForm(empresaForm, null, null, jtfPesquisaCNPJEmpresa.getText());
					listaEmpresaForm.setVisible(true);
					jbtNovo.setEnabled(true);
					jbtEditar.setEnabled(true);
					jbtCancelar.setEnabled(true);
					jbtSalvar.setEnabled(false);
					jtfCodigo.setText("");
					jtfDataAlteracao.setText("");
					jtfNomeFantasia.setText("");
					jtfRazaoSocial.setText("");
					jtfCNPJ.setText("");
					jtfInscricaoEstadual.setText("");
					jtfInscricaoMunicipal.setText("");
					jtfTelefoneCelular.setText("");
					jtfTelefoneComercial.setText("");
					jtfFax.setText("");
					jtfEmail.setText("");
					jtfEndereco.setText("");
					jtfNumero.setText("");
					jtfBairro.setText("");
					jtfCodigoCidade.setText("");
					jtfNomeCidade.setText("");
					jtfCodigoUF.setText("");
					jtfNomeUF.setText("");
					jtfNomePais.setText("");
					jtfPesquisaCodigoEmpresa.setText("");
					jtfPesquisaNomeEmpresa.setText("");
					jtfPesquisaCNPJEmpresa.setText("");
				}
			}
		});
	}
	
	public void pesquisaCidade() {
		jtfNomeCidade.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					ListaCidadeUFPaisForm listaCidadeUFPaisForm = new ListaCidadeUFPaisForm(empresaForm, jtfNomeCidade.getText());
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

	public EmpresaForm() {
		empresaForm = this;
		setIconImage(Toolkit.getDefaultToolkit().getImage(EmpresaForm.class.getResource("/Imagens/washCar.jpeg")));
		setTitle("Cadastro da Empresa");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 642, 457);
		jnpEmpresa = new JPanel();
		setLocationRelativeTo(null);
		jnpEmpresa.setLayout(null);
		setContentPane(jnpEmpresa);

		componentesTelaEmpresa();
		acoesDosBotoes();
		pesquisaPorCodigo();
		pesquisaPorNome();
		pesquisaPorDocumento();
		pesquisaCidade();
	}

	@Override
	public void preencherCampos(Entidade entidade) {
		if(jtfNomeCidade.isEnabled() && !jtfNomeUF.isEnabled() && !jtfNomePais.isEnabled()) {
			this.preencherCamposCidadeUFPais((Cidade)entidade);
		} else {
			this.preencherCamposEmpresa((Empresa)entidade);
		}
	}
}