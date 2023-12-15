package dev.kknd.multipledsdemo;

import dev.kknd.multipledsdemo.post.PostService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MultipleDsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultipleDsDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PostService postService) {
        return args -> {
            var posts = postService.findAll();
            System.out.println(posts);
        };
    }

}
