package telas.washCar;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AgendaTela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnAgenda;

	public static void main(String[] args) {
		AgendaTela agenda = new AgendaTela();
		agenda.setVisible(true);
	}

	public AgendaTela() {
		setResizable(false);
		setTitle("Agenda | WashCar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		jpnAgenda = new JPanel();
		setContentPane(jpnAgenda);
	}
}