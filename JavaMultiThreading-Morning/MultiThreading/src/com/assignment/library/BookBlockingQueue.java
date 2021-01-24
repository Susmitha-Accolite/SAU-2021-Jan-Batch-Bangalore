package com.assignment.library;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BookBlockingQueue {
	
	private Lock lock = new ReentrantLock();
	private Condition addBookCondition = lock.newCondition();
	private Condition buyerCondition = lock.newCondition();
	private List<Book> blockingQueue = new ArrayList<>();
	private int count = 0;
	
	BookBlockingQueue() { };
	
	public void put(Book book) throws InterruptedException {
		lock.lock();
		
		System.out.println("Locked In Put");
		
		try {
			blockingQueue.add(book);
			count++;
			buyerCondition.signal();
		}
		finally {
			lock.unlock();
		}
	}
	
	public List<Book> getBookList() {
		System.out.println("ID\tISBN\tName\tReviwer\tInReview\tInCart");
		for(Book book : blockingQueue) {
			book.getBookDetails();
		}
		
		return blockingQueue;
	}
	
	public void addToCart(Student student, Book book) throws InterruptedException{
		lock.lock();
		try {
			if(student.canBoughtBook(book.getId())) {
				for(int i = 0 ; i < blockingQueue.size() ; i++ ) {
					if(blockingQueue.get(i).getId() == book.getId() && blockingQueue.get(i).getISBN() == book.getISBN()) {
						blockingQueue.get(i).setInCart(true);
						blockingQueue.get(i).setReviewer(student.getName());
						break;
					}
				}
				addBookCondition.signalAll();
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		finally {
			lock.unlock();
		}
	}
	
	public void removeFromCart(Student student, Book book) throws InterruptedException{
		lock.lock();
		try {
			for(int i = 0 ; i < blockingQueue.size() ; i++ ) {
				if(blockingQueue.get(i).getId() == book.getId() && blockingQueue.get(i).getISBN() == book.getISBN()) {
					blockingQueue.get(i).setInCart(false);
					blockingQueue.get(i).setReviewer("Library");
					break;
				}
			}
			addBookCondition.signalAll();
		} finally {
			lock.unlock();	
		}
	}
	
	public void checkout(Student student, Book book) throws InterruptedException{
		lock.lock();
		System.out.println("Inside Checkout");
		try {
			while(count == 0) {
				buyerCondition.await();
			}
			
			if(student.canBoughtBook(book.getId())) {
				for(int i = 0 ; i < blockingQueue.size() ; i++ ) {
					if(blockingQueue.get(i).getId().equals(book.getId()) && blockingQueue.get(i).getISBN() == book.getISBN()) {
						blockingQueue.get(i).setInReview(true);
						blockingQueue.get(i).setReviewer(student.getName());
						student.addBoughtBook(blockingQueue.get(i));
						blockingQueue.remove(i);
						break;
					}
				}
				System.out.println("book bought");
				addBookCondition.signalAll();
			}
		} finally {
			
		}
	}

	public void review(Student student, Book book) throws InterruptedException{
		// TODO Auto-generated method stub
		lock.lock();
		try {
			
			if(book == null)
				System.out.println("Book has alredy purchased");
			while(count == 0)
				buyerCondition.await();
			if(student.canBoughtBook(book.getId())) {
				for(int i = 0 ; i < blockingQueue.size() ; i++ ) {
					if(blockingQueue.get(i).getId() == book.getId() && blockingQueue.get(i).getISBN() == book.getISBN()) {
						blockingQueue.get(i).setInReview(true);
						blockingQueue.get(i).setReviewer(student.getName());
						student.addInReviewList(blockingQueue.get(i));
						break;
					}
				}
				addBookCondition.signalAll();
			}
		} finally {
			lock.unlock();
		}
	}
	
 }
