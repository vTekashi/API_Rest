package br.com.residencia.biblioteca.dto;

import java.util.List;

public class EditoraDTO {
	private int codigoEditora;
	private String nome;
	private List<LivroDTO> listaLivrosDTO;
	private String imagemNome;
	private String imagemFileName;
	private String imagemUrl;
	

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
	public String getImagemNome() {
		return imagemNome;
	}
	public void setImagemNome(String imagemNome) {
		this.imagemNome = imagemNome;
	}
	public String getImagemFileName() {
		return imagemFileName;
	}
	public void setImagemFileName(String imagemFileName) {
		this.imagemFileName = imagemFileName;
	}
	public String getImagemUrl() {
		return imagemUrl;
	}
	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}
	
}
