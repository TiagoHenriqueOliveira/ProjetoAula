package telas.washCar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalTela extends JFrame {

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

	public PrincipalTela() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		jpPrincipal = new JPanel();
		setLocationRelativeTo(null);
		setContentPane(jpPrincipal);
		//this.setExtendedState(MAXIMIZED_BOTH);

		componentesTelaPrincipal();
		
		jmiCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiCarro) {
					CarroTela cadastroCarro = new CarroTela();
					cadastroCarro.setVisible(true);
				}
			}
		});
		
		jmiCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiCliente) {
					ClienteTela cadastroCliente = new ClienteTela();
					cadastroCliente.setVisible(true);
				}
			}
		});
		
		jmiCadastroUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiCadastroUsuario) {
					UsuarioTela cadastroUsuario = new UsuarioTela();
					cadastroUsuario.setVisible(true);
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
					OrdemServicoTela cadastrarOrdemServico = new OrdemServicoTela();
					cadastrarOrdemServico.setVisible(true);
				}
			}
		});
		
		jmiEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiEmpresa) {
					EmpresaTela cadastroEmpresa = new EmpresaTela();
					cadastroEmpresa.setVisible(true);
				}
			}
		});
		
		jmiMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiMarca) {
					MarcaTela cadastraMarca = new MarcaTela();
					cadastraMarca.setVisible(true);
				}
			}
		});
		
		jmiModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiModelo) {
					ModeloTela cadastraModelo = new ModeloTela();
					cadastraModelo.setVisible(true);
				}
			}
		});
		
		jmiTipoServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jmiTipoServico) {
					TipoServicoTela cadastraTipoServico = new TipoServicoTela();
					cadastraTipoServico.setVisible(true);
				}
			}
		});
	}
}