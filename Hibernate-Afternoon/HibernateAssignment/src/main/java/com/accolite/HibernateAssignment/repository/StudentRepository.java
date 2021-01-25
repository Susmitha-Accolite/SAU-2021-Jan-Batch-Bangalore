package com.accolite.HibernateAssignment.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.accolite.HibernateAssignment.entity.Student;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class StudentRepository {

	@PersistenceContext
	EntityManager entityManager;

	public void add(Student student) {
		entityManager.persist(student);
	}
	
	public void delete(Student student) {
		entityManager.remove(student);
	}
	
	public Student update(Student student) {
		return entityManager.merge(student);
	}
	
	public Student getById(int id) {
		return entityManager.find(Student.class, id);
	}
}
