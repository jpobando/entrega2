package com.ias.crudjp.repository;

import com.ias.crudjp.entity.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubjectRepository extends CrudRepository<Subject, Long> {

}
