package spring.boot.example.springboot2.model;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



public class JwtResponse implements Serializable {
	private static final long serialVersionUID = -8091879091924046844L;
	private String jwttoken;
	
	public JwtResponse()
	{
	}
	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}
	
	public String getToken() {
		return this.jwttoken;
	}
}