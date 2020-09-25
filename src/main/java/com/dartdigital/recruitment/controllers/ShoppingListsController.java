package com.dartdigital.recruitment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.dartdigital.recruitment.entities.Products;
import com.dartdigital.recruitment.entities.ShoppingLists;
import com.dartdigital.recruitment.services.ShoppingListsService;

@RestController
@RequestMapping("shopping-lists")
public class ShoppingListsController {

	@Autowired
	private ShoppingListsService shoppingListsService;

	@GetMapping("/{id}")
	public ResponseEntity<ShoppingLists> show(@PathVariable Long id) {
		return ResponseEntity.ok(shoppingListsService.findAndVerificate(id));
	}

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody ShoppingLists shoppingList) {
		shoppingListsService.create(shoppingList);
		return ResponseEntity.created(UriComponentsBuilder.fromPath("shopping-lists/{id}")
				.buildAndExpand(shoppingList.getId()).toUri()).build();
	}
	
	@PostMapping("{id}/add-item")
	public ResponseEntity<ShoppingLists> addItem(@PathVariable Long id, @RequestBody Products product) {
		return ResponseEntity.ok(shoppingListsService.addItem(id, product));
	}

	@DeleteMapping("{shoppingListId}/remove-item/{itemId}")
	public ResponseEntity<ShoppingLists> removeItem(@PathVariable Long shoppingListId, @PathVariable Long itemId) {
		return ResponseEntity.ok(shoppingListsService.removeItem(shoppingListId, itemId));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ShoppingLists> clear(@PathVariable Long id) {
		shoppingListsService.clear(id);
		return ResponseEntity.ok().build();
	}

}