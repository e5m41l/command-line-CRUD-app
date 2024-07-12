package com.luv2code.cruddemo;

import com.luv2code.cruddemo.DAO.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// I need to study
	// 1. Java Collections
	// 2. lambda expressions

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner-> {
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);

//            queryForStudents(studentDAO);

//			queryForStudentsByLastName(studentDAO);

			updateStudent(studentDAO);
		};

	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve the student
		int theId = 1;
		Student myStudent = studentDAO.findById(theId);

		// change first name
		myStudent.setFirstName("John");

		// update the student
		studentDAO.update(myStudent);

		// printing the result
		System.out.println("We have updated the student look-> " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// Calling the function
		List<Student> theStudents = studentDAO.findByLastName("Duck");

		// Printing The Result
		for (Student x: theStudents) {
			System.out.println(x);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
        List<Student> theStudents = studentDAO.findAll();

        for (Student x: theStudents) {
            System.out.println(x);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating a student object ...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

 		// retrieve the student using the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student("John", "Doe", "paul@luv2code.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating a student object ...");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
