package com.mrbatista.jamesbeer.venda;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.mrbatista.jamesbeer.model.Cerveja;
import com.mrbatista.jamesbeer.session.TabelaItensVenda;

public class TabelaItensVendaTest {
	
	private TabelaItensVenda tabelaItensVenda;

	@Before
	public void setUp() {
		tabelaItensVenda = new TabelaItensVenda();
	}
	
	@Test
	public void deveCalcularValorTotalSemItens() throws Exception {
	 assertEquals(BigDecimal.ZERO, tabelaItensVenda.getValorTotal());
	}
	
	@Test
	public void deveCalcularValorComUmItem() throws Exception{
		Cerveja cerveja = new Cerveja();
		BigDecimal valor = new BigDecimal("10.00");
		cerveja.setValor(valor);
		
		tabelaItensVenda.adicionarItem(cerveja, 1);
		
		assertEquals(valor, tabelaItensVenda.getValorTotal());
	}
	
	@Test
	public void deveCalcularValorComVariosItens() throws Exception {
		Cerveja cerveja1 = new Cerveja();
		cerveja1.setValor(new BigDecimal("10.00"));
		
		Cerveja cerveja2 = new Cerveja();
		cerveja2.setValor(new BigDecimal("5.00"));
		
		tabelaItensVenda.adicionarItem(cerveja1, 2); // 20.00
		tabelaItensVenda.adicionarItem(cerveja2, 3); // 15.00
		
		assertEquals(new BigDecimal("35.00"), tabelaItensVenda.getValorTotal());
	}
}
