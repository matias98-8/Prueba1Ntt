package com.Pagina.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Pagina.models.CategoriaProducto;
import com.Pagina.repositories.CategoriaProductoRepository;

@Service
public class CategoriaProductoService {
	@Autowired
	CategoriaProductoRepository categoriaproductoRepository;
	
	
	public List<CategoriaProducto> obtenerListaCategoriaProductos() {
		
		return  categoriaproductoRepository.findAll();
	}
	
	
	public List<CategoriaProducto> obtenerCategoriaProductoCategoriaWhereId(Long id){
		return categoriaproductoRepository.obtenerCategoriaProductoCategoriaWhereId(id);
	}
	
	
}
