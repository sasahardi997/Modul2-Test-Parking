package com.example.modul2.TestModul22.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.modul2.TestModul22.dao.ParkingKartaDAO;
import com.example.modul2.TestModul22.model.ParkingKarta;
import com.example.modul2.TestModul22.service.ParkingKartaService;

@Service
public class ParkingKartaServiceImpl implements ParkingKartaService {
	
	@Autowired
	private ParkingKartaDAO parkingKartaDAO;

	@Override
	public List<ParkingKarta> getAllByTrajanje(Integer trajanjeOd, Integer trajanjeDo) {
		if(trajanjeOd == null) {
			trajanjeOd = 0;
		}
		if(trajanjeDo == null) {
			trajanjeDo = Integer.MAX_VALUE;
		}
		return parkingKartaDAO.getAllByTrajanje(trajanjeOd, trajanjeDo);
	}

}
