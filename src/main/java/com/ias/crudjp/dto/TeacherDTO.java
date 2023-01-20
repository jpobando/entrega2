package com.ias.crudjp.dto;

import com.ias.crudjp.entity.Subject;
import com.ias.crudjp.entity.Teacher;

import java.util.List;

public class TeacherDTO {
    private Long id;
    private String name;
    private String lastname;
    private String dni;
    private int age;
    private List<Subject> subjects;

    public TeacherDTO(){}

    public TeacherDTO(Long id, String name, String lastname, String dni, int age, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.age = age;
        this.subjects = subjects;
    }

    public TeacherDTO(Teacher teacher) {
        this.id = teacher.getId();
        this.name = teacher.getName();
        this.lastname = teacher.getLastname();
        this.dni = teacher.getDni();
        this.age = teacher.getAge();
        this.subjects = teacher.getSubjects();
    }

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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
