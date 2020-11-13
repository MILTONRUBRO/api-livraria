package br.com.devmos.apilivraria.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devmos.apilivraria.errors.ResourceNotFoundException;
import br.com.devmos.apilivraria.models.Autor;
import br.com.devmos.apilivraria.repositories.AutorRepository;

@Service
public class AutorService {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private AutorRepository autorRepository;
	
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

	public List<Autor> buscaAutores() {
		return autorRepository.findAll();
	}
	
	@Transactional
	public void deletarAutor(Autor autor) {
		manager.remove(autor);
	}

}
