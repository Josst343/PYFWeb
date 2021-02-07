package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.EnvioMailService;
import com.sun.mail.iap.Response;



@RestController
public class RestControllerMail {
	
	@Autowired
	private EnvioMailService enviomail;

	@RequestMapping(value = "/enviarEmail", method = RequestMethod.POST)
	public Response enviarEmail(@RequestParam (name = "name") String nombre, @RequestParam(name = "email")String email,@RequestParam(name = "phone")String telefono,@RequestParam(name = "message")String mensaje) {
		System.err.println("El nombre que llego es :" +nombre);
		System.err.println("El email es: "+ email);
		System.err.println("El telefono es "+ telefono);
		System.err.println("El mesnaje es :"+ mensaje);
		System.out.println("Entrando en mestodo rest ...");
		enviomail.envioMail(email, "kirauzumaki@live.com.mx", "CONTACTO SIMPOSIO","El mensaje proviene de "+email+"con el nombre: "+nombre+"con el telefono: " +telefono+" y es el sigueinte: "+ mensaje );
		return new Response("email ok");
	}
}
