package ssu.db.BookShop.service;

import ssu.db.BookShop.dto.BooksAtWarehouseDTO;

import java.util.List;

public interface BooksAtWarehouseService {

    List<BooksAtWarehouseDTO> getAllBooksAtWarehouse();

    void createBooksAtWarehouse(BooksAtWarehouseDTO booksAtWarehouseDTO);
}
