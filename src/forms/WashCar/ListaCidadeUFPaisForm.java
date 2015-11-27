package forms.WashCar;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import preencherDados.WashCar.PreencherDados;
import dao.WashCar.CidadeDAOJDBC;
import model.WashCar.Cidade;
import javax.swing.ScrollPaneConstants;

public class ListaCidadeUFPaisForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnListaCidadeUFPais;
	private Vector<String> dados;
	private JTable jttListaCidadeUFPais;
	private DefaultTableModel dtmListaCidadeUFPais;
	private JScrollPane jspListaCidadeUFPais;
	private JButton jbtSelecionarCidadeUFPais;
	private JButton jbtCancelarPesquisa;
	private List<Cidade> listaCidadeUFPais;
	private Cidade cidade;
	private PreencherDados preencheDados;
	private String descricao;

	@SuppressWarnings("static-access")
	public void componentesListaCidadeUFPais() {
		dados = new Vector<String>();
		dados.add("Cód. Cidade");
		dados.add("Nome Cidade");
		dados.add("Nome Estado");
		dados.add("Nome País");
		dtmListaCidadeUFPais = new DefaultTableModel();
		dtmListaCidadeUFPais.setColumnIdentifiers(dados);
		jttListaCidadeUFPais = new JTable();
		jttListaCidadeUFPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jttListaCidadeUFPais.setModel(dtmListaCidadeUFPais);
		jttListaCidadeUFPais.getColumnModel().getColumn(0).setResizable(false);
		jttListaCidadeUFPais.getColumnModel().getColumn(0).setPreferredWidth(100);
		jttListaCidadeUFPais.getColumnModel().getColumn(1).setResizable(false);
		jttListaCidadeUFPais.getColumnModel().getColumn(1).setPreferredWidth(200);
		jttListaCidadeUFPais.getColumnModel().getColumn(2).setResizable(false);
		jttListaCidadeUFPais.getColumnModel().getColumn(2).setPreferredWidth(150);
		jttListaCidadeUFPais.getColumnModel().getColumn(3).setResizable(false);
		jttListaCidadeUFPais.getColumnModel().getColumn(3).setPreferredWidth(100);
		jspListaCidadeUFPais = new JScrollPane(jttListaCidadeUFPais);
		jspListaCidadeUFPais.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jttListaCidadeUFPais.setAutoResizeMode(jttListaCidadeUFPais.AUTO_RESIZE_OFF);
		jspListaCidadeUFPais.setBounds(10, 10, 444, 300);
		jpnListaCidadeUFPais.add(jspListaCidadeUFPais);
		
		jbtSelecionarCidadeUFPais = new JButton("Selecionar");
		jbtSelecionarCidadeUFPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSelecionarCidadeUFPais.setBounds(10, 338, 110, 23);
		jpnListaCidadeUFPais.add(jbtSelecionarCidadeUFPais);
		
		jbtCancelarPesquisa = new JButton("Cancelar");
		jbtCancelarPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelarPesquisa.setBounds(130, 339, 110, 23);
		jpnListaCidadeUFPais.add(jbtCancelarPesquisa);
	}
	
	public void preencherDadosTabelaSemFiltro() {
		listaCidadeUFPais = new CidadeDAOJDBC().todos();
		for(Cidade todas : listaCidadeUFPais) {
			dtmListaCidadeUFPais.addRow(new String[] {String.valueOf(todas.getIdCidade()), todas.getNome(),
					todas.getUnidadeFederativa().getNome(), todas.getUnidadeFederativa().getPais().getNome()});
		}
	}
	
	public void preencherDadosTabelaFiltroNome() {
		listaCidadeUFPais.addAll(new CidadeDAOJDBC().buscarNomeCidade(descricao));
		for(Cidade todas : listaCidadeUFPais) {
			dtmListaCidadeUFPais.addRow(new String[] {String.valueOf(todas.getIdCidade()), todas.getNome(),
					todas.getUnidadeFederativa().getNome(), todas.getUnidadeFederativa().getPais().getNome()});
		}
	}
	
	public void validacaoPesquisa() {
		if((descricao == null || descricao.equals(""))) {
				this.preencherDadosTabelaSemFiltro();
			} else if(descricao != null && !descricao.equals("")) {
				this.preencherDadosTabelaFiltroNome();
			}
	}
	
	public void acionarBotaoSelecionar() {
		jbtSelecionarCidadeUFPais.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtSelecionarCidadeUFPais) {
					Integer empresaSelecionada = jttListaCidadeUFPais.getSelectedRow();
					if(empresaSelecionada != -1) {
						cidade = listaCidadeUFPais.get(empresaSelecionada);
						preencheDados.preencherCampos(cidade);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Nenhuma cidade foi selecionada!!!\n"
								+ "Por gentileza, selecionar uma cidade!!!", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
	}
	
	public void acionarBotaoCancelar() {
		jbtCancelarPesquisa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtCancelarPesquisa) {
					dispose();
				}
			}
		});
	}
	
	public void inicializarForm() {
		listaCidadeUFPais = new ArrayList<>();
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaCidadeUFPaisForm.class.getResource("/Imagens/washCar.jpeg")));
		setFont(new Font("Tahoma", Font.PLAIN, 12));
		setResizable(false);
		setTitle("Lista de Cidades/Estados/País");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 400);
		setLocationRelativeTo(null);
		jpnListaCidadeUFPais = new JPanel();
		jpnListaCidadeUFPais.setLayout(null);
		setContentPane(jpnListaCidadeUFPais);
		
		componentesListaCidadeUFPais();
		validacaoPesquisa();
		acionarBotaoSelecionar();
		acionarBotaoCancelar();	
	}

	public ListaCidadeUFPaisForm(PreencherDados dados, String descricao) {
		this.preencheDados = dados;
		this.descricao = descricao;
		inicializarForm();
	}
}