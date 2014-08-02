package br.ufpb.dcx.aps.stratey;

import java.util.List;

public class ExportadorHTML implements Exportador {

	@Override
	public String exportar(List<String> paragrafos) {
		String result = "<html><body>";
		
		for (String p : paragrafos) {
			result += "<p>" + p + "</p>";
		}
		result += "</body></html>";
		return result;
	}

}
