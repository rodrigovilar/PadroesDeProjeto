package br.ufpb.dcx.aps.singleton;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
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

	public void carregarDados(String arquivo) {
		Properties prop = new Properties();

		try {
			File file = new File(arquivo);

			if (!file.exists()) {
				throw new RuntimeException("Nao pode achar arquivo: " + arquivo);
			}

			prop.load(new BufferedInputStream(new FileInputStream(file)));

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}

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
