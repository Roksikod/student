package org.example.student.repository;

import org.example.student.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepo extends JpaRepository<Group, Integer> {
}
