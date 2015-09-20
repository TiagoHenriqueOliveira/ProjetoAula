package forms.WashCar;

import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import model.WashCar.Marca;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaMarcaForm extends JFrame {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private MarcaForm marcaForm;
	private JPanel jpnListaMarca;
	private Vector<String> dados;
	private JTable jttListaMarca;
	private DefaultTableModel dtmListaMarca;
	private JScrollPane jspListaMarca;
	private JButton jbtSelecionarMarca;
	private JButton jbtCancelarPesquisa;
	private List<Marca> listaMarcas;
	
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
		jbtSelecionarMarca.setBounds(10, 228, 120, 23);
		jpnListaMarca.add(jbtSelecionarMarca);
		
		jbtCancelarPesquisa = new JButton("Cancelar");
		jbtCancelarPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelarPesquisa.setBounds(140, 228, 120, 23);
		jpnListaMarca.add(jbtCancelarPesquisa);
	}
	
	public void preencherDadosTabela() {
		listaMarcas = new MarcaDAOJDBC().todos();
		for(Marca todas : listaMarcas) {
			dtmListaMarca.addRow(new String [] {
					todas.getIdMarca().toString(), todas.getNome()
			});
		}
	}
	
	public void acionarBotaoSelecionar() {
		jbtSelecionarMarca.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtSelecionarMarca) {
					Integer marcaSelecionada = jttListaMarca.getSelectedRow();
					if(marcaSelecionada != -1) {
						
					} else {
						JOptionPane.showMessageDialog(null,
								"Nenhuma marca foi selecionada!!!\n"
								+ "Por gentileza, selecionar uma marca!!!",
								"Erro", JOptionPane.ERROR_MESSAGE);
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
					
				}
			}
		});
	}

	public ListaMarcaForm(MarcaForm marcaForm) {
		this.marcaForm = marcaForm;
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaMarcaForm.class.getResource("/Imagens/washCar.jpeg")));
		setTitle("Lista de Marcas");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 450, 300);
		jpnListaMarca = new JPanel();
		jpnListaMarca.setLayout(null);
		setContentPane(jpnListaMarca);
				
		componenteListaMarca();
		acionarBotaoSelecionar();
		acionarBotaoCancelar();
	}
}