package com.journal.demojournal.Models;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

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
@DynamicInsert
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
    @ColumnDefault("0")
    private Integer firstColokMark = 0;



    @Column(name = "secondcolokmark")
    @ColumnDefault("0")
    private Integer secondColokMark = 0;

    @Column(name = "thirdcolokmark")
    @ColumnDefault("0")
    private Integer thirdColokMark = 0;

    @Column(name = "firstseminarmark")
    @ColumnDefault("0")
    private Integer firstSeminarMark = 0;
    
    @Column(name = "secondseminarmark")
    @ColumnDefault("0")
    private Integer secondSeminarMark = 0;

    @Column(name = "thirdseminarmark")
    @ColumnDefault("0")
    private Integer thirdSeminarMark = 0;

    @Column(name = "totalseminarsmark")
    private Integer totalSeminarsMark = 0;

   // @Column(name = "attendance")
    //private int attendance = 10;


public Student() {
}
public  Student(String name, Integer id, String sureName, String fatherName, Integer firstColokMark, Integer secondColokMark, Integer thirdColokMark,Integer firstSeminarMark, Integer secondSeminarMark, Integer thirdSeminarMark, Integer totalSeminarsMark /*int attendance*/ ) {
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

public Integer getFirstColokMark() {return firstColokMark;}

public void setFirstColokMark(Integer firstColokMark) {

    if (firstColokMark == null){this.firstColokMark = 0; return;}

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

public Integer getSecondColokMark() {return secondColokMark;}

public void setSecondColokMark(Integer secondColokMark) {

     if (secondColokMark == null){this.secondColokMark = 0; return;}

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

public Integer getThirdColokMark() {return thirdColokMark;}

public void setThirdColokMark(Integer thirdColokMark) {

     if (thirdColokMark == null){this.thirdColokMark = 0; return;}

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


public Integer getFirstSeminarMark(){ return firstSeminarMark;}

public void setFirstSeminarMark(Integer firstSeminarMark){

     if (firstSeminarMark == null){this.firstSeminarMark = 0; return;}
    
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

public Integer getSecondSeminarMark(){ return secondSeminarMark;}

public void setSecondSeminarMark(Integer secondSeminarMark){

    if (secondSeminarMark == null){this.secondSeminarMark = 0; return;}

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
public Integer getThirdSeminarMark(){ return thirdSeminarMark;}

public void setThirdSeminarMark(Integer thirdSeminarMark){

    if (thirdSeminarMark == null){this.thirdSeminarMark = 0; return;}

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
public Integer getTotalSeminarsMark(){ return totalSeminarsMark;}


@PrePersist
public void setTotalSeminarsMark(){


   // this.totalSeminarsMark = (this.getFirstColokMark() + this.getSecondColokMark() + this.getThirdColokMark() + this.getFirstSeminarMark() + this.getSecondSeminarMark() + this.getThirdSeminarMark())/6*3;

    this.totalSeminarsMark =
        ((firstColokMark != null ? firstColokMark : 0) +
        (secondColokMark != null ? secondColokMark : 0) +
        (thirdColokMark != null ? thirdColokMark : 0) +
        (firstSeminarMark != null ? firstSeminarMark : 0) +
        (secondSeminarMark != null ? secondSeminarMark : 0) +
        (thirdSeminarMark != null ? thirdSeminarMark : 0))/6*3;


}

}
