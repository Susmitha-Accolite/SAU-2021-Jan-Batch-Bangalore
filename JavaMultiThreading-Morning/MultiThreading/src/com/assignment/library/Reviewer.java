package com.assignment.library;

import java.util.List;

public class Reviewer implements Runnable{
	private BookBlockingQueue queue;
	private Student student;
	private List<Book> book;
	
	
	public Reviewer(BookBlockingQueue queue, Student student, List<Book> book) {
		super();
		this.queue = queue;
		this.student = student;
		this.book = book;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			queue.review(student,book.get(0));
//			book.getDetails();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
