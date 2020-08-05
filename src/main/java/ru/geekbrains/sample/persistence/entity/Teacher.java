package ru.geekbrains.sample.persistence.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Teacher extends AbstractEntity{
    private String name;
    private String surname;
}