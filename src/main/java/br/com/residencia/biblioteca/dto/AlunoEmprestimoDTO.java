package br.com.residencia.biblioteca.dto;

import java.util.List;

public class AlunoEmprestimoDTO {
	private int numeroMatriculaAluno;	
	private String nome;
	private String cpf;
	private List<EmprestimoAlunoDTO> listaEmprestimoResumoDTO;
	
	public int getNumeroMatriculaAluno() {
		return numeroMatriculaAluno;
	}
	public void setNumeroMatriculaAluno(int numeroMatriculaAluno) {
		this.numeroMatriculaAluno = numeroMatriculaAluno;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public List<EmprestimoAlunoDTO> getListaEmprestimoResumoDTO() {
		return listaEmprestimoResumoDTO;
	}
	public void setListaEmprestimoResumoDTO(List<EmprestimoAlunoDTO> listaEmprestimoResumoDTO) {
		this.listaEmprestimoResumoDTO = listaEmprestimoResumoDTO;
	}
	
}
