package ssu.db.BookShop.dto;

import org.mapstruct.Mapper;
import ssu.db.BookShop.entity.Supplier;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    Supplier supplierDTOToSupplier(SupplierDTO supplierDTO);
    SupplierDTO supplierToSupplierDTO(Supplier supplier);
}
