package ssu.db.BookShop.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import ssu.db.BookShop.entity.BooksAtWarehouse;
import ssu.db.BookShop.service.BookService;
import ssu.db.BookShop.service.WarehouseService;
import ssu.db.BookShop.entity.BooksAtWarehouseId;

@Mapper(componentModel = "spring", imports = BooksAtWarehouseId.class)
public abstract class BooksAtWarehouseMapper {

    @Autowired
    WarehouseService warehouseService;
    @Autowired
    WarehouseMapper warehouseMapper;
    @Autowired
    BookService bookService;
    @Autowired
    BookMapper bookMapper;

    @Mapping(target = "id", expression = "java(new BooksAtWarehouseId(booksAtWarehouseDTO.getIdWarehouse(), booksAtWarehouseDTO.getIdBook()))")
    @Mapping(target = "idWarehouse", expression = "java(warehouseMapper.warehouseDTOToWarehouse(warehouseService.getWarehouseById(booksAtWarehouseDTO.getIdWarehouse())))")
    @Mapping(target = "idBook", expression = "java(bookMapper.bookDTOToBook(bookService.getBookById(booksAtWarehouseDTO.getIdBook())))")
    public abstract BooksAtWarehouse booksAtWarehouseDTOToBooksAtWarehouse(BooksAtWarehouseDTO booksAtWarehouseDTO);

    @Mapping(target = "idWarehouse", expression = "java(booksAtWarehouse.getIdWarehouse().getId())")
    @Mapping(target = "idBook", expression = "java(booksAtWarehouse.getIdBook().getId())")
    public abstract BooksAtWarehouseDTO booksAtWarehouseToBooksAtWarehouseDTO(BooksAtWarehouse booksAtWarehouse);
}
