package com.example.modul2.TestModul22.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.modul2.TestModul22.model.ParkingKarta;
import com.example.modul2.TestModul22.model.Zona;
import com.example.modul2.TestModul22.service.ParkingKartaService;

@Controller
@RequestMapping("/ParkingKarte")
public class ParkingKarteController {

	public static final String ZONE_KEY = "zone";
	public static final String PARKING_KARTE_KEY = "parkingKarte";
	public static final String PARKING_KARTE_CRVENA_ZONE = "parkingKarteCrvenaZona";
	public static final String PARKING_KARTE_KORISNIKA_KEY = "parkingKarteKorisnika";
	
	@Autowired
	private ServletContext servletContext;
	private String bURL;
	
	@Autowired
	private ParkingKartaService parkingKartaService;
	
	@PostConstruct
	public void init() {
		bURL = servletContext.getContextPath() + "/";
	}
	
	@PostMapping("/Create")
	public void createZadatak2(@RequestParam String registracija, @RequestParam String pocetakParkinga, @RequestParam int trajanjeUMinutima,
			@RequestParam String osobaSaInvaliditetom, @RequestParam int zonaId, HttpSession session, HttpServletResponse response) throws IOException {
		
		HashMap<Long, ParkingKarta> parkingKarte = (HashMap<Long, ParkingKarta>) servletContext.getAttribute(ParkingKarteController.PARKING_KARTE_KEY);
		HashMap<Integer, Zona> zone = (HashMap<Integer, Zona>) servletContext.getAttribute(ParkingKarteController.ZONE_KEY);
		List<ParkingKarta> pkKorisnika = (List<ParkingKarta>) session.getAttribute(ParkingKarteController.PARKING_KARTE_KORISNIKA_KEY);
		
		Zona zona = zone.get(zonaId);
		ParkingKarta parkingKarta = new ParkingKarta(Long.valueOf( parkingKarte.size() + 1) , registracija, pocetakParkinga, trajanjeUMinutima, osobaSaInvaliditetom, zona);
		parkingKarte.put(parkingKarta.getId(), parkingKarta);
		pkKorisnika.add(parkingKarta);
		
		int pkCrvenaZona = (int) servletContext.getAttribute(ParkingKarteController.PARKING_KARTE_CRVENA_ZONE);
		for(ParkingKarta pk : parkingKarte.values()) {
			System.out.println(pk);
			if(pk.getZona().getNaziv().equals("crvena")) {
				pkCrvenaZona ++;
			}
		}
	
		System.out.println("Ukupan broj parking karata za crvenu zonu: " + pkCrvenaZona);
		
		response.sendRedirect(bURL + "ParkingKarte/Zadatak3");
	}
	
	@GetMapping("/Zadatak3")
	public String zadata3(ModelMap modelMap, HttpSession session) {
		HashMap<Long, ParkingKarta> parkingKarte = (HashMap<Long, ParkingKarta>) servletContext.getAttribute(ParkingKarteController.PARKING_KARTE_KEY);
		modelMap.addAttribute("parkingKarte", parkingKarte.values());
		
		double ukupnaSuma = 0;
		for(ParkingKarta pk : parkingKarte.values()) {
			if(pk.getOsobaSaInvaliditetom().equals("DA")) {
				continue;
			} else {
				double minuti = 0;
				if(pk.getTrajanjeUMinutama() % 60 != 0) {
					minuti = pk.getTrajanjeUMinutama() / 60 + 1;
				} else {
					minuti = pk.getTrajanjeUMinutama() / 60;
				}
				ukupnaSuma += (pk.getZona().getCenaZaSat() * minuti);
			}
		}
		modelMap.addAttribute("ukupnaSuma", ukupnaSuma);
		
		List<ParkingKarta> pkKorisnika = (List<ParkingKarta>) session.getAttribute(ParkingKarteController.PARKING_KARTE_KORISNIKA_KEY);
		System.out.println("Parking karte korisnika: *******************");
		for(ParkingKarta pk : pkKorisnika) {
			System.out.println(pk);
		}
		System.out.println("************************");
		
		return "zadatak3";
	}
	
	@GetMapping("/Zadatak5")
	public String zadatak5(@RequestParam(defaultValue = "0") Integer trajanjeOd, @RequestParam(defaultValue = "1000") Integer trajanjeDo, ModelMap modelMap) {
		
		List<ParkingKarta> parkingKarte = parkingKartaService.getAllByTrajanje(trajanjeOd, trajanjeDo);
		modelMap.addAttribute("parkingKarte", parkingKarte);
		
		for(ParkingKarta pk : parkingKarte) {
			System.out.println(pk);
		}
		
		return "zadatak5";
	}
}
