document.addEventListener("DOMContentLoaded", function(event) { 
	function changeDates(MAdate, DIdate, WOdate, DOdate, VRdate, ZAdate, weeknummer) {
			$("#MAdate").html(MAdate);
			$("#DIdate").html(DIdate);
			$("#WOdate").html(WOdate);
			$("#DOdate").html(DOdate);
			$("#VRdate").html(VRdate);
			$("#ZAdate").html(ZAdate);
			$("#weeknummer").html(weeknummer);
		}
	function emptyContent() {
		$("#MAcontent").html("");
		$("#DIcontent").html("");
		$("#WOcontent").html("");
		$("#DOcontent").html("");
		$("#VRcontent").html("");
		$("#ZAcontent").html("");
	}
	function addBlockOpen(content, id, begintijd, eindtijd, locatie) {
		$(content).append("<div class=\"informatieblok\"><div class=\"i-tijd\">" +
				"<div class=\"checkbox informatieblok-checkbox checkbox-primary\">" +
				"<input type=\"checkbox\" id=\"" + id + "\">" +
				"<label for=\"" + id + "\">" + begintijd +" - "+ eindtijd + "</label></div></div>" +
				"<div class=\"i-locatie\">(" + locatie + ")</div>" +
				"<div class=\"i-student\">OPEN</div></div>");
	}
	function addBlockAfspraak(content, id, begintijd, eindtijd, locatie, studentnaam) {
		$(content).append("<div id=\"" + id + "\" class=\"informatieblok\">" +
				"<div class=\"i-tijd\"><span class=\"label background-blue-main\">" + begintijd + " - " + eindtijd + "</span></div>" +
				"<div class=\"i-locatie\">" + locatie + "</div>" +
				"<div class=\"i-student\">" + studentnaam + "</div></div>");
	}
	
	
	$.getJSON("SlbRoosterServlet.do?type=init", function(data){
		emptyContent();
		var list_datums = [];
		$.each(data, function(i, dates) {
			if (i != 6) {
				list_datums.push(String(dates.datum));
			} else {
				list_datums.push(String(dates.week));
			}
			if (i != 6) {
				$.each(dates.blok, function(y, blokken) {
					var list_blok = [];
					
					if (i == 0) {list_blok.push("#MAcontent");} 
					else if (i == 1) {list_blok.push("#DIcontent");}
					else if (i == 2) {list_blok.push("#WOcontent");}
					else if (i == 3) {list_blok.push("#DOcontent");}
					else if (i == 4) {list_blok.push("#VRcontent");}
					else if (i == 5) {list_blok.push("#ZAcontent");}
					list_blok.push(String(blokken.idAfspraak));
					list_blok.push(String(blokken.begintijd));
					list_blok.push(String(blokken.eindtijd));
					list_blok.push(String(blokken.locatie));
					
					if (blokken.studentnaam == null) {
						addBlockOpen(list_blok[0],list_blok[1],list_blok[2],list_blok[3],list_blok[4]);
					} else {
						list_blok.push(String(blokken.studentnaam));
						addBlockAfspraak(list_blok[0],list_blok[1],list_blok[2],list_blok[3],list_blok[4],list_blok[5]);
					}
		
				});
			}	
		});
		changeDates(list_datums[0], list_datums[1], list_datums[2], list_datums[3], list_datums[4], list_datums[5], list_datums[6]);
    });
	function getWeek(web_week) {
		$.getJSON("SlbRoosterServlet.do?type=anders&web_week=" + web_week, function(data){
			emptyContent();
			var list_datums = [];
			$.each(data, function(i, dates) {
				if (i != 6) {
					list_datums.push(String(dates.datum));
				} else {
					list_datums.push(String(dates.week));
				}
				if (i != 6) {
					$.each(dates.blok, function(y, blokken) {
						var list_blok = [];
						
						if (i == 0) {list_blok.push("#MAcontent");} 
						else if (i == 1) {list_blok.push("#DIcontent");}
						else if (i == 2) {list_blok.push("#WOcontent");}
						else if (i == 3) {list_blok.push("#DOcontent");}
						else if (i == 4) {list_blok.push("#VRcontent");}
						else if (i == 5) {list_blok.push("#ZAcontent");}
						list_blok.push(String(blokken.idAfspraak));
						list_blok.push(String(blokken.begintijd));
						list_blok.push(String(blokken.eindtijd));
						list_blok.push(String(blokken.locatie));
						
						if (blokken.studentnaam == null) {
							addBlockOpen(list_blok[0],list_blok[1],list_blok[2],list_blok[3],list_blok[4]);
						} else {
							list_blok.push(String(blokken.studentnaam));
							addBlockAfspraak(list_blok[0],list_blok[1],list_blok[2],list_blok[3],list_blok[4],list_blok[5]);
						}
			
					});
				}	
			});
			changeDates(list_datums[0], list_datums[1], list_datums[2], list_datums[3], list_datums[4], list_datums[5], list_datums[6]);
	    });
	}
	$("#terug").click(function(){
		var nummer = parseInt($("#weeknummer").html());
		if (nummer > 1) {
			nummer -= 1;
			getWeek(nummer);
		}
	});
	$("#verder").click(function(){
		var nummer = parseInt($("#weeknummer").html());
		if (nummer < 52) {
			nummer += 1;
			getWeek(nummer);
		}
	});
});