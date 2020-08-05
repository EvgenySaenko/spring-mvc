package ru.geekbrains.sample.dao;


import org.springframework.stereotype.Repository;
import ru.geekbrains.sample.persistence.entity.Book;
import ru.geekbrains.sample.persistence.entity.Student;
import ru.geekbrains.sample.persistence.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TeacherRepository {
    //Контекст постоянства(управляется Hibernate) - это кэш первого уровня,
    // в котором все объекты извлекаются из базы данных или сохраняются в базе данных
    //Контекст постоянства отслеживает любые изменения, внесенные в управляемый объект.
    //@PersistenceContext--все управление сущностями возлагается на EntityManager
    //который обладает полным набором CRUD операций
    @PersistenceContext
    private EntityManager entityManager;
    public List<Teacher> findAllTeachers() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        //указываем какую сущность ищем
        CriteriaQuery<Teacher>criteriaQuery = criteriaBuilder.createQuery(Teacher.class);
        //корневая сущность-первая сущность на которую джойнятся другие(когда мы делаем джойны)
        Root<Teacher> root = criteriaQuery.from(Teacher.class);
        CriteriaQuery<Teacher> all = criteriaQuery.select(root);
        return entityManager.createQuery(all).getResultList();
    }
}
