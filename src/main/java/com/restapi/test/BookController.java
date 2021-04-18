package com.restapi.test;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.test.entities.Book;
import com.restapi.test.services.BookService;






@RestController
public class BookController {
	//@RequestMapping(value="/books",method=RequestMethod.GET)
	@Autowired
	private BookService bookService;
	@GetMapping("/books")
	public List<Book> getBooks()
	{
	
		return bookService.getAllBook();
		
	}
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getByID(@PathVariable("id") int id)
	{
		Book book=bookService.getByID(id);
		if(book==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(book));
		
	}
	
	@PostMapping("/addbooks")
	public ResponseEntity addBook(@RequestBody  Book book)
	{
		try {
			
		
		Book b=bookService.addBook(book);
		
		return ResponseEntity.of(Optional.of(b));
		}
		catch(Exception e)
		{e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/deletebook/{bookId}")
	public String  deletebookbyid(@PathVariable("bookId") int bookId)
	{
		bookService.deleteBook(bookId);
		return "deleted";
		
		
	}
	
	
	@PutMapping("updatebood/{bookId}")
	public ResponseEntity updatedBook(@RequestBody Book book,@PathVariable("bookId") int bookId)
	{
		try
		{
			
		bookService.updatedBook(book,bookId);
		return ResponseEntity.ok().body(book);
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
	
}
