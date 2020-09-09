package spring.boot.example.springboot2.exception;

public class CustomerNotFoundException extends RuntimeException {
	public CustomerNotFoundException(long id){
		super("Could not found customer: "+id);
	}
}
