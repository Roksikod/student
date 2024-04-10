package org.example.student.repository;

import org.example.student.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Integer> {
}
