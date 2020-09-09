package spring.boot.example.springboot2.exception;

public class RoleNotFoundException extends RuntimeException {
	public RoleNotFoundException(String role){
		super("Could not found customer: "+role);
	}
}
