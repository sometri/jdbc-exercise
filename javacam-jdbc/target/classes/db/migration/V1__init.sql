CREATE SEQUENCE IF NOT EXISTS td_student_stu_id_seq MINVALUE 1;
CREATE SEQUENCE IF NOT EXISTS td_lesson_les_id_seq MINVALUE 1;
DROP TABLE IF EXISTS public.td_student;
CREATE TABLE IF NOT EXISTS public.td_student
(
    stu_id bigint NOT NULL DEFAULT nextval('td_student_stu_id_seq'::regclass),
    stu_first_name character varying(30) COLLATE pg_catalog."default" NOT NULL,
    stu_last_name character varying(30) COLLATE pg_catalog."default" NOT NULL,
    stu_dob timestamp without time zone NOT NULL,
    CONSTRAINT td_student_pkey PRIMARY KEY (stu_id)
);

DROP TABLE IF EXISTS public.td_lesson;
CREATE TABLE IF NOT EXISTS public.td_lesson
(
    les_id bigint NOT NULL DEFAULT nextval('td_lesson_les_id_seq'::regclass),
    les_name character varying(30) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT td_lesson_pkey PRIMARY KEY (les_id)
);