package ssu.db.BookShop.service;

import ssu.db.BookShop.dto.BookDTO;

import java.util.List;

public interface BookService {

    List<BookDTO> getAllBooks();

    void createBook(BookDTO book);
}
