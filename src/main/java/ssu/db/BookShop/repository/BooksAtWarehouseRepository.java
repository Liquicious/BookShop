package ssu.db.BookShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssu.db.BookShop.entity.BooksAtWarehouse;
import ssu.db.BookShop.entity.BooksAtWarehouseId;

public interface BooksAtWarehouseRepository extends JpaRepository<BooksAtWarehouse, BooksAtWarehouseId> {
}
