package ssu.db.BookShop.service;

import ssu.db.BookShop.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();

    void createCustomer(Customer customer);
}
