package uis.edu.entorno.tienda.exception;

import java.util.Date;
import java.util.Map;

public class ExceptionResponse {
	private Date timestamp;
	private String mensaje;
	private String detalles;
	private Map<String, String > erroresValidaciones;
	
	
	public ExceptionResponse() {
		
	}





	public ExceptionResponse(Date timestamp, String mensaje, String detalles) {
		super();
		this.timestamp = timestamp;
		this.mensaje = mensaje;
		this.detalles = detalles;
	}





	public ExceptionResponse(Date timestamp, String mensaje, String detalles, Map<String, String> erroresValidaciones) {
		super();
		this.timestamp = timestamp;
		this.mensaje = mensaje;
		this.detalles = detalles;
		this.erroresValidaciones = erroresValidaciones;
	}




	

	public Map<String, String> getErroresValidaciones() {
		return erroresValidaciones;
	}





	public void setErroresValidaciones(Map<String, String> erroresValidaciones) {
		this.erroresValidaciones = erroresValidaciones;
	}





	public Date getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public String getDetalles() {
		return detalles;
	}


	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	
}
