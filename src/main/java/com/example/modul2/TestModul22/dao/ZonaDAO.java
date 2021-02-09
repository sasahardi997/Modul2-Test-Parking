package com.example.modul2.TestModul22.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.modul2.TestModul22.model.Zona;

@Repository
public class ZonaDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static class ZonaRowMapper implements RowMapper<Zona>{

		@Override
		public Zona mapRow(ResultSet rs, int rowNum) throws SQLException {
			int index = 1;
			String naziv = rs.getString(index++);
			double cenaZaSat = rs.getDouble(index++);
			int dozvoljenoVremeParkingaUSatima = rs.getInt(index++);
			
			Zona zona = new Zona(naziv, cenaZaSat, dozvoljenoVremeParkingaUSatima);
			return zona;
		}
	}

	public List<Zona> getAll() {
		String sql = "SELECT naziv, cenaZaSat, dozvoljenoVremeParkingaUSatima FROM zone";
		return jdbcTemplate.query(sql, new ZonaRowMapper());
	}

	public void save(Zona zona) {
		String sql = "INSERT INTO zone(naziv, cenaZaSat, dozvoljenoVremeParkingaUSatima) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, zona.getNaziv(), zona.getCenaZaSat(), zona.getDozvoljenoVremeParkingaUSatima());
	}

}
