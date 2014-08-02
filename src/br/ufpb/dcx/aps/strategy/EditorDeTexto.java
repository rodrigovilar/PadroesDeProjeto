package br.ufpb.dcx.aps.strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditorDeTexto {

	List<String> paragrafos = new ArrayList<>();
	
	private Map<Formato, Exportador> exportadores = new HashMap<>();
	
	
	public EditorDeTexto() {
		addExportador(Formato.TXT, new ExportadorTXT());
		
		ExportadorMarkUp exportadorHTML = new ExportadorMarkUp();
		exportadorHTML.setInicioDoc("<html><body>");
		exportadorHTML.setFimDoc("</body></html>");
		exportadorHTML.setInicioParag("<p>");
		exportadorHTML.setFimParag("</p>");
		addExportador(Formato.HTML, exportadorHTML);

		ExportadorMarkUp exportadorXML = new ExportadorMarkUp();
		exportadorXML.setInicioDoc("<doc>");
		exportadorXML.setFimDoc("</doc>");
		exportadorXML.setInicioParag("<parag>");
		exportadorXML.setFimParag("</parag>");
		addExportador(Formato.XML, exportadorXML);

		ExportadorMarkUp exportadorXML2 = new ExportadorMarkUp();
		exportadorXML2.setInicioDoc("<raiz>");
		exportadorXML2.setFimDoc("</raiz>");
		exportadorXML2.setInicioParag("<linha>");
		exportadorXML2.setFimParag("</linha>");
		addExportador(Formato.XML2, exportadorXML2);
	}
	
	
	public void addExportador(Formato formato, Exportador exportador) {
		this.exportadores.put(formato, exportador);
	}

	public void digitar(String texto) {
		String[] parag = texto.split("\n");

		for (String p : parag) {
			paragrafos.add(p);
		}
	}

	public String exportar(Formato formato) {
		Exportador exportador = exportadores.get(formato);
		return exportador.exportar(paragrafos);
	}

}
