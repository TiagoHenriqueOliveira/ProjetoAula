package exception.WashCar;

public class RegistroNotExistente extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public RegistroNotExistente(String message) {
		super(message);
	}
}