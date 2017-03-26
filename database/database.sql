
/*1:)*/
CREATE DATABASE  IF NOT EXISTS db_agency;
USE 'db_agency';

create user 'agent'@'localhost' identified by 'gdanskOgorek';
grant all on db_agency.* to 'agent'@'localhost';


/*2:)*/
DROP TABLE IF EXISTS `contact`;

CREATE TABLE `contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `surname` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `birth_Date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
);

/*3:)*/
CREATE TABLE `category` (
`id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
   PRIMARY KEY (`id`)
);

INSERT INTO category (name) VALUES ('sluzbowy');
INSERT INTO category (name) VALUES ('prywatny');
INSERT INTO category (name) VALUES ('inny');

/*4:)*/
select * from category;
select * from contact;


describe contact