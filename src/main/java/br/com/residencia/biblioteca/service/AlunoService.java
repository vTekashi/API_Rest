package br.com.residencia.biblioteca.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.biblioteca.dto.AlunoDTO;
import br.com.residencia.biblioteca.dto.AlunoEmprestimoDTO;
import br.com.residencia.biblioteca.dto.EmprestimoAlunoDTO;
import br.com.residencia.biblioteca.dto.EmprestimoDTO;
import br.com.residencia.biblioteca.entity.Aluno;
import br.com.residencia.biblioteca.entity.Emprestimo;
import br.com.residencia.biblioteca.repository.AlunoRepository;
import br.com.residencia.biblioteca.repository.EmprestimoRepository;

@Service
public class AlunoService {
	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	EmprestimoRepository emprestimoRepository;
	
	@Autowired
	EmprestimoService emprestimoService;
	

	
	public List<Aluno> getAllAlunos(){
		return alunoRepository.findAll();
	}
	
	public List<AlunoDTO> getAllAlunosDTO(){
		List<Aluno> listaAluno = alunoRepository.findAll();
		List<AlunoDTO> listaAlunoDTO = new ArrayList<>();
	
		
		for(Aluno aluno: listaAluno) {
			
			AlunoDTO alunoDTO = toDTO(aluno);
			
			listaAlunoDTO.add(alunoDTO);	
		}
		
		return listaAlunoDTO;		
		
	}
	
	public Aluno getAlunoById(int id) {
		//return alunoRepository.findById(id).get(); 
		return alunoRepository.findById(id).orElse(null);
	}
	
	public Aluno saveAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public AlunoDTO saveAlunoDTO(AlunoDTO alunoDTO) {
		Aluno aluno = toEntidade(alunoDTO);
		Aluno novoAluno = alunoRepository.save(aluno);
		
		AlunoDTO alunoAtualizadaDTO = toDTO(novoAluno);
		return alunoAtualizadaDTO;
	}
	
	public Aluno updateAluno(Aluno aluno, int id) {
		/*getAlunoById é o metodo de pegar aluno.*/
		Aluno alunoExistenteNoBanco = getAlunoById(id);
		
		alunoExistenteNoBanco.setBairro(aluno.getBairro());
		alunoExistenteNoBanco.setCidade(aluno.getCidade());
		alunoExistenteNoBanco.setComplemento(aluno.getComplemento());
		alunoExistenteNoBanco.setCpf(aluno.getCpf());
		alunoExistenteNoBanco.setDataNascimento(aluno.getDataNascimento());
		alunoExistenteNoBanco.setLogradouro(aluno.getLogradouro());
		alunoExistenteNoBanco.setNome(aluno.getNome());
		alunoExistenteNoBanco.setNumeroLogradouro(aluno.getNumeroLogradouro());
		
		return alunoRepository.save(alunoExistenteNoBanco);
	}
	
	public AlunoDTO updateAlunoDTO(AlunoDTO alunoDTO, int id) {
		Aluno alunoExistenteNoBanco = getAlunoById(id);
		AlunoDTO alunoAtualizadoDTO = new AlunoDTO();
		
		
		if(alunoExistenteNoBanco != null){
			
			alunoExistenteNoBanco = toEntidade(alunoDTO);
			
			//AlunoExistenteNoBanco.setNome(AlunoDTO.getNome());
			
			
			Aluno alunoAtualizado = alunoRepository.save(alunoExistenteNoBanco);
			
			alunoAtualizadoDTO = toDTO(alunoAtualizado);
			
			//AlunoAtualizadaDTO.setCodigoAluno(AlunoAtualizada.getCodigoAluno());
			//AlunoAtualizadaDTO.setNome(AlunoAtualizada.getNome());
		}
		return alunoAtualizadoDTO;
	}
	
