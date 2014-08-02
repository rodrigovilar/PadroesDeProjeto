package br.ufpb.dcx.aps.stratey;

import java.util.List;

public class ExportadorTXT implements Exportador {

	@Override
	public String exportar(List<String> paragrafos) {
		String result = "";
		for (String p : paragrafos) {
			result += p + "\n";
		}
		return result;
	}

}
