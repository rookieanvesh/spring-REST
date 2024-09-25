package com.anvesh.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping("/hello")
    public String sayHello(){
        return "hello from 1st controller";
    }
    @GetMapping("/hello-2")
    @ResponseStatus(HttpStatus.ACCEPTED)//this is an enum class which has http objects and gives us status codes, by convention we should use this
    public String sayHello2(){
        return "hello from 2nd controller";
    }
}
