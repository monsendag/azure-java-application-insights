/*
---DEVELOPMENT---
SQL init som brukes når applikasjonen benytter Spring profile 'development', typisk til utvikling på localhost.
DB scripts som brukes av Flyway for Spring profile 'production' ligger i scr/main/resources/db/migration
 */
CREATE TABLE todos (
  id        INT(6)      NOT NULL               AUTO_INCREMENT,
  title     VARCHAR(60) NOT NULL,
  content   VARCHAR(600),
  completed BOOLEAN     NOT NULL               DEFAULT FALSE,
  CONSTRAINT todo_pk PRIMARY KEY (id)
);