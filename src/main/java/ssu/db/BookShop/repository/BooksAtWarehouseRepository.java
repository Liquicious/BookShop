package ssu.db.BookShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssu.db.BookShop.entity.BooksAtWarehouse;
import ssu.db.BookShop.entity.BooksAtWarehouseId;

@Repository
public interface BooksAtWarehouseRepository extends JpaRepository<BooksAtWarehouse, BooksAtWarehouseId> {
}
