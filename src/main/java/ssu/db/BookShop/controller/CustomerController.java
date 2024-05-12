package ssu.db.BookShop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ssu.db.BookShop.dto.CustomerDTO;
import ssu.db.BookShop.service.CustomerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Secured("ROLE_ADMIN")
    @GetMapping("/getAll")
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/create")
    public void createCustomer(@RequestBody CustomerDTO customer) {
        customerService.createCustomer(customer);
    }
}
