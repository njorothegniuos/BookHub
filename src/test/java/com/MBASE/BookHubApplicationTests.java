package com.MBASE;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.MBASE.model.Book;
import com.MBASE.repository.BookRepository;
import com.MBASE.services.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookHubApplicationTests {
	
	@InjectMocks
	private BookService bs;
	
	@Mock
	BookRepository repo;
	
	private static final int bookCode = 1;

	@Test
	public void getPersonTest() {
		bs.getBook(bookCode);
		verify(repo).getOne(bookCode);
	}
	
	@Test
	public void getAllTest() {
		bs.getAll();
		verify(repo).findAll();
	}
	
	@Test
	public void saveTest() {
		Book b = mock(Book.class);
		bs.create(b);
		verify(repo).save(b);
	}
	

	@Test
	public void contextLoads() {
	}

}
