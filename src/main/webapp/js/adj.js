$("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
});
$('#datum .input-group.date').datepicker({
    format: "dd/mm/yyyy",
    weekStart: 1,
    maxViewMode: 2,
    language: "nl",
    multidate: false,
    daysOfWeekDisabled: "0",
    autoclose: true,
    todayHighlight: true
});
$('.clockpicker').clockpicker({
  align: 'left',
  donetext: 'Klaar'
});
