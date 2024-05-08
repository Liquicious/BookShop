package ssu.db.BookShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssu.db.BookShop.entity.BooksInOrder;
import ssu.db.BookShop.entity.BooksInOrderId;

public interface BooksInOrderRepository extends JpaRepository<BooksInOrder, BooksInOrderId> {
}
