package br.com.devmos.apilivraria.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class LivroDTO {
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private int numeroPaginas;
	private String isbn;
	private LocalDate dataPublicacao;
	private Autor autor;
	private Categoria categoria;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public LivroDTO(Livro livro) {
		  this.titulo = livro.getTitulo();
		  this.resumo = livro.getResumo();
		  this.sumario = livro.getSumario();
		  this.preco = livro.getPreco();
		  this.numeroPaginas = livro.getNumeroPaginas();
		  this.isbn = livro.getIsbn();
		  this.dataPublicacao = livro.getDataPublicacao();
		  this.autor = livro.getAutor();
		  this.categoria = livro.getCategoria();
	}
	
	public static List<LivroDTO> converter(List<Livro> livros) {
		return livros.stream()
				.map(LivroDTO::new)
				.collect(Collectors.toList());
	}

}
