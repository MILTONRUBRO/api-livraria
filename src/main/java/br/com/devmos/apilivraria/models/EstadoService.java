package br.com.devmos.apilivraria.models;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

@Service
public class EstadoService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Estado salvar(Estado estado) {
		entityManager.persist(estado);
		return estado;
	}
	

}
