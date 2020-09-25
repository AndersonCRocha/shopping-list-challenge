package com.dartdigital.recruitment.services;

import com.dartdigital.recruitment.entities.Products;
import com.dartdigital.recruitment.entities.ShoppingLists;
import com.dartdigital.recruitment.exceptions.ProductNotFoundException;
import com.dartdigital.recruitment.exceptions.ShoppingListNotFoundException;

public interface ShoppingListsService {

	/**
	 * Searches the database for a shopping list, throws an exception if it does not exist
	 * @param id
	 * @return {@link ShoppingLists}
	 * @throws ProductNotFoundException
	 */
	ShoppingLists findAndVerificate(Long id) throws ShoppingListNotFoundException;
	
	/**
	 * Creates a shopping list in database
	 * @param product
	 * @return {@link ShoppingLists}
	 */
	ShoppingLists create(ShoppingLists shoppingList);

	/**
	 * Adds a shopping list item
	 * @param shoppingListId
	 * @param product
	 * @return {@link ShoppingLists}
	 */
	ShoppingLists addItem(Long shoppingListId, Products product);
	

	/**
	 * Remove a shopping list item
	 * @param productId
	 * @return ShoppingLists
	 */
	ShoppingLists removeItem(Long shoppingListId, Long productId);
	
	/**
	 * Clears the shopping list
	 * @param id
	 * @return ShoppingLists
	 */
	ShoppingLists clear(Long id);

}