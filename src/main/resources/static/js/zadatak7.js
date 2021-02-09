var baseURL = ""

function popuniBaseURL() {
	$.get("baseURL", function(odgovor) {
		console.log(odgovor)

		if (odgovor.status == "ok") {
			baseURL = odgovor.baseURL 
			$("base").attr("href", baseURL) 
		}
	})
	console.log("GET: " + "baseURL")
}

function cenaPDV(cena){
	return cena * 1.18
}

function dodajZonu(){
	var naziv = $("input[name=naziv]").val()
	var cenaZaSat = $("input[name=cenaZaSat]").val()
	var dozvoljenoVremeParkingaUSatima = $("input[name=dozvoljenoVremeParkingaUSatima]").val()
	
	var params = {
		naziv : naziv,
		cenaZaSat : cenaZaSat,
		dozvoljenoVremeParkingaUSatima : dozvoljenoVremeParkingaUSatima
	}
	console.log(params)
	
	$.post("Zone/Create", params, function(odgovor){
		console.log(odgovor)
		
		if(odgovor.status == "greska"){
			window.location.replace("zadatak7.html")
		} else if(odgovor.status == "ok"){
			$.get("Zone", function(odgovor){
				var zone = odgovor.zone
				console.log(zone)
			
				var tabela = $("table.tabela")
				tabela.find("tr:gt(1)").remove()
				for(var it in zone){
					cenaSaPDV = cenaPDV(zone[it].cenaZaSat)
					tabela.append(
						'<tr>' + 
							'<td>'+ zone[it].naziv +'</td>' + 
							'<td>'+ zone[it].cenaZaSat +'</td>' + 
							'<td>'+ cenaSaPDV.toFixed(2) +'</td>' + 
							'<td>'+ zone[it].dozvoljenoVremeParkingaUSatima +'</td>' + 
						'</tr>'
					)
				}
			})
		}
	})
}


function popuniZone(){
	$.get("Zone", function(odgovor){
		console.log(odgovor)
		
		if(odgovor.status = "ok"){
			var zone = odgovor.zone
			
			var tabela = $("table.tabela")
			tabela.find("tr:gt(1)").remove()
			for(var it in zone){
				var cenaSaPDV = cenaPDV(zone[it].cenaZaSat)
				tabela.append(
					'<tr>' + 
						'<td>'+ zone[it].naziv +'</td>' + 
						'<td>'+ zone[it].cenaZaSat +'</td>' + 
						'<td>'+ cenaSaPDV.toFixed(2) +'</td>' + 
						'<td>'+ zone[it].dozvoljenoVremeParkingaUSatima +'</td>' + 
					'</tr>'
				)
			}
		}
	})
	console.log("GET: Zone")
}

$(document).ready(function(){
	popuniBaseURL()
	popuniZone()
	
	$("form").submit(function(){
		dodajZonu()
		return false
	})
})