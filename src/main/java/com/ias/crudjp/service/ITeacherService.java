package com.ias.crudjp.service;

import com.ias.crudjp.dto.TeacherDTO;

import java.util.List;

public interface ITeacherService {
    TeacherDTO addTeacher(TeacherDTO teacher);
    void updateTeacher(TeacherDTO teacher);
    void deleteTeacher(Long teacherId);
    TeacherDTO getTeacherById(Long teacherId);
    List<TeacherDTO> getAllTeachers();
}
