package ssu.db.BookShop.dto;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ssu.db.BookShop.entity.Supplier;

@Mapper(componentModel = "spring",
        uses = SupplyMapper.class,
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface SupplierMapper {

    Supplier supplierDTOToSupplier(SupplierDTO supplierDTO);
    SupplierDTO supplierToSupplierDTO(Supplier supplier);
}
