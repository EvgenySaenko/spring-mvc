package ru.geekbrains.sample.persistence.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Student extends AbstractEntity {

    private String name;

    private Date birth_date;

    private boolean graduated;

    @Column(name = "last_name")
    private String surname;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> books;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "student_subject", joinColumns = @JoinColumn(name = "student"), inverseJoinColumns = @JoinColumn(name = "subject"))
    private List<Subject> subjects;

    @OneToOne
    @JoinColumn(name = "desk")
    private Desk desk;


    @ManyToMany(fetch = FetchType.LAZY)//если ко многим сущностям используем ленивую выборку
    @JoinTable(name = "student_teacher",joinColumns = @JoinColumn(name = "student"),inverseJoinColumns = @JoinColumn(name = "teacher"))
    private List<Teacher>teachers;

}