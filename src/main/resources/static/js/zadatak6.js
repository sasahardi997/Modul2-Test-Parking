$(document).ready(function(){
	console.log("povezano")
	
	$("form").submit(function(){
		var forma = $(this)
		var registracija = forma.find("input[name=registracija]").val()
		var pocetakParkinga = forma.find("input[name=pocetakParkinga]").val()
		var trajanjeUMinutima = forma.find("input[name=trajanjeUMinutima]").val()
		var invaliditet = $("input[name=osobaSaInvaliditetom]:checked").val()
		var zona = $("#zona").find(":selected").text()
		
		if(registracija == "" || pocetakParkinga == "" || trajanjeUMinutima == ""
		|| invaliditet == null){
			alert("Sva polja moraju biti unesena!")
			return false
		}
		if(trajanjeUMinutima < 15 || isNaN(trajanjeUMinutima)){
			alert("Trajanje parkinga u minutima mora biti ceo broj veci od 15!")
			return false
		}
		if(zona=="crvena" && trajanjeUMinutima > 120){
			alert("Maskimalno zadrzavanje na crvenoj zoni je 120 minuta!")
			return false
		}
		
		return true
	})
})