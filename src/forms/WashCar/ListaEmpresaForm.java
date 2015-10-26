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

import model.WashCar.Empresa;
import preencherDados.WashCar.PreencherDados;
import dao.WashCar.EmpresaDAOJDBC;

public class ListaEmpresaForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnListaEmpresa;
	private Vector<String> dados;
	private JTable jttListaEmpresa;
	private DefaultTableModel dtmListaEmpresa;
	private JScrollPane jspListaEmpresa;
	private JButton jbtSelecionarEmpresa;
	private JButton jbtCancelarPesquisa;
	private List<Empresa> listaEmpresas;
	private Empresa empresa;
	private PreencherDados preencheDados;
	private Integer codigo;
	private String descricao;
	private String documento;

	public void componentesListaUsuario() {
		dados = new Vector<String>();
		dados.add("Código");
		dados.add("Razão Social");
		dados.add("Nome Fantasia");
		dados.add("Cnpj");
		dados.add("Inscrição Estadual");
		dados.add("Inscrição Municipal");
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
		jttListaEmpresa.getColumnModel().getColumn(3).setResizable(false);
		jttListaEmpresa.getColumnModel().getColumn(3).setPreferredWidth(100);
		jttListaEmpresa.getColumnModel().getColumn(4).setResizable(false);
		jttListaEmpresa.getColumnModel().getColumn(4).setPreferredWidth(100);
		jttListaEmpresa.getColumnModel().getColumn(5).setResizable(false);
		jttListaEmpresa.getColumnModel().getColumn(5).setPreferredWidth(100);
		jspListaEmpresa = new JScrollPane(jttListaEmpresa);
		jspListaEmpresa.setBounds(10, 10, 774, 300);
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
	
	public void preencherDadosTabelaSemFiltro() {
		listaEmpresas = new EmpresaDAOJDBC().todos();
		for(Empresa todas : listaEmpresas) {
			dtmListaEmpresa.addRow(new String[] {	todas.getIdEmpresa().toString(), todas.getRazaoSocial(), todas.getNomeFantasia(),
					todas.getCnpj(), todas.getInscricaoEstadual(), todas.getInscricaoMunicipal()	});
		}
	}
	
	public void preencherDadosTabelaFiltroCodigo() {
		empresa = new Empresa();
		empresa = new EmpresaDAOJDBC().buscarId(Integer.valueOf(codigo));
		listaEmpresas.add(empresa);
		for(Empresa todas : listaEmpresas) {
			dtmListaEmpresa.addRow(new String[] {	todas.getIdEmpresa().toString(), todas.getRazaoSocial(), todas.getNomeFantasia(),
					todas.getCnpj(), todas.getInscricaoEstadual(), todas.getInscricaoMunicipal()	});
		}
	}
	
	public void preencherDadosTabelaFiltroNome() {
		listaEmpresas.addAll(new EmpresaDAOJDBC().buscarDescricao(descricao));
		for(Empresa todas : listaEmpresas) {
			dtmListaEmpresa.addRow(new String[] {	todas.getIdEmpresa().toString(), todas.getRazaoSocial(), todas.getNomeFantasia(),
					todas.getCnpj(), todas.getInscricaoEstadual(), todas.getInscricaoMunicipal()	});
		}
	}
	
	public void preencherDadosTabelaFiltroDocumento() {
		empresa = new Empresa();
		empresa = new EmpresaDAOJDBC().buscarDocumento(documento);
		listaEmpresas.add(empresa);
		for(Empresa todas : listaEmpresas) {
			dtmListaEmpresa.addRow(new String[] {	todas.getIdEmpresa().toString(), todas.getRazaoSocial(), todas.getNomeFantasia(),
					todas.getCnpj(), todas.getInscricaoEstadual(), todas.getInscricaoMunicipal()	});
		}
	}
	
	public void validacaoPesquisa() {
		if((codigo == null || codigo.equals("")) && (descricao == null || descricao.equals(""))
			&& (documento == null || documento.equals(""))) {
				this.preencherDadosTabelaSemFiltro();
			} else if(codigo != null && !codigo.equals("")) {
				this.preencherDadosTabelaFiltroCodigo();
			} else if(descricao != null && !descricao.equals("")) {
				this.preencherDadosTabelaFiltroNome();
			} else if(documento != null && !documento.equals("")) {
				this.preencherDadosTabelaFiltroDocumento();
			}
	}
	
	public void acionarBotaoSelecionar() {
		jbtSelecionarEmpresa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtSelecionarEmpresa) {
					Integer empresaSelecionada = jttListaEmpresa.getSelectedRow();
					if(empresaSelecionada != -1) {
						empresa = listaEmpresas.get(empresaSelecionada);
						preencheDados.preencherCampos(empresa);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Nenhuma empresa foi selecionada!!!\n"
								+ "Por gentileza, selecionar uma empresa!!!", "Erro", JOptionPane.ERROR_MESSAGE);
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
		listaEmpresas = new ArrayList<>();
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaEmpresaForm.class.getResource("/Imagens/washCar.jpeg")));
		setFont(new Font("Tahoma", Font.PLAIN, 12));
		setResizable(false);
		setTitle("Lista de Empresas");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		setLocationRelativeTo(null);
		jpnListaEmpresa = new JPanel();
		jpnListaEmpresa.setLayout(null);
		setContentPane(jpnListaEmpresa);
		
		componentesListaUsuario();
		validacaoPesquisa();
		acionarBotaoSelecionar();
		acionarBotaoCancelar();	
	}

	public ListaEmpresaForm(PreencherDados dados, String descricao, Integer codigo, String documento) {
		this.preencheDados = dados;
		this.descricao = descricao;
		this.codigo = codigo;
		this.documento = documento;
		inicializarForm();
	}
}