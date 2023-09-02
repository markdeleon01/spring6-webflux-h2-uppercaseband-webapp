CREATE TABLE if NOT EXISTS article
(
    id             integer NOT NULL PRIMARY KEY AUTO_INCREMENT,
    title          varchar(255),
    description    varchar(255),
    display_order  integer,
    media          varchar(255),
    sub_content    varchar(255),
    category       varchar(255)
);

CREATE TABLE if NOT EXISTS media
(
    id             integer NOT NULL PRIMARY KEY AUTO_INCREMENT,
    type           varchar(255),
    path           varchar(255)
);