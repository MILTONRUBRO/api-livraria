package br.com.devmos.apilivraria.models;

import java.util.List;
import java.util.stream.Collectors;

public class LivrosResumidos {

	private Long id;
	private String titulo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public LivrosResumidos(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}
	
	public static List<LivrosResumidos> converter(List<Livro> livros){
		return livros.stream()
				.map(LivrosResumidos::new)
				.collect(Collectors.toList());
	}

}
