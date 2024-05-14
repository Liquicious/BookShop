package ssu.db.BookShop.service;

import ssu.db.BookShop.dto.BooksInOrderDTO;

import java.util.List;

public interface BooksInOrderService {

    List<BooksInOrderDTO> getAllBooksInOrder();

    void createBooksInOrder(BooksInOrderDTO booksInOrderDTO);
}
