JamesBeer = JamesBeer || {};

JamesBeer.MultiSelecao = (function() {

    function MultiSelecao() {
        this.statusBtn = $('.js-status-btn');
        this.selecaoCheckbox = $('.js-selecao');
		this.selecaoTodosCheckbox = $('.js-selecao-todos');
    }

    MultiSelecao.prototype.iniciar = function() {
        this.statusBtn.on('click', onStatusBtnClicado.bind(this));
		this.selecaoTodosCheckbox.on('click', onSelecaoTodosClicado.bind(this));
		this.selecaoCheckbox.on('click', onSelecaoClicado.bind(this));
    }

    function onStatusBtnClicado(event) {
        var botaoClicado = $(event.currentTarget);
        var status = botaoClicado.data('status');
		var url = botaoClicado.data('url');

        var checkBoxSelecionados = this.selecaoCheckbox.filter(':checked').filter(':not(:disabled)');
        var codigos = $.map(checkBoxSelecionados, function(c) {
            return $(c).data('codigo');
        });

        if (codigos.length > 0) {
            $.ajax({
                url: url,
                method: 'POST',
                data: {
                    codigos: codigos,
                    status: status
                },
                success: function() {
                    window.location.reload();
                }
            });

        }
    }

	function onSelecaoTodosClicado() {
			var status = this.selecaoTodosCheckbox.prop('checked');
			
			this.selecaoCheckbox
				.filter(':not(:disabled)')
			    .prop('checked', status);
			
			statusBotaoAcao.call(this, status);
		}
		
		function onSelecaoClicado() {
			var habilitados = this.selecaoCheckbox.filter(':not(:disabled)');
			var checados = habilitados.filter(':checked');
			
			this.selecaoTodosCheckbox.prop('checked', checados.length === habilitados.length);

			statusBotaoAcao.call(this, checados.length);
		}
		
		function statusBotaoAcao(ativar) {
			ativar ? this.statusBtn.removeClass('disabled') : this.statusBtn.addClass('disabled');
		}
		
	
    return MultiSelecao;

}());



$(function() {
    var multiSelecao = new JamesBeer.MultiSelecao();
    multiSelecao.iniciar();
});