package br.ufpb.dcx.aps.singleton;

import org.junit.Test;

public class ConexaoBancoDadosTest {

	@Test
	public void testeProducaoOracle() throws Exception {
		ConexaoBancoDados.DRIVER = "oracle.jdbc.driver.OracleDriver";
		ConexaoBancoDados.URL_PREFIX = "jdbc:oracle:thin:@//";
		ConexaoBancoDados.ADDRESS = "10.0.0.1:1521";
		ConexaoBancoDados.SCHEMA = "/teste";
		ConexaoBancoDados.USER = "user1";
		ConexaoBancoDados.PASSWORD = "pass";
		
		ConexaoBancoDados.abrirConexao();
	}

}
