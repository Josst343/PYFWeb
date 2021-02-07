package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ConferencistaDao;
import com.example.demo.model.Conferencista;

@Service
public class ConferencistaServiceImpl implements ConferencistaService{
	
	@Autowired
	private ConferencistaDao cfcDao;

	@Override
	//nos ayuda a el rollback por si algo falla 
	@Transactional(readOnly = true)
	public List<Conferencista> listaConferencistas() {
	return	(List<Conferencista>) cfcDao.findAll();
	}

	@Override
	@Transactional
	public void guardar(Conferencista conferencista) {
		cfcDao.save(conferencista);
		
	}

	@Override
	@Transactional
	public void eliminar(Conferencista conferencista) {
		cfcDao.delete(conferencista);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Conferencista encontrarConferencista(Conferencista conferencista) {
		
		return cfcDao.findById(conferencista.getId()).orElse(null);
		
	}

}
