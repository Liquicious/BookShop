package ssu.db.BookShop.controller;

import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ssu.db.BookShop.entity.Book;
import ssu.db.BookShop.repository.BookRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    @PermitAll
    @GetMapping("/getBooks")
    List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @PermitAll
    @PostMapping("/addBook")
    void createBook(@RequestBody Book book) {
        bookRepository.save(book);
    }
}
