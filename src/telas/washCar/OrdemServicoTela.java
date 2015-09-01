package telas.washCar;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class OrdemServicoTela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnOrdemServico;

	public static void main(String[] args) {
		OrdemServicoTela ordemServico = new OrdemServicoTela();
		ordemServico.setVisible(true);
	}

	public OrdemServicoTela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		jpnOrdemServico = new JPanel();
		setContentPane(jpnOrdemServico);
	}
}