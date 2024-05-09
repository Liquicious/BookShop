package ssu.db.BookShop.controller;

import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ssu.db.BookShop.entity.BooksAtWarehouse;
import ssu.db.BookShop.entity.Warehouse;
import ssu.db.BookShop.repository.BooksAtWarehouseRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BooksAtWarehouseController {

    private final BooksAtWarehouseRepository booksAtWarehouseRepository;

    @PermitAll
    @GetMapping("/getBooksAtWarehouse")
    List<BooksAtWarehouse> getAllBooksAtWarehouse(Warehouse warehouse) {
        return booksAtWarehouseRepository.findBooksAtWarehouseByIdWarehouse(warehouse);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/addListOfBooksAtWarehouse")
    void addBooksAtWarehouse(@RequestBody List<BooksAtWarehouse> booksAtWarehouse) {
        booksAtWarehouseRepository.saveAll(booksAtWarehouse);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/addListOfBooksAtWarehouse")
    void addBookAtWarehouse(@RequestBody BooksAtWarehouse bookAtWarehouse) {
        booksAtWarehouseRepository.save(bookAtWarehouse);
    }
}
