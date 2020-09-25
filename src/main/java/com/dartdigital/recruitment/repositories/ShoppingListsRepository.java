package com.dartdigital.recruitment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dartdigital.recruitment.entities.ShoppingLists;

public interface ShoppingListsRepository extends JpaRepository<ShoppingLists, Long> {

}