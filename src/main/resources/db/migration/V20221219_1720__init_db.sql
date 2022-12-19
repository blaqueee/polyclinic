create table departments
(
    id   bigserial    not null
        constraint departments_pkey
            primary key,
    name varchar(255) not null
);

alter table departments
    owner to postgres;

create table diseases
(
    id    bigserial    not null
        constraint diseases_pkey
            primary key,
    cause varchar(255) not null,
    name  varchar(255) not null
);

alter table diseases
    owner to postgres;

create table doctors
(
    id                  bigserial    not null
        constraint doctors_pkey
            primary key,
    address             varchar(255) not null,
    email               varchar(255) not null,
    first_name          varchar(255) not null,
    last_name           varchar(255) not null,
    middle_name         varchar(255) not null,
    password            varchar(255) not null,
    role                varchar(255),
    experience_in_years integer      not null,
    specialization      varchar(255) not null,
    title               varchar(255) not null,
    department_id       bigint
        constraint fkl2mro81neln9topymd898urh1
            references departments
);

alter table doctors
    owner to postgres;

create table patients
(
    id          bigserial    not null
        constraint patients_pkey
            primary key,
    address     varchar(255) not null,
    email       varchar(255) not null,
    first_name  varchar(255) not null,
    last_name   varchar(255) not null,
    middle_name varchar(255) not null,
    password    varchar(255) not null,
    role        varchar(255),
    passport_id varchar(255) not null
);

alter table patients
    owner to postgres;

create table complaints
(
    id          bigserial    not null
        constraint complaints_pkey
            primary key,
    created_at  timestamp    not null,
    description varchar(255) not null,
    patient_id  bigint
        constraint fkgu176ph7v0qs5oqiihp38sw2v
            references patients
);

alter table complaints
    owner to postgres;

create table applications
(
    id           bigserial not null
        constraint applications_pkey
            primary key,
    created_at   timestamp,
    complaint_id bigint
        constraint fkr6pgnntawaaf1gdru7m0u28lt
            references complaints,
    disease_id   bigint
        constraint fk3s5ijtmfy9m7rlitms5mxqbm4
            references diseases,
    doctor_id    bigint
        constraint fkb77xblx7xjteo4myef0eqn75f
            references doctors
);

alter table applications
    owner to postgres;

create table disease_histories
(
    id         bigserial not null
        constraint disease_histories_pkey
            primary key,
    time       timestamp not null,
    disease_id bigint
        constraint fkcrsymp6dbe7hxfa5ftg9jxr8m
            references diseases,
    patient_id bigint
        constraint fketq5c7456haotvfmyh1g8depb
            references patients
);

alter table disease_histories
    owner to postgres;