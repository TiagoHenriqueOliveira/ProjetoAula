package forms.WashCar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.WashCar.ItemOrdemServicoDAOJDBC;
import daoFactory.WashCar.DaoFactory;
import exception.WashCar.RegistroExistente;
import exception.WashCar.RegistroNotExistente;
import model.WashCar.Entidade;
import model.WashCar.ItemOrdemServico;
import model.WashCar.OrdemServico;
import model.WashCar.TipoServico;
import preencherDados.WashCar.PreencherDados;
import validacaoCampos.WashCar.ValidaCampoAlfaNumerico;
import validacaoCampos.WashCar.ValidaCampoNumeroInteiro;

import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.awt.Color;

public class ItemOrdemServicoForm extends JFrame implements PreencherDados {

	private static final long serialVersionUID = 1L;
	private JPanel jpnItemOrdemServico;
	private JTable jttItemOrdemServico;
	private DefaultTableModel dtmItemOrdemServico;
	private Vector<String> dados;
	private JScrollPane jspItemOrdemServico;
	private JTextField jtfDescricaoServico;
	private JTextField jtfCodigoTipoServico;
	private JFormattedTextField jftfValor;
	public JFormattedTextField jftfSubTotal;
	private JLabel jlbSubTotal;
	private JLabel jlbDescricaoServico;
	private JLabel jlbCodigoTipoServico;
	private JLabel jlbValor;
	private JButton jbtExcluir;
	private JButton jbtSalvar;
	private JButton jbtCancelar;
	private JButton jbtFechar;
	private JButton jbtNovo;
	private Integer codigoOSV;
	@SuppressWarnings("unused")
	private PreencherDados preencherDados;
	@SuppressWarnings("unused")
	private OrdemServicoForm ordemServicoForm;
	private ItemOrdemServico itemOrdemServico;
	private static ItemOrdemServicoForm itemOrdemServicoForm;
	private List<ItemOrdemServico> listaItensDaOrdemServico;

	@SuppressWarnings("static-access")
	public void componentesItemOrdemServicoForm() {
		dados = new Vector<String>();
		dados.add("Cód. Serv.");
		dados.add("Descrição");
		dados.add("Valor do Serviço");
		dtmItemOrdemServico = new DefaultTableModel();
		dtmItemOrdemServico.setColumnIdentifiers(dados);
		
		jttItemOrdemServico = new JTable();
		jttItemOrdemServico.setModel(dtmItemOrdemServico);
		jttItemOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jttItemOrdemServico.getColumnModel().getColumn(0).setResizable(false);
		jttItemOrdemServico.getColumnModel().getColumn(0).setPreferredWidth(70);
		jttItemOrdemServico.getColumnModel().getColumn(1).setResizable(false);
		jttItemOrdemServico.getColumnModel().getColumn(1).setPreferredWidth(467);
		jttItemOrdemServico.getColumnModel().getColumn(2).setResizable(false);
		jttItemOrdemServico.getColumnModel().getColumn(2).setPreferredWidth(100);
		jspItemOrdemServico = new JScrollPane(jttItemOrdemServico);
		jttItemOrdemServico.setAutoResizeMode(jttItemOrdemServico.AUTO_RESIZE_OFF);
		jpnItemOrdemServico.add(jspItemOrdemServico);
		jspItemOrdemServico.setBounds(10, 10, 640, 235);
		
		jlbDescricaoServico = new JLabel("Descri\u00E7\u00E3o do Servi\u00E7o");
		jlbDescricaoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDescricaoServico.setBounds(120, 256, 324, 14);
		jpnItemOrdemServico.add(jlbDescricaoServico);
		
		jtfDescricaoServico = new JTextField();
		jtfDescricaoServico.setDocument(new ValidaCampoAlfaNumerico());
		jtfDescricaoServico.setEditable(false);
		jtfDescricaoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfDescricaoServico.setColumns(10);
		jtfDescricaoServico.setBounds(120, 271, 324, 20);
		jpnItemOrdemServico.add(jtfDescricaoServico);
		
		jtfCodigoTipoServico = new JTextField();
		jtfCodigoTipoServico.setDocument(new ValidaCampoNumeroInteiro());
		jtfCodigoTipoServico.setEditable(false);
		jtfCodigoTipoServico.setHorizontalAlignment(SwingConstants.CENTER);
		jtfCodigoTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCodigoTipoServico.setColumns(10);
		jtfCodigoTipoServico.setBounds(10, 271, 50, 20);
		jpnItemOrdemServico.add(jtfCodigoTipoServico);
		
		jlbCodigoTipoServico = new JLabel("C\u00F3d. Servi\u00E7o");
		jlbCodigoTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbCodigoTipoServico.setBounds(10, 256, 110, 14);
		jpnItemOrdemServico.add(jlbCodigoTipoServico);
		
		jftfValor = new JFormattedTextField();
		jftfValor.setEditable(false);
		jftfValor.setHorizontalAlignment(SwingConstants.RIGHT);
		jftfValor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jftfValor.setColumns(10);
		jftfValor.setBounds(455, 271, 80, 20);
		jpnItemOrdemServico.add(jftfValor);
		
		jlbValor = new JLabel("Valor");
		jlbValor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbValor.setBounds(454, 257, 80, 14);
		jpnItemOrdemServico.add(jlbValor);
		
		jbtNovo = new JButton("Novo");
		jbtNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtNovo.setBounds(10, 302, 120, 25);
		jpnItemOrdemServico.add(jbtNovo);
		
		jbtExcluir = new JButton("Excluir");
		jbtExcluir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtExcluir.setBounds(270, 302, 120, 25);
		jpnItemOrdemServico.add(jbtExcluir);
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSalvar.setEnabled(false);
		jbtSalvar.setBounds(140, 302, 120, 25);
		jpnItemOrdemServico.add(jbtSalvar);
		
		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setEnabled(false);
		jbtCancelar.setBounds(400, 302, 120, 25);
		jpnItemOrdemServico.add(jbtCancelar);
		
		jbtFechar = new JButton("Fechar");
		jbtFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtFechar.setBounds(530, 302, 120, 25);
		jpnItemOrdemServico.add(jbtFechar);
		
		jftfSubTotal = new JFormattedTextField();
		jftfSubTotal.setBackground(Color.YELLOW);
		jftfSubTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		jftfSubTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jftfSubTotal.setEditable(false);
		jftfSubTotal.setColumns(10);
		jftfSubTotal.setBounds(570, 271, 80, 20);
		jpnItemOrdemServico.add(jftfSubTotal);
		
		jlbSubTotal = new JLabel("Sub. Total");
		jlbSubTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbSubTotal.setBounds(570, 257, 100, 14);
		jpnItemOrdemServico.add(jlbSubTotal);
	}
	
