package br.ufpb.dcx.aps.strategy;

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
	
	@Test
	public void exportarParaXml() {
		assertEquals("<doc><parag>abc</parag><parag>def</parag></doc>",
				editor.exportar(new ExportadorXML()));
	}
}
