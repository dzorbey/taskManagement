package org.example.entities;


import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "TaskType")
public class TaskType extends AbstractEntityCustom {

	private static final long serialVersionUID = 7943343031168377562L;
}