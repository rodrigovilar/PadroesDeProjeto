package br.ufpb.dcx.aps.singleton;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Código baseado em:
 * 
 * http://www.dsc.ufcg.edu.br/~jacques/cursos/map/html/pat/singleton.htm
 */
public class ConexaoBancoDados {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String urlPrefix = "jdbc:oracle:thin:@//";
	private String address = "10.0.0.1:1521";
	private String schema = "database1";
	private String user = "root";
	private String password = "123";

	protected static ConexaoBancoDados instance = null;

	protected ConexaoBancoDados() {
	}

	public static ConexaoBancoDados getInstance() {
		if (instance == null) {
			// "lazy instantiation"
			instance = new ConexaoBancoDados();
		}

		return instance;
	}

	public void reset() {
		instance = null;
	}

	public String getDriver() {
		return driver;
	}

	public String getURL() {
		return urlPrefix + address + schema;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUrlPrefix(String urlPrefix) {
		this.urlPrefix = urlPrefix;
	}

	public String getUrlPrefix() {
		return urlPrefix;
	}

	public void carregarDados(String arquivo) {
		Properties prop = carregarPropriedades(arquivo);

		driver = prop.getProperty("driver", driver);
		urlPrefix = prop.getProperty("url.prefix", urlPrefix);
		address = prop.getProperty("address", address);
		schema = prop.getProperty("schema", schema);
		user = prop.getProperty("user", user);
		password = prop.getProperty("password", password);
	}

	protected Properties carregarPropriedades(String arquivo) {
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
		return prop;
	}

	public Connection abrirConexao() throws Exception {
		Class.forName(getDriver());

		return DriverManager.getConnection(getURL(), getUser(), getPassword());
	}

}
