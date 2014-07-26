package br.ufpb.dcx.aps.singleton;

import org.junit.After;
import org.junit.Test;

public class ConexaoBancoDadosTest {

	@After
	public void zerarSingleton() {
		ConexaoBancoDados.getInstance().reset();
	}
	
	@Test
	public void testeProducaoOracle() throws Exception {
		ConexaoBancoDados.getInstance().carregarDados("bd_oracle.properties");
		ConexaoBancoDados.getInstance().abrirConexao();
	}

	@Test
	public void testeDesenvolvimentoHsqldb() throws Exception {
		ConexaoBancoDadosHsqldb.getInstance().carregarDados("bd_local.properties");
		ConexaoBancoDados.getInstance().abrirConexao();
	}
}
