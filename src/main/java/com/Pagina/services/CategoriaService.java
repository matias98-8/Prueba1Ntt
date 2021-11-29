package com.Pagina.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Pagina.models.Categoria;
import com.Pagina.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	
	
	 	@Autowired
	 	CategoriaRepository categoriaRepository;

	 	
	 	public void insertarCategoria(@Valid Categoria categoria) {
			categoriaRepository.save(categoria);
		}
	 	
	 	public List<Categoria> obtenerListaCategorias() {
			
			return  categoriaRepository.findAll();
		}

		public Categoria buscarCategoriaId(Long id) {
			
			return categoriaRepository.findById(id).get();
		}

		public void eliminarCategoria(Long id) {
			categoriaRepository.deleteById(id);
		}
		

		public void eliminarCategoriaObjeto(Categoria categoria) {
			categoriaRepository.delete(categoria);
			
		}
		
		//save
		public void updateCategoria(@Valid Categoria categoria) {
			if(categoriaRepository.existsById(categoria.getId())){
				categoriaRepository.save(categoria);
			}		
		}
	 	
	 	
}