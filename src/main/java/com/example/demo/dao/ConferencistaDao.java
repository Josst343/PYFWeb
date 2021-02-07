package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Conferencista;

public interface ConferencistaDao extends CrudRepository<Conferencista, Long> {
	

}
