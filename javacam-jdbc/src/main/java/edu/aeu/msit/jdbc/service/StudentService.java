package edu.aeu.msit.jdbc.service;

import java.util.List;
import java.util.Optional;

import edu.aeu.msit.jdbc.model.Student;

public interface StudentService {
	int save(Student student);

	int update(Student student);

	int deleteById(int id);

	List<Student> findAll();

	Optional<Student> findById(int id);
}
