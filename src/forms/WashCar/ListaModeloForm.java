package forms.WashCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.WashCar.ModeloDAOJDBC;
import model.WashCar.Modelo;
import preencherDados.WashCar.PreencherDados;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaModeloForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnListaModelo;
	private Vector<String> dados;
	private JTable jttListaModelo;
	private DefaultTableModel dtmListaModelo;
	private JScrollPane jspListaModelo;
	private JButton jbtSelecionarModelo;
	private JButton jbtCancelarPesquisa;
	private List<Modelo> listaModelos;
	private Modelo modelo;
	private PreencherDados preencheDados;
	private Integer codigo;
	private String descricao;
	
	public void componenteListaMarca() {
		dados = new Vector<String>();
		dados.add("Código");
		dados.add("Nome do Modelo");
		dtmListaModelo = new DefaultTableModel();
		dtmListaModelo.setColumnIdentifiers(dados);
		jttListaModelo = new JTable();
		jttListaModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jttListaModelo.setModel(dtmListaModelo);
		jttListaModelo.getColumnModel().getColumn(0).setResizable(false);
		jttListaModelo.getColumnModel().getColumn(0).setPreferredWidth(20);
		jttListaModelo.getColumnModel().getColumn(1).setResizable(false);
		jttListaModelo.getColumnModel().getColumn(1).setPreferredWidth(200);
		jspListaModelo = new JScrollPane(jttListaModelo);
		jspListaModelo.setBounds(10, 10, 414, 207);
		jpnListaModelo.add(jspListaModelo);
				
		jbtSelecionarModelo = new JButton("Selecionar");
		jbtSelecionarModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSelecionarModelo.setBounds(10, 228, 110, 23);
		jpnListaModelo.add(jbtSelecionarModelo);
		
		jbtCancelarPesquisa = new JButton("Cancelar");
		jbtCancelarPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelarPesquisa.setBounds(140, 228, 110, 23);
		jpnListaModelo.add(jbtCancelarPesquisa);
	}
	
	public void preencherDadosTabelaSemFiltro() {
		listaModelos = new ModeloDAOJDBC().todos();
		for(Modelo todos : listaModelos) {
			dtmListaModelo.addRow(new String [] {todos.getIdModelo().toString(), todos.getNome()});
		}
	}
	
	public void preencherDadosTabelaFiltroCodigo() {
		modelo = new Modelo();
		modelo = new ModeloDAOJDBC().buscarId(Integer.valueOf(codigo));
		listaModelos.add(modelo);
		for(Modelo todos : listaModelos) {
			dtmListaModelo.addRow(new String [] {todos.getIdModelo().toString(), todos.getNome()});
		}
	}
	
	public void preencherDadosTabelaFiltroNome() {
		listaModelos.addAll(new ModeloDAOJDBC().buscarDescricao(descricao));
		for(Modelo todos : listaModelos) {
			dtmListaModelo.addRow(new String [] {todos.getIdModelo().toString(), todos.getNome()});
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
		jbtSelecionarModelo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtSelecionarModelo) {
					Integer modeloSelecionado = jttListaModelo.getSelectedRow();
					if(modeloSelecionado != -1) {
						modelo = listaModelos.get(modeloSelecionado);
						preencheDados.preencherCampos(modelo);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Nenhum modelo foi selecionada!!!\n"
						+ "Por gentileza, selecionar um modelo!!!", "Erro", JOptionPane.ERROR_MESSAGE);
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
		listaModelos = new ArrayList<>();
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaModeloForm.class.getResource("/Imagens/washCar.jpeg")));
		setTitle("Lista de Marcas");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		jpnListaModelo = new JPanel();
		jpnListaModelo.setLayout(null);
		setContentPane(jpnListaModelo);
				
		componenteListaMarca();
		validacaoPesquisa();
		acionarBotaoSelecionar();
		acionarBotaoCancelar();
	}

	public ListaModeloForm(PreencherDados dados, String descricao, Integer codigo) {
		this.preencheDados = dados;
		this.descricao = descricao;
		this.codigo = codigo;
		inicializarForm();
	}
}