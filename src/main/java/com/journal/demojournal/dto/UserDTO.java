package com.journal.demojournal.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    

    @NotEmpty(message="Shouldn't be empty.")
    @Size(min=2, max = 70, message="Shouldn't be empty.")
    private String userName;

    private String password;

     public UserDTO( String userName, String password)
    {
        this.userName = userName;
        this.password = password;
    }

}
