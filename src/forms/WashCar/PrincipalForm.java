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
	private JMenuItem jmiAgenda;
	private JMenuItem jmiOrdemServico;
	private JMenuItem jmiEmpresa;
	private JMenuItem jmiMarca;
	private JMenuItem jmiModelo;
	private JMenuItem jmiTipoServico;
	private static UsuarioForm usuarioForm = new UsuarioForm();
	private static CarroForm carroForm = new CarroForm();
	private static ClienteForm clienteForm = new ClienteForm();
	private static AgendaForm agendaForm = new AgendaForm();
	private static OrdemServicoForm ordemServicoForm = new OrdemServicoForm();
	private static EmpresaForm empresaForm = new EmpresaForm();
	private static ModeloForm modeloForm = new ModeloForm();
	private static MarcaForm marcaForm = new MarcaForm();
	private static TipoServicoForm tipoServicoForm = new TipoServicoForm();
	
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
					if(agendaForm.isVisible()) {
						JOptionPane.showMessageDialog(null, "Agenda de serviços, já está aberta!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
						agendaForm.requestFocus();
						agendaForm.setLocationRelativeTo(null);
					} else {
						agendaForm = new AgendaForm();
						agendaForm.setVisible(true);
					}
				}
			}
		});
		jmiCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiCarro) {
					if(carroForm.isVisible()) {
						JOptionPane.showMessageDialog(null, "Cadastro de carro, já está aberto!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
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
						JOptionPane.showMessageDialog(null, "Cadastro de cliente, já está aberto!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
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
						JOptionPane.showMessageDialog(null, "Cadastro de usuário, já está aberto!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
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
						JOptionPane.showMessageDialog(null, "Cadastro de Ordem de Serviço, já está aberta!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
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
						JOptionPane.showMessageDialog(null, "Cadastro de empresa, já está aberto!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
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
						JOptionPane.showMessageDialog(null, "Cadastro de marca, já está aberto!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
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
						JOptionPane.showMessageDialog(null, "Cadastro de modelo, já está aberto!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
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
						JOptionPane.showMessageDialog(null, "Cadastro de tipo de serviço, já está aberto!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
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