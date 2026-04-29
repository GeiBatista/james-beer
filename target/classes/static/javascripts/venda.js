JamesBeer.Venda = (function() {
	
	function Venda(tabelaItens) {
		this.tabelaItens = tabelaItens;
		this.valorTotalBox = $('.js-valor-total-box');
		this.valorFreteInput = $('#valorFrete');
		this.valorDescontoInput = $('#valorDesconto');
		
		this.valorTotalItens = 0;
		this.valorFrete = 0;
		this.valorDesconto = 0;
	}
	
	Venda.prototype.iniciar = function() {
		this.tabelaItens.on('tabela-itens-atualizada', onTabelaItensAtualizada.bind(this));
		this.valorFreteInput.on('keyup', onValorFreteAlterado.bind(this));
		this.valorDescontoInput.on('keyup', onValorDescontoAlterado.bind(this));
		
		this.tabelaItens.on('tabela-itens-atualizada', onValoresAlterados.bind(this));
		this.valorFreteInput.on('keyup', onValoresAlterados.bind(this));
		this.valorDescontoInput.on('keyup', onValoresAlterados.bind(this));
	}
	
	function onTabelaItensAtualizada(evento, valorTotalItens) {
		console.log('Valor total dos itens atualizado: ' + valorTotalItens);
		this.valorTotalItens = valorTotalItens == null ? 0 : Number(valorTotalItens);
	}
	
	function onValorFreteAlterado(evento) {
		this.valorFrete = Number(JamesBeer.recuperarValor($(evento.target).val())) || 0;
	}

	function onValorDescontoAlterado(evento) {
		this.valorDesconto = Number(JamesBeer.recuperarValor($(evento.target).val())) || 0;
	}
	
	/*function onValorFreteAlterado(evento) {
		this.valorFrete = JamesBeer.recuperarValor($(evento.target).val());
	}
	
	function onValorDescontoAlterado(evento) {
		this.valorDesconto = JamesBeer.recuperarValor($(evento.target).val());
	}*/
	
	function onValoresAlterados() {
		var valorTotal = this.valorTotalItens + this.valorFrete - this.valorDesconto;
		this.valorTotalBox.html(JamesBeer.formatarMoeda(valorTotal));
		
	}
	
	return Venda;
	
}());

$(function() {
	
	var autocomplete = new JamesBeer.Autocomplete();
	autocomplete.iniciar();
	
	var tabelaItens = new JamesBeer.TabelaItens(autocomplete);
	tabelaItens.iniciar();
	
	var venda = new JamesBeer.Venda(tabelaItens);
	venda.iniciar();
	
});