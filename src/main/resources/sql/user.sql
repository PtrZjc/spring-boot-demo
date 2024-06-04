-- this is adjusted for repetitive execution mysql implementation of schema org/springframework/security/core/userdetails/jdbc/users.ddl.
-- Docs: https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/jdbc.html

CREATE TABLE IF NOT EXISTS users (
    username VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(500) NOT NULL,
    enabled TINYINT(1) NOT NULL
);

CREATE TABLE IF NOT EXISTS authorities (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users(username)
);


set @x := (select count(*) from information_schema.statistics where table_name = 'authorities' and index_name = 'ix_auth_username' and table_schema = database());
set @sql := if( @x > 0, 'select ''Index exists.''', 'CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);');
PREPARE stmt FROM @sql;
EXECUTE stmt;
