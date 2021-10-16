package com.prashant.service;

import java.util.List;

import com.prashant.model.Product;



public interface ProductService {
	  public List<Product> getProducts();
	    public Product saveproduct(Product theProduct);
	    public Product getProduct(Integer theId);
	    public void deleteProduct(Integer theid);
	    
	  

}
