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
@Table(name = "lessons")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int lessonId;

    @Column(name = "title_lesson")
    String lessonTitle;

    @JsonIgnoreProperties(value = "passedLessons")
    @ManyToMany(mappedBy = "passedLessons")
    List<Student> passings;

}
