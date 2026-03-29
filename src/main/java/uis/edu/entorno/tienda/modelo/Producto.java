package uis.edu.entorno.tienda.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name=Producto.TABLE_NAME)

public class Producto {
public static final String TABLE_NAME ="producto";
	
	@Id // id para identificar la llave primaria 
	@GeneratedValue(strategy = GenerationType.IDENTITY)//  aca se define el autoincremental 
	private Long id;
	
	@NotNull(message = "El proveedor es obligatorio")
	@ManyToOne  // relacion Muchos  uno para este caso (un proveedor peude "proveer " varios productos )
	@JoinColumn(name="idProveedor")// aca se referencia la llave foranea
	private Proveedor  idProveedor ;
	
	

	@NotNull(message = "El IVA es obligatorio")
	@Column(name = "ivaCompra", nullable = false)
	private Double ivaCompra;
	
	@NotBlank(message = "El nombre no puede estar vacío")
	@Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
	@Column(name = "nombre", nullable = false, length = 255)
	private String nombre;
	
	@NotNull(message = "El precio de compra es obligatorio")
	@Positive(message = "El precio de compra debe ser positivo")
	@Column(name = "precioCompra", nullable = false)
	private Double precioCompra;
	
	@NotNull(message = "El precio de venta es obligatorio")
	@Positive(message = "El precio de venta debe ser positivo")
	@Column(name = "precioVenta", nullable = false)
	private Double precioVenta;

	// constructor 
	public Producto() {
		
	}

	public Producto(Long id, Proveedor idProveedor, Double ivaCompra, String nombre, Double precioCompra,
			Double precioVenta) {
		
		this.id = id;
		this.idProveedor = idProveedor;
		this.ivaCompra = ivaCompra;
		this.nombre = nombre;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
	}

	//getter y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Proveedor getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Proveedor idProveedor) {
		this.idProveedor = idProveedor;
	}

	public Double getIvaCompra() {
		return ivaCompra;
	}

	public void setIvaCompra(Double ivaCompra) {
		this.ivaCompra = ivaCompra;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(Double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public Double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}

	
	
	

}
