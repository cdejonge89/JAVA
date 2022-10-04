package com.lee.nmvc.controllers;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lee.nmvc.models.Book;
import com.lee.nmvc.services.BookService;

@RestController
public class BooksApi {
    private final BookService bookService;
    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }
    
    
    @RequestMapping("/api/books")
    public List<Book> index() {
        return bookService.allBooks();
    }
    
    // create
    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public Book create(
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang, 
    		@RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }
    
    //find one
    @GetMapping("/api/books/{id}")
    public Book renderOneBook(@PathVariable("id") Long id) {
    	return bookService.oneBook(id);
    }
    
    // update - find one + create
    @PutMapping("/api/books/{id}")
    public Book editBookProcess(@PathVariable("id") Long id,
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang, 
    		@RequestParam(value="pages") Integer numOfPages) {
    	Book foundBook = bookService.oneBook(id);
    	foundBook.setTitle(title);
    	foundBook.setDescription(desc);
    	foundBook.setLanguage(lang);
    	foundBook.setNumberOfPages(numOfPages);
    	return bookService.editBook(foundBook);
    	}
    
    // delete
    @DeleteMapping(value="/api/books/{id}")
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
    
    //find all
    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        return book;
    }

}
