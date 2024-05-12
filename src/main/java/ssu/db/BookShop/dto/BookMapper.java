package ssu.db.BookShop.dto;

import org.mapstruct.Mapper;
import ssu.db.BookShop.entity.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {

    Book bookDTOToBook(BookDTO bookDTO);
    BookDTO bookToBookDTO(Book book);
}
