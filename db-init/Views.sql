USE [dammmn]


--отчет по кол-ву заказов и заработанным средствам по месяцам
select * from Orders_by_months order by Year, Month

EXEC sp_helptext 'Orders_by_months'


--все заказы данного покупателя
select * from Orders_of_customer where id_customer = 500

EXEC sp_helptext 'Orders_of_customer'


--все книги, купленные покупателем
select * from Customer_books where Customer = 819

EXEC sp_helptext 'Customer_books'
GO

CREATE OR ALTER VIEW Stored_Books
AS
SELECT id_warehouse AS Warehouse, Books_at_warehouse.id_book AS Book_ID, book_name AS Book, quantity_in_stock AS Quantity
FROM dbo.Books_at_warehouse
INNER JOIN dbo.Books on Books.id_book = Books_at_warehouse.id_book
WITH CHECK OPTION
GO

--Список книг на складе
select * from Stored_Books where Warehouse = 100

UPDATE Stored_Books
SET Quantity = Quantity - 5
WHERE Warehouse = 100 and Book_ID = 30

select * from Stored_Books where Warehouse = 100
GO



SET NUMERIC_ROUNDABORT OFF
SET ANSI_PADDING, ANSI_WARNINGS, CONCAT_NULL_YIELDS_NULL,
ARITHABORT, QUOTED_IDENTIFIER, ANSI_NULLS ON
GO

CREATE OR ALTER VIEW Warehouse_staff
WITH SCHEMABINDING
AS
	SELECT id_warehouse AS Warehouse, id_employee AS Employee
	FROM dbo.Staff
GO

CREATE UNIQUE CLUSTERED INDEX IX_EMP ON Warehouse_staff(Warehouse, Employee)
DROP INDEX Warehouse_staff.IX_EMP

select * from Warehouse_staff
select * from Warehouse_staff WITH (NOEXPAND)