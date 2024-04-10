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
@Table(name = "projects")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int projectId;

    @Column(name = "title_project")
    String projectTitle;

    @Column(name = "title_topic")
    String projectTopic;

    @JsonIgnoreProperties(value = "doneProjects")
    @ManyToMany(mappedBy = "doneProjects")
    List<Student> heroes;
}
