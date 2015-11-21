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

import dao.WashCar.OrdemServicoDAOJDBC;
import model.WashCar.OrdemServico;
import preencherDados.WashCar.PreencherDados;

public class ListaOrdemServicoForm extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel jpnListaOrdemServico;
	private Vector<String> dados;
	private JTable jttListaOrdemServico;
	private DefaultTableModel dtmListaOrdemServico;
	private JScrollPane jspListaOrdemServico;
	private JButton jbtSelecionarOrdemServico;
	private JButton jbtCancelarPesquisa;
	private List<OrdemServico> listaOrdemServico;
	private OrdemServico ordemServico;
	private PreencherDados preencheDados;
	private Integer codigo;
	private String descricao;
	private String placa; 

	@SuppressWarnings("static-access")
	public void componentesListaOrdemServico() {
		dados = new Vector<String>();
		dados.add("Código");
		dados.add("Nome do Cliente");
		dados.add("CPF do Cliente");
		dados.add("CNPJ do Cliente");
		dados.add("Nome do Carro");
		dados.add("Placa do Carro");
		dtmListaOrdemServico = new DefaultTableModel();
		dtmListaOrdemServico.setColumnIdentifiers(dados);
		jttListaOrdemServico = new JTable();
		jttListaOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jttListaOrdemServico.setModel(dtmListaOrdemServico);
		jttListaOrdemServico.getColumnModel().getColumn(0).setResizable(false);
		jttListaOrdemServico.getColumnModel().getColumn(0).setPreferredWidth(60);
		jttListaOrdemServico.getColumnModel().getColumn(1).setResizable(false);
		jttListaOrdemServico.getColumnModel().getColumn(1).setPreferredWidth(250);
		jttListaOrdemServico.getColumnModel().getColumn(2).setResizable(false);
		jttListaOrdemServico.getColumnModel().getColumn(2).setPreferredWidth(110);
		jttListaOrdemServico.getColumnModel().getColumn(3).setResizable(false);
		jttListaOrdemServico.getColumnModel().getColumn(3).setPreferredWidth(130);
		jttListaOrdemServico.getColumnModel().getColumn(4).setResizable(false);
		jttListaOrdemServico.getColumnModel().getColumn(4).setPreferredWidth(400);
		jttListaOrdemServico.getColumnModel().getColumn(5).setResizable(false);
		jttListaOrdemServico.getColumnModel().getColumn(5).setPreferredWidth(100);
		jspListaOrdemServico = new JScrollPane(jttListaOrdemServico);
		jttListaOrdemServico.setAutoResizeMode(jttListaOrdemServico.AUTO_RESIZE_OFF);
		jspListaOrdemServico.setBounds(10, 10, 674, 300);
		jpnListaOrdemServico.add(jspListaOrdemServico);
		
		jbtSelecionarOrdemServico = new JButton("Selecionar");
		jbtSelecionarOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtSelecionarOrdemServico.setBounds(10, 338, 110, 23);
		jpnListaOrdemServico.add(jbtSelecionarOrdemServico);
		
		jbtCancelarPesquisa = new JButton("Cancelar");
		jbtCancelarPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelarPesquisa.setBounds(130, 339, 110, 23);
		jpnListaOrdemServico.add(jbtCancelarPesquisa);
	}
	
	public void preencherDadosTabelaSemFiltro() {
		listaOrdemServico = new OrdemServicoDAOJDBC().todos();
		for(OrdemServico todos : listaOrdemServico) {
			if(todos.getCliente().getTipoPessoa() == 1) {
				dtmListaOrdemServico.addRow(new String[] {String.valueOf(todos.getIdOrdemServico()), todos.getCliente().getPessoaFisica().getNome(),
						todos.getCliente().getPessoaFisica().getCpf(), null, todos.getCarro().getNome(), todos.getCarro().getPlaca()});
			} else {
				dtmListaOrdemServico.addRow(new String[] {String.valueOf(todos.getIdOrdemServico()), todos.getCliente().getPessoaJuridica().getNomeFantasia(), null,
						todos.getCliente().getPessoaJuridica().getCnpj(), todos.getCarro().getNome(), todos.getCarro().getPlaca()});
			}
		}
	}
	
	public void preencherDadosTabelaFiltroCodigo() {
		ordemServico = new OrdemServico();
		ordemServico = new OrdemServicoDAOJDBC().buscarId(codigo);
		listaOrdemServico.add(ordemServico);
		for(OrdemServico todos : listaOrdemServico) {
			if(todos.getCliente().getTipoPessoa() == 1) {
				dtmListaOrdemServico.addRow(new String[] {String.valueOf(todos.getIdOrdemServico()), todos.getCliente().getPessoaFisica().getNome(),
						todos.getCliente().getPessoaFisica().getCpf(), null, todos.getCarro().getNome(), todos.getCarro().getPlaca()});
			} else {
				dtmListaOrdemServico.addRow(new String[] {String.valueOf(todos.getIdOrdemServico()), todos.getCliente().getPessoaJuridica().getNomeFantasia(), null,
						todos.getCliente().getPessoaJuridica().getCnpj(), todos.getCarro().getNome(), todos.getCarro().getPlaca()});
			}
		}
	}
	
	public void preencherDadosTabelaFiltroNome() {
		listaOrdemServico.addAll(new OrdemServicoDAOJDBC().buscarDescricao(descricao));
		for(OrdemServico todos : listaOrdemServico) {
			if(todos.getCliente().getTipoPessoa() == 1) {
				dtmListaOrdemServico.addRow(new String[] {String.valueOf(todos.getIdOrdemServico()), todos.getCliente().getPessoaFisica().getNome(),
						todos.getCliente().getPessoaFisica().getCpf(), null, todos.getCarro().getNome(), todos.getCarro().getPlaca()});
			} else {
				dtmListaOrdemServico.addRow(new String[] {String.valueOf(todos.getIdOrdemServico()), todos.getCliente().getPessoaJuridica().getNomeFantasia(), null,
						todos.getCliente().getPessoaJuridica().getCnpj(), todos.getCarro().getNome(), todos.getCarro().getPlaca()});
			}
		}		
	}
	
	public void preencherDadosTabelaFiltroPlaca() {
		ordemServico = new OrdemServico();
		ordemServico = new OrdemServicoDAOJDBC().pesquisaPorPlaca(placa);
		listaOrdemServico.add(ordemServico);
		for(OrdemServico todos : listaOrdemServico) {
			if(todos.getCliente().getTipoPessoa() == 1) {
				dtmListaOrdemServico.addRow(new String[] {String.valueOf(todos.getIdOrdemServico()), todos.getCliente().getPessoaFisica().getNome(),
						todos.getCliente().getPessoaFisica().getCpf(), null, todos.getCarro().getNome(), todos.getCarro().getPlaca()});
			} else {
				dtmListaOrdemServico.addRow(new String[] {String.valueOf(todos.getIdOrdemServico()), todos.getCliente().getPessoaJuridica().getNomeFantasia(), null,
						todos.getCliente().getPessoaJuridica().getCnpj(), todos.getCarro().getNome(), todos.getCarro().getPlaca()});
			}
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
		jbtSelecionarOrdemServico.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent acvt) {
				if(acvt.getSource() == jbtSelecionarOrdemServico) {
					Integer ordemServicoSelecionada = jttListaOrdemServico.getSelectedRow();
					if(ordemServicoSelecionada != -1) {
						ordemServico = listaOrdemServico.get(ordemServicoSelecionada);
						preencheDados.preencherCampos(ordemServico);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Nenhuma ordem de serviço foi selecionada!!!\n"
						+ "Por gentileza, selecionar uma ordem de serviço!!!", "Erro", JOptionPane.ERROR_MESSAGE);
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
		listaOrdemServico = new ArrayList<>();
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaOrdemServicoForm.class.getResource("/Imagens/washCar.jpeg")));
		setFont(new Font("Tahoma", Font.PLAIN, 12));
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Lista de Ordens de Servi\u00E7o");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		setLocationRelativeTo(null);
		jpnListaOrdemServico = new JPanel();
		jpnListaOrdemServico.setLayout(null);
		setContentPane(jpnListaOrdemServico);
		
		componentesListaOrdemServico();
		acionarBotaoSelecionar();
		acionarBotaoCancelar();
		validacaoPesquisa();
	}

	public ListaOrdemServicoForm(PreencherDados dados, String descricao, Integer codigo, String placa) {
		this.preencheDados = dados;
		this.codigo = codigo;
		this.descricao = descricao;
		this.placa = placa;
		inicializarForm();
	}
}