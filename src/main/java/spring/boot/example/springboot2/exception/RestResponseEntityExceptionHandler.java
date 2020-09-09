package spring.boot.example.springboot2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
 
//    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
//    protected ResponseEntity<ErrorDescription> handleConflict(RuntimeException ex, WebRequest request) {
//    	ErrorDescription bodyOfResponse = new ErrorDescription();
//    	bodyOfResponse.setCode(1200);
//    	bodyOfResponse.setMessage(ex.getMessage());
//        return new ResponseEntity<ErrorDescription>(bodyOfResponse,HttpStatus.CONFLICT);
//    }
	
  @ExceptionHandler(value = {Exception.class})
  protected ResponseEntity<ErrorDescription> handleConflict(Exception ex, WebRequest request) {
  	ErrorDescription bodyOfResponse = new ErrorDescription();
  	bodyOfResponse.setCode(1200);
  	bodyOfResponse.setMessage(ex.getMessage());
      return new ResponseEntity<ErrorDescription>(bodyOfResponse,HttpStatus.CONFLICT);
  }
}