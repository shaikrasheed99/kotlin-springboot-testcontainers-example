create table if not exists users (
    username text primary key,
    password text,
    email text,
    role text
);