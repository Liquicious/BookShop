package ssu.db.BookShop.dto;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import ssu.db.BookShop.entity.BooksInOrder;
import ssu.db.BookShop.entity.BooksInOrderId;
import ssu.db.BookShop.entity.BooksInSupplyId;
import ssu.db.BookShop.entity.Order;
import ssu.db.BookShop.service.CustomerService;
import ssu.db.BookShop.service.WarehouseService;

@Mapper(componentModel = "spring",
        imports = {BooksInOrderId.class},
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        unmappedSourcePolicy = ReportingPolicy.ERROR)
public abstract class OrderMapper {

    @Mapping(target = "idCustomer.id", source = "idCustomer")
    @Mapping(target = "idWarehouse.id", source = "idWarehouse")
    public abstract Order orderDTOToOrder(OrderDTO orderDTO);

    @Mapping(target = "idWarehouse", source = "order.idWarehouse.id")
    @Mapping(target = "idCustomer", source = "order.idCustomer.id")
    public abstract OrderDTO orderToOrderDTO(Order order);

    @Mapping(target = "id", expression = "java(new BooksInOrderId(booksInOrderDTO.getIdOrder(), booksInOrderDTO.getIdBook()))")
    @Mapping(target = "idOrder.id", source = "idOrder")
    @Mapping(target = "idBook.id", source = "idBook")
    @Mapping(target = "idSupply.id", source = "idSupply")
    public abstract BooksInOrder booksInOrderDTOToBooksInOrder(BooksInOrderDTO booksInOrderDTO);

    @BeanMapping(ignoreUnmappedSourceProperties = "id")
    @Mapping(target = "idBook", source = "booksInOrder.idBook.id")
    @Mapping(target = "idOrder", source = "booksInOrder.idOrder.id")
    @Mapping(target = "idSupply", source = "booksInOrder.idSupply.id")
    public abstract BooksInOrderDTO bookInOrderToBooksInOrderDTO(BooksInOrder booksInOrder);
}
