package com.dartdigital.recruitment.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dartdigital.recruitment.entities.Products;
import com.dartdigital.recruitment.entities.ShoppingLists;
import com.dartdigital.recruitment.exceptions.InvalidQuantityException;
import com.dartdigital.recruitment.exceptions.ProductNotFoundException;
import com.dartdigital.recruitment.repositories.ProductsRepository;
import com.dartdigital.recruitment.services.ProductsService;
import com.dartdigital.recruitment.utils.TacoApi;

@Service
public class ProductsServiceImpl implements ProductsService {

	@Autowired
	private ProductsRepository productsRepository;
	@Autowired
	private TacoApi tacoApi;

	@Override
	public Products findAndVerificate(Long id) throws ProductNotFoundException {
		Optional<Products> productOptional = productsRepository.findById(id);
		return productOptional.orElseThrow(() -> new ProductNotFoundException("Product not found for id: " + id));
	}

	@Override
	public Products save(Products product) {
		if(!product.isQuantityValid()) {
			throw new InvalidQuantityException();
		}
		return productsRepository.save(product);
	}

	@Override
	public Products check(Long id) {
		Products product = findAndVerificate(id);
		product.setChecked(Boolean.TRUE);
		return productsRepository.save(product);
	}

	@Override
	public void delete(Long id) {
		productsRepository.delete(findAndVerificate(id));
	}

	@Override
	@Transactional
	public void deleteByShoppingList(ShoppingLists shoppingList) {
		productsRepository.deleteByShoppingList(shoppingList);
	}

	@Override
	public List<Products> searchByNameAndCategor(String name, Long categoryId) {
		return tacoApi.getProducts(categoryId).parallelStream()
				.filter(food -> food.getDescription().toUpperCase().contains(name.toUpperCase()))
				.map(food -> new Products(food.getDescription())).collect(Collectors.toList());
	}

	@Override
	public Products updateQuantity(Long id, Integer quantity) {
		Products product = findAndVerificate(id);
		product.setQuantity(quantity);
		return save(product);
	}

}