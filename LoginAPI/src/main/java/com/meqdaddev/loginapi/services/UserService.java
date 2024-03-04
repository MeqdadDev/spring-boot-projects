package com.meqdaddev.loginapi.services;

import com.meqdaddev.loginapi.models.ApplicationUser;
import com.meqdaddev.loginapi.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("In the user details service");

        if (!username.equals("Meqdad")) throw new UsernameNotFoundException("Not Meqdad");
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1, "USER"));
        return new ApplicationUser(1, "Meqdad", passwordEncoder.encode("password"), roles);
    }
}
