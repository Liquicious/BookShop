package ssu.db.BookShop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ssu.db.BookShop.dto.CustomerDTO;
import ssu.db.BookShop.dto.CustomerMapper;
import ssu.db.BookShop.entity.Customer;
import ssu.db.BookShop.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (Customer customer : customerList) {
            customerDTOList.add(customerMapper.customerToCustomerDTO(customer));
        }
        return customerDTOList;
    }

    @Override
    public void createCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        customerRepository.save(customer);
    }

    @Override
    public CustomerDTO getCustomerById(int id) {
        return customerMapper.customerToCustomerDTO(customerRepository.findById(id).get());
    }
}
