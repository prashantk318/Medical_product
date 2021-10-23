package com.prashant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prashant.model.Product;
import com.prashant.repo.ProductRepository;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Order;




@SpringBootTest
class ExamAppApplicationTests {

	@Autowired
	ProductRepository repo;
	
	@Test
	@Order(2)
	public void createTest() {
		Product product = new Product();
		product.setId(9);
		product.setName("Pfizer");
		product.setBrand("Dispirin");
		product.setPrice(200);
		product.setQuantity(2);
		repo.save(product);
		assertNotNull(repo.findById(9).get());
	}
	

  @Test
  @Order(2) 
  public void testReadAll () { List list = repo.findAll();
  assertThat(list).size().isGreaterThan(0); }
  
  @Test
  @Order(3)
  public void testRead () {
	  Product product = repo.findById(8).get();
  assertEquals("Pfizer", product.getName()); }
  
  @Test
  @Order(4)
  public void testUpdate () {
	  Product p = repo.findById(7).get();
  p.setPrice(300); repo.save(p); 
  assertNotEquals(200,
  repo.findById(7).get().getPrice()); }
 
	
  @Test
  @Order(5)
  public void testDelete () { 
 repo.deleteById(5);
  assertThat(repo.existsById(5)).isFalse(); } 
  }
 



