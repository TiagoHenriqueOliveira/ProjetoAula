package validacaoCampos.WashCar;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class ValidaCampoAlfaNumerico extends PlainDocument {
	
	/*
	 * Objetivo dessa classe � para validar campos que ir�o n�meros, letras e acentos.
	 */

	private static final long serialVersionUID = 1L;

	public void insertString(int offset, String string, javax.swing.text.AttributeSet setAtributo) throws BadLocationException {
			super.insertString(offset, string.toUpperCase(), setAtributo);
	}
	
	public void replace(int offset, String string, javax.swing.text.AttributeSet setAtributo) 	throws BadLocationException {
			super.insertString(offset, string.toUpperCase(), setAtributo);
	}
}