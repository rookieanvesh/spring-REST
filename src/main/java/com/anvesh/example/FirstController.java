package com.anvesh.example;

import org.springframework.web.bind.annotation.*;

@RestController//this rest controller is used at the class level and it indicates that the annotated class is used as a rest controller,
//spring's component scanning mechanism detects these classes and creates the beans of them in the application context
public class FirstController {
   // @GetMapping("/hello")
    public String sayHello(){
        return "hello from 1st controller";
    }
/*
    @GetMapping("/hello-2")
    @ResponseStatus(HttpStatus.ACCEPTED)//this is an enum class which has http objects and gives us status codes, by convention we should use this
    public String sayHello2(){
        return "hello from 2nd controller";
    }
*/
    @PostMapping("/post")
    public String post(@RequestBody String message){//in order to send a message we give it a body message
        return "request accepted and message" + message;
    }
    @PostMapping("/post-order")
    public String postOrder(@RequestBody Order order){
        return "request accepted and message" + order.toString();
    }

    @PostMapping("/post-order-record")
    public String postRecord(@RequestBody OrderRecord order){
        return "request accepted and message" + order.toString();
    }
    //http
    //@GetMapping("/hello/{user-name}")
    public String pathVar(@PathVariable("user-name") String userName){
        //we would always want to use @PathVariable inside the parameter as this would tell spring that this is the variable that is used in the path
        return "my value = " + userName;
    }
    //http://localhost:8080/hello?param_name=paramvalue&param_name_2=value2
    @GetMapping("/hello")
    public String paramVar(
            @RequestParam("user-name")String userFirstName,
            @RequestParam("user-lastname")String userLastName
            ){
        return "my value = " + userFirstName + " " + userLastName;
    }
}
