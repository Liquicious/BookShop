package ssu.db.BookShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssu.db.BookShop.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
}
