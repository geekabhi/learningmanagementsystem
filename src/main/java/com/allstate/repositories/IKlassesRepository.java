package com.allstate.repositories;

import com.allstate.entities.Klasses;
import org.springframework.data.repository.CrudRepository;

public interface IKlassesRepository extends CrudRepository<Klasses, Integer> {

    Klasses findByName(String name);
}
