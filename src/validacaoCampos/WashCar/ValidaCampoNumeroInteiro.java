package validacaoCampos.WashCar;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class ValidaCampoNumeroInteiro extends PlainDocument{
	
	private static final long serialVersionUID = 1L;

	/*
	 * Objetivo dessa classe � para validar campos que ir�o receber somente numeros inteiros
	 * sem nenhum tipo de espa�amento e caracter especial
	 */
	
	public void insertString(int offset, String string,
			javax.swing.text.AttributeSet setAtributo)
			throws BadLocationException {
			super.insertString(offset, string.toUpperCase().replaceAll("[^0-9]", ""), setAtributo);
	}
	
	public void replace(int offset, String string,
			javax.swing.text.AttributeSet setAtributo)
			throws BadLocationException {
			super.insertString(offset, string.toUpperCase().replaceAll("[^0-9]", ""), setAtributo);
	}
}