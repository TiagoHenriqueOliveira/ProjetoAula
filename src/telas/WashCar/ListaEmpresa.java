package telas.WashCar;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.WashCar.Empresa;
import model.WashCar.Usuario;
import dao.WashCar.EmpresaDAOJDBC;
import dao.WashCar.UsuarioDAOJDBC;

public class ListaEmpresa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnListaEmpresa;
	private Vector<String> dados;
	private JTable jttListaEmpresa;
	private DefaultTableModel dtmListaEmpresa;
	private JScrollPane jspListaEmpresa;
	private JButton jbtSelecionarEmpresa;
	private JButton jbtCancelarPesquisa;
	private List<Empresa> listaEmpresas;
	private EmpresaTela empresaTela;

	public void componentesListaUsuario() {
		dados = new Vector<String>();
		dados.add("Código");
		dados.add("Nome do Usuário");
		dados.add("Login do Usuário");
		dtmListaEmpresa = new DefaultTableModel();
		dtmListaEmpresa.setColumnIdentifiers(dados);
		jttListaEmpresa = new JTable();
		jttListaEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jttListaEmpresa.setModel(dtmListaEmpresa);
		jttListaEmpresa.getColumnModel().getColumn(0).setResizable(false);
		jttListaEmpresa.getColumnModel().getColumn(0).setPreferredWidth(20);
		jttListaEmpresa.getColumnModel().getColumn(1).setResizable(false);
		jttListaEmpresa.getColumnModel().getColumn(1).setPreferredWidth(150);
		jttListaEmpresa.getColumnModel().getColumn(2).setResizable(false);
		jttListaEmpresa.getColumnModel().getColumn(2).setPreferredWidth(100);
		jspListaEmpresa = new JScrollPane(jttListaEmpresa);
		jspListaEmpresa.setBounds(10, 10, 500, 300);
		jpnListaEmpresa.add(jspListaEmpresa);
		
		jbtSelecionarEmpresa = new JButton("Selecionar");
		jbtSelecionarEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSelecionarEmpresa.setBounds(10, 338, 110, 23);
		jpnListaEmpresa.add(jbtSelecionarEmpresa);
		
		jbtCancelarPesquisa = new JButton("Cancelar");
		jbtCancelarPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelarPesquisa.setBounds(130, 339, 110, 23);
		jpnListaEmpresa.add(jbtCancelarPesquisa);
	}

	public ListaEmpresa(EmpresaTela empresaTela) {
		this.empresaTela = empresaTela;
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaEmpresa.class.getResource("/Imagens/washCar.jpeg")));
		setFont(new Font("Tahoma", Font.PLAIN, 12));
		setResizable(false);
		setTitle("Lista de Usuários");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 400);
		setLocationRelativeTo(null);
		jpnListaEmpresa = new JPanel();
		jpnListaEmpresa.setLayout(null);
		setContentPane(jpnListaEmpresa);
		
		componentesListaUsuario();
		
		listaEmpresas = new EmpresaDAOJDBC().todos();
		for(Empresa todas : listaEmpresas) {
			dtmListaEmpresa.addRow(new String[] {
					todas.getIdEmpresa().toString(), todas.getRazaoSocial(), todas.getNomeFantasia(),
					todas.getCnpj(), todas.getInscricaoEstadual(), todas.getInscricaoMunicipal()
			});
		}
				
		jbtSelecionarEmpresa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtSelecionarEmpresa) {
					Integer empresaSelecionada = jttListaEmpresa.getSelectedRow();
					Empresa empresa = listaEmpresas.get(empresaSelecionada);
					empresaTela.preencherCampos(empresa);
				}
			}
		});
	}
}