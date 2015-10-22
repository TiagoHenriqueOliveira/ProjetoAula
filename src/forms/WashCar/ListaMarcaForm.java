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
import javax.swing.JButton;

import dao.WashCar.MarcaDAOJDBC;
import model.WashCar.Marca;
import model.WashCar.Modelo;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaMarcaForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnListaMarca;
	private Vector<String> dados;
	private JTable jttListaMarca;
	private DefaultTableModel dtmListaMarca;
	private JScrollPane jspListaMarca;
	private JButton jbtSelecionarMarca;
	private JButton jbtCancelarPesquisa;
	private MarcaForm marcaForm;
	private List<Marca> listaMarcas;
	private Marca marca;
	
	public void componenteListaMarca() {
		dados = new Vector<String>();
		dados.add("Código");
		dados.add("Nome da Marca");
		dtmListaMarca = new DefaultTableModel();
		dtmListaMarca.setColumnIdentifiers(dados);
		jttListaMarca = new JTable();
		jttListaMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jttListaMarca.setModel(dtmListaMarca);
		jttListaMarca.getColumnModel().getColumn(0).setResizable(false);
		jttListaMarca.getColumnModel().getColumn(0).setPreferredWidth(20);
		jttListaMarca.getColumnModel().getColumn(1).setResizable(false);
		jttListaMarca.getColumnModel().getColumn(1).setPreferredWidth(200);
		jspListaMarca = new JScrollPane(jttListaMarca);
		jspListaMarca.setBounds(10, 10, 414, 207);
		jpnListaMarca.add(jspListaMarca);
				
		jbtSelecionarMarca = new JButton("Selecionar");
		jbtSelecionarMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSelecionarMarca.setBounds(10, 228, 110, 23);
		jpnListaMarca.add(jbtSelecionarMarca);
		
		jbtCancelarPesquisa = new JButton("Cancelar");
		jbtCancelarPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelarPesquisa.setBounds(140, 228, 110, 23);
		jpnListaMarca.add(jbtCancelarPesquisa);
	}
	
	public void preencherDadosTabelaSemFiltro() {
		listaMarcas = new MarcaDAOJDBC().todos();
		for(Marca todas : listaMarcas) {
			dtmListaMarca.addRow(new String [] {	todas.getIdMarca().toString(), todas.getNome()});
		}
	}
	
	public void preencherDadosTabelaFiltroCodigo() {
		marca = new Marca();
		marca = new MarcaDAOJDBC().buscarId(Integer.valueOf(marcaForm.getCodigoMarca()));
		listaMarcas.add(marca);
		for(Marca todas : listaMarcas) {
			dtmListaMarca.addRow(new String [] {	todas.getIdMarca().toString(), todas.getNome()});
		}
	}
	
	public void preencherDadosTabelaFiltroNome() {
		listaMarcas.addAll(new MarcaDAOJDBC().buscarDescricao(marcaForm.getNomeMarca()));
		for(Marca todas : listaMarcas) {
			dtmListaMarca.addRow(new String [] {	todas.getIdMarca().toString(), todas.getNome()});
		}
	}
	
	public void validacaoPesquisa() {
		if((marcaForm.getCodigoMarca() == null || marcaForm.getCodigoMarca().equals(""))
			&& (marcaForm.getNomeMarca() == null || marcaForm.getNomeMarca().equals(""))) {
			this.preencherDadosTabelaSemFiltro();
		} else if(marcaForm.getCodigoMarca() != null && !marcaForm.getCodigoMarca().equals("")) {
			this.preencherDadosTabelaFiltroCodigo();
		} else if(marcaForm.getNomeMarca() != null && !marcaForm.getNomeMarca().equals("")) {
			this.preencherDadosTabelaFiltroNome();
		}
	}
	
	public void acionarBotaoSelecionar() {
		jbtSelecionarMarca.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtSelecionarMarca) {
					Integer marcaSelecionada = jttListaMarca.getSelectedRow();
					if(marcaSelecionada != -1) {
						Marca marca = listaMarcas.get(marcaSelecionada);
						marcaForm.preencherCampos(marca);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Nenhuma marca foi selecionada!!!\n"
						+ "Por gentileza, selecionar uma marca!!!", "Erro", JOptionPane.ERROR_MESSAGE);
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

	public ListaMarcaForm(MarcaForm marcaForm) {
		this.marcaForm = marcaForm;
		listaMarcas = new ArrayList<>();
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaMarcaForm.class.getResource("/Imagens/washCar.jpeg")));
		setTitle("Lista de Marcas");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		jpnListaMarca = new JPanel();
		jpnListaMarca.setLayout(null);
		setContentPane(jpnListaMarca);
				
		componenteListaMarca();
		validacaoPesquisa();
		acionarBotaoSelecionar();
		acionarBotaoCancelar();
	}
}