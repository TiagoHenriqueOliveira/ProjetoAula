package forms.WashCar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;

public class AgendaForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnAgenda;

	public static void main(String[] args) {
		AgendaForm agenda = new AgendaForm();
		agenda.setVisible(true);
	}

	public AgendaForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AgendaForm.class.getResource("/Imagens/washCar.jpeg")));
		setResizable(false);
		setTitle("Agenda | WashCar");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		jpnAgenda = new JPanel();
		setContentPane(jpnAgenda);
	}
}