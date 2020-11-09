package br.com.devmos.apilivraria.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devmos.apilivraria.models.Autor;
import br.com.devmos.apilivraria.models.AutorRequest;
import br.com.devmos.apilivraria.services.AutorService;

@RestController
public class AutoresController {
	
	private AutorService autorService;
	
	@PostMapping("api/autores")
	public ResponseEntity<Autor> saveAutor(@RequestBody @Valid AutorRequest request) {
		Autor autor = request.toModel();
		autorService.salvar(autor);
		return ResponseEntity.ok(autor);
	}

}
