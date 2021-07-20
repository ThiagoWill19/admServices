package com.thiagowill.admServices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagowill.admServices.entities.Product;
import com.thiagowill.admServices.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product findById(int id) {
		return productRepository.findById(id).get(); 
	}
	
	public void save(Product product) {
		productRepository.save(product);
	}
	
	public void deleteById(int id) {
		productRepository.deleteById(id);
	}
}
