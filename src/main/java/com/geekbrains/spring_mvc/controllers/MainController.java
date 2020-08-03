package com.geekbrains.spring_mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    //отвечает за возврат главной страницы
    @GetMapping(value = "/")//вернем сразу страницу в ответ
    public String showHomePage(){
        return "index";
    }

}
