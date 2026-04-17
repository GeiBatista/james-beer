package com.mrbatista.jamesbeer.venda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.mrbatista.jamesbeer.model.ItemVenda;

public class TabelaItensVenda {
	
private List<ItemVenda> itens = new ArrayList<>();
	
	public BigDecimal getValorTotal() {
		return itens.stream()
				.map(ItemVenda::getValorTotal)
				.reduce(BigDecimal::add)
				.orElse(BigDecimal.ZERO);
	}

}
