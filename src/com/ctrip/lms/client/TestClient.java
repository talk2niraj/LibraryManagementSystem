package com.ctrip.lms.client;

import java.util.ArrayList;
import java.util.List;

import com.ctrip.lms.exception.LBSException;
import com.ctrip.lms.models.Author;
import com.ctrip.lms.models.Book;
import com.ctrip.lms.models.User;
import com.ctrip.lms.service.BookService;
import com.ctrip.lms.service.UserService;

public class TestClient {

	private static final int MAX_LOOP_COUNT = 4;

	public static void main(String[] args) throws LBSException {
		//TEST Data
		Author author = new Author(112233, "David Colt");
		List<Author> authors = new ArrayList<Author>();
		authors.add(author);
		Book awsEssentialsBook = new Book(12345, "AWS Essentials", authors);
//		Book awsBook = new Book(12345, "AWS Essentials", authors);
		Book awsBook = new Book("AWS Essentials");
		User niraj = new User("Niraj");
		
		for (int switchValue = 1; switchValue < MAX_LOOP_COUNT; switchValue++) {
			switch(switchValue) {
				case 1: 
					System.out.println("Attempting to add book: " + awsEssentialsBook.getTitle());
					System.out.println("Book added: " + new BookService().addBook(awsEssentialsBook));
					//System.out.println("Book added: " + new BookService().addBook(awsBook));
					break;
				case 2: 
					User user = new User(1, "Niraj");
					System.out.println("Attempting to add user: " + user.getName());
					System.out.println("User added: " + new UserService().addUser(user));
					break;
				case 3: 
					System.out.println("Requesting book : " + awsBook.getTitle() + " for user: "+ niraj.getName());
					System.out.println("Book granted: " + new BookService().lendBook(awsBook.getTitle(), niraj));
					break;
				case 4: 
					System.out.println("Attempting to return book : " + awsBook.getTitle() + " for user: "+ niraj.getName());
					System.out.println("Book returned: " + new BookService().returnBook(awsBook.getTitle(), niraj));
					break;
				case 5: 
					System.out.println("Searching book with title : " + awsBook.getTitle());
					System.out.println("Book found: " + new BookService().searchBookByTitle(awsBook.getTitle()));
					System.out.println("Searching book by author : " + author.getAutherName());
					System.out.println("Book found: " + new BookService().searchBookByAuthor(author.getAutherName()));
					break;
	//			default: 
	//				System.out.println("Invalid input");
		}
		}
	}
}
