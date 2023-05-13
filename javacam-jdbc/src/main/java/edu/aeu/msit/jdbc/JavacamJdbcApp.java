package edu.aeu.msit.jdbc;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.aeu.msit.jdbc.model.Lesson;
import edu.aeu.msit.jdbc.model.Student;
import edu.aeu.msit.jdbc.service.LessonService;
import edu.aeu.msit.jdbc.service.StudentService;

@SpringBootApplication
public class JavacamJdbcApp implements CommandLineRunner {
	
	@Autowired
    StudentService studentService;
	@Autowired
    LessonService lessonService;
	
	public static void main(String[] args) {
		SpringApplication.run(JavacamJdbcApp.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("StartApplication...");
		testStudentData();
		testLessonData();
	}

	@SuppressWarnings("deprecation")
	void testStudentData() {
		List<Student> students = Arrays.asList(
			new Student("OENG", "Sometri", new Date(1984, 5, 14)),
			new Student("Gates", "Bill", new Date(2000, 5, 15)),
			new Student("Zuckerberg", "Mark", new Date(2001, 5, 16))
		);
		System.out.println("[SAVE]");
		students.forEach(student -> {
			System.out.println("Saving student with name: " + student.toString());
			studentService.save(student);
		});
		// find all
		System.out.println("get All students: " + studentService.findAll());
		// find by id
		System.out.println("Find Student with id 13");
		Student student = studentService.findById(13).orElseThrow(IllegalArgumentException::new);
		System.out.println("Student with id 13: " + student);
	}
	
	void testLessonData() {
		List<Lesson> lessons = Arrays.asList(
			new Lesson("JavaScript"),
			new Lesson("Java"),
			new Lesson("C#")
		);
		System.out.println("[SAVE]");
		lessons.forEach(lesson -> {
			System.out.println("Saving lesson with name: " + lesson.toString());
			lessonService.save(lesson);
		});
		// find all
		System.out.println("get All lessons: " + lessonService.findAll());
		// find by id
		System.out.println("Find Lesson with id 13");
		Lesson lesson = lessonService.findById(13).orElseThrow(IllegalArgumentException::new);
		System.out.println("Lesson with id 13: " + lesson);
	}

}
