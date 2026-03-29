package uis.edu.entorno.tienda.modelo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name=Usuario.TABLE_NAME)

public class Usuario {
	public static final String TABLE_NAME ="usuario";
	
	@Id // id para identificar la llave primaria 
	@GeneratedValue(strategy = GenerationType.IDENTITY)//  aca se define el autoincremental 
	private Long id;
	@NotNull(message = "El Tipo de documento es obligatorio")
	@ManyToOne  // relacion Muchos  uno para este caso (muchos usuarios peuden teenr un tipo de doc)
	@JoinColumn(name="idTipoDocumento")// aca se referencia la llave foranea
	private Tipodocumento idTipoDocumento;
	
	// columnas de la tabla
	
	@NotBlank(message = "El número de documento no puede estar vacío")
	@Column(name = "numeroDocumento", nullable = false, length = 40)
	private String numeroDocumento;

	@NotBlank(message = "El email no puede estar vacío")
	@Email(message = "El email no es válido")
	@Column(name = "email", nullable = false, length = 255)
	private String email;

	@NotBlank(message = "El nombre no puede estar vacío")
	@Column(name = "nombre", nullable = false, length = 255)
	private String nombre;

	@NotBlank(message = "La contraseña no puede estar vacía")
	@Size(min = 6, message = "La contraseña debe tener mínimo 6 caracteres")
	@Column(name = "password", nullable = false, length = 255)
	private String password;

	@NotBlank(message = "El nombre de usuario no puede estar vacío")
	@Column(name = "nombreUsuario", nullable = false, length = 255)
	private String nombreUsuario;
	
	
	
	// constructor 

	public Usuario() {
		
	}



	public Usuario(Long id, Tipodocumento idTipoDocumento, String numeroDocumento, String email, String nombre,
			String password, String nombreUsuario) {
		
		this.id = id;
		this.idTipoDocumento = idTipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.email = email;
		this.nombre = nombre;
		this.password = password;
		this.nombreUsuario = nombreUsuario;
	}

	// Getters and Sedders

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Tipodocumento getIdTipoDocumento() {
		return idTipoDocumento;
	}



	public void setIdTipoDocumento(Tipodocumento idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}



	public String getNumeroDocumento() {
		return numeroDocumento;
	}



	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getNombreUsuario() {
		return nombreUsuario;
	}



	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}



	public static String getTableName() {
		return TABLE_NAME;
	}
	
	
	
	
	
	
	

	
	
	
	

} 