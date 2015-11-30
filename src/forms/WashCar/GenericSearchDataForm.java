package forms.WashCar;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

import model.WashCar.Data;
import preencherDados.WashCar.PreencherDados;
import javax.swing.ImageIcon;

public class GenericSearchDataForm extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel jpnDataForm = new JPanel();
	private JButton jbtOK;
	private JButton jbtCancelar;
	private JLabel jlbDataInicial;
	private JLabel jlbDataFinal;
	private JFormattedTextField jftfDataInicial;
	private JFormattedTextField jftfDataFinal;
	private String dataInicial;
	private String dataFinal;
	private Data data;
	private PreencherDados preencheDados;
	
	public void componentesDataForm() {
		jbtOK = new JButton("");
		jbtOK.setIcon(new ImageIcon(GenericSearchDataForm.class.getResource("/Imagens/ok.jpg")));
		jbtOK.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtOK.setBounds(63, 56, 30, 30);
		jpnDataForm.setBorder(UIManager.getBorder("PopupMenu.border"));
		jpnDataForm.add(jbtOK);
		jbtOK.setActionCommand("OK");
		getRootPane().setDefaultButton(jbtOK);
		
		jbtCancelar = new JButton("");
		jbtCancelar.setIcon(new ImageIcon(GenericSearchDataForm.class.getResource("/Imagens/no.jpg")));
		jbtCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbtCancelar.setBounds(103, 56, 30, 30);
		jpnDataForm.add(jbtCancelar);
		jbtCancelar.setActionCommand("Cancel");
		
		jlbDataInicial = new JLabel("Data Inicial");
		jlbDataInicial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataInicial.setBounds(10, 11, 140, 14);
		jpnDataForm.add(jlbDataInicial);
		
		try {
			jftfDataInicial = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jftfDataInicial.setHorizontalAlignment(SwingConstants.RIGHT);
		jftfDataInicial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jftfDataInicial.setBounds(10, 25, 75, 20);
		jpnDataForm.add(jftfDataInicial);
		
		jlbDataFinal = new JLabel("Data Final");
		jlbDataFinal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbDataFinal.setBounds(107, 11, 140, 14);
		jpnDataForm.add(jlbDataFinal);
		
		try {
			jftfDataFinal = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jftfDataFinal.setHorizontalAlignment(SwingConstants.RIGHT);
		jftfDataFinal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jftfDataFinal.setBounds(107, 25, 75, 20);
		jpnDataForm.add(jftfDataFinal);
	}
	
	public void acionarBotaoOK	() {
		jbtOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(evt.getSource() == jbtOK) {
					if(jftfDataInicial.getText().equals("  /  /    ")) {
						JOptionPane.showMessageDialog(null, "A data inicial não pode ser em vazio/sem informação.\n"
						+ "Por gentileza, informe uma data válida.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
						jftfDataInicial.requestFocus();
					} else if(jftfDataFinal.getText().equals("  /  /    ")) {
						JOptionPane.showMessageDialog(null, "A data final não pode ser em vazio/sem informação.\n"
						+ "Por gentileza, informe uma data válida.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
						jftfDataFinal.requestFocus();
					} else {
						data = new Data();
						
						String diaInicial = jftfDataInicial.getText().substring(0, 2);
						String mesInicial = jftfDataInicial.getText().substring(3, 5);
						String anoInicial = jftfDataInicial.getText().substring(6);
						dataInicial = anoInicial + "-" + mesInicial + "-" + diaInicial;
						
						String diaFinal = jftfDataFinal.getText().substring(0, 2);
						String mesFinal = jftfDataFinal.getText().substring(3, 5);
						String anoFinal = jftfDataFinal.getText().substring(6);
						dataFinal = anoFinal + "-" + mesFinal + "-" + diaFinal;
						
						Integer dtFim = Integer.valueOf(anoFinal + mesFinal + diaFinal);
						Integer dtIni = Integer.valueOf(anoInicial + mesInicial + diaInicial);
						
						if(dtFim < dtIni) {
							JOptionPane.showMessageDialog(null, "A data final não pode ser menor que a data inicial."
							+ "Por gentileza, informe uma data válida.", "Atenção", JOptionPane.WARNING_MESSAGE);
							jftfDataInicial.requestFocus();
							jftfDataInicial.setText("");
							jftfDataFinal.setText("");
						} else {
							data.setDataInicial(Date.valueOf(dataInicial).toLocalDate());
							data.setDataFinal(Date.valueOf(dataFinal).toLocalDate());
							preencheDados.preencherCampos(data);
							dispose();
						}
					}
				}
			}
		});
	}
	
	public void acionarBotaoCancelar() {
		jbtCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(evt.getSource() == jbtCancelar) {
					dispose();
				}
			}
		});
	}
	
	public void inicializarForm() {
		setFont(new Font("Tahoma", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(GenericSearchDataForm.class.getResource("/Imagens/washCar.jpeg")));
		setTitle("Período");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setBounds(100, 100, 202, 125);
		getContentPane().add(jpnDataForm, BorderLayout.CENTER);
		jpnDataForm.setLayout(null);
		
		componentesDataForm();
		acionarBotaoCancelar();
		acionarBotaoOK();
	}

	public GenericSearchDataForm(PreencherDados dados) {
		this.preencheDados = dados;
		inicializarForm();
	}
}