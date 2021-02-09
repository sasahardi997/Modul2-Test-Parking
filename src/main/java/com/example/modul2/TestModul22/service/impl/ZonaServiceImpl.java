package com.example.modul2.TestModul22.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.modul2.TestModul22.dao.ZonaDAO;
import com.example.modul2.TestModul22.model.Zona;
import com.example.modul2.TestModul22.service.ZonaService;

@Service
public class ZonaServiceImpl implements ZonaService {

	@Autowired
	private ZonaDAO zonaDAO;
	
	@Override
	public List<Zona> getAll() {
		return zonaDAO.getAll();
	}

	@Override
	public Zona save(Zona zona) {
		zonaDAO.save(zona);
		return zona;
	}

}
