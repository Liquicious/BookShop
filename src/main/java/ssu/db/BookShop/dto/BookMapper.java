package ssu.db.BookShop.dto;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ssu.db.BookShop.entity.Book;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface BookMapper {

    Book bookDTOToBook(BookDTO bookDTO);
    BookDTO bookToBookDTO(Book book);
}
