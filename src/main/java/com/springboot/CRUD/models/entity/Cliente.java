package com.springboot.CRUD.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "clientes")//cambia el nombre de la tabla
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//genera el id automaticamente
	private Long id;

	@NotEmpty//valida que no sea vacio
	private String nombre;
	
	@NotEmpty//valida que no sea vacio
	private String apellido;
	
	@NotEmpty//valida que no sea vacio
	@Email
	private String email;

	@NotNull//valida que no sea nulo
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)//se usa para que se guarde la fecha y la hora
	@DateTimeFormat(pattern="yyyy-MM-dd")//formato de la fecha año-mes-dia
	private Date createAt;

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;//serializa los objetos para que se puedan enviar por la red en bytes

}
