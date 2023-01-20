package com.ias.crudjp.repository;

import com.ias.crudjp.entity.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface ITeacherRepository extends CrudRepository<Teacher,Long> {
}
