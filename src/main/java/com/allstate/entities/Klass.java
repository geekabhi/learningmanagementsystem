package com.allstate.entities;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "klasses")
public class Klass {

    private int id;
    private int version;
    private String name;
    private Date semester;
    private int credits;
    private String department;
    private Double fee;
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
    public Date getSemester() {
        return semester;
    }
    public void setSemester(Date semester) {
        this.semester = semester;
    }

    @NotNull
    @Min(value = 0)
    public int getCredits() {
        return credits;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Column(nullable = false, columnDefinition = "ENUM('SCIENCE', 'ENGINEERING', 'LITERATURE', 'PHILOSOPHY')")
    @NotNull
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    @NotNull
    public Double getFee() {
        return fee;
    }
    public void setFee(Double fee) {
        this.fee = fee;
    }

    @CreationTimestamp
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }

    @UpdateTimestamp
    public Date getModified() {
        return modified;
    }
    public void setModified(Date modified) {
        this.modified = modified;
    }



}