package ssu.db.BookShop.dto;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ssu.db.BookShop.entity.Warehouse;

@Mapper(componentModel = "spring",
        uses = {BooksAtWarehouseMapper.class, StaffMapper.class},
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface WarehouseMapper {

    Warehouse warehouseDTOToWarehouse(WarehouseDTO warehouseDTO);
    WarehouseDTO warehouseToWarehouseDTO(Warehouse warehouse);
}
