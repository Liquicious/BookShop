package ssu.db.BookShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssu.db.BookShop.entity.BooksAtWarehouse;
import ssu.db.BookShop.entity.BooksAtWarehouseId;
import ssu.db.BookShop.entity.Warehouse;

import java.util.List;

public interface BooksAtWarehouseRepository extends JpaRepository<BooksAtWarehouse, BooksAtWarehouseId> {
    List<BooksAtWarehouse> findBooksAtWarehouseByIdWarehouse(Warehouse idWarehouse);
}
