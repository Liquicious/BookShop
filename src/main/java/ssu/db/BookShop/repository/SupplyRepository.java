package ssu.db.BookShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssu.db.BookShop.entity.Supply;

public interface SupplyRepository extends JpaRepository<Supply, Integer> {
}
