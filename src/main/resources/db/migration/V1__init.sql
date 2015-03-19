CREATE TABLE todos (
  id        INT(6)       NOT NULL               AUTO_INCREMENT,
  title     VARCHAR(60)  NOT NULL,
  content   VARCHAR(600) NOT NULL,
  completed BOOLEAN      NOT NULL               DEFAULT FALSE,
  CONSTRAINT todo_pk PRIMARY KEY (id)
);