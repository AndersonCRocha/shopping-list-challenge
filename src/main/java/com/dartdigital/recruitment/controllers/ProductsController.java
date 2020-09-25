package com.dartdigital.recruitment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dartdigital.recruitment.entities.Products;
import com.dartdigital.recruitment.services.ProductsService;

@RestController
@RequestMapping("products")
public class ProductsController {

	@Autowired
	private ProductsService productsService;

	@GetMapping("search")
	public ResponseEntity<List<Products>> searchByName(@RequestParam String name, @RequestParam Long categoryId) {
		return ResponseEntity.ok(productsService.searchByNameAndCategor(name, categoryId));
	}
	
	@PutMapping("{id}/update-quantity")
	public ResponseEntity<Products> updateQuantity(@PathVariable Long id, @RequestParam Integer quantity) {
		return ResponseEntity.ok(productsService.updateQuantity(id, quantity));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Void> checkItem(@PathVariable Long id) {
		productsService.check(id);
		return ResponseEntity.ok().build();
	}
	
}