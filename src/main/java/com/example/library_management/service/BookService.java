package com.example.library_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.library_management.model.Book;
import com.example.library_management.repository.BookRepository;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public Book serviceAddBook(Book book){
        return bookRepository.save(book);
    }

    @Transactional(readOnly=true)
    public List<Book> serviceGetAllBook(){
        return bookRepository.findAll();
    }
    
}
