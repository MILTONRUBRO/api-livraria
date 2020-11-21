package br.com.devmos.apilivraria.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devmos.apilivraria.models.Pais;
import br.com.devmos.apilivraria.models.PaisRequest;
import br.com.devmos.apilivraria.services.PaisService;

@RestController
public class PaisController {
	
	@Autowired
	private PaisService paisService;
	
	@PostMapping("api/paises")
	public ResponseEntity<Pais> save(@RequestBody @Valid PaisRequest request) {
		Pais pais = request.toModel();
		paisService.salvar(pais);
		return ResponseEntity.ok(pais);
		
	}

}
