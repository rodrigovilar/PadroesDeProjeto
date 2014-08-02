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
		assertEquals("abc\ndef\n", editor.exportar(Formato.TXT));
	}

	@Test
	public void exportarParaHtml() {
		assertEquals("<html><body><p>abc</p><p>def</p></body></html>",
				editor.exportar(Formato.HTML));
	}
	
	@Test
	public void exportarParaXml() {
		assertEquals("<doc><parag>abc</parag><parag>def</parag></doc>",
				editor.exportar(Formato.XML));
	}
	
	@Test
	public void exportarParaXml2() {
		assertEquals("<raiz><linha>abc</linha><linha>def</linha></raiz>",
				editor.exportar(Formato.XML2));
	}

}
