package com.ias.crudjp.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="Materia")
public class Subject {
    @Id
    @Column(name="idMateria")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Identity
    private long id;
    @Column(nullable = false)
    private String topic;
    @Column(nullable = false)
    private LocalDate schedule;

    @ManyToOne // relación base de datos, muchos estudiantes para una sola materia.
    @JoinColumn(name="idTeacher") // se relaciona la llave foránea de materia
    private Teacher teacher;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)  //Cuando se coloca un JoinColumn se debe relacionar con un mappedBy
    private List<Student> studentsList;             // CascadeType.All permite que al hacer una modificación en la clave primaria se modifique en las claves foráneas


    public Subject(long id, String topic, LocalDate schedule, Teacher teacher, List<Student> studentsList) {
        this.id = id;
        this.topic = topic;
        this.schedule = schedule;
        this.teacher = teacher;
        this.studentsList = studentsList;
    }
    public Subject() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public LocalDate getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalDate schedule) {
        this.schedule = schedule;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }
}
