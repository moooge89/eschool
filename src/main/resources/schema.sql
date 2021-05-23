drop table if exists student;

create table student(
    id serial not null,
    name varchar,
    surname varchar,
    grade int,
    favoriteSubject varchar
);