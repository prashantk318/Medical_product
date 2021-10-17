package com.prashant.controller;

import java.net.URI;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prashant.exception.ProductNotFoundException;
import com.prashant.model.Product;
import com.prashant.service.ProductService;




@RestController
@CrossOrigin
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/products")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Product> retrieveAllProducts(){
		return service.getProducts();
	}
	
	
	
	@GetMapping("/products/{theId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Product retriveProducts(@PathVariable Integer theId) {
		Product theProduct = service.getProduct(theId);
		
		if(theProduct== null) {
			throw new ProductNotFoundException("Id -" + theId);
			}
		
		return theProduct;
	}
	
	@PostMapping("/products")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Product> createProduct( @RequestBody Product theProduct) {
		
		Product savedProduct = service.saveproduct(theProduct);
		
	
		URI location = ServletUriComponentsBuilder
				 .fromCurrentRequest()
				 .path("/{theId}")
				 .buildAndExpand(savedProduct.getId())
				 .toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/products/{theId}")
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable Integer theId) {
		
		Product theProduct = service.getProduct(theId);
		if (theProduct == null) {
			throw new ProductNotFoundException("id_"+theId);
		}
		service.deleteProduct(theId);
	}

	@PutMapping("/products/{theId}")
	@CrossOrigin(origins = "http://localhost:4200")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(@PathVariable Integer theId,@RequestBody Product theProduct) {
        Product savedProduct = service.getProduct(theId);
        
        savedProduct.setId(theId);
        savedProduct.setName(theProduct.getName());
        savedProduct.setBrand(theProduct.getBrand());
        savedProduct.setPrice(theProduct.getPrice());
        savedProduct.setQuantity(theProduct.getQuantity());
        service.saveproduct(savedProduct);
        
    }
	

}
