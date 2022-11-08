package sk.durixx.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
}
)
public class LibraryApplication {

    public static void main(String[] args) {
        // run the application
        SpringApplication.run(LibraryApplication.class, args);
    }
}
