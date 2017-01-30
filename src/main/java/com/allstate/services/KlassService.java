package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.repositories.IKlassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KlassService {

    private IKlassRepository repository;

    @Autowired
    public void setRepository(IKlassRepository repository) {
        this.repository = repository;
    }

    public Klass create(Klass classes) {
        return this.repository.save(classes);
    }

    public Klass findByName(String name) {
        return this.repository.findByName(name);
    }

    public Klass findById(int id) {
        return this.repository.findOne(id);
    }
}
