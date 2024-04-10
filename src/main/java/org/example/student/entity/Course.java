package org.example.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "courses")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int courseId;

    @Column(name = "title_course")
    String courseTitle;

    @JsonIgnoreProperties(value = "workedCourses")
    @ManyToMany(mappedBy = "workedCourses")
    List<Tutor> workes;

    @JsonIgnoreProperties(value = "studiedCourses")
    @ManyToMany(mappedBy = "studiedCourses")
    List<Student> trainees;
}
