package ssu.db.BookShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssu.db.BookShop.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
