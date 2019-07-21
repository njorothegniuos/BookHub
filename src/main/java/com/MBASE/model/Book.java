package com.MBASE.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "books", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "BookCode"
        }),
       
})
public class Book {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int bookCode;

    @NotBlank
    @Size(min=5, max = 50, message="BookName should have atleast 5 characters")
    private String bookName;
    
    @NotBlank
    @Size(min=10, max = 50, message="Author Name should have atleast 10 characters")
    private String author;
    
    private int year;

	public int getBookCode() {
		return bookCode;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
    
	public String tosString() {
		return "A book by the name: " +bookName + " written by : " + author +" published in: " +year;
	}

}
