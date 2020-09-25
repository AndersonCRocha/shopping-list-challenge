package com.dartdigital.recruitment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dartdigital.recruitment.dto.Categories;
import com.dartdigital.recruitment.utils.TacoApi;

@RestController
@RequestMapping("categories")
public class CategoriesController {

	@Autowired
	private TacoApi tacoApi;
	
	@GetMapping
	public List<Categories> list() {
		return tacoApi.getCategories();
	}
	
}