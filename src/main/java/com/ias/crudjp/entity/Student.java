package com.ias.crudjp.entity;

import com.ias.crudjp.dto.StudentDTO;
import com.ias.crudjp.dto.TeacherDTO;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="estudiantes") // En la base de datos se cambia el nombre por "estudiantes" pero el proyecto se sigue llamando Student
public class Student {
    @Id  // esta anotación es para indicar que será el ID de la tabla
    @Column(name="idEstudiante")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //1,2,3,4,5 a nivel de código se le indica que es autoincremental
    private Long id;
    @Column(name = "nombres",nullable = false) // se le cambia el nombre al campo en la BD, es opcional
    private String name;
    @Column(nullable = false)
    private String lastname;
    @Column(name = "cedula",nullable = false)
    private String dni;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private LocalDate birthDate;
    @ManyToOne // relación base de datos, muchos estudiantes para una sola materia.
    @JoinColumn(name="idMateria") // se relaciona la llave foránea de materia
    private Subject subject;

    public Student(){}

    public Student(Long id, String name, String lastname, String dni, int age, LocalDate birthDate, Subject subject) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.age = age;
        this.birthDate = birthDate;
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() { return name; }

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

    public Subject getSubject() { return subject; }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student(StudentDTO studentDTO){
        this.id = studentDTO.getId(); // Lo genera la base de datos, ANALIZARLO!!
        this.name = studentDTO.getName();
        this.lastname = studentDTO.getLastname();
        this.dni = studentDTO.getDni();
        this.age = studentDTO.getAge();
        this.subject = studentDTO.getSubject();
    }
}
