$(document).ready(function() {
  $('.button-collapse').sideNav();
  $('.button-collapse2').sideNav();
  $('select').material_select();
  $('.datepicker').pickadate({
    selectMonths: true, // Creates a dropdown to control month
    selectYears: 100, // Creates a dropdown of 15 years to control year
    min: new Date(1920, 0, 1),
    max: new Date(),
    monthsFull: ['01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12'],
    monthsShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
    weekdaysFull: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sabádo'],
    weekdaysShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab'],
    today: 'Hoje',
    clear: 'Limpar',
    close: 'Pronto',
    labelMonthNext: 'Próximo mês',
    labelMonthPrev: 'Mês anterior',
    labelMonthSelect: 'Selecione um mês',
    labelYearSelect: 'Selecione um ano',
    format: 'dd/mm/yyyy'
  });
  $('.datepicker2').pickadate({
	    selectMonths: true, // Creates a dropdown to control month
	    selectYears: 100, // Creates a dropdown of 15 years to control year
	    min: new Date(),
	    max: new Date(2020, 0, 1),
	    monthsFull: ['01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12'],
	    monthsShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
	    weekdaysFull: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sabádo'],
	    weekdaysShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab'],
	    today: 'Hoje',
	    clear: 'Limpar',
	    close: 'Pronto',
	    labelMonthNext: 'Próximo mês',
	    labelMonthPrev: 'Mês anterior',
	    labelMonthSelect: 'Selecione um mês',
	    labelYearSelect: 'Selecione um ano',
	    format: 'dd/mm/yyyy'
	  });
  $('.timepicker').pickatime({
	  default: 'now', // Set default time: 'now', '1:30AM', '16:30'
	  fromnow: 0,       // set default time to * milliseconds from now (using with default = 'now')
	  twelvehour: false, // Use AM/PM or 24-hour format
	  donetext: 'OK', // text for done-button
	  cleartext: 'Clear', // text for clear-button
	  canceltext: 'Cancel', // Text for cancel-button
	  autoclose: false, // automatic close timepicker
	  ampmclickable: true, // make AM PM clickable
	  aftershow: function(){} //Function for after opening timepicker
  });
  $('.parallax').parallax();
  $('.modal').modal();
});
