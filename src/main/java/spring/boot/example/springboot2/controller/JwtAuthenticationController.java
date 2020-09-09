package spring.boot.example.springboot2.controller;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.example.springboot2.service.JwtUserDetailsService;
import spring.boot.example.springboot2.config.JwtTokenUtil;
import spring.boot.example.springboot2.model.JwtRequest;
import spring.boot.example.springboot2.model.JwtResponse;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class JwtAuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody @Valid JwtRequest authenticationRequest) throws Exception {
		System.out.println(authenticationRequest.getUsername()+" aaaa "+authenticationRequest.getPassword());
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		System.out.println(authenticationRequest.getUsername()+" aaaa "+authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		System.out.println(authenticationRequest.getUsername()+" aaaa "+authenticationRequest.getPassword());
		final String token = jwtTokenUtil.generateToken(userDetails);
		System.out.println(new JwtResponse(token).getToken());
		System.out.println(authenticationRequest.getUsername()+" aaaa "+authenticationRequest.getPassword());
		ResponseEntity<JwtResponse> x = ResponseEntity.ok(new JwtResponse(token));
		System.out.println(x.getBody().getToken());
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}