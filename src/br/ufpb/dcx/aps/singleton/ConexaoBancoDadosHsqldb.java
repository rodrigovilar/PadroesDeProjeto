package br.ufpb.dcx.aps.singleton;

import java.util.Properties;

public class ConexaoBancoDadosHsqldb extends ConexaoBancoDados {

	public static ConexaoBancoDados getInstance() {
		if (instance == null) {
			instance = new ConexaoBancoDadosHsqldb();
		}

		return instance;
	}

	private String directory;

	private ConexaoBancoDadosHsqldb() {
		// Default values
		setDriver("org.hsqldb.jdbc.JDBCDriver");
		setUrlPrefix("jdbc:hsqldb:");
		setDirectory("db1");
	}

	@Override
	public void carregarDados(String arquivo) {
		Properties prop = carregarPropriedades(arquivo);

		setDriver(prop.getProperty("driver", getDriver()));
		setUrlPrefix(prop.getProperty("url.prefix", getUrlPrefix()));
		setDirectory(prop.getProperty("directory", getDirectory()));
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	@Override
	public String getURL() {
		return getUrlPrefix() + getDirectory();
	}
}
