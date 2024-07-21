package com.example.library_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library_management.model.BookDetails;

public interface BookDetailsRepository extends JpaRepository<BookDetails,Long> {
    
}
