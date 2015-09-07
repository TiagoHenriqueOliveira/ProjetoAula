package validacaoCampos.WashCar;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class ValidaCampoValor extends PlainDocument{
	
	private static final long serialVersionUID = 1L;

	/*
	 * Objetivo dessa classe � para validar campos que ir�o receber valores
	 * do tipo: real, dolar e outros
	 */
	
	public void insertString(int offset, String string,
			javax.swing.text.AttributeSet setAtributo)
			throws BadLocationException {
			super.insertString(offset, string.toUpperCase().replaceAll("[^0-9|^,|^.]", ""), setAtributo);
	}
	
	public void replace(int offset, String string,
			javax.swing.text.AttributeSet setAtributo)
			throws BadLocationException {
			super.insertString(offset, string.toUpperCase().replaceAll("[^0-9|^,|^.]", ""), setAtributo);
	}
}