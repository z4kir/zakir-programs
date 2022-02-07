package com.example.springbootfirstapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent() {
        return new Student("zakir", "Shaikh");
    }

    @GetMapping("/query")
    public Student getquery(@RequestParam(name = "firstName") String firstName,
                            @RequestParam(name = "lastName") String lastName) {
        return new Student(firstName, lastName);

    }


}
