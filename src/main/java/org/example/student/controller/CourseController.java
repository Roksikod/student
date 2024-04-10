package org.example.student.controller;


import org.example.student.entity.Course;
import org.example.student.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("courses")
public class CourseController {
    @Autowired
    private CourseRepo courseRepo;

    @GetMapping("/all")
    public List<Course> getAll(){
        return courseRepo.findAll();
    }
    @GetMapping("/{id}")
    public Course getCourse(@RequestParam int courseId) {
        return courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course was not found"));
    }

    @PostMapping
    public Course addCourse(@RequestBody Course course){
        return courseRepo.save(course);
    }
}
