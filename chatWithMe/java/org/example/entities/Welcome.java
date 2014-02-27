package org.example.entities;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "welcome")
public class Welcome extends AbstractEntityCustom {

	private static final long serialVersionUID = 3692783533098753237L;
}
