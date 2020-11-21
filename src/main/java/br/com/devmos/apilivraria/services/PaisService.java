package br.com.devmos.apilivraria.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devmos.apilivraria.models.Pais;
import br.com.devmos.apilivraria.repositories.PaisRepository;

@Service
public class PaisService {

	@Autowired
	private PaisRepository paisRepository;
	
	@Transactional
	public void salvar(Pais pais) {
		paisRepository.save(pais);
	}

}
