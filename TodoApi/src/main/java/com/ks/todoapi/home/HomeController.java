package com.ks.todoapi.home;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String greeting(){
        return "Welcome to SpringBoot";
    }

    @GetMapping("/{name}")
    public String greetingWithName(@PathVariable String name){
        return "Welcome " + name + " to SpringBoot";

    }

}
