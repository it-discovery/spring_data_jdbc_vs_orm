
CREATE TABLE orders(ID varchar(40) primary key, CREATED timestamp, MODIFIED timestamp, PRODUCT int, AMOUNT int);

CREATE TABLE products(ID int IDENTITY primary key, NAME varchar(32), PRICE double, CREATED timestamp, MODIFIED timestamp, VERSION int);

