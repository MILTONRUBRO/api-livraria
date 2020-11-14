package br.com.devmos.apilivraria.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.devmos.apilivraria.models.Livro;

@Service
public class LivroService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public Livro salvarLivro(Livro livro) {
		entityManager.persist(livro);
		return livro;
	}

}
