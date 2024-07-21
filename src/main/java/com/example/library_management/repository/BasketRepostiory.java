package com.example.library_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library_management.model.Basket;

public interface BasketRepostiory extends JpaRepository<Basket,Long> {
    
}
