package ssu.db.BookShop.controller;

import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ssu.db.BookShop.dto.BooksInSupplyDTO;
import ssu.db.BookShop.service.BooksInSupplyService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/booksInSupply")
public class BooksInSupplyController {

    private final BooksInSupplyService booksInSupplyService;

    @PermitAll
    @GetMapping("/getAll")
    List<BooksInSupplyDTO> getAllBooksInSupply() {
        return booksInSupplyService.getAllBooksInSupply();
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/create")
    void createBooksInSupply(@RequestBody BooksInSupplyDTO booksInSupplyDTO) {
        booksInSupplyService.createBooksInSupply(booksInSupplyDTO);
    }
}
