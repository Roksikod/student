package org.example.student.controller.front;

import lombok.RequiredArgsConstructor;
import org.example.student.entity.model.FrontTutor;
import org.example.student.service.FrontTutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class FrontTutorController {
    @Autowired
    private final FrontTutorService frontTutorService;

    @GetMapping("/front-tutor/all")
    public String frontTutors(Model model) {
        model.addAttribute("frontTutors", frontTutorService.frontTutorList());
        return "frontTutors";
    }
    @GetMapping("/front-tutor/1")
    public String frontTutor(Model model) {
        model.addAttribute("frontTutors", frontTutorService.frontTutorList());
        return "frontTutor";
    }

    @GetMapping("/front-tutor/{id}")
    public String frontTutorInfo(@PathVariable int frontTutorId, Model model) {
        model.addAttribute("frontTutor", frontTutorService.getFrontTutorById(frontTutorId));
        return "frontTutor-info";
    }

    @PostMapping("/front-tutor/create")
    public String createFRontTutor(FrontTutor frontTutor) {
        frontTutorService.saveFrontTutor(frontTutor);
        return "redirect:/";
    }

    @PostMapping("/front-tutor/delete/{id}")
    public String deleteFrontTutor(@PathVariable int id) {
        frontTutorService.deleteFrontTutor(id);
        return "redirect:/";
    }
}
