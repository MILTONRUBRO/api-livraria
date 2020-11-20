package br.com.devmos.apilivraria.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devmos.apilivraria.models.Livro;
import br.com.devmos.apilivraria.models.LivroDTO;
import br.com.devmos.apilivraria.models.LivroRequest;
import br.com.devmos.apilivraria.models.LivrosResumidos;
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
	
	@GetMapping("api/livros/{idLivro}")
	public ResponseEntity<Livro> getLivro(@PathVariable("idLivro") Long id){
		Livro livro = livroService.buscarLivro(id);
		return ResponseEntity.ok(livro);
	}
	
	@GetMapping("api/livros/dados/{titulo}")
	public ResponseEntity<Livro> getLivroPorTitulo(@PathVariable("titulo") String titulo){
		Livro livro = livroService.buscarLivroPorTitulo(titulo);
		return ResponseEntity.ok(livro);
	}
	
	@DeleteMapping("api/livros/{idLivro}")
	public void deletLivro(@PathVariable("idLivro") Long id) {
		Livro livro = livroService.buscarLivro(id);
		
		livroService.deletar(livro);
		
	}
	
	@PutMapping("api/livros/{idLivro}")
	public ResponseEntity<LivroDTO> updateLivro(@PathVariable("idLivro") Long id, @RequestBody @Valid LivroRequest request) {
		Livro livro = livroService.buscarLivro(id);
		
		livro = request.toModel(autorService, categoriaService);
		
		return ResponseEntity.ok(livroService.atualizarLivro(livro, id));
		
	}
	
	@GetMapping("api/livros/resumo")
	public ResponseEntity<List<LivrosResumidos>> getLivrosCadastrados(){
		return ResponseEntity.ok(livroService.listarResumoLivros());
	}

}
