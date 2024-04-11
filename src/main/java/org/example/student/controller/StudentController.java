package org.example.student.controller;

import org.example.student.entity.*;
import org.example.student.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    LessonRepo lessonRepo;

    @Autowired
    ProjectRepo projectRepo;

    @Autowired
    CourseRepo courseRepo;

    @GetMapping("/all")
    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@RequestParam int studentId) {
        return studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student was not found"));
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepo.save(student);
    }

    @PutMapping("/students-pass-lessons")
    public Student updateStudentLessons(@RequestParam int studentId, @RequestParam int lessonId) {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student was not found"));
        Lesson lesson = lessonRepo.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson was not found"));
        student.getPassedLessons().add(lesson);
        return studentRepo.save(student);
    }

    @PutMapping("/students-do-projects")
    public Student updateStudentProjects(@RequestParam int studentId, @RequestParam int projectId) {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student was not found"));
        Project project = projectRepo.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project was not found"));
        student.getDoneProjects().add(project);
        return studentRepo.save(student);
    }

    @PutMapping("/students-study-on-courses")
    public Student updateStudentCourses(@RequestParam int studentId, @RequestParam int courseId) {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student was not found"));
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course was not found"));
        student.getStudiedCourses().add(course);
        return studentRepo.save(student);
    }


}
