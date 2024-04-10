package org.example.student.controller;

import org.example.student.entity.Course;
import org.example.student.entity.Lesson;
import org.example.student.entity.Student;
import org.example.student.entity.Tutor;
import org.example.student.repository.CourseRepo;
import org.example.student.repository.LessonRepo;
import org.example.student.repository.StudentRepo;
import org.example.student.repository.TutorRepo;
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
    public Student updateStudent (@RequestParam int studentId, @RequestParam int lessonId){
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student was not found"));
        Lesson lesson = lessonRepo.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson was not found"));
        student.getPassedLessons().add(lesson);
        return studentRepo.save(student);
    }
}
