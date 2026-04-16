var JamesBeer = JamesBeer || {};

JamesBeer.MaskMoney = (function() {

    function MaskMoney() {
        this.decimal = $('.js-decimal');
        this.plain = $('.js-plain');

    }

    MaskMoney.prototype.enable = function() {
        this.decimal.maskMoney({ decimal: ',', thousands: '.' });
        this.plain.maskMoney({ precision: 0, thousands: '.' });
    }
    return MaskMoney;

})();

JamesBeer.MaskPhoneNumber = (function () {
	
	function MaskPhoneNumber() {
		this.inputPhoneNumber = $('.js-phone-number');
	}
	
	MaskPhoneNumber.prototype.enable = function () {
		var maskBehavior = function (val) {
		  return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
		};
		
		 var options = {
		  onKeyPress: function(val, e, field, options) {
		      field.mask(maskBehavior.apply({}, arguments), options);
		    }
		};
		
		this.inputPhoneNumber.mask(maskBehavior, options);
		}
		
		return MaskPhoneNumber;
}());

JamesBeer.MaskCep = (function() {

    function MaskCep() {
		this.inputCep = $('.js-cep');
    }

    MaskCep.prototype.enable = function() {
		var options =  {
		  onKeyPress: function(cep, event, currentField, options){
		    console.log('Tecla pressionada:', cep, ' evento: ', event,
		                'campoAtual: ', currentField, ' opções: ', options);
		  },
		  onChange: function(cep){
		    console.log('CEP alterado:', cep);
		  },
		  onInvalid: function(val, e, f, invalid, options){
		    var error = invalid[0];
		    console.log ("Dígito: ", error.v, " é inválido para a posição: ", error.p, ". Esperávamos algo como: ", error.e);
		  }
		};
		
		this.inputCep.mask('00000-000', options);
    }

    return MaskCep;

}());

JamesBeer.MaskDate = (function() {
	
	function MaskDate() {
		this.inputDate = $('.js-date');
	}
	
	MaskDate.prototype.enable = function() {
		this.inputDate.mask('00/00/0000');
		this.inputDate.datepicker({
			orientation: 'bottom',
			language: 'pt-BR',
			autoclose: true
		});
	}
	
	return MaskDate;
	
}());

JamesBeer.Security = (function() {
	
	function Security() {
		this.token = $('input[name=_csrf]').val();
		this.header = $('input[name=_csrf_header]').val();
	}
	
	Security.prototype.enable = function() {
		$(document).ajaxSend(function(event, jqxhr, settings) {
			jqxhr.setRequestHeader(this.header, this.token);
		}.bind(this));
	}
	
	return Security;
	
}());

JamesBeer.formatarMoeda = function(valor) {
	numeral.language('pt-br');
	return numeral(valor).format('0,0.00');
}

$(function() {
    var maskMoney = new JamesBeer.MaskMoney();
    maskMoney.enable();
	
	var maskPhoneNumber = new JamesBeer.MaskPhoneNumber();
	maskPhoneNumber.enable();
	
	var maskCep = new JamesBeer.MaskCep();
	maskCep.enable();
	
	var maskDate = new JamesBeer.MaskDate();
	maskDate.enable();
	
	var security = new JamesBeer.Security();
	security.enable();
});