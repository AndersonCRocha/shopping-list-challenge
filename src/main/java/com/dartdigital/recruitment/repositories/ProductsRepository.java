package com.dartdigital.recruitment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dartdigital.recruitment.entities.Products;
import com.dartdigital.recruitment.entities.ShoppingLists;

public interface ProductsRepository extends JpaRepository<Products, Long> {

	public void deleteByShoppingList(ShoppingLists shoppingList);
	
}