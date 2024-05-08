CREATE OR ALTER PROCEDURE Create_customer
@cstName nvarchar(30), @cstSex nvarchar(10), @cstAge INT
AS
IF (LEN(@cstName) > 10 and (@cstSex = 'male' or @cstSex = 'female') and @cstAge between 1 and 100)
	INSERT INTO dbo.Customers VALUES
		(@cstName, @cstSex, @cstAge)
ELSE RETURN -1

DROP PROCEDURE Create_customer
GO


CREATE OR ALTER PROCEDURE Get_statistics
@year INT, @month INT
AS
IF @month between 1 and 12 and @year between 2020 and DATEPART(year, GETDATE())
	SELECT * FROM dbo.Orders_by_months
	WHERE Month = @month and Year = @year
ELSE RETURN -1
GO


CREATE OR ALTER PROCEDURE Add_book
@name nvarchar(30), @author nvarchar(30), @year INT, @country nvarchar(30)
AS
IF @year between 2020 and DATEPART(year, GETDATE()) and LEN(@name) >= 3 and LEN(@author) >= 3 and LEN(@country) >= 2
		and NOT EXISTS (SELECT book_name FROM dbo.Books WHERE book_name = @name and author = @author)
	INSERT INTO dbo.Books VALUES
		(@name, @author, @year, @country)
ELSE RETURN -1
GO


CREATE OR ALTER PROCEDURE Add_supply
@idSupplier INT, @idWarehouse INT, @bookList BooksInSupplyList READONLY
AS
IF EXISTS (SELECT * FROM dbo.Suppliers WHERE id_supplier = @idSupplier) and 
		EXISTS (SELECT * FROM dbo.Warehouses WHERE id_warehouse = @idWarehouse)
	BEGIN

	DECLARE @date DATE = GETDATE()
	DECLARE @idBook INT, @quant INT, @bookPrice INT, @idSupply INT

	INSERT INTO dbo.Supplies VALUES
	(@idSupplier, @idWarehouse, @date)

	SET @idSupply = (SELECT TOP(1) id_supply from dbo.Supplies where id_supplier = @idSupplier and id_warehouse = @idWarehouse and date_of_delivery = @date)
	DECLARE cur CURSOR FOR 
		SELECT id_book, quantity, book_price FROM @bookList
	OPEN cur
	FETCH NEXT FROM cur INTO @idBook, @quant, @bookPrice
	
	WHILE @@FETCH_STATUS = 0
		BEGIN
		INSERT INTO dbo.Books_in_supply VALUES
		(@idSupply, @idBook, @quant, @bookPrice)
		FETCH NEXT FROM cur INTO @idBook, @quant, @bookPrice
		END
	CLOSE cur
	DEALLOCATE cur
	END
ELSE
RETURN -1
GO


CREATE TYPE dbo.BooksInOrderList AS TABLE
	(id_book INT, quantity INT, id_supply INT)
GO

CREATE OR ALTER PROCEDURE Create_order
@idCust INT, @idWarehouse INT, @bookList BooksInOrderList READONLY
AS
DECLARE @date DATETIME = GETDATE()
DECLARE @orderCost INT
SELECT @orderCost = SUM(lst.quantity * bis.book_price) FROM @bookList lst 
		INNER JOIN dbo.Books_in_supply bis 
		ON lst.id_book = bis.id_book and lst.id_supply = bis.id_supply

INSERT INTO dbo.Orders VALUES
(@date, @orderCost, @idCust, @idWarehouse, GETDATE())

DECLARE @idOrder INT = (SELECT TOP(1) id_order FROM dbo.Orders WHERE date_of_order = @date)

DECLARE cur CURSOR FOR
	SELECT id_book, quantity, id_supply FROM @bookList
OPEN cur

DECLARE @idBook INT, @quant INT, @idSupply INT
FETCH NEXT FROM cur INTO @idBook, @quant, @idSupply

WHILE @@FETCH_STATUS = 0
BEGIN
	IF @quant <= (SELECT TOP(1) quantity_in_stock FROM dbo.Books_at_warehouse WHERE id_book = @idBook and 
			id_warehouse = (SELECT TOP(1) id_warehouse FROM dbo.Supplies WHERE id_supply = @idSupply))
		BEGIN
		INSERT INTO dbo.Books_in_order VALUES
		(@idOrder, @idBook, @quant, @idSupply)

		UPDATE dbo.Books_at_warehouse SET
		quantity_in_stock = quantity_in_stock - @quant
		WHERE id_warehouse = (SELECT TOP(1) id_warehouse FROM dbo.Supplies WHERE id_supply = @idSupply)
		and id_book = @idBook

		FETCH NEXT FROM cur INTO @idBook, @quant, @idSupply
		END
	ELSE
		BEGIN
		DECLARE cancel_cur CURSOR FOR
			SELECT id_book, quantity_in_order, id_supply FROM dbo.Books_in_order
			WHERE id_order = @idOrder
		OPEN cancel_cur
		FETCH NEXT FROM cancel_cur INTO @idBook, @quant, @idSupply

		WHILE @@FETCH_STATUS = 0
		BEGIN
			UPDATE dbo.Books_at_warehouse SET
			quantity_in_stock = quantity_in_stock + @quant
			WHERE id_warehouse = (SELECT TOP(1) id_warehouse FROM dbo.Supplies WHERE id_supply = @idSupply)
			and id_book = @idBook

			FETCH NEXT FROM cancel_cur INTO @idBook, @quant, @idSupply
		END
		CLOSE cancel_cur
		DEALLOCATE cancel_cur

		DELETE FROM dbo.Books_in_order
		WHERE id_order = @idOrder

		DELETE FROM dbo.Orders
		WHERE id_order = @idOrder

		CLOSE cur
		DEALLOCATE cur
		RETURN -1
		END
END
CLOSE cur
DEALLOCATE cur
