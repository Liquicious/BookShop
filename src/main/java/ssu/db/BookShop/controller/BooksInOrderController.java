package ssu.db.BookShop.controller;

import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ssu.db.BookShop.dto.BooksInOrderDTO;
import ssu.db.BookShop.service.BooksInOrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/booksInOrder")
public class BooksInOrderController {

    private final BooksInOrderService booksInOrderService;

    @PermitAll
    @GetMapping("/getAll")
    List<BooksInOrderDTO> getAllBooksInOrder() {
        return booksInOrderService.getAllBooksInOrder();
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/create")
    void createBooksInOrder(@RequestBody BooksInOrderDTO booksInOrderDTO) {
        booksInOrderService.createBooksInOrder(booksInOrderDTO);
    }
}