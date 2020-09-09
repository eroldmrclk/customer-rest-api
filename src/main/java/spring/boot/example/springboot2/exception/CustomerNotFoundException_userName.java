package spring.boot.example.springboot2.exception;

public class CustomerNotFoundException_userName extends RuntimeException {
	public CustomerNotFoundException_userName(String username){
		super("Could not found customer: "+username);
	}
}
