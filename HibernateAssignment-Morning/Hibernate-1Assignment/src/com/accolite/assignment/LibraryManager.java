package com.accolite.assignment;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LibraryManager {

	private static SessionFactory factory;
	
	public static void main(String[] args) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
			
		} catch (Exception e) {
			System.err.println(e);// TODO: handle exception
		}
		LibraryManager manager = new LibraryManager();
		
		manager.addBook();
		manager.getBooks();
		manager.updateBook(2);
		manager.deleteBookById(4);
		
		int count = manager.countOfBooks();
		System.out.println("Total numebr of books in the library are : " +count);
	}
	
	private static void addBook() {
		
		System.out.println("----------------Create Books------------------");
		
		Session session = factory.openSession();
		Transaction tx = null;
		Integer bookId = null;
		String[] bookNames = {"Da Vinci Code,The", "Harry Potter", "Angels and Demons", "Twilight", " 	Gruffalo,The" };
		String[] bookAuthors = {"Brown, Dan", "Rowling, J.K.", " Brown, Dan ", "Meyer, Stephenie", "Donaldson, Julia"};
		String[] bookPublishers = {"Transworld ", "Bloomsbury ", "Transworld", "Little, Brown Book", "Pan Macmillan"};
		String[] bookLanguage = {"Engilish", "Engilish ", "Engilish", "Engilish", "Engilish"};
		
		for(int i=0; i<5;i++) {
			try {
				tx = session.beginTransaction();
				Library lib = new Library( bookNames[i] ,bookPublishers[i] ,bookAuthors[i], bookLanguage[i]);
				bookId = (Integer) session.save(lib);
				tx.commit();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				if(tx!=null)
					tx.rollback();
			}finally {
				System.out.println("Details of added book ");
				System.out.println(bookNames[i]+"\t " +bookPublishers[i]+"\t " + bookAuthors[i]+"\t " +bookLanguage[i]);
				
			}
		}
		session.close();
	}
	
	private void updateBook(int id) {
		System.out.println("----------------Update Books------------------");
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Library book = session.get(Library.class, id);
			System.out.println("Updating the language for id: "+ id);
			System.out.print(book.getId()+"\t");
			System.out.print(book.getName()+"\t");
			System.out.print(book.getAuthor()+"\t");
			System.out.print(book.getPublisher()+"\t");
			System.out.println(book.getLanguage());
			
			book.setLanguage("British - Engilish");
			
			System.out.println("************************");
			
			System.out.println("After Updating");
			System.out.print(book.getId()+"\t");
			System.out.print(book.getName()+"\t");
			System.out.print(book.getAuthor()+"\t");
			System.out.print(book.getPublisher()+"\t");
			System.out.println(book.getLanguage());
			
			session.update(book);
			tx.commit();
			
		} catch (Exception e) {
			
		}
	}
	
	private void getBooks() {
		System.out.println("----------------Read Books----------------");
		
		Session session = factory.openSession();
		Transaction tx = null;
		int count= 0;
		try {
			tx = session.beginTransaction();
			List<Library> books = session.createQuery("FROM Library").list();
			System.out.println("Books from the Database are: ");
			count = books.size();
			
			for(Library book : books) {
				System.out.print(book.getId()+"\t");
				System.out.print(book.getName()+"\t");
				System.out.print(book.getAuthor()+"\t");
				System.out.print(book.getPublisher()+"\t");
				System.out.println(book.getLanguage());
			}
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if(tx!=null) {
				tx.rollback();
			}
		}finally {
			session.close();
		}
	}
	
	private void deleteBookById(int id) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		
		System.out.println("----------------Delete Books------------------");
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Library book = session.get(Library.class,id);
			System.out.println("Book to be deleted: " + id);
			System.out.print(book.getId()+"\t");
			System.out.print(book.getName()+"\t");
			System.out.print(book.getAuthor()+"\t");
			System.out.print(book.getPublisher()+"\t");
			System.out.println(book.getLanguage());
			
			
			session.delete(book);
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		} finally {
			session.close();
		}
		
	}
	
	private int countOfBooks() {
		Session session = factory.openSession();
		Transaction tx = null;
		int count= 0;
		try {
			tx = session.beginTransaction();
			List<Library> books = session.createQuery("FROM Library").list();
			System.out.println("Books from the Database are: ");
			count = books.size();
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if(tx!=null) {
				tx.rollback();
			}
		}finally {
			session.close();
		}
		return count;
	}
}
