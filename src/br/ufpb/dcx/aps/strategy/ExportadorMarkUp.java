package br.ufpb.dcx.aps.strategy;

import java.util.List;

public class ExportadorMarkUp implements Exportador {

	private String inicioDoc;
	private String fimDoc;
	private String inicioParag;
	private String fimParag;

	public String getInicioDoc() {
		return inicioDoc;
	}

	public void setInicioDoc(String inicioDoc) {
		this.inicioDoc = inicioDoc;
	}

	public String getFimDoc() {
		return fimDoc;
	}

	public void setFimDoc(String fimDoc) {
		this.fimDoc = fimDoc;
	}

	public String getInicioParag() {
		return inicioParag;
	}

	public void setInicioParag(String inicioParag) {
		this.inicioParag = inicioParag;
	}

	public String getFimParag() {
		return fimParag;
	}

	public void setFimParag(String fimParag) {
		this.fimParag = fimParag;
	}

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
