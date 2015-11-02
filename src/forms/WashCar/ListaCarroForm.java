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

import dao.WashCar.CarroDAOJDBC;
import model.WashCar.Carro;
import preencherDados.WashCar.PreencherDados;

public class ListaCarroForm extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel jpnListaCarro;
	private Vector<String> dados;
	private JTable jttListaCarro;
	private DefaultTableModel dtmListaCarro;
	private JScrollPane jspListaCarro;
	private JButton jbtSelecionarCarro;
	private JButton jbtCancelarPesquisa;
	private List<Carro> listaCarros;
	private Carro carro;
	private PreencherDados preencheDados;
	private Integer codigo;
	private String descricao;
	private String placa; 

	public void componentesListaCarro() {
		dados = new Vector<String>();
		dados.add("C�digo");
		dados.add("Nome do Carro");
		dados.add("Placa do Carro");
		dtmListaCarro = new DefaultTableModel();
		dtmListaCarro.setColumnIdentifiers(dados);
		jttListaCarro = new JTable();
		jttListaCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jttListaCarro.setModel(dtmListaCarro);
		jttListaCarro.getColumnModel().getColumn(0).setResizable(false);
		jttListaCarro.getColumnModel().getColumn(0).setPreferredWidth(10);
		jttListaCarro.getColumnModel().getColumn(1).setResizable(false);
		jttListaCarro.getColumnModel().getColumn(1).setPreferredWidth(300);
		jttListaCarro.getColumnModel().getColumn(2).setResizable(false);
		jttListaCarro.getColumnModel().getColumn(2).setPreferredWidth(50);
		jspListaCarro = new JScrollPane(jttListaCarro);
		jspListaCarro.setBounds(10, 10, 500, 300);
		jpnListaCarro.add(jspListaCarro);
		
		jbtSelecionarCarro = new JButton("Selecionar");
		jbtSelecionarCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSelecionarCarro.setBounds(10, 338, 110, 23);
		jpnListaCarro.add(jbtSelecionarCarro);
		
		jbtCancelarPesquisa = new JButton("Cancelar");
		jbtCancelarPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelarPesquisa.setBounds(130, 339, 110, 23);
		jpnListaCarro.add(jbtCancelarPesquisa);
	}
	
	public void preencherDadosTabelaSemFiltro() {
		listaCarros = new CarroDAOJDBC().todos();
		for(Carro todos : listaCarros) {
			dtmListaCarro.addRow(new String[] {String.valueOf(todos.getIdCarro()), todos.getNome(), todos.getPlaca()});
		}
	}
	
	public void preencherDadosTabelaFiltroCodigo() {
		carro = new Carro();
		carro = new CarroDAOJDBC().buscarId(codigo);
		listaCarros.add(carro);
		for(Carro todos : listaCarros) {
			dtmListaCarro.addRow(new String[] {String.valueOf(todos.getIdCarro()), todos.getNome(), todos.getPlaca()});
		}
	}
	
	public void preencherDadosTabelaFiltroNome() {
		listaCarros.addAll(new CarroDAOJDBC().buscarDescricao(descricao));
		for(Carro todos : listaCarros) {
			dtmListaCarro.addRow(new String[] {String.valueOf(todos.getIdCarro()), todos.getNome(), todos.getPlaca()});
		}		
	}
	
	public void preencherDadosTabelaFiltroPlaca() {
		carro = new Carro();
		carro = new CarroDAOJDBC().pesquisaPorPlaca(placa);
		listaCarros.add(carro);
		for(Carro todos : listaCarros) {
			dtmListaCarro.addRow(new String[] {String.valueOf(todos.getIdCarro()), todos.getNome(), todos.getPlaca()});
		}
	}
	
	public void validacaoPesquisa() {
		if((codigo == null || codigo.equals("")) && (descricao == null || descricao.equals("")) && (placa == null || placa.equals("   -    "))) {
			this.preencherDadosTabelaSemFiltro();
		} else if(codigo != null && !codigo.equals("")) {
			this.preencherDadosTabelaFiltroCodigo();
		} else if(descricao != null && !descricao.equals("")) {
			this.preencherDadosTabelaFiltroNome();
		} else if(placa != null && !placa.equals("   -    ")) {
			this.preencherDadosTabelaFiltroPlaca();
		}
	}
	
	public void acionarBotaoSelecionar() {
		jbtSelecionarCarro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent acvt) {
				if(acvt.getSource() == jbtSelecionarCarro) {
					Integer carroSelecionado = jttListaCarro.getSelectedRow();
					if(carroSelecionado != -1) {
						carro = listaCarros.get(carroSelecionado);
						preencheDados.preencherCampos(carro);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Nenhum carro foi selecionado!!!\n"
						+ "Por gentileza, selecionar um carro!!!", "Erro", JOptionPane.ERROR_MESSAGE);
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
		listaCarros = new ArrayList<>();
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaCarroForm.class.getResource("/Imagens/washCar.jpeg")));
		setFont(new Font("Tahoma", Font.PLAIN, 12));
		setResizable(false);
		setTitle("Lista de Carros");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 400);
		setLocationRelativeTo(null);
		jpnListaCarro = new JPanel();
		jpnListaCarro.setLayout(null);
		setContentPane(jpnListaCarro);
		
		componentesListaCarro();
		acionarBotaoSelecionar();
		acionarBotaoCancelar();
		validacaoPesquisa();
	}

	public ListaCarroForm(PreencherDados dados, String descricao, Integer codigo, String placa) {
		this.preencheDados = dados;
		this.codigo = codigo;
		this.descricao = descricao;
		this.placa = placa;
		inicializarForm();
	}
}