package ssu.db.BookShop.service;

import ssu.db.BookShop.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    void createCustomer(CustomerDTO customer);
}
