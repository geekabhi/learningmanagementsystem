package com.allstate.services;

import com.allstate.entities.Teacher;
import com.allstate.enums.Gender;
import com.allstate.repositories.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {
    private ITeacherRepository repository;

    @Autowired
    public void setRepository(ITeacherRepository repository) {
        this.repository = repository;
    }


    public Teacher create(Teacher teacher) {
        return this.repository.save(teacher);
    }

    public Teacher getById(int id) {
        return this.repository.findById(id);
    }

    public Iterable<Teacher> getByGender(Gender gender) {
        return this.repository.findByGender(gender);
    }

    public Iterable<Teacher> getTeachersOlderThan(int age) {
        return this.repository.findByAgeGreaterThan(age);
    }
}
