package com.assignment.library;

import java.util.ArrayList;
import java.util.List;

public class LibraryMain {
	
	private static List<Student> students = new ArrayList<>();
	private static List<Book> Books = new ArrayList<>();

	public static void main(String[] args) {
		
		initializeStudents();
		BookBlockingQueue queue = new BookBlockingQueue();
		initialBooks(queue);
		
		Books = queue.getBookList();
		
		
		System.out.println("------------------------- Add Signle Book to Cart ----------------------------");
		
		String[] booksInCart_Id = {"B2"};
		Thread t1 = new Thread(new Cart(queue, students.get(1), isValidBook(booksInCart_Id)));
		t1.run();
		
		queue.getBookList();
		
		System.out.println("--------------------------Add multiple Books to cart----------------------------");
		
		booksInCart_Id = new String[] {"B1", "B3", "B5"};
		Thread t2 = new Thread(new Cart(queue,students.get(4),isValidBook(booksInCart_Id)));
		t2.run();
		
		queue.getBookList();
		
		addNewBooks(queue);
		
		System.out.println("--------------------------Review Books----------------------------");
		
		String[] booksReview_Id = {"B6"};
		Thread t3 = new Thread(new Reviewer(queue, students.get(2), isValidBook(booksReview_Id)));
		t3.run();
		
		booksReview_Id = new String[] {"B4"};
		Thread t4 = new Thread(new Reviewer(queue, students.get(4), isValidBook(booksReview_Id)));
		t4.run();
		
		System.out.println("Books In Review");
		for(Student s : students) {
			s.getReviewList();
		}
		
		System.out.println("Books Purchased");
		for(Student s : students) {
			s.getBoughtBooks();
		}
	}
		
		
	private static void initialBooks(BookBlockingQueue queue) {
		String[] name = {"BA","BA","BB","BC","BB","BC","BD","BD","BD","BD"};
		String[] id = 		{ "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "B10" };
		String[] ISBN = {"BK1","BK1","BK2","BK3","BK2","BK3","BK4","BK4","BK4","BK4"};
		Boolean [] inReview = {false,false,false,false,false,false,false,false,false,false};
		
		Boolean[] inCart = {false,false,false,false,false,false,false,false,false,false}; 
		
		Thread initializeBookList = new Thread(new AddBooks(queue,id,ISBN,name,inReview,inCart));
		initializeBookList.run();	
	}
	
	public static void initializeStudents() {
		String[] name = {"SA","SB","SC","SD","SE","SF","SG","SH","SI","SJ"};
		String[] id = 		{ "S1" , "S2" , "S3" , "S4" , "S5" , "S6" ,"S7" , "S8" , "S9" , "S10" };

		for(int i=0;i<10;i++) {
			Student b = new Student(id[i], name[i]);
			students.add(b);
		}
		System.out.println("added students");
	}
	
	public static void addNewBooks(BookBlockingQueue queue) {
		String[] name = {"BE"};
		String[] id =  {"B11"};
		String[] ISBN= {"BK5"};
		Boolean [] inReview = {false};
		Boolean [] inCart = {false};
		Thread addNewBookList = new Thread(new AddBooks(queue,id,ISBN, name,inReview, inCart));
		addNewBookList.run();

		System.out.println("All the books in the library are: ");
		Books = queue.getBookList();
	}
	
	public static List<Book> isValidBook(String[] bookIDs) {
		List<Book> validationBooks = new ArrayList<>();
		
		for(String id : bookIDs) {
			for(int i = 0; i < Books.size(); i++) {
				if(Books.get(i).getId() == id && !Books.get(i).getInReview() && !Books.get(i).getInCart()) {
					validationBooks.add(Books.get(i));
					break;
				}
			}
		}
//		System.out.println("In validation");
//		for(int i =0; i < validationBooks.size(); i++) {
//			System.out.println(validationBooks.get(i).getId());
//		}
		
		return validationBooks;
	}
}
