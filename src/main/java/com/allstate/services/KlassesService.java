package com.allstate.services;

import com.allstate.entities.Klasses;
import com.allstate.repositories.IKlassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KlassesService {

    private IKlassesRepository repository;

    @Autowired
    public void setRepository(IKlassesRepository repository) {
        this.repository = repository;
    }

    public Klasses create(Klasses classes) {
        return this.repository.save(classes);
    }

    public Klasses findByName(String name) {
        return this.repository.findByName(name);
    }

    public Klasses findById(int id) {
        return this.repository.findOne(id);
    }
}
