package com.Pagina.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {

	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String descripcion;
	private Integer precio;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name="categorias_productos",//tabla intermedia
		joinColumns = @JoinColumn(name="producto_id"),
		inverseJoinColumns = @JoinColumn(name="categoria_id")
	)
	private List<Categoria> categorias;
	
	
	
	public Producto() {
		super();
	}


	public Producto(String nombre, String descripcion, Integer precio) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Integer getPrecio() {
		return precio;
	}


	public void setPrecio(Integer precio) {
		this.precio = precio;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	public List<Categoria> getCategorias() {
		return categorias;
	}


	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
}
