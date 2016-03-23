package vtn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("vtn")
public class MvcStandaloneApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MvcStandaloneApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MvcStandaloneApplication.class);
    }
}
