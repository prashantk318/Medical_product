package com.prashant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prashant.model.Product;
import com.prashant.repo.ProductRepository;
import com.prashant.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;;
	@Override
	public List<Product> getProducts() {
	
		return repo.findAll();
	}

	@Override
	public Product saveproduct(Product theProduct) {
		return repo.save(theProduct);
	}

	@Override
	public Product getProduct(Integer theId) {
		
		return repo.findById(theId).get();
	}

	@Override
	public void deleteProduct(Integer theid) {
		repo.deleteById(theid);
		
	}

	

}
