package com.glints.onlinestore.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.glints.onlinestore.exception.BadRequestException;
import com.glints.onlinestore.model.Sale;
import com.glints.onlinestore.payload.SalePayload;
import com.glints.onlinestore.service.SaleService;

@RestController
@RequestMapping("/api")
public class SaleController {
	@Autowired
	SaleService saleService;
	
	@GetMapping("/sale")
	public ResponseEntity<List<Sale>> read(){
		List<Sale> sales = saleService.read();
		return new ResponseEntity<List<Sale>>(sales, HttpStatus.OK);
	}
	
	@PostMapping("/create-sale")
	public ResponseEntity<Sale> create(@Valid @RequestBody SalePayload salePayload){
		Sale sale = saleService.create(salePayload);
		return new ResponseEntity<Sale>(sale, HttpStatus.OK);
	}
	
	@PostMapping("/update-sale/{id}")
	public ResponseEntity<Sale> update(@PathVariable("id") Integer id,@Valid @RequestBody SalePayload salePayload) throws BadRequestException{
		Sale sale; 
		try {			
			sale = saleService.update(id, salePayload);
		} catch (BadRequestException e) {
			throw new BadRequestException(e.getMessage());
		}
		return new ResponseEntity<Sale>(sale, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-sale/{id}")
	public String delete(@PathVariable("id") Integer id) {
		saleService.delete(id);
		return "Transaction with id: " + id + " has been deleted!";
	}
	
	@GetMapping("/sale/{id}")
	public ResponseEntity<Sale> readById(@PathVariable("id") Integer id){
		Sale sale = saleService.readById(id);
		return new ResponseEntity<Sale>(sale, HttpStatus.OK);
	}
}
