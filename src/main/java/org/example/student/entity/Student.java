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
@Table(name = "students")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @Column(name = "email")
    String email;

    @Column(name = "nick_tg")
    String nickTg;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "city")
    String city;

    @Column(name = "age")
    Integer age;
    @JsonIgnoreProperties(value = "passings")
    @ManyToMany
    @JoinTable(name= "student_lesson",
            joinColumns = {
                    @JoinColumn(name = "student_id", referencedColumnName = "studentId")},
            inverseJoinColumns = {
                    @JoinColumn(name = "lesson_id", referencedColumnName = "lessonId")
            })
    List<Lesson> passedLessons;

    @JsonIgnoreProperties(value = "heroes")
    @ManyToMany
    @JoinTable(name= "student_project",
            joinColumns = {
                    @JoinColumn(name = "student_id", referencedColumnName = "studentId")},
            inverseJoinColumns = {
                    @JoinColumn(name = "project_id", referencedColumnName = "projectId")
            })
    List<Project> doneProjects;

}
