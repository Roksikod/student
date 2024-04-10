package org.example.student.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

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

    @Column(name = "status_project")
    String projectStatus;
}
