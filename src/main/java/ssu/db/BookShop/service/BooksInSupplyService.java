package ssu.db.BookShop.service;

import ssu.db.BookShop.dto.BooksInSupplyDTO;

import java.util.List;

public interface BooksInSupplyService {

    List<BooksInSupplyDTO> getAllBooksInSupply();

    void createBooksInSupply(BooksInSupplyDTO booksInSupplyDTO);
}
