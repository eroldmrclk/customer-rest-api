package spring.boot.example.springboot2.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.boot.example.springboot2.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
	Optional<Role> findByRole(String role);
}
