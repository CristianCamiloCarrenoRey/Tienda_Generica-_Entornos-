package uis.edu.entorno.tienda.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name=Proveedor.TABLE_NAME)

public class Proveedor {
	
	public static final String TABLE_NAME ="proveedor";
	
	@Id // llave priamria 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //
	private Long id;
	
	@Column(name = "ciudad", length = 255)
	private String ciudad;

	@Column(name = "direccion", length = 255)
	private String direccion;

	@NotBlank(message = "El nombre del proveedor no puede estar vacío")
	@Column(name = "nombre", nullable = false, length = 255)
	private String nombre;
	
	@Size(min = 8, max = 10, message = "el Numero esta incompleto")
	@Column(name = "telefono", length = 15)
	private String telefono;

	@NotBlank(message = "El NIT no puede estar vacío")
	@Size(min = 9, max = 10, message = "El NIT esta imcompleto")
	@Column(name = "nit", nullable = false, length = 100)
	private String nit;
	// constructor
	public Proveedor() {
		
	}

	public Proveedor(Long id, String ciudad, String direccion, String nombre, String telefono, String nit) {
		
		this.id = id;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.nombre = nombre;
		this.telefono = telefono;
		this.nit = nit;
	}

	
	// getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}


	
	
	
	
	

}
