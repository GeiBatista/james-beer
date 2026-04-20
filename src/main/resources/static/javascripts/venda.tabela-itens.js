JamesBeer.TabelaItens = (function() {
	
	function TabelaItens(autocomplete) {
		this.autocomplete = autocomplete;
		this.tabelaCervejasContainer = $('.js-tabela-cervejas-container');
	}
	
	TabelaItens.prototype.iniciar = function() {
		this.autocomplete.on('item-selecionado', onItemSelecionado.bind(this));
	}
	
	function onItemSelecionado(evento, item) {
		var resposta = $.ajax({
			url: 'item',
			method: 'POST',
			data: {
				codigoCerveja: item.codigo
			}
		});
		
		resposta.done(onItemAdicionadoNoServidor.bind(this));
		
	}
	
	function onItemAdicionadoNoServidor(html) {
			this.tabelaCervejasContainer.html(html);
		}
	
	return TabelaItens;
	
}());

$(function() {
	
	var autocomplete = new JamesBeer.Autocomplete();
	autocomplete.iniciar();
	
	var tabelaItens = new JamesBeer.TabelaItens(autocomplete);
	tabelaItens.iniciar();
	
});