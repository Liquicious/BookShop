package ssu.db.BookShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssu.db.BookShop.entity.BooksInSupply;
import ssu.db.BookShop.entity.BooksInSupplyId;

@Repository
public interface BooksInSupplyRepository extends JpaRepository<BooksInSupply, BooksInSupplyId> {
}
