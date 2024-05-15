package ssu.db.BookShop.dto;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ssu.db.BookShop.entity.BooksInOrder;
import ssu.db.BookShop.entity.BooksInOrderId;

@Mapper(componentModel = "spring",
        imports = BooksInOrderId.class,
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface BooksInOrderMapper {

    @Mapping(target = "id", expression = "java(new BooksInOrderId(booksInOrderDTO.getIdOrder(), booksInOrderDTO.getIdBook()))")
    @Mapping(target = "idOrder.id", source = "idOrder")
    @Mapping(target = "idBook.id", source = "idBook")
    @Mapping(target = "idSupply.id", source = "idSupply")
    BooksInOrder booksInOrderDTOToBooksInOrder(BooksInOrderDTO booksInOrderDTO);

    @BeanMapping(ignoreUnmappedSourceProperties = "id")
    @Mapping(target = "idOrder", source = "booksInOrder.idOrder.id")
    @Mapping(target = "idBook", source = "booksInOrder.idBook.id")
    @Mapping(target = "idSupply", source = "booksInOrder.idSupply.id")
    BooksInOrderDTO booksInOrderToBooksInOrderDTO(BooksInOrder booksInOrder);
}