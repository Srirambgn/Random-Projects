# Coding Projects!
# New thing im working on, not completed yet:
## Custom Database Engine

Compile and start the text-based database with:

```text
javac CustomDatabase.java
java CustomDatabase
```

Tables are stored as `.table` CSV files in `database_data/`. A different directory can be supplied as the first argument.

Supported commands:

```text
CREATE TABLE users (id, name, age);
INSERT INTO users VALUES (1, 'Alice', 30);
SELECT * FROM users;
SELECT name, age FROM users WHERE id = 1;
SHOW TABLES;
```
