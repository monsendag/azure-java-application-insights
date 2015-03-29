CREATE TABLE todos (
  id        INT         NOT NULL               IDENTITY (1, 1),
  title     VARCHAR(60) NOT NULL,
  content   VARCHAR(600),
  completed BIT         NOT NULL               DEFAULT 0,
  CONSTRAINT todo_pk PRIMARY KEY (id)
);