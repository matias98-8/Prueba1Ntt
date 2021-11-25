package com.Pagina.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Pagina.models.Venta;

public interface VentaRepository extends CrudRepository<Venta, Long> {

	
	List<Venta> findAll();
}
