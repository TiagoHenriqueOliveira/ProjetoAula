package exception.WashCar;

public class RegistroNotExistente extends NullPointerException {

	private static final long serialVersionUID = 1L;
	
	public RegistroNotExistente(String message) {
		super(message);
	}
	
	public String usuarioNotExistente() {
		String mensagem = "";
		if(getMessage() != null) {
			if(getMessage().contains("Exception in thread")) {
				mensagem = "Nenhum usuário foi localizado.\n"
						+ "Por gentileza, efetue uma nova pesquisa.";
			}
		}
		return mensagem;
	}
}