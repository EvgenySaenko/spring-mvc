package com.geekbrains.spring_mvc.services;


import com.geekbrains.spring_mvc.Repositories.StudentsRepository;
import com.geekbrains.spring_mvc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//аннотация сервис говорит что это уже сервисный слой, и является наследником компонента
@Service//сервис инжектит репозиторий и теперь имеет к нему доступ
public class StudentsService {
    private StudentsRepository studentsRepository;

    @Autowired//инжектим репозиторий
    public void setStudentsRepository(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }
    //чтобы запросить список всех студентов, мы просим репозиторий найти нам всех студентов
    public List<Student> getAllStudents(){
        return studentsRepository.findAll();
    }

    //просим репозиторий найти студента по его id
    public Student findById(Long id){//просим репозиторий найти студента по id
        return studentsRepository.findById(id);
    }
}
