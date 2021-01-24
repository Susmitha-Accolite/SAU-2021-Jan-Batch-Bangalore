package com.assignment.library;

import java.util.List;

public class Cart implements Runnable{

	private BookBlockingQueue queue;
	private Student student;
	private List<Book> bookList;
	
	public Cart(BookBlockingQueue queue, Student student, List<Book> bookList) {
		super();
		this.queue = queue;
		this.student = student;
		this.bookList = bookList;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("inside cart");
			for(Book book : bookList) {
				book.getBookDetails();
				queue.addToCart(student, book);	
			}
			System.out.println("list of books from cart----------------");
			queue.getBookList();
			System.out.println("----------done ----------");
			Thread t = new Thread(new Buyer(queue,student,bookList.get(0)));
			t.run();
			bookList.remove(0);
			
			if(bookList.size() > 0) {
				Thread.sleep(5000);
				for(Book book: bookList) {
					queue.removeFromCart(student,book);		
				}
			}
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
