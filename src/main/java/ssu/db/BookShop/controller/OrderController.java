package ssu.db.BookShop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ssu.db.BookShop.dto.OrderDTO;
import ssu.db.BookShop.service.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Secured("ROLE_ADMIN")
    @GetMapping("/getAll")
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/create")
    public void createOrder(@RequestBody OrderDTO order) {
        orderService.createOrder(order);
    }
}
