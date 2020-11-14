package br.com.devmos.apilivraria.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.devmos.apilivraria.errors.ResourceNotFoundException;
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
	
	public Categoria buscarCategoria(Long id) {
		Categoria categoria = entityManager.find(Categoria.class, id);
		
		if(categoria == null) {
			throw new ResourceNotFoundException();
		}
		return categoria;
	}

}
