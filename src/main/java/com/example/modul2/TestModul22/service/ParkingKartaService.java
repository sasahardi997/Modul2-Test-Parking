package com.example.modul2.TestModul22.service;

import java.util.List;

import com.example.modul2.TestModul22.model.ParkingKarta;

public interface ParkingKartaService {

	List<ParkingKarta> getAllByTrajanje(Integer trajanjeOd, Integer trajanjeDo);
}
