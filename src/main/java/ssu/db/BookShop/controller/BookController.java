package ssu.db.BookShop.controller;

import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ssu.db.BookShop.dto.BookDTO;
import ssu.db.BookShop.service.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @PermitAll
    @GetMapping("/getAll")
    List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/create")
    void createBook(@RequestBody BookDTO book) {
        bookService.createBook(book);
    }
}
