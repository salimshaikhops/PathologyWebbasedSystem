package com.restapi.test.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="authors")
public class Author {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int AuthorId;
	private String AuthorName;
	private String title;
	@OneToOne(mappedBy="author")
	@JsonBackReference
	private Book book;
	public int getAuthorId() {
		return AuthorId;
	}
	public void setAuthorId(int authorId) {
		
<<<<<<< HEAD
		sdfsfdfdf
=======
		sddddd
>>>>>>> cff58dfe78f67a9ba67685cbe7efc40571dd90f2
		AuthorId = authorId;
	}
	public String getAuthorName() {
		return AuthorName;
	}
	public void setAuthorName(String authorName) {
		AuthorName = authorName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Author(int authorId, String authorName, String title) {
		super();
		AuthorId = authorId;
		AuthorName = authorName;
		this.title = title;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
