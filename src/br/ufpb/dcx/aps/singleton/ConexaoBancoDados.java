package br.ufpb.dcx.aps.singleton;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Código baseado em:
 * 
 * http://www.dsc.ufcg.edu.br/~jacques/cursos/map/html/pat/singleton.htm
 */
public class ConexaoBancoDados {

	public static String DRIVER;
	public static String URL_PREFIX;
	public static String ADDRESS;
	public static String SCHEMA;
	public static String USER;
	public static String PASSWORD;

	public static Connection abrirConexao() throws Exception {
		Class.forName(DRIVER);

		return DriverManager.getConnection(URL_PREFIX + ADDRESS + SCHEMA, USER,
				PASSWORD);
	}

}
