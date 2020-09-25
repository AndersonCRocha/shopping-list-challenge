package com.dartdigital.recruitment.services;

import java.util.List;

import com.dartdigital.recruitment.entities.Products;
import com.dartdigital.recruitment.entities.ShoppingLists;
import com.dartdigital.recruitment.exceptions.ProductNotFoundException;

public interface ProductsService {

	/**
	 * Searches the database for a product, throws an exception if it does not exist
	 * @param id
	 * @return {@link Products}
	 * @throws ProductNotFoundException
	 */
	Products findAndVerificate(Long id) throws ProductNotFoundException;
	
	/**
	 * Creates a new item
	 * @param product
	 * @return {@link Products}
	 */
	Products save(Products product);
	
	/**
	 * Marks as checked the item in shopping list
	 * @param id
	 * @return {@link Products}
	 */
	Products check(Long id);
	
	/**
	 * Deletes an item from the shopping list
	 * @param id
	 */
	void delete(Long id);
	
	/**
	 * Deletes all shopping list items
	 * @param shoppingList
	 */
	void deleteByShoppingList(ShoppingLists shoppingList);

	/**
	 * Return a list of products
	 * @param name
	 * @return {@link List<Products>}
	 */
	List<Products> searchByNameAndCategor(String name, Long categoryId);

	/**
	 * Updates product items quantity
	 * @param id
	 * @param quantity
	 * @return Products
	 */
	Products updateQuantity(Long id, Integer quantity);
	
}