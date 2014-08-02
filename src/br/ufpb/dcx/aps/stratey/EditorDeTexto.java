package br.ufpb.dcx.aps.stratey;

import java.util.ArrayList;
import java.util.List;

public class EditorDeTexto {

	List<String> paragrafos = new ArrayList<>();

	public void digitar(String texto) {
		String[] parag = texto.split("\n");

		for (String p : parag) {
			paragrafos.add(p);
		}
	}

	public String exportar(Formato formato) {

		String result = "";

		switch (formato) {

		case TXT:
			for (String p : paragrafos) {
				result += p + "\n";
			}
			return result;

		case HTML:
			result += "<html><body>";
			
			for (String p : paragrafos) {
				result += "<p>" + p + "</p>";
			}
			result += "</body></html>";
			return result;
		}
		
		return null;
	}

}
