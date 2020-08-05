package ru.geekbrains.sample.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import ru.geekbrains.sample.dao.StudentRepository;
import ru.geekbrains.sample.dao.TeacherRepository;
import ru.geekbrains.sample.persistence.entity.Student;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final TeacherRepository teacherRepository;

    private final StudentRepository studentRepository;


    @GetMapping("/")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/students")
    public String getStudentPage(Model model) {
        model.addAttribute("students", studentRepository.findAllStudents());
        return "student";
    }
    //когда прилетит запрос вида http://localhost:8080/teachers
    @GetMapping("/teachers")
    public String showAllTeachers(Model model){
        model.addAttribute("teachers",teacherRepository.findAllTeachers());
        return "teachers";
    }

//    @PostMapping("/students")
//    public String sendForm(@ModelAttribute Student student) {
//        System.out.println(student);
//        return "redirect:/";
//    }

}