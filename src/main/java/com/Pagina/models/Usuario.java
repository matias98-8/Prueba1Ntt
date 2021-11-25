package com.Pagina.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
 
	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String Apellido;
	private Integer edad;
	
	
	public Usuario() {
		super();
	}


	public Usuario(String nombre, String apellido, Integer edad) {
		super();
		this.nombre = nombre;
		Apellido = apellido;
		this.edad = edad;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return Apellido;
	}


	public void setApellido(String apellido) {
		Apellido = apellido;
	}


	public Integer getEdad() {
		return edad;
	}


	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
