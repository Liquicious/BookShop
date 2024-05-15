package ssu.db.BookShop.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ssu.db.BookShop.entity.BooksInOrderId;
import ssu.db.BookShop.entity.Order;

@Mapper(componentModel = "spring",
        imports = {BooksInOrderId.class},
        uses = {BooksInOrderMapper.class},
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface OrderMapper {

    @Mapping(target = "idCustomer.id", source = "idCustomer")
    @Mapping(target = "idWarehouse.id", source = "idWarehouse")
    Order orderDTOToOrder(OrderDTO orderDTO);

    @Mapping(target = "idWarehouse", source = "order.idWarehouse.id")
    @Mapping(target = "idCustomer", source = "order.idCustomer.id")
    OrderDTO orderToOrderDTO(Order order);

}
