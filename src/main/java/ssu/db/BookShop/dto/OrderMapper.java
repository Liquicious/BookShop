package ssu.db.BookShop.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import ssu.db.BookShop.entity.BooksInSupplyId;
import ssu.db.BookShop.entity.Order;
import ssu.db.BookShop.service.CustomerService;
import ssu.db.BookShop.service.WarehouseService;

@Mapper(componentModel = "spring", imports = BooksInSupplyId.class)
public abstract class OrderMapper {

    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    WarehouseService warehouseService;
    @Autowired
    WarehouseMapper warehouseMapper;

    @Mapping(target = "idCustomer", expression = "java(customerMapper.customerDTOToCustomer(customerService.getCustomerById(orderDTO.getIdCustomer())))")
    @Mapping(target = "idWarehouse", expression = "java(warehouseMapper.warehouseDTOToWarehouse(warehouseService.getWarehouseById(orderDTO.getIdWarehouse())))")
    public abstract Order orderDTOToOrder(OrderDTO orderDTO);

    @Mapping(target = "idCustomer", expression = "java(order.getIdCustomer().getId())")
    @Mapping(target = "idWarehouse", expression = "java(order.getIdWarehouse().getId())")
    public abstract OrderDTO orderToOrderDTO(Order order);
}
