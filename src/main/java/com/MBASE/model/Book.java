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
    private int BookCode;

    @NotBlank
    @Size(min=5, max = 50, message="BookName should have atleast 5 characters")
    private String BookName;
    
    @NotBlank
    @Size(min=10, max = 50, message="Author Name should have atleast 10 characters")
    private String Author;
    
    @NotBlank
    @Size(min=4, max = 4, message="Enter a valid Year")
    private int Year;

	public int getBookCode() {
		return BookCode;
	}

	public void setBookCode(int bookCode) {
		BookCode = bookCode;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}
    

}
