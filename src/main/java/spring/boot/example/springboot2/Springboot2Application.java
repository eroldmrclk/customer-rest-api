package spring.boot.example.springboot2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import spring.boot.example.springboot2.entity.Customer;
import spring.boot.example.springboot2.entity.Role;
import spring.boot.example.springboot2.repository.CustomerRepository;
import spring.boot.example.springboot2.repository.RoleRepository;


@SpringBootApplication
public class Springboot2Application {
	@Autowired
	RoleRepository roleRepository;
	
	 @Bean
	    PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	public static void main(String[] args) {
		SpringApplication.run(Springboot2Application.class, args);
		
	}
	
	
	@Bean
	  CommandLineRunner initDatabase(CustomerRepository repository) {

//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//		String hashedPassword = bCryptPasswordEncoder.encode("dmrclk");
//		List<Role> roles = new ArrayList<>();
//		roleRepository.save(new Role("ADMIN"));
//		roleRepository.save(new Role("USER"));
		
		// 1-ADMIN
		// 2-USER
//		Customer customer = new Customer("Erol", "Demirçelik", "erol", hashedPassword);
//		List<Role> customer1Role = new ArrayList();
//		customer1Role.add(roleRepository.findById(1).get());
//		customer1Role.add(roleRepository.findById(2).get());
//		customer1.setRoles(customer1Role);
//		repository.save(customer1);
		
		return null;
	  }
}
