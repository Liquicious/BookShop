package ssu.db.BookShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssu.db.BookShop.entity.BooksInOrder;
import ssu.db.BookShop.entity.BooksInOrderId;

@Repository
public interface BooksInOrderRepository extends JpaRepository<BooksInOrder, BooksInOrderId> {
}
