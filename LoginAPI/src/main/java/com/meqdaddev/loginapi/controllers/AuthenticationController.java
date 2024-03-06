package com.meqdaddev.loginapi.controllers;

import com.meqdaddev.loginapi.dto.RegistrationDTO;
import com.meqdaddev.loginapi.models.ApplicationUser;
import com.meqdaddev.loginapi.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO registrationDTO) {

        return authenticationService.registerUser(registrationDTO.getUsername(), registrationDTO.getPassword());
    }

}
