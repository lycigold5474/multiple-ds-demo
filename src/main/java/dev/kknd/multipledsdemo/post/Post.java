package dev.kknd.multipledsdemo.post;

import java.time.LocalDate;

public record Post(
        String id,
        String title,
        String slug,
        LocalDate date,
        int timeToRead,
        String tags
) {

}
