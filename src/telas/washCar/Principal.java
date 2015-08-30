package telas.washCar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jpPrincipal;
	private JMenuBar jmbPrincipal;
	private JMenu jmnCadastro;
	private JMenuItem jmiCarro;
	private JMenuItem jmiCliente;
	private JMenu mnUsurios;
	private JMenuItem jmiCadastroUsuario;
	private JMenuItem jmiAlteracaoSenha;
	private JMenuItem jmiSair;
	private JMenu jmnServios;
	private JMenuItem jmiAgenda;
	private JMenuItem jmiOrdemServico;
	private JMenu jmnFinanceiro;
	private JMenuItem jmiContaPagar;
	private JMenuItem jmiContaReceber;
	private JMenu jmnConfiguracoes;
	private JMenuItem jmiEmpresas;
	private JMenu jmnParametros;
	private JMenuItem jmiMarca;
	private JMenuItem jmiModelo;
	private JMenuItem jmiTipoServico;

	public static void main(String[] args) {
		Principal principal = new Principal();
		principal.setVisible(true);
	}
	
	public void componentesTela() {
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
		
		jmiAlteracaoSenha = new JMenuItem("Altera\u00E7\u00E3o de Senha");
		mnUsurios.add(jmiAlteracaoSenha);
		
		jmiSair = new JMenuItem("Sair");
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
		
		jmiEmpresas = new JMenuItem("Empresa");
		jmnConfiguracoes.add(jmiEmpresas);
		
		jmnParametros = new JMenu("Parametros");
		jmnConfiguracoes.add(jmnParametros);
		
		jmiMarca = new JMenuItem("Marcas");
		jmnParametros.add(jmiMarca);
		
		jmiModelo = new JMenuItem("Modelos");
		jmnParametros.add(jmiModelo);
		
		jmiTipoServico = new JMenuItem("Tipos de Servi\u00E7o");
		jmnParametros.add(jmiTipoServico);
	}

	public Principal() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		jpPrincipal = new JPanel();
		setContentPane(jpPrincipal);
		this.setExtendedState(MAXIMIZED_BOTH);

		componentesTela();

	}
}