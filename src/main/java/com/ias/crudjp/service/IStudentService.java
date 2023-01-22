package com.ias.crudjp.service;

import com.ias.crudjp.dto.StudentDTO;

import java.util.List;

public interface IStudentService {

    void saveStudent(StudentDTO student);
    String updateStudent(StudentDTO student);
    String deleteStudent(Long studentId);
    StudentDTO getStudentById(Long StudentId);
    List<StudentDTO> getAllStudents();
}
