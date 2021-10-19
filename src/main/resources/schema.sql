CREATE DATABASE MYSTERIOUS_DATABASE;
CREATE TABLE "group"
(
    id     INT PRIMARY KEY,
    name   varchar(255) NOT NULL,
    parentDTO INT REFERENCES "group" (id)
);
ALTER TABLE "group"
    ADD FOREIGN KEY (id) REFERENCES item (id);

CREATE TABLE item
(
    id               INT PRIMARY KEY,
    name             varchar(255) NOT NULL,
    base_price       MONEY        NOT NULL,
    currency         varchar(15)  NOT NULL,
    imageUrl         varchar(255),
    complexity       DOUBLE PRECISION,
    configuration_id INT REFERENCES configuration (id),
    parent_group     INT REFERENCES "group" (id)

);
ALTER TABLE item
    ADD FOREIGN KEY (id) REFERENCES "group" (id);

CREATE TABLE configuration
(
    id         serial PRIMARY KEY,
    Resolution varchar(3) NOT NULL CHECK (Resolution IN ('HD', 'FHD', '_4K'))
);

CREATE TABLE basket
(
    id   serial PRIMARY KEY,
    name varchar(255) NOT NULL
);

CREATE TABLE items_baskets
(
    item_id  INT REFERENCES item (id),
    basket_id INT REFERENCES basket (id),
    id       INT PRIMARY KEY,
    CONSTRAINT item FOREIGN KEY (basket_id) References item (id),
    CONSTRAINT "group" FOREIGN KEY (item_id) References basket (id)
);

CREATE TABLE users (
                       username varchar(15),
                       password varchar(100),
                       enabled tinyint(1),
                       PRIMARY KEY (username)
) ;

CREATE TABLE authorities (
                             username varchar(15),
                             authority varchar(25),
                             FOREIGN KEY (username) references users(username)
) ;

INSERT INTO users (username, password, enabled)
VALUES
    ('zaur', '{noop}zaur', 1),
    ('elena', '{noop}elena', 1),
    ('ivan', '{noop}ivan', 1);

INSERT INTO authorities (username, authority)
VALUES
    ('zaur', 'ROLE_EMPLOYEE'),
    ('elena', 'ROLE_HR'),
    ('ivan', 'ROLE_HR'),
    ('ivan', 'ROLE_MANAGER');

--DROP DATABASE MYSTERIOUS_DATABASE;
--DROP TABLE items_groups;
--DROP TABLE "group";
--DROP TABLE item;
--DROP TABLE configuration;