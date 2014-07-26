package br.ufpb.dcx.aps.singleton;

import org.junit.Test;

public class ConexaoBancoDadosTest {

	@Test
	public void testeProducaoOracle() throws Exception {
		ConexaoBancoDados.carregarDados("bd_oracle.properties");
		ConexaoBancoDados.abrirConexao();
	}

}
