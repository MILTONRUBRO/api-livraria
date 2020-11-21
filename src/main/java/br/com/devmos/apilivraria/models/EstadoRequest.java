package br.com.devmos.apilivraria.models;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.devmos.apilivraria.errors.ResourceNotFoundException;
import br.com.devmos.apilivraria.repositories.PaisRepository;

public class EstadoRequest {
	@NotBlank
	private String nome;
	
	@NotNull
	private Long idAutor;

	public Estado toModel(PaisRepository paisRepository, Long idPais) {
		Optional<Pais> possivelPais = paisRepository.findById(idPais);
		
		if(!possivelPais.isPresent()) {
			throw new ResourceNotFoundException();
		}
		
		return new Estado(nome, possivelPais.get());
	}
	
	

}
