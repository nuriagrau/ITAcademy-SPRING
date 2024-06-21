package cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t01.n01.Controllers;


import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {


    @GetMapping("/HelloWorld")
    public String greet(@RequestParam(value = "nom", defaultValue = "UNKNOWN") String nom) {
        return "Hello, " + nom + ". You are executing a Maven project.";
    };

    @GetMapping(value = {"/HelloWorld2", "/HelloWorld2/{nom}"})
    String greet2(@PathVariable(required = false) String nom) {
        if (nom != null) {
            return "Hello, " + nom + ". You are executing a Maven project.";
        }
        return "Hello! You are executing a Maven project.";
    };
}
