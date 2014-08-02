package br.ufpb.dcx.aps.stratey;

import static org.junit.Assert.*;

import org.junit.Test;

public class EditorDeTextoTest {

	@Test
	public void exportarParaTxt() {
		EditorDeTexto editor = new EditorDeTexto();
		editor.digitar("abc\ndef");
		assertEquals("abc\ndef\n", editor.exportar());
	}

}
