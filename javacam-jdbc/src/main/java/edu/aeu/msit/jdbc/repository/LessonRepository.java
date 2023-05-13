package edu.aeu.msit.jdbc.repository;

import java.util.List;
import java.util.Optional;

import edu.aeu.msit.jdbc.model.Lesson;

public interface LessonRepository {
	int save(Lesson lesson);

	int update(Lesson lesson);

	int deleteById(int id);

	List<Lesson> findAll();

	Optional<Lesson> findById(int id);
}
