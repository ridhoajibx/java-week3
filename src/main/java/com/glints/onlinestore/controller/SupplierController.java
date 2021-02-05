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

import com.glints.onlinestore.model.Supplier;
import com.glints.onlinestore.payload.SupplierPayload;
import com.glints.onlinestore.service.SupplierService;

@RestController
@RequestMapping("/api")
public class SupplierController {

	@Autowired
	SupplierService supplierService;
	
	@GetMapping("/supplier")
	public ResponseEntity<List<Supplier>> read(){
		List<Supplier> suppliers = supplierService.read();
		return new ResponseEntity<List<Supplier>>(suppliers, HttpStatus.OK);
	}
	
	@PostMapping("/create-supplier")
	public ResponseEntity<Supplier> create(@RequestBody SupplierPayload supplierPayload){
		Supplier supplier = supplierService.create(supplierPayload);
		return new ResponseEntity<Supplier>(supplier, HttpStatus.OK);
	}	
	
	@PostMapping("/update-supplier/{id}")
	public ResponseEntity<Supplier> update(@PathVariable("id") Integer id, @RequestBody SupplierPayload supplierPayload){
		Supplier supplier = supplierService.update(id, supplierPayload);
		return new ResponseEntity<Supplier>(supplier, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-supplier/{id}")
	public String delete(@PathVariable("id") Integer id) {
		supplierService.delete(id);
		return "Supplier with id: " + id + " has been deleted!";
	}
	@GetMapping("/supplier/{id}")
	public ResponseEntity<Supplier> readById(@PathVariable("id") Integer id){
		Supplier supplier = supplierService.readById(id);
		return new ResponseEntity<Supplier>(supplier, HttpStatus.OK);
	}
	
}
