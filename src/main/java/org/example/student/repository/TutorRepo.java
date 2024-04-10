package org.example.student.repository;

import org.example.student.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepo extends JpaRepository<Tutor,Integer> {
}
