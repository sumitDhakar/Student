package com.student.been;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String studentAddress;
	private String studentNAme;
	private String email;
	private Boolean deleted = false;
		private String Password;
	
	private Role studentRole;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	   @JoinColumn(name="u_id")
@JsonManagedReference
@EqualsAndHashCode.Exclude
	   private Set<UserRoles> userRoles;
	


}
