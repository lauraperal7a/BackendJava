
create table IF NOT EXISTS address (id int auto_increment primary key,street varchar(255),number varchar (255),location varchar (255),province varchar (255));
create table IF NOT EXISTS patients (id int auto_increment primary key,name varchar(255),lastName varchar (255),dni varchar (255),entryDate TIMESTAMP WITHOUT TIME ZONE,address_id int);
create table IF NOT EXISTS dentists (id int auto_increment primary key,name varchar(255),lastName varchar (255),licenseNumber int);
