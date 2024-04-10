package org.example.student.controller;

import org.example.student.entity.Lesson;
import org.example.student.entity.Project;
import org.example.student.repository.LessonRepo;
import org.example.student.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("projects")
public class ProjectController {
    @Autowired
    private ProjectRepo projectRepo;

    @GetMapping("/all")
    public List<Project> getAll(){
        return projectRepo.findAll();
    }
    @GetMapping("/{id}")
    public Project getProject(@RequestParam int projectId) {
        return projectRepo.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project was not found"));
    }

    @PostMapping
    public Project addProject(@RequestBody Project project){
        return projectRepo.save(project);
    }
}
