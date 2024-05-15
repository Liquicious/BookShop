package ssu.db.BookShop.dto;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ssu.db.BookShop.entity.Customer;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface CustomerMapper {

    Customer customerDTOToCustomer(CustomerDTO customerDTO);
    CustomerDTO customerToCustomerDTO(Customer customer);
}
