package com.assignment.library;

import java.util.ArrayList;

public class Student {
	private String id;
	private String name;
	private ArrayList<Book> boughtBooks;
	private ArrayList<Book> reviewingBooks;
	
	public Student(String id, String name) {
		super();
		this.id = id;
		this.name = name;
		boughtBooks = new ArrayList<>();
		reviewingBooks = new ArrayList<>();
	}
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void addInReviewList(Book book) {
		this.reviewingBooks.add(book);
	}
	
	public void addBoughtBook(Book book) {
		this.boughtBooks.add(book);
	}
	
	public boolean canBoughtBook(String id) {
		for(Book b : boughtBooks) {
			if(b.getId() == id)
				return false;
		}
		return true;
	}
	
	public void getReviewList() {
		if(reviewingBooks.size() == 0) {
			System.out.println("Not Books are in review yet");
		}
		else {
			for(Book b : reviewingBooks) {
				b.getBookDetails();
			}
		}
	}
	
	public void getBoughtBooks() {
		if(boughtBooks.size() == 0) {
			System.out.println("No Books are purchased yet");
		}
		else {
			for(Book b : boughtBooks) {
				b.getBookDetails();
			}
		}
	}
}

