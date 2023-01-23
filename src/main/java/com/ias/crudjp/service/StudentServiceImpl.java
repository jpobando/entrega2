package com.ias.crudjp.service;

import com.ias.crudjp.dto.StudentDTO;
import com.ias.crudjp.entity.Student;
import com.ias.crudjp.repository.IStudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements IStudentService{

    public final IStudentRepository _studentRepository;

    public StudentServiceImpl(IStudentRepository _studentRepository) { this._studentRepository = _studentRepository; }

    @Override
    public void saveStudent(StudentDTO studentDTO) {
        if(!_studentRepository.existsById(studentDTO.getId())){
            Student studentToAdd = new Student();

            studentToAdd.setAge(studentDTO.getAge());
            studentToAdd.setDni(studentDTO.getDni());
            studentToAdd.setName(studentDTO.getName());
            studentToAdd.setLastname(studentDTO.getLastname());
            studentToAdd.setBirthDate(studentDTO.getBirthDate());

            Student studentSaved = _studentRepository.save(studentToAdd);

            studentDTO.setId(studentSaved.getId());
        }
    }

    @Override
    public String updateStudent(StudentDTO studentDTO) {
        Optional<Student> value = _studentRepository.findById(studentDTO.getId());
        if(value.isPresent()){
            _studentRepository.save(new Student(studentDTO));
            return "Updated";
        } else {
            return "Not exists";
        }
    }

    @Override
    public String deleteStudent(Long studentId) {
        Optional<Student> value = _studentRepository.findById(studentId);
        if(value.isPresent()){
            _studentRepository.deleteById(studentId);
            return "Deleted";
        } else {
            return "Not found";
        }
    }

    @Override
    public StudentDTO getStudentById(Long StudentId) {
        Optional<Student> value = _studentRepository.findById(StudentId);
        if(value.isPresent()) {
            StudentDTO studentDTO = new StudentDTO();

            studentDTO.setId(value.get().getId());
            studentDTO.setAge(value.get().getAge());
            studentDTO.setDni(value.get().getDni());
            studentDTO.setName(value.get().getName());
            studentDTO.setLastname(value.get().getLastname());
            studentDTO.setBirthDate(value.get().getBirthDate());

            return studentDTO;
        } else {
            return null;
        }
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> list = (List<Student>) _studentRepository.findAll();
        return list.stream()
                .map(StudentDTO::new)
                .collect(Collectors.toList());
    }
}
