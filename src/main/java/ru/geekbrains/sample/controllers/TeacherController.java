package ru.geekbrains.sample.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.sample.dao.TeacherRepository;
import ru.geekbrains.sample.persistence.entity.Teacher;


@Controller
@RequestMapping("teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherRepository teacherRepository;

    //когда прилетит запрос вида http://localhost:8080/teachers
    @GetMapping("/")
    public String showAllTeachers(Model model){
        model.addAttribute("teachers",teacherRepository.findAllTeachers());
        return "teacher";
    }

//    @PostMapping("/")
//    public String sendCarsForm(@ModelAttribute Teacher teacher) {
//        System.out.println(teacher);
//        return "redirect:/teachers/";
//    }
}
