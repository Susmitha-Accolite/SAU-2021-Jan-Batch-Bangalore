package com.assignment.library;

public class AddBooks implements Runnable{

	private BookBlockingQueue queue;
	private String[] id;
	private String[] ISBN;
	private String[] name;
	private Boolean[] inReview;
	private Boolean[] inCart;

	
	
	public AddBooks(BookBlockingQueue queue, String[] id, String[] ISBN, String[] name, Boolean[] inReview,
			Boolean[] inCart) {
		super();
		this.queue = queue;
		this.name = name;
		this.id = id;
		this.ISBN = ISBN;
		this.inReview = inReview;
		this.inCart = inCart;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<id.length;i++) {
//			 System.out.println("inserting book " + name[i] + " " +  id[i] + " " + ISBN[i]);
			Book b = new Book(this.id[i], this.ISBN[i],this.name[i], this.inReview[i], this.inCart[i],"Library");
			try {
				queue.put(b);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
}
