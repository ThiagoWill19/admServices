package com.thiagowill.admServices.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="client_has_product", joinColumns={@JoinColumn(name="client_id")},
	inverseJoinColumns= {@JoinColumn(name="product_id")})
	private List<Product> productList;

}
