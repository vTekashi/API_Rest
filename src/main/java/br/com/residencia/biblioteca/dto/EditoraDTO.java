package br.com.residencia.biblioteca.dto;

import br.com.residencia.biblioteca.entity.Editora;

public class EditoraDTO {
	private int codigoEditora;
	private String nome;
	
	public EditoraDTO() {
		
	}
	
	public EditoraDTO(Editora editora) {
		this.codigoEditora = editora.getCodigoEditora();
		this.nome = editora.getNome() ;
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
	
}
