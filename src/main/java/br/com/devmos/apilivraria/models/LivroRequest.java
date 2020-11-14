package br.com.devmos.apilivraria.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LivroRequest {
	@NotBlank
	private String titulo;
	
	@NotBlank
	@Size(max = 500)
	private String resumo;
	
	private String sumario;
	
	@NotNull	
	@Min(20)
	private BigDecimal preco;
	
	@Min(100)
	private int numeroPaginas;
	
	@NotBlank
	private String isbn;
	
	@FutureOrPresent
	private LocalDateTime dataPublicacao;
	
	@NotNull
	private Long idAutor;
	
	@NotNull
	private Long idCategoria;

}
