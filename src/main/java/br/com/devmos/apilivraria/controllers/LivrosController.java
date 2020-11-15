package br.com.devmos.apilivraria.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devmos.apilivraria.models.Livro;
import br.com.devmos.apilivraria.models.LivroDTO;
import br.com.devmos.apilivraria.models.LivroRequest;
import br.com.devmos.apilivraria.services.AutorService;
import br.com.devmos.apilivraria.services.CategoriaService;
import br.com.devmos.apilivraria.services.LivroService;

@RestController
public class LivrosController {
	
	@Autowired
	private AutorService autorService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private LivroService livroService;
	
	@PostMapping("api/livros")
	public ResponseEntity<Livro> saveLivro(@RequestBody @Valid LivroRequest request){
		Livro livro = request.toModel(autorService, categoriaService);
		return ResponseEntity.ok(livroService.salvarLivro(livro));
	}
	
	@GetMapping("api/livros")
	public ResponseEntity<List<LivroDTO>> getLivros(){
		return ResponseEntity.ok(livroService.listarLivros());
	}

}
