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
				mensagem = "J� existe um usu�rio cadastrado com o login escolhido.\n"
						+ "Por gentileza, escolha um login v�lido.";
			}
		}
		return mensagem;
	}
	
	public String marcaJaExiste() {
		String mensagem = "";
		if(getMessage() != null) {
			if(getMessage().contains("Duplicate entry")) {
				mensagem = "J� existe uma marca cadastrada com o nome informado.\n"
						+ "Por gentileza, informe um nome de marca v�lido.";
			}
		}
		return mensagem;
	}
	
	public String modeloJaExiste() {
		String mensagem = "";
		if(getMessage() != null) {
			if(getMessage().contains("Duplicate entry")) {
				mensagem = "J� existe um modelo cadastrado com o nome informado.\n"
						+ "Por gentileza, informe um nome de modelo v�lido.";
			}
		}
		return mensagem;
	}
	
	public String placaJaExiste() {
		String mensagem = "";
		if(getMessage() != null) {
			if(getMessage().contains("Duplicate entry")) {
				mensagem = "J� existe uma placa cadastrada.\n"
						+ "Por gentileza, informe uma placa v�lida.";
			}
		}
		return mensagem;
	}
	
	public String documentoJaExiste() {
		String mensagem = "";
		if(getMessage() != null) {
			if(getMessage().contains("cnpjEmpresa_UNIQUE")) {
				mensagem = "J� existe um cnpj cadastrado.\n"
						+ "Por gentileza, informe um cnpj v�lido.";
			} else if(getMessage().contains("inscricaoEstadualEmpresa_UNIQUE")) {
				mensagem = "J� existe uma Inscri��o Estadual cadastrada.\n"
						+ "Por gentileza, informe uma Inscri��o Estadual v�lida.";
			} else if(getMessage().contains("inscricaoMunicipalEmpresa_UNIQUE")) {
				mensagem = "J� existe uma Inscri��o Municipal cadastrada.\n"
						+ "Por gentileza, informe uma Inscri��o Municipal v�lida.";
			} else if(getMessage().contains("cpfCliente_UNIQUE")) {
				mensagem = "J� existe uma Inscri��o Municipal cadastrada.\n"
						+ "Por gentileza, informe uma Inscri��o Municipal v�lida.";
			} else if(getMessage().contains("rgCliente_UNIQUE")) {
				mensagem = "J� existe uma Inscri��o Municipal cadastrada.\n"
						+ "Por gentileza, informe uma Inscri��o Municipal v�lida.";
			}
		}
		return mensagem;
	}
}