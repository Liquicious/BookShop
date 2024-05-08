package ssu.db.BookShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssu.db.BookShop.entity.Supplier;

public interface SupplierRepostiory extends JpaRepository<Supplier, Integer> {
}
