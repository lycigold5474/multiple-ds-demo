DROP TABLE IF EXISTS Post;

CREATE TABLE Post (
    id varchar(255) NOT NULL,
    title varchar(255) NOT NULL,
    slug varchar(255) NOT NULL,
    date date NOT NULL,
    time_to_read int NOT NULL,
    tags varchar(255),
    PRIMARY KEY (id)
);

INSERT INTO Post(id, title, slug, date, time_to_read, tags)
VALUES ('1', 'Sample Title', 'sample-slug', '2022-12-12', 10, 'tag1,tag2');