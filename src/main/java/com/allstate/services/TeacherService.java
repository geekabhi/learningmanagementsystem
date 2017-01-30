package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.entities.Teacher;
import com.allstate.enums.Gender;
import com.allstate.repositories.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

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

    public Teacher findById(int id) {
        return this.repository.findById(id);
    }

    public Teacher findByName(String name ) { return  this.repository.findByName(name); }

    public Iterable<Teacher> findByGender(Gender gender) {
        return this.repository.findByGender(gender);
    }

    public Iterable<Teacher> findByAgeGreaterThan(int age) {
        return this.repository.findByAgeGreaterThan(age);
    }

    @Transactional
    public List<Klass> findAllClassesByTeacherName(String name) {
        return this.findByName(name).getKlasses();
    }
}
