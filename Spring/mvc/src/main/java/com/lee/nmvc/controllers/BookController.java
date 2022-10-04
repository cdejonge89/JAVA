package com.lee.nmvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lee.nmvc.models.Book;
import com.lee.nmvc.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	// --------- 	DETAIL FOR ONE --------
	@GetMapping("/books/{bookId}")
	public String displayBooks(
			@PathVariable("bookId") Long bookId,
			Model model) {
		Book book = bookService.findBook(bookId);
		model.addAttribute("book", book);
		return "home.jsp";
	}
	
	// ---------- ALL BOOKS ---------------
	@GetMapping("/books")
	public String displayBooks(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "display.jsp";
	}
	
	//----------- CREATE FORM (binding) ---------------
	// 1. SHOW THE FORM
	@GetMapping("books/new")
	public String showCreateForm(Model model) {
		Book emptyBook = new Book();
		model.addAttribute("newBook", emptyBook);
		return "createBookBinding.jsp";
		
	}
	
	// 2. PROCESS THE FORM
	@PostMapping("/books/new")
	public String prcoessBindingCreateForm(
			@Valid @ModelAttribute("newBook") Book book,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "createBookBinding.jsp";
		} else {
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
}
