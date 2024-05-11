package ssu.db.BookShop.service;

import ssu.db.BookShop.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    void createBook(Book book);
}
