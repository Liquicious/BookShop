package ssu.db.BookShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssu.db.BookShop.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
