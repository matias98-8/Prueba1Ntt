package com.Pagina.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Pagina.models.Producto;



@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long>{

	List<Producto> findAll();
}
