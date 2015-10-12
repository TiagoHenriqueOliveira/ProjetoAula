package forms.WashCar;

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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.SwingConstants;

public class TipoServicoForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnTipoServico;
	private JPanel jpnPesquisaTipoServico;
	private JTextField jtfPesquisaCodigoTipoServico;
	private JTextField jtfPesquisaNomeTipoServico;
	private JTextField jtfCodigo;
	private JTextField jtfNomeTipoServico;
	private JTextField jtfDataAlteracao;
	private JTextField jtfValor;
	private JLabel jlbCodigo;
	private JLabel jlbNomeTipoServico;
	private JLabel jlbDataAlteracao;
	private JLabel jlbValor;
	private JLabel jlbConsultaTipoServico;
	private JLabel jlbPesquisaCodigoTipoServico;
	private JLabel jlbPesquisaNomeTipoServico;
	private JButton jbtPesquisarTipoServico;
	private JButton jbtNovo;
	private JButton jbtSalvar;
	private JButton jbtEditar;
	private JButton jbtCancelar;
	private JButton jbtFechar;
	private JCheckBox jckbForaUso;
	private JMenu mnRelatrios;
	private JMenuBar jmbTipoServico;
	

	public void componenteTelaTipoServico() {		
		jmbTipoServico = new JMenuBar();
		jmbTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		setJMenuBar(jmbTipoServico);
		
		mnRelatrios = new JMenu("Relat\u00F3rios");
		mnRelatrios.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jmbTipoServico.add(mnRelatrios);
		setContentPane(jpnTipoServico);
		
		jpnPesquisaTipoServico = new JPanel();
		jpnPesquisaTipoServico.setLayout(null);
		jpnPesquisaTipoServico.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnPesquisaTipoServico.setBounds(10, 11, 640, 84);
		jpnTipoServico.add(jpnPesquisaTipoServico);
		
		jtfPesquisaCodigoTipoServico = new JTextField();
		jtfPesquisaCodigoTipoServico.setDocument(new ValidaCampoNumeroInteiro());
		jtfPesquisaCodigoTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaCodigoTipoServico.setColumns(10);
		jtfPesquisaCodigoTipoServico.setBounds(10, 52, 50, 20);
		jpnPesquisaTipoServico.add(jtfPesquisaCodigoTipoServico);
		
		jtfPesquisaNomeTipoServico = new JTextField();
		jtfPesquisaNomeTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPesquisaNomeTipoServico.setColumns(10);
		jtfPesquisaNomeTipoServico.setBounds(86, 52, 334, 20);
		jpnPesquisaTipoServico.add(jtfPesquisaNomeTipoServico);
		
		jlbPesquisaCodigoTipoServico = new JLabel("C\u00F3digo");
		jlbPesquisaCodigoTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaCodigoTipoServico.setBounds(10, 36, 66, 14);
		jpnPesquisaTipoServico.add(jlbPesquisaCodigoTipoServico);
		
		jlbPesquisaNomeTipoServico = new JLabel("Nome do Tipo de Servi\u00E7o");
		jlbPesquisaNomeTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbPesquisaNomeTipoServico.setBounds(86, 36, 275, 14);
		jpnPesquisaTipoServico.add(jlbPesquisaNomeTipoServico);
		
		jbtPesquisarTipoServico = new JButton("");
		jbtPesquisarTipoServico.setIcon(new ImageIcon(TipoServicoForm.class.getResource("/Imagens/lupaPesquisa.jpeg")));
		jbtPesquisarTipoServico.setBounds(430, 40, 40, 32);
		jpnPesquisaTipoServico.add(jbtPesquisarTipoServico);
		
		jlbConsultaTipoServico = new JLabel("Consulta Tipos de Servi\u00E7o");
		jlbConsultaTipoServico.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbConsultaTipoServico.setBounds(10, 11, 200, 14);
		jpnPesquisaTipoServico.add(jlbConsultaTipoServico);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 197, 120, 25);
		jpnTipoServico.add(jbtNovo);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setEnabled(false);
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setBounds(140, 197, 120, 25);
		jpnTipoServico.add(jbtSalvar);
		
		jbtEditar = new JButton("Editar");
		jbtEditar.setEnabled(false);
		jbtEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtEditar.setBounds(270, 197, 120, 25);
		jpnTipoServico.add(jbtEditar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setEnabled(false);
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setBounds(400, 197, 120, 25);
		jpnTipoServico.add(jbtCancelar);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setToolTipText("");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setBounds(530, 197, 120, 25);
		jpnTipoServico.add(jbtFechar);
		
		jtfCodigo = new JTextField();
		jtfCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigo.setEditable(false);
		jtfCodigo.setColumns(10);
		jtfCodigo.setBackground(Color.YELLOW);
		jtfCodigo.setBounds(10, 120, 50, 20);
		jpnTipoServico.add(jtfCodigo);
		
		jtfNomeTipoServico = new JTextField();
		jtfNomeTipoServico.setEnabled(false);
		jtfNomeTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeTipoServico.setColumns(10);
		jtfNomeTipoServico.setBounds(10, 166, 414, 20);
		jpnTipoServico.add(jtfNomeTipoServico);
		
		jlbCodigo = new JLabel("C\u00F3digo");
		jlbCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigo.setBounds(10, 106, 86, 14);
		jpnTipoServico.add(jlbCodigo);
		
		jlbNomeTipoServico = new JLabel("Nome do Tipo de Servi\u00E7o");
		jlbNomeTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbNomeTipoServico.setBounds(10, 151, 380, 14);
		jpnTipoServico.add(jlbNomeTipoServico);
		
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
		jtfDataAlteracao.setBounds(549, 120, 101, 20);
		jpnTipoServico.add(jtfDataAlteracao);
		
		jlbDataAlteracao = new JLabel("Data Altera\u00E7\u00E3o");
		jlbDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataAlteracao.setBounds(549, 107, 101, 14);
		jpnTipoServico.add(jlbDataAlteracao);
		
		jtfValor = new JTextField();
		jtfValor.setEnabled(false);
		jtfValor.setDocument(new ValidaCampoValor());
		jtfValor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfValor.setColumns(10);
		jtfValor.setBackground(Color.WHITE);
		jtfValor.setBounds(434, 166, 120, 20);
		jpnTipoServico.add(jtfValor);
		
		jlbValor = new JLabel("Valor do Tipo de Servi\u00E7o");
		jlbValor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbValor.setBounds(434, 151, 216, 14);
		jpnTipoServico.add(jlbValor);
		
		jckbForaUso = new JCheckBox("Fora de Uso");
		jckbForaUso.setEnabled(false);
		jckbForaUso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jckbForaUso.setBounds(260, 119, 130, 23);
		jpnTipoServico.add(jckbForaUso);
	}
	
	public void acionarBotaoNovo() {
		jbtNovo.setEnabled(false);
		jtfNomeTipoServico.setEnabled(true);
		jtfValor.setEnabled(true);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
	}
	
	public void salvarCadastro() {
		
	}
	
	public void salvarEdicaoCadastro() {
		
	}
	
	public void acionarBotaoEditar() {
		
	}
	
	public void acionarBotaoCancelar() {
		jbtNovo.setEnabled(true);
		jtfNomeTipoServico.setEnabled(false);
		jtfValor.setEnabled(false);
		jtfNomeTipoServico.setText("");
		jtfValor.setText("");
		jbtSalvar.setEnabled(false);
		jbtCancelar.setEnabled(false);
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
					
				}
			}
		});
		
		jbtEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent acvt) {
				if(acvt.getSource() == jbtEditar) {
					
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

	public TipoServicoForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TipoServicoForm.class.getResource("/Imagens/washCar.jpeg")));
		setTitle("Cadastrar Tipos de Serviço | WashCar");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 669, 284);
		jpnTipoServico = new JPanel();
		jpnTipoServico.setLayout(null);
		setLocationRelativeTo(null);
			
		componenteTelaTipoServico();
		acoesDosBotoes();
		
	}
}