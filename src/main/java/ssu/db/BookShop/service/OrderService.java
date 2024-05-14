package ssu.db.BookShop.service;

import ssu.db.BookShop.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> getAllOrders();

    void createOrder(OrderDTO orderDTO);

    OrderDTO getOrderById(int id);
}
