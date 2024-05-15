package ssu.db.BookShop.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ssu.db.BookShop.entity.Supply;

@Mapper(componentModel = "spring",
        uses = BooksInSupplyMapper.class,
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface SupplyMapper {

    @Mapping(target = "idSupplier.id", source = "idSupplier")
    @Mapping(target = "idWarehouse.id", source = "idWarehouse")
    Supply supplyDTOToSupply(SupplyDTO supplyDTO);

    @Mapping(target = "idSupplier", source = "supply.idSupplier.id")
    @Mapping(target = "idWarehouse", source = "supply.idWarehouse.id")
    SupplyDTO supplyToSupplyDTO(Supply supply);
}
