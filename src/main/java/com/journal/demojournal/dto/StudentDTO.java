package com.journal.demojournal.dto;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@DynamicInsert
@Getter
public class StudentDTO {
    

    @NotEmpty(message = "Should not be empty")
    @Size(min = 3, max = 50, message = "Should be between 3 and 50 characters")
    private String name;
    
    
    @NotEmpty(message = "Should not be empty")
    @Size(min = 3, max = 50, message = "Should be between 3 and 50 characters")
    private String sureName; 


    @NotEmpty(message = "Should not be empty")
    @Size(min = 3, max = 50, message = "Should be between 3 and 50 characters")
    private String fatherName;


    @ColumnDefault("0")
    private Integer firstColokMark = 0;


    @ColumnDefault("0")
    private Integer secondColokMark = 0;

    @ColumnDefault("0")
    private Integer thirdColokMark = 0;

    @ColumnDefault("0")
    private Integer firstSeminarMark = 0;
    
    @ColumnDefault("0")
    private Integer secondSeminarMark = 0;

    @ColumnDefault("0")
    private Integer thirdSeminarMark = 0;

    public StudentDTO(String name, String sureName, String fatherName, Integer firstColokMark, Integer secondColokMark, Integer thirdColokMark,Integer firstSeminarMark, Integer secondSeminarMark, Integer thirdSeminarMark ){
        this.name = name;
        this.sureName = sureName;
        this.fatherName = fatherName;
        this.firstColokMark = firstColokMark;
        this.secondColokMark = secondColokMark;
        this. thirdColokMark = thirdColokMark;
        this.firstSeminarMark = firstSeminarMark;
        this.secondSeminarMark = secondSeminarMark;
        this.thirdSeminarMark = thirdSeminarMark;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public  void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

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

}
