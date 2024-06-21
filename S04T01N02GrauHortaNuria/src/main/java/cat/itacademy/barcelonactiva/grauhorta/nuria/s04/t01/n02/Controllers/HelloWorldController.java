package cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t01.n02.Controllers;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class HelloWorldController {


    @GetMapping("/HelloWorld")
    public String greet(@RequestParam(value = "nom", defaultValue = "UNKNOWN") String nom) {
        return "Hello, " + nom + ". You are executing a Gradle project.";
    }


    @GetMapping(value = {"/HelloWorld2", "/HelloWorld2/{nom}"})
    public String greet2(@PathVariable(required = false) String nom) {
        if (nom != null) {
            return "Hello, " + nom + ". You are executing a Gradle project.";
        }
        return "Hello! You are executing a Gradle project.";
    }
}
