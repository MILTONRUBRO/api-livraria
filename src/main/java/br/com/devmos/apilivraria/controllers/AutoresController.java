package br.com.devmos.apilivraria.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devmos.apilivraria.models.Autor;
import br.com.devmos.apilivraria.models.AutorDTO;
import br.com.devmos.apilivraria.models.AutorRequest;
import br.com.devmos.apilivraria.services.AutorService;
import br.com.devmos.apilivraria.validators.BloquearEmailDuplicadoAutorValidator;

@RestController
public class AutoresController {

	@Autowired
	private AutorService autorService;

	@Autowired
	private BloquearEmailDuplicadoAutorValidator bloquearEmailDuplicadoAutorValidator;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(bloquearEmailDuplicadoAutorValidator);
	}

	@PostMapping("api/autores")
	public ResponseEntity<Autor> saveAutor(@RequestBody @Valid AutorRequest request) {
		Autor autor = request.toModel();

		autorService.salvar(autor);
		return ResponseEntity.ok(autor);
	}

	@GetMapping("api/autores/{idAutor}")
	public ResponseEntity<Autor> buscaAutor(@PathVariable("idAutor") Long id) {
		return ResponseEntity.ok(autorService.buscarAutorPorId(id));
	}
	
	@GetMapping("api/autores")
	public ResponseEntity<List<AutorDTO>> getAutores(){
		
		List<Autor> autores = autorService.buscaAutores();
		
		return ResponseEntity.ok(AutorDTO.converte(autores));
	}
	
	@DeleteMapping("api/autores/{idAutor}")
	public void deleteAutores(@PathVariable("idAutor") Long id) {
		Autor autor = autorService.buscarAutorPorId(id);
		autorService.deletarAutor(autor);
	}

}
