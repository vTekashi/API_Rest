package br.com.residencia.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.residencia.biblioteca.dto.LivroDTO;
import br.com.residencia.biblioteca.entity.Livro;
import br.com.residencia.biblioteca.repository.LivroRepository;

@Service
public class LivroService {
		@Autowired
		LivroRepository livroRepository;
		
		public List<Livro> getAllLivros(){
			return livroRepository.findAll();
		}
		
		public Livro getLivroById(int id) {
			return livroRepository.findById(id).get();
			//return livroRepository.findById(id).orElse(null);
		}
		
		public Livro saveLivro(Livro livro) {
			return livroRepository.save(livro);
		}
		
		public LivroDTO saveLivroDTO(LivroDTO livroDTO) {
			Livro livro = toEntidade(livroDTO);
			Livro novoLivro = livroRepository.save(livro);
			
			LivroDTO livroAtualizadoDTO = toDTO(novoLivro);
			return livroAtualizadoDTO;
		}
		
		public Livro updateLivro(Livro livro, int id) {
			Livro livroExistenteNoBanco = getLivroById(id);
			
			livroExistenteNoBanco.setNomeLivro(livro.getNomeLivro());
			livroExistenteNoBanco.setNomeAutor(livro.getNomeAutor());
			livroExistenteNoBanco.setDataLancamento(livro.getDataLancamento());
			livroExistenteNoBanco.setCodigoIsbn(livro.getCodigoIsbn());
			
			return livroRepository.save(livroExistenteNoBanco);
		}
		
		public LivroDTO updateLivroDTO(LivroDTO livroDTO, int id) {
			Livro livroExistenteNoBanco = getLivroById(id);
			LivroDTO livroAtualizadaDTO = new LivroDTO();
			
			
			if(livroExistenteNoBanco != null){
				
				livroExistenteNoBanco = toEntidade(livroDTO);
				
				//livroExistenteNoBanco.setNome(LivroDTO.getNome());
				
				
				Livro livroAtualizada = livroRepository.save(livroExistenteNoBanco);
				
				livroAtualizadaDTO = toDTO(livroAtualizada);
				
				//livroAtualizadaDTO.setCodigoLivro(livroAtualizada.getCodigoLivro());
				//livroAtualizadaDTO.setNome(livroAtualizada.getNome());
			}
			return livroAtualizadaDTO;
		}
		
		public Livro toEntidade (LivroDTO livroDTO) {
			Livro livro = new Livro();
			livro.setNomeLivro(livroDTO.getNomeLivro());
			livro.setNomeAutor(livroDTO.getNomeAutor());
			livro.setDataLancamento(livroDTO.getDataLancamento());
			livro.setCodigoIsbn(livroDTO.getCodigoIsbn());
			return livro;
		}
		
		public LivroDTO toDTO(Livro livro) {
			LivroDTO livroDTO = new LivroDTO();
			
			livroDTO.setCodigoLivro(livro.getCodigoLivro());
			livroDTO.setNomeLivro(livro.getNomeLivro());
			livroDTO.setNomeAutor(livro.getNomeAutor());
			livroDTO.setDataLancamento(livro.getDataLancamento());
			livroDTO.setCodigoIsbn(livro.getCodigoIsbn());
			
			return livroDTO;
		}
		
		public Livro deleteLivro(int id) {
			livroRepository.deleteById(id);
			return getLivroById(id);
		}
}
