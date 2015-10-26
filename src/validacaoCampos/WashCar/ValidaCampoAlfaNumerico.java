package validacaoCampos.WashCar;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class ValidaCampoAlfaNumerico extends PlainDocument {
	
	/*
	 * Objetivo dessa classe é para validar campos que irão receber somente letras
	 */

	private static final long serialVersionUID = 1L;

	public void insertString(int offset, String string, javax.swing.text.AttributeSet setAtributo) throws BadLocationException {
			super.insertString(offset, string.toUpperCase().replaceAll("[^a-z|^A-Z|^/|^&|^0-9|^~|^^|^´|^`|^ ]", ""), setAtributo);
	}
	
	public void replace(int offset, String string, javax.swing.text.AttributeSet setAtributo) 	throws BadLocationException {
			super.insertString(offset, string.toUpperCase().replaceAll("[^a-z|^A-Z|^/|^&|^0-9|^~|^^|^´|^`|^ ]", ""), setAtributo);
	}
}