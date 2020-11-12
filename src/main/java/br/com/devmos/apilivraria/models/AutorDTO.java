package br.com.devmos.apilivraria.models;

import java.util.List;
import java.util.stream.Collectors;

public class AutorDTO {
	
	private String nome;
	private String email;
	private String descricao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public AutorDTO() {
		
	}
	
	public AutorDTO(Autor autor) {
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
		
	}
	public static List<AutorDTO> converte(List<Autor> autores) {
		return autores.stream()
				.map(AutorDTO::new)
				.collect(Collectors.toList());
	}
	

}
