package com.ias.crudjp.repository;

import com.ias.crudjp.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends CrudRepository<Student, Long> {
    // en CrudRepository se le asignan como parámetros genéricos la entidad (Student) y el tipo de dato de la clave
    // primario que se definió en dicha entidad, en este caso id cuyo tipo es Long
}

