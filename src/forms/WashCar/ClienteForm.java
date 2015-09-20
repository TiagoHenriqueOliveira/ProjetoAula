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

import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

import validacaoCampos.WashCar.ValidaCampoDocumentoFisico;
import validacaoCampos.WashCar.ValidaCampoNumeroInteiro;
import validacaoCampos.WashCar.ValidaCampoDocumentoJuridico;
import validacaoCampos.WashCar.ValidaCampoString;
import validacaoCampos.WashCar.ValidaCampoTelefone;

import com.toedter.calendar.JDateChooser;
import java.awt.Toolkit;

public class ClienteForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnCliente;
	private JTextField jtfPesquisaCodigoCliente;
	private JTextField jtfPesquisaNomeCliente;
	private JTextField jtfPesquisaCnpjCliente;
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
	private JTextField jtfInscricaoMunicipal;
	private JTextField jtfTelefoneResidencial;
	private JTextField jtfEmail;
	private JTextField jtfNome;
	private JTextField jtfCPF;
	private JTextField jtfRG;
	private JTextField jtfSobrenomeCliente;
	private JPanel jpnPesquisaCliente;
	private JLabel jlbPesquisaCodigoCliente;
	private JLabel jlbPesquisaNomeCliente;
	private JButton jbtPesquisaCliente;
	private JLabel jlbCnpjDoCliente;
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
	private JLabel jlbTipoPessoa;
	private JLabel jlbUnidadeFederativa;
	private JLabel jlbInscricaoMunicipal;
	private ButtonGroup jbgTipoPessoa;
	private JRadioButton jrbFisica;
	private JRadioButton jrbJuridica;
	private JLabel jlbTelefoneResidencial;
	private JLabel jlbEmail;
	private JLabel jlbNome;
	private JLabel jlbCPF;
	private JLabel jlbRG;
	private JLabel jlbDataNascimento;
	private JCheckBox jckbForaUso;
	private JLabel jlbSobrenomeCliente;
	private JTextField jtfUnidadeFederativa;
	private JButton jbtNovo;
	private JButton jbtFechar;
	private JButton jbtCancelar;
	private JButton jbtSalvar;
	private JButton jbtEditar;
	private JLabel jlbConsultaCliente;
	private JDateChooser jctDataNascimento;

	public void componentesTelaCliente() {
		jpnPesquisaCliente = new JPanel();
		jpnPesquisaCliente.setLayout(null);
		jpnPesquisaCliente.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnPesquisaCliente.setBounds(10, 11, 615, 81);
		jpnCliente.add(jpnPesquisaCliente);
		
		jlbPesquisaCodigoCliente = new JLabel("C\u00F3digo");
		jlbPesquisaCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaCodigoCliente.setBounds(10, 34, 46, 14);
		jpnPesquisaCliente.add(jlbPesquisaCodigoCliente);
		
		jtfPesquisaCodigoCliente = new JTextField();
		jtfPesquisaCodigoCliente.setDocument(new ValidaCampoNumeroInteiro());
		jtfPesquisaCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaCodigoCliente.setColumns(10);
		jtfPesquisaCodigoCliente.setBounds(10, 50, 66, 20);
		jpnPesquisaCliente.add(jtfPesquisaCodigoCliente);
		
		jlbPesquisaNomeCliente = new JLabel("Nome do Cliente");
		jlbPesquisaNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaNomeCliente.setBounds(86, 34, 100, 14);
		jpnPesquisaCliente.add(jlbPesquisaNomeCliente);
		
		jtfPesquisaNomeCliente = new JTextField();
		jtfPesquisaNomeCliente.setDocument(new ValidaCampoString());
		jtfPesquisaNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaNomeCliente.setColumns(10);
		jtfPesquisaNomeCliente.setBounds(86, 50, 275, 20);
		jpnPesquisaCliente.add(jtfPesquisaNomeCliente);
		
		jbtPesquisaCliente = new JButton("");
		jbtPesquisaCliente.setIcon(new ImageIcon(ClienteForm.class.getResource("/Imagens/lupaPesquisa.jpeg")));
		jbtPesquisaCliente.setBounds(565, 38, 40, 32);
		jpnPesquisaCliente.add(jbtPesquisaCliente);
		
		try {
			jtfPesquisaCnpjCliente = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfPesquisaCnpjCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaCnpjCliente.setColumns(10);
		jtfPesquisaCnpjCliente.setBounds(371, 50, 165, 20);
		jpnPesquisaCliente.add(jtfPesquisaCnpjCliente);
		
		jlbCnpjDoCliente = new JLabel("CNPJ do Cliente");
		jlbCnpjDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCnpjDoCliente.setBounds(371, 34, 100, 14);
		jpnPesquisaCliente.add(jlbCnpjDoCliente);
		
		jlbConsultaCliente = new JLabel("Consulta Cadastro do Cliente");
		jlbConsultaCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbConsultaCliente.setBounds(10, 9, 200, 14);
		jpnPesquisaCliente.add(jlbConsultaCliente);
		
		jlbCodigo = new JLabel("C\u00F3digo");
		jlbCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigo.setBounds(10, 103, 46, 14);
		jpnCliente.add(jlbCodigo);
		
		jtfCodigo = new JTextField();
		jtfCodigo.setDocument(new ValidaCampoNumeroInteiro());
		jtfCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigo.setEditable(false);
		jtfCodigo.setColumns(10);
		jtfCodigo.setBackground(Color.YELLOW);
		jtfCodigo.setBounds(10, 119, 66, 20);
		jpnCliente.add(jtfCodigo);
		
		jlbRazaoSocial = new JLabel("Raz\u00E3o Social");
		jlbRazaoSocial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbRazaoSocial.setBounds(10, 238, 150, 14);
		jpnCliente.add(jlbRazaoSocial);
		
		jtfRazaoSocial = new JTextField();
		jtfRazaoSocial.setDocument(new ValidaCampoString());
		jtfRazaoSocial.setEnabled(false);
		jtfRazaoSocial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfRazaoSocial.setColumns(10);
		jtfRazaoSocial.setBounds(10, 254, 300, 20);
		jpnCliente.add(jtfRazaoSocial);
		
		jlbNomeFantasia = new JLabel("Nome Fantasia");
		jlbNomeFantasia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeFantasia.setBounds(10, 285, 160, 14);
		jpnCliente.add(jlbNomeFantasia);
		
		jtfNomeFantasia = new JTextField();
		jtfNomeFantasia.setDocument(new ValidaCampoString());
		jtfNomeFantasia.setEnabled(false);
		jtfNomeFantasia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeFantasia.setColumns(10);
		jtfNomeFantasia.setBounds(10, 301, 300, 20);
		jpnCliente.add(jtfNomeFantasia);
		
		jlbCNPJ = new JLabel("CNPJ");
		jlbCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCNPJ.setBounds(320, 285, 100, 14);
		jpnCliente.add(jlbCNPJ);
		
		try {
			jtfCNPJ = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfCNPJ.setEnabled(false);
		jtfCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCNPJ.setColumns(10);
		jtfCNPJ.setBounds(320, 301, 165, 20);
		jpnCliente.add(jtfCNPJ);
		
		jlbEndereco = new JLabel("Endere\u00E7o");
		jlbEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbEndereco.setBounds(10, 379, 80, 14);
		jpnCliente.add(jlbEndereco);
		
		jtfEndereco = new JTextField();
		jtfEndereco.setDocument(new ValidaCampoString());
		jtfEndereco.setEnabled(false);
		jtfEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfEndereco.setColumns(10);
		jtfEndereco.setBounds(10, 395, 250, 20);
		jpnCliente.add(jtfEndereco);
		
		jlbBairro = new JLabel("Bairro");
		jlbBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbBairro.setBounds(346, 379, 46, 14);
		jpnCliente.add(jlbBairro);
		
		jtfBairro = new JTextField();
		jtfBairro.setDocument(new ValidaCampoString());
		jtfBairro.setEnabled(false);
		jtfBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfBairro.setColumns(10);
		jtfBairro.setBounds(346, 395, 139, 20);
		jpnCliente.add(jtfBairro);
		
		jlbNumero = new JLabel("N\u00FAmero");
		jlbNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNumero.setBounds(270, 379, 46, 14);
		jpnCliente.add(jlbNumero);
		
		jtfNumero = new JTextField();
		jtfNumero.setDocument(new ValidaCampoNumeroInteiro());
		jtfNumero.setEnabled(false);
		jtfNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNumero.setColumns(10);
		jtfNumero.setBounds(270, 395, 66, 20);
		jpnCliente.add(jtfNumero);
		
		jlbTelefoneComercial = new JLabel("Telefone Comercial");
		jlbTelefoneComercial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneComercial.setBounds(495, 285, 130, 14);
		jpnCliente.add(jlbTelefoneComercial);
		
		jtfTelefoneComercial = new JTextField();
		jtfTelefoneComercial.setDocument(new ValidaCampoTelefone());
		jtfTelefoneComercial.setEnabled(false);
		jtfTelefoneComercial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneComercial.setColumns(10);
		jtfTelefoneComercial.setBounds(495, 301, 130, 20);
		jpnCliente.add(jtfTelefoneComercial);
		
		jlbTelefoneCelular = new JLabel("Telefone Celular");
		jlbTelefoneCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneCelular.setBounds(495, 379, 130, 14);
		jpnCliente.add(jlbTelefoneCelular);
		
		jtfTelefoneCelular = new JTextField();
		jtfTelefoneCelular.setDocument(new ValidaCampoTelefone());
		jtfTelefoneCelular.setEnabled(false);
		jtfTelefoneCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneCelular.setColumns(10);
		jtfTelefoneCelular.setBounds(495, 395, 130, 20);
		jpnCliente.add(jtfTelefoneCelular);
		
		jlbFax = new JLabel("Fax");
		jlbFax.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbFax.setBounds(495, 426, 46, 14);
		jpnCliente.add(jlbFax);
		
		jtfFax = new JTextField();
		jtfFax.setDocument(new ValidaCampoTelefone());
		jtfFax.setEnabled(false);
		jtfFax.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfFax.setColumns(10);
		jtfFax.setBounds(495, 442, 130, 20);
		jpnCliente.add(jtfFax);
		
		jlbInscricaoEstadual = new JLabel("Inscri\u00E7\u00E3o Estadual");
		jlbInscricaoEstadual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbInscricaoEstadual.setBounds(320, 332, 165, 14);
		jpnCliente.add(jlbInscricaoEstadual);
		
		jtfInscricaoEstadual = new JTextField();
		jtfInscricaoEstadual.setDocument(new ValidaCampoDocumentoJuridico());
		jtfInscricaoEstadual.setEnabled(false);
		jtfInscricaoEstadual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfInscricaoEstadual.setColumns(10);
		jtfInscricaoEstadual.setBounds(320, 348, 165, 20);
		jpnCliente.add(jtfInscricaoEstadual);
		
		jlbDataAlteracao = new JLabel("Data Alteracao");
		jlbDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataAlteracao.setBounds(525, 103, 100, 14);
		jpnCliente.add(jlbDataAlteracao);
		
		try {
			jtfDataAlteracao = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfDataAlteracao.setEditable(false);
		jtfDataAlteracao.setColumns(10);
		jtfDataAlteracao.setBackground(Color.YELLOW);
		jtfDataAlteracao.setBounds(525, 119, 100, 20);
		jpnCliente.add(jtfDataAlteracao);
		
		jlbCidade = new JLabel("Cidade");
		jlbCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCidade.setBounds(10, 426, 46, 14);
		jpnCliente.add(jlbCidade);
		
		jtfCidade = new JTextField();
		jtfCidade.setDocument(new ValidaCampoString());
		jtfCidade.setEnabled(false);
		jtfCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCidade.setColumns(10);
		jtfCidade.setBounds(10, 442, 139, 20);
		jpnCliente.add(jtfCidade);
		
		jlbPais = new JLabel("Pa\u00EDs");
		jlbPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPais.setBounds(346, 426, 46, 14);
		jpnCliente.add(jlbPais);
		
		jtfPais = new JTextField();
		jtfPais.setDocument(new ValidaCampoString());
		jtfPais.setEnabled(false);
		jtfPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPais.setColumns(10);
		jtfPais.setBounds(346, 442, 139, 20);
		jpnCliente.add(jtfPais);
		
		jlbTipoPessoa = new JLabel("Tipo de Pessoa");
		jlbTipoPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTipoPessoa.setBounds(120, 103, 100, 14);
		jpnCliente.add(jlbTipoPessoa);
		
		jlbUnidadeFederativa = new JLabel("Estado");
		jlbUnidadeFederativa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbUnidadeFederativa.setBounds(159, 425, 100, 14);
		jpnCliente.add(jlbUnidadeFederativa);
		
		jlbInscricaoMunicipal = new JLabel("Inscri\u00E7\u00E3o Municipal");
		jlbInscricaoMunicipal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbInscricaoMunicipal.setBounds(320, 238, 130, 14);
		jpnCliente.add(jlbInscricaoMunicipal);
		
		jtfInscricaoMunicipal = new JTextField();
		jtfInscricaoMunicipal.setDocument(new ValidaCampoDocumentoJuridico());
		jtfInscricaoMunicipal.setEnabled(false);
		jtfInscricaoMunicipal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfInscricaoMunicipal.setColumns(10);
		jtfInscricaoMunicipal.setBounds(320, 254, 165, 20);
		getContentPane().add(jtfInscricaoMunicipal);
		
		jrbFisica = new JRadioButton("Pessoa F\u00EDsica");
		jrbFisica.setEnabled(false);
		jrbFisica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jrbFisica.setBounds(120, 119, 120, 23);
		getContentPane().add(jrbFisica);
		
		jrbJuridica = new JRadioButton("Pessoa Jur\u00EDdica");
		jrbJuridica.setEnabled(false);
		jrbJuridica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jrbJuridica.setBounds(242, 118, 120, 23);
		getContentPane().add(jrbJuridica);
		
		jbgTipoPessoa = new ButtonGroup();
		jbgTipoPessoa.add(jrbFisica);
		jbgTipoPessoa.add(jrbJuridica);
		
		jtfTelefoneResidencial = new JTextField();
		jtfTelefoneResidencial.setDocument(new ValidaCampoTelefone());
		jtfTelefoneResidencial.setEnabled(false);
		jtfTelefoneResidencial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneResidencial.setColumns(10);
		jtfTelefoneResidencial.setBounds(495, 348, 130, 20);
		jpnCliente.add(jtfTelefoneResidencial);
		
		jlbTelefoneResidencial = new JLabel("Telefone Residencial");
		jlbTelefoneResidencial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneResidencial.setBounds(495, 332, 130, 14);
		jpnCliente.add(jlbTelefoneResidencial);
		
		jlbEmail = new JLabel("E-mail");
		jlbEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbEmail.setBounds(10, 332, 160, 14);
		jpnCliente.add(jlbEmail);
		
		jtfEmail = new JTextField();
		jtfEmail.setDocument(new ValidaCampoString());
		jtfEmail.setEnabled(false);
		jtfEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfEmail.setColumns(10);
		jtfEmail.setBounds(10, 348, 300, 20);
		jpnCliente.add(jtfEmail);
		
		jlbNome = new JLabel("Nome do Cliente");
		jlbNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNome.setBounds(10, 150, 150, 14);
		jpnCliente.add(jlbNome);
		
		jtfNome = new JTextField();
		jtfNome.setDocument(new ValidaCampoString());
		jtfNome.setEnabled(false);
		jtfNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNome.setColumns(10);
		jtfNome.setBounds(10, 166, 300, 20);
		jpnCliente.add(jtfNome);
		
		jlbCPF = new JLabel("CPF");
		jlbCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCPF.setBounds(320, 150, 100, 14);
		jpnCliente.add(jlbCPF);
		
		try {
			jtfCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfCPF.setEnabled(false);
		jtfCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCPF.setColumns(10);
		jtfCPF.setBounds(320, 166, 165, 20);
		jpnCliente.add(jtfCPF);
		
		jlbRG = new JLabel("R.G.");
		jlbRG.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbRG.setBounds(320, 195, 100, 14);
		jpnCliente.add(jlbRG);
		
		jtfRG = new JTextField();
		jtfRG.setDocument(new ValidaCampoDocumentoFisico());
		jtfRG.setEnabled(false);
		jtfRG.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfRG.setColumns(10);
		jtfRG.setBounds(320, 210, 165, 20);
		jpnCliente.add(jtfRG);
		
		jlbDataNascimento = new JLabel("Data de Nascimento");
		jlbDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataNascimento.setBounds(495, 150, 130, 14);
		jpnCliente.add(jlbDataNascimento);
		
		jckbForaUso = new JCheckBox("Fora de Uso");
		jckbForaUso.setEnabled(false);
		jckbForaUso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jckbForaUso.setBounds(364, 118, 97, 23);
		jpnCliente.add(jckbForaUso);
		
		jtfSobrenomeCliente = new JTextField();
		jtfSobrenomeCliente.setDocument(new ValidaCampoString());
		jtfSobrenomeCliente.setEnabled(false);
		jtfSobrenomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfSobrenomeCliente.setColumns(10);
		jtfSobrenomeCliente.setBounds(10, 210, 300, 20);
		jpnCliente.add(jtfSobrenomeCliente);
		
		jlbSobrenomeCliente = new JLabel("Sobrenome do Cliente");
		jlbSobrenomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbSobrenomeCliente.setBounds(10, 195, 150, 14);
		jpnCliente.add(jlbSobrenomeCliente);
		
		jtfUnidadeFederativa = new JTextField();
		jtfUnidadeFederativa.setDocument(new ValidaCampoString());
		jtfUnidadeFederativa.setEnabled(false);
		jtfUnidadeFederativa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfUnidadeFederativa.setColumns(10);
		jtfUnidadeFederativa.setBounds(159, 443, 177, 20);
		jpnCliente.add(jtfUnidadeFederativa);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 471, 110, 23);
		jpnCliente.add(jbtNovo);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setBounds(515, 471, 110, 23);
		jpnCliente.add(jbtFechar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setEnabled(false);
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setBounds(390, 471, 110, 23);
		jpnCliente.add(jbtCancelar);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setEnabled(false);
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(265, 471, 110, 23);
		jpnCliente.add(jbtSalvar);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setEnabled(false);
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setBounds(138, 471, 110, 23);
		jpnCliente.add(jbtEditar);
		
		jctDataNascimento = new JDateChooser();
		jctDataNascimento.setBounds(495, 166, 130, 20);
		jctDataNascimento.setEnabled(false);
		jpnCliente.add(jctDataNascimento);
	}
	
	public void novoCadastro() {
		jbtNovo.setEnabled(false);
		jrbFisica.setEnabled(true);
		jrbJuridica.setEnabled(true);
		jtfNome.setEnabled(true);
		jtfSobrenomeCliente.setEnabled(true);
		jctDataNascimento.setEnabled(true);
		jtfCPF.setEnabled(true);
		jtfRG.setEnabled(true);
		jtfRazaoSocial.setEnabled(true);
		jtfNomeFantasia.setEnabled(true);
		jtfCNPJ.setEnabled(true);
		jtfInscricaoEstadual.setEnabled(true);
		jtfInscricaoMunicipal.setEnabled(true);
		jtfEmail.setEnabled(true);
		jtfTelefoneCelular.setEnabled(true);
		jtfTelefoneComercial.setEnabled(true);
		jtfTelefoneResidencial.setEnabled(true);
		jtfFax.setEnabled(true);
		jtfEndereco.setEnabled(true);
		jtfNumero.setEnabled(true);
		jtfBairro.setEnabled(true);
		jtfUnidadeFederativa.setEnabled(true);
		jtfCidade.setEnabled(true);
		jtfPais.setEnabled(true);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
	}
	
	public void salvarCadastro() {
		
	}
	
	public void editarCadastro() {
		
	}
	
	public void cancelarCadastro() {
		jbtNovo.setEnabled(true);
		jrbFisica.setEnabled(false);
		jrbJuridica.setEnabled(false);
		jtfNome.setEnabled(false);
		jtfSobrenomeCliente.setEnabled(false);
		jctDataNascimento.setEnabled(false);
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
		jtfUnidadeFederativa.setEnabled(false);
		jtfCidade.setEnabled(false);
		jtfPais.setEnabled(false);
		jtfNome.setText("");
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
		jtfFax.setText("");
		jtfEndereco.setText("");
		jtfNumero.setText("");
		jtfBairro.setText("");
		jtfUnidadeFederativa.setText("");
		jtfCidade.setText("");
		jtfPais.setText("");
		jbtSalvar.setEnabled(false);
		jbtCancelar.setEnabled(false);
	}

	public ClienteForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClienteForm.class.getResource("/Imagens/washCar.jpeg")));
		setResizable(false);
		setTitle("Cadastro de Clientes");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 533);
		jpnCliente = new JPanel();
		jpnCliente.setLayout(null);
		setLocationRelativeTo(null);
		setContentPane(jpnCliente);
		
		componentesTelaCliente();
		
		jbtNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtNovo) {
					novoCadastro();
				}
			}
		});
		
		jbtSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		jbtEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		jbtCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtCancelar) {
					cancelarCadastro();
				}
			}
		});
		
		jbtFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtFechar) {
					dispose();
				}
			}
		});
	}
}