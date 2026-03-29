package uis.edu.entorno.tienda.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name=Tipodocumento.TABLE_NAME)

public class Tipodocumento {
	public static final String TABLE_NAME ="tipodocumento";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "El tipo de documento no puede estar vacío")
	@Column(name = "tipo", nullable = false, length = 50)
	private String tipo;


	//constructor 
	


	public Tipodocumento() {
		
	}
	
	public Tipodocumento(Long id, String tipo) {
		
		this.id = id;
		this.tipo = tipo;
	}
	
	

	// getters and setters 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	// getters and setters 
	

	
	
	
}
