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

import model.WashCar.Usuario;
import dao.WashCar.UsuarioDAOJDBC;
import forms.WashCar.UsuarioForm;

public class ListaUsuarioForm extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private UsuarioForm usuarioForm;
	private List<Usuario> listaUsuarios;
	private Usuario usuario;
	private JPanel jpnListaUsuario;
	private Vector<String> dados;
	private JTable jttListaUsuario;
	private DefaultTableModel dtmListaUsuario;
	private JScrollPane jspListaUsuario;
	private JButton jbtSelecionarUsuario;
	private JButton jbtCancelarPesquisa;

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
		
		jbtSelecionarUsuario = new JButton("Selecionar");
		jbtSelecionarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSelecionarUsuario.setBounds(10, 338, 110, 23);
		jpnListaUsuario.add(jbtSelecionarUsuario);
		
		jbtCancelarPesquisa = new JButton("Cancelar");
		jbtCancelarPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelarPesquisa.setBounds(130, 339, 110, 23);
		jpnListaUsuario.add(jbtCancelarPesquisa);
	}
	
	public void preencherDadosTabelaSemFiltro() {
		listaUsuarios = new UsuarioDAOJDBC().todos();
		for(Usuario todos : listaUsuarios) {
			dtmListaUsuario.addRow(new String[] {todos.getIdUsuario().toString(), todos.getNome(), todos.getLogin()});
		}
	}
	
	public void preencherDadosTabelaFiltroNome() {
		listaUsuarios.addAll(new UsuarioDAOJDBC().buscarDescricao(usuarioForm.getNomeUsuario()));
		for(Usuario todos : listaUsuarios) {
			dtmListaUsuario.addRow(new String[] {todos.getIdUsuario().toString(), todos.getNome(), todos.getLogin()});
		}		
	}
	
	public void preencherDadosTabelaFiltroCodigo() {
		usuario = new Usuario();
		usuario = new UsuarioDAOJDBC().buscarId(Integer.valueOf(usuarioForm.getCodigoUsuario()));
		listaUsuarios.add(usuario);
		for(Usuario todos : listaUsuarios) {
			dtmListaUsuario.addRow(new String[] {todos.getIdUsuario().toString(), todos.getNome(), todos.getLogin()});
		}
	}
	
	public void validacaoPesquisa() {
		if((usuarioForm.getNomeUsuario() == null || usuarioForm.getNomeUsuario().equals(""))
			&& (usuarioForm.getCodigoUsuario() == null || usuarioForm.getCodigoUsuario().equals(""))) {
			this.preencherDadosTabelaSemFiltro();
		} else if(usuarioForm.getNomeUsuario() != null && !usuarioForm.getNomeUsuario().equals("")) {
			this.preencherDadosTabelaFiltroNome();
		} else if(usuarioForm.getCodigoUsuario() != null && !usuarioForm.getCodigoUsuario().equals("")) {
			this.preencherDadosTabelaFiltroCodigo();
		}
	}
	
	public void acionarBotaoSelecionar() {
		jbtSelecionarUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent acvt) {
				if(acvt.getSource() == jbtSelecionarUsuario) {
					Integer usuarioSelecionado = jttListaUsuario.getSelectedRow();
					if(usuarioSelecionado != -1) {
						Usuario usuario = listaUsuarios.get(usuarioSelecionado);
						usuarioForm.preencherCampos(usuario);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Nenhum usuário foi selecionado!!!\n"
						+ "Por gentileza, selecionar um usuário!!!", "Erro", JOptionPane.ERROR_MESSAGE);
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

	public ListaUsuarioForm(UsuarioForm usuarioForm) {
		this.usuarioForm = usuarioForm;
		listaUsuarios = new ArrayList<>();
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaUsuarioForm.class.getResource("/Imagens/washCar.jpeg")));
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
		acionarBotaoSelecionar();
		acionarBotaoCancelar();
		validacaoPesquisa();
	}
}