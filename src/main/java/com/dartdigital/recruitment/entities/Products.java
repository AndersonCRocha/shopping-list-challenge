package com.dartdigital.recruitment.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Products {

	private Long id;
	private String name;
	private Integer quantity;
	private Boolean checked = Boolean.FALSE;
	private ShoppingLists shoppingList;

	public Products() {
	}

	public Products(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Boolean getChecked() {
		return checked;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	public ShoppingLists getShoppingList() {
		return shoppingList;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public void setShoppingList(ShoppingLists shoppingList) {
		this.shoppingList = shoppingList;
	}

	public boolean isQuantityValid() {
		return this.quantity > 0;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Products)) {
			return false;
		}
		Products other = (Products) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", quantity=" + quantity + "]";
	}

}