package br.com.devmos.apilivraria.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devmos.apilivraria.models.CompraRequest;

@RestController
public class FechaCompraController {
	
	public void save(@Valid @RequestBody CompraRequest compraRequest) {
		
	}

}
