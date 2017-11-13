package com.ctrip.lms.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ctrip.lms.dao.BookDAO;
import com.ctrip.lms.models.Author;
import com.ctrip.lms.models.Book;
import com.ctrip.lms.models.User;

public class BookDAOImpl implements BookDAO {
	private final static List<Book> BOOK_STORE = new ArrayList<Book>();
	private final static Map<Long, Book> BOOK_OUT_REGISTER = new HashMap<Long, Book>();

	public boolean addBook(Book book) {
//		if (BOOK_STORE.contains(book)) {
//			System.out.println("Book details already exists.");
//		}
		boolean added = BOOK_STORE.add(book);
		System.out.println(BOOK_STORE.size());
		return added;
	}

	@Override
	public Book addEntryInOutBook(Book book, User user) {
		return BOOK_OUT_REGISTER.put(user.getUserId(), book);
	}
	
	@Override
	public Book searchBookByTitle(String bookTitle) {
		for (Book book : BOOK_STORE) {
			if (bookTitle.equalsIgnoreCase(book.getTitle())) {
				return book;
			}
		}
		return null;
	}

	@Override
	public int searchBookByAuthor(String authorName) {
		int index = -1;
		int i = 0;
		for (Book book : BOOK_STORE) {
			i++;
			for (Author author : book.getAuthors()) {
				if (authorName.equalsIgnoreCase(author.getAutherName())) {
					index = i;
					break;
				}
			}
		}
		return index;
	}

	@Override
	public Book removeEntryFromOutBook(Book book, User user){
		return BOOK_OUT_REGISTER.remove((user.getUserId()));
	}

	@Override
	public int booksTakenCountForTheUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBooksTakenCountForTheUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
