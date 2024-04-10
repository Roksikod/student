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
@Table(name = "tutors")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tutorId;

    @Column(name = "email_tutor")
    String tutorEmail;

    @Column(name = "nick_tg_tutor")
    String tutorNickTg;

    @Column(name = "first_name_tutor")
    String tutorFirstName;

    @Column(name = "last_name_tutor")
    String tutorLastName;

    @Column(name = "city_tutor")
    String tutorCity;

    @Column(name = "age_tutor")
    Integer tutorAge;

    @JsonIgnoreProperties(value = "workes")
    @ManyToMany
    @JoinTable(name= "tutor_course",
            joinColumns = {
                    @JoinColumn(name = "tutor_id", referencedColumnName = "tutorId")},
            inverseJoinColumns = {
                    @JoinColumn(name = "course_id", referencedColumnName = "courseId")
            })
    List<Course> workedCourses;

    @JsonIgnoreProperties(value = "groupWorkes")
    @ManyToMany
    @JoinTable(name= "tutor_group",
            joinColumns = {
                    @JoinColumn(name = "tutor_id", referencedColumnName = "tutorId")},
            inverseJoinColumns = {
                    @JoinColumn(name = "group_id", referencedColumnName = "groupId")
            })
    List<Group> workedGroups;
}

   /* "tutorEmail":"tut1@gmail.com",
            "tutorNickTg":"tut1@gmail.com",
            "tutorFirstName":"tut1@gmail.com",
            "tutorLastName":"tut1@gmail.com",
            "tutorCity":"tut1@gmail.com",
            "tutorAge":"tut1@gmail.com"*/