package com.ias.crudjp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="profesores")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idTeacher")
    private Long id;
    @Column(name = "nombres",nullable = false) // se le cambia el nombre al campo en la BD, es opcional
    private String name;
    @Column(nullable = false)
    private String lastname;
    @Column(name = "cedula",nullable = false)
    private String dni;
    @Column(nullable = false)
    private int age;
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Subject> subjects;
    public Teacher(){}
    public Teacher(Long id, String name, String lastname, String dni, int age, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.age = age;
        this.subjects = subjects;
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
