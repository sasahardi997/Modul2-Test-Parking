package com.example.modul2.TestModul22.model;

public class ParkingKarta {

	private Long id;
	private String registracija;
	private String pocetakParkinga;
	private int trajanjeUMinutama;
	private String osobaSaInvaliditetom;
	private Zona zona;
	
	public ParkingKarta(String registracija, String pocetakParkinga, int trajanjeUMinutama, String osobaSaInvaliditetom,
			Zona zona) {
		this.registracija = registracija;
		this.pocetakParkinga = pocetakParkinga;
		this.trajanjeUMinutama = trajanjeUMinutama;
		this.osobaSaInvaliditetom = osobaSaInvaliditetom;
		this.zona = zona;
	}

	public ParkingKarta(Long id, String registracija, String pocetakParkinga, int trajanjeUMinutama,
			String osobaSaInvaliditetom, Zona zona) {
		this.id = id;
		this.registracija = registracija;
		this.pocetakParkinga = pocetakParkinga;
		this.trajanjeUMinutama = trajanjeUMinutama;
		this.osobaSaInvaliditetom = osobaSaInvaliditetom;
		this.zona = zona;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParkingKarta other = (ParkingKarta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegistracija() {
		return registracija;
	}

	public void setRegistracija(String registracija) {
		this.registracija = registracija;
	}

	public String getPocetakParkinga() {
		return pocetakParkinga;
	}

	public void setPocetakParkinga(String pocetakParkinga) {
		this.pocetakParkinga = pocetakParkinga;
	}

	public int getTrajanjeUMinutama() {
		return trajanjeUMinutama;
	}

	public void setTrajanjeUMinutama(int trajanjeUMinutama) {
		this.trajanjeUMinutama = trajanjeUMinutama;
	}

	public String getOsobaSaInvaliditetom() {
		return osobaSaInvaliditetom;
	}

	public void setOsobaSaInvaliditetom(String osobaSaInvaliditetom) {
		this.osobaSaInvaliditetom = osobaSaInvaliditetom;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	@Override
	public String toString() {
		return "ParkingKarta [id=" + id + ", registracija=" + registracija + ", pocetakParkinga=" + pocetakParkinga
				+ ", trajanjeUMinutama=" + trajanjeUMinutama + ", osobaSaInvaliditetom=" + osobaSaInvaliditetom
				+ ", zona=" + zona + "]";
	}
	
}
