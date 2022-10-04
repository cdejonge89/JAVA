package com.lee.nmvc.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.lee.nmvc.models.Book;
import com.lee.nmvc.repositories.BookRepository;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    
    // find one
    public Book oneBook(Long id) {
    	Optional<Book> optionalBook = bookRepository.findById(id);
    	if(optionalBook.isPresent()) {
    		return optionalBook.get();
    	} else {
    		return null;
    	}
    }
    
    // update a book
    public Book editBook(Book updatedBook) {
    	return bookRepository.save(updatedBook);
    }
    
    // delete a book
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
    
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
}
