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

import dao.WashCar.ClienteDAOJDBC;
import model.WashCar.Cliente;
import preencherDados.WashCar.PreencherDados;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Window.Type;

public class ListaClienteForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnListaCliente;
	private Vector<String> dados;
	private JTable jttListaCliente;
	private DefaultTableModel dtmListaCliente;
	private JScrollPane jspListaCliente;
	private JButton jbtSelecionarCliente;
	private JButton jbtCancelarPesquisa;
	private List<Cliente> listaCliente;
	private Cliente cliente;
	private PreencherDados preencheDados;
	private Integer codigo;
	private String nome;
	private String cnpj;
	private String cpf;
	
	public void componenteListaCliente() {
		dados = new Vector<String>();
		dados.add("Código");
		dados.add("Nome do Cliente");
		dados.add("CNPJ do Cliente");
		dados.add("CPF do Cliente");
		dtmListaCliente = new DefaultTableModel();
		dtmListaCliente.setColumnIdentifiers(dados);
		jttListaCliente = new JTable();
		jttListaCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jttListaCliente.setModel(dtmListaCliente);
		jttListaCliente.getColumnModel().getColumn(0).setResizable(false);
		jttListaCliente.getColumnModel().getColumn(0).setPreferredWidth(15);
		jttListaCliente.getColumnModel().getColumn(1).setResizable(false);
		jttListaCliente.getColumnModel().getColumn(1).setPreferredWidth(250);
		jttListaCliente.getColumnModel().getColumn(2).setResizable(false);
		jttListaCliente.getColumnModel().getColumn(2).setPreferredWidth(80);
		jttListaCliente.getColumnModel().getColumn(3).setResizable(false);
		jttListaCliente.getColumnModel().getColumn(3).setPreferredWidth(80);
		jspListaCliente = new JScrollPane(jttListaCliente);
		jspListaCliente.setBounds(10, 10, 600, 365);
		jpnListaCliente.add(jspListaCliente);
				
		jbtSelecionarCliente = new JButton("Selecionar");
		jbtSelecionarCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSelecionarCliente.setBounds(10, 388, 110, 23);
		jpnListaCliente.add(jbtSelecionarCliente);
		
		jbtCancelarPesquisa = new JButton("Cancelar");
		jbtCancelarPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelarPesquisa.setBounds(140, 388, 110, 23);
		jpnListaCliente.add(jbtCancelarPesquisa);
	}
	
	public void preencherDadosTabelaSemFiltro() {
		listaCliente = new ClienteDAOJDBC().todos();
		for(Cliente clientes : listaCliente) {
			if(clientes.getTipoPessoa() == 1) {
				dtmListaCliente.addRow(new String [] {String.valueOf(clientes.getIdCliente()), clientes.getPessoaFisica().getNome(), null, clientes.getPessoaFisica().getCpf()});
			} else {
				dtmListaCliente.addRow(new String [] {String.valueOf(clientes.getIdCliente()),clientes.getPessoaJuridica().getNomeFantasia(), clientes.getPessoaJuridica().getCnpj(), null});
			}
		}
	}
	
	public void preencherDadosTabelaFiltroCodigo() {
		cliente = new Cliente();
		cliente = new ClienteDAOJDBC().buscarId(codigo);
		listaCliente.add(cliente);
		for(Cliente clientes : listaCliente) {
			if(clientes.getTipoPessoa() == 1) {
				dtmListaCliente.addRow(new String [] {String.valueOf(clientes.getIdCliente()), clientes.getPessoaFisica().getNome(), null, clientes.getPessoaFisica().getCpf()});
			} else {
				dtmListaCliente.addRow(new String [] {String.valueOf(clientes.getIdCliente()),clientes.getPessoaJuridica().getNomeFantasia(), clientes.getPessoaJuridica().getCnpj(), null});
			}
		}
	}
	
	public void preencherDadosTabelaFiltroNome() {
		listaCliente.addAll(new ClienteDAOJDBC().buscarDescricao(nome));
		for(Cliente clientes : listaCliente) {
			if(clientes.getTipoPessoa() == 1) {
				dtmListaCliente.addRow(new String [] {String.valueOf(clientes.getIdCliente()), clientes.getPessoaFisica().getNome(), null, clientes.getPessoaFisica().getCpf()});
			} else {
				dtmListaCliente.addRow(new String [] {String.valueOf(clientes.getIdCliente()),clientes.getPessoaJuridica().getNomeFantasia(), clientes.getPessoaJuridica().getCnpj(), null});
			}
		}
	}
	
	public void preencherDadosTabelaFiltroCNPJ() {
		cliente = new Cliente();
		cliente = new ClienteDAOJDBC().pesquisaCNPJ(cnpj);
		listaCliente.add(cliente);
		for(Cliente clientes : listaCliente) {
			if(clientes.getTipoPessoa() == 1) {
				dtmListaCliente.addRow(new String [] {String.valueOf(clientes.getIdCliente()), clientes.getPessoaFisica().getNome(), null, clientes.getPessoaFisica().getCpf()});
			} else {
				dtmListaCliente.addRow(new String [] {String.valueOf(clientes.getIdCliente()),clientes.getPessoaJuridica().getNomeFantasia(), clientes.getPessoaJuridica().getCnpj(), null});
			}
		}
	}
	
	public void preencherDadosTabelaFiltroCPF() {
		cliente = new Cliente();
		cliente = new ClienteDAOJDBC().pesquisaCPF(cpf);
		listaCliente.add(cliente);
		for(Cliente clientes : listaCliente) {
			if(clientes.getTipoPessoa() == 1) {
				dtmListaCliente.addRow(new String [] {String.valueOf(clientes.getIdCliente()), clientes.getPessoaFisica().getNome(), null, clientes.getPessoaFisica().getCpf()});
			} else {
				dtmListaCliente.addRow(new String [] {String.valueOf(clientes.getIdCliente()),clientes.getPessoaJuridica().getNomeFantasia(), clientes.getPessoaJuridica().getCnpj(), null});
			}
		}
	}
	
	public void validacaoPesquisa() {
		if((codigo == null || codigo.equals("")) && (nome == null || nome.equals(""))
			&& (cnpj == null || cnpj.equals("  .   .   /    -  ")) && (cpf == null || cpf.equals("   .   .   -  "))) {
			this.preencherDadosTabelaSemFiltro();
		} else if(codigo != null && !codigo.equals("")) {
			this.preencherDadosTabelaFiltroCodigo();
		} else if(nome != null && !nome.equals("")) {
			this.preencherDadosTabelaFiltroNome();
		} else if(cnpj != null && !cnpj.equals("  .   .   /    -  ")) {
			this.preencherDadosTabelaFiltroCNPJ();
		} else if(cpf != null && !cpf.equals("   .   .   -  ")) {
			this.preencherDadosTabelaFiltroCPF();
		}
	}
	
	public void acionarBotaoSelecionar() {
		jbtSelecionarCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtSelecionarCliente) {
					Integer clienteSelecionado = jttListaCliente.getSelectedRow();
					if(clienteSelecionado != -1) {
						cliente = listaCliente.get(clienteSelecionado);
						preencheDados.preencherCampos(cliente);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Nenhum cliente foi selecionado!!!\n"
						+ "Por gentileza, selecionar um cliente!!!", "Erro", JOptionPane.ERROR_MESSAGE);
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
		listaCliente = new ArrayList<>();
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaClienteForm.class.getResource("/Imagens/washCar.jpeg")));
		setTitle("Lista de Clientes");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 637, 461);
		setLocationRelativeTo(null);
		jpnListaCliente = new JPanel();
		jpnListaCliente.setLayout(null);
		setContentPane(jpnListaCliente);
				
		componenteListaCliente();
		validacaoPesquisa();
		acionarBotaoSelecionar();
		acionarBotaoCancelar();
	}

	public ListaClienteForm(PreencherDados dados, Integer codigo, String nome, String cnpj, String cpf) {
		this.preencheDados = dados;
		this.nome = nome;
		this.codigo = codigo;
		this.cnpj = cnpj;
		this.cpf = cpf;
		inicializarForm();
	}
}