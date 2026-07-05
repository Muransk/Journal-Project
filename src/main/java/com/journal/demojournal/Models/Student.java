package com.journal.demojournal.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "student")
public class Student 
{   @Id
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "Should not be empty")
    @Size(min = 3, max = 50, message = "Should be between 3 and 50 characters")
    @Column(name = "name")
    private String name;  
    
    @Column(name = "surname")
    private String sureName; 

public Student() {
}
public  Student(String name, int id, String sureName) {
    this.name = name;
    this.id = id;
    this.sureName = sureName;
}

public String getName() {
    return name;

}

public void setName(String name) {
    this.name = name;
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getSureName() { 
    return sureName;
}

public void setSureName(String sureName) {
    this.sureName = sureName;
}
}
