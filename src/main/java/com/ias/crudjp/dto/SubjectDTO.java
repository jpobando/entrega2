package com.ias.crudjp.dto;

import com.ias.crudjp.entity.Student;
import com.ias.crudjp.entity.Subject;
import com.ias.crudjp.entity.Teacher;

import java.time.LocalDate;
import java.util.List;

public class SubjectDTO {
    private long id;
    private String topic;
    private LocalDate schedule;
    private Teacher teacher;
    private List<Student> studentsList;

    public SubjectDTO(){}

    public SubjectDTO(long id, String topic, LocalDate schedule, Teacher teacher, List<Student> studentsList) {
        this.id = id;
        this.topic = topic;
        this.schedule = schedule;
        this.teacher = teacher;
        this.studentsList = studentsList;
    }

    public SubjectDTO(Subject subject) {
        this.id = subject.getId();
        this.topic = subject.getTopic();
        this.schedule = subject.getSchedule();
        this.teacher = subject.getTeacher();
        this.studentsList = subject.getStudentsList();
    }

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
