package ssu.db.BookShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssu.db.BookShop.entity.BooksInSupply;
import ssu.db.BookShop.entity.BooksInSupplyId;

public interface BooksInSupplyRepository extends JpaRepository<BooksInSupply, BooksInSupplyId> {
}
