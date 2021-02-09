package com.example.modul2.TestModul22.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.modul2.TestModul22.model.ParkingKarta;
import com.example.modul2.TestModul22.model.Zona;

@Repository
public class ParkingKartaDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static class ParkingKartaRowMapper implements RowMapper<ParkingKarta>{

		@Override
		public ParkingKarta mapRow(ResultSet rs, int rowNum) throws SQLException {
			int index = 1;
			Long idPK = rs.getLong(index++);
			String registracija = rs.getString(index++);
			String pocetakParking = rs.getString(index++);
			int trajanjeUMinutima = rs.getInt(index++);
			String osobaSaInvaliditetom = rs.getString(index++);
			int zonaId = rs.getInt(index++);
			
			int idZ = rs.getInt(index++);
			String naziv = rs.getString(index++);
			double cenaZaSat = rs.getDouble(index++);
			int dozvoljenoVremeParkingaUSatima = rs.getInt(index++);
			
			Zona zona = new Zona(idZ, naziv, cenaZaSat, dozvoljenoVremeParkingaUSatima);
			ParkingKarta pk = new ParkingKarta(idPK, registracija, pocetakParking, trajanjeUMinutima, osobaSaInvaliditetom, zona);
			return pk;
		}
		
	}

	public List<ParkingKarta> getAllByTrajanje(Integer trajanjeOd, Integer trajanjeDo) {
		String sql = "SELECT pk.id, pk.registracija, pk.pocetakParkinga, pk.trajanjeUMinutima, pk.osobaSaInvaliditetom,\r\n"
				+ "pk.zonaId, z.id, z.naziv, z.cenaZaSat, z.dozvoljenoVremeParkingaUSatima FROM parkingkarte pk\r\n"
				+ "LEFT JOIN zone z ON pk.zonaId = z.id WHERE trajanjeUMinutima > ? AND trajanjeUMinutima < ?";
		return jdbcTemplate.query(sql, new ParkingKartaRowMapper(), trajanjeOd, trajanjeDo);
	}

}
