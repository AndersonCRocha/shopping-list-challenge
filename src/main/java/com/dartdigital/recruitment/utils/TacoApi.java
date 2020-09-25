package com.dartdigital.recruitment.utils;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dartdigital.recruitment.dto.Categories;
import com.dartdigital.recruitment.dto.Foods;

@FeignClient(name = "tacoApi", url = "${taco.api.url}")
public interface TacoApi {

	@GetMapping("category")
	List<Categories> getCategories();

	@GetMapping("category/{categoryId}/food")
	List<Foods> getProducts(@RequestParam("categoryId") Long categoryId);

}