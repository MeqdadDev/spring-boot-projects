package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.JULY;
import static java.time.Month.JUNE;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student meqdad = new Student(
                    "Meqdad",
                    "meqdad@mail.com",
                    LocalDate.of(2000, JULY, 22)
            );

            Student siwar = new Student(
                    "Siwar",
                    "siwar@mail.com",
                    LocalDate.of(2005, JUNE, 7)
            );
            repository.saveAll(
                    List.of(meqdad, siwar)
            );
        };
    }
}
