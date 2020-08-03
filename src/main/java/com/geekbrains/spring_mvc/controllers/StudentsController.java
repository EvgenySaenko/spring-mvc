package com.geekbrains.spring_mvc.controllers;


import com.geekbrains.spring_mvc.model.Student;
import com.geekbrains.spring_mvc.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//если мы считаем что все запросы должны попадать на отдельный endpoint(корень должен быть свой)
//можно поставить @RequestMapping  и этот endpoint будет обрабатывать запросы вида
//root//http://localhost:8189/app/students
@RequestMapping("/students")
public class StudentsController {
    private StudentsService studentsService;

    @Autowired//можно заинжектить через контроллер, т.к. контроллеры друг друга не инжектят(кольца не будет)
    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping//вернет страницу со списком пользователей
    public String showAllStudents(Model model){
        List<Student> students = studentsService.getAllStudents();
        model.addAttribute("students",students);
        return "all_students";
    }
    //root//http://localhost:8189/app/students/profile/{id}
    //показыли выбранного студента
    @GetMapping("/profile/{id}")
    public String showProfileStudent(@PathVariable Long id, Model model){
        model.addAttribute("student", studentsService.findById(id));
        return "profile";
    }

}
