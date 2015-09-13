package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoUtil {

	private static Connection connection;
	
	static {
		String endereco = "jdbc:mysql://localhost:3306/washcar";
		String usuario = "root";
		String senha = "910822";
		try {
			connection = DriverManager.getConnection(endereco, usuario, senha);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados!!!\n"
																		+ "Verifique se o serviço do servidor está ativo!!!",
																		"Erro de Conexão", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static Connection getCon() {
		return connection;
	}
}
