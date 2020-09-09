package spring.boot.example.springboot2.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import spring.boot.example.springboot2.entity.Customer;
import spring.boot.example.springboot2.service.CustomerService;

@AllArgsConstructor
@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	CustomerService customerService;
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> byUsername = customerService.findByUsername(username);

        return byUsername.orElseThrow(() -> new UsernameNotFoundException("Kullanıcı Bulunamadı"));
    }
}