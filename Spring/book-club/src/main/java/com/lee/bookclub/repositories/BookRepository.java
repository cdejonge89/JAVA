package com.lee.bookclub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lee.bookclub.models.Book;
import com.lee.bookclub.models.User;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	List<Book> findAll();
	

}
