package forms.WashCar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class PrincipalForm extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jpPrincipal;
	private JMenuBar jmbPrincipal;
	private JMenu jmnCadastro;
	private JMenu mnUsurios;
	private JMenu jmnServios;
	private JMenu jmnConfiguracoes;
	private JMenuItem jmiCarro;
	private JMenuItem jmiCliente;
	private JMenuItem jmiCadastroUsuario;
	private JMenuItem jmiSair;
	private JMenuItem jmiAgenda;
	private JMenuItem jmiOrdemServico;
	private JMenuItem jmiEmpresa;
	private JMenuItem jmiMarca;
	private JMenuItem jmiModelo;
	private JMenuItem jmiTipoServico;
	private static UsuarioForm usuarioForm;
	private static CarroForm carroForm;
	private static ClienteForm clienteForm;
	private static AgendaForm agendaForm;
	private static OrdemServicoForm ordemServicoForm;
	private static EmpresaForm empresaForm;
	private static ModeloForm modeloForm;
	private static MarcaForm marcaForm;
	private static TipoServicoForm tipoServicoForm;
	
	public void componentesTelaPrincipal() {
		jmbPrincipal = new JMenuBar();
		setJMenuBar(jmbPrincipal);

		jmnCadastro = new JMenu("Cadastros");
		jmbPrincipal.add(jmnCadastro);

		jmiCarro = new JMenuItem("Carros");
		jmnCadastro.add(jmiCarro);

		jmiCliente = new JMenuItem("Clientes");
		jmnCadastro.add(jmiCliente);
		
		jmiMarca = new JMenuItem("Marcas");
		jmnCadastro.add(jmiMarca);
		
		jmiModelo = new JMenuItem("Modelos");
		jmnCadastro.add(jmiModelo);
		
		mnUsurios = new JMenu("Usu\u00E1rios");
		jmnCadastro.add(mnUsurios);
		
		jmiCadastroUsuario = new JMenuItem("Cadastro de Usu\u00E1rio");
		mnUsurios.add(jmiCadastroUsuario);
		
		jmiTipoServico = new JMenuItem("Tipos de Servi\u00E7o");
		jmnCadastro.add(jmiTipoServico);
		
		jmiSair = new JMenuItem("Sair do Sistema");
		jmnCadastro.add(jmiSair);
		
		jmnServios = new JMenu("Servi\u00E7os");
		jmbPrincipal.add(jmnServios);
		
		jmiAgenda = new JMenuItem("Agenda");
		jmnServios.add(jmiAgenda);
		
		jmiOrdemServico = new JMenuItem("Ordem de Servi\u00E7o");
		jmnServios.add(jmiOrdemServico);
		
		jmnConfiguracoes = new JMenu("Configura\u00E7\u00F5es");
		jmbPrincipal.add(jmnConfiguracoes);
		
		jmiEmpresa = new JMenuItem("Empresa");
		jmnConfiguracoes.add(jmiEmpresa);
	}
	
	public void acoesDosMenus() {
		jmiAgenda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiAgenda) {
					agendaForm = new AgendaForm();
					agendaForm.setVisible(true);
				}
			}
		});
		jmiCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiCarro) {
					carroForm = new CarroForm();
					carroForm.setVisible(true);
				}
			}
		});
		
		jmiCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiCliente) {
					clienteForm = new ClienteForm();
					clienteForm.setVisible(true);
				}
			}
		});
		
		jmiCadastroUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiCadastroUsuario) {
					usuarioForm = new UsuarioForm();
					usuarioForm.setVisible(true);
				}
			}
		});
		
		jmiSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiSair) {
					System.exit(0);
				}
			}
		});
		
		jmiOrdemServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiOrdemServico) {
					ordemServicoForm = new OrdemServicoForm();
					ordemServicoForm.setVisible(true);
				}
			}
		});
		
		jmiEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiEmpresa) {
					empresaForm = new EmpresaForm();
					empresaForm.setVisible(true);
				}
			}
		});
		
		jmiMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiMarca) {
					marcaForm = new MarcaForm();
					marcaForm.setVisible(true);
				}
			}
		});
		
		jmiModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiModelo) {
					modeloForm = new ModeloForm();
					modeloForm.setVisible(true);
				}
			}
		});
		
		jmiTipoServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiTipoServico) {
					tipoServicoForm = new TipoServicoForm();
					tipoServicoForm.setVisible(true);
				}
			}
		});
	}

	public PrincipalForm() {
		setTitle("WashCar Lavagens");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrincipalForm.class.getResource("/Imagens/washCar.jpeg")));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		jpPrincipal = new JPanel();
		setLocationRelativeTo(null);
		setContentPane(jpPrincipal);

		componentesTelaPrincipal();
		acoesDosMenus();		
	}
}