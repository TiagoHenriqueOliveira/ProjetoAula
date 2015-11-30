package forms.WashCar;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.text.MaskFormatter;

import daoFactory.WashCar.DaoFactory;
import exception.WashCar.RegistroExistente;
import exception.WashCar.RegistroNotExistente;
import model.WashCar.Entidade;
import model.WashCar.TipoServico;
import preencherDados.WashCar.PreencherDados;

import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.JCheckBox;

import validacaoCampos.WashCar.ValidaCampoAlfaNumerico;
import validacaoCampos.WashCar.ValidaCampoNumeroInteiro;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TipoServicoForm extends JFrame implements PreencherDados {

	private static final long serialVersionUID = 1L;
	private JPanel jpnTipoServico;
	private JPanel jpnPesquisaTipoServico;
	private JTextField jtfPesquisaCodigoTipoServico;
	private JTextField jtfPesquisaNomeTipoServico;
	private JTextField jtfCodigo;
	private JTextField jtfNomeTipoServico;
	private JTextField jtfDataAlteracao;
	private JFormattedTextField jftfValor;
	private JLabel jlbCodigo;
	private JLabel jlbNomeTipoServico;
	private JLabel jlbDataAlteracao;
	private JLabel jlbValor;
	private JLabel jlbConsultaTipoServico;
	private JLabel jlbPesquisaCodigoTipoServico;
	private JLabel jlbPesquisaNomeTipoServico;
	private JButton jbtNovo;
	private JButton jbtSalvar;
	private JButton jbtEditar;
	private JButton jbtCancelar;
	private JButton jbtFechar;
	private JCheckBox jckbForaUso;
	private JMenu mnRelatrios;
	private JMenuBar jmbTipoServico;
	private TipoServico tipoServico;
	private static TipoServicoForm tipoServicoForm;
	private ListaTipoServicoForm listaTipoServico = new ListaTipoServicoForm(null, null, null);

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
		jtfPesquisaNomeTipoServico.setDocument(new ValidaCampoAlfaNumerico());		
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
		jtfNomeTipoServico.setDocument(new ValidaCampoAlfaNumerico());
		jtfNomeTipoServico.setEditable(false);
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
		jtfDataAlteracao.setBounds(549, 120, 75, 20);
		jpnTipoServico.add(jtfDataAlteracao);
		
		jlbDataAlteracao = new JLabel("Data Altera\u00E7\u00E3o");
		jlbDataAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataAlteracao.setBounds(549, 107, 101, 14);
		jpnTipoServico.add(jlbDataAlteracao);
		
		jlbValor = new JLabel("Valor do Tipo de Servi\u00E7o");
		jlbValor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbValor.setBounds(434, 151, 216, 14);
		jpnTipoServico.add(jlbValor);
		
		jckbForaUso = new JCheckBox("Fora de Uso");
		jckbForaUso.setEnabled(false);
		jckbForaUso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jckbForaUso.setBounds(260, 119, 130, 23);
		jpnTipoServico.add(jckbForaUso);
		
		jftfValor = new JFormattedTextField();
		jftfValor.setHorizontalAlignment(SwingConstants.RIGHT);
		jftfValor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jftfValor.setEditable(false);
		jftfValor.setBounds(434, 166, 80, 20);
		jpnTipoServico.add(jftfValor);
	}
	
	public void acionarBotaoNovo() {
		jtfNomeTipoServico.requestFocus();
		jckbForaUso.setSelected(false);
		jtfNomeTipoServico.setEditable(true);
		jftfValor.setEditable(true);
		jtfCodigo.setText("");
		jtfNomeTipoServico.setText("");
		jftfValor.setText("");
		jtfDataAlteracao.setText("");
		jbtNovo.setEnabled(false);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
		jbtEditar.setEnabled(false);
	}
	
	@SuppressWarnings("static-access")
	public void salvarCadastro() throws RegistroExistente, ParseException {
		if(jtfNomeTipoServico.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o tipo de serviço!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeTipoServico.requestFocus();
		}else if(jftfValor.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o valor!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jftfValor.requestFocus();
		} else {
			this.tipoServico = new TipoServico();
			this.tipoServico.setNome(jtfNomeTipoServico.getText());
			Locale locBrazil = new Locale("pt", "BR");
			NumberFormat nf = NumberFormat.getInstance(locBrazil);
			String n = nf.format(Double.valueOf(jftfValor.getText().replace(",", ".")));
			this.tipoServico.setValor(Double.valueOf(n));
			this.tipoServico.setDataAltercacao(Date.valueOf(tipoServico.getDataAltercacao().now()).toLocalDate());
			this.tipoServico.setForaUso(jckbForaUso.isSelected());
			DaoFactory.getFactory().tipoServicoDao().inserir(tipoServico);
			jtfCodigo.setText(String.valueOf(this.tipoServico.getIdTipoServico()));
			jftfValor.setText(String.valueOf(new DecimalFormat("R$ #,##0.00").format(this.tipoServico.getValor())));
			jtfDataAlteracao.setText(this.tipoServico.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
			JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!!!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			jckbForaUso.setEnabled(false);
			jtfNomeTipoServico.setEditable(false);
			jftfValor.setEditable(false);
			jbtSalvar.setEnabled(false);
			jbtEditar.setEnabled(true);
			jbtNovo.setEnabled(true);
			jbtCancelar.setEnabled(false);
		}
	}
	
	@SuppressWarnings("static-access")
	public void salvarEdicaoCadastro() throws RegistroExistente, ParseException {
		if(jtfNomeTipoServico.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o tipo de serviço!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeTipoServico.requestFocus();
		} else if(jftfValor.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o valor!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jftfValor.requestFocus();
		} else {
			this.tipoServico = new TipoServico();
			this.tipoServico.setNome(jtfNomeTipoServico.getText());
			Locale locBrazil = new Locale("pt", "BR");
			NumberFormat nf = NumberFormat.getInstance(locBrazil);
			String n = nf.format(Double.valueOf(jftfValor.getText().replace(",", ".").substring(3)));
			this.tipoServico.setValor(Double.valueOf(n));
			this.tipoServico.setDataAltercacao(Date.valueOf(tipoServico.getDataAltercacao().now()).toLocalDate());
			this.tipoServico.setForaUso(jckbForaUso.isSelected());
			this.tipoServico.setIdTipoServico(Integer.valueOf(jtfCodigo.getText()));
			DaoFactory.getFactory().tipoServicoDao().alterar(tipoServico);
			jftfValor.setText(String.valueOf(new DecimalFormat("R$ #,##0.00").format(this.tipoServico.getValor())));
			jtfDataAlteracao.setText(this.tipoServico.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
			JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!!!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			jckbForaUso.setEnabled(false);
			jtfNomeTipoServico.setEditable(false);
			jftfValor.setEditable(false);
			jbtSalvar.setEnabled(false);
			jbtEditar.setEnabled(true);
			jbtNovo.setEnabled(true);
			jbtCancelar.setEnabled(false);
		}
	}
	
	public void acionarBotaoEditar() {
		jckbForaUso.setEnabled(true);
		jtfNomeTipoServico.setEditable(true);
		jftfValor.setEditable(true);
		jbtNovo.setEnabled(false);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
	}
	
	public void acionarBotaoCancelar() {
		jckbForaUso.setEnabled(false);
		jtfNomeTipoServico.setEditable(false);
		jftfValor.setEditable(false);
		jckbForaUso.setSelected(false);
		jtfNomeTipoServico.setText("");
		jftfValor.setText("");
		jbtNovo.setEnabled(true);
		jbtCancelar.setEnabled(false);
		jbtSalvar.setEnabled(false);
		jbtEditar.setEnabled(false);
	}
	
	public void preencheCamposTipoServico(TipoServico tipoServico) {
		jtfCodigo.setText(String.valueOf(tipoServico.getIdTipoServico()));
		jtfNomeTipoServico.setText(tipoServico.getNome());
		jftfValor.setText(String.valueOf(new DecimalFormat("R$ #,##0.00").format(tipoServico.getValor())));
		jtfDataAlteracao.setText(tipoServico.getDataAltercacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
		if(tipoServico.isForaUso()) {
			jckbForaUso.setSelected(true);
		} else {
			jckbForaUso.setSelected(false);
		}
		jtfPesquisaCodigoTipoServico.requestFocus();
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
					if(acvt.getSource() == jbtSalvar) {
						if(jbtSalvar.isEnabled() && jbtEditar.isEnabled()) {
							try {
								salvarEdicaoCadastro();
							} catch (RegistroExistente | ParseException salvarEdicao) {
								salvarEdicao.printStackTrace();
							}
						} else {
							try {
								salvarCadastro();
							} catch (RegistroExistente | ParseException salvarCadastro) {
								salvarCadastro.printStackTrace();
							}
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
					if(jtfCodigo.getText() == null || jtfCodigo.getText().equals("")) {
						Integer valor = JOptionPane.showConfirmDialog(null, "Você NÃO concluiu o cadastro.\n"
								+ "Deseja realmente fechar sem concluir o cadastro?\n"
								+ "SIM - Cadastro da Ordem de Serviço será cancelado!\n"
								+ "NÃO - Por gentileza, conclua o cadastro da Ordem de Serviço!", "Atenção", JOptionPane.YES_NO_OPTION);
						if(valor == 0) {
							dispose();
						}
					}
				} else {
					dispose();
				}
			}
		});
	}
	
	public void pesquisaPorCodigo() {
		jtfPesquisaCodigoTipoServico.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						if(listaTipoServico.isVisible()) {
							listaTipoServico.requestFocus();
							listaTipoServico.setLocationRelativeTo(tipoServicoForm);
						} else {
							Integer codigo = null;
							if(!jtfPesquisaCodigoTipoServico.getText().equals("")) {
								codigo = Integer.valueOf(jtfPesquisaCodigoTipoServico.getText());
							}
							listaTipoServico = new ListaTipoServicoForm(tipoServicoForm, null, codigo);
							listaTipoServico.setVisible(true);
							jckbForaUso.setEnabled(false);
							jtfNomeTipoServico.setEditable(false);
							jftfValor.setEditable(false);
							jckbForaUso.setSelected(false);
							jtfCodigo.setText("");
							jtfNomeTipoServico.setText("");
							jftfValor.setText("");
							jbtEditar.setEnabled(true);
							jbtSalvar.setEnabled(false);
							jbtCancelar.setEnabled(true);
						}
					} catch (RegistroNotExistente e) {
						JOptionPane.showMessageDialog(tipoServicoForm, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
						jtfPesquisaCodigoTipoServico.setText("");
						jtfPesquisaCodigoTipoServico.requestFocus();
					}
				}
			}
		});
	}
	
	public void pesquisaPorNome() {
		jtfPesquisaNomeTipoServico.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						if(listaTipoServico.isVisible()) {
							listaTipoServico.requestFocus();
							listaTipoServico.setLocationRelativeTo(tipoServicoForm);
						} else {
							listaTipoServico = new ListaTipoServicoForm(tipoServicoForm, jtfPesquisaNomeTipoServico.getText(), null);
							listaTipoServico.setVisible(true);
							jckbForaUso.setEnabled(false);
							jtfNomeTipoServico.setEditable(false);
							jftfValor.setEditable(false);
							jckbForaUso.setSelected(false);
							jtfCodigo.setText("");
							jtfNomeTipoServico.setText("");
							jftfValor.setText("");
							jbtEditar.setEnabled(true);
							jbtSalvar.setEnabled(false);
							jbtCancelar.setEnabled(true);
						}
					} catch (RegistroNotExistente e) {
						JOptionPane.showMessageDialog(tipoServicoForm, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
						jtfPesquisaNomeTipoServico.setText("");
						jtfPesquisaNomeTipoServico.requestFocus();
					}
				}
			}
		});
	}

	public TipoServicoForm() {
		tipoServicoForm = this;
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
		pesquisaPorCodigo();
		pesquisaPorNome();
	}

	@Override
	public void preencherCampos(Entidade entidade) {
		this.preencheCamposTipoServico((TipoServico)entidade);
	}
}