CREATE TABLE Books (
	id_book integer NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	book_name varchar(30) NOT NULL,
	author varchar(30) NOT NULL,
	year_of_writing integer NOT NULL,
	country varchar(30) NOT NULL
);

CREATE TABLE Warehouses (
	id_warehouse integer NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	adress_warehouse varchar(100) NOT NULL

);

CREATE TABLE Customers (
	id_customer integer NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	customer_name varchar(30) NOT NULL,
	customer_sex varchar(10) NOT NULL,
	customer_age integer NOT NULL

);

CREATE TABLE Suppliers (
	id_supplier integer NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	supplier_name varchar(30) NOT NULL

);

CREATE TABLE Books_at_warehouse (
	id_warehouse integer NOT NULL,
	id_book integer NOT NULL,
	quantity_in_stock integer NOT NULL,
	CONSTRAINT FK_Books_at_warehouse_id_warehouse FOREIGN KEY (id_warehouse) REFERENCES Warehouses (id_warehouse),
	CONSTRAINT FK_Books_at_warehouse_id_book FOREIGN KEY (id_book) REFERENCES Books (id_book),
	CONSTRAINT PK_Books_at_warehouse_book_at_warehouse PRIMARY KEY (id_warehouse, id_book)

);

CREATE TABLE Staff (
	id_employee integer NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	employee_name varchar(30) NOT NULL,
	employee_sex varchar(10) NOT NULL,
	job_title varchar(20) NOT NULL,
	experience integer NOT NULL,
	id_warehouse integer NOT NULL,
	CONSTRAINT FK_Staff_id_warehouse FOREIGN KEY (id_warehouse) REFERENCES Warehouses (id_warehouse)

);

CREATE TABLE Supplies (
	id_supply integer NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	id_supplier integer NOT NULL,
	id_warehouse integer NOT NULL,
	date_of_delivery date NOT NULL,
	CONSTRAINT FK_Supplies_id_supplier FOREIGN KEY (id_supplier) REFERENCES Suppliers (id_supplier),
	CONSTRAINT FK_Supplies_id_warehouse FOREIGN KEY (id_warehouse) REFERENCES Warehouses (id_warehouse)

);

CREATE TABLE Orders (
	id_order integer NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	date_of_order TIMESTAMP(3) NOT NULL,
	order_cost float NOT NULL,
	id_customer integer NOT NULL,
	id_warehouse integer NOT NULL,
	CONSTRAINT FK_Orders_id_customer FOREIGN KEY (id_customer) REFERENCES Customers (id_customer),
	CONSTRAINT FK_Orders_id_warehouse FOREIGN KEY (id_warehouse) REFERENCES Warehouses (id_warehouse)

);

CREATE TABLE Books_in_order (
	id_order integer NOT NULL,
	id_book integer NOT NULL,
	quantity_in_order integer NOT NULL,
	id_supply integer NOT NULL,
	CONSTRAINT FK_Books_in_order_id_order FOREIGN KEY (id_order) REFERENCES Orders (id_order),
	CONSTRAINT FK_Books_in_order_id_book FOREIGN KEY (id_book) REFERENCES Books (id_book),
	CONSTRAINT FK_Books_in_order_id_supply FOREIGN KEY (id_supply) REFERENCES Supplies (id_supply),
	CONSTRAINT PK_Books_in_order_book_in_order PRIMARY KEY (id_order, id_book)

);

CREATE TABLE Books_in_supply (
	id_supply integer NOT NULL,
	id_book integer NOT NULL,
	quantity_in_supply integer NOT NULL,
	book_price integer NOT NULL,
	CONSTRAINT FK_Books_in_supply_id_supply FOREIGN KEY (id_supply) REFERENCES Supplies (id_supply),
	CONSTRAINT FK_Books_in_supply_id_book FOREIGN KEY (id_book) REFERENCES Books (id_book),
	CONSTRAINT PK_Books_in_supply_book_in_supply PRIMARY KEY (id_supply, id_book)

);
