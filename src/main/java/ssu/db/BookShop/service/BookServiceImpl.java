package ssu.db.BookShop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ssu.db.BookShop.dto.BookDTO;
import ssu.db.BookShop.dto.BookMapper;
import ssu.db.BookShop.entity.Book;
import ssu.db.BookShop.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private BookMapper bookMapper;

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> bookList = bookRepository.findAll();
        List<BookDTO> bookDTOList = new ArrayList<>();
        for (Book book : bookList) {
            bookDTOList.add(bookMapper.bookToBookDTO(book));
        }
        return bookDTOList;
    }

    @Override
    public void createBook(BookDTO bookDTO) {
        Book book = bookMapper.bookDTOToBook(bookDTO);
        bookRepository.save(book);
    }
}
