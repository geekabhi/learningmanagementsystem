package com.allstate.entities;


import com.allstate.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "teachers")
@Data
public class Teacher {

    private int id;
    private String name;
    private int age;
    private Gender gender;
    private Klass klass_id;
    private Date created;
    private Date modified;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Column(nullable = false, columnDefinition = "ENUM('Male', 'Female')")
    @Enumerated(EnumType.STRING)
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @ManyToOne
    @JoinColumn(name = "klass_id")
    @JsonIgnore
    public Klass getKlass_id() {
        return klass_id;
    }
    public void setKlass_id(Klass klass_id) {
        this.klass_id = klass_id;
    }
}
