package forms.WashCar;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.WashCar.TipoServicoDAOJDBC;
import model.WashCar.TipoServico;
import preencherDados.WashCar.PreencherDados;

public class ListaTipoServicoForm extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel jpnListaTipoServico;
	private Vector<String> dados;
	private JTable jttListaTipoServico;
	private DefaultTableModel dtmListaTipoServico;
	private JScrollPane jspListaTipoServico;
	private JButton jbtSelecionarTipoServico;
	private JButton jbtCancelarPesquisa;
	private PreencherDados preencheDados;
	private List<TipoServico> listaTiposServicos;
	private TipoServico tipoServico;
	private Integer codigo;
	private String descricao; 

	@SuppressWarnings("static-access")
	public void componentesListaUsuario() {
		dados = new Vector<String>();
		dados.add("Código");
		dados.add("Nome do Serviço");
		dados.add("Valor");
		dtmListaTipoServico = new DefaultTableModel();
		dtmListaTipoServico.setColumnIdentifiers(dados);
		jttListaTipoServico = new JTable();
		jttListaTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jttListaTipoServico.setModel(dtmListaTipoServico);
		jttListaTipoServico.getColumnModel().getColumn(0).setResizable(false);
		jttListaTipoServico.getColumnModel().getColumn(0).setPreferredWidth(60);
		jttListaTipoServico.getColumnModel().getColumn(1).setResizable(false);
		jttListaTipoServico.getColumnModel().getColumn(1).setPreferredWidth(337);
		jttListaTipoServico.getColumnModel().getColumn(2).setResizable(false);
		jttListaTipoServico.getColumnModel().getColumn(2).setPreferredWidth(100);
		jspListaTipoServico = new JScrollPane(jttListaTipoServico);
		jttListaTipoServico.setAutoResizeMode(jttListaTipoServico.AUTO_RESIZE_OFF);
		jspListaTipoServico.setBounds(10, 10, 500, 300);
		jpnListaTipoServico.add(jspListaTipoServico);
		
		jbtSelecionarTipoServico = new JButton("Selecionar");
		jbtSelecionarTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSelecionarTipoServico.setBounds(10, 338, 110, 23);
		jpnListaTipoServico.add(jbtSelecionarTipoServico);
		
		jbtCancelarPesquisa = new JButton("Cancelar");
		jbtCancelarPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelarPesquisa.setBounds(130, 339, 110, 23);
		jpnListaTipoServico.add(jbtCancelarPesquisa);
	}
	
	public void preencherDadosTabelaSemFiltro() {
		listaTiposServicos = new TipoServicoDAOJDBC().todos();
		for(TipoServico todos : listaTiposServicos) {
			dtmListaTipoServico.addRow(new String[] {String.valueOf(todos.getIdTipoServico()), todos.getNome(), 
					String.valueOf(new DecimalFormat("R$ #,##0.00").format(todos.getValor()))});
		}
	}
	
	public void preencherDadosTabelaFiltroCodigo() {
		tipoServico = new TipoServico();
		tipoServico = new TipoServicoDAOJDBC().buscarId(codigo);
		listaTiposServicos.add(tipoServico);
		for(TipoServico todos : listaTiposServicos) {
			dtmListaTipoServico.addRow(new String[] {String.valueOf(todos.getIdTipoServico()), todos.getNome(), 
					String.valueOf(new DecimalFormat("R$ #,##0.00").format(todos.getValor()))});
		}
	}
	
	public void preencherDadosTabelaFiltroNome() {
		listaTiposServicos.addAll(new TipoServicoDAOJDBC().buscarDescricao(descricao));
		for(TipoServico todos : listaTiposServicos) {
			dtmListaTipoServico.addRow(new String[] {String.valueOf(todos.getIdTipoServico()), todos.getNome(), 
					String.valueOf(new DecimalFormat("R$ #,##0.00").format(todos.getValor()))});
		}		
	}
	
	public void validacaoPesquisa() {
		if((codigo == null || codigo.equals(""))
			&& (descricao== null || descricao.equals(""))) {
			this.preencherDadosTabelaSemFiltro();
		} else if(codigo != null && !codigo.equals("")) {
			this.preencherDadosTabelaFiltroCodigo();
		} else if(descricao != null && !descricao.equals("")) {
			this.preencherDadosTabelaFiltroNome();
		}
	}
	
	public void acionarBotaoSelecionar() {
		jbtSelecionarTipoServico.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent acvt) {
				if(acvt.getSource() == jbtSelecionarTipoServico) {
					Integer tipoServicoSelecionado = jttListaTipoServico.getSelectedRow();
					if(tipoServicoSelecionado != -1) {
						tipoServico = listaTiposServicos.get(tipoServicoSelecionado);
						preencheDados.preencherCampos(tipoServico);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Nenhum serviço foi selecionado!!!\n"
						+ "Por gentileza, selecionar um serviço!!!", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
	}
	
	public void acionarBotaoCancelar() {
		jbtCancelarPesquisa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	public void inicializarForm() {
		listaTiposServicos = new ArrayList<>();
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaTipoServicoForm.class.getResource("/Imagens/washCar.jpeg")));
		setFont(new Font("Tahoma", Font.PLAIN, 12));
		setResizable(false);
		setTitle("Lista de Serviços Prestados");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 400);
		setLocationRelativeTo(null);
		jpnListaTipoServico = new JPanel();
		jpnListaTipoServico.setLayout(null);
		setContentPane(jpnListaTipoServico);
		
		componentesListaUsuario();
		acionarBotaoSelecionar();
		acionarBotaoCancelar();
		validacaoPesquisa();
	}

	public ListaTipoServicoForm(PreencherDados dados, String descricao, Integer codigo) {
		this.preencheDados = dados;
		this.codigo = codigo;
		this.descricao = descricao;
		inicializarForm();
	}
}