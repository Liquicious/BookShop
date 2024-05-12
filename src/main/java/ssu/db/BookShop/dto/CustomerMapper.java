package ssu.db.BookShop.dto;

import org.mapstruct.Mapper;
import ssu.db.BookShop.entity.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer customerDTOToCustomer(CustomerDTO customerDTO);
    CustomerDTO customerToCustomerDTO(Customer customer);
}
