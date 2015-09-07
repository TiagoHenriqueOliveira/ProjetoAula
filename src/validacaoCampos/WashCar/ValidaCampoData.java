package validacaoCampos.WashCar;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class ValidaCampoData extends PlainDocument{
	
	private static final long serialVersionUID = 1L;

	/*
	 * Objetivo dessa classe é para validar campos que irão receber informação de datas
	 */
	
	public void insertString(int offset, String string,
			javax.swing.text.AttributeSet setAtributo)
			throws BadLocationException {
			super.insertString(offset, string.toUpperCase().replaceAll("[^0-9|^/]", ""), setAtributo);
	}
	
	public void replace(int offset, String string,
			javax.swing.text.AttributeSet setAtributo)
			throws BadLocationException {
			super.insertString(offset, string.toUpperCase().replaceAll("[^0-9|^/]", ""), setAtributo);
	}
}