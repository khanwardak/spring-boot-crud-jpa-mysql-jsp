package com.practiceAPI4.practice4RestAPI.welcomeController;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class WelcomController {
//    constructor injection done
    private MessageSource messageSource;

    public WelcomController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    //    hrer we retun string value
    @GetMapping(path = "/")
    public String welcome(){
        return "Welcome this welcome Controller";
    }
//    this acept lenguage header and how message in multiple language
    @GetMapping(path = "/internationalization")
    public String internationalization(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("pashto.morning.message",null,"Default Message",locale);
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
