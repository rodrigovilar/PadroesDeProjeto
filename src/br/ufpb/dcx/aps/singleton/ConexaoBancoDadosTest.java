package br.ufpb.dcx.aps.singleton;

import org.junit.Test;

public class ConexaoBancoDadosTest {

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
