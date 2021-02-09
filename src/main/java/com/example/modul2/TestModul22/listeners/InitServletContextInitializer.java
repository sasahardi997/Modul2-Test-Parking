package com.example.modul2.TestModul22.listeners;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.stereotype.Component;

import com.example.modul2.TestModul22.controller.ParkingKarteController;
import com.example.modul2.TestModul22.model.ParkingKarta;
import com.example.modul2.TestModul22.model.Zona;

@Component
public class InitServletContextInitializer implements ServletContextInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("Inicijalizacija konteksta pri ServletContextInitializer...");
		
		HashMap<Integer, Zona> zone = new HashMap<Integer, Zona>();
		zone.put(1, new Zona(1, "bela", 35.00));
		zone.put(2, new Zona(2, "plava", 44.00));
		zone.put(3, new Zona(3, "crvena", 53.00, 2));
		servletContext.setAttribute(ParkingKarteController.ZONE_KEY, zone);
		
		HashMap<Long, ParkingKarta> parkingKarte = new HashMap<Long, ParkingKarta>();
		parkingKarte.put(1L, new ParkingKarta(1L, "SO 123 456", "2019-12-18 11:30:00", 130, "DA", zone.get(3)));
		parkingKarte.put(2L, new ParkingKarta(2L, "NS 222 333", "2019-12-17 15:00:00", 45, "NE", zone.get(1)));
		parkingKarte.put(3L, new ParkingKarta(3L, "BG 444 555", "2019-11-12 17:45:00", 90, "NE", zone.get(2)));
		servletContext.setAttribute(ParkingKarteController.PARKING_KARTE_KEY, parkingKarte);
		
		int karteCrveneZone = 0;
		servletContext.setAttribute(ParkingKarteController.PARKING_KARTE_CRVENA_ZONE, karteCrveneZone);
		
		System.out.println("Uspeh ServletContextInitializer!");
		
	}

}
