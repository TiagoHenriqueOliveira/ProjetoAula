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
	private JMenuItem jmiCarro;
	private JMenuItem jmiCliente;
	private JMenu mnUsurios;
	private JMenuItem jmiCadastroUsuario;
	private JMenuItem jmiSair;
	private JMenu jmnServios;
	private JMenuItem jmiAgenda;
	private JMenuItem jmiOrdemServico;
	private JMenu jmnFinanceiro;
	private JMenuItem jmiContaPagar;
	private JMenuItem jmiContaReceber;
	private JMenu jmnConfiguracoes;
	private JMenuItem jmiEmpresa;
	private JMenu jmnParametros;
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
		
		mnUsurios = new JMenu("Usu\u00E1rios");
		jmnCadastro.add(mnUsurios);
		
		jmiCadastroUsuario = new JMenuItem("Cadastro de Usu\u00E1rio");
		mnUsurios.add(jmiCadastroUsuario);
		
		jmiSair = new JMenuItem("Sair do Sistema");
		jmnCadastro.add(jmiSair);
		
		jmnServios = new JMenu("Servi\u00E7os");
		jmbPrincipal.add(jmnServios);
		
		jmiAgenda = new JMenuItem("Agenda");
		jmnServios.add(jmiAgenda);
		
		jmiOrdemServico = new JMenuItem("Ordem de Servi\u00E7o");
		jmnServios.add(jmiOrdemServico);
		
		jmnFinanceiro = new JMenu("Financeiro");
		jmbPrincipal.add(jmnFinanceiro);
		
		jmiContaPagar = new JMenuItem("Contas \u00E0 Pagar");
		jmnFinanceiro.add(jmiContaPagar);
		
		jmiContaReceber = new JMenuItem("Contas \u00E0 Receber");
		jmnFinanceiro.add(jmiContaReceber);
		
		jmnConfiguracoes = new JMenu("Configura\u00E7\u00F5es");
		jmbPrincipal.add(jmnConfiguracoes);
		
		jmiEmpresa = new JMenuItem("Empresa");
		jmnConfiguracoes.add(jmiEmpresa);
		
		jmnParametros = new JMenu("Parâmetros");
		jmnConfiguracoes.add(jmnParametros);
		
		jmiMarca = new JMenuItem("Marcas");
		jmnParametros.add(jmiMarca);
		
		jmiModelo = new JMenuItem("Modelos");
		jmnParametros.add(jmiModelo);
		
		jmiTipoServico = new JMenuItem("Tipos de Servi\u00E7o");
		jmnParametros.add(jmiTipoServico);
	}

	public PrincipalForm() {
		setTitle("WashCar Lavagens");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrincipalForm.class.getResource("/Imagens/washCar.jpeg")));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		jpPrincipal = new JPanel();
		setLocationRelativeTo(null);
		setContentPane(jpPrincipal);

		componentesTelaPrincipal();
		
		jmiCarro.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiCarro) {
					carroForm = new CarroForm();
					carroForm.show();
				}
			}
		});
		
		jmiCliente.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiCliente) {
					clienteForm = new ClienteForm();
					clienteForm.show();
				}
			}
		});
		
		jmiCadastroUsuario.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiCadastroUsuario) {
					usuarioForm = new UsuarioForm();
					usuarioForm.show();
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
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiOrdemServico) {
					ordemServicoForm = new OrdemServicoForm();
					ordemServicoForm.show();
				}
			}
		});
		
		jmiEmpresa.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiEmpresa) {
					empresaForm = new EmpresaForm();
					empresaForm.show();
				}
			}
		});
		
		jmiMarca.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiMarca) {
					marcaForm = new MarcaForm();
					marcaForm.show();
				}
			}
		});
		
		jmiModelo.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiModelo) {
					modeloForm = new ModeloForm();
					modeloForm.show();
				}
			}
		});
		
		jmiTipoServico.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiTipoServico) {
					tipoServicoForm = new TipoServicoForm();
					tipoServicoForm.show();
				}
			}
		});
	}
}