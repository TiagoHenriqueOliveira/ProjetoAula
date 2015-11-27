package forms.WashCar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class PrincipalForm extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jpPrincipal;
	private JMenuBar jmbPrincipal;
	private JMenu jmnCadastro;
	private JMenu jmnServios;
	private JMenu jmnConfiguracoes;
	private JMenuItem jmiCarro;
	private JMenuItem jmiCliente;
	private JMenuItem jmiCadastroUsuario;
	private JMenuItem jmiSair;
	private JMenuItem jmiOrdemServico;
	private JMenuItem jmiEmpresa;
	private JMenuItem jmiMarca;
	private JMenuItem jmiModelo;
	private JMenuItem jmiTipoServico;
	private UsuarioForm usuarioForm = new UsuarioForm();
	private CarroForm carroForm = new CarroForm();
	private ClienteForm clienteForm = new ClienteForm();
	private OrdemServicoForm ordemServicoForm = new OrdemServicoForm();
	private EmpresaForm empresaForm = new EmpresaForm();
	private ModeloForm modeloForm = new ModeloForm();
	private MarcaForm marcaForm = new MarcaForm();
	private TipoServicoForm tipoServicoForm = new TipoServicoForm();
	
	public void componentesTelaPrincipal() {
		jmbPrincipal = new JMenuBar();
		setJMenuBar(jmbPrincipal);

		jmnCadastro = new JMenu("Cadastros");
		jmbPrincipal.add(jmnCadastro);
		
		jmiCadastroUsuario = new JMenuItem("Cadastro de Usu\u00E1rio");
		jmnCadastro.add(jmiCadastroUsuario);

		jmiCarro = new JMenuItem("Carros");
		jmnCadastro.add(jmiCarro);

		jmiCliente = new JMenuItem("Clientes");
		jmnCadastro.add(jmiCliente);
		
		jmiMarca = new JMenuItem("Marcas");
		jmnCadastro.add(jmiMarca);
		
		jmiModelo = new JMenuItem("Modelos");
		jmnCadastro.add(jmiModelo);
		
		jmiTipoServico = new JMenuItem("Tipos de Servi\u00E7o");
		jmnCadastro.add(jmiTipoServico);
		
		jmiSair = new JMenuItem("Sair do Sistema");
		jmnCadastro.add(jmiSair);
		
		jmnServios = new JMenu("Servi\u00E7os");
		jmbPrincipal.add(jmnServios);
		
		jmiOrdemServico = new JMenuItem("Ordem de Servi\u00E7o");
		jmnServios.add(jmiOrdemServico);
		
		jmnConfiguracoes = new JMenu("Configura\u00E7\u00F5es");
		jmbPrincipal.add(jmnConfiguracoes);
		
		jmiEmpresa = new JMenuItem("Empresa");
		jmnConfiguracoes.add(jmiEmpresa);
	}
	
	public void acoesDosMenus() {
		jmiCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiCarro) {
					if(carroForm.isVisible()) {
						carroForm.requestFocus();
						carroForm.setLocationRelativeTo(null);
					} else {
						carroForm = new CarroForm();
						carroForm.setVisible(true);
					}
				}
			}
		});
		
		jmiCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiCliente) {
					if(clienteForm.isVisible()) {
						clienteForm.requestFocus();
						clienteForm.setLocationRelativeTo(null);
					} else {
						clienteForm = new ClienteForm();
						clienteForm.setVisible(true);
					}
				}
			}
		});
		
		jmiCadastroUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiCadastroUsuario) {
					if(usuarioForm.isVisible()) {
						usuarioForm.requestFocus();
						usuarioForm.setLocationRelativeTo(null);
					} else {
						usuarioForm = new UsuarioForm();
						usuarioForm.setVisible(true);
					}
				}
			}
		});
		
		jmiOrdemServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiOrdemServico) {
					if(ordemServicoForm.isVisible()) {
						ordemServicoForm.requestFocus();
						ordemServicoForm.setLocationRelativeTo(null);
					} else {
						ordemServicoForm = new OrdemServicoForm();
						ordemServicoForm.setVisible(true);
					}
				}
			}
		});
		
		jmiEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiEmpresa) {
					if(empresaForm.isVisible()) {
						empresaForm.requestFocus();
						empresaForm.setLocationRelativeTo(null);
					} else {
						empresaForm = new EmpresaForm();
						empresaForm.setVisible(true);
					}
				}
			}
		});
		
		jmiMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiMarca) {
					if(marcaForm.isVisible()) {
						marcaForm.requestFocus();
						marcaForm.setLocationRelativeTo(null);
					} else {
						marcaForm = new MarcaForm();
						marcaForm.setVisible(true);
					}
				}
			}
		});
		
		jmiModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiModelo) {
					if(modeloForm.isVisible()) {
						modeloForm.requestFocus();
						modeloForm.setLocationRelativeTo(null);
					} else {
						modeloForm = new ModeloForm();
						modeloForm.setVisible(true);
					}
				}
			}
		});
		
		jmiTipoServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiTipoServico) {
					if(tipoServicoForm.isVisible()) {
						tipoServicoForm.requestFocus();
						tipoServicoForm.setLocationRelativeTo(null);
					} else {
						tipoServicoForm = new TipoServicoForm();
						tipoServicoForm.setVisible(true);
					}
				}
			}
		});
		
		jmiSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiSair) {
					Integer valor = JOptionPane.showConfirmDialog(null, "Deseja sair do sistema", "Confirmação", JOptionPane.YES_NO_OPTION);
					if(valor == 0) {
						System.exit(0);
					}
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