package org.example.student.controller;

import org.example.student.entity.Course;
import org.example.student.entity.Tutor;
import org.example.student.repository.CourseRepo;
import org.example.student.repository.TutorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tutors")
public class TutorController {
    @Autowired
    private TutorRepo tutorRepo;

    @Autowired
    CourseRepo courseRepo;

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
    public Tutor updateTutor (@RequestParam int tutorId, @RequestParam int courseId){
        Tutor tutor = tutorRepo.findById(tutorId)
                .orElseThrow(() -> new RuntimeException("Tutor was not found"));
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course was not found"));
        tutor.getWorkedCourses().add(course);
        return tutorRepo.save(tutor);
    }
}
