package com.moldavets.befit.controller;

import com.moldavets.befit.model.TrainingExercise;
import com.moldavets.befit.service.ExerciseTypeService;
import com.moldavets.befit.service.TrainingExerciseService;
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
@RequestMapping("/trainingexercises")
@RequiredArgsConstructor
public class TrainingExerciseController {

    private final TrainingExerciseService trainingExerciseService;
    private final TrainingSessionService trainingSessionService;
    private final ExerciseTypeService exerciseTypeService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("exercises", trainingExerciseService.findAll());
        return "trainingexercises/list";
    }

    @GetMapping("/new")
    public String createForm(TrainingExercise exercise, Model model) {
        model.addAttribute("sessions", trainingSessionService.findAll());
        model.addAttribute("types", exerciseTypeService.findAll());
        return "trainingexercises/form";
    }

    @PostMapping("/save")
    public String save(@Valid TrainingExercise exercise, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("sessions", trainingSessionService.findAll());
            model.addAttribute("types", exerciseTypeService.findAll());
            return "trainingexercises/form";
        }
        trainingExerciseService.save(exercise);
        return "redirect:/trainingexercises";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("exercise", trainingExerciseService.findById(id));
        model.addAttribute("sessions", trainingSessionService.findAll());
        model.addAttribute("types", exerciseTypeService.findAll());
        return "trainingexercises/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        trainingExerciseService.deleteById(id);
        return "redirect:/trainingexercises";
    }
}