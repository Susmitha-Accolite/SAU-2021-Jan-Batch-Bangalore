package com.assignment.library;

public class Book {
	
	private String id;
	private String ISBN;
	private String name;
	private Boolean inReview;
	private Boolean inCart;
	private String reviewer;
	
	
	public Book(String id, String ISBN, String name, Boolean inReview, Boolean inCart, String reviewer) {
		super();
		this.id = id;
		this.ISBN = ISBN;
		this.name = name;
		this.inReview = inReview;
		this.inCart = inCart;
		this.reviewer = reviewer;
	}


	public String getId() {
		return id;
	}
 	
	
	public String getISBN() {
		return ISBN;
	}
	
	public String getName() {
		return name;
	}
	
	public Boolean getInReview() {
		return inReview;
	}
	public void setInReview(Boolean inReview) {
		this.inReview = inReview;
	}
	
	public Boolean getInCart() {
		return inCart;
	}
	
	public void setInCart(Boolean inCart) {
		this.inCart = inCart;
	}
	
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	
	public String getReviewer() {
		return reviewer;
	}
	
	public void getBookDetails() {
		
		System.out.print(this.getId() + "\t");
		System.out.print(this.getName()+ "\t");
		System.out.print(this.getISBN()+ "\t");
		System.out.print(this.getReviewer() + "\t");
		System.out.print(this.getInReview() + "\t");
		System.out.println(this.getInCart());
	}
	
}
