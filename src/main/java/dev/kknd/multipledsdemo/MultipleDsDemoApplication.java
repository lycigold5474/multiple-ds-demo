package dev.kknd.multipledsdemo;

import dev.kknd.multipledsdemo.post.Post;
import dev.kknd.multipledsdemo.post.PostService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class MultipleDsDemoApplication {
    private static final Logger logger = LoggerFactory.getLogger(MultipleDsDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MultipleDsDemoApplication.class, args);
    }

    @Bean
    JdbcClient blogJdbcClient(@Qualifier("blogDataSource") DataSource dataSource) {
        return JdbcClient.create(dataSource);
    }

    @Bean
    JdbcClient subscriberJdbcClient(@Qualifier("subscriberDataSource") DataSource dataSource) {
        return JdbcClient.create(dataSource);
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
    CommandLineRunner dsCommandLineRunner(@Qualifier("blogDataSource") DataSource blogDataSource, @Qualifier("subscriberDataSource") DataSource subscriberDataSource) {
        return args -> {
            try {
                logger.info(blogDataSource.getConnection().getMetaData().getURL());
                logger.info(subscriberDataSource.getConnection().getMetaData().getURL());
            } catch (SQLException e) {
                logger.error("Error getting datasource URL", e);
            }
        };
    }
}
