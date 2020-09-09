package spring.boot.example.springboot2.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
    @Column(nullable = false)
    @NotEmpty
	private String role;
    
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List <Customer> customers;
	
    public Role(String role) {
    	this.role = role;
    }
    
	public Role() {	}	
	
	@Override
    public String getAuthority() {
        return role;
    }
	
}
