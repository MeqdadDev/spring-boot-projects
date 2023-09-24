package com.springprojects.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/app")
public class AppController {

    @GetMapping("/hi")
    public ResponseEntity<String> sayHi(){
        System.out.println("Say hi");
        return ResponseEntity.ok("Hi from secured endpoint");
    }
}
