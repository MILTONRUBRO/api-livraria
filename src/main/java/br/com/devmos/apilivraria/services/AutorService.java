package br.com.devmos.apilivraria.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

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

}