package com.journal.demojournal.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "student")
public class Student 
{   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotEmpty(message = "Should not be empty")
    @Size(min = 3, max = 50, message = "Should be between 3 and 50 characters")
    @Column(name = "name")
    private String name;
    
    
    @NotEmpty(message = "Should not be empty")
    @Size(min = 3, max = 50, message = "Should be between 3 and 50 characters")
    @Column(name = "surname")
    private String sureName; 


    @NotEmpty(message = "Should not be empty")
    @Size(min = 3, max = 50, message = "Should be between 3 and 50 characters")
    @Column(name = "fathername")
    private String fatherName;

    @Column(name = "firstcolokmark")
    private int firstColokMark = 0;



    @Column(name = "secondcolokmark")
    private int secondColokMark = 0;

    @Column(name = "thirdcolokmark")
    private int thirdColokMark = 0;

    @Column(name = "firstseminarmark")
    private int firstSeminarMark = 0;
    
    @Column(name = "secondseminarmark")
    private int secondSeminarMark = 0;

    @Column(name = "thirdseminarmark")
    private int thirdSeminarMark = 0;

    @Column(name = "totalseminarsmark")
    private int totalSeminarsMark = 0;

   // @Column(name = "attendance")
    //private int attendance = 10;


public Student() {
}
public  Student(String name, Integer id, String sureName, String fatherName, int firstColokMark, int secondColokMark, int thirdColokMark,int firstSeminarMark, int secondSeminarMark, int thirdSeminarMark, int totalSeminarsMark /*int attendance*/ ) {
    this.name = name;
    this.id = id;
    this.sureName = sureName;
    this.fatherName = fatherName;
    this.firstColokMark = firstColokMark;
    this.secondColokMark = secondColokMark;
    this.thirdColokMark = thirdColokMark;
    this.firstSeminarMark = firstSeminarMark;
    this.secondSeminarMark = secondSeminarMark;
    this.thirdSeminarMark = thirdSeminarMark;
    this.totalSeminarsMark = totalSeminarsMark;
    //this.attendance = attendance;
}

public String getName() {return name;}

public void setName(String name) {this.name = name;}

public Integer getId() {return id;}

public void setId(Integer id) {this.id = id;}

public String getSureName() { return sureName;}

public void setSureName(String sureName) {this.sureName = sureName;}

public String getFatherName() {return fatherName;}

public void setFatherName(String fatherName) {this.fatherName = fatherName;}

public int getFirstColokMark() {return firstColokMark;}

public void setFirstColokMark(int firstColokMark) {
    if (firstColokMark >= 0 && firstColokMark <= 10)
    {
    this.firstColokMark = firstColokMark;
    }
    else if(firstColokMark < 0)
    {
        this.firstColokMark = 0;
    }
    else if(firstColokMark > 10)
    {
        this.firstColokMark = 10;
    }
}

public int getSecondColokMark() {return secondColokMark;}

public void setSecondColokMark(int secondColokMark) {
    if (secondColokMark >= 0 && secondColokMark <= 10)
    {
this.secondColokMark = secondColokMark;
    }
    else if(secondColokMark < 0)
    {
        this.secondColokMark = 0;
    }
    else if(secondColokMark > 10)
    {
        this.secondColokMark = 10;
    }
}

public int getThirdColokMark() {return thirdColokMark;}

public void setThirdColokMark(int thirdColokMark) {
    if (thirdColokMark >= 0 && thirdColokMark <= 10){
this.thirdColokMark = thirdColokMark;
    }
    else if(thirdColokMark < 0){
        this.thirdColokMark = 0;
    }
    else if(thirdColokMark > 10){
        this.thirdColokMark = 10;
    }
}


public int getFirstSeminarMark(){ return firstSeminarMark;}

public void setFirstSeminarMark(int firstSeminarMark){
    
    if (firstSeminarMark >= 0 && firstSeminarMark <= 10){
        this.firstSeminarMark = firstSeminarMark;
    }
    else if(firstSeminarMark < 0){
        this.firstSeminarMark = 0;
    }
    else if(firstSeminarMark > 10){
        this.firstSeminarMark = 10;
    }
}

public int getSecondSeminarMark(){ return secondSeminarMark;}

public void setSecondSeminarMark(int secondSeminarMark){
    if (secondSeminarMark >= 0 && secondSeminarMark <= 10){
        this.secondSeminarMark = secondSeminarMark;
    }
    else if(secondSeminarMark < 0){
        this.secondSeminarMark = 0;
    }
    else if(secondSeminarMark > 10){
        this.secondSeminarMark = 10;
    }
}
public int getThirdSeminarMark(){ return thirdSeminarMark;}

public void setThirdSeminarMark(int thirdSeminarMark){
    if (thirdSeminarMark >= 0 && thirdSeminarMark <= 10){
        this.thirdSeminarMark = thirdSeminarMark;
    }
    else if(thirdSeminarMark < 0){
        this.thirdSeminarMark = 0;
    }
    else if(thirdSeminarMark > 10){
        this.thirdSeminarMark = 10;
    }
}
public int getTotalSeminarsMark(){ return totalSeminarsMark;}


@PrePersist
public void setTotalSeminarsMark(){


    this.totalSeminarsMark = (this.getFirstColokMark() + this.getSecondColokMark() + this.getThirdColokMark() + this.getFirstSeminarMark() + this.getSecondSeminarMark() + this.getThirdSeminarMark())/6*3;
}
}
