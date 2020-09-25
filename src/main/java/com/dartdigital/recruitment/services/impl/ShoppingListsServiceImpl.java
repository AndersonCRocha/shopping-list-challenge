package com.dartdigital.recruitment.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dartdigital.recruitment.entities.Products;
import com.dartdigital.recruitment.entities.ShoppingLists;
import com.dartdigital.recruitment.exceptions.InvalidQuantityException;
import com.dartdigital.recruitment.exceptions.ShoppingListNotFoundException;
import com.dartdigital.recruitment.repositories.ShoppingListsRepository;
import com.dartdigital.recruitment.services.ProductsService;
import com.dartdigital.recruitment.services.ShoppingListsService;

@Service
public class ShoppingListsServiceImpl implements ShoppingListsService {

	@Autowired
	private ShoppingListsRepository shoppingListsRepository;
	@Autowired
	private ProductsService productsService;
	
	@Override
	public ShoppingLists findAndVerificate(Long id) throws ShoppingListNotFoundException {
		Optional<ShoppingLists> shoppingListOptional = shoppingListsRepository.findById(id);
		return shoppingListOptional
				.orElseThrow(() -> new ShoppingListNotFoundException("Shopping list not found for id: "+id));
	}
	
	@Override
	public ShoppingLists create(ShoppingLists shoppingList) {
		shoppingList.getProducts().forEach(product -> {
			if(!product.isQuantityValid()) {
				throw new InvalidQuantityException();
			}
		});
		return shoppingListsRepository.save(shoppingList);
	}

	@Override
	public ShoppingLists addItem(Long shoppingListId, Products product) {
		ShoppingLists shoppingList = findAndVerificate(shoppingListId);
		product.setShoppingList(shoppingList);
		productsService.save(product);
		shoppingList.addItem(product);
		return shoppingList;
	}

	@Override
	public ShoppingLists removeItem(Long shoppingListId, Long productId) {
		ShoppingLists shoppingList = findAndVerificate(shoppingListId);
		productsService.deleteByShoppingList(shoppingList);
		shoppingList.removeItem(productId);
		return shoppingList;
	}

	@Override
	public ShoppingLists clear(Long id) {
		ShoppingLists shoppingList = findAndVerificate(id);
		productsService.deleteByShoppingList(shoppingList);
		shoppingList.clear();
		return shoppingList;
	}

}