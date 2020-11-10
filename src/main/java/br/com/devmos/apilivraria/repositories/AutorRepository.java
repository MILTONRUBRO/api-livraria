package br.com.devmos.apilivraria.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.devmos.apilivraria.models.Autor;

@Repository
public interface AutorRepository  extends CrudRepository<Autor, Long>{

	Optional<Autor> findByEmail(String email);

}
