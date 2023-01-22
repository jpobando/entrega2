package com.ias.crudjp.service;

import com.ias.crudjp.dto.TeacherDTO;
import com.ias.crudjp.entity.Teacher;
import com.ias.crudjp.repository.ITeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements ITeacherService{

    private final ITeacherRepository _teacherRepository;

    //Inyección de dependencias
    public TeacherServiceImpl(ITeacherRepository _teacherRepository) { this._teacherRepository = _teacherRepository; }
    @Override
    public void saveTeacher(TeacherDTO teacher) {

        if(!_teacherRepository.existsById(teacher.getId())){
            Teacher teacherToAdd = new Teacher();

            //Mapeo entre Teacher (Entidad necesaria para guardar el registro) y el DTO (parametros de la función)
            teacherToAdd.setAge(teacher.getAge());
            teacherToAdd.setDni(teacher.getDni());
            teacherToAdd.setName(teacher.getName());
            teacherToAdd.setLastname(teacher.getLastname());

            //Guardo el registro y me retorna el mismo pero con el ID que quedo en la base datos
            Teacher teacherSaved = _teacherRepository.save(teacherToAdd);

            //Le agrego el ID a la entidad
            teacher.setId(teacherSaved.getId());
        }
        //Instancia de la entidad teacher necesaria para persistir en la base de datos
        /*Teacher teacherToAdd = new Teacher();

        //Mapeo entre Teacher (Entidad necesaria para guardar el registro) y el DTO (parametros de la función)
        teacherToAdd.setAge(teacherdto.getAge());
        teacherToAdd.setDni(teacherdto.getDni());
        teacherToAdd.setName(teacherdto.getName());
        teacherToAdd.setLastname(teacherdto.getLastname());

        //Guardo el registro y me retorna el mismo pero con el ID que quedo en la base datos
        Teacher teacherSaved = _teacherRepository.save(teacherToAdd);

        //Le agrego el ID a la entidad
        teacherdto.setId(teacherSaved.getId());
        */
    }

    @Override
    public String updateTeacher(TeacherDTO teacher) {
        Optional<Teacher> value = _teacherRepository.findById(teacher.getId());
        if(value.isPresent()){
            _teacherRepository.save(new Teacher(teacher));
            return "Updated";
        } else {
            return "Not exists";
        }
    }

    @Override
    public String deleteTeacher(Long teacherId) {
        Optional<Teacher> value = _teacherRepository.findById(teacherId);
        if(value.isPresent()){
            _teacherRepository.deleteById(teacherId);
            return "Updated";
        } else {
            return "Not exists";
        }
    }

    @Override
    public TeacherDTO getTeacherById(Long teacherId) {
        Optional<Teacher> value = _teacherRepository.findById(teacherId);
        if(value.isPresent()){

            //Objeto DTO que debe ser retornado por el metodo
            TeacherDTO teacherDto= new TeacherDTO();

           //Se llenan los campos del DTO con el objeto retornado de la base de datos
            teacherDto.setAge(value.get().getAge());
            teacherDto.setId(value.get().getId());
            teacherDto.setDni(value.get().getDni());
            teacherDto.setName(value.get().getName());
            teacherDto.setLastname(value.get().getLastname());

            return teacherDto;
        } else {
            return null;
        }
    }

    @Override
    public List<TeacherDTO> getAllTeachers() {
        List<Teacher> list = (List<Teacher>) _teacherRepository.findAll();
        return list.stream()
                .map(TeacherDTO::new)
                .collect(Collectors.toList());
    }
}
