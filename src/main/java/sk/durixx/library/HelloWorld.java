package sk.durixx.library;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HelloWorld {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }
}
