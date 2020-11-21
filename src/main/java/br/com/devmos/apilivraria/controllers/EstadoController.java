package br.com.devmos.apilivraria.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devmos.apilivraria.models.Estado;
import br.com.devmos.apilivraria.models.EstadoRequest;
import br.com.devmos.apilivraria.models.EstadoService;
import br.com.devmos.apilivraria.repositories.PaisRepository;

@RestController
public class EstadoController {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private EstadoService estadoService;
	
	@PostMapping("api/estados/{idPais}")
	public ResponseEntity<Estado> save(@RequestBody @Valid EstadoRequest request, Long idPais) {
		Estado estado = request.toModel(paisRepository, idPais);
		
		return ResponseEntity.ok(estadoService.salvar(estado));
		
	}

}
