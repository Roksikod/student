package org.example.student.controller;

import org.example.student.entity.Course;
import org.example.student.entity.Group;
import org.example.student.repository.CourseRepo;
import org.example.student.repository.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("groups")
public class GroupController {
    @Autowired
    private GroupRepo groupRepo;

    @GetMapping("/all")
    public List<Group> getAll(){
        return groupRepo.findAll();
    }
    @GetMapping("/{id}")
    public Group getGroup(@RequestParam int groupId) {
        return groupRepo.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group was not found"));
    }

    @PostMapping
    public Group addGroup(@RequestBody Group group){
        return groupRepo.save(group);
    }
}
