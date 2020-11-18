package br.com.devmos.apilivraria.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devmos.apilivraria.errors.ResourceNotFoundException;
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

	public Livro buscarLivro(Long id) {
		Optional<Livro> possivelLivro = livroRepository.findById(id);
		
		if(!possivelLivro.isPresent()) {
			throw new ResourceNotFoundException();
		}
		return possivelLivro.get();
	}

	public Livro buscarLivroPorTitulo(String titulo) {
		Optional<Livro> possivelLivro = livroRepository.findByTitulo(titulo);
		
		if(!possivelLivro.isPresent()) {
			throw new ResourceNotFoundException();
		}
		return possivelLivro.get();
	}

}
