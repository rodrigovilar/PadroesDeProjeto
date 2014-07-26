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

	  private static String driver = "oracle.jdbc.driver.OracleDriver";
	  private static String urlPrefix = "jdbc:oracle:thin:@//";
	  private static String address = "10.0.0.1:1521";
	  private static String schema = "database1";
	  private static String user = "root";
	  private static String password = "123";

	public static String getDriver() {
		return driver;
	}

	public static String getURL() {
		return urlPrefix + address + schema;
	}

	public static String getUser() {
		return user;
	}

	public static String getPassword() {
		return password;
	}

	public static void carregarDados(String arquivo) {
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

		driver = prop.getProperty("driver", driver);
		urlPrefix = prop.getProperty("url.prefix", urlPrefix);
		address = prop.getProperty("address", address);
		schema = prop.getProperty("schema", schema);
		user = prop.getProperty("user", user);
		password = prop.getProperty("password", password);
	}

	public static Connection abrirConexao() throws Exception {
		Class.forName(getDriver());

		return DriverManager.getConnection(getURL(), getUser(), getPassword());
	}

}
