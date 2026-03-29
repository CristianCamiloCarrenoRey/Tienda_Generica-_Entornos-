package uis.edu.entorno.tienda.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class ResponseExceptionHandler  extends ResponseEntityExceptionHandler{
	private static final Logger logger= LoggerFactory.getLogger(ResponseExceptionHandler.class);
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse>manjarTodasExcepciones(Exception e){
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(),
				"OCURRIO UN ERROR",
				e.getMessage()
				
				);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid( MethodArgumentNotValidException ex,HttpHeaders headers,HttpStatusCode status,
	        WebRequest request) {

	    // Recorre todos los errores y los mete en el Map
	    Map<String, String> errores = new HashMap<>();
	    ex.getBindingResult().getFieldErrors()
	        .forEach(error -> errores.put(
	            error.getField(),        // clave = nombre del campo
	            error.getDefaultMessage() // valor = mensaje de error
	        ));

	    ExceptionResponse response = new ExceptionResponse(
	        new Date(),
	        "Error de validación",
	        request.getDescription(false),
	        errores
	    );

	    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}