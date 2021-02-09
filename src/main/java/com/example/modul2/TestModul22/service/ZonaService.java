package com.example.modul2.TestModul22.service;

import java.util.List;

import com.example.modul2.TestModul22.model.Zona;

public interface ZonaService {

	List<Zona> getAll();
	Zona save(Zona zona);
}
