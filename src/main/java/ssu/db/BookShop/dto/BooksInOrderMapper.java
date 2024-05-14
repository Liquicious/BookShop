package ssu.db.BookShop.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import ssu.db.BookShop.entity.BooksInOrder;
import ssu.db.BookShop.entity.BooksInOrderId;
import ssu.db.BookShop.service.BookService;
import ssu.db.BookShop.service.OrderService;
import ssu.db.BookShop.service.SupplyService;

@Mapper(componentModel = "spring", imports = BooksInOrderId.class)
public abstract class BooksInOrderMapper {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    BookService bookService;
    @Autowired
    BookMapper bookMapper;
    @Autowired
    SupplyService supplyService;
    @Autowired
    SupplyMapper supplyMapper;

    @Mapping(target = "id", expression = "java(new BooksInOrderId(booksInOrderDTO.getIdOrder(), booksInOrderDTO.getIdBook()))")
    @Mapping(target = "idOrder", expression = "java(orderMapper.orderDTOToOrder(orderService.getOrderById(booksInOrderDTO.getIdOrder())))")
    @Mapping(target = "idBook", expression = "java(bookMapper.bookDTOToBook(bookService.getBookById(booksInOrderDTO.getIdBook())))")
    @Mapping(target = "idSupply", expression = "java(supplyMapper.supplyDTOToSupply(supplyService.getSupplyById(booksInOrderDTO.getIdSupply())))")
    public abstract BooksInOrder booksInOrderDTOToBooksInOrder(BooksInOrderDTO booksInOrderDTO);

    @Mapping(target = "idOrder", expression = "java(booksInOrder.getIdOrder().getId())")
    @Mapping(target = "idBook", expression = "java(booksInOrder.getIdBook().getId())")
    @Mapping(target = "idSupply", expression = "java(booksInOrder.getIdSupply().getId())")
    public abstract BooksInOrderDTO booksInOrderToBooksInOrderDTO(BooksInOrder booksInOrder);
}