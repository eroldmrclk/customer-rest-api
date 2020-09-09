package spring.boot.example.springboot2.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.example.springboot2.DependencyInjectionControl;
import spring.boot.example.springboot2.entity.Customer;
import spring.boot.example.springboot2.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {
	
//  bu programla alakasız not:
//	başkasından bir jar aldık güzel methodlar var ama dokunamıyoruz koda 
//	bunu @Bean ile bean haline çevirip kendi projemize @Autowired edebiliyoruz.
//	@Bean("dependencyInjection")
//	public DependencyInjectionControl dIc() {
//		return new DependencyInjectionControl();
//	}
//	
//	@Autowired
//	@Qualifier("dependencyInjection")
//	DependencyInjectionControl dIc;
	
	@Autowired
	CustomerService customerService;
	
	
	@GetMapping("/all")
	public Iterable<Customer> findAll() {
        return customerService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Customer> findById(@PathVariable("id") long id) {
		return customerService.findById(id);
	}
	
	@PostMapping("/save")
	public Customer save(final @RequestBody @Valid Customer customer) {
		customerService.save(customer);
		return customer;
	}
	
	@DeleteMapping("/delete")
	public Customer delete(@RequestParam @Valid long id) {
		return customerService.delete(id);
	}
	
	@PutMapping("/updateall/{id}")// tüm özellikleri update ederken kullanıyoruz.
	  Customer replaceEmployee(@RequestBody Customer customer, @PathVariable Long id) {
		return customerService.updateAll(customer, id);
	 }
	
	@PatchMapping("/update")// sadece bir properties değişiyorsa patch, tümüyle ele alınıyorsa put.
	public Customer update(@RequestBody @Valid Customer customer) {
		return customerService.update(customer);
	}
	
}
