package spring.boot.example.springboot2.service;

import java.util.HashMap;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.example.springboot2.entity.Role;
import spring.boot.example.springboot2.exception.RoleNotFoundException;
import spring.boot.example.springboot2.repository.RoleRepository;
@Service
public class RoleService {
	
	@Autowired
	RoleRepository roleRepository;

	private final Logger log = LoggerFactory.getLogger(this.getClass()); 

	
	public Iterable<Role> findAll(){
		log.info("All roles were listed.");
		return roleRepository.findAll();
	}
	
	public Optional<Role> findByRoleName(String role) {
		Optional<Role> Role = Optional.ofNullable(roleRepository.findByRole(role).orElseThrow(() -> new RoleNotFoundException(role)));
		return Role;
	}
	
	public HashMap<Role, Integer> save(String role) {
		HashMap<Role, Integer> roles = new HashMap();
		if(!this.findByRoleName(role).isPresent()) {
			roles.put(new Role(role), 1);
		}
		return roles;
	}
	
	public Role delete(int id) {
		Optional<Role> Role = roleRepository.findById(id);
		if(!Role.isPresent()) {
			log.info("Any role not found for deleting!");
			throw new IllegalArgumentException("This is already deleted!");
		}
		roleRepository.deleteById(id);
		log.info("Role name: "+id+" was deleted.");
		return Role.get();
	}
}
