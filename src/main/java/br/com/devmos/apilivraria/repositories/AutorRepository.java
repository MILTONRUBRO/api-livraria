package br.com.devmos.apilivraria.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devmos.apilivraria.models.Autor;

@Repository
public interface AutorRepository  extends JpaRepository<Autor, Long>{

	Optional<Autor> findByEmail(String email);

}
