package ssu.db.BookShop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ssu.db.BookShop.entity.Book;
import ssu.db.BookShop.repository.BookRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
    }
}
