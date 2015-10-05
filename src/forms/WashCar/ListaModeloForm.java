package forms.WashCar;

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

import javax.swing.JButton;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaModeloForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private ModeloForm modeloForm;
	private JPanel jpnListaModelo;
	private Vector<String> dados;
	private JTable jttListaModelo;
	private DefaultTableModel dtmListaModelo;
	private JScrollPane jspListaModelo;
	private JButton jbtSelecionarModelo;
	private JButton jbtCancelarPesquisa;
	private List<Modelo> listaModelos;
	
	public void componenteListaMarca() {
		dados = new Vector<String>();
		dados.add("Código");
		dados.add("Nome da Marca");
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
	
	public void preencherDadosTabela() {
		listaModelos = new ModeloDAOJDBC().todos();
		for(Modelo todos : listaModelos) {
			dtmListaModelo.addRow(new String [] {
					todos.getIdModelo().toString(), todos.getNome()
			});
		}
	}
	
	public void acionarBotaoSelecionar() {
		jbtSelecionarModelo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtSelecionarModelo) {
					Integer marcaSelecionada = jttListaModelo.getSelectedRow();
					if(marcaSelecionada != -1) {
						Modelo modelo = listaModelos.get(marcaSelecionada);
						modeloForm.preencherCampos(modelo);
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

	public ListaModeloForm(ModeloForm modeloForm) {
		this.modeloForm = modeloForm;
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaModeloForm.class.getResource("/Imagens/washCar.jpeg")));
		setTitle("Lista de Marcas");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		jpnListaModelo = new JPanel();
		jpnListaModelo.setLayout(null);
		setContentPane(jpnListaModelo);
				
		componenteListaMarca();
		preencherDadosTabela();
		acionarBotaoSelecionar();
		acionarBotaoCancelar();
	}
}