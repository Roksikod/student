package org.example.student.repository;

import org.example.student.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Integer> {
}
