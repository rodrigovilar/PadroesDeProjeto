package br.ufpb.dcx.aps.strategy;


public class ExportadorXML extends ExportadorMarkUp {

	@Override
	public String getInicioDoc() {
		return "<doc>";
	}

	@Override
	public String getFimDoc() {
		return "</doc>";
	}

	@Override
	public String getInicioParag() {
		return "<parag>";
	}

	@Override
	public String getFimParag() {
		return "</parag>";
	}

}