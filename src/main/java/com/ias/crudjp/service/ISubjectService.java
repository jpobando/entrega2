package com.ias.crudjp.service;

import com.ias.crudjp.dto.SubjectDTO;

import java.util.List;

public interface ISubjectService {

    void saveSubject(SubjectDTO subject);
    String updateSubject(SubjectDTO subject);
    String deleteSubject(Long subjectId);
    SubjectDTO getSubjectById(Long subjectId);
    List<SubjectDTO> getAllSubjects();
}
