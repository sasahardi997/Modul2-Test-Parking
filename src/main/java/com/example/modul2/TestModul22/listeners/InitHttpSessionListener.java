package com.example.modul2.TestModul22.listeners;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.stereotype.Component;

import com.example.modul2.TestModul22.controller.ParkingKarteController;
import com.example.modul2.TestModul22.model.ParkingKarta;

@Component
public class InitHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Inicijalizacija sesisje HttpSessionListener...");
		
		HttpSession session  = se.getSession();
		System.out.println("Session id korisnika je "+ session.getId());
		
		List<ParkingKarta> parkingKarteKorisnika = new ArrayList<ParkingKarta>();
		session.setAttribute(ParkingKarteController.PARKING_KARTE_KORISNIKA_KEY, parkingKarteKorisnika);
		
		System.out.println("Uspeh HttpSessionListener!");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Brisanje sesisje HttpSessionListener...");
		System.out.println("Uspeh HttpSessionListener!");
	}

}
