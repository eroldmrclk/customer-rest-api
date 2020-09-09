package spring.boot.example.springboot2.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.example.springboot2.entity.Customer;
import spring.boot.example.springboot2.exception.CustomerNotFoundException;
import spring.boot.example.springboot2.exception.CustomerNotFoundException_userName;
import spring.boot.example.springboot2.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
    private final Logger log = LoggerFactory.getLogger(this.getClass()); 
	
	public Iterable<Customer> findAll() {
		log.info("All customers were listed.");
        return customerRepository.findAll();
	}
	
	public Optional<Customer> findById(long id) {
		Optional<Customer> customer = Optional.ofNullable(customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id)));
//		if(!customer.isPresent()) {
//			log.info("Any customer not found for listing!");
//			throw new IllegalArgumentException("I cannot find "+id);
//		}
		log.info("Customer id: "+id+" was listed.");
		return customer;
	}
	
	public Customer save(Customer customer) {
		log.info("A customer was saved.");
		return customerRepository.save(customer);
	}
	
	public Customer delete(long id) {
		Optional<Customer> customer = this.findById(id);
		if(!customer.isPresent()) {
			log.info("Any customer not found for deleting!");
			throw new IllegalArgumentException("This is already deleted!");
		}
		customerRepository.deleteById(id);
		log.info("Customer id: "+id+" was deleted.");
		return customer.get();
	}
	
	
	public Customer updateAll (Customer customer, Long id) {
		 return customerRepository.findById(customer.getId())
			      .map(updatedCustomer -> {
			        updatedCustomer.setFirstName(customer.getFirstName());
			        updatedCustomer.setLastName(customer.getLastName());
			        return customerRepository.save(updatedCustomer);
			      })
			      .orElseGet(() -> {
			        customer.setId(id);
			        return customerRepository.save(customer);
			      });
	}
	
	public Customer update(Customer customer) {
		Optional<Customer> customerChanged = this.findById(customer.getId()); // is there a customer like that???
		log.info("A customer that id: "+customer.getId()+" was updated.");
		return customerRepository.save(customer);
	}
	
	public Optional<Customer> findByUsername(String username) {
		
		Optional<Customer> customer = Optional.ofNullable(customerRepository.findByUserName(username)).orElseThrow(() -> new CustomerNotFoundException_userName(username));
//		if(!customer.isPresent()) {
//			log.info("Any customer not found for listing!");
//			throw new IllegalArgumentException("I cannot find "+id);
//		}
		return customer;
	}
	
}
