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
import java.sql.Date;
import java.time.format.DateTimeFormatter;

import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

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
	private JTextField jtfCidade;
	private JTextField jtfPais;
	private JTextField jtfPesquisaCNPJEmpresa;
	private JTextField jtfInscricaoMunicipal;
	private JTextField jtfUnidadeFederativa;
	private JTextField jtfEmail;
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
	private JRadioButton jrbSimplesNacional;
	private JRadioButton jrbLucroPresumido;
	private JRadioButton jrbLucroReal;
	private ButtonGroup jbgRegimeTributario;
	private JButton jbtNovo;
	private JButton jbtEditar;
	private JButton jbtSalvar;
	private JButton jbtCancelar;
	private JButton jbtFechar;
	private static EmpresaForm empresaForm;
	private Empresa empresa;

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
		jlbCodigo.setBounds(10, 107, 66, 14);
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
		jtfRazaoSocial.setBounds(10, 170, 300, 20);
		jnpEmpresa.add(jtfRazaoSocial);
		
		jlbNomeFantasia = new JLabel("Nome Fantasia da Empresa");
		jlbNomeFantasia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeFantasia.setBounds(10, 201, 300, 14);
		jnpEmpresa.add(jlbNomeFantasia);
		
		jtfNomeFantasia = new JTextField();
		jtfNomeFantasia.setDocument(new ValidaCampoString());
		jtfNomeFantasia.setEnabled(false);
		jtfNomeFantasia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeFantasia.setColumns(10);
		jtfNomeFantasia.setBounds(10, 217, 300, 20);
		jnpEmpresa.add(jtfNomeFantasia);
		
		jlbCNPJ = new JLabel("CNPJ");
		jlbCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCNPJ.setBounds(320, 154, 165, 14);
		jnpEmpresa.add(jlbCNPJ);
		
		try {
			jtfCNPJ= new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfCNPJ.setEnabled(false);
		jtfCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCNPJ.setColumns(10);
		jtfCNPJ.setBounds(320, 170, 165, 20);
		jnpEmpresa.add(jtfCNPJ);
		
		jlbEndereco = new JLabel("Endere\u00E7o");
		jlbEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbEndereco.setBounds(10, 248, 177, 14);
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
		jlbBairro.setBounds(346, 248, 139, 14);
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
		jlbNumero.setBounds(270, 248, 66, 14);
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
		jlbTelefoneComercial.setBounds(495, 201, 130, 14);
		jnpEmpresa.add(jlbTelefoneComercial);
		
		jtfTelefoneComercial = new JTextField();
		jtfTelefoneComercial.setDocument(new ValidaCampoTelefone());
		jtfTelefoneComercial.setEnabled(false);
		jtfTelefoneComercial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneComercial.setColumns(10);
		jtfTelefoneComercial.setBounds(495, 217, 130, 20);
		jnpEmpresa.add(jtfTelefoneComercial);
		
		jlbTelefoneCelular = new JLabel("Telefone Celular");
		jlbTelefoneCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneCelular.setBounds(495, 248, 130, 14);
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
		jlbFax.setBounds(495, 295, 130, 14);
		jnpEmpresa.add(jlbFax);
		
		jtfFax = new JTextField();
		jtfFax.setDocument(new ValidaCampoTelefone());
		jtfFax.setEnabled(false);
		jtfFax.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfFax.setColumns(10);
		jtfFax.setBounds(495, 311, 130, 20);
		jnpEmpresa.add(jtfFax);
		
		jlbInscricaoEstadual = new JLabel("Inscri\u00E7\u00E3o Estadual");
		jlbInscricaoEstadual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbInscricaoEstadual.setBounds(320, 201, 165, 14);
		jnpEmpresa.add(jlbInscricaoEstadual);
		
		jtfInscricaoEstadual = new JTextField();
		jtfInscricaoEstadual.setDocument(new ValidaCampoDocumentoJuridico());
		jtfInscricaoEstadual.setEnabled(false);
		jtfInscricaoEstadual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfInscricaoEstadual.setColumns(10);
		jtfInscricaoEstadual.setBounds(320, 217, 165, 20);
		jnpEmpresa.add(jtfInscricaoEstadual);
		
		jlbDataAlteracao = new JLabel("Data Alteracao");
		jlbDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataAlteracao.setBounds(525, 107, 100, 14);
		jnpEmpresa.add(jlbDataAlteracao);
		
		try {
			jtfDataAlteracao = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfDataAlteracao.setBackground(Color.YELLOW);
		jtfDataAlteracao.setEditable(false);
		jtfDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfDataAlteracao.setColumns(10);
		jtfDataAlteracao.setBounds(525, 123, 100, 20);
		jnpEmpresa.add(jtfDataAlteracao);
		
		jlbCidade = new JLabel("Cidade");
		jlbCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCidade.setBounds(10, 344, 139, 14);
		jnpEmpresa.add(jlbCidade);
		
		jtfCidade = new JTextField();
		jtfCidade.setDocument(new ValidaCampoAlfaNumerico());
		jtfCidade.setEnabled(false);
		jtfCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCidade.setColumns(10);
		jtfCidade.setBounds(10, 360, 139, 20);
		jnpEmpresa.add(jtfCidade);
		
		jlbPais = new JLabel("Pa\u00EDs");
		jlbPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPais.setBounds(346, 344, 139, 14);
		jnpEmpresa.add(jlbPais);
		
		jtfPais = new JTextField();
		jtfPais.setDocument(new ValidaCampoAlfaNumerico());
		jtfPais.setEnabled(false);
		jtfPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPais.setColumns(10);
		jtfPais.setBounds(346, 360, 139, 20);
		jnpEmpresa.add(jtfPais);
		
		jlbRegimeTributario = new JLabel("Regime Tribut\u00E1rio");
		jlbRegimeTributario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbRegimeTributario.setBounds(80, 105, 240, 15);
		jnpEmpresa.add(jlbRegimeTributario);
		
		jlbUnidadeFederativa = new JLabel("Estado");
		jlbUnidadeFederativa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbUnidadeFederativa.setBounds(159, 343, 177, 14);
		jnpEmpresa.add(jlbUnidadeFederativa);
		
		jlbInscricaoMunicipal = new JLabel("Inscri\u00E7\u00E3o Municipal");
		jlbInscricaoMunicipal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbInscricaoMunicipal.setBounds(495, 154, 130, 14);
		jnpEmpresa.add(jlbInscricaoMunicipal);
		
		jtfInscricaoMunicipal = new JTextField();
		jtfInscricaoMunicipal.setDocument(new ValidaCampoDocumentoJuridico());
		jtfInscricaoMunicipal.setEnabled(false);
		jtfInscricaoMunicipal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfInscricaoMunicipal.setColumns(10);
		jtfInscricaoMunicipal.setBounds(495, 170, 130, 20);
		jnpEmpresa.add(jtfInscricaoMunicipal);
		
		jrbSimplesNacional = new JRadioButton("Simples Nacional");
		jrbSimplesNacional.setEnabled(false);
		jrbSimplesNacional.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jrbSimplesNacional.setBounds(75, 120, 145, 25);
		getContentPane().add(jrbSimplesNacional);
		
		jrbLucroPresumido = new JRadioButton("Lucro Presumido");
		jrbLucroPresumido.setEnabled(false);
		jrbLucroPresumido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jrbLucroPresumido.setBounds(225, 120, 145, 25);
		getContentPane().add(jrbLucroPresumido);
		
		jrbLucroReal = new JRadioButton("Lucro Real");
		jrbLucroReal.setEnabled(false);
		jrbLucroReal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jrbLucroReal.setBounds(375, 120, 145, 25);
		getContentPane().add(jrbLucroReal);
		
		jbgRegimeTributario = new ButtonGroup();
		jbgRegimeTributario.add(jrbSimplesNacional);
		jbgRegimeTributario.add(jrbLucroReal);
		jbgRegimeTributario.add(jrbLucroPresumido);
		
		jtfUnidadeFederativa = new JTextField();
		jtfUnidadeFederativa.setDocument(new ValidaCampoAlfaNumerico());
		jtfUnidadeFederativa.setEnabled(false);
		jtfUnidadeFederativa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfUnidadeFederativa.setColumns(10);
		jtfUnidadeFederativa.setBounds(159, 361, 177, 20);
		jnpEmpresa.add(jtfUnidadeFederativa);
		
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
		jlbEmailEmpresa.setBounds(10, 295, 150, 14);
		jnpEmpresa.add(jlbEmailEmpresa);
	}
	
	public void acionarBotaoNovo() {
		jbtNovo.setEnabled(false);
		jbtEditar.setEnabled(false);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
		jtfRazaoSocial.requestFocus();
		jrbLucroPresumido.setEnabled(true);
		jrbLucroReal.setEnabled(true);
		jrbSimplesNacional.setEnabled(true);
		jrbLucroPresumido.setSelected(false);
		jrbLucroReal.setSelected(false);
		jrbSimplesNacional.setSelected(false);
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
		jtfCidade.setEnabled(true);
		jtfUnidadeFederativa.setEnabled(true);
		jtfPais.setEnabled(true);
		jtfCodigo.setText("");
		jtfDataAlteracao.setText("");
		jrbLucroPresumido.setSelected(false);
		jrbLucroReal.setSelected(false);
		jrbSimplesNacional.setSelected(false);
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
		jtfCidade.setText("");
		jtfUnidadeFederativa.setText("");
		jtfPais.setText("");
	}
	
	@SuppressWarnings("static-access")
	public void salvarCadastroEmpresa() throws Exception{
		if(jtfRazaoSocial.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigat�rio informar a raz�o social!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfRazaoSocial.requestFocus();
		} else if(jtfNomeFantasia.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigat�rio informar o nome fantasia!!!", 	"Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeFantasia.requestFocus();
		} else if(jtfCNPJ.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigat�rio informar o Cnpj!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfCNPJ.requestFocus();
		} else if(jtfEndereco.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigat�rio informar o endere�o!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfEndereco.requestFocus();
		} else if(jtfBairro.getText().equals(""))	 {
			JOptionPane.showMessageDialog(null, "Obrigat�rio informar o bairro!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfBairro.requestFocus();
		} else if(jtfNumero.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigat�rio informar o n�mero do estabelecimento!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNumero.requestFocus();
		} else if(!jrbSimplesNacional.isSelected() || !jrbLucroPresumido.isSelected() || !jrbLucroReal.isSelected()) {
			JOptionPane.showMessageDialog(null, "Obrigat�rio informar o regime tribut�rio da empresa!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		} else if(jtfEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigat�rio informar o email da empresa!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNumero.requestFocus();
		} else {
			this.empresa = new Empresa();
			this.empresa.setRazaoSocial(jtfRazaoSocial.getText());
			this.empresa.setNomeFantasia(jtfNomeFantasia.getText());
			this.empresa.setCnpj(jtfCNPJ.getText());
			this.empresa.setInscricaoEstadual(jtfInscricaoEstadual.getText());
			this.empresa.setInscricaoMunicipal(jtfInscricaoMunicipal.getText());
			this.empresa.setTelefoneCelular(jtfTelefoneCelular.getText());
			this.empresa.setTelefoneComercial(jtfTelefoneComercial.getText());
			this.empresa.setFax(jtfFax.getText());
			this.empresa.setEmail(jtfEmail.getText());
			this.empresa.setEndereco(jtfEndereco.getText());
			this.empresa.setNumero(Integer.valueOf(jtfNumero.getText()));
			this.empresa.setBairro(jtfBairro.getText());
			//this.empresa.setCidade(new Cidade());
			this.empresa.setDataAltercacao(Date.valueOf(empresa.getDataAltercacao().now()).toLocalDate());
			if(jrbSimplesNacional.isSelected()) {
				this.empresa.setRegimeTributario(1);
			} else if(jrbLucroPresumido.isSelected()) {
				this.empresa.setRegimeTributario(2);
			} else if(jrbLucroReal.isSelected()) {
				this.empresa.setRegimeTributario(3);
			}
			DaoFactory.getFactory().empresaDao().inserir(empresa);
			jtfCodigo.setText(String.valueOf(this.empresa.getIdEmpresa()));
			jtfDataAlteracao.setText(this.empresa.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
			JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!!!", "Confirma��o", JOptionPane.INFORMATION_MESSAGE);
			jrbLucroPresumido.setEnabled(false);
			jrbLucroReal.setEnabled(false);
			jrbSimplesNacional.setEnabled(false);
			jtfNomeFantasia.setEnabled(false);
			jtfRazaoSocial.setEnabled(false);
			jtfCNPJ.setEnabled(false);
			jtfInscricaoEstadual.setEnabled(false);
			jtfInscricaoMunicipal.setEnabled(false);
			jtfTelefoneCelular.setEnabled(false);
			jtfTelefoneComercial.setEnabled(false);
			jtfFax.setEnabled(false);
			jtfEmail.setEditable(false);
			jtfEndereco.setEnabled(false);
			jtfNumero.setEnabled(false);
			jtfBairro.setEnabled(false);
			jtfCidade.setEnabled(false);
			jtfUnidadeFederativa.setEnabled(false);
			jtfPais.setEnabled(false);
			jbtSalvar.setEnabled(false);
			jbtEditar.setEnabled(true);
			jbtNovo.setEnabled(true);
		}
	}
	
	public void salvarEdicaoEmpresa() throws Exception{
		
	}
	
	public void acionarBotaoEditar() {
		jbtNovo.setEnabled(false);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
		jrbLucroPresumido.setEnabled(true);
		jrbLucroReal.setEnabled(true);
		jrbSimplesNacional.setEnabled(true);
		jtfNomeFantasia.setEnabled(true);
		jtfRazaoSocial.setEnabled(true);
		jtfCNPJ.setEnabled(true);
		jtfInscricaoEstadual.setEnabled(true);
		jtfInscricaoMunicipal.setEnabled(true);
		jtfTelefoneCelular.setEnabled(true);
		jtfTelefoneComercial.setEnabled(true);
		jtfFax.setEnabled(true);
		jtfEmail.setEditable(true);
		jtfEndereco.setEnabled(true);
		jtfNumero.setEnabled(true);
		jtfBairro.setEnabled(true);
		jtfCidade.setEnabled(true);
		jtfUnidadeFederativa.setEnabled(true);
		jtfPais.setEnabled(true);
		
	}
	
	public void acionarBotaoCancelar() {
		jbtNovo.setEnabled(true);
		jbtCancelar.setEnabled(false);
		jbtSalvar.setEnabled(false);
		jbtEditar.setEnabled(false);
		jtfPesquisaCodigoEmpresa.requestFocus();
		jrbLucroPresumido.setEnabled(false);
		jrbLucroReal.setEnabled(false);
		jrbSimplesNacional.setEnabled(false);
		jrbLucroPresumido.setSelected(false);
		jrbLucroReal.setSelected(false);
		jrbSimplesNacional.setSelected(false);
		jtfNomeFantasia.setEnabled(false);
		jtfRazaoSocial.setEnabled(false);
		jtfCNPJ.setEnabled(false);
		jtfInscricaoEstadual.setEnabled(false);
		jtfInscricaoMunicipal.setEnabled(false);
		jtfTelefoneCelular.setEnabled(false);
		jtfTelefoneComercial.setEnabled(false);
		jtfFax.setEnabled(false);
		jtfEmail.setEditable(false);
		jtfEndereco.setEnabled(false);
		jtfNumero.setEnabled(false);
		jtfBairro.setEnabled(false);
		jtfCidade.setEnabled(false);
		jtfUnidadeFederativa.setEnabled(false);
		jtfPais.setEnabled(false);
		jrbLucroPresumido.setSelected(false);
		jrbLucroReal.setSelected(false);
		jrbSimplesNacional.setSelected(false);
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
		jtfCidade.setText("");
		jtfUnidadeFederativa.setText("");
		jtfPais.setText("");
	}
	
	public void preencherCamposEmpresa(Empresa empresa) {
		jtfCodigo.setText(String.valueOf(empresa.getIdEmpresa()));
		jtfRazaoSocial.setText(empresa.getRazaoSocial());
		jtfNomeFantasia.setText(empresa.getNomeFantasia());
		jtfCNPJ.setText(empresa.getCnpj());
		jtfInscricaoEstadual.setText(empresa.getInscricaoEstadual());
		jtfInscricaoMunicipal.setText(empresa.getInscricaoMunicipal());
		jtfTelefoneCelular.setText(empresa.getTelefoneCelular());
		jtfTelefoneComercial.setText(empresa.getTelefoneComercial());
		jtfFax.setText(empresa.getFax());
		jtfEmail.setText(empresa.getEmail());
		jtfEndereco.setText(empresa.getEndereco());
		jtfNumero.setText(String.valueOf(empresa.getNumero()));
		jtfBairro.setText(empresa.getBairro());
		jtfCidade.setText(empresa.getCidade().getNome());
//		jtfUnidadeFederativa.setText(empresa.getCidade().getUnidadeFederativa().getNome());
//		jtfPais.setText(empresa.getCidade().getUnidadeFederativa().getPais().getNome());
		jtfDataAlteracao.setText(empresa.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
		if(empresa.getRegimeTributario() == 1) {
			jrbSimplesNacional.setSelected(true);
		} else if(empresa.getRegimeTributario() == 2) {
			jrbLucroPresumido.setSelected(true);
		} else if(empresa.getRegimeTributario() == 3) {
			jrbLucroReal.setSelected(true);
		}
		jtfPesquisaCodigoEmpresa.setText("");
		jtfPesquisaNomeEmpresa.setText("");
		jtfPesquisaCNPJEmpresa.setText("");
		jtfPesquisaCodigoEmpresa.requestFocus();
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
					jrbLucroPresumido.setSelected(false);
					jrbLucroReal.setSelected(false);
					jrbSimplesNacional.setSelected(false);
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
					jtfCidade.setText("");
					jtfUnidadeFederativa.setText("");
					jtfPais.setText("");
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
					jrbLucroPresumido.setSelected(false);
					jrbLucroReal.setSelected(false);
					jrbSimplesNacional.setSelected(false);
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
					jtfCidade.setText("");
					jtfUnidadeFederativa.setText("");
					jtfPais.setText("");
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
					jrbLucroPresumido.setSelected(false);
					jrbLucroReal.setSelected(false);
					jrbSimplesNacional.setSelected(false);
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
					jtfCidade.setText("");
					jtfUnidadeFederativa.setText("");
					jtfPais.setText("");
				}
			}
		});
	}
	
	public void pesquisaCidade() {
		jtfCidade.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					ListaCidadeUFPaisForm listaCidadeUFPaisForm = new ListaCidadeUFPaisForm(empresaForm, jtfCidade.getText());
					listaCidadeUFPaisForm.setVisible(true);
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
		setBounds(100, 100, 641, 455);
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
		this.preencherCamposEmpresa((Empresa)entidade);
	}
}