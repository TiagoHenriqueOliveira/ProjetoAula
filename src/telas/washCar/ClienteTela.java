package telas.washCar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class ClienteTela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnCliente;
	private JTextField jtfPesquisaCodigoCliente;
	private JTextField jtfPesquisaNomeCliente;
	private JTextField jtfCnpjDoCliente;
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
	private JTextField jtfDataNascimento;
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

	public void componentesTelaCliente() {
		jpnPesquisaCliente = new JPanel();
		jpnPesquisaCliente.setLayout(null);
		jpnPesquisaCliente.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnPesquisaCliente.setBounds(10, 11, 615, 55);
		jpnCliente.add(jpnPesquisaCliente);
		
		jlbPesquisaCodigoCliente = new JLabel("C\u00F3digo");
		jlbPesquisaCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaCodigoCliente.setBounds(10, 11, 46, 14);
		jpnPesquisaCliente.add(jlbPesquisaCodigoCliente);
		
		jtfPesquisaCodigoCliente = new JTextField();
		jtfPesquisaCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaCodigoCliente.setColumns(10);
		jtfPesquisaCodigoCliente.setBounds(10, 27, 66, 20);
		jpnPesquisaCliente.add(jtfPesquisaCodigoCliente);
		
		jlbPesquisaNomeCliente = new JLabel("Nome do Cliente");
		jlbPesquisaNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaNomeCliente.setBounds(86, 11, 100, 14);
		jpnPesquisaCliente.add(jlbPesquisaNomeCliente);
		
		jtfPesquisaNomeCliente = new JTextField();
		jtfPesquisaNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaNomeCliente.setColumns(10);
		jtfPesquisaNomeCliente.setBounds(86, 27, 275, 20);
		jpnPesquisaCliente.add(jtfPesquisaNomeCliente);
		
		jbtPesquisaCliente = new JButton("");
		jbtPesquisaCliente.setIcon(new ImageIcon(ClienteTela.class.getResource("/Imagens/lupaPesquisa.jpeg")));
		jbtPesquisaCliente.setBounds(565, 15, 40, 32);
		jpnPesquisaCliente.add(jbtPesquisaCliente);
		
		jtfCnpjDoCliente = new JTextField();
		jtfCnpjDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCnpjDoCliente.setColumns(10);
		jtfCnpjDoCliente.setBounds(371, 27, 165, 20);
		jpnPesquisaCliente.add(jtfCnpjDoCliente);
		
		jlbCnpjDoCliente = new JLabel("CNPJ do Cliente");
		jlbCnpjDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCnpjDoCliente.setBounds(371, 11, 100, 14);
		jpnPesquisaCliente.add(jlbCnpjDoCliente);
		
		jlbCodigo = new JLabel("C\u00F3digo");
		jlbCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigo.setBounds(10, 77, 46, 14);
		jpnCliente.add(jlbCodigo);
		
		jtfCodigo = new JTextField();
		jtfCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigo.setEditable(false);
		jtfCodigo.setColumns(10);
		jtfCodigo.setBackground(Color.YELLOW);
		jtfCodigo.setBounds(10, 93, 66, 20);
		jpnCliente.add(jtfCodigo);
		
		jlbRazaoSocial = new JLabel("Raz\u00E3o Social");
		jlbRazaoSocial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbRazaoSocial.setBounds(10, 212, 150, 14);
		jpnCliente.add(jlbRazaoSocial);
		
		jtfRazaoSocial = new JTextField();
		jtfRazaoSocial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfRazaoSocial.setColumns(10);
		jtfRazaoSocial.setBounds(10, 228, 300, 20);
		jpnCliente.add(jtfRazaoSocial);
		
		jlbNomeFantasia = new JLabel("Nome Fantasia");
		jlbNomeFantasia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeFantasia.setBounds(10, 259, 160, 14);
		jpnCliente.add(jlbNomeFantasia);
		
		jtfNomeFantasia = new JTextField();
		jtfNomeFantasia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeFantasia.setColumns(10);
		jtfNomeFantasia.setBounds(10, 275, 300, 20);
		jpnCliente.add(jtfNomeFantasia);
		
		jlbCNPJ = new JLabel("CNPJ");
		jlbCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCNPJ.setBounds(320, 259, 100, 14);
		jpnCliente.add(jlbCNPJ);
		
		jtfCNPJ = new JTextField();
		jtfCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCNPJ.setColumns(10);
		jtfCNPJ.setBounds(320, 275, 165, 20);
		jpnCliente.add(jtfCNPJ);
		
		jlbEndereco = new JLabel("Endere\u00E7o");
		jlbEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbEndereco.setBounds(10, 353, 80, 14);
		jpnCliente.add(jlbEndereco);
		
		jtfEndereco = new JTextField();
		jtfEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfEndereco.setColumns(10);
		jtfEndereco.setBounds(10, 369, 250, 20);
		jpnCliente.add(jtfEndereco);
		
		jlbBairro = new JLabel("Bairro");
		jlbBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbBairro.setBounds(346, 353, 46, 14);
		jpnCliente.add(jlbBairro);
		
		jtfBairro = new JTextField();
		jtfBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfBairro.setColumns(10);
		jtfBairro.setBounds(346, 369, 139, 20);
		jpnCliente.add(jtfBairro);
		
		jlbNumero = new JLabel("N\u00FAmero");
		jlbNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNumero.setBounds(270, 353, 46, 14);
		jpnCliente.add(jlbNumero);
		
		jtfNumero = new JTextField();
		jtfNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNumero.setColumns(10);
		jtfNumero.setBounds(270, 369, 66, 20);
		jpnCliente.add(jtfNumero);
		
		jlbTelefoneComercial = new JLabel("Telefone Comercial");
		jlbTelefoneComercial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneComercial.setBounds(495, 259, 130, 14);
		jpnCliente.add(jlbTelefoneComercial);
		
		jtfTelefoneComercial = new JTextField();
		jtfTelefoneComercial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneComercial.setColumns(10);
		jtfTelefoneComercial.setBounds(495, 275, 130, 20);
		jpnCliente.add(jtfTelefoneComercial);
		
		jlbTelefoneCelular = new JLabel("Telefone Celular");
		jlbTelefoneCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneCelular.setBounds(495, 353, 130, 14);
		jpnCliente.add(jlbTelefoneCelular);
		
		jtfTelefoneCelular = new JTextField();
		jtfTelefoneCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneCelular.setColumns(10);
		jtfTelefoneCelular.setBounds(495, 369, 130, 20);
		jpnCliente.add(jtfTelefoneCelular);
		
		jlbFax = new JLabel("Fax");
		jlbFax.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbFax.setBounds(495, 400, 46, 14);
		jpnCliente.add(jlbFax);
		
		jtfFax = new JTextField();
		jtfFax.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfFax.setColumns(10);
		jtfFax.setBounds(495, 416, 130, 20);
		jpnCliente.add(jtfFax);
		
		jlbInscricaoEstadual = new JLabel("Inscri\u00E7\u00E3o Estadual");
		jlbInscricaoEstadual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbInscricaoEstadual.setBounds(320, 306, 165, 14);
		jpnCliente.add(jlbInscricaoEstadual);
		
		jtfInscricaoEstadual = new JTextField();
		jtfInscricaoEstadual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfInscricaoEstadual.setColumns(10);
		jtfInscricaoEstadual.setBounds(320, 322, 165, 20);
		jpnCliente.add(jtfInscricaoEstadual);
		
		jlbDataAlteracao = new JLabel("Data Alteracao");
		jlbDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataAlteracao.setBounds(495, 77, 130, 14);
		jpnCliente.add(jlbDataAlteracao);
		
		jtfDataAlteracao = new JTextField();
		jtfDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfDataAlteracao.setEditable(false);
		jtfDataAlteracao.setColumns(10);
		jtfDataAlteracao.setBackground(Color.YELLOW);
		jtfDataAlteracao.setBounds(495, 93, 130, 20);
		jpnCliente.add(jtfDataAlteracao);
		
		jlbCidade = new JLabel("Cidade");
		jlbCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCidade.setBounds(10, 400, 46, 14);
		jpnCliente.add(jlbCidade);
		
		jtfCidade = new JTextField();
		jtfCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCidade.setColumns(10);
		jtfCidade.setBounds(10, 416, 139, 20);
		jpnCliente.add(jtfCidade);
		
		jlbPais = new JLabel("Pa\u00EDs");
		jlbPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPais.setBounds(346, 400, 46, 14);
		jpnCliente.add(jlbPais);
		
		jtfPais = new JTextField();
		jtfPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPais.setColumns(10);
		jtfPais.setBounds(346, 416, 139, 20);
		jpnCliente.add(jtfPais);
		
		jlbTipoPessoa = new JLabel("Tipo de Pessoa");
		jlbTipoPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTipoPessoa.setBounds(120, 77, 100, 14);
		jpnCliente.add(jlbTipoPessoa);
		
		jlbUnidadeFederativa = new JLabel("Estado");
		jlbUnidadeFederativa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbUnidadeFederativa.setBounds(159, 399, 100, 14);
		jpnCliente.add(jlbUnidadeFederativa);
		
		jlbInscricaoMunicipal = new JLabel("Inscri\u00E7\u00E3o Municipal");
		jlbInscricaoMunicipal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbInscricaoMunicipal.setBounds(320, 212, 130, 14);
		jpnCliente.add(jlbInscricaoMunicipal);
		
		jtfInscricaoMunicipal = new JTextField();
		jtfInscricaoMunicipal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfInscricaoMunicipal.setColumns(10);
		jtfInscricaoMunicipal.setBounds(320, 228, 165, 20);
		getContentPane().add(jtfInscricaoMunicipal);
		
		jrbFisica = new JRadioButton("Pessoa F\u00EDsica");
		jrbFisica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jrbFisica.setBounds(120, 93, 120, 23);
		getContentPane().add(jrbFisica);
		
		jrbJuridica = new JRadioButton("Pessoa Jur\u00EDdica");
		jrbJuridica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jrbJuridica.setBounds(242, 92, 120, 23);
		getContentPane().add(jrbJuridica);
		
		jbgTipoPessoa = new ButtonGroup();
		jbgTipoPessoa.add(jrbFisica);
		jbgTipoPessoa.add(jrbJuridica);
		
		jtfTelefoneResidencial = new JTextField();
		jtfTelefoneResidencial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneResidencial.setColumns(10);
		jtfTelefoneResidencial.setBounds(495, 322, 130, 20);
		jpnCliente.add(jtfTelefoneResidencial);
		
		jlbTelefoneResidencial = new JLabel("Telefone Residencial");
		jlbTelefoneResidencial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneResidencial.setBounds(495, 306, 130, 14);
		jpnCliente.add(jlbTelefoneResidencial);
		
		jlbEmail = new JLabel("E-mail");
		jlbEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbEmail.setBounds(10, 306, 160, 14);
		jpnCliente.add(jlbEmail);
		
		jtfEmail = new JTextField();
		jtfEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfEmail.setColumns(10);
		jtfEmail.setBounds(10, 322, 300, 20);
		jpnCliente.add(jtfEmail);
		
		jlbNome = new JLabel("Nome do Cliente");
		jlbNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNome.setBounds(10, 124, 150, 14);
		jpnCliente.add(jlbNome);
		
		jtfNome = new JTextField();
		jtfNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNome.setColumns(10);
		jtfNome.setBounds(10, 140, 300, 20);
		jpnCliente.add(jtfNome);
		
		jlbCPF = new JLabel("CPF");
		jlbCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCPF.setBounds(320, 124, 100, 14);
		jpnCliente.add(jlbCPF);
		
		jtfCPF = new JTextField();
		jtfCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCPF.setColumns(10);
		jtfCPF.setBounds(320, 140, 165, 20);
		jpnCliente.add(jtfCPF);
		
		jlbRG = new JLabel("R.G.");
		jlbRG.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbRG.setBounds(320, 169, 100, 14);
		jpnCliente.add(jlbRG);
		
		jtfRG = new JTextField();
		jtfRG.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfRG.setColumns(10);
		jtfRG.setBounds(320, 184, 165, 20);
		jpnCliente.add(jtfRG);
		
		jtfDataNascimento = new JTextField();
		jtfDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfDataNascimento.setColumns(10);
		jtfDataNascimento.setBounds(495, 140, 130, 20);
		jpnCliente.add(jtfDataNascimento);
		
		jlbDataNascimento = new JLabel("Data de Nascimento");
		jlbDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataNascimento.setBounds(495, 124, 130, 14);
		jpnCliente.add(jlbDataNascimento);
		
		jckbForaUso = new JCheckBox("Fora de Uso");
		jckbForaUso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jckbForaUso.setBounds(364, 92, 97, 23);
		jpnCliente.add(jckbForaUso);
		
		jtfSobrenomeCliente = new JTextField();
		jtfSobrenomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfSobrenomeCliente.setColumns(10);
		jtfSobrenomeCliente.setBounds(10, 184, 300, 20);
		jpnCliente.add(jtfSobrenomeCliente);
		
		jlbSobrenomeCliente = new JLabel("Sobrenome do Cliente");
		jlbSobrenomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbSobrenomeCliente.setBounds(10, 169, 150, 14);
		jpnCliente.add(jlbSobrenomeCliente);
		
		jtfUnidadeFederativa = new JTextField();
		jtfUnidadeFederativa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfUnidadeFederativa.setColumns(10);
		jtfUnidadeFederativa.setBounds(159, 417, 177, 20);
		jpnCliente.add(jtfUnidadeFederativa);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 445, 110, 23);
		jpnCliente.add(jbtNovo);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setBounds(515, 445, 110, 23);
		jpnCliente.add(jbtFechar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setBounds(390, 445, 110, 23);
		jpnCliente.add(jbtCancelar);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(265, 445, 110, 23);
		jpnCliente.add(jbtSalvar);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setBounds(138, 445, 110, 23);
		jpnCliente.add(jbtEditar);
	}

	public ClienteTela() {
		setResizable(false);
		setTitle("Cadastro de Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 507);
		jpnCliente = new JPanel();
		jpnCliente.setLayout(null);
		setLocationRelativeTo(null);
		setContentPane(jpnCliente);
		
		componentesTelaCliente();

	}
}