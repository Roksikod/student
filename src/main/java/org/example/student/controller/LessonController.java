package org.example.student.controller;

import org.example.student.entity.Course;
import org.example.student.entity.Lesson;
import org.example.student.repository.CourseRepo;
import org.example.student.repository.LessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lessons")
public class LessonController {
    @Autowired
    private LessonRepo lessonRepo;

    @GetMapping("/all")
    public List<Lesson> getAll(){
        return lessonRepo.findAll();
    }
    @GetMapping("/{id}")
    public Lesson getLesson(@RequestParam int lessonId) {
        return lessonRepo.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Student was not found"));
    }

    @PostMapping
    public Lesson addLesson(@RequestBody Lesson lesson){
        return lessonRepo.save(lesson);
    }

}