	public void acionarBotaoNovo() {
		jtfDescricaoServico.requestFocus();
		jtfDescricaoServico.setEditable(true);
		jtfCodigoTipoServico.setText("");
		jtfDescricaoServico.setText("");
		jftfValor.setText("");
		jbtNovo.setEnabled(false);
		jbtSalvar.setEnabled(true);
		jbtCancelar.setEnabled(true);
		jbtExcluir.setEnabled(false);
	}
	
	public void acionarBotaoSalvar() throws RegistroExistente {
		if(jtfCodigoTipoServico.getText() == null || jtfCodigoTipoServico.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar serviço válido!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfDescricaoServico.requestFocus();
			jtfDescricaoServico.setText("");
		} else {
			this.itemOrdemServico = new ItemOrdemServico();
			this.itemOrdemServico.setOrdemServico(new OrdemServico(codigoOSV));
			this.itemOrdemServico.setTipoServico(new TipoServico(Integer.valueOf(jtfCodigoTipoServico.getText()), null));
			this.itemOrdemServico.setValorUnitario(Double.parseDouble(jftfValor.getText().replace(",", ".").substring(3)));
			dtmItemOrdemServico.addRow(new String[]{String.valueOf(jtfCodigoTipoServico.getText()), 
			jtfDescricaoServico.getText(), String.valueOf(jftfValor.getText())});
			DaoFactory.getFactory().itemOrdemServicoDao().inserir(itemOrdemServico);
			jftfSubTotal.setText(String.valueOf(new DecimalFormat("R$ #,##0.00").format(calculaAdicaoSubTotal())));
			jtfDescricaoServico.setEditable(false);
			jbtNovo.setEnabled(true);
			jbtSalvar.setEnabled(false);
			jbtExcluir.setEnabled(true);
			jbtCancelar.setEnabled(false);
		}
	}
	
