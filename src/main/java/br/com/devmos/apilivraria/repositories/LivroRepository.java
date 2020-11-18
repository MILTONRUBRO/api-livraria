package br.com.devmos.apilivraria.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devmos.apilivraria.models.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

	Optional<Livro> findByTitulo(String titulo);

}
