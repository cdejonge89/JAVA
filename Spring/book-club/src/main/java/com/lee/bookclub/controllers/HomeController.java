package com.lee.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lee.bookclub.models.Book;
import com.lee.bookclub.services.BookService;

@Controller
public class HomeController {
	@Autowired
	private BookService bookService;
	
	// all books table
	@GetMapping("/books")
	public String booksPage(HttpSession session, Model model) {
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
			@ModelAttribute("newBook") Book newBook) {
		return "newBook.jsp";
	}
	//process the form
	@PostMapping("/books/new")
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
	@GetMapping("/books/details/{id}")
	public String bookDetails(@PathVariable("id") Long id, Model model, HttpSession session) {
		Book book = bookService.oneBook(id);
		model.addAttribute("book", book);
		model.addAttribute("bookList", bookService.allBooks());
		return "details.jsp";
	}
	
}
