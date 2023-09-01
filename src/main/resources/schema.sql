CREATE TABLE if NOT EXISTS article
(
    id             integer NOT NULL PRIMARY KEY AUTO_INCREMENT,
    title          varchar(255),
    description    varchar(255),
    sort_order     integer,
    media          varchar(255),
    sub_content    varchar(255),
    category       varchar(255)
);