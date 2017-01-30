package com.allstate.services;


import com.allstate.entities.Student;
import com.allstate.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private IStudentRepository repository;

    @Autowired
    public void setRepository(IStudentRepository repository) {
        this.repository = repository;
    }

    public Student create(String email) {
        Student student = new Student();
        student.setEmail(email);
        return this.create(student);
    }

    public Student create(Student student) {
        return this.repository.save(student);
    }

    public Student findById(int Id) {
        return this.repository.findOne(Id);
    }

    public Student findByEmail(String email) {
        return this.repository.findByEmail(email);
    }
}

