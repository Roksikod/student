package org.example.student.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "groups")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int groupId;

    @Column(name = "title_group")
    String groupTitle;

    @Column(name = "title_course")
    String courseTitle;

    @Column(name = "study_date")
    String studyDate;

    @JsonIgnoreProperties(value = "workedGroups")
    @ManyToMany(mappedBy = "workedGroups")
    List<Tutor> groupWorkes;

    @ManyToOne
    @JsonBackReference(value = "course_groups")
    Course course;
}
