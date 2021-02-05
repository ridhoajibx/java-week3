package com.glints.onlinestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glints.onlinestore.model.Product;
import com.glints.onlinestore.payload.ProductPayload;
import com.glints.onlinestore.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/product")
	public ResponseEntity<List<Product>> read(){
		List<Product> products = productService.read();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@PostMapping("/create-product")
	public ResponseEntity<Product> create(@RequestBody ProductPayload productPayload){
		Product product = productService.create(productPayload);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@PostMapping("/update-product/{id}")
	public ResponseEntity<Product> create(@PathVariable("id") Integer id, @RequestBody ProductPayload productPayload){
		Product product = productService.update(id, productPayload);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-product/{id}")
	public String delete(@PathVariable("id") Integer id) {
		productService.delete(id);
		return "Product with id: " + id + " has been deleted!";
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> readById(@PathVariable("id") Integer id){
		Product product = productService.readById(id);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
}
