package br.com.devmos.apilivraria.services;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.devmos.apilivraria.errors.ResourceNotFoundException;
import br.com.devmos.apilivraria.models.Autor;

@Service
public class AutorService {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public Autor salvar(Autor autor) {
		 manager.persist(autor);
		 return autor;
	}

	public Autor buscarAutorPorId(Long id) {
		 Autor autor = manager.find(Autor.class, id);
		 
		 if(autor == null) {
			 throw new ResourceNotFoundException();
		 }
		 return autor;
	}

}
