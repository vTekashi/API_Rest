package br.com.residencia.biblioteca.dto;

import java.time.Instant;

public class EmprestimoAlunoDTO {
	private int codigoEmprestimo;
	private Instant dataEmprestimo;
	private Instant dataEntrega;
	
	public int getCodigoEmprestimo() {
		return codigoEmprestimo;
	}
	public void setCodigoEmprestimo(int codigoEmprestimo) {
		this.codigoEmprestimo = codigoEmprestimo;
	}
	public Instant getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Instant dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Instant getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(Instant dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	
}
