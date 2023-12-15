package dev.kknd.multipledsdemo;

import dev.kknd.multipledsdemo.post.Post;
import dev.kknd.multipledsdemo.post.PostService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class MultipleDsDemoApplication {
    private static final Logger logger = LoggerFactory.getLogger(MultipleDsDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MultipleDsDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PostService postService) {
        return args -> {
            List<Post> posts = postService.findAll();
            if (logger.isInfoEnabled()) {
                logger.info(posts.toString());
            }
        };
    }

    @Bean
    CommandLineRunner dsCommandLineRunner(DataSource dataSource) {
        return args -> {
            try {
                logger.info(dataSource.getConnection().getMetaData().getURL());
            } catch (SQLException e) {
                logger.error("Error getting datasource URL", e);
            }
        };
    }
}
