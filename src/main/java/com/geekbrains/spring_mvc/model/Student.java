package com.geekbrains.spring_mvc.model;

public class Student {
    private Long id;
    private String name;
    private int score;
    private String department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Student() {
    }

    public Student(Long id, String name, int score,String department) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.department = department;
    }
}
