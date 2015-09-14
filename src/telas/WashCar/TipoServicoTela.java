package telas.WashCar;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

import validacaoCampos.WashCar.ValidaCampoNumeroInteiro;
import validacaoCampos.WashCar.ValidaCampoValor;
import java.awt.Toolkit;

public class TipoServicoTela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnTipoServico;
	private JTextField jtfPesquisaCodigoTipoServico;
	private JTextField jtfPesquisaNomeTipoServico;
	private JTextField jtfCodigo;
	private JTextField jtfNomeTipoServico;
	private JTextField jtfDataAlteracao;
	private JTextField jtfValor;
	private JPanel jpnPesquisaTipoServico;
	private JLabel jlbPesquisaCodigoTipoServico;
	private JLabel jlbPesquisaNomeTipoServico;
	private JButton jbtPesquisarTipoServico;
	private JButton jbtNovo;
	private JButton jbtSalvar;
	private JButton jbtEditar;
	private JButton jbtCancelar;
	private JButton jbtFechar;
	private JLabel jlbCodigo;
	private JLabel jlbNomeTipoServico;
	private JLabel jlbDataAlteracao;
	private JLabel jlbValor;
	private JCheckBox jckbForaUso;
	private JLabel jlbConsultaTipoServico;

	public void componenteTelaTipoServico() {
		jpnPesquisaTipoServico = new JPanel();
		jpnPesquisaTipoServico.setLayout(null);
		jpnPesquisaTipoServico.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnPesquisaTipoServico.setBounds(10, 11, 414, 84);
		jpnTipoServico.add(jpnPesquisaTipoServico);
		
		jtfPesquisaCodigoTipoServico = new JTextField();
		jtfPesquisaCodigoTipoServico.setDocument(new ValidaCampoNumeroInteiro());
		jtfPesquisaCodigoTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaCodigoTipoServico.setColumns(10);
		jtfPesquisaCodigoTipoServico.setBounds(10, 52, 66, 20);
		jpnPesquisaTipoServico.add(jtfPesquisaCodigoTipoServico);
		
		jtfPesquisaNomeTipoServico = new JTextField();
		jtfPesquisaNomeTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaNomeTipoServico.setColumns(10);
		jtfPesquisaNomeTipoServico.setBounds(86, 52, 275, 20);
		jpnPesquisaTipoServico.add(jtfPesquisaNomeTipoServico);
		
		jlbPesquisaCodigoTipoServico = new JLabel("C\u00F3digo");
		jlbPesquisaCodigoTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaCodigoTipoServico.setBounds(10, 36, 46, 14);
		jpnPesquisaTipoServico.add(jlbPesquisaCodigoTipoServico);
		
		jlbPesquisaNomeTipoServico = new JLabel("Nome do Tipo de Servi\u00E7o");
		jlbPesquisaNomeTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaNomeTipoServico.setBounds(86, 36, 150, 14);
		jpnPesquisaTipoServico.add(jlbPesquisaNomeTipoServico);
		
		jbtPesquisarTipoServico = new JButton("");
		jbtPesquisarTipoServico.setIcon(new ImageIcon(TipoServicoTela.class.getResource("/Imagens/lupaPesquisa.jpeg")));
		jbtPesquisarTipoServico.setBounds(367, 41, 40, 32);
		jpnPesquisaTipoServico.add(jbtPesquisarTipoServico);
		
		jlbConsultaTipoServico = new JLabel("Consulta Tipos de Servi\u00E7o");
		jlbConsultaTipoServico.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbConsultaTipoServico.setBounds(10, 11, 200, 14);
		jpnPesquisaTipoServico.add(jlbConsultaTipoServico);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 218, 75, 23);
		jpnTipoServico.add(jbtNovo);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setEnabled(false);
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(93, 218, 75, 23);
		jpnTipoServico.add(jbtSalvar);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setEnabled(false);
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setBounds(178, 218, 75, 23);
		jpnTipoServico.add(jbtEditar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setEnabled(false);
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setBounds(261, 218, 80, 23);
		jpnTipoServico.add(jbtCancelar);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setToolTipText("");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setBounds(350, 218, 75, 23);
		jpnTipoServico.add(jbtFechar);
		
		jtfCodigo = new JTextField();
		jtfCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigo.setEditable(false);
		jtfCodigo.setColumns(10);
		jtfCodigo.setBackground(Color.YELLOW);
		jtfCodigo.setBounds(10, 123, 86, 20);
		jpnTipoServico.add(jtfCodigo);
		
		jtfNomeTipoServico = new JTextField();
		jtfNomeTipoServico.setEnabled(false);
		jtfNomeTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeTipoServico.setColumns(10);
		jtfNomeTipoServico.setBounds(10, 181, 243, 20);
		jpnTipoServico.add(jtfNomeTipoServico);
		
		jlbCodigo = new JLabel("C\u00F3digo");
		jlbCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigo.setBounds(10, 106, 46, 14);
		jpnTipoServico.add(jlbCodigo);
		
		jlbNomeTipoServico = new JLabel("Nome do Tipo de Servi\u00E7o");
		jlbNomeTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeTipoServico.setBounds(10, 164, 150, 14);
		jpnTipoServico.add(jlbNomeTipoServico);
		
		try {
			jtfDataAlteracao = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfDataAlteracao.setEditable(false);
		jtfDataAlteracao.setColumns(10);
		jtfDataAlteracao.setBackground(Color.YELLOW);
		jtfDataAlteracao.setBounds(323, 122, 101, 20);
		jpnTipoServico.add(jtfDataAlteracao);
		
		jlbDataAlteracao = new JLabel("Data Altera\u00E7\u00E3o");
		jlbDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataAlteracao.setBounds(323, 106, 101, 14);
		jpnTipoServico.add(jlbDataAlteracao);
		
		jtfValor = new JTextField();
		jtfValor.setDocument(new ValidaCampoValor());
		jtfValor.setEnabled(false);
		jtfValor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfValor.setColumns(10);
		jtfValor.setBackground(Color.WHITE);
		jtfValor.setBounds(274, 181, 150, 20);
		jpnTipoServico.add(jtfValor);
		
		jlbValor = new JLabel("Valor do Tipo de Servi\u00E7o");
		jlbValor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbValor.setBounds(274, 164, 150, 14);
		jpnTipoServico.add(jlbValor);
		
		jckbForaUso = new JCheckBox("Fora de Uso");
		jckbForaUso.setEnabled(false);
		jckbForaUso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jckbForaUso.setBounds(170, 121, 97, 23);
		jpnTipoServico.add(jckbForaUso);
	}
	
	public void novoCadastro() {
		jbtNovo.setEnabled(false);
		jtfNomeTipoServico.setEnabled(true);
		jtfValor.setEnabled(true);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
	}
	
	public void salvarCadastro() {
		
	}
	
	public void editarCadastro() {
		
	}
	
	public void cancelarCadastro() {
		jbtNovo.setEnabled(true);
		jtfNomeTipoServico.setEnabled(false);
		jtfValor.setEnabled(false);
		jtfNomeTipoServico.setText("");
		jtfValor.setText("");
		jbtSalvar.setEnabled(false);
		jbtCancelar.setEnabled(false);
	}

	public TipoServicoTela() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TipoServicoTela.class.getResource("/Imagens/washCar.jpeg")));
		setTitle("Cadastrar Tipos de Serviço | WashCar");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 440, 283);
		jpnTipoServico = new JPanel();
		jpnTipoServico.setLayout(null);
		setLocationRelativeTo(null);
		setContentPane(jpnTipoServico);
		
		componenteTelaTipoServico();
		
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