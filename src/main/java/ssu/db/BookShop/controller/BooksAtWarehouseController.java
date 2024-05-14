package ssu.db.BookShop.controller;

import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ssu.db.BookShop.dto.BooksAtWarehouseDTO;
import ssu.db.BookShop.service.BooksAtWarehouseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/booksAtWarehouse")
public class BooksAtWarehouseController {

    private final BooksAtWarehouseService booksAtWarehouseService;

    @PermitAll
    @GetMapping("/getAll")
    List<BooksAtWarehouseDTO> getAllBooksAtWarehouse() {
        return booksAtWarehouseService.getAllBooksAtWarehouse();
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/create")
    void createBooksAtWarehouse(@RequestBody BooksAtWarehouseDTO booksAtWarehouseDTO) {
        booksAtWarehouseService.createBooksAtWarehouse(booksAtWarehouseDTO);
    }
}
