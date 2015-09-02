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
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public class EmpresaTela extends JFrame {

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
	private JTextField textField_10;
	private JTextField jtfFax;
	private JTextField jtfInscricaoEstadual;
	private JTextField jtfDataAlteracao;
	private JTextField jtfCidade;
	private JTextField jtfPais;
	private JTextField jtfPesquisaCNPJEmpresa;
	private JTextField jtfInscricaoMunicipal;
	private JPanel jpnPesquisaEmpresa;
	private JLabel jlbPesquisaCodigoEmpresa;
	private JLabel jlbPesquisaNomeEmpresa;
	private JButton jbtPesquisaEmpresa;
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
	private JRadioButton jrbSimplesNacional;
	private JRadioButton jrbLucroPresumido;
	private JRadioButton jrbLucroReal;
	private ButtonGroup jbgRegimeTributario;
	private JTextField jtfUnidadeFederativa;
	private JButton jbtNovo;
	private JButton jbtEditar;
	private JButton jbtSalvar;
	private JButton jbtCancelar;
	private JButton jbtFechar;

	public void componentesTelaEmpresa() {
		jpnPesquisaEmpresa = new JPanel();
		jpnPesquisaEmpresa.setLayout(null);
		jpnPesquisaEmpresa.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnPesquisaEmpresa.setBounds(10, 11, 615, 55);
		jnpEmpresa.add(jpnPesquisaEmpresa);
		
		jlbPesquisaCodigoEmpresa = new JLabel("C\u00F3digo");
		jlbPesquisaCodigoEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaCodigoEmpresa.setBounds(10, 11, 46, 14);
		jpnPesquisaEmpresa.add(jlbPesquisaCodigoEmpresa);
		
		jtfPesquisaCodigoEmpresa = new JTextField();
		jtfPesquisaCodigoEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaCodigoEmpresa.setColumns(10);
		jtfPesquisaCodigoEmpresa.setBounds(10, 27, 66, 20);
		jpnPesquisaEmpresa.add(jtfPesquisaCodigoEmpresa);
		
		jlbPesquisaNomeEmpresa = new JLabel("Nome da Empresa");
		jlbPesquisaNomeEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaNomeEmpresa.setBounds(86, 11, 100, 14);
		jpnPesquisaEmpresa.add(jlbPesquisaNomeEmpresa);
		
		jtfPesquisaNomeEmpresa = new JTextField();
		jtfPesquisaNomeEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaNomeEmpresa.setColumns(10);
		jtfPesquisaNomeEmpresa.setBounds(86, 27, 275, 20);
		jpnPesquisaEmpresa.add(jtfPesquisaNomeEmpresa);
		
		jbtPesquisaEmpresa = new JButton("");
		jbtPesquisaEmpresa.setIcon(new ImageIcon(EmpresaTela.class.getResource("/Imagens/lupaPesquisa.jpeg")));
		jbtPesquisaEmpresa.setBounds(565, 15, 40, 32);
		jpnPesquisaEmpresa.add(jbtPesquisaEmpresa);
		
		jtfPesquisaCNPJEmpresa = new JTextField();
		jtfPesquisaCNPJEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaCNPJEmpresa.setColumns(10);
		jtfPesquisaCNPJEmpresa.setBounds(371, 27, 165, 20);
		jpnPesquisaEmpresa.add(jtfPesquisaCNPJEmpresa);
		
		jlbPesquisaCNPJEmpresa = new JLabel("CNPJ da Empresa");
		jlbPesquisaCNPJEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaCNPJEmpresa.setBounds(371, 11, 100, 14);
		jpnPesquisaEmpresa.add(jlbPesquisaCNPJEmpresa);
		
		jlbCodigo = new JLabel("C\u00F3digo");
		jlbCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigo.setBounds(10, 77, 46, 14);
		jnpEmpresa.add(jlbCodigo);
		
		jtfCodigo = new JTextField();
		jtfCodigo.setEditable(false);
		jtfCodigo.setBackground(Color.YELLOW);
		jtfCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigo.setColumns(10);
		jtfCodigo.setBounds(10, 93, 66, 20);
		jnpEmpresa.add(jtfCodigo);
		
		jlbRazaoSocial = new JLabel("Raz\u00E3o Social da Empresa");
		jlbRazaoSocial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbRazaoSocial.setBounds(10, 124, 150, 14);
		jnpEmpresa.add(jlbRazaoSocial);
		
		jtfRazaoSocial = new JTextField();
		jtfRazaoSocial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfRazaoSocial.setColumns(10);
		jtfRazaoSocial.setBounds(10, 140, 300, 20);
		jnpEmpresa.add(jtfRazaoSocial);
		
		jlbNomeFantasia = new JLabel("Nome Fantasia da Empresa");
		jlbNomeFantasia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeFantasia.setBounds(10, 171, 160, 14);
		jnpEmpresa.add(jlbNomeFantasia);
		
		jtfNomeFantasia = new JTextField();
		jtfNomeFantasia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeFantasia.setColumns(10);
		jtfNomeFantasia.setBounds(10, 187, 300, 20);
		jnpEmpresa.add(jtfNomeFantasia);
		
		jlbCNPJ = new JLabel("CNPJ");
		jlbCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCNPJ.setBounds(320, 124, 100, 14);
		jnpEmpresa.add(jlbCNPJ);
		
		jtfCNPJ = new JTextField();
		jtfCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCNPJ.setColumns(10);
		jtfCNPJ.setBounds(320, 140, 165, 20);
		jnpEmpresa.add(jtfCNPJ);
		
		jlbEndereco = new JLabel("Endere\u00E7o");
		jlbEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbEndereco.setBounds(10, 218, 80, 14);
		jnpEmpresa.add(jlbEndereco);
		
		jtfEndereco = new JTextField();
		jtfEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfEndereco.setColumns(10);
		jtfEndereco.setBounds(10, 234, 250, 20);
		jnpEmpresa.add(jtfEndereco);
		
		jlbBairro = new JLabel("Bairro");
		jlbBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbBairro.setBounds(346, 218, 46, 14);
		jnpEmpresa.add(jlbBairro);
		
		jtfBairro = new JTextField();
		jtfBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfBairro.setColumns(10);
		jtfBairro.setBounds(346, 234, 139, 20);
		jnpEmpresa.add(jtfBairro);
		
		jlbNumero = new JLabel("N\u00FAmero");
		jlbNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNumero.setBounds(270, 218, 46, 14);
		jnpEmpresa.add(jlbNumero);
		
		jtfNumero = new JTextField();
		jtfNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNumero.setColumns(10);
		jtfNumero.setBounds(270, 234, 66, 20);
		jnpEmpresa.add(jtfNumero);
		
		jlbTelefoneComercial = new JLabel("Telefone Comercial");
		jlbTelefoneComercial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneComercial.setBounds(495, 171, 130, 14);
		jnpEmpresa.add(jlbTelefoneComercial);
		
		jtfTelefoneComercial = new JTextField();
		jtfTelefoneComercial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTelefoneComercial.setColumns(10);
		jtfTelefoneComercial.setBounds(495, 187, 130, 20);
		jnpEmpresa.add(jtfTelefoneComercial);
		
		jlbTelefoneCelular = new JLabel("Telefone Celular");
		jlbTelefoneCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbTelefoneCelular.setBounds(495, 218, 130, 14);
		jnpEmpresa.add(jlbTelefoneCelular);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_10.setColumns(10);
		textField_10.setBounds(495, 234, 130, 20);
		jnpEmpresa.add(textField_10);
		
		jlbFax = new JLabel("Fax");
		jlbFax.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbFax.setBounds(495, 265, 46, 14);
		jnpEmpresa.add(jlbFax);
		
		jtfFax = new JTextField();
		jtfFax.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfFax.setColumns(10);
		jtfFax.setBounds(495, 281, 130, 20);
		jnpEmpresa.add(jtfFax);
		
		jlbInscricaoEstadual = new JLabel("Inscri\u00E7\u00E3o Estadual");
		jlbInscricaoEstadual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbInscricaoEstadual.setBounds(320, 171, 165, 14);
		jnpEmpresa.add(jlbInscricaoEstadual);
		
		jtfInscricaoEstadual = new JTextField();
		jtfInscricaoEstadual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfInscricaoEstadual.setColumns(10);
		jtfInscricaoEstadual.setBounds(320, 187, 165, 20);
		jnpEmpresa.add(jtfInscricaoEstadual);
		
		jlbDataAlteracao = new JLabel("Data Alteracao");
		jlbDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataAlteracao.setBounds(495, 77, 130, 14);
		jnpEmpresa.add(jlbDataAlteracao);
		
		jtfDataAlteracao = new JTextField();
		jtfDataAlteracao.setBackground(Color.YELLOW);
		jtfDataAlteracao.setEditable(false);
		jtfDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfDataAlteracao.setColumns(10);
		jtfDataAlteracao.setBounds(495, 93, 130, 20);
		jnpEmpresa.add(jtfDataAlteracao);
		
		jlbCidade = new JLabel("Cidade");
		jlbCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCidade.setBounds(10, 265, 46, 14);
		jnpEmpresa.add(jlbCidade);
		
		jtfCidade = new JTextField();
		jtfCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCidade.setColumns(10);
		jtfCidade.setBounds(10, 281, 139, 20);
		jnpEmpresa.add(jtfCidade);
		
		jlbPais = new JLabel("Pa\u00EDs");
		jlbPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPais.setBounds(346, 265, 46, 14);
		jnpEmpresa.add(jlbPais);
		
		jtfPais = new JTextField();
		jtfPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPais.setColumns(10);
		jtfPais.setBounds(346, 281, 139, 20);
		jnpEmpresa.add(jtfPais);
		
		jlbRegimeTributario = new JLabel("Regime Tribut\u00E1rio");
		jlbRegimeTributario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbRegimeTributario.setBounds(120, 77, 100, 14);
		jnpEmpresa.add(jlbRegimeTributario);
		
		jlbUnidadeFederativa = new JLabel("Estado");
		jlbUnidadeFederativa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbUnidadeFederativa.setBounds(159, 264, 100, 14);
		jnpEmpresa.add(jlbUnidadeFederativa);
		
		jlbInscricaoMunicipal = new JLabel("Inscri\u00E7\u00E3o Municipal");
		jlbInscricaoMunicipal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbInscricaoMunicipal.setBounds(495, 124, 130, 14);
		jnpEmpresa.add(jlbInscricaoMunicipal);
		
		jtfInscricaoMunicipal = new JTextField();
		jtfInscricaoMunicipal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfInscricaoMunicipal.setColumns(10);
		jtfInscricaoMunicipal.setBounds(495, 140, 130, 20);
		jnpEmpresa.add(jtfInscricaoMunicipal);
		
		jrbSimplesNacional = new JRadioButton("Simples Nacional");
		jrbSimplesNacional.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jrbSimplesNacional.setBounds(120, 93, 120, 23);
		getContentPane().add(jrbSimplesNacional);
		
		jrbLucroPresumido = new JRadioButton("Lucro Presumido");
		jrbLucroPresumido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jrbLucroPresumido.setBounds(242, 92, 120, 23);
		getContentPane().add(jrbLucroPresumido);
		
		jrbLucroReal = new JRadioButton("Lucro Real");
		jrbLucroReal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jrbLucroReal.setBounds(364, 92, 109, 23);
		getContentPane().add(jrbLucroReal);
		
		jbgRegimeTributario = new ButtonGroup();
		jbgRegimeTributario.add(jrbSimplesNacional);
		jbgRegimeTributario.add(jrbLucroReal);
		jbgRegimeTributario.add(jrbLucroPresumido);
		
		jtfUnidadeFederativa = new JTextField();
		jtfUnidadeFederativa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfUnidadeFederativa.setColumns(10);
		jtfUnidadeFederativa.setBounds(159, 282, 177, 20);
		jnpEmpresa.add(jtfUnidadeFederativa);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 311, 110, 23);
		jnpEmpresa.add(jbtNovo);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setBounds(138, 311, 110, 23);
		jnpEmpresa.add(jbtEditar);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(265, 311, 110, 23);
		jnpEmpresa.add(jbtSalvar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setBounds(390, 311, 110, 23);
		jnpEmpresa.add(jbtCancelar);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setBounds(515, 311, 110, 23);
		jnpEmpresa.add(jbtFechar);
	}

	public EmpresaTela() {
		setTitle("Cadastro da Empresa");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 641, 373);
		jnpEmpresa = new JPanel();
		setLocationRelativeTo(null);
		jnpEmpresa.setLayout(null);
		setContentPane(jnpEmpresa);

		componentesTelaEmpresa();
		
	}
}