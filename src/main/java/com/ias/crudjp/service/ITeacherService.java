package com.ias.crudjp.service;

import com.ias.crudjp.dto.TeacherDTO;

import java.util.List;

public interface ITeacherService {
    void saveTeacher(TeacherDTO teacher);
    String updateTeacher(TeacherDTO teacher);
    String deleteTeacher(Long teacherId);
    TeacherDTO getTeacherById(Long teacherId);
    List<TeacherDTO> getAllTeachers();
}
