package br.com.residencia.biblioteca.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.biblioteca.dto.EditoraDTO;
import br.com.residencia.biblioteca.entity.Editora;
import br.com.residencia.biblioteca.repository.EditoraRepository;

@Service
public class EditoraService {
	@Autowired
	EditoraRepository editoraRepository;
	
	public List<Editora> getAllEditoras(){
		return editoraRepository.findAll();
	}
	
	public List<EditoraDTO> getAllEditorasDTO(){
		return editoraRepository.findAll().stream().map(EditoraDTO::new).collect(Collectors.toList());
	}
	
	public Editora getEditoraById(int id) {
		return editoraRepository.findById(id).orElse(null);
	}
	
	public Editora saveEditora(Editora editora) {
		return editoraRepository.save(editora);
	}
	
	public EditoraDTO saveEditoraDTO(EditoraDTO editoraDTO) {
		
		Editora editora = new Editora(editoraDTO);
		return new EditoraDTO(editoraRepository.save(editora)); 
	}
		
	
	
	public Editora updateEditora(Editora editora, int id) {
		Editora editoraExistenteNoBanco = getEditoraById(id);
		
		editoraExistenteNoBanco.setNome(editora.getNome());
		
		return editoraRepository.save(editoraExistenteNoBanco);
	}
	
	public Editora deleteEditora(int id) {
		editoraRepository.deleteById(id);
		return getEditoraById(id);
	}
	
	
}
