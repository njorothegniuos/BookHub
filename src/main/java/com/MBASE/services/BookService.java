package com.MBASE.services;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MBASE.model.Book;
import com.MBASE.repository.BookRepository;




@Service
public class BookService {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	private BookRepository bookRepository;
	
	//create operation
	public Book create(Book b) {
		return bookRepository.save(b);
		
	}
	
	//retrieve operation
	
		public List<Book> getAll(){
			return bookRepository.findAll();
		}
		
		public Book getByFirstName(String bookName) {
			return bookRepository.findByBookName(bookName);
		}
		
		//update operation
		public Book update(Book bk) {
			Book k = bookRepository.getOne(bk.getBookCode());
			k.setBookName(bk.getBookName());
			k.setAuthor(bk.getAuthor());
			k.setYear(bk.getYear());
			return bookRepository.save(k);
		}
		//delete operation
		public void deleteAll() {
			bookRepository.deleteAll();
		}
		public void delete(int bookCode) {
			Book p = bookRepository.getOne(bookCode);
			bookRepository.delete(p);
		}
		
		public Book getBook(int bookCode) {
				return bookRepository.getOne(bookCode);

		}
		

}
