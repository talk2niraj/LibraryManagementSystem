package com.ctrip.lms.service;

import com.ctrip.lms.dao.BookDAO;
import com.ctrip.lms.dao.impl.BookDAOImpl;
import com.ctrip.lms.exception.LBSException;
import com.ctrip.lms.models.Book;
import com.ctrip.lms.models.User;
import com.ctrip.lms.validator.Validator;

public class BookService {
	private static final int CAP = 2;
	BookDAO bookDAO = new BookDAOImpl();
	public boolean addBook(Book book) throws LBSException {
		if (Validator.catchInvalidBook(book)) {
			throw new LBSException("Invalid book information. Cannot be added.");
		}
		
		return bookDAO.addBook(book);
	}
	
	public boolean lendBook(String bookTitle, User user) {
		if (bookDAO.booksTakenCountForTheUser(user) >= CAP) {
			
			System.out.println("User has reached the " + CAP);
			return false;
		}
		
		Book book = bookDAO.searchBookByTitle(bookTitle);

		if (book == null) {
			return false;
		}
		bookDAO.addEntryInOutBook(book, user);
		bookDAO.updateBooksTakenCountForTheUser(user);
		return true;
	}
	
	public boolean returnBook(String bookTitle, User user) {
		Book book = bookDAO.searchBookByTitle(bookTitle);
		if (book != null) {
			bookDAO.removeEntryFromOutBook(book, user);
			//bookDAO.updateBooksTakenCountForTheUser(user);
			return true;
		}
		return false;
	}

	public Book searchBookByTitle(String bookTitle) {
		return bookDAO.searchBookByTitle(bookTitle);
	}

	public boolean searchBookByAuthor(String authorName) {
		// TODO Auto-generated method stub
		return bookDAO.searchBookByAuthor(authorName) > -1;
	}
}
