package com.ias.crudjp.service;

import com.ias.crudjp.dto.StudentDTO;
import com.ias.crudjp.entity.Student;
import com.ias.crudjp.repository.IStudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService{

    public final IStudentRepository _studentRepository;

    public StudentServiceImpl(IStudentRepository _studentRepository) { this._studentRepository = _studentRepository; }

    @Override
    public void saveStudent(StudentDTO student) {
        if(!_studentRepository.existsById(student.getId())){
            Student studentToAdd = new Student();

            studentToAdd.setAge(student.getAge());
            studentToAdd.setDni(student.getDni());
            studentToAdd.setName(student.getName());
            studentToAdd.setLastname(student.getLastname());
            studentToAdd.setBirthDate(student.getBirthDate());
        }
    }

    @Override
    public String updateStudent(StudentDTO student) {
        return null;
    }

    @Override
    public String deleteStudent(Long studentId) {
        return null;
    }

    @Override
    public StudentDTO getStudentById(Long StudentId) {
        return null;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return null;
    }
}
