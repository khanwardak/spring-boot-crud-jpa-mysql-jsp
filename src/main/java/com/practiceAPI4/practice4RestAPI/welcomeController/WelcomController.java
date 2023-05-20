package com.practiceAPI4.practice4RestAPI.welcomeController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomController {
//    hrer we retun string value
    @GetMapping(path = "/")
    public String welcome(){
        return "Welcome this welcome Controller";
    }

//    here we can retrun bean or oject of a class as json using restAPI

    @GetMapping(path = "json")

    public HelloBean welcomController(){
        return  new HelloBean("Hello this welcome Conroller");
    }
    @GetMapping(path = "json/{name}")

    public HelloBean pathVariable(@PathVariable String name){
        return  new HelloBean("Hello this welcome Conroller" + name);
    }
}
