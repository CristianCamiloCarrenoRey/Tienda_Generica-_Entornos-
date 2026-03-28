package uis.edu.entorno.tienda.modelo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name=Usuario.TABLE_NAME)

public class Usuario {
	public static final String TABLE_NAME ="usuario";
	
	@Id // id para identificar la llave primaria 
	@GeneratedValue(strategy = GenerationType.IDENTITY)//  aca se define el autoincremental 
	private Long id;
	
	@ManyToOne  // relacion Muchos  uno para este caso (muchos usuarios peuden teenr un tipo de doc)
	@JoinColumn(name="idTipoDocumento")// aca se referencia la llave foranea
	private Tipodocumento idTipoDocumento;
	
	// columnas de la tabla
	
	@Column(name= "numeroDocumento")
	private String numeroDocumento;
	
	@Column(name= "email")
	private String email;
	
	@Column(name= "nombre")
	private String nombre;
	
	@Column(name= "password")
	private String password;
	
	@Column(name= "nombreUsuario")
	private String nombreUsuario;
	
	
	
	// constructor 

	public Usuario() {
		super();
	}



	public Usuario(Long id, Tipodocumento idTipoDocumento, String numeroDocumento, String email, String nombre,
			String password, String nombreUsuario) {
		super();
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