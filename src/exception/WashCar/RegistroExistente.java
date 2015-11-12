package exception.WashCar;

public class RegistroExistente extends Exception {

	private static final long serialVersionUID = 1L;
	
	public RegistroExistente(String message) {
		super(message);
	}
	
	public String usuarioJaExiste() {
		String mensagem = "";
		if(getMessage() != null) {
			if(getMessage().contains("Duplicate entry")) {
				mensagem = "Já existe um usuário cadastrado com o login escolhido.\n"
						+ "Por gentileza, escolha um login válido.";
			}
		}
		return mensagem;
	}
	
	public String marcaJaExiste() {
		String mensagem = "";
		if(getMessage() != null) {
			if(getMessage().contains("Duplicate entry")) {
				mensagem = "Já existe uma marca cadastrada com o nome informado.\n"
						+ "Por gentileza, informe um nome de marca válido.";
			}
		}
		return mensagem;
	}
	
	public String modeloJaExiste() {
		String mensagem = "";
		if(getMessage() != null) {
			if(getMessage().contains("Duplicate entry")) {
				mensagem = "Já existe um modelo cadastrado com o nome informado.\n"
						+ "Por gentileza, informe um nome de modelo válido.";
			}
		}
		return mensagem;
	}
	
	public String placaJaExiste() {
		String mensagem = "";
		if(getMessage() != null) {
			if(getMessage().contains("Duplicate entry")) {
				mensagem = "Já existe uma placa cadastrada.\n"
						+ "Por gentileza, informe uma placa válida.";
			}
		}
		return mensagem;
	}
	
	public String documentoJaExiste() {
		String mensagem = "";
		if(getMessage() != null) {
			if(getMessage().contains("cnpjEmpresa_UNIQUE")) {
				mensagem = "Já existe um cnpj cadastrado.\n"
						+ "Por gentileza, informe um cnpj válido.";
			} else if(getMessage().contains("inscricaoEstadualEmpresa_UNIQUE")) {
				mensagem = "Já existe uma Inscrição Estadual cadastrada.\n"
						+ "Por gentileza, informe uma Inscrição Estadual válida.";
			} else if(getMessage().contains("inscricaoMunicipalEmpresa_UNIQUE")) {
				mensagem = "Já existe uma Inscrição Municipal cadastrada.\n"
						+ "Por gentileza, informe uma Inscrição Municipal válida.";
			} else if(getMessage().contains("cpfCliente_UNIQUE")) {
				mensagem = "Já existe uma Inscrição Municipal cadastrada.\n"
						+ "Por gentileza, informe uma Inscrição Municipal válida.";
			} else if(getMessage().contains("rgCliente_UNIQUE")) {
				mensagem = "Já existe uma Inscrição Municipal cadastrada.\n"
						+ "Por gentileza, informe uma Inscrição Municipal válida.";
			}
		}
		return mensagem;
	}
}