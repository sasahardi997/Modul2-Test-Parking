package com.example.modul2.TestModul22.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.modul2.TestModul22.model.Zona;
import com.example.modul2.TestModul22.service.ZonaService;

@Controller
@RequestMapping("/Zone")
public class ZoneController {
	
	@Autowired
	private ZonaService zonaService;

	@GetMapping
	@ResponseBody
	public HashMap<String, Object> index(){
		
		List<Zona> zone = zonaService.getAll();
		HashMap<String, Object> odgovor = new LinkedHashMap<String, Object>();
		odgovor.put("status", "ok");
		odgovor.put("zone", zone);
		
		return odgovor;
	}
	
	@PostMapping("/Create")
	@ResponseBody
	public Map<String, Object> create(
			@RequestParam String naziv,
			@RequestParam double cenaZaSat,
			@RequestParam int dozvoljenoVremeParkingaUSatima){
		
		try {
			if(naziv.equals("")) {
				throw new Exception("Naziv ne sme biti prazan!");
			}
			if(cenaZaSat < 1) {
				throw new Exception("Cena za sat ne sme biti manja od 1!");
			}
			
			Zona zona = new Zona(naziv, cenaZaSat, dozvoljenoVremeParkingaUSatima);
			zonaService.save(zona);
			
			Map<String, Object> odgovor = new LinkedHashMap<String, Object>();
			odgovor.put("status", "ok");
			return odgovor;	
		} catch (Exception e) {
			String poruka = e.getMessage();
			if (poruka == "") {
				poruka = "Neuspešno dodavanje!";
			}
			
			Map<String, Object> odgovor = new LinkedHashMap<>();
			odgovor.put("status", "greska");
			odgovor.put("poruka", poruka);
			return odgovor;
		}
	}
}
