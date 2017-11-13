package com.ctrip.lms.dao;

import com.ctrip.lms.models.Book;
import com.ctrip.lms.models.User;

public interface BookDAO {
	
	public boolean addBook(Book book);

	public int searchBookByAuthor(String authorName);

	public Book searchBookByTitle(String bookTitle);
	
	public Book addEntryInOutBook(Book book, User user);

	public Book removeEntryFromOutBook(Book book, User user);

	public int booksTakenCountForTheUser(User user);
	
	public int updateBooksTakenCountForTheUser(User user);

}
