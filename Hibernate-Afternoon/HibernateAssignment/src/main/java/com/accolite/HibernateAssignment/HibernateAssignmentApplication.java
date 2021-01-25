package com.accolite.HibernateAssignment;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.accolite.HibernateAssignment.entity.Course;
import com.accolite.HibernateAssignment.entity.Department;
import com.accolite.HibernateAssignment.entity.Student;
import com.accolite.HibernateAssignment.repository.StudentJPARepository;
import com.accolite.HibernateAssignment.repository.StudentRepository;

@SpringBootApplication
@Transactional
public class HibernateAssignmentApplication implements CommandLineRunner{

	@Resource
	StudentRepository studentRepository;
	
	@Autowired
	StudentJPARepository studentJPARepository;
	
	public static void main(String[] args) {
		System.out.println("*******************");
		SpringApplication.run(HibernateAssignmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Inside Run");
		
		Student student1 = new Student();
		student1.setName("AAA");
		student1.setAge(19);
		
		Student student2 = new Student();
		student2.setName("BBB");
		student2.setAge(20);
		
		Student student3 = new Student();
		student3.setName("CCC");
		student3.setAge(20);
		
		Student student4 = new Student();
		student4.setName("DDD");
		student4.setAge(21);
		
		Department department1 = new Department();
		department1.setName("CSE");
		
		Department department2 = new Department();
		department2.setName("IT");
		
		Course course1 = new Course();
		course1.setTitle("Databases");
		course1.setInstructorName("I1");
		
		Course course2 = new Course();
		course2.setTitle("Java Programming");
		course2.setInstructorName("I2");
		
		Set<Student> studentSet1 = new HashSet<>();
		studentSet1.add(student1);
		studentSet1.add(student2);
		
		course1.setStudents(studentSet1);
		
		department1.setStudents(studentSet1);
		
		Set<Student> studentSet2 = new HashSet<>();
		studentSet2.add(student3);
		studentSet2.add(student4);
		
		course2.setStudents(studentSet2);
		
		department2.setStudents(studentSet2);
		
		studentJPARepository.save(student1);
//		studentJPARepository.save(student2);
//		studentJPARepository.save(student3);
//		studentJPARepository.save(student4);
		
//		studentJPARepository.save(department1);
//		studentJPARepository.save(department2);
//		
//		studentJPARepository.save(course1);
//		studentJPARepository.save(course2);
		
//		studentRepository.delete(student4);
//		System.out.println("Deleted the student");
		
		Student studentDetails = studentRepository.getById(student1.getId());
		System.out.println(studentDetails.getName()+"\t"+studentDetails.getAge());
		
		System.out.println("Complete");
	}

}
