package org.example.student.repository;

import org.example.student.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepo extends JpaRepository<Lesson,Integer> {
}
