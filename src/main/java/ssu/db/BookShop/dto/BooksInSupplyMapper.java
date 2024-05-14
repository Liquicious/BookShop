package ssu.db.BookShop.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import ssu.db.BookShop.entity.BooksInSupply;
import ssu.db.BookShop.entity.BooksInSupplyId;
import ssu.db.BookShop.service.BookService;
import ssu.db.BookShop.service.SupplyService;

@Mapper(componentModel = "spring", imports = BooksInSupplyId.class)
public abstract class BooksInSupplyMapper {

    @Autowired
    SupplyService supplyService;
    @Autowired
    SupplyMapper supplyMapper;
    @Autowired
    BookService bookService;
    @Autowired
    BookMapper bookMapper;

    @Mapping(target = "id", expression = "java(new BooksInSupplyId(booksInSupplyDTO.getIdSupply(), booksInSupplyDTO.getIdBook()))")
    @Mapping(target = "idSupply", expression = "java(supplyMapper.supplyDTOToSupply(supplyService.getSupplyById(booksInSupplyDTO.getIdSupply())))")
    @Mapping(target = "idBook", expression = "java(bookMapper.bookDTOToBook(bookService.getBookById(booksInSupplyDTO.getIdBook())))")
    public abstract BooksInSupply booksInSupplyDTOToBooksInSupply(BooksInSupplyDTO booksInSupplyDTO);

    @Mapping(target = "idSupply", expression = "java(booksInSupply.getIdSupply().getId())")
    @Mapping(target = "idBook", expression = "java(booksInSupply.getIdBook().getId())")
    public abstract BooksInSupplyDTO booksInSupplyToBooksInSupplyDTO(BooksInSupply booksInSupply);
}
