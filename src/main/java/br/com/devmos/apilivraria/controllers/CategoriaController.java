package br.com.devmos.apilivraria.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devmos.apilivraria.models.Categoria;
import br.com.devmos.apilivraria.models.CategoriaRequest;
import br.com.devmos.apilivraria.services.CategoriaService;

@RestController
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@PostMapping("api/categorias")
	public ResponseEntity<Categoria> save(@RequestBody @Valid CategoriaRequest request) {
		Categoria categoria = request.toModel();
		return ResponseEntity.ok(categoriaService.salvar(categoria));

	}

}