	private Aluno toEntidade (AlunoDTO alunoDTO) {
		Aluno aluno = new Aluno();
		aluno.setNome(alunoDTO.getNome());
		
		aluno.setBairro(alunoDTO.getBairro());
		aluno.setCidade(alunoDTO.getCidade());
		aluno.setComplemento(alunoDTO.getComplemento());
		aluno.setCpf(alunoDTO.getCpf());
		aluno.setDataNascimento(alunoDTO.getDataNascimento());
		aluno.setLogradouro(alunoDTO.getLogradouro());
		aluno.setNome(alunoDTO.getNome());
		aluno.setNumeroLogradouro(alunoDTO.getNumeroLogradouro());
		
		
		return aluno;
	}
	
	private AlunoDTO toDTO(Aluno aluno) {
		AlunoDTO alunoDTO = new AlunoDTO();
		
		alunoDTO.setBairro(aluno.getBairro());
		alunoDTO.setCidade(aluno.getCidade());
		alunoDTO.setComplemento(aluno.getComplemento());
		alunoDTO.setCpf(aluno.getCpf());
		alunoDTO.setDataNascimento(aluno.getDataNascimento());
		alunoDTO.setLogradouro(aluno.getLogradouro());
		alunoDTO.setNome(aluno.getNome());
		alunoDTO.setNumeroLogradouro(aluno.getNumeroLogradouro());
		alunoDTO.setNumeroMatriculaAluno(aluno.getNumeroMatriculaAluno());
		
		return alunoDTO;
	}
	
	public Aluno deleteAluno(int id) {
		alunoRepository.deleteById(id); //DELETA
		return getAlunoById(id);  //PROCURA NO BANCO PARA VER SE DELETOU.
	}
	
	public List<AlunoDTO> getAllAlunosEmprestimosDTO(){
		List<Aluno> listaAluno = alunoRepository.findAll();
		List<AlunoDTO> listaAlunoDTO = new ArrayList<>();
	
		for(Aluno alunos: listaAluno) {
			AlunoDTO alunoDTO = toDTO(alunos);
			List<Emprestimo> listaEmprestimos = new ArrayList<>();
			List<EmprestimoDTO> listaEmprestimosDTO = new ArrayList<>();
		
			listaEmprestimos = emprestimoRepository.findByAlunos(alunos);
			
			for(Emprestimo emprestimo : listaEmprestimos) {
				EmprestimoDTO emprestimoDTO = emprestimoService.toDTO(emprestimo);
				listaEmprestimosDTO.add(emprestimoDTO);
			}
			alunoDTO.setListaEmprestimosDTO(listaEmprestimosDTO);
			
			listaAlunoDTO.add(alunoDTO);	
		}
		return listaAlunoDTO;	
	}
	
	public List<AlunoEmprestimoDTO> getAllAlunoEmprestimoResumoDTO(){
		List<Aluno> listaAluno = alunoRepository.findAll();
		List<AlunoEmprestimoDTO> listaAlunoEmprestimoDTO = new ArrayList<>();
	
		for(Aluno alunos: listaAluno) {
			AlunoEmprestimoDTO alunoEmprestimoDTO = toDTO2(alunos);
			List<Emprestimo> listaEmprestimos = new ArrayList<>();
			List<EmprestimoAlunoDTO> listaEmprestimoAlunoDTO = new ArrayList<>();
		
			listaEmprestimos = emprestimoRepository.findByAlunos(alunos);
			
			for(Emprestimo emprestimo : listaEmprestimos) {
				EmprestimoAlunoDTO emprestimoAlunoDTO = emprestimoService.toDTO2(emprestimo);
				listaEmprestimoAlunoDTO.add(emprestimoAlunoDTO);
			}
			alunoEmprestimoDTO.setListaEmprestimoResumoDTO(listaEmprestimoAlunoDTO);
			
			listaAlunoEmprestimoDTO.add(alunoEmprestimoDTO);	
		}
		return listaAlunoEmprestimoDTO;	
	}
	
	private AlunoEmprestimoDTO toDTO2(Aluno aluno) {
		AlunoEmprestimoDTO alunoEmprestimoDTO = new AlunoEmprestimoDTO();
		
		alunoEmprestimoDTO.setCpf(aluno.getCpf());
		alunoEmprestimoDTO.setNome(aluno.getNome());
		alunoEmprestimoDTO.setNumeroMatriculaAluno(aluno.getNumeroMatriculaAluno());
		
		return alunoEmprestimoDTO;
	}
	
	
}
