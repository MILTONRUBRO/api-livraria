package br.com.devmos.apilivraria.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.devmos.apilivraria.models.Categoria;

@Service
public class CategoriaService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public Categoria salvar(Categoria categoria) {
		entityManager.persist(categoria);
		return categoria;
	}

}
