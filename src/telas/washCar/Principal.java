package telas.washCar;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jpPrincipal;

	public static void main(String[] args) {
		Principal principal = new Principal();
		principal.setVisible(true);
	}

	public Principal() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		jpPrincipal = new JPanel();
		jpPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		jpPrincipal.setLayout(new BorderLayout(0, 0));
		setContentPane(jpPrincipal);
		this.setExtendedState(MAXIMIZED_BOTH);
	}
}