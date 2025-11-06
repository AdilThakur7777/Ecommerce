package org.example.microservices_spring;


import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String Hello() {
        return "Hello World";
    }

    @PostMapping("/hello")
    public String helloPost(@RequestBody String name) {
        return "Hello"+name;
    }
}
