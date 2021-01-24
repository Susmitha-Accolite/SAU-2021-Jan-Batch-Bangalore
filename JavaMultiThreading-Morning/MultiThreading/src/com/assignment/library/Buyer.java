package com.assignment.library;

public class Buyer implements Runnable {

	private BookBlockingQueue queue;
	private Student student;
	private Book book;
	
	
	public Buyer(BookBlockingQueue queue, Student student, Book book) {
		super();
		this.queue = queue;
		this.student = student;
		this.book = book;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Inside Buyer");
			queue.checkout(student,book);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
