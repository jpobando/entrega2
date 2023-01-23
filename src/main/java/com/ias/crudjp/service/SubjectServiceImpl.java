package com.ias.crudjp.service;

import com.ias.crudjp.dto.SubjectDTO;
import com.ias.crudjp.entity.Subject;
import com.ias.crudjp.repository.ISubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements ISubjectService {

    public final ISubjectRepository _subjectRepository;

    public SubjectServiceImpl(ISubjectRepository _subjectRepository) { this._subjectRepository = _subjectRepository; }
    @Override
    public void saveSubject(SubjectDTO subjectDTO) {
        Subject subjectToAdd = new Subject();

        subjectToAdd.setSchedule(subjectDTO.getSchedule());
        subjectToAdd.setTeacher(subjectDTO.getTeacher());
        subjectToAdd.setTopic(subjectDTO.getTopic());
        subjectToAdd.setStudentsList(subjectDTO.getStudentsList());

        Subject subjectSaved = _subjectRepository.save(subjectToAdd);

        subjectDTO.setId(subjectSaved.getId());
    }

    @Override
    public String updateSubject(SubjectDTO subjectDTO) {
        Optional<Subject> value = _subjectRepository.findById(subjectDTO.getId());
        if(value.isPresent()){
            _subjectRepository.save(new Subject(subjectDTO));
            return "Updated";
        } else {
            return "Not found";
        }
    }

    @Override
    public String deleteSubject(Long subjectId) {
        Optional<Subject> value = _subjectRepository.findById(subjectId);
        if(value.isPresent()){
            _subjectRepository.deleteById(subjectId);
            return "Deleted";
        } else {
            return "Not found";
        }
    }

    @Override
    public SubjectDTO getSubjectById(Long subjectId) {
        Optional<Subject> value = _subjectRepository.findById(subjectId);
        if(value.isPresent()){
            SubjectDTO subjectDTO = new SubjectDTO();

            subjectDTO.setId(value.get().getId());
            subjectDTO.setSchedule(value.get().getSchedule());
            subjectDTO.setTeacher(value.get().getTeacher());
            subjectDTO.setTopic(value.get().getTopic());
            subjectDTO.setStudentsList(value.get().getStudentsList());

            return subjectDTO;
        } else {
            return null;
        }
    }

    @Override
    public List<SubjectDTO> getAllSubjects() {
        List<Subject> list = (List<Subject>) _subjectRepository.findAll();
        return list.stream()
                .map(SubjectDTO::new)
                .collect(Collectors.toList());
    }
}
