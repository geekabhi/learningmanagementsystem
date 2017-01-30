package com.allstate.repositories;


import com.allstate.entities.Teacher;
import com.allstate.enums.Gender;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ITeacherRepository extends CrudRepository<Teacher,Integer>{
    Teacher findById(int id);

    Iterable<Teacher> findByGender(Gender gender);

    Iterable<Teacher> findByAgeGreaterThan(int age);
}
