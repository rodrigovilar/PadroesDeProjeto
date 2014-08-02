package br.ufpb.dcx.aps.stratey;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class EditorDeTextoTest {

	private EditorDeTexto editor;

	@Before
	public void AbreEditorEscreveTexto() {
		editor = new EditorDeTexto();
		editor.digitar("abc\ndef");
	}

	@Test
	public void exportarParaTxt() {
		assertEquals("abc\ndef\n", editor.exportar(new ExportadorTXT()));
	}

	@Test
	public void exportarParaHtml() {
		assertEquals("<html><body><p>abc</p><p>def</p></body></html>",
				editor.exportar(new ExportadorHTML()));
	}
}
