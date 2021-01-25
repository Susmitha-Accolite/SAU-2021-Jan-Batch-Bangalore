package com.accolite.HibernateAssignment.repository;

import org.springframework.data.repository.CrudRepository;

import com.accolite.HibernateAssignment.entity.Course;
import com.accolite.HibernateAssignment.entity.Department;
import com.accolite.HibernateAssignment.entity.Student;

public interface StudentJPARepository extends CrudRepository<Student, Integer>{

	public Student findStudentByCourse_Id(int id);
	public Student findStudentByDepartment_Id(int id);
}
