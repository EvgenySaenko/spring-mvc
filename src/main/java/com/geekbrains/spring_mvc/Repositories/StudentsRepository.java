package com.geekbrains.spring_mvc.Repositories;


import com.geekbrains.spring_mvc.model.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
//слой приложения отвечающий за взаимодействие с бозой даных(работа с базой данных-положить в базу, достать оттуда)
//пока что просто как база данных
public class StudentsRepository {
    private List<Student>students;
    @PostConstruct
    public void init(){//заполняем некий список студентов
        this.students = new ArrayList<>();
        this.students.add(new Student(1L,"Bob",70,"Economics"));
        this.students.add(new Student(2L,"John",85,"IT-technologies"));
        this.students.add(new Student(3L,"Sam",55,"IT-technologies"));
        this.students.add(new Student(4L,"Jack",100,"Economics"));
        this.students.add(new Student(5L,"Mike",60,"IT-technologies"));
    }

    public List<Student> findAll() {
        return Collections.unmodifiableList(students);
    }


    //ищет студента по id
    public Student findById(Long id){
        for(Student s : students){
            if (s.getId().equals(id)){
                return s;
            }
        }
        throw new RuntimeException("Student not found");
    }
}
