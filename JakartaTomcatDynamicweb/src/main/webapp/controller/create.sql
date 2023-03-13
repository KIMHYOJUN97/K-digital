create table student(
    id      varchar2(20) constraint student_id_pk primary key,
    name    varchar(15) constraint student_name_nn not null,
    gender  varchar(3) constraint student_gender_nn not null,
    korean  number(3) constraint student_korean not null,
    english number(3) constraint student_english_nn not null,
    math    number(3) constraint student_math_nn not null,
    science number(3) constraint student_science_nn not null,
);