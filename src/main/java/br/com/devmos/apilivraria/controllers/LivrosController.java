package br.com.devmos.apilivraria.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devmos.apilivraria.models.Livro;
import br.com.devmos.apilivraria.models.LivroRequest;

@RestController
public class LivrosController {
	
	@PostMapping("api/livros")
	public ResponseEntity<Livro> saveLivro(@RequestBody @Valid LivroRequest request){
		return null;
	}

}
