package com.MBASE.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MBASE.model.Book;




@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
List<Book> findByBookCode(int BookCode);

public Book findByYear(int Year);
	
Book findByBookName(String BookName);

}
