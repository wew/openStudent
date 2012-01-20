package ca.openstudent.auth;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
	
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Id private Long id;  
	public Long getId() {
		return this.id;
	}

	// Further getters and setters omitted
	public boolean isNew() {
		return null == this.id;
	}
}