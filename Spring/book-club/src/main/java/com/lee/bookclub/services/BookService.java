package com.lee.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.bookclub.models.Book;
import com.lee.bookclub.models.User;
import com.lee.bookclub.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;
	
	// CREATE
	public Book createBook(Book newBook) {
		return bookRepo.save(newBook);
	}
	
	//FIND ALL
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	
	//FIND ONE
	public Book oneBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	//EDIT
	public Book editBook(Book book) {
		return bookRepo.save(book);
	}
	
	//DELETE
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	

}