	public void acionarBotaoExcluir() throws RegistroExistente {
		this.itemOrdemServico = new ItemOrdemServico();
		Integer linha = jttItemOrdemServico.getSelectedRow();
		if(linha != -1) {
			Integer indice = JOptionPane.showConfirmDialog(itemOrdemServicoForm, "Deseja relamente EXCLUIR o serviço selecionado?", "Confirmação", JOptionPane.YES_NO_OPTION);
			if(indice == 0) {
				Integer codigo = Integer.valueOf((String) jttItemOrdemServico.getValueAt(linha, 0));
				this.itemOrdemServico.setTipoServico(new TipoServico(codigo, null));
				this.itemOrdemServico.setOrdemServico(new OrdemServico(codigoOSV));
				DaoFactory.getFactory().itemOrdemServicoDao().excluir(itemOrdemServico);
				jftfSubTotal.setText(String.valueOf(new DecimalFormat("R$ #,##0.00").format(calculaSubtracaoSubTotal())));
				dtmItemOrdemServico.removeRow(linha);
			} else {
				jtfCodigoTipoServico.setText("");
				jtfDescricaoServico.setText("");
				jftfValor.setText("");
			}
		} else {
			JOptionPane.showMessageDialog(itemOrdemServicoForm, "Nenhum serviço foi selecionado!!!\n"
			+ "Por gentileza, selecionar um serviço!!!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void acionarBotaoCancelar() {
		jtfDescricaoServico.setEditable(false);
		jtfCodigoTipoServico.setText("");
		jtfDescricaoServico.setText("");
		jftfValor.setText("");
		jbtNovo.setEnabled(true);
		jbtSalvar.setEnabled(false);
		jbtCancelar.setEnabled(false);
		jbtExcluir.setEnabled(true);
	}
	
	public void preencheCamposTipoServico(TipoServico tipoServico) {
		jtfCodigoTipoServico.setText(String.valueOf(tipoServico.getIdTipoServico()));
		jtfDescricaoServico.setText(tipoServico.getNome());
		jftfValor.setText(String.valueOf(new DecimalFormat("R$ #,##0.00").format(tipoServico.getValor())));
		jtfDescricaoServico.requestFocus();
	}
	
	public void preencheTabelaComServicosJaCadastrado() {
		listaItensDaOrdemServico = new ItemOrdemServicoDAOJDBC().mostrarItens(codigoOSV);
		for(ItemOrdemServico todos : listaItensDaOrdemServico) {
			dtmItemOrdemServico.addRow(new String[]{String.valueOf(todos.getTipoServico().getIdTipoServico()), 
					todos.getTipoServico().getNome(), String.valueOf(new DecimalFormat("R$ #,##0.00").format(todos.getValorUnitario()))});
		}
		jftfSubTotal.setText(String.valueOf(new DecimalFormat("R$ #,##0.00").format(calcularValorTotalOSV())));
	}
	
	public void preencheCamposTexto() {
		Integer linha = jttItemOrdemServico.getSelectedRow();
		if(linha != -1) {
			jtfCodigoTipoServico.setText((String) jttItemOrdemServico.getValueAt(linha, 0));
			jtfDescricaoServico.setText((String) jttItemOrdemServico.getValueAt(linha, 1));
			jftfValor.setText((String) jttItemOrdemServico.getValueAt(linha, 2));
		}
	}
	
	public void pesquisarTipoServico() {
		jtfDescricaoServico.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyevt) {
				if(keyevt.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						ListaTipoServicoForm listaTipoServico = new ListaTipoServicoForm(itemOrdemServicoForm, jtfDescricaoServico.getText(), null);
						listaTipoServico.setVisible(true);
					} catch (RegistroNotExistente e) {
						JOptionPane.showMessageDialog(itemOrdemServicoForm, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
						jtfDescricaoServico.requestFocus();
					}
				}
			}
		});
	}
	
	public Double calcularValorTotalOSV() {
		Double valorTotal = 0.0;
		for(ItemOrdemServico valor : listaItensDaOrdemServico) {
			Double totalOSV = valor.getValorUnitario();
			valorTotal += totalOSV;
		}
		return valorTotal;
	}
	
	public Double calculaAdicaoSubTotal() {
		Double subTotal = Double.valueOf(jftfSubTotal.getText().replace(",", ".").substring(3));
		Double valor = Double.valueOf(jftfValor.getText().replace(",", ".").substring(3));
		subTotal += valor;
		return subTotal;
	}
	
	public Double calculaSubtracaoSubTotal() {
		Double subTotal = Double.valueOf(jftfSubTotal.getText().replace(",", ".").substring(3));
		Double valor = Double.valueOf(jftfValor.getText().replace(",", ".").substring(3));
		subTotal -= valor;
		jtfCodigoTipoServico.setText("");
		jtfDescricaoServico.setText("");
		jftfValor.setText("");
		return subTotal;
	}
	
	public void acoesDosBotoes() {
		jbtNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtNovo) {
					acionarBotaoNovo();
				}
			}
		});
		
		jbtSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtSalvar) {
					try {
						acionarBotaoSalvar();
					} catch (RegistroExistente salvar) {
						salvar.printStackTrace();
					}
				}
			}
		});
		
		jbtExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtExcluir) {
					try {
						preencheCamposTexto();
						acionarBotaoExcluir();
					} catch (RegistroExistente excluir) {
						excluir.printStackTrace();
					}
				}
			}
		});
		
		jbtCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtCancelar) {
					acionarBotaoCancelar();
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
	
	public void inicializarForm() {
		itemOrdemServicoForm = this;
		listaItensDaOrdemServico = new ArrayList<>();
		setTitle("Lançamento de Itens da Ordem de Serviço");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ItemOrdemServicoForm.class.getResource("/Imagens/washCar.jpeg")));
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 668, 368);
		setLocationRelativeTo(null);
		jpnItemOrdemServico = new JPanel();
		jpnItemOrdemServico.setLayout(null);
		setContentPane(jpnItemOrdemServico);
		
		componentesItemOrdemServicoForm();
		acoesDosBotoes();
		pesquisarTipoServico();
		preencheTabelaComServicosJaCadastrado();
	}

	public ItemOrdemServicoForm(PreencherDados dados, Integer codigoOSV) {
		this.preencherDados = dados;
		this.codigoOSV = codigoOSV;
		inicializarForm();
	}

	@Override
	public void preencherCampos(Entidade entidade) {
		this.preencheCamposTipoServico((TipoServico)entidade);
	}
}