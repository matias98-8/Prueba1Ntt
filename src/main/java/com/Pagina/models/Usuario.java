package com.Pagina.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="usuarios")
public class Usuario {
 
	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String email;
	private String password;
	@Transient
	private String passwordConfirmation;
	
	public Usuario() {
		super();
	}

	public Usuario(String nombre, String email, String password) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
