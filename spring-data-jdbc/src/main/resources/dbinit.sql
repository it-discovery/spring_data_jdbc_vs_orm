
CREATE TABLE orders(id varchar(32) primary key, CREATED timestamp, MODIFIED timestamp, product int);

CREATE TABLE products(ID int IDENTITY primary key, NAME varchar(32), PRICE double, CREATED timestamp, MODIFIED timestamp, VERSION int);

