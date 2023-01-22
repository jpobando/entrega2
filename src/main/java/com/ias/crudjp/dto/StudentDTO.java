package com.ias.crudjp.dto;

import com.ias.crudjp.entity.Student;
import com.ias.crudjp.entity.Subject;

import java.time.LocalDate;

public class StudentDTO {
    private Long id;
    private String name;
    private String lastname;
    private String dni;
    private int age;
    private LocalDate birthDate;
    private Subject subject;

    public StudentDTO(){}

    public StudentDTO(Long id, String name, String lastname, String dni, int age, LocalDate birthDate, Subject subject) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.age = age;
        this.birthDate = birthDate;
        this.subject = subject;
    }

    public StudentDTO(Student student){
        this.id = student.getId();
        this.name = student.getName();
        this.lastname = student.getLastname();
        this.dni = student.getDni();
        this.age = student.getAge();
        this.birthDate = student.getBirthDate();
        this.subject = student.getSubject();
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
