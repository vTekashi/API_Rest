package br.com.residencia.biblioteca.dto;

import java.util.List;

public class EditoraDTO {
	private int codigoEditora;
	private String nome;
	private List<LivroDTO> listaLivrosDTO;
	

	public List<LivroDTO> getListaLivrosDTO() {
		return listaLivrosDTO;
	}
	public void setListaLivrosDTO(List<LivroDTO> listaLivrosDTO) {
		this.listaLivrosDTO = listaLivrosDTO;
	}
	//	public EditoraDTO() {
//		
//	}
//	
//	public EditoraDTO(int codigoEditora, String nome) {
//		this.codigoEditora = codigoEditora;
//		this.nome = nome;
//	}
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
