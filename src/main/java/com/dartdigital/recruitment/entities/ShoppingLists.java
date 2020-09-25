package com.dartdigital.recruitment.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

@Entity
public class ShoppingLists {

	private Long id;
	private LocalDateTime createdAt;
	private List<Products> products;
	
	public ShoppingLists() {
		this.products = new ArrayList<Products>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "shopping_list_id")
	public List<Products> getProducts() {
		return products;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public void addItem(Products product) {
		this.products.add(product);
	}
	
	public void removeItem(Long productId) {
		this.products = this.products.stream().filter(product -> !product.getId().equals(productId))
				.collect(Collectors.toList());
	}
	
	public void clear() {
		this.products = new ArrayList<Products>();
	}
	
	@PrePersist
	public void prePersist() {
		this.createdAt = LocalDateTime.now();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ShoppingLists)) {
			return false;
		}
		ShoppingLists other = (ShoppingLists) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "ShoppingLists [id=" + id + ", createdAt=" + createdAt + ", products=" + products + "]";
	}

}