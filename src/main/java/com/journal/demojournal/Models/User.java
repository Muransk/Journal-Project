package com.journal.demojournal.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message="Shouldn't be empty.")
    @Size(min=2, max = 70, message="Shouldn't be empty.")
    @Column(name="username")
    private String userName;

    @Column(name="password")
    private String password;

   
    public User( String userName, String password)
    {
        this.userName = userName;
        this.password = password;
    }


    
}
