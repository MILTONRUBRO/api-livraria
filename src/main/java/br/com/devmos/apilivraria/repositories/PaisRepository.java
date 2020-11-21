package br.com.devmos.apilivraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devmos.apilivraria.models.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>{

}
