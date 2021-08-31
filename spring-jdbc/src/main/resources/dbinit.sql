
CREATE TABLE orders(id varchar(32) primary key, CREATED_AT timestamp, product int);

CREATE TABLE PRODUCTS(ID int IDENTITY primary key, NAME varchar(32), price double, createdAt timestamp, modifiedAt timestamp);

