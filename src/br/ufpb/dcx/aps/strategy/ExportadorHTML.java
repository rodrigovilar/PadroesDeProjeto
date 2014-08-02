package br.ufpb.dcx.aps.strategy;


public class ExportadorHTML extends ExportadorMarkUp {

	@Override
	public String getInicioDoc() {
		return "<html><body>";
	}

	@Override
	public String getFimDoc() {
		return "</body></html>";
	}

	@Override
	public String getInicioParag() {
		return "<p>";
	}

	@Override
	public String getFimParag() {
		return "</p>";
	}

}
