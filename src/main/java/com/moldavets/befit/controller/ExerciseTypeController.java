package com.moldavets.befit.controller;

import com.moldavets.befit.model.ExerciseType;
import com.moldavets.befit.service.ExerciseTypeService;
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
@RequestMapping("/exercisetypes")
@RequiredArgsConstructor
public class ExerciseTypeController {

    private final ExerciseTypeService exerciseTypeService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("exercisetypes", exerciseTypeService.findAll());
        return "exercisetypes/list";
    }

    @GetMapping("/new")
    public String createForm(ExerciseType exerciseType) {
        return "exercisetypes/form";
    }

    @PostMapping("/save")
    public String save(@Valid ExerciseType exerciseType, BindingResult result) {
        if (result.hasErrors()) {
            return "exercisetypes/form";
        }
        exerciseTypeService.save(exerciseType);
        return "redirect:/exercisetypes";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("exerciseType", exerciseTypeService.findById(id));
        return "exercisetypes/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        exerciseTypeService.deleteById(id);
        return "redirect:/exercisetypes";
    }

}
