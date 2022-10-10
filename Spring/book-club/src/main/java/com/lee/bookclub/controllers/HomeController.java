package com.lee.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.lee.bookclub.models.Book;
import com.lee.bookclub.services.BookService;

@Controller
public class HomeController {
	@Autowired
	private BookService bookService;
	
	// all books table
	@GetMapping("/books")
	public String booksPage(HttpSession session, Model model) {
		// this line redirects to logout as set in UserController if user is not logged in
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		model.addAttribute("bookList", bookService.allBooks());
		return "booksPage.jsp";
	}
	
	//ADD A BOOK
	//show the form
	@GetMapping("/books/new")
	public String createBook(
			@ModelAttribute("newBook") Book newBook, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		return "newBook.jsp";
	}
	//process the form
	@PostMapping("/new/books")
	public String processBook(
			@Valid @ModelAttribute("newBook") Book book,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "newBook.jsp";
		} else {
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
	
	//DETAILS - FIND ONE
	@GetMapping("/books/{id}")
	public String bookDetails(@PathVariable("id") Long id, Model model, HttpSession session) {
		Book book = bookService.oneBook(id);
		model.addAttribute("book", book);
		model.addAttribute("bookList", bookService.allBooks());
		return "details.jsp";
	}
	
	//EDIT
	@GetMapping("/books/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model, HttpSession session) {
		// this line doesn't let you get to edit page without being logged in
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		Book book = bookService.oneBook(id);
		model.addAttribute("book", book);
		// this line doesn't let you edit someone elses book
		if(book.getBook().getId() != (Long) session.getAttribute("userId")) {
			return "redirect:/books";
		}
		return "editBook.jsp";
	}
	@PutMapping("/books/edit/{id}")
	public String processBook(
			@Valid @ModelAttribute("book") Book book,
			BindingResult result) {
		if(result.hasErrors()) {
			return "editBook.jsp";
		} else {
			bookService.editBook(book);
			return "redirect:/books";
		}
	}
	
	//DELETE
	@DeleteMapping("/donations/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return "redirect:/books";
	}
}
