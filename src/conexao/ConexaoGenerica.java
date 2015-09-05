package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoGenerica {

	private static Connection connection;
	
	static {
		String endereco = "jdbc:mysql://localhost:3306/washcar";
		String usuario = "root";
		String senha = "910822";
		try {
			connection = DriverManager.getConnection(endereco, usuario, senha);
		} catch (SQLException e) {
			System.out.println("Erro ao conectar no banco de dados"+e.getMessage());
		}
	}
	
	public static Connection getConexao() {
		return connection;
	}
}
