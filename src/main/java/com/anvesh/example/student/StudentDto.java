package com.anvesh.example.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        //providing custom error message through message field
        @NotEmpty(message = "first name should not be empty")
        String firstname,
        @NotEmpty
        String lastname,
        String email,
        Integer schoolId
){

}
