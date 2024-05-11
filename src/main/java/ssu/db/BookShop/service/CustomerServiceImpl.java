package ssu.db.BookShop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ssu.db.BookShop.entity.Customer;
import ssu.db.BookShop.repository.CustomerRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
