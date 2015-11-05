package exception.WashCar;

public class RegistroExistente extends Exception {

	private static final long serialVersionUID = 1L;
	
	public RegistroExistente(String message) {
		super(message);
	}
	
	public String usuarioExistente() {
		String mensagem = "";
		if(getMessage() != null) {
			if(getMessage().contains("Duplicate entry")) {
				mensagem = "Já existe um usuário cadastrado com o login escolhido.\n"
						+ "Por gentileza escolha um login válido.";
			}
		}
		return mensagem;
	}
}