package telas.WashCar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Toolkit;
import java.util.Vector;
import javax.swing.JButton;

public class ListaUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnListaUsuario;
	private Vector<String> dados;
	private JTable jttListaUsuario;
	private DefaultTableModel dtmListaUsuario;
	private JScrollPane jspListaUsuario;
	private UsuarioTela usuarioTela;

	public void componentesListaUsuario() {
		dados = new Vector<String>();
		dados.add("Código");
		dados.add("Nome do Usuário");
		dados.add("Login do Usuário");
		dtmListaUsuario = new DefaultTableModel();
		dtmListaUsuario.setColumnIdentifiers(dados);
		jttListaUsuario = new JTable();
		jttListaUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jttListaUsuario.setModel(dtmListaUsuario);
		jttListaUsuario.getColumnModel().getColumn(0).setResizable(false);
		jttListaUsuario.getColumnModel().getColumn(0).setPreferredWidth(20);
		jttListaUsuario.getColumnModel().getColumn(1).setResizable(false);
		jttListaUsuario.getColumnModel().getColumn(1).setPreferredWidth(150);
		jttListaUsuario.getColumnModel().getColumn(2).setResizable(false);
		jttListaUsuario.getColumnModel().getColumn(2).setPreferredWidth(100);
		jspListaUsuario = new JScrollPane(jttListaUsuario);
		jspListaUsuario.setBounds(10, 10, 500, 300);
		jpnListaUsuario.add(jspListaUsuario);
		
		JButton jbtSelecionarUsuario = new JButton("Selecionar");
		jbtSelecionarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSelecionarUsuario.setBounds(10, 338, 110, 23);
		jpnListaUsuario.add(jbtSelecionarUsuario);
		
		JButton jbtCancelarPesquisa = new JButton("Cancelar");
		jbtCancelarPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelarPesquisa.setBounds(130, 339, 110, 23);
		jpnListaUsuario.add(jbtCancelarPesquisa);
	}

	public ListaUsuario(UsuarioTela usuarioTela) {
		this.usuarioTela = usuarioTela;
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaUsuario.class.getResource("/Imagens/washCar.jpeg")));
		setFont(new Font("Tahoma", Font.PLAIN, 12));
		setResizable(false);
		setTitle("Lista de Usuários");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 400);
		setLocationRelativeTo(null);
		jpnListaUsuario = new JPanel();
		jpnListaUsuario.setLayout(null);
		setContentPane(jpnListaUsuario);
		
		componentesListaUsuario();
	}
}