package com.ias.crudjp.repository;

import com.ias.crudjp.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends CrudRepository<Student, Long> {
    /*
    Esta interfaz permite separar la logica de negocio de la lógica para acceder a la base de datos. Se comunica
    directamente con la base de datos.
    Forma parte de la capa de persistencia, la cual tiene acceso a los datos y puede manipularlos.
    CrudRepository es una infertaz a la que se le asignan como parámetros genéricos la entidad (Student) y el tipo
    de dato de la clave primaria que se definió en dicha entidad, en este caso id cuyo tipo es Long.
    NOTA: esta inferfaz no implementa, EXTIENDE de la interfaz CrudRepository
    Hay otra inferfaz de la que puede extender para hacer un CRUD y es mas completa que es JpaRepository
    */
}

