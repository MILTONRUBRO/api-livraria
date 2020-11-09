package br.com.devmos.apilivraria.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank 
	@Email
	private String email;
	
	@NotBlank 
	@Size(max = 400)
	private String descricao;
	
	private LocalDateTime instanteCriacao; 
	
	@Deprecated
	public Autor() {
		
	}

	public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
		
		Assert.hasLength(nome, "O nome é obrigatorio");
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		instanteCriacao = LocalDateTime.now();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public LocalDateTime getInstanteCriacao() {
		return instanteCriacao;
	}

	public void setInstanteCriacao(LocalDateTime instanteCriacao) {
		this.instanteCriacao = instanteCriacao;
	}

}
