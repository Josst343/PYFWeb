package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.ConferencistaDao;
import com.example.demo.model.Conferencista;

public interface ConferencistaService {
	
	public List<Conferencista> listaConferencistas();
	
	public void guardar(Conferencista conferencista);
	
	public void eliminar (Conferencista conferencista);
	
	public Conferencista encontrarConferencista(Conferencista conferencista);
	

}
