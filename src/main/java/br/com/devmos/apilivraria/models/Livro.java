package br.com.devmos.apilivraria.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Livro {
	
	@NotBlank
	private String titulo;
	
	@NotBlank
	private String resumo;
	
	private String sumario;
	
	@NotBlank
	@Min(20)
	private BigDecimal preco;
	
	@NotBlank
	@Min(100)
	private int numeroPaginas;
	
	@NotBlank
	private String isbn;
	
	@FutureOrPresent
	private LocalDateTime dataPublicacao;

}
