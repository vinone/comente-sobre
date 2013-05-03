package br.com.vinone.comentesobre.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue
	private Long Id;
	
	@NotNull
	private String email;
	
	protected Autor(){}
	
	public Autor(String email){
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
