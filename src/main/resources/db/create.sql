SET MODE PostgreSQL;
 CREATE TABLE IF NOT EXISTS jobs(
    id int PRIMARY KEY auto_increment,
    title VARCHAR,
    description  VARCHAR,
     tel int
 );