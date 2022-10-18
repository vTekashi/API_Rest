package br.com.residencia.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.biblioteca.dto.EmprestimoDTO;
import br.com.residencia.biblioteca.entity.Emprestimo;
import br.com.residencia.biblioteca.repository.EmprestimoRepository;

@Service
public class EmprestimoService {
	@Autowired
	EmprestimoRepository emprestimoRepository;
	
	public List<Emprestimo> getAllEmprestimos(){
		return emprestimoRepository.findAll();
	}
	
	public Emprestimo getEmprestimoById(int id) {
		return emprestimoRepository.findById(id).get();
	}
	
	public Emprestimo saveEmprestimo(Emprestimo emprestimo) {
		return emprestimoRepository.save(emprestimo);
	}
	
	public Emprestimo updateEmprestimo(Emprestimo emprestimo, int id) {
		Emprestimo emprestimoExistenteNoBanco = getEmprestimoById(id);
		
		emprestimoExistenteNoBanco.setDataEmprestimo(emprestimo.getDataEmprestimo());
		emprestimoExistenteNoBanco.setDataEntrega(emprestimo.getDataEntrega());
		emprestimoExistenteNoBanco.setValorEmprestimo(emprestimo.getValorEmprestimo());
		emprestimoExistenteNoBanco.setLivro(emprestimo.getLivro());
		emprestimoExistenteNoBanco.setAlunos(emprestimo.getAlunos());
		
		return emprestimoRepository.save(emprestimoExistenteNoBanco);
	}
	
	
	public Emprestimo toEntidade (EmprestimoDTO emprestimoDTO) {
		Emprestimo emprestimo = new Emprestimo();
		
		
		emprestimo.setDataEmprestimo(emprestimoDTO.getDataEmprestimo());
		emprestimo.setDataEntrega(emprestimoDTO.getDataEntrega());
		emprestimo.setValorEmprestimo(emprestimoDTO.getValorEmprestimo());		
		
		return emprestimo;
	}
	
	public EmprestimoDTO toDTO(Emprestimo emprestimo) {
		EmprestimoDTO emprestimoDTO = new EmprestimoDTO();
		
		emprestimoDTO.setDataEmprestimo(emprestimo.getDataEmprestimo());
		emprestimoDTO.setDataEntrega(emprestimo.getDataEntrega());
		emprestimoDTO.setValorEmprestimo(emprestimo.getValorEmprestimo());	
		emprestimoDTO.setCodigoEmprestimo(emprestimo.getCodigoEmprestimo());
		
		return emprestimoDTO;
	}
	
	public Emprestimo deleteEmprestimo(int id) {
		emprestimoRepository.deleteById(id);
		return getEmprestimoById(id);
	}
}
