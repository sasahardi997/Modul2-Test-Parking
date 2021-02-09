package com.example.modul2.TestModul22.model;

public class Zona {

	private int id;
	private String naziv;
	private double cenaZaSat;
	private int dozvoljenoVremeParkingaUSatima;
	
	public Zona(String naziv, double cenaZaSat, int dozvoljenoVremeParkingaUSatima) {
		this.naziv = naziv;
		this.cenaZaSat = cenaZaSat;
		this.dozvoljenoVremeParkingaUSatima = dozvoljenoVremeParkingaUSatima;
	}

	public Zona(int id, String naziv, double cenaZaSat, int dozvoljenoVremeParkingaUSatima) {
		this.id = id;
		this.naziv = naziv;
		this.cenaZaSat = cenaZaSat;
		this.dozvoljenoVremeParkingaUSatima = dozvoljenoVremeParkingaUSatima;
	}

	public Zona(int id, String naziv, double cenaZaSat) {
		this.id = id;
		this.naziv = naziv;
		this.cenaZaSat = cenaZaSat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Zona other = (Zona) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public double getCenaZaSat() {
		return cenaZaSat;
	}

	public void setCenaZaSat(double cenaZaSat) {
		this.cenaZaSat = cenaZaSat;
	}

	public int getDozvoljenoVremeParkingaUSatima() {
		return dozvoljenoVremeParkingaUSatima;
	}

	public void setDozvoljenoVremeParkingaUSatima(int dozvoljenoVremeParkingaUSatima) {
		this.dozvoljenoVremeParkingaUSatima = dozvoljenoVremeParkingaUSatima;
	}

	@Override
	public String toString() {
		return "Zona [id=" + id + ", naziv=" + naziv + ", cenaZaSat=" + cenaZaSat + ", dozvoljenoVremeParkingaUSatima="
				+ dozvoljenoVremeParkingaUSatima + "]";
	}
	
}
