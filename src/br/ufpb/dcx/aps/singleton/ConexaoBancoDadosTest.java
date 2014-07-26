package br.ufpb.dcx.aps.singleton;

import org.junit.Test;

public class ConexaoBancoDadosTest {

	@Test
	public void testeProducaoOracle() throws Exception {
		ConexaoBancoDados.getInstance().carregarDados("bd_oracle.properties");
		ConexaoBancoDados.getInstance().abrirConexao();
	}

}
