package com.Pagina.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Pagina.models.Usuario;
import com.Pagina.models.Venta;
import com.Pagina.repositories.VentaRepository;



@Service
public class VentaService {
	@Autowired
	VentaRepository ventaRepository;

	public void insertarVenta(@Valid Venta venta) {
		ventaRepository.save(venta);
	}
	
	public List<Venta> obtenerListaVentas() {
		
		return  ventaRepository.findAll();
	}
	
	public Venta buscarVentaId(Long id) {
		
		return ventaRepository.findById(id).get();
	}
	
	public void eliminarVenta(Long id) {
		ventaRepository.deleteById(id);
	}
	
	public void eliminarVentaObjeto(Venta venta) {
		ventaRepository.delete(venta);
		
	}
	
	public void updateVenta(@Valid Venta venta) {
		if(ventaRepository.existsById(venta.getId())){
			ventaRepository.save(venta);
		}		
	}
	
	
}
