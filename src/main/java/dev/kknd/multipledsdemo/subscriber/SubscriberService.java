package dev.kknd.multipledsdemo.subscriber;

import dev.kknd.multipledsdemo.post.Post;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriberService {

    private JdbcClient jdbcClient;
    public SubscriberService(@Qualifier("subscriberJdbcClient") JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Subscriber> findAll() {
        return jdbcClient.sql("SELECT id, name, email FROM Subscriber")
                .query(Subscriber.class)
                .list();
    }
}
