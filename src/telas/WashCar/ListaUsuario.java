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

import model.WashCar.Usuario;
import dao.WashCar.UsuarioDAOJDBC;

public class ListaUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnListaUsuario;
	private Vector<String> dados;
	private JTable jttListaUsuario;
	private DefaultTableModel dtmListaUsuario;
	private JScrollPane jspListaUsuario;
	private JButton jbtSelecionarUsuario;
	private JButton jbtCancelarPesquisa;
	private List<Usuario> listaUsuarios;
	private UsuarioTela usuarioTela;

	public void componentesListaUsuario() {
		dados = new Vector<String>();
		dados.add("C�digo");
		dados.add("Nome do Usu�rio");
		dados.add("Login do Usu�rio");
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
		
		jbtSelecionarUsuario = new JButton("Selecionar");
		jbtSelecionarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSelecionarUsuario.setBounds(10, 338, 110, 23);
		jpnListaUsuario.add(jbtSelecionarUsuario);
		
		jbtCancelarPesquisa = new JButton("Cancelar");
		jbtCancelarPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelarPesquisa.setBounds(130, 339, 110, 23);
		jpnListaUsuario.add(jbtCancelarPesquisa);
	}

	public ListaUsuario(UsuarioTela usuarioTela) {
		this.usuarioTela = usuarioTela;
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaUsuario.class.getResource("/Imagens/washCar.jpeg")));
		setFont(new Font("Tahoma", Font.PLAIN, 12));
		setResizable(false);
		setTitle("Lista de Usu�rios");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 400);
		setLocationRelativeTo(null);
		jpnListaUsuario = new JPanel();
		jpnListaUsuario.setLayout(null);
		setContentPane(jpnListaUsuario);
		
		componentesListaUsuario();
		
		listaUsuarios = new UsuarioDAOJDBC().todos();
		for(Usuario todos : listaUsuarios) {
			dtmListaUsuario.addRow(new String[] {
					todos.getIdUsuario().toString(), todos.getNome(), todos.getLogin()
			});
		}
				
		jbtSelecionarUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtSelecionarUsuario) {
					Integer usuarioSelecionado = jttListaUsuario.getSelectedRow();
					Usuario usuario = listaUsuarios.get(usuarioSelecionado);
					usuarioTela.preencherCampos(usuario);
				}
			}
		});
	}
}