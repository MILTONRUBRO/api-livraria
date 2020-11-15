package br.com.devmos.apilivraria.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devmos.apilivraria.models.Livro;
import br.com.devmos.apilivraria.models.LivroDTO;
import br.com.devmos.apilivraria.repositories.LivroRepository;

@Service
public class LivroService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Transactional
	public Livro salvarLivro(Livro livro) {
		entityManager.persist(livro);
		return livro;
	}

	public List<LivroDTO> listarLivros() {
		List<Livro> livros = livroRepository.findAll();
		return LivroDTO.converter(livros);
	}

}
