package com.ias.crudjp.service;

import com.ias.crudjp.dto.TeacherDTO;
import com.ias.crudjp.entity.Teacher;
import com.ias.crudjp.repository.ITeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService implements ITeacherService{

    private ITeacherRepository _teacherRepository;
    @Override
    public TeacherDTO addTeacher(TeacherDTO teacherdto) {
        //Instancia de la entidad teacher necesaria para persistir en la base de datos
        Teacher teacherToAdd = new Teacher();

        //Mapeo entre Teacher (Entidad necesaria para guardar el registro) y el DTO (parametros de la función)
        teacherToAdd.setAge(teacherdto.getAge());
        teacherToAdd.setDni(teacherdto.getDni());
        teacherToAdd.setName(teacherdto.getName());
        teacherToAdd.setLastname(teacherdto.getLastname());

        //Guardo el registro y me retorna el mismo pero con el ID que quedo en la base datos
        Teacher teacherSaved = _teacherRepository.save(teacherToAdd);

        //Le agrego el ID a la entidad
        teacherdto.setId(teacherSaved.getId());

       return teacherdto;
    }

    @Override
    public void updateTeacher(TeacherDTO teacher) {

    }

    @Override
    public void deleteTeacher(Long teacherId) {

    }

    @Override
    public TeacherDTO getTeacherById(Long teacherId) {
        return null;
    }

    @Override
    public List<TeacherDTO> getAllTeachers() {
        return null;
    }
}
