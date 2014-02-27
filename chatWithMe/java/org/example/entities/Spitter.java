package org.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "spitter")
public class Spitter extends AbstractEntityCustom {

	private static final long serialVersionUID = 3692783533098753237L;
	
	private String deneme;
	
	@Column(name="Deneme")
	public String getDeneme() {
		return deneme;
	}

	public void setDeneme(String deneme) {
		this.deneme = deneme;
	}
	
	
	
}