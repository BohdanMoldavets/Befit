package com.moldavets.befit.controller;

import com.moldavets.befit.model.TrainingSession;
import com.moldavets.befit.service.TrainingSessionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trainingsessions")
@RequiredArgsConstructor
public class TrainingSessionController {

    private final TrainingSessionService trainingSessionService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("sessions", trainingSessionService.findAll());
        return "trainingsessions/list";
    }

    @GetMapping("/new")
    public String createForm(TrainingSession session) {
        return "trainingsessions/form";
    }

    @PostMapping("/save")
    public String save(@Valid TrainingSession session, BindingResult result) {
        if (result.hasErrors()) {
            result.rejectValue("startTime", "error.session", "Start time must be before end time");
            return "trainingsessions/form";
        }
        trainingSessionService.save(session);
        return "redirect:/trainingsessions";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("session", trainingSessionService.findById(id));
        return "trainingsessions/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        trainingSessionService.deleteById(id);
        return "redirect:/trainingsessions";
    }
}