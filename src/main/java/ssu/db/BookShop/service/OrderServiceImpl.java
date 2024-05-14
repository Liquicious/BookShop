package ssu.db.BookShop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ssu.db.BookShop.dto.OrderDTO;
import ssu.db.BookShop.dto.OrderMapper;
import ssu.db.BookShop.entity.Order;
import ssu.db.BookShop.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;
    private OrderMapper orderMapper;

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> listOrder = orderRepository.findAll();
        List<OrderDTO> listOrderDTO = new ArrayList<>();
        for (Order order: listOrder) {
            listOrderDTO.add(orderMapper.orderToOrderDTO(order));
        }
        return listOrderDTO;
    }

    @Override
    public void createOrder(OrderDTO orderDTO) {
        Order order = orderMapper.orderDTOToOrder(orderDTO);
        orderRepository.save(order);
    }

    @Override
    public OrderDTO getOrderById(int id) {
        return orderMapper.orderToOrderDTO(orderRepository.findById(id).get());
    }
}
