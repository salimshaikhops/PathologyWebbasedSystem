package com.restapi.test.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.test.entities.Book;
import com.restapi.test.repository.BookRepository;

@Service
public class BookService {
	
	/*  fake data
	 * private static List<Book> list=new ArrayList<>();
	 * 
	 * static { list.add(new Book(1,"pythin","salim")); list.add(new
	 * Book(2,"java","Alam ")); list.add(new Book(3,"pythin","sanju")); list.add(new
	 * Book(4,"cpp","rama")); }
	 */
	@Autowired
	private BookRepository bookRepository;
	
	
	public List<Book> getAllBook()
	{	List<Book> list=(List<Book>) bookRepository.findAll();
		return list;
	}
	
	public Book getByID(int id)
	{
		Book book=null;
		try
		{
			//book= list.stream().filter(e->e.getId()==id).findFirst().get();
			book=bookRepository.findById(id);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return book; 
	}
			
	public Book addBook(Book b)
	{
		//list.add(b);
		Book result= bookRepository.save(b);
		return result;
	}
	public void  deleteBook(int bookId)
	{
		
		
		//list=list.stream().filter(book ->book.getId()!=bookId).collect(Collectors.toList());
		
		
		/*
		 * list=list.stream().filter(book ->{ if(book.getId() !=bookId) { return true; }
		 * else { return false; } }).collect(Collectors.toList());
		 */
		/*
		 * list=list.stream().filter(book ->book.getId()!=bookId).collect(Collectors.toList());
		 * 
		 * 
		 */
		
		
		bookRepository.deleteById(bookId);
		
	}
	
	public void updatedBook(Book bo,int bookId)
	{/*
		 * list=list.stream().map(b -> { if(b.getId()==bo.getId()) {
		 * b.setAuthor(bo.getAuthor()); b.setName(bo.getName()); } return b;
		 * }).collect(Collectors.toList());
		 */
		
		bo.setId(bookId);
		bookRepository.save(bo);
		
		
		
		
		
	}
		
	
	
	
}
