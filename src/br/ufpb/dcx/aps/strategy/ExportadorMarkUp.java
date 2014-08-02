package br.ufpb.dcx.aps.strategy;

import java.util.List;

public abstract class ExportadorMarkUp implements Exportador {
	
	public abstract String getInicioDoc();

	public abstract String getFimDoc();

	public abstract String getInicioParag();

	public abstract String getFimParag();
	
	@Override
	public String exportar(List<String> paragrafos) {
		String result = getInicioDoc();

		for (String p : paragrafos) {
			result += getInicioParag() + p + getFimParag();
		}
		result += getFimDoc();
		return result;
	}

}
