package br.com.residencia.biblioteca.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.residencia.biblioteca.dto.EditoraDTO;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class, property = "codigoEditora")
@Entity
@Table(name = "editora")
public class Editora {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigoeditora")
	private int codigoEditora;

	@Column(name = "nome")
	private String nome;
	
	@OneToMany(mappedBy = "editora")
	private Set<Livro> livros;
	
	
	

	public Editora() {
		
	}
	

	public Editora(EditoraDTO editoraDTO) {
		this.codigoEditora = editoraDTO.getCodigoEditora();
		this.nome = editoraDTO.getNome();
	}


	public int getCodigoEditora() {
		return codigoEditora;
	}

	public void setCodigoEditora(int codigoEditora) {
		this.codigoEditora = codigoEditora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Livro> getLivros() {
		return livros;
	}

	public void setLivros(Set<Livro> livros) {
		this.livros = livros;
	}
	

}
