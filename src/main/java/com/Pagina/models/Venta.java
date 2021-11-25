package com.Pagina.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="ventas")
public class Venta {

	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String comprador;
	private Integer codigo;
	
	
	public Venta() {
		super();
	}


	public Venta(String comprador, Integer codigo) {
		super();
		this.comprador = comprador;
		this.codigo = codigo;
	}


	


	public String getComprador() {
		return comprador;
	}


	public void setComprador(String comprador) {
		this.comprador = comprador;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
}
