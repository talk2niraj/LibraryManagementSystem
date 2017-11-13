package com.ctrip.lms.models;

import java.util.List;

public class Book {
	private long bookId;
	private String title;
	private List<Author> authors;

	public Book(String title) {
		super();
		this.title = title;
	}
	
	public Book(long bookId, String title, List<Author> authors) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.authors = authors;
	}
	public long getBookId() {
		return bookId;
	}
	public String getTitle() {
		return title;
	}
	public List<Author> getAuthors() {
		return authors;
	}
}
