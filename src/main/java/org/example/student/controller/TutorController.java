package org.example.student.controller;

import org.example.student.entity.Course;
import org.example.student.entity.Group;
import org.example.student.entity.Student;
import org.example.student.entity.Tutor;
import org.example.student.repository.CourseRepo;
import org.example.student.repository.GroupRepo;
import org.example.student.repository.StudentRepo;
import org.example.student.repository.TutorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("tutors")
public class TutorController {
    @Autowired
    private TutorRepo tutorRepo;

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    CourseRepo courseRepo;

    @Autowired
    GroupRepo groupRepo;

    @GetMapping("/all")
    public List<Tutor> getAll() {
        return tutorRepo.findAll();
    }
    @GetMapping("/{id}")
    public Tutor getTutor(@RequestParam int tutorId) {
        return tutorRepo.findById(tutorId)
                .orElseThrow(() -> new RuntimeException("Student was not found"));
    }

    @PostMapping
    public Tutor addTutor(@RequestBody Tutor tutor) {
        return tutorRepo.save(tutor);
    }

    @PutMapping("/tutors-work-courses")
    public Tutor updateTutorCourses (@RequestParam int tutorId, @RequestParam int courseId){
        Tutor tutor = tutorRepo.findById(tutorId)
                .orElseThrow(() -> new RuntimeException("Tutor was not found"));
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course was not found"));
        tutor.getWorkedCourses().add(course);
        return tutorRepo.save(tutor);
    }

    @PutMapping("/tutors-work-groups")
    public Tutor updateTutorGroups (@RequestParam int tutorId, @RequestParam int groupId){
        Tutor tutor = tutorRepo.findById(tutorId)
                .orElseThrow(() -> new RuntimeException("Tutor was not found"));
        Group group = groupRepo.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group was not found"));
        tutor.getWorkedGroups().add(group);
        return tutorRepo.save(tutor);
    }
    @PutMapping("/tutor-has-students")
    public Tutor updateTutorStudents(@RequestParam int tutorId, @RequestParam int studentId) {
         Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student was not found"));
        Tutor tutor = tutorRepo.findById(tutorId)
                .orElseThrow(() -> new RuntimeException("Course was not found"));
        tutor.getTutorStudents().add(student);
        student.setTutor(tutor);
        studentRepo.save(student);
        return tutorRepo.save(tutor);
    }
}
